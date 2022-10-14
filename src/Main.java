import logic.File;
import logic.FileDifferentiator;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter the file path: ");
        String path = scanner.nextLine();
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();
        System.out.print("Enter the file extension: ");
        String fileExtension = scanner.nextLine();
        FileDifferentiator fd = new FileDifferentiator();
        File file = new File(fileName, path, fileExtension);
        InputStream inputStreamFromFile = fd.getInputStreamFromFile(file);
        System.out.println(fileName + "." + fileExtension + " is a " + fd.getFileType(fd.fileSignature(inputStreamFromFile)) + " file.");
    }
}