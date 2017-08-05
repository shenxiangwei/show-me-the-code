package problem;

import redis.clients.jedis.Jedis;

/** 
* @author shenxiangwei 
* @date 2017年8月5日 下午4:10:32 
* @parameter  
* @since  
* @return  
*/
public final class problem003 {
	
	static final Jedis jedis = new Jedis("127.0.0.1",6379);
	
	public void setValue(String key,String value){
	
		jedis.set(key, value);
	}
	public String getValue(String key){
		return jedis.get(key);
	}

}
