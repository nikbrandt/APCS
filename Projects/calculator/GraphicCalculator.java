import java.lang.Math;
import javax.swing.*;
import java.awt.*;

class GraphicCalculator extends JFrame {
  
  GraphicCalculator() {
    JFrame frame = new JFrame("Calculator");
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
    
    button = new JButton("4");
    con.gridy = 11;
    pane.add(button, con);
    
    button = new JButton("1");
    con.gridy = 12;
    pane.add(button, con);
    
    button = new JButton("0");
    con.gridy = 13;
    con.gridwidth = 2;
    pane.add(button, con);
    
    
    button = new JButton("8");
    con.gridwidth = 1;
    con.gridx = 1;
    con.gridy = 10;
    pane.add(button, con);
    
    button = new JButton("5");
    con.gridy = 11;
    pane.add(button, con);
    
    button = new JButton("2");
    con.gridy = 12;
    pane.add(button, con);
    
    
    button = new JButton("9");
    con.gridx = 2;
    con.gridy = 10;
    pane.add(button, con);
    
    button = new JButton("6");
    con.gridy = 11;
    pane.add(button, con);
    
    button = new JButton("3");
    con.gridy = 12;
    pane.add(button, con);
    
    button = new JButton(".");
    con.gridy = 13;
    pane.add(button, con);
    
    
    button = new JButton("/");
    con.gridx = 3;
    con.gridy = 10;
    pane.add(button, con);
    
    button = new JButton("*");
    con.gridy = 11;
    pane.add(button, con);
    
    button = new JButton("+");
    con.gridy = 12;
    pane.add(button, con);
    
    button = new JButton("-");
    con.gridy = 13;
    pane.add(button, con);
    
    JLabel mainPane = new JLabel("test");
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
    frame.setResizable(false);
    frame.setLocation(10, 10);
    frame.setAlwaysOnTop(true);
    frame.setVisible(true);
    frame.setAlwaysOnTop(false);
  }
  
  public static void main (String str[]) {
    GraphicCalculator calc = new GraphicCalculator();
  }
  
}

class Calculator {
  
  public double currentValue;
  
  Calculator () {
    currentValue = 0.0;
  }
  
}