// remove all comments to make this more efficient, had to comment some things out because Edhesive has shitty standards that do not allow for refactoring and efficient code. I'm not saying I have efficient comments, though.

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class FreightTrain {
  // have to define this here instead of using Boxcar.POSSIBLE_CARGO because they use their own Boxcar class in the runner
  public static final List<String> POSSIBLE_CARGO = Arrays.asList("gizmos", "gadgets", "widgets", "wadgets");
  
  private ArrayList<Boxcar> train;
  
  FreightTrain() {
    this(1);
  }
  
  FreightTrain(int n) {
    if (n < 1) n = 1;
    
    train = new ArrayList<Boxcar>(n);
    
    for (int i = 0; i < n; i++)
      train.add(i, new Boxcar());
  }
  
  public String toString() {
    String out = "";
    for (Boxcar car: train)
      out += car + "\n";
    // out = out.substring(0, out.length() - 1); // can't make this function output a nicer looking thing because it defies their shitty code quality standards, apparently
    return out;
  }
  
  public void setCargo(String c) {
    for (Boxcar car: train)
      car.setCargo(c);
  }
  
  public void setMultiCargo() {
    int type = 0;
    for (Boxcar car: train) {
      car.setCargo(/*Boxcar.*/POSSIBLE_CARGO.get(type)); // can't use Boxcar.POSSIBLE_CARGO because their runner uses their own Boxcar class
      type++;
      if (type >= 4) type = 0;
    }
  }
  
  public void fillTrain() {
    for (Boxcar car: train) {
      for (int i = 0; i < 10; i++)
        car.loadCargo();
    }
  }
  
  public void callForRepair(int i) {
    if (i > train.size() - 1 || i < 0) return;
    train.get(i).callForRepair();
  }
}