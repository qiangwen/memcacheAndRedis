package com.jrj.redis;

import redis.clients.jedis.Jedis;

public class RedisManager {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.set("name", "wenqiang");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(jedis.get("name"));
	}
}
