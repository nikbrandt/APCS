class Person {
  private String firstName;
  private String lastName;
  
  Person(String first, String last) {
    firstName = first;
    lastName = last;
  }
  
  public String toString() {
    return lastName + ", " + firstName;
  }
}