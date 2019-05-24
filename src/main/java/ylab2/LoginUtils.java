package ylab2;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import ylab2.model.Data;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class LoginUtils {
        private static DefaultHttpClient httpClient;

        public static CookieStore doLoginPost(Data data) {
            //第一次请求，获取cookie
            httpClient = HttpClientFactory.getInstance();
            HttpPost loginPost = new HttpPost(PathConst.LOGIN_URL);

            List<NameValuePair> urlParameters = new ArrayList<>();
            String username = (data.getUsername().isEmpty() ? "2667296769@qq.com" : data.getUsername().trim());
            String password = (data.getPassword().isEmpty() ? "liuguan456" : data.getPassword().trim());
            urlParameters.add(new BasicNameValuePair("username", username));
            urlParameters.add(new BasicNameValuePair("password", password));
            urlParameters.add(new BasicNameValuePair("rememberMe", "true"));
            HttpEntity postParams = null;
            try {
                postParams = new UrlEncodedFormEntity(urlParameters, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            loginPost.setEntity(postParams);
            HttpResponse loginResponse = null;
            try {
                loginResponse = httpClient.execute(loginPost);
            } catch (IOException e) {
                e.printStackTrace();
            }

            Header[] headers = loginResponse.getHeaders("Set-Cookie");
            for (Header header : headers) {
                System.out.println(header.getValue());
            }
            CookieStore cookieStore = httpClient.getCookieStore();

            return cookieStore;

        }

}
