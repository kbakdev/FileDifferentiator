package logic;

import java.io.IOException;
import java.io.InputStream;

public class FileDifferentiator {
    /**
     * Get the file type based on the file signature.
     *
     * @param fileData Byte array of the file.
     * @return String of the file type.
     */
    public String getFileType(byte[] fileData) throws Exception {
        String type;
        type = BytesChecker.checkBytes(fileData);
        return type;
    }

    /**
     * Get InputStream from file.
     *
     */
    public byte[] fileSignature(InputStream is) throws IOException {
        byte[] data = new byte[is.available()];
        try {
            is.read(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
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