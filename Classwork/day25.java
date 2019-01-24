//Save to Z: drive with your name here: [     NIKOLAS BRANDT IS MY NAME OKAY just kidding i know im not the one who needs this giant space to put my name but im still putting my name in all caps so you can REALLY SEE IT helpme    ] <-- gaping hole for name
//Due Monday October 15, 2018

class day25 {
  public static void main(String[] args) {
    
    System.out.println("Nikolas Brandt makes a glorious program that doesn't actually require an array");
    
    int [] array = new int[100];
    double total = 0;
    
    for (int i = 0; i < 100; i++) {
      int rand = (int)(Math.random() * 100) + 1;
      array[i] = rand;
      total += rand;
      if ((i + 1) % 10 == 0) System.out.println(rand);
      else System.out.print(rand + "\t");
    }
    
    System.out.println("Average: " + (total / 100.0));
    
  }
}