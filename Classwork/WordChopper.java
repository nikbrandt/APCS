// Nikolas Brandt on December 3rd, 2018 doing a program to chop words

class WordChopper {
  public static String chopper(String one, String two) {
    return one.substring(0, one.length() / 2) + two.substring(two.length() / 2);
  }
  
  public static void main (String str[]) {
    String [] wordList = {"hope", "puppy", "code"};
    
    for (int i = 0; i < wordList.length; i++) {
      for (int j = 0; j < wordList.length; j++) {
        if (j == i) continue;
        System.out.println(wordList[i] + " + " + wordList[j] + ":\t" + chopper(wordList[i], wordList[j]));
      }
    }
  }
}