import java.util.ArrayList;

class MergeSort {
  private ArrayList<int[]> array;
  
  public static void main(String str[]) {
    int[] array = { -2, 3, -5, 20, -10, 8 };
    
    new MergeSort(array);
  }
  
  MergeSort(int[] a) {
    array = new ArrayList<int[]>();
    
    for (int val: a) {
      array.add(new int[] { val });
    }
    
    merge();
    
    for (int[] ar: array) {
      System.out.print(ar[0] + " ");
    }
  }
  
  private /*int[]*/ void merge() {
    if (array.size() == 1) return/* toArray()*/;
    
    System.out.println("here");
    print();
    System.out.println();
    
    for (int i = 1; i < array.size() - 1; i++) {
      int[] first = array.get(i - 1);
      int[] second = array.get(i);
      int[] output = new int[first.length + second.length];
      
      int iteratorOne = 0;
      int iteratorTwo = 0;
      
      for (int j = 0; j < first.length + second.length; j++) {
        int val;
        
        if (iteratorOne == first.length) {
          val = second[iteratorTwo];
          iteratorTwo++;
        } else if (iteratorTwo == second.length) {
          val = first[iteratorOne];
          iteratorOne++;
        } else if (first[iteratorOne] < second[iteratorTwo]) {
          val = first[iteratorOne];
          iteratorOne++;
        } else {
          val = second[iteratorTwo];
          iteratorTwo++;
        }
        
        output[j] = val;
      }
      
      array.set(i, output);
      array.remove(i - 1);
    }
    
    System.out.println("there");
    print();
    System.out.println();
    
    merge();
  }
  
  /*private int[] toArray() {
    int[] out = new int[array.size()];
    
    for (int i = 0; i < array.size(); i++)
      out[i] = array.get(i);
    
    return out;
  }*/
  
  private void print() {
    for (int[] arr: array) {
      System.out.print("[ ");
      for (int i: arr) {
        System.out.print(i + " ");
      }
      System.out.print("]");
    }
    System.out.println();
  }
}