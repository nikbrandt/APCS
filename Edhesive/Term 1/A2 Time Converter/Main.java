import java.util.Scanner;

class Main {
  
  public static void main (String str[]) {
   
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Gimme the seconds since the evil Unix Epoch okay thanks");
    int number = scanner.nextInt();
    
    int year = number / Constants.YEAR_IN_SECONDS;
    number %= Constants.YEAR_IN_SECONDS;
    year += 1970;
    
    int month = number / Constants.MONTH_IN_SECONDS;
    number %= Constants.MONTH_IN_SECONDS;
    
    int day = number / Constants.DAY_IN_SECONDS;
    number %= Constants.DAY_IN_SECONDS;
    
    int hour = number / Constants.HOUR_IN_SECONDS;
    number %= Constants.HOUR_IN_SECONDS;
    
    int minute = number / Constants.MINUTE_IN_SECONDS;
    number %= Constants.MINUTE_IN_SECONDS;
    
    System.out.println("Year: " + year);
    System.out.println("Month: " + month);
    System.out.println("Day: " + day);
    System.out.println("Hour: " + hour);
    System.out.println("Min: " + minute);
    System.out.println("Sec: " + number);
    
  }
  
}

class Constants {
  
  public static int MINUTE_IN_SECONDS = 60;
  public static int HOUR_IN_SECONDS = MINUTE_IN_SECONDS * 60;
  public static int DAY_IN_SECONDS = HOUR_IN_SECONDS * 24;
  public static int MONTH_IN_SECONDS = DAY_IN_SECONDS * 30;
  public static int YEAR_IN_SECONDS = MONTH_IN_SECONDS * 12;
  
}