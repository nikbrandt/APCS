import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

class Matrix {
  private static String title = "\n ********** **                    ****     ****             **          **        \n/////**/// /**                   /**/**   **/**            /**         //         \n    /**    /**       *****       /**//** ** /**  ******   ****** ****** ** **   **\n    /**    /******  **///**      /** //***  /** //////** ///**/ //**//*/**//** ** \n    /**    /**///**/*******      /**  //*   /**  *******   /**   /** / /** //***  \n    /**    /**  /**/**////       /**   /    /** **////**   /**   /**   /**  **/** \n    /**    /**  /**//******      /**        /**//********  //** /***   /** ** //**\n    //     //   //  //////       //         //  ////////    //  ///    // //   // \n\tBy Nik B.\n\tCopyright (c) 2018. Because this looks like a 2018 program, right?\n\n\n";
  
  private static void print(String string) {
    for (int i = 0; i < string.length(); i++) System.out.print(string.charAt(i));
  }
  
  public static void main (String str[]) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.print(title);
    int width = 150;
    int height = 20;
    int delay = 40;
    
    print("How many characters wide would ya like this simulation? (1080p 174)");
    try {
      width = scanner.nextInt();
    } catch (Exception e) {
      print("How about a proper integer next time, thanks.\n");
    }
    
    print("And how many tall? (1080p 45)");
    try {
      height = scanner.nextInt();
    } catch (Exception e) {
      print("How about a proper integer next time, thanks.\n");
    }
    
    print("And how long between redraws, in ms? (Recommended 40)");
    try {
      delay = scanner.nextInt();
    } catch (Exception e) {
      print("How about a proper integer next time, thanks.\n");
    }
      
    
    scanner.close();
    
    print("Alrighty, prepare thyself for coolness\n");
    for (int i = 0; i < 50; i++) System.out.print("-");
    System.out.println();
    
    String [] grid = new String[height];    
    grid[0] = firstRowTemplate(width); // assigning to null for some reason
    
    JFrame frame = new JFrame("spoooky matrix");
    
    JTextArea label = new JTextArea("hi");
    Font font = new Font("roboto mono", Font.PLAIN, 18);
    label.setFont(font);
    label.addKeyListener(new EscKeyListener(frame));
    frame.add(label);
    label.setBackground(Color.BLACK);
    label.setForeground(Color.GREEN);
    
    frame.setSize(label.getFontMetrics(font).stringWidth(grid[0]) + 50, label.getFontMetrics(font).getHeight() * height + 45);
    if (width >= 174 && height >= 45) {
      frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
      frame.setUndecorated(true);
    }
    frame.setMinimumSize(new Dimension(800, 450));
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setAlwaysOnTop(true);
    frame.setAlwaysOnTop(false);
    
    printGrid(grid, label);
    repeat(grid, label, delay);
  }
  
  private static void printGrid (String [] grid, JTextArea label) {
    String base = "";
    for (int i = 0; i < grid.length; i++) {
      if (grid[i] != null) base += generate(grid[i]);
      base += "\n";
    }
    label.setText(base);
  }
  
  private static void repeat (String[] grid, JTextArea label, int delay) {
    try {
      TimeUnit.MILLISECONDS.sleep(delay);
    } catch (InterruptedException e) {}
    
    String[] newGrid = new String[grid.length];
    for (int i = 1; i < grid.length; i++) newGrid[i] = grid[i - 1];
    //System.out.println("\n");
    
    newGrid[0] = genNextRow(newGrid);
    printGrid(newGrid, label);
    repeat(newGrid, label, delay);
  }
  
  private static char [] possibleSmallTops = {'*', '.', ',', '~', '_'};
  private static char [] possibleSmallBottoms = {'*', '^', '`', '~', '"', '\''};
  
  private static String generate (String row) {
    String base = "";
    for (int i = 0; i < row.length(); i++) {
      char current = row.charAt(i);
      if (current == 'n') {
        base += (int)(Math.random() * 10);
      } else if (current == 'l') {
        base += (char)((int)(Math.random() * 26) + 66);
      } else if (current == 's') { // small top
        base += possibleSmallTops[(int)(Math.random() * possibleSmallTops.length)];
      } else if (current == 'b') {
        base += possibleSmallBottoms[(int)(Math.random() * possibleSmallBottoms.length)];
      } else if (current == ' ') base += " ";
    }
    return base;
  }
  
  private static String genNextRow(String[] grid) {
    // analyze grid to see how long previous columns are
    int[] lengths = new int[grid[1].length()];
    for (int i = 1; i < grid.length; i++) {
      if (grid[i] == null) break;
      for (int j = 0; j < grid[1].length(); j++) {
        if (lengths[j] > 0) continue;
        if (grid[i].charAt(j) != ' ') lengths[j]--;
        else lengths[j] -= lengths[j] * 2;
      }
    }
    
    for (int i = 0; i < lengths.length; i++) {
      if (lengths[i] < 0) lengths[i] -= lengths[i] * 2;
    }
    // lengths now has length of each row thingy, e.g. D/3/./ / will have length 3
    int max = 10; // maximum length of column
    int min = 2; // minimum length of column
    
    String base = "";
    for (int i = 0; i < grid[1].length(); i++) {
      int current = grid[1].charAt(i);
      int currentLength = lengths[i];
      
      int num = (int)(Math.random() * 101) + 1; // s is small top, b is small bottom, n is number, l is capital letter
      
      if (current == 'n' || current == 'l') {
        if (currentLength >= max) base += " ";
        else if (currentLength >= min) {
          if (num <= 40) base += "l";
          else if (num <= 70) base += "n";
          else base += "s";
        } else {
          if (num <= 60) base += "l";
          else base += "n";
        }
      } else if (current == ' ') {
        if (num <= 96) base += " ";
        else if (num <= 97) base += "l";
        else if (num <= 98) base += "n";
        else base += "b";
      } else if (current == 's') {
        base += " ";
      } else if (current == 'b') {
        if (num <= 60) base += "l";
        else base += "n";
      }
    }
    return base;
  }
  
  private static String firstRowTemplate(int width) {
    String base = "";
    for (int i = 0; i < width; i++) {
      int num = (int)(Math.random() * 101) + 1;
      if (num <= 80) base += " "; // blank, 80% chance
      else if (num <= 90) base += "b"; // small bottom character, 10% chance
      else if (num <= 95) base += "n"; // number, 5% chance
      else base += "l"; // capital letter, 5% chance
    }
    return base;
  }
}

class EscKeyListener extends KeyAdapter {
  
  private JFrame frame;
  
  EscKeyListener(JFrame input) {
    super();
    this.frame = input;
  }
  
  @Override
  public void keyPressed(KeyEvent event) {
    if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {
      frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
  }
  
}