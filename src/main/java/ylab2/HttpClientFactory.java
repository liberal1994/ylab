package ylab2;

import org.apache.http.impl.client.DefaultHttpClient;


public class HttpClientFactory {

    private HttpClientFactory() {

    }

    public static DefaultHttpClient getInstance() {
        return InnerInstanceFactory.httpClient;
    }

    private static class InnerInstanceFactory {
        private static DefaultHttpClient httpClient = new DefaultHttpClient();
    }
}
