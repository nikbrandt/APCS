//Save to Z: drive with your name here: Nikolas Brandt
//Due Monday October 9, 2018

class day23 {
   public static void main(String[] str) {
      String t = "Grace M. Hopper";
      
      String [] args = t.split(" ");
      
      System.out.println("First: " + args[0]);
      System.out.println("Middle: " + args[1].substring(0, 1));
      System.out.println("Last: " + args[2]);

      /*
       * Add code to print the first name, middle initial and last name on 
       * the correct lines using .substring() and .indexOf() methods only.
       * Your code must work with any length first and last name. The middle
       * initial will always just be an initial.
       * 
       * Your output should look like this:
       * 
       * First: Grace 
       * Middle: M 
       * Last: Hopper 
       * 
       * */
   }
}