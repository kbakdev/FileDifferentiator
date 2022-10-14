package test;

import logic.File;
import logic.FileDifferentiator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class MagicNumbersTest {
    File jpg = new File("zyzz", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "jpg");
    File png = new File("zyzz", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "png");
    File gif = new File("zyzz", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "gif");
    File bmp = new File("53jk1", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "bmp");
    File tiff = new File("file_example_TIFF_1MB", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "tiff");
    File pdf = new File("sample", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "pdf");
    File rar = new File("sample", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "rar");
    File sevenz = new File("sample", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "7z");

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
