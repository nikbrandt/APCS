import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GraphicCalculator extends JFrame {
  Calculator calc = new Calculator();
  JFrame frame;
  JLabel mainPane;
  double val = 0;
  boolean toRestart = false; // to restart on next keypress
  
  GraphicCalculator() {
    frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Container pane = frame.getContentPane();
    pane.setLayout(new GridBagLayout());
    
    GridBagConstraints con = new GridBagConstraints();
    
    JButton button;
    
    /* to add listeners
aButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        aTextField.setText(aNewText);
    }
}); 
    */
    
    button = new JButton("7");
    con.fill= GridBagConstraints.HORIZONTAL;
    con.insets = new Insets(3, 3, 3, 3);
    con.gridx = 0;
    con.gridy = 10;
    pane.add(button, con);
    addNumberListener(button, 7);
    
    button = new JButton("4");
    con.gridy = 11;
    pane.add(button, con);
    addNumberListener(button, 4);
    
    button = new JButton("1");
    con.gridy = 12;
    pane.add(button, con);
    addNumberListener(button, 1);
    
    button = new JButton("0");
    con.gridy = 13;
    con.gridwidth = 2;
    pane.add(button, con);
    addNumberListener(button, 0);
    
    
    button = new JButton("8");
    con.gridwidth = 1;
    con.gridx = 1;
    con.gridy = 10;
    pane.add(button, con);
    addNumberListener(button, 8);
    
    button = new JButton("5");
    con.gridy = 11;
    pane.add(button, con);
    addNumberListener(button, 5);
    
    button = new JButton("2");
    con.gridy = 12;
    pane.add(button, con);
    addNumberListener(button, 2);
    
    
    button = new JButton("9");
    con.gridx = 2;
    con.gridy = 10;
    pane.add(button, con);
    addNumberListener(button, 9);
    
    button = new JButton("6");
    con.gridy = 11;
    pane.add(button, con);
    addNumberListener(button, 6);
    
    button = new JButton("3");
    con.gridy = 12;
    pane.add(button, con);
    addNumberListener(button, 3);
    
    button = new JButton(".");
    con.gridy = 13;
    pane.add(button, con);
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        processDecimal();
      }
    });
    
    
    button = new JButton("/");
    con.gridx = 3;
    con.gridy = 9;
    pane.add(button, con);
    addOperationListener(button, "/");
    
    button = new JButton("*");
    con.gridy = 10;
    pane.add(button, con);
    addOperationListener(button, "*");
    
    button = new JButton("+");
    con.gridy = 11;
    pane.add(button, con);
    addOperationListener(button, "+");
    
    button = new JButton("-");
    con.gridy = 12;
    pane.add(button, con);
    addOperationListener(button, "-");
    
    button = new JButton("=");
    con.gridy = 13;
    pane.add(button, con);
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        processResult();
      }
    });
    
    mainPane = new JLabel("main");
    con.gridx = 0;
    con.gridy = 0;
    con.gridwidth = 4;
    mainPane.setText("0");
    mainPane.setOpaque(true);
    mainPane.setBackground(Color.white);
    mainPane.setForeground(Color.black);
    // System.out.println(mainPane.getFont());
    mainPane.setFont(new Font("Dialog", Font.PLAIN, 50));
    pane.add(mainPane, con);
    
    frame.pack();
    frame.setSize(275, 375);
    frame.setResizable(true);
    frame.setLocation(10, 10);
    frame.setAlwaysOnTop(true);
    frame.setVisible(true);
    frame.setAlwaysOnTop(false);
  }
  
  public static void main (String str[]) {
    GraphicCalculator calc = new GraphicCalculator();
  }
  
  private void addNumberListener(JButton button, int num) {
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        processNumber(num);
      }
    }); 
  }
  
  private void addOperationListener(JButton button, String op) {
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        processOperation(op);
      }
    }); 
  }
  
  private void processNumber(int num) {
    if (toRestart) {
      toRestart = false;
      mainPane.setText("" + num);
    } else if (mainPane.getText() == "0") mainPane.setText("" + num);
    else mainPane.setText(mainPane.getText() + num);
  }
  
  private void processOperation(String op) {
    calc.setFirst(Double.parseDouble(mainPane.getText()));
    calc.setOperation(op);
    toRestart = true;
  }
  
  private void processDecimal() {
    String paneText = mainPane.getText();
    if (paneText.indexOf(".") >= 0) return;
    mainPane.setText(paneText + ".");
  }
  
  private void processResult() {
    calc.setSecond(Double.parseDouble(mainPane.getText()));
    double res = calc.getResult();
    if ((double)(int)res == res) mainPane.setText("" + ((int)res));
    else mainPane.setText("" + res);
  }
  
}

class Calculator {
  
  double firstValue;
  double secondValue;
  String operation;
  
  Calculator () {
    firstValue = 0;
    secondValue = 0;
  }
  
  public void setFirst(double val) {
    firstValue = val;
  }
  
  public void setSecond(double val) {
    secondValue = val;
  }
  
  public void setOperation(String op) {
    operation = op;
  }
  
  public double getResult() {
    switch (operation) {
      case "*":
        return firstValue * secondValue;
      case "/":
        return firstValue / secondValue;
      case "-":
        return firstValue - secondValue;
      case "+":
      default:
        return firstValue + secondValue;
    }
  }
  
}