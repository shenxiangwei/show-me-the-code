package problem;

import java.io.IOException;

import org.junit.Test;

public class mainFunction {

	public static void main(String[] args) throws IOException {
		
		/*
		 * 第一个问题
		 */
		//P001();
		
		
		/*
		 * 第二个问题
		 */
//		try {
//			P002();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		/*
		 * 第三个问题
		 */
		//P003();
		
		/*
		 * 第四个问题
		 */
		String result;
		String [] words;
		result = problem004.readTxtFile("C://Users//Bryan//Desktop//test.txt");
//		for (byte value : buf){
			System.out.println("单词个数为:"+result.split(" ").length);
			System.out.println("单词为：");
			words = result.split(" ");
			for(String value:words)
			System.out.println(value);
			
//		}
	}

	/*
	 * Problem 001
	 */
	public static String[] P001() {
		// 生成60位的随机数字和字母串
//		String s1NumAndStr, s2Number;
//		s1NumAndStr = problem001.randomString(60);
//		//System.out.println(s1NumAndStr);
//		// 生成20位的随机数字串
//		s2Number = problem001.randomNumStr(20);
//		//System.out.println(s2Number);
		String autoGenerCode[] = new String[10] ;

		//生成200激活码
		for(int i=0; i<10; i++){
			autoGenerCode[i] = problem001.randomString(60);
		}
		//输出激活码
		int i = 0;
		for(String str:autoGenerCode){
			i++;
			System.out.println("这是随机生成的激活码（不是数据库里存入的值）：");
			System.out.println("激活码"+i+":"+str);
		}
		return autoGenerCode;
	}
	/*
	 * Problem 002
	 */
	public static void P002() throws Exception{
		String[] str = P001();
		for(int i = 0;i<str.length;i++)
		problem002.insert(str[i]);
	}
	
	/**
	 * Problem 003
	 */
	public static void P003(){
		String[] str = P001();
		problem003 p0003 = new problem003();
		String key = "";
//		for(int i = 0; i < str.length; i++){
//			key = key + i;
//			p0003.setValue(key, str[i]);
//			key = null;
//		}
		for(int j=0;j<str.length;j++){
			key= key +j;
			System.out.println("redis存入的值"+p0003.getValue(key));
			key = null;
		}
	}

}
