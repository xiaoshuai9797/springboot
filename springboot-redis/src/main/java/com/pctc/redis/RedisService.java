package com.pctc.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Component
public final class RedisService {

	@Autowired
	ShardedJedisPool shardedJedisPool;

	/**
	 * 
     * string缓存赋值
     * @param key 键
     * @return 值
	 */
	public boolean set(String key, String value) {
		try {
			ShardedJedis shardedJedis = shardedJedisPool.getResource();
			shardedJedis.set(key, value);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	
	
	/**
     * string缓存获取
     * @param key 键
     * @return 值
     */
    public Object get(String key) {
    	ShardedJedis shardedJedis = shardedJedisPool.getResource();
        return key == null ? null : shardedJedis.get(key);
    }

}