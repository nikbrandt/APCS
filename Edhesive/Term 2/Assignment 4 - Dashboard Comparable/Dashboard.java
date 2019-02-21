class Dashboard implements Comparable {
  private int odometer = 0;
  private int speedometer = 0;
  private boolean checkEngine = false;
  
  Dashboard() {
    this(0, 0);
  }
  
  Dashboard(int milesTravelled, int speed) {
    updateOdometer(milesTravelled);
    if (speed >= 0 && speed <= 100) speedometer = speed;
    else checkEngine = true;
  }
  
  private void updateOdometer(int miles) {
    if (miles >= 0 && miles < 100000) odometer = miles;
    else {
      odometer = 0;
      checkEngine = true;
    }
  }
  
  public void accelerate() {
    speedometer++;
    if (speedometer > 100 || checkEngine) {
      speedometer = 0;
      checkEngine = true;
    }
  }
  
  public void drive(int numMinutes) {
    int distance = (int)((double) numMinutes / 60.0 * ((double) speedometer));
    updateOdometer(odometer + distance);
  }
  
  public String toString() {
    String odo = "";
    
    int numCount = 0;
    for (int i = odometer; i > 0; i /= 10) // find length of number
      numCount++;
    for (int i = 0; i < (5 - numCount); i++) // add appropriate number of zeroes
      odo += 0;
    
    if (odometer != 0) odo += odometer;
    
    return "Speedometer: " + speedometer + " MPH\n"
      + "Odometer: " + odo + "\n"
      + "Check Engine: " + (checkEngine ? "On" : "Off");
  }
  
  public int getOdometer() {
    return odometer;
  }
  
  public int getSpeed() {
    return speedometer;
  }
  
  public boolean getCheckEngineLight() {
    return checkEngine;
  }
  
  public int compareTo(Object o) {
    Dashboard other = (Dashboard) o;
    
    int odometer = other.getOdometer();
    if (this.odometer < odometer) return -1;
    if (this.odometer > odometer) return 1;
    
    int speedometer = other.getSpeed();
    if (this.speedometer < speedometer) return -1;
    if (this.speedometer > speedometer) return 1;
    
    boolean checkEngine = other.getCheckEngineLight();
    if (!this.checkEngine && checkEngine) return -1;
    if (this.checkEngine && !checkEngine) return 1;
    
    return 0;
  }
  
  public String race (Dashboard other, int accelerationOneCount, int accelerationTwoCount) {
    StringBuilder out = new StringBuilder();
    
    for (int i = 0; i < accelerationOneCount; i++)
      this.accelerate();
    for (int i = 0; i < accelerationTwoCount; i++)
      other.accelerate();
    
    boolean firstStall = this.checkEngine;
    boolean secondStall = other.getCheckEngineLight();
    
    if (firstStall) out.append("First car stalled out!\n");
    if (secondStall) out.append("Second car stalled out!\n");
    
    out.append("\n" + this.toString());
    out.append("\n\n" + other.toString());
    out.append("\n\n");
    
    if ((firstStall && secondStall) || (speedometer == other.getSpeed()))
      out.append("It's a tie!");
    else out.append("Car " + (speedometer > other.getSpeed() ? 1 : 2) + " has won the race!");
    
    return out.toString();
  }
  
  public String difference (Dashboard other) {
    int firstDistance = odometer;
    int secondDistance = other.getOdometer();
    
    if (firstDistance > secondDistance) {
      return "Second car will need to drive for " + calcMinutes((firstDistance - secondDistance), other.getSpeed()) + " minutes to catch first car.";
    } else if (secondDistance > firstDistance) {
      return "First car will need to drive for " + calcMinutes((secondDistance - firstDistance), speedometer) + " minutes to catch second car.";
    } else return "ur bad";
  }
  
  private int calcMinutes(int distance, int rate) {
    // distance in miles, rate in MPH
    
    double dist = distance;
    double r = rate;
    
    return (int) (60 * (distance / r));
  }
}