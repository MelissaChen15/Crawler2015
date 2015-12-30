package SimpleBFSCrawler;

import java.io.DataOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class DownLoadFile {
	
	//url和网站类型生成文件名，并去掉非法字符
	public  String getFileNameByUrl(String url,String contentType){
		//http:// (7)
		url=url.substring(7);
		//text/html?
		if(contentType.indexOf("html")!=-1){
			url= url.replaceAll("[\\?/:*|<>\"]", "_")+".txt";
			return url;
		}
		//application/pdf?
		else{
          return url.replaceAll("[\\?/:*|<>\"]", "_")+"."+
          contentType.substring(contentType.lastIndexOf("/")+1);
		}	
	}

	//保存到本地
	private void saveToLocal(byte[] data, String filePath){
		try{
			DataOutputStream out = new DataOutputStream(new FileOutputStream(
					new File(filePath)));
			for (int i = 0; i < data.length; i++)
				out.write(data[i]);
			out.flush();
			out.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}

	//下载url指向的网页
	public String downloadFile(String url){
		String filePath = null;
		//1.HttpClient对象，设置参数
		HttpClient httpClient = new HttpClient();
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(
				5000);//请求超时5s
		//2.Get对象，设置参数		
		GetMethod getMethod = new GetMethod(url);
		getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);//请求超时5s
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());

		//3.执行get
		try{
			int statusCode = httpClient.executeMethod(getMethod);
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: "
						+ getMethod.getStatusLine());
				filePath = null;
			}

			//4.处理响应
			byte[] responseBody = getMethod.getResponseBody();
			filePath = "/home/melissa/acabridge2/"
					+ getFileNameByUrl(url, getMethod.getResponseHeader(
							"Content-Type").getValue());
			saveToLocal(responseBody, filePath);
		} 
		catch(HttpException e){
			System.out.println("Please check your provided http address!");
			e.printStackTrace();
		} 
		catch(IOException e){
			e.printStackTrace();
		} 
		finally{
			getMethod.releaseConnection();
		}
		return filePath;
	}
}
