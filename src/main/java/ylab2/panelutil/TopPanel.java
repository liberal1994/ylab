package ylab2.panelutil;

import javax.swing.*;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TopPanel extends JPanel {
    JPanel timePanel;
    JLabel label;
    JTextField targetDate,targetTime;

    public TopPanel() {
        init();
    }

    private void init() {

        label = new JLabel("抢机时时间(默认当前)：");
        label.setFont(new Font("宋体", Font.BOLD, 20));
        Date current = new Date();


        String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(current);
        String timeStr = new SimpleDateFormat("HH:mm").format(current);

        timePanel=new JPanel(new GridLayout(1,2,2,0));

        targetDate=new JTextField(dateStr);
        targetDate.setFont(new Font("宋体",Font.BOLD,20));

        targetTime=new JTextField(timeStr+":59");
        targetTime.setFont(new Font("宋体",Font.BOLD,20));

        timePanel.add(targetDate);
        timePanel.add(targetTime);

        timePanel = new JPanel(new GridLayout(1, 2, 5, 0));
        timePanel.add(targetDate);
        timePanel.add(targetTime);
        setLayout(new GridLayout(1, 2, 0, 0));
        add(label);
        add(timePanel);
    }


}
