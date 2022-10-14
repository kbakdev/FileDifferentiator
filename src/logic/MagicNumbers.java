package logic;

// MagicNumbers is a map with Key: MagicByte and Value: FileType
public enum MagicNumbers {
    PNG(new byte[]{(byte) 0x89, 0x50, 0x4E, 0x47, 0x0D, 0x0A, 0x1A, 0x0A}, FileType.PNG),
    JPG(new byte[]{(byte) 0xFF, (byte) 0xD8, (byte) 0xFF}, FileType.JPG),
    GIF(new byte[]{0x47, 0x49, 0x46, 0x38, 0x37, 0x61}, FileType.GIF),
    GIF2(new byte[]{0x47, 0x49, 0x46, 0x38, 0x39, 0x61}, FileType.GIF),
    TIFF(new byte[]{0x49, 0x49, 0x2A, 0x00}, FileType.TIFF),
    TIFF2(new byte[]{0x4D, 0x4D, 0x00, 0x2A}, FileType.TIFF),
    BMP(new byte[]{0x42, 0x4D}, FileType.BMP),
    ZIP(new byte[]{0x50, 0x4B, 0x03, 0x04}, FileType.ZIP),
    RAR(new byte[]{0x52, 0x61, 0x72, 0x21, 0x1A, 0x07, 0x00}, FileType.RAR),
    RAR2(new byte[]{0x52, 0x61, 0x72, 0x21, 0x1A, 0x07, 0x01, 0x00}, FileType.RAR),
    RAR3(new byte[]{0x52, 0x61, 0x72, 0x21, 0x1A, 0x07, 0x00, 0x00}, FileType.RAR),
    RAR4(new byte[]{0x52, 0x61, 0x72, 0x21, 0x1A, 0x07, 0x01, 0x00}, FileType.RAR),
    AVI(new byte[]{0x52, 0x49, 0x46, 0x46}, FileType.AVI),
    MKV(new byte[]{0x1A, 0x45, (byte) 0xDF, (byte) 0xA3}, FileType.MKV),
    MP3(new byte[]{0x49, 0x44, 0x33}, FileType.MP3),
    MOV(new byte[]{0x66, 0x74, 0x79, 0x70, 0x4D, 0x4F, 0x4F, 0x56}, FileType.MOV),
    PDF(new byte[]{0x25, 0x50, 0x44, 0x46}, FileType.PDF),
    WMV(new byte[]{0x30, 0x26, (byte) 0xB2, 0x75, (byte) 0x8E, 0x66, (byte) 0xCF, 0x11, (byte) 0xA6, (byte) 0xD9, 0x00, (byte) 0xAA, 0x00, 0x62, (byte) 0xCE, 0x6C}, FileType.WMV),;

    private final byte[] magicBytes;
    private final FileType fileType;

    MagicNumbers(byte[] magicBytes, FileType fileType) {
        this.magicBytes = magicBytes;
        this.fileType = fileType;
    }

    public static MagicNumbers.MagicNumber[] getMagicNumbers() {
        return MagicNumbers.MagicNumber.values();
    }

    public static class MagicNumber {
        private final byte[] magicBytes;
        private final FileType fileType;

        public MagicNumber(byte[] magicBytes, FileType fileType) {
            this.magicBytes = magicBytes;
            this.fileType = fileType;
        }

        public static MagicNumber[] values() {
            MagicNumber[] magicNumbers = new MagicNumber[MagicNumbers.values().length];
            for (int i = 0; i < MagicNumbers.values().length; i++) {
                magicNumbers[i] = new MagicNumber(MagicNumbers.values()[i].magicBytes, MagicNumbers.values()[i].fileType);
            }
            return magicNumbers;
        }

        public Object fileType() {
            return fileType;
        }

        public byte[] magicBytes() {
            return magicBytes;
        }
    }
}
