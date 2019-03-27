package com.ziggy.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//用户领取的优惠券
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pass {
    //用户Id
    private Long userId;

    //pass在Hbase中的rowKey
    private String rowKey;

    //PassTemplate在Hbase中的rowKey
    private String templateId;

    //优惠券token,有可能给是Null,则填充-1
    private String token;

    //领取日期
    private Date assginedDate;

    //消费 日期，不为空表示已经被消费了
    private Date conDate;

}
