// Nikolas Brandt, 1/22/19

/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *       Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */

import java.util.List;
import java.util.Arrays;

public class Magpie2 {
  /**
   * Get a default greeting  
   * @return a greeting
   */
  public String getGreeting() {
    return "Hello, let's talk.";
  }
  
  /**
   * Gives a response to a user statement
   * 
   * @param statement
   *            the user statement
   * @return a response based on the rules given
   */
  public String getResponse(String statement) {
    statement = statement.toLowerCase();
    
    String response = "";
    if (statement.trim().length() == 0) {
      response = "Say something, please.";
    } else if (statement.indexOf("no") >= 0) {
      response = "Sheesh, such negativity.";
    } else if (statement.indexOf("brother") >= 0) {
      response = "What's your brother do in his free time?";
    } else if (statement.indexOf("mother") >= 0
                 || statement.indexOf("father") >= 0
                 || statement.indexOf("sister") >= 0) {
      response = "Tell me more about your family.";
    } else if (statement.indexOf("cat") >= 0 || statement.indexOf("dog") >= 0) {
      response = "I wish I had pets.";
    } else if (statement.indexOf("mr.") >= 0) {
      response = "He sounds like a good teacher.";
    } else if (statement.indexOf("mrs.") >= 0) {
      response = "She sounds like a good teacher.";
    } else {
      response = getRandomResponse();
    }
    return response;
  }
  
  /**
   * Pick a default response to use if nothing else fits.
   * @return a non-committal string
   */
  private String getRandomResponse() {
    final List<String> responses = Arrays.asList(new String[] {"Interesting, tell me more.", "Hmm.", "Do you really think so?", "You don't say.", "If you say so.", "It do be like that."});
    return responses.get((int)(Math.random() * responses.size()));
  }
}
