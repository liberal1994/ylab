package ylab2.panelutil;

import ylab2.model.MachineEnum;

import javax.swing.*;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MidPanel extends JPanel {
    String name;
    JLabel jl1, jl2, jl3, jl4, jl5;
    JTextField date, start, end;
    JComboBox<String> machineId;
    JTextArea content;

    public MidPanel(String name) {
        this.name = name;
        init();

    }

    private void init() {
        jl1 = new JLabel("仪器" + name);
        jl1.setFont(new Font("宋体", Font.BOLD, 20));
        jl1.setForeground(Color.BLUE);
        jl2 = new JLabel("日期(默认7天后)");
        jl2.setFont(new Font("楷体", Font.BOLD, 16));
        jl3 = new JLabel("开始时间");
        jl3.setFont(new Font("楷体", Font.BOLD, 16));
        jl4 = new JLabel("结束时间");
        jl4.setFont(new Font("楷体", Font.BOLD, 16));
        jl5 = new JLabel("实验内容");
        jl5.setFont(new Font("楷体", Font.BOLD, 16));

        Date timeStamp = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7);
        date = new JTextField(new SimpleDateFormat("yyyy年MM月dd日").format(timeStamp));

        date.setFont(new Font("宋体", Font.BOLD, 18));
        start = new JTextField("13:00");
        start.setFont(new Font("宋体", Font.BOLD, 18));
        end = new JTextField("17:00");
        end.setFont(new Font("宋体", Font.BOLD, 18));

        machineId = new JComboBox();
        machineId.addItem(MachineEnum.OLDF20.getName());
        machineId.addItem(MachineEnum.NEWF20.getName());
        machineId.addItem(MachineEnum.OLDSAC.getName());
        machineId.addItem(MachineEnum.FIB.getName());
        machineId.addItem(MachineEnum.NONE.getName());
        machineId.setFont(new Font("楷体", Font.BOLD, 18));

        content = new JTextArea();
        content.setFont(new Font("楷体", Font.BOLD, 18));

        setLayout(new GridLayout(5, 5));
        add(jl1);
        add(machineId);
        add(jl2);
        add(date);
        add(jl3);
        add(start);
        add(jl4);
        add(end);
        add(jl5);
        add(content);
        setBackground(Color.lightGray);
    }

}
