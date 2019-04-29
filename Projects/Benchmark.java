class Benchmark {
  private static int[] array = { 100, 150, 105, 120, 90, 80, 50, 75, 75, 70, 80, 90, 100 };
  static int start = 2;
  static int end = 10;
  
  public static void main(String str[]) {
    testMultipleMultiple(10, 10000000);
  }
  
  public static long testOne() {
    long startTime = System.nanoTime();
    // test code here
    
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    
    for (int i = start; i <= end; i++) {
      if (array[i] > max) max = array[i];
      if (array[i] < min) min = array[i];
    }
    
    boolean out = (max - min) <= 10;
    
    // end test code here
    return System.nanoTime() - startTime;
  }
  
  public static long testTwo() {
    long startTime = System.nanoTime();
    // test code here
    
    int max = array[start];
    int min = array[start];
    
    for (int i = start + 1; i <= end; i++) {
      if (array[i] > max) max = array[i];
      if (array[i] < min) min = array[i];
    }
    
    boolean out = (max - min) <= 10;
    
    // end test code here
    return System.nanoTime() - startTime;
  }
  
  public static long testMultiple(int iterations) {
    long sumOne = 0;
    long sumTwo = 0;
    
    for (int i = 0; i < iterations; i++) {
      sumOne += testOne();
    }
    
    for (int i = 0; i < iterations; i++) {
      sumTwo += testTwo();
    }
    
    long averageOne = sumOne / iterations;
    long averageTwo = sumTwo / iterations;
    
    System.out.println("" + iterations + " tests:");
    System.out.println("   Test one: " + averageOne + " nanosecond average");
    System.out.println("   Test two: " + averageTwo + " nanosecond average");
    System.out.println("   " + (averageOne - averageTwo) + " nanosecond computed difference");
    
    return averageOne - averageTwo;
  }
  
  public static void testMultipleMultiple(int tests, int iterations) {
    long sum = 0;
    
    for (int i = 0; i < tests; i++) {
      sum += testMultiple(iterations);
    }
    
    long average = sum / tests;
    
    System.out.println();
    System.out.println("Computed average difference over " + tests + " tests: " + average + " nanosecond(s).");
  }
}