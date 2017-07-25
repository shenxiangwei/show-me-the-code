package problem;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

/**
 * @author shenxiangwei
 * @date 2017年7月25日 下午5:55:48
 * @parameter
 * @since
 * @return
 */
public class problem002 {
	// 将题目一的激活码保存到MySQL数据库
		public static void insert(String codeValue) throws Exception {
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/autocode","root","root");
	        
	        //注意下面几行★
	        String sql = "insert into AUTO_CODE(CODE_VALUE) values(?)"; //★
	        PreparedStatement sta = (PreparedStatement) con.prepareStatement(sql);
	        sta.setString(1,codeValue);
	        
	        int rows = sta.executeUpdate();
	        if(rows > 0) {
	            System.out.println("operate successfully!");
	        }
	        sta.close();
	        con.close();
	    }
}
