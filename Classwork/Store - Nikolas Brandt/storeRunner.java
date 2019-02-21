import java.util.ArrayList;

public class storeRunner
{
  public static void main(String arg[])
  {
    ArrayList<Product> theStore = new ArrayList<Product>();
    theStore.add(new Product("Beef Jerky",3.25));
    theStore.add(new Dairy("Nonfat Yogurt",2.89,18,2,26));
    theStore.add(new Alcohol("Lagunitas",8.42));
    for(Product p: theStore)
      System.out.println(p);
  }
}
