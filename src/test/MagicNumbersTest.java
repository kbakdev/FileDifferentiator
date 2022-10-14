package test;

import logic.File;
import logic.FileDifferentiator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.nio.file.Paths;

public class MagicNumbersTest {

    String s = Paths.get("").toAbsolutePath() + "/src/test/resources";

    File jpg = new File("zyzz", s, "jpg");
    File png = new File("zyzz", s, "png");
    File gif = new File("zyzz", s, "gif");
    File bmp = new File("53jk1", s, "bmp");
    File tiff = new File("file_example_TIFF_1MB", s, "tiff");
    File pdf = new File("sample", s, "pdf");
    File rar = new File("sample", s, "rar");
    File sevenz = new File("sample", s, "7z");

    FileDifferentiator fd = new FileDifferentiator();

    @Test
    @DisplayName("Check if magic numbers match the file extension - JPG")
    public void testMagicNumbersMatchExtensionJPG() throws Exception {
        InputStream inputStreamFromFile = fd.getInputStreamFromFile(jpg);
        String fileType = fd.getFileType(fd.fileSignature(inputStreamFromFile));
        assert fileType.equals(jpg.extension());
    }

    @Test
    @DisplayName("Check if magic numbers match the file extension - PNG")
    public void testMagicNumbersMatchExtensionPNG() throws Exception {
        InputStream inputStreamFromFile = fd.getInputStreamFromFile(png);
        String fileType = fd.getFileType(fd.fileSignature(inputStreamFromFile));
        assert fileType.equals(png.extension());
    }

    @Test
    @DisplayName("Check if magic numbers match the file extension - GIF")
    public void testMagicNumbersMatchExtensionGIF() throws Exception {
        InputStream inputStreamFromFile = fd.getInputStreamFromFile(gif);
        String fileType = fd.getFileType(fd.fileSignature(inputStreamFromFile));
        assert fileType.equals(gif.extension());
    }

    @Test
    @DisplayName("Check if magic numbers match the file extension - BMP")
    public void testMagicNumbersMatchExtensionBMP() throws Exception {
        InputStream inputStreamFromFile = fd.getInputStreamFromFile(bmp);
        String fileType = fd.getFileType(fd.fileSignature(inputStreamFromFile));
        assert fileType.equals(bmp.extension());
    }

    @Test
    @DisplayName("Check if magic numbers match the file extension - TIFF")
    public void testMagicNumbersMatchExtensionTIFF() throws Exception {
        InputStream inputStreamFromFile = fd.getInputStreamFromFile(tiff);
        String fileType = fd.getFileType(fd.fileSignature(inputStreamFromFile));
        assert fileType.equals(tiff.extension());
    }

    @Test
    @DisplayName("Check if magic numbers match the file extension - PDF")
    public void testMagicNumbersMatchExtensionPDF() throws Exception {
        InputStream inputStreamFromFile = fd.getInputStreamFromFile(pdf);
        String fileType = fd.getFileType(fd.fileSignature(inputStreamFromFile));
        assert fileType.equals(pdf.extension());
    }

    @Test
    @DisplayName("Check if magic numbers match the file extension - RAR")
    public void testMagicNumbersMatchExtensionRAR() throws Exception {
        InputStream inputStreamFromFile = fd.getInputStreamFromFile(rar);
        String fileType = fd.getFileType(fd.fileSignature(inputStreamFromFile));
        assert fileType.equals(rar.extension());
    }

    @Test
    @DisplayName("Check if magic numbers match the file extension - 7Z")
    public void testMagicNumbersMatchExtension7Z() throws Exception {
        InputStream inputStreamFromFile = fd.getInputStreamFromFile(sevenz);
        String fileType = fd.getFileType(fd.fileSignature(inputStreamFromFile));
        assert fileType.equals(sevenz.extension());
    }
}
