import java.util.Scanner;

class Main {
  public static String duplicate (String input) {
    int repeat = input.length() % 2 == 0 ? input.length() * 2 : input.length();
    String base = "";
    
    for (int i = 0; i < input.length(); i++) {
      for (int j = 0; j < repeat; j++) {
        base += input.substring(i, i + 1);
      }
    }
    
    return base;
  }
  
  public static boolean isEdhesivePalindrome (String input) {
    if (input.length() <= 3 || input.length() >= 15) return false;
    input = input.replace("4", "a").replace("3", "e").replace("0", "o").toLowerCase();
    String reverse = "";
    
    for (int i = input.length(); i > 0; i--) reverse += input.substring(i - 1, i);
    if (reverse.equals(input)) return true;
    return false;
  }
  
  public static double numberScramble (double input) {
    if (input < 0) return 0.0;
    input += 5;
    input /= 2;
    input = Math.sqrt(input);
    return input;
  }
  
  public static void main (String str[]) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Welcome to the Methods Sampler Platter. Please enter a String to duplicate.");
    System.out.println("The duplicated String is: " + duplicate(scanner.nextLine()));
    
    System.out.println("Next, please enter a String to check for Edhesive Palindromes.");
    if (isEdhesivePalindrome(scanner.nextLine())) System.out.println("Nice, you found an Edhesive Palindrome!");
    else System.out.println("Too bad, that isn't an Edhesive Palindrome.");
    
    System.out.println("Almost done! Please enter a number to scramble.");
    System.out.println("The scrambled number is: " + numberScramble(scanner.nextDouble()));
  }
}