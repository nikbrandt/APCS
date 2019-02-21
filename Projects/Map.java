import java.util.ArrayList;
import java.lang.StringBuilder;

class Map {
  private ArrayList<ArrayList<Tile>> grid;
  private int height;
  private int width;
  
  public static void main(String str[]) {
    Map test = new Map(50, 20);
    System.out.println(test);
    
    Map test2 = new Map(5, 3);
    test.addThing(test2, 5, 2, 2, 3, 'm');
    test.addThing(test2, 10, 3, 2, 2, 'X');
    test.addThing(test2, 30, 2, 6, 7, 'R');
    System.out.println(test);
  }
  
  Map(int width, int height) {
    grid = new ArrayList<ArrayList<Tile>>(height);
    
    this.height = height;
    this.width = width;
    
    for (int i = 0; i < height; i++) {
      ArrayList<Tile> row = new ArrayList<Tile>(width);
      for (int j = 0; j < width; j++) {
        Tile t = new Tile(j + 1, i + 1);
        row.add(t);
      }
      grid.add(row);
    }
  }
  
  private boolean addThing(Object thing, int x, int y, int width, int height, char thingValue) {
    if (!canAdd(x, y, width, height)) return false;
    for (int i = y - 1; i < height + y - 1; i++) {
      for (int j = x - 1; j < width + x - 1; j++) {
        grid.get(i).get(j).setOccupation(thing, thingValue);
      }
    }
    return true;
  }
  
  private boolean canAdd(int x, int y, int width, int height) {
    if (this.width < x - 1 + width || this.height < y - 1 + height) return false; 
    for (int i = y - 1; i < height + y - 1; i++) {
      for (int j = x - 1; j < width + x - 1; j++) {
        if (grid.get(i).get(j).isOccupied()) return false;
      }
    }
    return true;
  }
  
  public String toString() {
    StringBuilder out = new StringBuilder();
    
    for (ArrayList<Tile> row: grid) {
      for (Tile tile: row) {
        out.append(tile);
        out.append(' ');
      }
      out.append('\n');
    }
    
    return out.toString();
  }
}

class Tile {
  private boolean occupied;
  private Object parent;
  private char value;
  private int x;
  private int y;
  
  Tile(int x, int y) {
    this(x, y, '.', false);
  }
  
  Tile(int x, int y, char value, boolean occupied) {
    this.x = x;
    this.y = y;
    this.value = value;
    this.occupied = occupied;
  }
  
  public boolean isOccupied() {
    return occupied;
  }
  
  public void setOccupation(Object parent, char value) {
    this.parent = parent;
    this.value = value;
    occupied = true;
  }
  
  public String toString() {
    return "" + value;
  }
}