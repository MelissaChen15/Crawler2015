package SimpleBFSCrawler;

import java.util.HashSet;

import java.util.PriorityQueue;
import java.util.Set;
import java.util.Queue;
public class LinkQueue {
	
	//已访问
	private static Set<String> visitedUrl = new HashSet<String>();
	
	//未访问
	private static Queue<String> unVisitedUrl = new PriorityQueue<String>();
	
	//获得url队列
	public static Queue<String> getUnVisitedUrl() {
		return unVisitedUrl;
	}
	
	//添加到已访问
	public static void addVisitedUrl(String url) {
		visitedUrl.add(url);
	}
	
	//移除已访问
	public static void removeVisitedUrl(String url) {
		visitedUrl.remove(url);
	}
	
	//未访问url出队列
	public static Object unVisitedUrlDeQueue() {
		return unVisitedUrl.poll();
	}

	//保证每个url访问一次
	public static void addUnvisitedUrl(String url) {
		if (url != null && !url.trim().equals("")
				&& !visitedUrl.contains(url)
				&& !unVisitedUrl.contains(url))
			unVisitedUrl.add(url);
	}
	
	//获得已访问url数目
	public static int getVisitedUrlNum() {
		return visitedUrl.size();
	}
	
	//判断未访问是否为空
	public static boolean unVisitedUrlsEmpty() {
		return unVisitedUrl.isEmpty();
	}

}
