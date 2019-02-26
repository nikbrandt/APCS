/* Due Monday 2/25/19 before class is over.
 * Write a class "Circle" which can be instantiated
 * and for which the code below executes as shown.
 * Circle extends Shape and is not abstract.
 * 
 * Save your Circle.java file and this Shape.java file
 * in a folder called "Shape yourname" where "yourname" is 
 * your name. Copy the folder to the Z: drive when you are
 * done to get credit. 
 * 
 * Don't change this file. Use this as your runner for testing. 
 * Use "3.1415926" for pi in your Circle.java file.
 * 
 * See correct final output below.
 */
public abstract class Shape
{
 public abstract double getArea();
 
 public static void main(String[] args)
 {
  Circle c1 = new Circle(3);
  System.out.println("Area of "+c1+": "+c1.getArea());
  Circle c2 = new Circle(5.641895883597747);
  System.out.println("Area of "+c2+": "+c2.getArea());
 }
}

/* Your output should match this:

Area of circle with radius 3.0: 28.274333400000003 
Area of circle with radius 5.641895883597747: 100.0 

//Your exact trailing decimals may vary
*/