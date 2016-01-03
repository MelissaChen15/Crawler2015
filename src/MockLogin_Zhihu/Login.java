package MockLogin_Zhihu;
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
    private static String userName = "1391816228@163.com";  
    private static String password = "720312xy";  
//    private static String redirectURL = "http://blog.renren.com/blog/304317577/449470467";  
  
    // Don't change the following URL  
    private static String LoginURL = "https://www.zhihu.com/#signin";  
  
    // The HttpClient is used in one session  
    private HttpResponse response;  
    private DefaultHttpClient httpclient = new DefaultHttpClient();  
  
    private boolean login() {  
        HttpPost httpost = new HttpPost(LoginURL);  
        // All the parameters post to the web site  
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();  
        nvps.add(new BasicNameValuePair("_xsrf", "4c1e26b705608a1cdfc123198e25d9ba"));  
        nvps.add(new BasicNameValuePair("email", userName));  
        nvps.add(new BasicNameValuePair("password", password));  
        nvps.add(new BasicNameValuePair("remember_me", "true"));  

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
        if (locationHeader == null) {  
            return null;  
        }  
        return locationHeader.getValue();  
    }  
  
    private String getText(String redirectLocation) {  
        HttpGet httpget = new HttpGet(redirectLocation);  
        // Create a response handler  
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
  
    public void printText() {  
        if (login()) {  
            String redirectLocation = getRedirectLocation();  
            if(redirectLocation == null)
            	redirectLocation = "https://www.zhihu.com/people/chen-mei-ying-72";
            if (redirectLocation != null) {  
                System.out.println(getText(redirectLocation));  
            }  
        }  
    }  
  
    public static void main(String[] args) {  
        Login renRen = new Login();  
        renRen.printText();  
    }  
}  
  

