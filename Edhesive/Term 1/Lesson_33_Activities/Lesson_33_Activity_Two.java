import java.util.Scanner;

class Lesson_33_Activity_Two {
  
  public static void randomize(int[] array) {
    for (int i = 0; i < array.length; i++) array[i] = (int)(Math.random() * 90) + 10;
  }
  
}