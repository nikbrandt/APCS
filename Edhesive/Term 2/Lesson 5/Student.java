class Student {
  private static int currentID;
  
  private String firstName;
  private String lastName;
  private int grade;
  private double gradePointAverage;
  private int id;
  
  Student() {
    this("None", "None", 0, 0);
  }
  
  Student(String first, String last, int gradeLevel, double gpa) {
    if (gradeLevel >= 0 && gradeLevel <= 12) grade = gradeLevel;
    else grade = 0;
    
    if (gpa >= 0 && gpa <= 4.5) gradePointAverage = gpa;
    else gpa = 0;
    
    currentID++;
    id = currentID;
    
    firstName = first;
    lastName = last;
  }
  
  public String toString() {
    return lastName + ", " + firstName +
      "\nGPA: " + gradePointAverage +
      "\nGrade Level: " + grade + " id # " + id;
  }
  
}