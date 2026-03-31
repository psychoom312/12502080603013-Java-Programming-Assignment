import java.io.File;
import java.util.Date;

public class DirectoryLister {
    public static void main(String[] args) {
        // Replace with your actual directory path
        String path = "C:/Users/Public"; 
        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                System.out.println("--- Files in: " + path + " ---");
                System.out.printf("%-30s | %-10s | %-20s\n", "Name", "Type", "Last Modified");
                System.out.println("---------------------------------------------------------------");

                for (File file : files) {
                    String type = file.isDirectory() ? "DIR" : "FILE";
                    String lastModified = new Date(file.lastModified()).toString();
                    
                    System.out.printf("%-30s | %-10s | %-20s\n", 
                        file.getName(), type, lastModified);
                }
            } else {
                System.out.println("The directory is empty.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }
    }
}
