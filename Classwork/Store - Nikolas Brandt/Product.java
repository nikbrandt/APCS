// Nikolas Brandt, 2-21-19, period 4

class Product {
  private String name;
  private double cost;
  private boolean over21;
  
  Product (String name, double cost) {
    this.name = name;
    if (cost > 0) this.cost = cost;
    else this.cost = 0;
    setOver21(false);
  }
  
  public void setOver21(boolean over21) {
    this.over21 = over21;
  }
  
  public String toString() {
    return name + ", $" + cost;
  }
}

class Dairy extends Product {
  private String expiration;
  
  Dairy(String name, double cost, int year, int month, int day) {
    super(name, cost);
    expiration = month + "/" + day + "/" + year;
  }
  
  public String toString() {
    return super.toString() + ", expires: " + expiration;
  }
}

class Alcohol extends Product {
  Alcohol(String name, double cost) {
    super(name, cost);
    setOver21(true);
  }
  
  public String toString() {
    return super.toString() + ", must be 21 or over";
  }
}