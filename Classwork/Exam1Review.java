// Nikolas Brandt
// 2-4-19, Period 4

import java.util.ArrayList;
class Exam1Review {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<String>();
    list.add("apple");
    list.add("banana");
    list.add("banana");
    list.add("banana");
    list.add("canteloup");
    list.add("canteloup");
    System.out.println("Before: "+list);
    
    ArrayList<String> temp = new ArrayList<String>();
    for (int i = list.size() - 1; i >= 0; i--) {
      if (temp.contains(list.get(i))) list.remove(i);
      else temp.add(list.get(i));
    }
    
    System.out.println("After:  "+list);
  }
}