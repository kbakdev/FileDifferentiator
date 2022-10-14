package logic;

import java.nio.ByteBuffer;
import java.util.Arrays;

// BytesChecker with MagicNumbers
public class BytesChecker {
    public static String checkBytes(byte[] fileData) throws Exception {
        String type;
        if (Byte.toUnsignedInt(fileData[0]) == 0xFF && Byte.toUnsignedInt(fileData[1]) == 0xD8 && Byte.toUnsignedInt(fileData[fileData.length - 2]) == 0xFF && Byte.toUnsignedInt(fileData[fileData.length - 1]) == 0xD9) {
            type = "jpeg";
            return type;
        }
        if (Bytes.convert(Arrays.copyOfRange(fileData, 0, 4)) == 0x89504E47) {
            type = "png";
            return type;
        }
        if (Bytes.convert(Arrays.copyOfRange(fileData, 0, 4)) == 0x47494638) {
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
        if (Bytes.convert(Arrays.copyOfRange(fileData, 0, 4)) == 0x00000100) {
            type = "tiff";
            return type;
        }
        if (Bytes.convert(Arrays.copyOfRange(fileData, 0, 4)) == 0x52494646 && Bytes.convert(Arrays.copyOfRange(fileData, 8, 12)) == 0x57454250) {
            type = "wav";
            return type;
        }
        if (Bytes.convert(Arrays.copyOfRange(fileData, 0, 4)) == 0x52494646 && Bytes.convert(Arrays.copyOfRange(fileData, 8, 12)) == 0x41564920) {
            type = "avi";
            return type;
        }
        if (Bytes.convert(Arrays.copyOfRange(fileData, 0, 4)) == 0x52494646 && Bytes.convert(Arrays.copyOfRange(fileData, 8, 12)) == 0x4D4D002A) {
            type = "amr";
            return type;
        }
        if (Bytes.convert(Arrays.copyOfRange(fileData, 4, 8)) == 0x66747970 && Bytes.convert(Arrays.copyOfRange(fileData, 8, 12)) == 0x71742020) {
            type = "mov";
            return type;
        }
        if (Byte.toUnsignedInt(fileData[4]) == 0x66 && Byte.toUnsignedInt(fileData[5]) == 0x74 && Byte.toUnsignedInt(fileData[6]) == 0x79 && Byte.toUnsignedInt(fileData[7]) == 0x70) {
            if (Bytes.convert(Arrays.copyOfRange(fileData, 8, 12)) == 0x6D703431) {
                type = "mp4";
                return type;
            }
            if (Bytes.convert(Arrays.copyOfRange(fileData, 8, 12)) == 0x69736F32) {
                type = "mp4";
                return type;
            }
            if (Bytes.convert(Arrays.copyOfRange(fileData, 8, 12)) == 0x69736F6D) {
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
        throw new Exception("Unknown file type");
    }

    public static class Bytes {
        public static int convert(byte[] bytes) {
            return ByteBuffer.wrap(bytes).getInt();
        }
    }
}