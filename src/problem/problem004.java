package problem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author shenxiangwei
 * @date 2017年8月7日 下午4:14:49
 * @parameter
 * @since
 * @return
 */
public class problem004 {

	public static String readTxtFile(String filePath) {

		try {

			String encoding = "GBK";

			File file = new File(filePath);

			if (file.isFile() && file.exists()) { // 判断文件是否存在

				InputStreamReader read = new InputStreamReader(

						new FileInputStream(file), encoding);// 考虑到编码格式

				BufferedReader bufferedReader = new BufferedReader(read);

				String lineTxt = null;
				
				String result = "";

				while ((lineTxt = bufferedReader.readLine()) != null) {

					result+= lineTxt;
					
					//System.out.println(lineTxt);
				}
				

				read.close();
				
				return result;

			} else {

				System.out.println("找不到指定的文件");

			}

		} catch (Exception e) {

			System.out.println("读取文件内容出错");

			e.printStackTrace();

		}
		return null;

	}

	//返回文件中每个字符组成的byte数组 (输出原字符需要强转char)
	 public static byte[] getContent(String filePath) throws IOException {  
	        File file = new File(filePath);  
	        long fileSize = file.length();  
	        if (fileSize > Integer.MAX_VALUE) {  
	            System.out.println("file too big...");  
	            return null;  
	        }  
	        FileInputStream fi = new FileInputStream(file);  
	        byte[] buffer = new byte[(int) fileSize];  
	        int offset = 0;  
	        int numRead = 0;  
	        while (offset < buffer.length  && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {  
	            offset += numRead;  
	        }  
	        fi.close();  
	        return buffer;  
	    }  
	
	public final static int countWordsNumber(File f) {

		return 0;
	}

}
