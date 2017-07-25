package problem;

public class mainFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//P001();
	}

	/*
	 * Problem 001
	 */
	public static void P001() {
		// 生成60位的随机数字和字母串
		String s1NumAndStr, s2Number;
		s1NumAndStr = problem001.randomString(60);
		//System.out.println(s1NumAndStr);
		// 生成20位的随机数字串
		s2Number = problem001.randomNumStr(20);
		//System.out.println(s2Number);
		String autoGenerCode[] = new String[200] ;

		//生成200激活码
		for(int i=0; i<200; i++){
			autoGenerCode[i] = problem001.randomString(60);
		}
		//输出激活码
		int i = 0;
		for(String str:autoGenerCode){
			i++;
			System.out.println("激活码"+i+":"+str);
		}
	}
	/*
	 * Problem 002
	 */
	public static void P002(){
		
	}

}
