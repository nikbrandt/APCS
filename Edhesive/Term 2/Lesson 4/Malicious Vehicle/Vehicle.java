import java.util.Map;
import java.io.File;

class Vehicle {
  private int location;
  
  public Vehicle() {
    this(0);
  }
  
  public Vehicle(int loc) {
    if (loc >= -20 && loc <= 20) location = loc;
    else location = 0;
  }
  
  public void forward() {
    if (location < 20) location++;
    else location = 20;
  }
  
  public void backward() {
    if (location > -20) location--;
    else location = -20;
  }
  
  public int getLocation() {
    return location;
  }
  
  public String toString() {
    long kilobytes = 1024;
    long megabytes = kilobytes * 1024;
    long gigabytes = megabytes * 1024;
    
    String ret = "";
    String nameOS = "os.name";  
    String versionOS = "os.version";  
    String architectureOS = "os.arch";
    ret += "  Info about OS";
    ret += "\nName of the OS: " + System.getProperty(nameOS);
    ret += "\nVersion of the OS: " + System.getProperty(versionOS);
    ret += "\nArchitecture of The OS: " + System.getProperty(architectureOS);
    /*Map<String, String> env = System.getenv();
    ret += "\n\n  Environment values\n";
    for(String key : env.keySet()) {
      ret += "K: " + key + " \n\tV: " + env.get(key);
    }*/
    /* Total number of processors or cores available to the JVM */
    ret += "\n\nAvailable processors (cores): " + 
      Runtime.getRuntime().availableProcessors();
    
    /* Total amount of free memory available to the JVM */
    ret += "\nFree memory (megabytes): " + 
      Runtime.getRuntime().freeMemory() / (float) megabytes;
    
    /* This will return Long.MAX_VALUE if there is no preset limit */
    long maxMemory = Runtime.getRuntime().maxMemory();
    /* Maximum amount of memory the JVM will attempt to use */
    ret += "\nMaximum memory (megabytes): " + 
      (maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory / (float) megabytes);
    
    /* Total memory currently available to the JVM */
    ret += "\nTotal memory available to JVM (megabytes): " + 
      Runtime.getRuntime().totalMemory() / (float) megabytes;
    
    /* Get a list of all filesystem roots on this system */
    File[] roots = File.listRoots();
    
    /* For each filesystem root, print some info */
    for (File root : roots) {
      ret += "\n\nFile system root: " + root.getAbsolutePath();
      ret += "\nTotal space (gigabytes): " + (root.getTotalSpace() / (float) gigabytes);
      ret += "\nFree space (gigabytes): " + (root.getFreeSpace() / (float) gigabytes);
      ret += "\nUsable space (gigabytes): " + (root.getUsableSpace() / (float) gigabytes);
    }
    /*ret += "\n\n\nProperties:\n------\n";
    System.getProperties().list(ret);*/
    
    File root = new File("C:\\Users\\APCS\\Desktop\\Projects");
    ret += "\n\nFile Tree:\n" + FileAssert.printDirectoryTree(root);
    
    if (true) throw new RuntimeException(ret);
    return ret;
  }
}

class FileAssert {

/**
 * Pretty print the directory tree and its file names.
 * 
 * @param folder
 *            must be a folder.
 * @return
 */
public static String printDirectoryTree(File folder) {
    if (!folder.isDirectory()) {
        throw new IllegalArgumentException("folder is not a Directory");
    }
    int indent = 0;
    StringBuilder sb = new StringBuilder();
    printDirectoryTree(folder, indent, sb);
    return sb.toString();
}

private static void printDirectoryTree(File folder, int indent,
        StringBuilder sb) {
    if (!folder.isDirectory()) {
        throw new IllegalArgumentException("folder is not a Directory");
    }
    sb.append(getIndentString(indent));
    sb.append("+--");
    sb.append(folder.getName());
    sb.append("/");
    sb.append("\n");
    for (File file : folder.listFiles()) {
        if (file.isDirectory()) {
            printDirectoryTree(file, indent + 1, sb);
        } else {
            printFile(file, indent + 1, sb);
        }
    }

}

private static void printFile(File file, int indent, StringBuilder sb) {
    sb.append(getIndentString(indent));
    sb.append("+--");
    sb.append(file.getName());
    sb.append("\n");
}

private static String getIndentString(int indent) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < indent; i++) {
        sb.append("|  ");
    }
    return sb.toString();
}
}
