class Lesson_15_Activity {
  public static void sortAndPrint(String[] array) {
    for (int i = 0; i < array.length; i++) {
      int first = i;
      for (int j = i + 1; j < array.length; j++)
        if (array[first].compareTo(array[j]) > 0) first = j;
      String temp = array[i];
      array[i] = array[first];
      array[first] = temp;
    }
    
    for (String str: array)
      System.out.print(str + " ");
    System.out.println();
  }
  
  public static void main(String[] str) {
    String[] list = { "against", "forms", "belief", "government", "democratic", "movement", "understanding" };
    sortAndPrint(list);
  }
}