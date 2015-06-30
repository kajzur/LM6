/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lm6;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static lm6.LM6.digits;

/**
 *
 * @author Matt
 */
public class CheckListener implements ActionListener {

    JTextField a;
    JLabel labela;

    CheckListener(JTextField jta, JLabel label) {
        a = jta;
        labela = label;
    }

    CheckListener(JTextField jta) {
    }
    static char[] digits = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    static char[] operators = {'+', '-', '*', ':', '^'};

    @Override
    public void actionPerformed(ActionEvent e) {

        char[] arr = a.getText().toCharArray();
        boolean bracket = false, oneOp = false, shouldBeNumber = false;
        try {
            for (int i = 0; i < arr.length; i++) {
                if(!contains(arr[i], digits) 
                        && !contains(arr[i], operators) 
                        && arr[i] != ')' 
                        && arr[i] !='('
                        && arr[i] != '.'
                        && arr[i] != ';') {
                    throw new Exception("Invalid character");
                }
                else if (contains(arr[i], digits)) {

                    i = digit(arr, i);
                    oneOp = false;
                    if ((i + 1) < arr.length && arr[i + 1] == ')') {
                        bracket = false;
                        i++;
                    }
                    shouldBeNumber = false;

                } else if (!contains(arr[i], digits) && arr[i] != '(' && shouldBeNumber) {
                    throw new Exception("Invalid syntax");
                } else if (arr[i] == '(') {
                    bracket = true;
                    i = digit(arr, i + 1);
                    i--;
                    oneOp = false;
                } else if (bracket == true && arr[i] == '(') {
                    throw new Exception("Bracket missmacht");
                } else if (contains(arr[i], operators) && oneOp == false) {
                    oneOp = true;
                    shouldBeNumber = true;
                } else if (contains(arr[i], operators) && oneOp == true) {
                    throw new Exception("Many operators next to each other");
                } else if (arr[i] == ';') {
                    shouldBeNumber = false;
                    oneOp = false;
                    if (bracket) {
                        throw new Exception("Invalid bracket!");
                    }
                    bracket = false;
                }
            }
            if (bracket) {
                throw new Exception("Invalid bracket!");
            }
            if(oneOp){
                throw new Exception("Invalid operator!");
            }
        } catch (Exception ex) {
            labela.setForeground(Color.RED);
            labela.setText("Nie poprawny");
            return;
        }

        labela.setForeground(Color.GREEN);
        labela.setText("Poprawny");

    }

    public static int digit(char[] arr, int start) throws Exception {
        boolean wasDot = false;
        int result = start;
        for (int i = start; i < arr.length; i++) {
            if (!contains(arr[i], digits) && arr[i] != '.') {
                throw new Exception("Invalid number!");
            } else if (arr[i] == '.' && wasDot != true) {
                wasDot = true;
            } else if (wasDot == true) {
                result = i;
            } else {
                return result;
            }
        }
        return result;
    }

    private static boolean contains(char search, char[] arr) {
        boolean finded = false;
        for (char c : arr) {
            if (c == search) {
                finded = true;
            }
        }

        return finded;
    }

}
