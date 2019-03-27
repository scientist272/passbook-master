package com.ziggy.passbook;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PassbookApplicationTests {

	@Autowired
	private StringRedisTemplate redisTemplate;

	@Test
	public void testRedisTemplate() {

		log.info("redis connection:{}",redisTemplate.getConnectionFactory());
		// redis flush all
		redisTemplate.execute((RedisCallback<Object>) connection->{
			connection.flushAll();
			return null;
				}
		);
//
//		assert redisTemplate.opsForValue().get("name") == null;
//
//		redisTemplate.opsForValue().set("name","ziggy");
//		assert redisTemplate.opsForValue().get("name") != null;
//		System.out.println(redisTemplate.opsForValue().get("name"));

	}

}
