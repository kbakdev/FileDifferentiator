import logic.File;
import logic.FileDifferentiator;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // Mock Files
        File file1 = new File("zyzz", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "gif");
        System.out.println("File 1 created: " + file1.name() + "." + file1.extension());
        File file2 = new File("zyzz", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "jpg");
        System.out.println("File 2 created: " + file2.name() + "." + file2.extension());
        File file3 = new File("zyzz", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "png");
        System.out.println("File 3 created: " + file3.name() + "." + file3.extension());
        File file4 = new File("zyzz", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "txt");
        System.out.println("File 4 created: " + file4.name() + "." + file4.extension());

        // Create files that are included in the package testFiles.
        FileDifferentiator fd = new FileDifferentiator();
        fd.addFile(file1);
        fd.addFile(file2);
        fd.addFile(file3);
        fd.addFile(file4);

        // getFiles() returns a list of files that are included in the package testFiles.
        System.out.println("Files in the package: " + Arrays.toString(fd.getFiles()));

        // Get InputStream from a file.
        InputStream fileSignature = fd.getInputStreamFromFile(file1);
        System.out.println("File signature: " + Arrays.toString(fd.fileSignature(fileSignature)));
        
        InputStream fileSignature2 = fd.getInputStreamFromFile(file2);
        System.out.println("File signature: " + Arrays.toString(fd.fileSignature(fileSignature2)));
        System.out.println("InputStream from file 1: " + fileSignature);

        // Get the file type based on the file signature.
        System.out.println("File 1 is a " + fd.getFileType(fd.fileSignature(fileSignature)) + " file.");
        // Check File Signature
        System.out.println(fd.getFileType(fd.fileSignature(fileSignature)));

        // Get the list of files to be differentiated.
        System.out.println("Files to be differentiated: " + Arrays.toString(fd.getFiles()));

        // Print the list of files to be differentiated.
    }
}