package MysqlText;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToMysql {

	public static void main(String[] args) throws Exception {
        Connection conn = null;
        String sql;
        String url = "jdbc:mysql://localhost:3306/InstallText?"
                + "user=root&password= &useUnicode=true&characterEncoding=UTF8";
        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            sql = "INSERT INTO `InstallText`.`Grade` (`id`, `name`, `grade`) VALUES ('14124705', 'eric', '99');";
            int result = stmt.executeUpdate(sql);
            System.out.print(result);
            sql = "select * from Grade";
            ResultSet rs = stmt.executeQuery(sql);// executeQuery会返回结果的集合，否则返回空值
             System.out.println("学号 姓名 成绩");
             while (rs.next()) {
                    System.out.println(rs.getString(1) + "\t" + rs.getString(2)+ "\t" + rs.getString(3));
             }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
 
    }
	
}
