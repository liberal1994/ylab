package ylab2;

import javax.swing.*;
import java.awt.*;

public class SettingPanel extends JPanel {

    JButton submitButton;
    JPanel allPanel, topPanel, midPanel, buttomPanel;
    TextField textField;

    public SettingPanel() {
        init();
    }

    //初始化容器
    private void init() {
        allPanel=new JPanel();
        topPanel = new JPanel();
        midPanel=new JPanel();
        buttomPanel=new JPanel();
        allPanel.setLayout(new BorderLayout());
        allPanel.add(topPanel);
        allPanel.add(midPanel);
        allPanel.add(buttomPanel);
        textField=new TextField();
        topPanel.add(new TextField());

    }


}
