class Main {
  public static void main (String str[]) {
    Keyboard keyboardOne = new Keyboard(50, true, "US");
    Keyboard keyboardTwo = new Keyboard(100, false, "Andean");
    Keyboard keyboardThree = new Keyboard();
    
    // Keyboard.getKeyNum();
    
    
    System.out.println(" " + keyboardOne.getKeyNum());
    System.out.println(keyboardTwo.getKeyNum());
    System.out.println(keyboardThree);
  }
}

class Keyboard {
  private int keyNum;
  private boolean hingesBroken;
  private String layout;
  
  Keyboard(int numKeys, boolean hinge, String lay) {
    keyNum = numKeys;
    hingesBroken = hinge;
    layout = lay;
  }
  
  Keyboard() {
    
    this(104, false, "US");
  }
  
  public int getKeyNum() {
    return keyNum;
  }
  
  public String toString() {
    return "Keyboard with " + layout + " layout\n  " +
      ( hingesBroken ? "Broken hinges" : "Hinges working" ) +
      "\n  Has " + keyNum + " keys.";
  }
}

class Methods {
  public static void print (String... str) {
    for (int i = 0; i < str.length; i++)
      System.out.print(str[i] + " ");
  }
}
























public class 