package SimpleBFSCrawler;


import java.util.Set;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Crawler {

	//使用种子初始化url队列
	private void initCrawlerWithSeeds(String[] seeds){
		for(int i=0;i<seeds.length;i++)
			LinkQueue.addUnvisitedUrl(seeds[i]);
	}	

	//定义filter
	public void crawling(String[] seeds){  
		LinkFilter filter = new LinkFilter(){
			public boolean accept(String url) {
//				if(url.startsWith("http://movie.douban.com/subject/"))
//					return true;
//				else
//					return false;
				//从一个片入手即可
				Pattern p2 = Pattern.compile("http://zpjob.acabridge.cn/www/career/view\\?cid=[0-9]+?&comid=[0-9]+?");
				Matcher m2 = p2.matcher(url);
				Pattern p = Pattern.compile("http://zpjob.acabridge.cn/www/company/view\\?comid=[0-9]+?");
				Matcher m = p.matcher(url);
				boolean find = false;
				if(m.matches() || m2.matches())
					find = true;
				return find;
			}
		};
		
		//获取合适的链接加入要爬的队列
		initCrawlerWithSeeds(seeds);
		while(!LinkQueue.unVisitedUrlsEmpty()&&LinkQueue.getVisitedUrlNum()<=50000){
			String visitUrl=(String)LinkQueue.unVisitedUrlDeQueue();
			if(visitUrl==null)
				continue;
			DownLoadFile downLoader=new DownLoadFile();
			downLoader.downloadFile(visitUrl);
			LinkQueue.addVisitedUrl(visitUrl);			
			Set<String> links=HtmlParserTool.extracLinks(visitUrl,filter);
			for(String link:links){
				LinkQueue.addUnvisitedUrl(link);
			}
		}
	}

}
