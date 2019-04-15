import java.util.ArrayList;

class Crossword {
  private final boolean DEBUG = true;
  
  private Board board;
  private ArrayList<Word> words;
  private ArrayList<Word> copy;
  
  public static void main (String str[]) {
    // Crossword cs = new Crossword(10, 10, "hello", "there", "mother", "dad", "father");
    Crossword cs = new Crossword(3, 3, "cat", "hat");
  }
  
  Crossword() {
    this(0, 0, new String[0]);
  }
  
  Crossword(int h, int w) {
    this(h, w, new String[0]);
  }
  
  Crossword(String... wordList) {
    this (0, 0, wordList);
  }
  
  Crossword(int h, int w, String... wordList) {
    board = new Board(h, w, wordList);
    
    words = new ArrayList<Word>();
    
    for (int i = 0; i < wordList.length; i++) {
      words.add(new Word(wordList[i]));
    }
    
    if (DEBUG) System.out.println("Crossward initialized with words:\n" + words);
    if (DEBUG) System.out.println("Adding words..");
    
    initialize();
  }
  
  private void initialize() {
    copy = new ArrayList<Word>(words);
    if (DEBUG) System.out.println("Word\tLength");
    
    for (Word word: words) {
      int length = word.length();
      
      if (DEBUG) System.out.println("\n" + word + "\t" + length);
      
      int count = 0;
      while (true) {
        if (count > 1000) {
          if (DEBUG) System.out.println("Could not find place for word: " + word);
          break;
        }
        
        boolean randDir = (int)(Math.random() * 2) == 1 ? true : false;
        
        int maxX = randDir ? board.getWidth() - length - 1 : board.getWidth() - 1;
        int maxY = randDir ? board.getHeight() - 1 : board.getHeight() - length - 1;
        
        int randX = (int)(Math.random() * (maxX + 1));
        int randY = (int)(Math.random() * (maxY + 1));
        
        // where true = x, false = y
        if (DEBUG) System.out.print("\t " + randX + ", " + randY + (randDir ? " in x direction: " : " in y direction: "));
        if (board.isBlank(word, randX, randY, randDir)) { // continue here
          word.setX(randX);
          word.setY(randY);
          word.setDir(randDir);
          board.addWord(word);
          if (DEBUG) System.out.println("\n" + board);
          break;
        }
        if (DEBUG) System.out.println();
        
        count++;
      }
    }
    
    System.out.println("Finished initializing, board:");
    System.out.println(board);
  }
}

class Board {
  private final boolean DEBUG = true;
  
  private int minHeight = 2;
  private int minWidth = 2;
  private int maxHeight = 50;
  private int maxWidth = 50;
  private int defaultWidth = 5;
  private int defaultHeight = 5;
  
  private int width;
  private int height;
  private ArrayList<ArrayList<Tile>> board;
  
  Board(int h, int w, String... wordList) {
    if (h >= minHeight && h <= maxHeight) height = h;
    else height = defaultHeight;
    if (w >= minWidth && w <= maxWidth) width = w;
    else width = defaultWidth;
    
    board = new ArrayList<ArrayList<Tile>>(height);
    
    for (int i = 0; i < height; i++) {
      board.add(new ArrayList<Tile>(width));
      for (int j = 0; j < width; j++) {
        board.get(i).add(new Tile());
      }
    }
  }
  
  public int getHeight() {
    return height;
  }
  
  public int getWidth() {
    return width;
  }
  
  // true = x, false = y direction
  public boolean isBlank(Word word, int x, int y, boolean dir) {
    int length = word.length();
    for (int i = 0; i < length; i++) {
      if (dir) {// x
        if (DEBUG) System.out.print("" + board.get(y).get(x + i) + " " + word.getWord().substring(i, i + 1) + " ");
        if (DEBUG) System.out.print("" + (!board.get(y).get(x + i).isBlank() // location is not blank and
              && !board.get(y).get(x + i).getValue().equals(word.getWord().substring(i, i + 1)) // char at location != word's char at location and
              && board.get(y).get(x + i).getWord() != null // tile has word and 
              && board.get(y).get(x + i).getWord().getDir() == dir) + " ");
        
        if (!board.get(y).get(x + i).isBlank() // location is not blank and
              && !board.get(y).get(x + i).getValue().equals(word.getWord().substring(i, i + 1)) // char at location != word's char at location and
              && board.get(y).get(x + i).getWord() != null // tile has word and 
              && board.get(y).get(x + i).getWord().getDir() == dir) return false; // direction is the same
        if (y - 1 >= 0 && !board.get(y - 1).get(x + i).isBlank()) return false;
        if (y + 1 < height && !board.get(y + 1).get(x + i).isBlank()) return false;
      } else { // y
        if (DEBUG) System.out.print("" + board.get(y + i).get(x) + " " + word.getWord().substring(i, i + 1) + " ");
        if (DEBUG) System.out.print("" + (!board.get(y + i).get(x).isBlank() 
              && !board.get(y + i).get(x).getValue().equals(word.getWord().substring(i, i + 1)) 
              && board.get(y + i).get(x).getWord() != null
              && board.get(y + i).get(x).getWord().getDir() == dir) + " ");
        if (!board.get(y + i).get(x).isBlank() 
              && !board.get(y + i).get(x).getValue().equals(word.getWord().substring(i, i + 1)) 
              && board.get(y + i).get(x).getWord() != null
              && board.get(y + i).get(x).getWord().getDir() == dir) return false;
        if (x - 1 >= 0 && !board.get(y + i).get(x - 1).isBlank()) return false;
        if (x + 1 < width && !board.get(y + i).get(x + 1).isBlank()) return false;
      }
    }

    if (DEBUG) System.out.print("^");
    
    if (dir) {
      if (x - 1 >= 0 && !board.get(y).get(x - 1).isBlank()) return false;
      if (x + length < width && !board.get(y).get(x + length).isBlank()) return false;
    } else {
      if (y - 1 >= 0 && !board.get(y - 1).get(x).isBlank()) return false;
      if (y + length < height && !board.get(y + length).get(x).isBlank()) return false;
    }
    
    return true;
  }
  
  // always check if blank prior to using this method
  // true = x, false = y for direction
  public void addWord(Word word) {
    for (int i = 0; i < word.length(); i++) {
      if (word.getDir()) { // x
        board.get(word.getY()).get(word.getX() + i).set(word.getLetter(i));
      } else { // y
        board.get(word.getY() + i).get(word.getX()).set(word.getLetter(i));
      }
    }
  }
  
  public String toString() {
    String base = "";
    for (ArrayList<Tile> row: board) {
      for (Tile tile: row) {
        base += tile + " ";
      }
      base += "\n";
    }
    return base;
  }
}

class Word {
  int x;
  int y;
  boolean direction;
  String word;
  char[] letters;
  boolean hasPos;
  
  Word(String w) {
    this(-1, -1, false, w);
  }
  
  Word(int posX, int posY, boolean dir, String w) {
    if (x < 0 || y < 0) hasPos = false;
    else hasPos = true;
    x = posX;
    y = posY;
    direction = dir;
    word = w;
    letters = new char[word.length()];
    for (int i = 0; i < word.length(); i++)
      letters[i] = word.charAt(i);
  }
  
  public int getX() {
    return x;
  }
  
  public int getY() {
    return y;
  }
  
  public boolean getDir() {
    return direction;
  }
  
  public String getWord() {
    return word;
  }
  
  public int length() {
    return word.length();
  }
  
  public void setX(int p) {
    x = p;
  }
  
  public void setY(int p) {
    y = p;
  }
  
  public void setDir(boolean d) {
    direction = d;
  }
  
  public String getLetter (int pos) {
    return "" + word.charAt(pos);
  }
  
  public String toString() {
    return word;
  }
}

class Tile {
  private String value;
  private Word word;
  
  Tile() {
    value = "";
  }
  
  public void set(String val) {
    if (val.length() <= 1) value = val;
    else value = val.substring(0, 1);
  }
  
  public void setWord(Word word) {
    this.word = word;
  }
  
  public Word getWord() {
    return word;
  }
  
  public boolean isBlank() {
    if (value.length() == 0) return true;
    return false;
  }
  
  public String getValue() {
    return value;
  }
  
  public String toString () {
    if (value.length() == 1) return value;
    return "_";
  }
}