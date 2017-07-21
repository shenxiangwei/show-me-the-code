import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

public class mainFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			imageUtils.pressText("4", "C:/Users/Bryan/Desktop/u904.jpg", 
					"C:/Users/Bryan/Desktop/u904_text3.jpg", "宋体", Font.BOLD, Color.BLACK, 80,
					200, 0, 1);
			System.out.println("处理完成！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
