package com.jrj.memecache;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

public class MemcacheTest {

	protected static MemCachedClient mc = new MemCachedClient();
	
	protected static MemcacheTest mt = new MemcacheTest();
	
	static{
		//服务器列表
		String[] servers = {"127.0.0.1:11211"};
		//权重
		Integer[] weights = {3};
		SockIOPool sock = SockIOPool.getInstance();
		sock.setServers(servers);
		sock.setWeights(weights);
		
		//设置一些初始化参数
		//设置连接数
		sock.setInitConn(3);
		sock.setMinConn(3);
		sock.setMaxConn(20);
		sock.setMaxIdle(1000*60*60*6);
		//设置主线程的睡眠时间
		sock.setMaintSleep(30);
		//设置tcp的参数，连接超时等
		sock.setNagle(false);
		sock.setSocketTO(3000);
		sock.setSocketConnectTO(0);
		//初始化连接池
		sock.initialize();
		//压缩设置
		//mc.setCompressEnable(true);
		//mc.setCompressThreshold(64*1024);
	}
	
	private MemcacheTest(){
		
	}
	public static MemcacheTest getInstance(){
		return mt;
	}
	public static boolean add(String key,Object value){
		
		return mc.add(key, value);
	}
	
	public static void main(String[] args) {
		MemcacheTest mt = MemcacheTest.getInstance();
		mt.add("name", "wenqiang");
	}
}
