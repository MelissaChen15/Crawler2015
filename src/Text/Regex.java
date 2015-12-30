package Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Pattern p = Pattern.compile(".+?cid=(.+?)&comid=.+?");
//		Matcher m = p.matcher("zpjob.acabridge.cn_www_career_view_cid=1711&comid=2142.txt");
//		System.out.println(m.find());
//		System.out.println(m.group(1));
//		
//	    int  id = -1;
//		Pattern pp = Pattern.compile(".+?cid=(.+?)&comid=.+?");
//		Matcher mm = pp.matcher("zpjob.acabridge.cn_www_career_view_cid=1711&comid=2142.txt");
//		System.out.println(mm.find());
//		id = Integer.parseInt(mm.group(1));
//		System.out.println(id);
//		
		Pattern p = Pattern.compile("http://zpjob.acabridge.cn/www/company/view\\?comid=[0-9].+?");
		Matcher m = p.matcher("http://zpjob.acabridge.cn/www/company/view?comid=2072");
		System.out.println(m.find());
//		
//		int  id = -1;
//		Pattern p = Pattern.compile(".+?cid=(.+?)&comid=.+?");
//		Matcher m = p.matcher("zpjob.acabridge.cn_www_career_view_cid=10000&comid=2799.txt");
//		System.out.println(m.find());
//		id = Integer.parseInt(m.group(1));
//		System.out.println(id);
		
	}

}
