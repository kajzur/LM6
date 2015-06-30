package lm6;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.FlowLayout;
import java.awt.HeadlessException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Matt
 */
public class GUI extends JFrame{

    private JTextField jta = new JTextField(20);
    JButton check = new JButton("Sprawdź");
    JLabel label = new JLabel();
    public GUI() throws HeadlessException {
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.setLayout(new FlowLayout());
        JPanel main = new JPanel();
        BoxLayout gb = new BoxLayout(main, BoxLayout.Y_AXIS);
        main.setLayout(gb);
        jta.setEditable(true);
        check.addActionListener(new CheckListener(jta, label));
        main.add(new JLabel("Wpisz ciąg"));
        main.add(jta);
        main.add(check);
        main.add(label);
        this.add(main);
    }
    
    public void addText(String txt){
        jta.setText(jta.getText()+txt+"\n");
    }
    
}

