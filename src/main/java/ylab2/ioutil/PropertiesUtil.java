package ylab2.ioutil;

import java.io.*;
import java.util.Properties;


import ylab2.PathConst;

public class PropertiesUtil {
    public static Properties read() {
        Properties props = new Properties();
        Reader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(PathConst.PROPERTY), "UTF-8"));
            props.load(reader);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return props;
    }


    public static void write(Properties props) {
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(PathConst.PROPERTY), "UTF-8"));
            props.store(writer, "----------------");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != writer) {
                try {
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
