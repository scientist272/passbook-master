package com.ziggy.passbook.merchants;

import com.alibaba.fastjson.JSON;
import com.ziggy.passbook.merchants.service.IMerchantsServ;
import com.ziggy.passbook.merchants.vo.CreateMerchantsRequest;
import com.ziggy.passbook.merchants.vo.PassTemplate;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

//商户服务测试类
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MerchantsApplicationTests {

	@Autowired
	private IMerchantsServ merchantsServ;


	/*
	{"data":{"id":17},"errorCode":0,"errorMsg":""}

	{"data":{"id":18},"errorCode":0,"errorMsg":""}
	 */
	@Test
	//@Transactional
	public void testCreateMerchantsServ() {
		CreateMerchantsRequest request = new CreateMerchantsRequest();
		request.setName("慕课");
		request.setLogoUrl("www.imooc.com");
		request.setBusinessLicenseUrl("www.imooc.com");
		request.setPhone("1234567890");
		request.setAddress("北京市");

		System.out.println(JSON.toJSONString(merchantsServ.createMerchants(request)));
	}

	/*
	{"data":{"address":"北京市","businessLicenseUrl":"www.imooc.com",
	"id":20,"isAudit":false,"logoUrl":"www.imooc.com","name":"慕课",
	"phone":"1234567890"},"errorCode":0,"errorMsg":""}

	 */
	@Test
	public void testBuildMerchantsInfoById(){
		System.out.println(JSON.toJSONString(merchantsServ.buildMerchantsInfoById(17)));
	}

	/*
	DropPassTemplate: {"backGround":2,"desc":"详情: 慕课",
	"end":1551508789225,"hasToken":false,"id":20,"limit":10000,
	"start":1550644789225,"summary":"简介: 慕课","title":"title: 慕课"}
	 */
	@Test
	public void testDropPassTemplate(){
		PassTemplate passTemplate = new PassTemplate();
		passTemplate.setId(18);
		passTemplate.setTitle("title: 3");
		passTemplate.setSummary("简介: 慕课");
		passTemplate.setDesc("详情: 慕课");
		passTemplate.setLimit(10000L);
		passTemplate.setHasToken(true);
		passTemplate.setBackground(2);
		passTemplate.setStart(DateUtils.addDays(new Date(), -20));
		passTemplate.setEnd(DateUtils.addDays(new Date(), 20));

		System.out.println(JSON.toJSONString(merchantsServ.dropPassTemplate(passTemplate)));
	}

}
