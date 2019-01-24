// Copyright (c) 2019 Nikolas Brandt, the legendary coding child, but not really
// 1/17/19, period 4 AP Computer Science

class day {
  private boolean schoolDay;
  private int percentChanceRain;
  
  day(int chance, boolean d) {
    if (chance <= 100 && chance >= 0) percentChanceRain = chance;
    else percentChanceRain = 0;
    schoolDay = d;
  }
  
  day() {
    this(0, false);
  }
  
  public String toString() {
    return "Today is a " + (percentChanceRain < 25 ?
                              "sunny" :
                              "cloudy") + " " + (schoolDay ?
                                                   "school" :
                                                   "non-school") + "day with a " + percentChanceRain + "% chance of rain.";
  }
}