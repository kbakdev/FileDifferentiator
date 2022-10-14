package test;

import logic.File;
import logic.FileDifferentiator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileDifferentiatorTest {

    FileDifferentiator fd = new FileDifferentiator();
    String s = Paths.get("").toAbsolutePath() + "/src/test/resources";

    @Test
    @DisplayName("File is a JPEG file")
    void fileIsJPEG() throws Exception {
        assert fd.getFileType(fd.fileSignature(fd.getInputStreamFromFile(new File("zyzz", s, "jpg")))).equals("jpg");
    }

    @Test
    @DisplayName("File is a PNG file")
    void fileIsPNG() throws Exception {
        assert fd.getFileType(fd.fileSignature(fd.getInputStreamFromFile(new File("zyzz", s, "png")))).equals("png");
    }

    @Test
    @DisplayName("File is a GIF file")
    void fileIsGIF() throws Exception {
        assert fd.getFileType(fd.fileSignature(fd.getInputStreamFromFile(new File("zyzz", s, "gif")))).equals("gif");
    }

    @Test
    @DisplayName("File is a BMP file")
    void fileIsBMP() throws Exception {
        assert fd.getFileType(fd.fileSignature(fd.getInputStreamFromFile(new File("53jk1", s, "bmp")))).equals("bmp");
    }

    @Test
    @DisplayName("File is a TIFF file")
    void fileIsTIFF() throws Exception {
        assert fd.getFileType(fd.fileSignature(fd.getInputStreamFromFile(new File("file_example_TIFF_1MB", s, "tiff")))).equals("tiff");
    }

    @Test
    @DisplayName("File is a PDF file")
    void fileIsPDF() throws Exception {
        assert fd.getFileType(fd.fileSignature(fd.getInputStreamFromFile(new File("sample", s, "pdf")))).equals("pdf");
    }

    @Test
    @DisplayName("File is a RAR file")
    void fileIsRAR() throws Exception {
        assert fd.getFileType(fd.fileSignature(fd.getInputStreamFromFile(new File("sample", s, "rar")))).equals("rar");
    }

    @Test
    @DisplayName("File is a MP3 file")
    void fileIsMP3() throws Exception {
        assert fd.getFileType(fd.fileSignature(fd.getInputStreamFromFile(new File("file_example_MP3_700KB", s, "mp3")))).equals("mp3");
    }

    @Test
    @DisplayName("File is a AVI file")
    void fileIsAVI() throws Exception {
        assert fd.getFileType(fd.fileSignature(fd.getInputStreamFromFile(new File("file_example_AVI_480_750kB", s, "avi")))).equals("avi");
    }

    @Test
    @DisplayName("File is a MKV file")
    void fileIsMKV() throws Exception {
        assert fd.getFileType(fd.fileSignature(fd.getInputStreamFromFile(new File("sample_640x360", s, "mkv")))).equals("mkv");
    }

    @Test
    @DisplayName("File is a WMV file")
    void fileIsWMV() throws Exception {
        assert fd.getFileType(fd.fileSignature(fd.getInputStreamFromFile(new File("sample_640x360", s, "wmv")))).equals("wmv");
    }

    @Test
    @DisplayName("Couldn't determine file type")
    void fileIsUnknown() {
        assertThrows(IllegalArgumentException.class, () -> fd.getFileType(fd.fileSignature(fd.getInputStreamFromFile(new File("unknown", s, "unknown")))));
    }

    @Test
    @DisplayName("Corrupted file hack.png_original")
    void fileIsCorrupted() {
        assertThrows(IllegalArgumentException.class, () -> fd.getFileType(fd.fileSignature(fd.getInputStreamFromFile(new File("hack", s, "png_original")))));
    }

    @Test
    @DisplayName("Corrupted file test.png_original")
    void fileIsCorrupted2() {
        assertThrows(IllegalArgumentException.class, () -> fd.getFileType(fd.fileSignature(fd.getInputStreamFromFile(new File("test", s, "png_original")))));
    }

    @Test
    @DisplayName("Check Magic Number Extension")
    void checkMagicNumberExtension() throws Exception {
        File file = new File("zyzz", s, "jpg");
        InputStream inputStreamFromFile = fd.getInputStreamFromFile(file);
        byte[] fileSignature = fd.fileSignature(inputStreamFromFile);
        assert fd.getFileType(fileSignature).equals(file.extension());
    }

    @Test
    @DisplayName("Check Magic Number Extension - Corrupted Magic Bytes")
    void checkMagicNumberExtensionFunctionError() throws Exception {
        File file = new File("virus", s, "bmp");
        InputStream inputStreamFromFile = fd.getInputStreamFromFile(file);
        byte[] fileSignature = fd.fileSignature(inputStreamFromFile);
        assertThrows(Exception.class, () -> fd.getFileType(fileSignature));
    }

    @Test
    @DisplayName("Check Magic Number Extension Special Function")
    void checkMagicNumberExtensionSpecialFunction() throws Exception {
        File file = new File("zyzz", s, "jpg");
        InputStream inputStreamFromFile = fd.getInputStreamFromFile(file);
        byte[] fileSignature = fd.fileSignature(inputStreamFromFile);
        assert fd.checkMagicNumberExtension(fd.getFileType(fileSignature), file.extension());
    }

    @Test
    @DisplayName("Check Magic Number Extension Special Function - Corrupted Magic Bytes")
    void checkMagicNumberExtensionSpecialFunctionError() throws Exception {
        File file = new File("virus", s, "bmp");
        InputStream inputStreamFromFile = fd.getInputStreamFromFile(file);
        byte[] fileSignature = fd.fileSignature(inputStreamFromFile);
        assertThrows(Exception.class, () -> fd.checkMagicNumberExtension(fd.getFileType(fileSignature), file.extension()));
    }

    @Test
    @DisplayName("CHeck Magic Number Extension of Fake GIF File")
    void checkMagicNumberExtensionFakeGIF() throws Exception {
        File file = new File("fakeGIF", s, "jpg");
        InputStream inputStreamFromFile = fd.getInputStreamFromFile(file);
        byte[] fileSignature = fd.fileSignature(inputStreamFromFile);
        assertThrows(Exception.class, () -> fd.checkMagicNumberExtension(fd.getFileType(fileSignature), file.extension()));
    }
}
