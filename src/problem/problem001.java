package problem;

import java.util.Random;

/**
 * @author Bryan
 *
 */
public class problem001 {
	//Auto Generated Activation Code

	private static Random strGen = new Random();  
	private static Random numGen = new Random();  
	private static char[] numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();  
	private static char[] numbers = ("0123456789").toCharArray();  
	 
	
	/**
	 * @param length 生成随机字符串的长度
	 * @return 返回随机生成的字符串
	 */
	public static final String randomString(int length) {  
	 if (length < 1) {  
	  return null;  
	 }  
	 char[] randBuffer = new char[length];  
	 for (int i = 0; i < randBuffer.length; i++) {  
	  randBuffer[i] = numbersAndLetters[strGen.nextInt(62)];  
	 }
	 return new String(randBuffer);  
	}  
	  
	 
	/**
	 * @param length 生成随机数字串的长度
	 * @return 返回生成的数字串
	 */
	public static final String randomNumStr(int length) {  
	 if (length < 1) {  
	  return null;  
	 }  
	 char[] randBuffer = new char[length];  
	 for (int i = 0; i < randBuffer.length; i++) {  
	  randBuffer[i] = numbers[numGen.nextInt(10)];  
	 }  
	 return new String(randBuffer);  
	}  
}
