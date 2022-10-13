package logic;

public class Bytes {
    public static int convert(byte[] copyOfRange) {
        // Convert bytes to unsigned int.
        int unsignedInt = 0;
        for (byte b : copyOfRange) {
            unsignedInt = unsignedInt << 8;
            unsignedInt = unsignedInt | (b & 0xff);
        }
        return unsignedInt;
    }
}
