package logic;
import java.util.Arrays;public class BytesChecker {
    public static String checkBytes(byte[] fileData) throws Exception {
        String type;
        MagicNumbers.MagicNumber[] magicNumbers = MagicNumbers.getMagicNumbers();
        for (MagicNumbers.MagicNumber magicNumber : magicNumbers) {
            if (Arrays.equals(magicNumber.magicBytes(), Arrays.copyOfRange(fileData, 0, magicNumber.magicBytes().length))) {
                type = magicNumber.fileType().toString();
                return type;
            }
        }
        throw new Exception("Unknown file type");
    }
}