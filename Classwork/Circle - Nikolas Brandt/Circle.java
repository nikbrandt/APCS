class Circle extends Shape {
  private double radius;
  
  Circle(double radius) {
    if (radius > 0) this.radius = radius;
    else this.radius = 0;
  }
  
  public double getArea() {
    return Math.PI * Math.pow(radius, 2);
  }
  
  public String toString() {
    return "circle with radius " + radius;
  }
}