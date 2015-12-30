package Parser;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Read {


	 public static void read(String filePath) throws IOException {


		 //读取文件
		File file = new File(filePath);
		String[] filelist = file.list();
		for (String fi:filelist) {
			ArrayList<Object> requireds = new ArrayList<Object>();
			File readfile = new File(filePath + "\\" + fi);

			if (!readfile.isDirectory()) {
				//逐行
				String content = "";
			    BufferedReader br = new BufferedReader(new InputStreamReader(  
			           new FileInputStream(filePath + "\\" + fi)));  
			    for (String line = br.readLine(); line != null; line = br.readLine()) {  
			        content += line;
			    }  
			    br.close(); 
			    
			    int  id = -1;
				Pattern p = Pattern.compile(".+?cid=(.+?)&comid=.+?");
				Matcher m = p.matcher(readfile.getName());
				if(m.find())
					id = Integer.parseInt(m.group(1));
				requireds.add(id);
			    
				
			    InfoParser.requireds(content, requireds);
			    for(Object obj:requireds){
			    	System.out.println("info:"+obj);
			    }
			    System.out.println("--------");
			    
//			    saveToSql(info,ranking);
			    }
		}
		}  
	 
	//写入数据库
		public static boolean saveToSql(ArrayList<String> info,ArrayList<String> ranking){
			String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String url = "jdbc:sqlserver://localhost:1433;DatabaseName=豆瓣电影";
			String user = "sa";
			String password = "720312xy";
			try{
				 Class.forName(driverName);
				 Connection conn = DriverManager.getConnection(url,user,password);
				 Statement stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				 String sql =  "SET NOCOUNT ON insert into 影片基本信息 values('"+info.get(0)+"','"+info.get(1)+"','"+info.get(2)+"','"+info.get(3)+"','"+info.get(4)+"','"+info.get(5)+"','"+info.get(6)+"','"+info.get(7)+"','"+info.get(8)+"','"+info.get(9)+"')";
//				 String sql =  "SET NOCOUNT ON insert into 影片基本信息 values('1','1','1','1','1','1','1','1','1','1','1','1')";
				 ResultSet rs = stat.executeQuery(sql);
			}
			catch(Exception e){
				   e.printStackTrace();
			}
			return true;
		}

}

