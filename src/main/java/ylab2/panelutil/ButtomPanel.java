package ylab2.panelutil;

import ylab2.ioutil.PropertiesUtil;

import javax.swing.*;

import java.awt.*;
import java.util.Properties;

public class ButtomPanel extends JPanel {

    JLabel jl1, jl2;
    JTextField username;
    JPasswordField password;

    public ButtomPanel() {
        init();
    }

    private void init() {
        jl1 = new JLabel("用户名");
        jl1.setFont(new Font("宋体", Font.BOLD, 20));

        jl2 = new JLabel("密码");
        jl2.setFont(new Font("宋体", Font.BOLD, 20));

        Properties props = PropertiesUtil.read();
        String u = props.getProperty("username");
        String p = props.getProperty("password");

        username = new JTextField(u);
        username.setFont(new Font("宋体", Font.PLAIN, 20));
        password = new JPasswordField(p);
        password.setFont(new Font("宋体", Font.PLAIN, 20));

        setLayout(new GridLayout(2, 2, 0, 5));
        add(jl1);
        add(username);
        add(jl2);
        add(password);
    }

}
