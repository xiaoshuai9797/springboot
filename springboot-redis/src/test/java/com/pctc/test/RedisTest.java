package com.pctc.test;

import com.pctc.App;
import com.pctc.redis.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= App.class)
public class RedisTest {
	
	@Autowired
	RedisService redisService;
	
	@Test
	public void redisTestSet(){	
		System.out.println(redisService.set("redis_001", "springboot-redis1"));
		System.out.println("整合springboot 与junit结束");
	 }
	
	
	
	@Test
	public void redisTestGet(){	
		System.out.println(redisService.get("redis_001"));
		System.out.println("整合springboot 与junit结束");
	 }
	
	
}
