class Lesson_17_Activity {
  public static boolean isSorted(int[] array) {
    if (array.length == 0) return true;
    
    int current = array[0];
    
    for (int i = 1; i < array.length; i++) {
      if (array[i] >= current) current = array[i];
      else return false;
    }
    
    return true;
  }
  
  public static int binarySearch(int[] array, int value) {
    return searchInRange(array, value, 0, array.length - 1);
  }
  
  private static int searchInRange(int[] array, int value, int start, int end) {
    if (end < start) return -1;
    int midpoint = (start + end) / 2;
    if (array[midpoint] < value) return searchInRange(array, value, midpoint + 1, end);
    if (array[midpoint] > value) return searchInRange(array, value, start, midpoint - 1);
    return midpoint;
  }
  
  public static int whileBinarySearch(int[] array, int value) {
    int start = 0;
    int end = array.length -1;
    
    while (end >= start) {
      int midpoint = (start + end) / 2;
      
      if (array[midpoint] < value) start = midpoint + 1;
      else if (array[midpoint] > value) end = midpoint - 1;
      else return midpoint;
    }
    
    return -1;
  }
  
  public static void main(String str[]) {
    int[] array = { 1, 1, 3, 5, 6, 7, 11, 20, 21, 24, 26, 29, 30, 31, 34 };
    int[] array2 = { 3, 2, 4 };
    
    System.out.println(isSorted(array));
    
    System.out.println(whileBinarySearch(array, 31));
  }
}