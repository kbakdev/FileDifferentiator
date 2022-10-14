package logic;

import java.io.IOException;
import java.io.InputStream;

public class FileDifferentiator {
    public String getFileType(byte[] fileData) throws Exception {
        return BytesChecker.checkBytes(fileData);
    }

    public byte[] fileSignature(InputStream is) throws IOException {
        byte[] data = new byte[is.available()];
        try {
            is.read(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public InputStream getInputStreamFromFile(File file) {
        try {
            return java.nio.file.Files.newInputStream(java.nio.file.Path.of(file.path() + "/" + file.name() + "." + file.extension()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean checkMagicNumberExtension(String magicNumber, String extension) {
        return magicNumber.equals(extension);
    }
}