package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    JFrame frame = new JFrame("Calculator");
    JPanel panel = new JPanel();
    JTextArea textArea = new JTextArea();
    JButton[] numButtons= new JButton[10];
    JButton[] funButtons= new JButton[9];

    JButton buttonBack, buttonClr, buttonEqu, buttonDot, buttonNeg;
    JButton buttonAdd, buttonSub, buttonMul, buttonDiv;

    Font fonts= new Font("Ink Free", Font.BOLD,30);
    double no1=0,no2=0,result=0;
    char Operator;
    Calculator(){
        frame.setSize(420,550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        textArea.setBounds(50,25,300,75);
        textArea.setFont(fonts);
        textArea.setEditable(false);

        buttonAdd = new JButton("+");
        buttonSub = new JButton("-");
        buttonMul = new JButton("*");
        buttonDiv = new JButton("/");
        buttonEqu = new JButton("=");
        buttonDot = new JButton(".");
        buttonClr = new JButton("C");
        buttonBack = new JButton("<-");
        buttonNeg = new JButton(("+/-"));

        funButtons[0] = buttonBack;
        funButtons[1] = buttonClr;
        funButtons[2] = buttonDot;
        funButtons[3] = buttonEqu;
        funButtons[4] = buttonAdd;
        funButtons[5] = buttonSub;
        funButtons[6] = buttonMul;
        funButtons[7] = buttonDiv;
        funButtons[8] = buttonNeg;

        for (int i=0;i<9;i++){
            funButtons[i].addActionListener(this);
            funButtons[i].setFont(fonts);
            funButtons[i].setFocusable(false);
        }
        for (int i=0;i<10;i++){
            numButtons[i]=new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFont(fonts);
            numButtons[i].setFocusable(false);
        }

        buttonClr.setBounds(50,130,100,50);
        buttonBack.setBounds(150,130,100,50);
        buttonDiv.setBounds(250,130,100,50);

        panel.setBounds(50,180,300,300);
        panel.setLayout(new GridLayout(4,4));
        panel.setBackground(Color.LIGHT_GRAY);


        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);

        panel.add(funButtons[6]);

        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);

        panel.add(funButtons[5]);

        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);

        panel.add(funButtons[4]);

        panel.add(funButtons[8]);
        panel.add(numButtons[0]);

        panel.add(funButtons[2]);
        panel.add(funButtons[3]);
//

        frame.add(buttonBack);
        frame.add(buttonClr);
        frame.add(buttonDiv);
        frame.add(textArea);
        frame.add(panel);

        frame.setVisible(true);

    }



    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i=0;i<10;i++){
            if (e.getSource()==numButtons[i]){
                textArea.setText(textArea.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource()==buttonDot){
            textArea.setText(textArea.getText().concat("."));
        }
        if (e.getSource()==buttonAdd){
            no1= Double.parseDouble(textArea.getText());
            Operator = '+';
            textArea.setText("");
        }
        if (e.getSource()==buttonSub){
            no1= Double.parseDouble(textArea.getText());
            Operator = '-';
            textArea.setText("");
        }
        if (e.getSource()==buttonMul){
            no1= Double.parseDouble(textArea.getText());
            Operator = '*';
            textArea.setText("");
        }
        if (e.getSource()==buttonDiv){
            no1= Double.parseDouble(textArea.getText());
            Operator = '/';
            textArea.setText("");
        }
        if (e.getSource()==buttonEqu){
            no2= Double.parseDouble(textArea.getText());
            switch (Operator){
                case '+':
                    result= no1+no2;
                    break;
                case '-':
                    result= no1-no2;
                    break;
                case '*':
                    result= no1*no2;
                    break;
                case '/':
                    result= no1/no2;
                    break;
            }
            textArea.setText(String.valueOf(result));
            no1=result;
        }
        if (e.getSource()==buttonClr){
            textArea.setText("");
        }
        if (e.getSource()==buttonBack){
            String str = textArea.getText();
            textArea.setText("");
            for (int i=0;i<str.length()-1;i++){

                textArea.setText(textArea.getText()+str.charAt(i));
            }
        }
        if (e.getSource()==buttonNeg){
            double temp = Double.parseDouble(textArea.getText());
            temp*=-1;
            textArea.setText(String.valueOf(temp));
        }

    }
}
