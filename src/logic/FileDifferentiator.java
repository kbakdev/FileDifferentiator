package logic;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class FileDifferentiator {
    /**
     * Get the file type based on the file signature.
     *
     * @param fileData Byte array of the file.
     * @return String of the file type.
     */
    public String getFileType(byte[] fileData) throws Exception {
        String type;
        if (Byte.toUnsignedInt(fileData[0]) == 0xFF && Byte.toUnsignedInt(fileData[1]) == 0xD8 && Byte.toUnsignedInt(fileData[fileData.length - 2]) == 0xFF && Byte.toUnsignedInt(fileData[fileData.length - 1]) == 0xD9) {
            type = "jpeg";
            return type;
        }
        if (Byte.toUnsignedInt(fileData[0]) == 0x89 && Byte.toUnsignedInt(fileData[1]) == 0x50 && Byte.toUnsignedInt(fileData[2]) == 0x4E && Byte.toUnsignedInt(fileData[3]) == 0x47 && Byte.toUnsignedInt(fileData[4]) == 0x0D && Byte.toUnsignedInt(fileData[5]) == 0x0A && Byte.toUnsignedInt(fileData[6]) == 0x1A && Byte.toUnsignedInt(fileData[7]) == 0x0A) {
            type = "png";
            return type;
        }
        if (Byte.toUnsignedInt(fileData[0]) == 0x47 && Byte.toUnsignedInt(fileData[1]) == 0x49 && Byte.toUnsignedInt(fileData[2]) == 0x46 && Byte.toUnsignedInt(fileData[3]) == 0x38 && (Byte.toUnsignedInt(fileData[4]) == 0x37 || Byte.toUnsignedInt(fileData[4]) == 0x39) && Byte.toUnsignedInt(fileData[5]) == 0x61) {
            type = "gif";
            return type;
        }
        if (Byte.toUnsignedInt(fileData[0]) == 0x42 && Byte.toUnsignedInt(fileData[1]) == 0x4D) {
            type = "bmp";
            return type;
        }
        if (Byte.toUnsignedInt(fileData[0]) == 0x49 && Byte.toUnsignedInt(fileData[1]) == 0x49 && Byte.toUnsignedInt(fileData[2]) == 0x2A && Byte.toUnsignedInt(fileData[3]) == 0x00) {
            type = "tiff";
            return type;
        }
        if (Byte.toUnsignedInt(fileData[0]) == 0x4D && Byte.toUnsignedInt(fileData[1]) == 0x4D && Byte.toUnsignedInt(fileData[2]) == 0x00 && Byte.toUnsignedInt(fileData[3]) == 0x2A) {
            type = "tiff";
            return type;
        }
        if (Byte.toUnsignedInt(fileData[0]) == 0x52 && Byte.toUnsignedInt(fileData[1]) == 0x49 && Byte.toUnsignedInt(fileData[2]) == 0x46 && Byte.toUnsignedInt(fileData[3]) == 0x46 && Byte.toUnsignedInt(fileData[8]) == 0x57 && Byte.toUnsignedInt(fileData[9]) == 0x41 && Byte.toUnsignedInt(fileData[10]) == 0x56 && Byte.toUnsignedInt(fileData[11]) == 0x45) {
            type = "wav";
            return type;
        }
        if (Bytes.convert(Arrays.copyOfRange(fileData, 0, 4)) == 0x52494646 && Bytes.convert(Arrays.copyOfRange(fileData, 8, 12)) == 0x41564920) {
            type = "avi";
            return type;
        }
        if (Byte.toUnsignedInt(fileData[0]) == 0x52 && Byte.toUnsignedInt(fileData[1]) == 0x49 && Byte.toUnsignedInt(fileData[2]) == 0x46 && Byte.toUnsignedInt(fileData[3]) == 0x46 && Byte.toUnsignedInt(fileData[8]) == 0x41 && Byte.toUnsignedInt(fileData[9]) == 0x4D && Byte.toUnsignedInt(fileData[10]) == 0x52 && Byte.toUnsignedInt(fileData[11]) == 0x20) {
            type = "amr";
            return type;
        }
        // ASCII: ftypqt
        // Offset: 4
        if (Bytes.convert(Arrays.copyOfRange(fileData, 4, 8)) == 0x66747970 && Bytes.convert(Arrays.copyOfRange(fileData, 8, 12)) == 0x71742020) {
            type = "mov";
            return type;
        }
        if (Byte.toUnsignedInt(fileData[4]) == 0x66 && Byte.toUnsignedInt(fileData[5]) == 0x74 && Byte.toUnsignedInt(fileData[6]) == 0x79 && Byte.toUnsignedInt(fileData[7]) == 0x70) {
            // HEX: 6D 70 34 31
            // ASCII: mp41
            // offset: 8
            if (Byte.toUnsignedInt(fileData[8]) == 0x6D && Byte.toUnsignedInt(fileData[9]) == 0x70 && Byte.toUnsignedInt(fileData[10]) == 0x34 && Byte.toUnsignedInt(fileData[11]) == 0x31) {
                type = "mp4";
                return type;
            }
            // HEX: 69 73 6F 32
            // ASCII: iso2
            // offset: 8
            if (Byte.toUnsignedInt(fileData[8]) == 0x69 && Byte.toUnsignedInt(fileData[9]) == 0x73 && Byte.toUnsignedInt(fileData[10]) == 0x6F && Byte.toUnsignedInt(fileData[11]) == 0x32) {
                type = "mp4";
                return type;
            }
            // HEX: 69 73 6F 6D
            // ASCII: isom
            // offset: 8
            if (Byte.toUnsignedInt(fileData[8]) == 0x69 && Byte.toUnsignedInt(fileData[9]) == 0x73 && Byte.toUnsignedInt(fileData[10]) == 0x6F && Byte.toUnsignedInt(fileData[11]) == 0x6D) {
                type = "mp4";
                return type;
            }

            type = "mp4";
            return type;
        }
        if ((Byte.toUnsignedInt(fileData[0]) == 0xFF || Byte.toUnsignedInt(fileData[0]) == 0x49) && (Byte.toUnsignedInt(fileData[1]) == 0x44 || Byte.toUnsignedInt(fileData[1]) == 0xFB || Byte.toUnsignedInt(fileData[1]) == 0xF3 || Byte.toUnsignedInt(fileData[1]) == 0xF2) && Byte.toUnsignedInt(fileData[2]) == 0x33) {
            type = "mp3";
            return type;
        }
        if (Byte.toUnsignedInt(fileData[0]) == 0x1A && Byte.toUnsignedInt(fileData[1]) == 0x45 && Byte.toUnsignedInt(fileData[2]) == 0xDF && Byte.toUnsignedInt(fileData[3]) == 0xA3) {
            type = "mkv";
            return type;
        }
        if (Byte.toUnsignedInt(fileData[0]) == 0x25 && Byte.toUnsignedInt(fileData[1]) == 0x50 && Byte.toUnsignedInt(fileData[2]) == 0x44 && Byte.toUnsignedInt(fileData[3]) == 0x46 && Byte.toUnsignedInt(fileData[4]) == 0x2D) {
            type = "pdf";
            return type;
        }
        if (Bytes.convert(Arrays.copyOfRange(fileData, 0, 4)) == 0x52617221) {
            type = "rar";
            return type;
        }
        if (Bytes.convert(Arrays.copyOfRange(fileData, 0, 4)) == 0x3026B275 && Bytes.convert(Arrays.copyOfRange(fileData, 4, 8)) == 0x8E66CF11) {
            type = "wmv";
            return type;
        }
        if (Bytes.convert(Arrays.copyOfRange(fileData, 0, 4)) == 0x377ABCAF && Bytes.convert(Arrays.copyOfRange(fileData, 4, 6)) == 0x271C) {
            type = "7z";
            return type;
        }

        throw new Exception("File type not supported");
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