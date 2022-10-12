package logic;

import java.io.IOException;
import java.io.InputStream;

public class FileDifferentiator {

    private final byte[] data = new byte[4];

    // addFile() adds a file to the list of files to be differentiated.
    public void addFile(File file) {
        try {
            InputStream is = java.nio.file.Files.newInputStream(java.nio.file.Path.of(file.path() + "/" + file.name() + "." + file.extension()));
            is.read(data);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // getFiles returns the list of files to be differentiated.
    public <T extends File> T[] getFiles() {
        // Return the list of files.
        return null;
    }

    /**
     * Get the file type based on the file signature.
     *
     * @param fileData Byte array of the file.
     * @return String of the file type.
     */
    public String getFileType(byte[] fileData) {
        String type = "undefined";
        if(Byte.toUnsignedInt(fileData[0]) == 0xFF && Byte.toUnsignedInt(fileData[1]) == 0xD8)
            type = "jpg";
        return type;
    }

    /**
     * Get the first 4 byte of a file signature.
     *
     */
    public byte[] fileSignature(InputStream is)
            throws IOException, NullPointerException {
        is.read(data, 0, 4);
        return data;
    }

    // getInputStreamFromFile() returns an InputStream from a file.
    public InputStream getInputStreamFromFile(File file) {
        try {
            return java.nio.file.Files.newInputStream(java.nio.file.Path.of(file.path() + "/" + file.name() + "." + file.extension()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}