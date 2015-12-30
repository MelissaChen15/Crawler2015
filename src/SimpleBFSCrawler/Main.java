package SimpleBFSCrawler;

public class Main {

	public static void main(String[]args){
		Crawler crawler = new Crawler();
		
		long start =  System.currentTimeMillis();
		String[] source = new String[1200];
		for(int i = 1; i < 1196; i++)
			source[i] = "http://zpjob.acabridge.cn/www/career/lists/" + i;
		crawler.crawling(source);
		long end =  System.currentTimeMillis();
		System.out.println("time:"+(end-start));
	}
}

