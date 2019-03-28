// Nikolas Brandt, 3/4/19

public class DayC implements Comparable {
  private int percentChanceRain;
  private boolean schoolDay;
  
  public int compareTo(Object o) {
    DayC other = (DayC) o;
    
    if (this.schoolDay && !other.schoolDay) return -1;
    if (!this.schoolDay && other.schoolDay) return 1;
    
    if (this.percentChanceRain > other.percentChanceRain) return -1;
    if (this.percentChanceRain < other.percentChanceRain) return 1;
    
    return 0;
  }
     
  public DayC() {
    this(0,false);
  }
  
  public DayC(int d, boolean b) {
    if(d>=0 && d<=100)
      percentChanceRain = d;
    else
      percentChanceRain=0;
    schoolDay = b; 
  }
  
  
  public String toString() {
    String t = "Today is a ";
    if(percentChanceRain<25)
      t=t+"sunny ";
    else
      t=t+"cloudy ";
    
    if (schoolDay)
      t=t+"school day with a "+percentChanceRain+"% chance of rain.";
    else
      t=t+"non-school day with a "+percentChanceRain+"% chance of rain.";
    return t;
  }
  
  public static void main(String[] args) {
    //create and print a day using the default constructor:
    DayC d1 = new DayC();
    DayC d2 = new DayC();
    DayC d3 = new DayC(52,true);
    DayC d4 = new DayC(52,true);
    DayC d5 = new DayC(67,true);
    DayC d6 = new DayC(11,false);
    
    System.out.println("day1: "+d1);
    System.out.println("day2: "+d2);
    System.out.println("  day1.compareTo(day2): "+d1.compareTo(d2));
    System.out.println("  day2.compareTo(day1): "+d2.compareTo(d1));
    System.out.println("  (both should be zero)");
    if(d1.compareTo(d2)==0 && d2.compareTo(d1)==0)
      System.out.println("PASSED");
    else
      System.out.println("FAILED");
    
    
    System.out.println("\nday3: "+d3);
    System.out.println("day4: "+d4);
    System.out.println("  day3.compareTo(day4): "+d3.compareTo(d4));
    System.out.println("  day4.compareTo(day3): "+d4.compareTo(d3));
    System.out.println("  (both should be zero)");
    if(d3.compareTo(d4)==0 && d4.compareTo(d3)==0)
      System.out.println("PASSED");
    else
      System.out.println("FAILED");
    
    
    System.out.println("\nday1: "+d1);
    System.out.println("day3: "+d3);
    System.out.println("  day3.compareTo(day1): "+d3.compareTo(d1));
    System.out.println("  (should be -1)");
    System.out.println("  day1.compareTo(day3): "+d1.compareTo(d3));
    System.out.println("  (should be 1)");
    if(d3.compareTo(d1)==-1 && d1.compareTo(d3)==1)
      System.out.println("PASSED");
    else
      System.out.println("FAILED");
    
    
    System.out.println("\nday4: "+d4);
    System.out.println("day5: "+d5);
    System.out.println("  day5.compareTo(day4): "+d5.compareTo(d4));
    System.out.println("  (should be -1)");
    System.out.println("  day4.compareTo(day5): "+d4.compareTo(d5));
    System.out.println("  (should be 1)");
    if(d5.compareTo(d4)==-1 && d4.compareTo(d5)==1)
      System.out.println("PASSED");
    else
      System.out.println("FAILED");
    
    System.out.println("\nday1: "+d1);
    System.out.println("day6: "+d6);
    System.out.println("  day6.compareTo(day1): "+d6.compareTo(d1));
    System.out.println("  (should be -1)");
    System.out.println("  day1.compareTo(day6): "+d1.compareTo(d6));
    System.out.println("  (should be 1)");
    if(d6.compareTo(d1)==-1 && d1.compareTo(d6)==1)
      System.out.println("PASSED");
    else
      System.out.println("FAILED");
    System.out.println();
    
    System.out.println("This DayC.java file coded by: Nikolas Brandt"); 
  }
}