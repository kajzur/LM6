/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lm6;

/**
 *
 * @author Matt
 */
public class LM6 {

    /**
     * @param args the command line arguments
     */
    static char[] digits = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    static char[] operators = {'+', '-', '*', ':', '^'};
    private static GUI gui;

    public static void main(String[] args) throws Exception {

        gui = new GUI();
        gui.setVisible(true);
    }

}
