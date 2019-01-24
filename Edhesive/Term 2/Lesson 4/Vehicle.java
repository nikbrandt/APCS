class Vehicle {
  private int location;
  
  public Vehicle() {
    this(0);
  }
  
  public Vehicle(int loc) {
    if (loc >= -20 && loc <= 20) location = loc;
    else location = 0;
  }
  
  public void forward() {
    if (location < 20) location++;
    else location = 20;
  }
  
  public void backward() {
    if (location > -20) location--;
    else location = -20;
  }
  
  public int getLocation() {
    return location;
  }
  
  public String toString() {
    String blanks = "";
    for (int i = 0; i < location + 20; i++)
      blanks += " ";
    return blanks + "@";
  }
}