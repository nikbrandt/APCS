import java.util.ArrayList;

class UltimateTeam {
  private ArrayList<UltimatePlayer> players;
  private ArrayList<Coach> coaches;
  
  UltimateTeam(ArrayList<UltimatePlayer> p, ArrayList<Coach> c) {
    players = p;
    coaches = c;
  }
  
  public String getCutters() {
    String out = "";
    for (UltimatePlayer player: players)
      if (player.getPosition().equals("cutter")) out += player + "\n";
    return out;
  }
  
  public String getHandlers() {
    String out = "";
    for (UltimatePlayer player: players)
      if (player.getPosition().equals("handler")) out += player + "\n";
    return out;
  }
  
  public String toString() {
    String out = "COACHES\n";
    for (Coach coach: coaches)
      out += coach + "\n";
    
    out += "\nPLAYERS\n";
    for (UltimatePlayer player: players)
      out += player + "\n";
    
    return out;
  }
}