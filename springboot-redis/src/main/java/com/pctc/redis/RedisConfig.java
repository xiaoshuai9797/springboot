package com.pctc.redis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

@Configuration
@PropertySource(value = "classpath:redis.properties")
public class RedisConfig {
	
	@Autowired
	private Environment env;
	
	
	
	@Bean //相当spring.xml文件<bean id=   class="" />
	@ConfigurationProperties(prefix = "spring.redis.pool")
	public JedisPoolConfig getJedisPoolConfig() {
		return new JedisPoolConfig();
	}
	
	
	

	@Bean
	public ShardedJedisPool getJedisPool() {
		try {
			List<JedisShardInfo> shardList = new ArrayList<JedisShardInfo>();
			int index = 1;
			while(true){
				//读取host
				String host = env.getProperty("spring.redis.shard."+index+".host");
				if(StringUtils.isEmpty(host)){
					break;
				}
				//读取port
				String port = env.getProperty("spring.redis.shard."+index+".port");
				JedisShardInfo info = new JedisShardInfo(host, Integer.valueOf(port), 0, "");
				//读取password
				String password = env.getProperty("spring.redis.shard."+index+".password");
				if(!StringUtils.isEmpty(password)){
					info.setPassword(password);
				}
				shardList.add(info);
				index++;
			}
			if(shardList.size() == 0){
				//无法加载redis
				throw new IOException();
			}
			return new ShardedJedisPool(getJedisPoolConfig(), shardList);
		} catch (Exception e) {
			throw new RuntimeException("无法加载资源文件!");
		}
	}

}