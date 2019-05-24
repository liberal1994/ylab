package ylab2.panelutil;

import ylab2.ApplicationEntry;
import ylab2.SettingPanel;
import ylab2.ioutil.PropertiesUtil;
import ylab2.model.Data;

import javax.swing.*;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class VisualPropertySetting extends JFrame {

    private SettingPanel panel;

    public VisualPropertySetting() {
        init();
    }

    public void init() {
        this.setLayout(new BorderLayout());
        TopPanel topPanel = new TopPanel();
        JPanel m = new JPanel();
        m.setLayout(new GridLayout(2, 1, 0, 2));
        //在这里向组件中写入值
        Properties properties=PropertiesUtil.read();
        MidPanel midPanel = new MidPanel("1");
        midPanel.content.setText(properties.getProperty("content"));
        midPanel.machineId.setSelectedItem(properties.getProperty("instrumentId"));
        midPanel.date.setText(properties.getProperty("reserveDate"));
        midPanel.start.setText(properties.getProperty("reserveStartTime"));
        midPanel.end.setText(properties.getProperty("reserveEndTime"));

        MidPanel midPanel2 = new MidPanel("2");
        midPanel.content.setText(properties.getProperty("content2"));
        midPanel.machineId.setSelectedItem(properties.getProperty("instrumentId2"));
        midPanel.date.setText(properties.getProperty("reserveDate2"));
        midPanel.start.setText(properties.getProperty("reserveStartTime2"));
        midPanel.end.setText(properties.getProperty("reserveEndTime2"));

        ButtomPanel buttomPanel = new ButtomPanel();
        m.add(midPanel);
        m.add(midPanel2);
        m.setBackground(Color.black);
        JPanel verifyPanel = new JPanel(new BorderLayout());
        verifyPanel.add(buttomPanel, BorderLayout.CENTER);
        JButton verify = new JButton("确定");
        verify.setFont(new Font("宋体", Font.BOLD, 20));
        verify.setForeground(new Color(255, 50, 0));
        verify.addActionListener(e -> {
            Data data = new Data();
            Properties props = new Properties();

            String u = buttomPanel.username.getText();
            data.setUsername(u);
            props.setProperty("username", u);
            String p = new String(buttomPanel.password.getPassword());
            data.setPassword(p);
            props.setProperty("password", p);

            data.setCurrentDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            data.setOnTimeDate(topPanel.targetDate.getText() + "-" + topPanel.targetTime.getText());

            String date=midPanel.date.getText();
            data.setReserveDate(date);
            props.setProperty("reserveDate",date);

            String startTime=midPanel.start.getText();
            data.setReserveStartTime(startTime);
            props.setProperty("reserveStartTime",startTime);

            String endTime=midPanel.end.getText();
            data.setReserveEndTime(endTime);
            props.setProperty("reserveEndTime",endTime);

            String mId=midPanel.machineId.getSelectedItem().toString();
            data.setInstrumentId(mId);
            props.setProperty("instrumentId",mId);

            String content=midPanel.content.getText();
            data.setReserveReport(content);
            props.setProperty("ReserveReport",content);

            String date2=midPanel.date.getText();
            data.setReserveDate(date2);
            props.setProperty("reserveDate2",date2);

            String startTime2=midPanel.start.getText();
            data.setReserveStartTime(startTime2);
            props.setProperty("reserveStartTime2",startTime2);

            String endTime2=midPanel.end.getText();
            data.setReserveEndTime(endTime2);
            props.setProperty("reserveEndTime2",endTime2);

            String mId2=midPanel.machineId.getSelectedItem().toString();
            data.setInstrumentId(mId2);
            props.setProperty("instrumentId2",mId2);

            String content2=midPanel.content.getText();
            data.setReserveReport(content2);
            props.setProperty("ReserveReport2",content2);

            PropertiesUtil.write(props);

            this.dispose();
            ApplicationEntry.start(data);

        });
        verifyPanel.add(verify, BorderLayout.SOUTH);
        verifyPanel.setBackground(Color.gray);
        add(topPanel, BorderLayout.NORTH);
        add(m, BorderLayout.CENTER);
        add(verifyPanel, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("ylab设置");
        this.setSize(500, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setAlwaysOnTop(false);
    }

    public static void main(String[] args) {
        new VisualPropertySetting();
    }


}
