package Parser;

import java.util.ArrayList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;

public class InfoParser {

	public static void requireds(String content,ArrayList<Object> requireds
			) throws IOException{
		
		//标题
		String title = "";
		Pattern p1 = Pattern.compile(".+?<h1>(.+?)</h1>.+?");
		Matcher m1 = p1.matcher(content);
		Pattern pp1 = Pattern.compile("<div class=\"tit overhidden\">.+?<h2>(.+?)</h2>.+?");
		Matcher mm1 = pp1.matcher(content);
		if (m1.find()) {
			title += m1.group(1).trim();
		}
		//此处加副标题
		if(mm1.find()){
			Pattern p111 = Pattern.compile("-");
			String[] s = p111.split(mm1.group(1).trim());
			title += "_" + s[0];
		}
		requireds.add(title);
		
		//专业要求
		String  major = "";
		Pattern p2 = Pattern.compile(".+?专业要求：<span class=\"gary-font\">(.+?)</span>.+?");
		Matcher m2 = p2.matcher(content);
		if (m2.find()) {
			major =m2.group(1).trim();
		}
		requireds.add(major);
		
		//发布时间
		String publishTime = "";
		Pattern p3 = Pattern.compile(".+?发布时间：<span class=\"gary-font\">(.+?)</span>.+?");
		Matcher m3 = p3.matcher(content);
		if (m3.find()) {
			publishTime = m3.group(1).trim();
		}
		requireds.add(publishTime);
		
		//职位类型
		String jobType = "";
		Pattern p4 = Pattern.compile(".+?职位类型：<span class=\"gary-font\">(.+?)</span>.+?");
		Matcher m4 = p4.matcher(content);
		if (m4.find()) {
			jobType = m4.group(1).trim();
		}
		requireds.add(jobType);
		
		//年龄要求
		String  age = "";
		Pattern  p5 = Pattern.compile(".+?年龄要求：<span class=\"gary-font\">(.+?)</span>.+?");
		Matcher  m5= p5.matcher(content);
		if (m5.find()) {
			age = m5.group(1).trim();
		}
		requireds.add(age);
		
		//职称要求
		String  academicTitle = "";
		Pattern  p6= Pattern.compile(".+?职称要求：<span class=\"gary-font\">(.+?)</span>.+?");
		Matcher  m6= p6.matcher(content);
		if (m6.find()) {
			academicTitle= m6.group(1).trim();
		}
		requireds.add(academicTitle);
		
		//学历要求
		String  eduBackground = "";
		Pattern  p7= Pattern.compile(".+?学历要求：<span class=\"gary-font\">(.+?)</span>.+?");
		Matcher  m7= p7.matcher(content);
		if (m7.find()) {
			eduBackground= m7.group(1).trim();
		}
		requireds.add(eduBackground);
		
		//用人部门
		String department = "";
		Pattern p8 = Pattern.compile(".+?用人部门：<span class=\"gary-font\">(.+?)</span>.+?");
		Matcher m8 = p8.matcher(content);
		if (m8.find()) {
			department= m8.group(1).trim();
		}
		requireds.add(department);
		
		//工作经验
		String workBackground = "";
		Pattern p9 = Pattern.compile(".+?工作经验：<span class=\"gary-font\">(.+?)</span>.+?");
		Matcher m9 = p9.matcher(content);
		if (m9.find()) {
			workBackground = m9.group(1).trim();
		}
		requireds.add(workBackground);
		
		//招聘人数
		String nums = "";
		Pattern p10 = Pattern.compile(".+?招聘人数：<span class=\"gary-font\">(.+?)</span>.+?");
		Matcher m10 = p10.matcher(content);
		if (m10.find()) {
			nums = m10.group(1).trim();
		}
		requireds.add(nums);
		
		//工作性质
		String jobNature = "";
		Pattern p11 = Pattern.compile(".+?工作性质：<span class=\"gary-font\">(.+?)</span>.+?");
		Matcher m11 = p11.matcher(content);
		if (m11.find()) {
			jobNature = m11.group(1).trim();
		}
		requireds.add(jobNature);
		
		//应聘条件
		String condition = "";
		Pattern p12 = Pattern.compile(".+?应聘条件：<span class=\"gary-font\">(.+?)</span>.+?");
		Matcher m12 = p12.matcher(content);
		if (m12.find()) {
			condition = m12.group(1).trim();
		}
		requireds.add(condition);

		
//		//招聘程序 null的可能性很大
//		String  procedure= "";
//		Pattern  p13= Pattern.compile(".+?招聘程序.+?<p>(.+?)</p>.+?");
//		Matcher m13 = p13.matcher(content);
//		if (m13.find()) {
//			procedure = m13.group(1).trim();
//		}
//		requireds.add(procedure);
//		
//		//工作待遇 null的可能性很大
//		String  treatment = "";
//		Pattern p14 = Pattern.compile(".+?工作待遇.+?<p>(.+?)</p>.+?");
//		Matcher m14 = p14.matcher(content);
//		if (m14.find()) {
//			treatment = m14.group(1).trim();
//		}
//		requireds.add(treatment);
//		
		//应聘基本条件
		//null
		String  basicCondition = "";
//		Pattern p15 = Pattern.compile(".+?应聘办法.+?<p>(.+?)</p>.+?");
//		Matcher m15 = p15.matcher(content);
//		if (m15.find()) {
//			basicCondition = m15.group(1).trim();
//		}
		requireds.add(basicCondition);
		
		//内容
		String content1 ="";
		Pattern p16 = Pattern.compile(".+?应聘条件：.+?</table>(.+?)<div class=\"font-18 pad-l-10\">附加文档</div>.+?");
		Matcher m16 = p16.matcher(content);
		if (m16.find()) {
			content1 = m16.group(1).trim();
		}
		requireds.add(content1);
		
		
		//联系方式
		String  contextWay = "";
		Pattern p17 = Pattern.compile(".+?联系方式.+?<p>(.+?)</div>.+?");
		Matcher m17 = p17.matcher(content);
		if (m17.find()) {
			contextWay = m17.group(1).trim();
		}
		requireds.add(contextWay);
		
		
	}

}
