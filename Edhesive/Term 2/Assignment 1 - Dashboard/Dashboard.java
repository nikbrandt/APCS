class Dashboard {
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
    if (speedometer > 100) {
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
}