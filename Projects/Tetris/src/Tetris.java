import java.util.Scanner; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * http://tetris.wikia.com/wiki/Tetris_Guideline
 * https://constantrenewal.com/wp-content/uploads/2018/03/Tetris-Effect-1024x626.png
 * https://www.dummies.com/programming/java/how-to-write-java-code-to-show-an-image-on-the-screen/
 */

class Tetris {
  public static void main (String str[]) {
    new Game();
  }
}

class Game {
  private Sound sound;
  private JFrame frame;
  private GridBagConstraints con = new GridBagConstraints();
  Container pane;
  
  Game() {
    frame = new JFrame("Tetris");
    /*ImageIcon yellowPiece = new ImageIcon("assets\\images\\yellowSingle.png");
    JLabel yellowPieceLabel = new JLabel(yellowPiece);
    frame.add(yellowPieceLabel);*/
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    
    pane = frame.getContentPane();
    pane.setLayout(new GridBagLayout());
    
    menu();
  }
  
  private void clear () {
    System.out.println("Here");
    frame.getContentPane().removeAll();
    frame.repaint();
    frame.revalidate();
  }
  
  private void menu () {
    JButton button;
    
    button = new JButton("clear test");
    frame.add(button);
    
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        clear();
      }
    });
    
    sound = new Sound();
    
    button = new JButton("play music");
    frame.add(button);
    
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        sound.play();
      }
    });
    
    button = new JButton("pause music");
    frame.add(button);
    
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        sound.pause();
      }
    });
/* to add listeners
aButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        aTextField.setText(aNewText);
    }
}); 
    */
    frame.pack();
  }
}