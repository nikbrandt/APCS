// Nikolas Brandt, 2/26/19

public class Shuffler {
  // number of times to shuffle
  private static final int SHUFFLE_COUNT = 3;
  // number of values to shuffle
  private static final int VALUE_COUNT = 10;
  
  public static void main(String[] args) {
    System.out.println("Results of " + SHUFFLE_COUNT +
                       " consecutive perfect shuffles:");
    int[] values1 = new int[VALUE_COUNT];
    for (int i = 0; i < values1.length; i++) {
      values1[i] = i;
    }
    for (int j = 1; j <= SHUFFLE_COUNT; j++) {
      perfectShuffle(values1);
      System.out.print("  " + j + ":");
      for (int k = 0; k < values1.length; k++) {
        System.out.print(" " + values1[k]);
      }
      System.out.println();
    }
    System.out.println();
    
    System.out.println("Results of " + SHUFFLE_COUNT +
                       " consecutive efficient selection shuffles:");
    int[] values2 = new int[VALUE_COUNT];
    for (int i = 0; i < values2.length; i++) {
      values2[i] = i;
    }
    for (int j = 1; j <= SHUFFLE_COUNT; j++) {
      selectionShuffle(values2);
      System.out.print("  " + j + ":");
      for (int k = 0; k < values2.length; k++) {
        System.out.print(" " + values2[k]);
      }
      System.out.println();
    }
    System.out.println();
  }
  
  // perfect shuffle, definitely not perfect
  public static void perfectShuffle(int[] values) {
    int k = 0;
    int[] shuffled = new int[values.length];
    
    int middle = values.length % 2 == 0
      ? values.length / 2
      : (values.length + 1) / 2;
    
    
    
    for (int j = 0; j < middle; j++) {
      shuffled[k] = values[j];
      k += 2;
    }
    
    k = 1;
    for (int j = middle; j < values.length; j++) {
      shuffled[k] = values[j];
      k += 2;
    }
    
    for (int i = 0; i < shuffled.length; i++) {
      // System.out.println(values[i] + " to: " + shuffled[i]);
      values[i] = shuffled[i];
    }
  }
  
  // efficient selection shuffle
  public static void selectionShuffle(int[] values) {
    for (int i = values.length - 1; i >= 0; i--) {
      int r = (int)(Math.random() * i);
      int temp = values[r];
      
      values[r] = values[i];
      values[i] = temp;
    }
  }
}
