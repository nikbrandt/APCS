import java.util.List;
import java.util.Arrays;

class Boxcar {
  public static final List<String> POSSIBLE_CARGO = Arrays.asList("gizmos", "gadgets", "widgets", "wadgets");
  
  private String cargo; // one of POSSIBLE_CARGO
  private int numUnits; // between 0 and 10, dependent on repair
  private boolean repair; // if in repair/service, true if repair. if true, numUnits = 0
  
  Boxcar() {
    this ("gizmos", 5, false);
  }
  
  Boxcar(String inCargo, int inUnits, boolean inRepair) {
    setCargo(inCargo);
    
    if (inUnits >= 0 && inUnits <= 10 && !inRepair) numUnits = inUnits;
    else numUnits = 0;
    
    repair = inRepair;
  }
  
  public void loadCargo() {
    if (numUnits >= 10) return;
    if (repair) numUnits = 0;
    else numUnits++;
  }
  
  public String getCargo() {
    return cargo;
  }
  
  public void setCargo(String inCargo) {
    inCargo = inCargo.toLowerCase();
    if (POSSIBLE_CARGO.contains(inCargo)) cargo = inCargo;
    else cargo = "gizmos";
  }
  
  public boolean isFull() {
    return numUnits == 10;
  }
  
  public void callForRepair() {
    repair = true;
    numUnits = 0;
  }
  
  public String toString() {
    return numUnits + " " + cargo + "\tin " + (repair ? "repair" : "service");
  }
}