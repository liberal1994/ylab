package ylab2;

import ylab2.model.Data;


import org.apache.http.client.CookieStore;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskDemo {
    
    public static void start(Data data) {

        String dataStr=data.getOnTimeDate();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        Date date = null;

        CookieStore cookieStore=LoginUtils.doLoginPost(data);


        try {
            date = format.parse(dataStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        new Timer().schedule(new TimerTask() {
            int count = 20;

            @Override
            public void run() {
                if (count > 0) {
                    try {
                        HttpClientUtil.sendPOST(cookieStore,data);
                        count--;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else{
                    this.cancel();
                    System.exit(0);
                }
            }
        }, date, 300);

        new Timer().schedule(new TimerTask() {
            int count = 20;

            @Override
            public void run() {
                if (count > 0) {
                    try {
                        HttpClientUtil2.sendPOST(cookieStore,data);
                        count--;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else{
                    this.cancel();
                    System.exit(0);
                }
            }
        }, date, 300);

    }

}
