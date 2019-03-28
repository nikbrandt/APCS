import java.util.ArrayList;

class WrapperPractice {
  public static void main(String str[]) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    
    for (int i = 10; i <= 990; i += 10)
      list.add(i);
    System.out.println(list);
    
    for (int i = list.size() - 1; i >= 0; i--)
      if (list.get(i) % 3 == 0 || list.get(i) % 4 == 0) list.remove(i);
    System.out.println(list);
    
    System.out.println(list.get(list.size() - 1).intValue());
    
    System.out.println(Integer.MAX_VALUE);
    System.out.println(Integer.MIN_VALUE);
    
    System.out.println("Nikolas Brandt - 3/11/19");
  }
}