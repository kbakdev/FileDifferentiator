import logic.File;
import logic.FileDifferentiator;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        // Scan user input
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        // Get the file path
        System.out.print("Enter the file path: ");
        String path = scanner.nextLine();
//        String path = "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles";


        // Get the file name from the input
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();
//        String fileName = "zyzz";

        // Get the file extension from the input
        System.out.print("Enter the file extension: ");
//        String fileExtension = "jpg";
        String fileExtension = scanner.nextLine();

        // Create a new FileDifferentiator object
        FileDifferentiator fd = new FileDifferentiator();

        // Create a new File object
        File file = new File(fileName, path, fileExtension);

        // Get InputStream from a file.
        InputStream inputStreamFromFile = fd.getInputStreamFromFile(file);

        // Get the file type based on the file signature.
        System.out.println(fileName + "." + fileExtension + " is a " + fd.getFileType(fd.fileSignature(inputStreamFromFile)) + " file.");
    }
}