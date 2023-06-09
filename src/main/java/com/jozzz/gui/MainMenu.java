package com.jozzz.gui;

import com.jozzz.Main;
import com.jozzz.util.Element;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Objects;

public class MainMenu extends JPanel {

    private DIPDisplay dipDisplay;
    private DairyDisplay dairyDisplay;
    private TableListSelect tableListSelect;
    public MainMenu(){
        this.setPreferredSize(new Dimension(1366, 768));
        this.setBorder(new EmptyBorder(10,10,10,10));
        this.setLayout(new GridBagLayout());

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 300));
        panel.setLayout(new GridLayout(2, 1));

        JLabel textTitle = new JLabel("DPO Cleanser");
        textTitle.setFont(Element.getFont(35));
        textTitle.setIcon(new ImageIcon(Objects.requireNonNull(Main.class.getClassLoader().getResource("img/MomCow.png"))));
        textTitle.setHorizontalAlignment(JLabel.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 0, 10));

        JButton dpoButton = new JButton("Data DIP");
        dpoButton.setFont(Element.getFont(20));
        dpoButton.addActionListener(event -> {
            if(dipDisplay == null){
                dipDisplay = new DIPDisplay();
            }
            Main.display.add(dipDisplay, "DIP_DISPLAY");
            Element.getCardLayout().show(Main.display, "DIP_DISPLAY");
        });

        JButton dairyButton = new JButton("Data Zyan Dairy");
        dairyButton.setFont(Element.getFont(20));
        dairyButton.addActionListener(event -> {
            if(dairyDisplay == null){
                dairyDisplay = new DairyDisplay();
            }
            Main.display.add(dairyDisplay, "DAIRY_DISPLAY");
            Element.getCardLayout().show(Main.display, "DAIRY_DISPLAY");
        });

        JButton tableListButton = new JButton("Table List Select");
        tableListButton.setFont(Element.getFont(20));
        tableListButton.addActionListener(event -> {
            if(tableListSelect == null){
                tableListSelect = new TableListSelect();
            }
            Main.display.add(tableListSelect, "TABLE_LIST_DISPLAY");
            Element.getCardLayout().show(Main.display, "TABLE_LIST_DISPLAY");
        });

        buttonPanel.add(dpoButton);
        buttonPanel.add(dairyButton);
        buttonPanel.add(tableListButton);

        panel.add(textTitle);
        panel.add(buttonPanel);

        this.add(panel);
    }
}
