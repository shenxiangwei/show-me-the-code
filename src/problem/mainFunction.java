package problem;

public class mainFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//P001();
		try {
			P002();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Problem 001
	 */
	public static String[] P001() {
		// 生成60位的随机数字和字母串
		String s1NumAndStr, s2Number;
		s1NumAndStr = problem001.randomString(60);
		//System.out.println(s1NumAndStr);
		// 生成20位的随机数字串
		s2Number = problem001.randomNumStr(20);
		//System.out.println(s2Number);
		String autoGenerCode[] = new String[10] ;

		//生成200激活码
		for(int i=0; i<10; i++){
			autoGenerCode[i] = problem001.randomString(60);
		}
		//输出激活码
		int i = 0;
		for(String str:autoGenerCode){
			i++;
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

}
