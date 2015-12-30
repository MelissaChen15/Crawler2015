package MockLogin_Douban;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class Login {  
    // The configuration items  
    private static String userName = "13918162228@163.com";  
    private static String password = "720312xy";  
//    private static String redirectURL = "http://www.douban.com/people/138761300/";  
  
    private static String LoginURL = "http://www.douban.com/accounts/login?source=movie";  
  
    // 在同一个会话中使用cookies
    private HttpResponse response;  
    private DefaultHttpClient httpclient = new DefaultHttpClient();  
  
	private  boolean login() {  
        HttpPost httpost = new HttpPost(LoginURL);  
        //post参数设置
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();  
 //source=movie&redir=http%3A%2F%2Fwww.douban.com&form_email=13918162228%40163.com&form_password=720312xy&login=%E7%99%BB%E5%BD%95
        nvps.add(new BasicNameValuePair("source", "movie"));  
        nvps.add(new BasicNameValuePair("redir", "http%3A%2F%2Fwww.douban.com"));  
        nvps.add(new BasicNameValuePair("form_email", userName));  
        nvps.add(new BasicNameValuePair("form_password", password));  
        nvps.add(new BasicNameValuePair("login", "%E7%99%BB%E5%BD%95"));  
        try {  
            httpost.setEntity(new UrlEncodedFormEntity(nvps));  
            response = httpclient.execute(httpost);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        } finally {  
            httpost.abort();  
        }  
        return true;  
    }  
  
    private String getRedirectLocation() {  
        Header locationHeader = response.getFirstHeader("Location");  
        System.out.println(response.getFirstHeader("Location"));
        if (locationHeader == null) {  
            return null;  
        }  
        return locationHeader.getValue();  
    }  
  
    private String getText(String redirectLocation) {  
        HttpGet httpget = new HttpGet(redirectLocation);  
        ResponseHandler<String> responseHandler = new BasicResponseHandler();  
        String responseBody = "";  
        try {  
            responseBody = httpclient.execute(httpget, responseHandler);  
        } catch (Exception e) {  
            e.printStackTrace();  
            responseBody = null;  
        } finally {  
            httpget.abort();  
            httpclient.getConnectionManager().shutdown();  
        }  
        return responseBody;  
    }  
  
    public void save(String filePath ) {  
        if (login()) {  
            String redirectLocation = getRedirectLocation();  
            if (redirectLocation != null) {  
//                System.out.println(getText(redirectLocation));  
            	try{
            			DataOutputStream out = new DataOutputStream(new FileOutputStream(
            					new File(filePath)));
            			for (int i = 0; i < getText(redirectLocation).getBytes().length; i++)
            				out.write(getText(redirectLocation).getBytes()[i]);
            				out.flush();
            				out.close();
            		}
            		catch (IOException e){
            			e.printStackTrace();
            		}
            	}
            }  
        }  
}  













