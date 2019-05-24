package ylab2;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import ylab2.model.Data;
import ylab2.model.MachineEnum;

import java.io.*;
import java.util.*;

public class HttpClientUtil {

    public static void sendPOST(CookieStore cookieStore, Data data) throws IOException {

        String machineId = MachineEnum.getCodeByName(data.getInstrumentId());
        if (machineId == null || machineId.length() == 0) {
            return;
        }

        DefaultHttpClient httpClient = new DefaultHttpClient(new PoolingClientConnectionManager());
        httpClient.setCookieStore(cookieStore);

        HttpPost httpPost = new HttpPost(PathConst.POST_URL);
        httpPost.setHeader("Host", "cem.ylab.cn");
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
        httpPost.setHeader("Charset", "UTF-8");

        List<BasicNameValuePair> urlParameters = new ArrayList<>();


        urlParameters.add(new BasicNameValuePair("currentDate", data.getCurrentDate()));
        urlParameters.add(new BasicNameValuePair("reserveDate", data.getReserveDate()));
        urlParameters.add(new BasicNameValuePair("instrumentId", machineId));
        urlParameters.add(new BasicNameValuePair("reserveStartTime", data.getReserveStartTime()));
        urlParameters.add(new BasicNameValuePair("reserveEndTime", data.getReserveEndTime()));
        urlParameters.add(new BasicNameValuePair("ReserveReport", data.getReserveReport()));

        urlParameters.add(new BasicNameValuePair("hideRest", "1"));

        UrlEncodedFormEntity postParams = new UrlEncodedFormEntity(urlParameters, HTTP.UTF_8);
        httpPost.setEntity(postParams);

        HttpResponse httpResponse = httpClient.execute(httpPost);


        System.out.println("POST Response Status:: "
                + httpResponse.getStatusLine().getStatusCode());

    }


}
