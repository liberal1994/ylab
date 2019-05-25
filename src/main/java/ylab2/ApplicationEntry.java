package ylab2;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import ylab2.model.Data;


public class ApplicationEntry {
    public static void start(Data data){

        TimerTaskDemo.start(data);
    }

}
