package test;

import logic.File;
import logic.FileDifferentiator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FileDifferentiatorTest {

    FileDifferentiator fd = new FileDifferentiator();

    @Test
    @DisplayName("File is a JPEG file")
    void fileIsJPEG() throws Exception {
        File file = new File("zyzz", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "jpg");
        assert fd.getFileType(fd.fileSignature(fd.getInputStreamFromFile(file))).equals("jpeg");
    }

    @Test
    @DisplayName("File is a PNG file")
    void fileIsPNG() throws Exception {
        File file = new File("zyzz", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "png");
        assert fd.getFileType(fd.fileSignature(fd.getInputStreamFromFile(file))).equals("png");
    }

    @Test
    @DisplayName("File is a GIF file")
    void fileIsGIF() throws Exception {
        File file = new File("zyzz", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "gif");
        assert fd.getFileType(fd.fileSignature(fd.getInputStreamFromFile(file))).equals("gif");
    }

    @Test
    @DisplayName("File is a BMP file")
    void fileIsBMP() throws Exception {
        File file = new File("53jk1", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "bmp");
        assert fd.getFileType(fd.fileSignature(fd.getInputStreamFromFile(file))).equals("bmp");
    }

    @Test
    @DisplayName("File is a TIFF file")
    void fileIsTIFF() throws Exception {
        File file = new File("file_example_TIFF_1MB", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "tiff");
        assert fd.getFileType(fd.fileSignature(fd.getInputStreamFromFile(file))).equals("tiff");
    }

    @Test
    @DisplayName("File is a PDF file")
    void fileIsPDF() throws Exception {
        File file = new File("sample", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "pdf");
        assert fd.getFileType(fd.fileSignature(fd.getInputStreamFromFile(file))).equals("pdf");
    }

    @Test
    @DisplayName("File is a RAR file")
    void fileIsRAR() throws Exception {
        File file = new File("sample", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "rar");
        assert fd.getFileType(fd.fileSignature(fd.getInputStreamFromFile(file))).equals("rar");
    }

    @Test
    @DisplayName("File is a MP3 file")
    void fileIsMP3() throws Exception {
        File file = new File("file_example_MP3_700KB", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "mp3");
        assert fd.getFileType(fd.fileSignature(fd.getInputStreamFromFile(file))).equals("mp3");
    }

    @Test
    @DisplayName("File is a MP4 file")
    void fileIsMP4() throws Exception {
        File file = new File("file_example_MP4_480_1_5MG", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "mp4");
        assert fd.getFileType(fd.fileSignature(fd.getInputStreamFromFile(file))).equals("mp4");
    }

    @Test
    @DisplayName("File is a AVI file")
    void fileIsAVI() throws Exception {
        File file = new File("file_example_AVI_480_750kB", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "avi");
        assert fd.getFileType(fd.fileSignature(fd.getInputStreamFromFile(file))).equals("avi");
    }

    @Test
    @DisplayName("File is a MKV file")
    void fileIsMKV() throws Exception {
        File file = new File("sample_640x360", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "mkv");
        assert fd.getFileType(fd.fileSignature(fd.getInputStreamFromFile(file))).equals("mkv");
    }

    @Test
    @DisplayName("File is a MOV file")
    void fileIsMOV() throws Exception {
        File file = new File("file_example_MOV_480_700kB", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "mov");
        assert fd.getFileType(fd.fileSignature(fd.getInputStreamFromFile(file))).equals("mov");
    }

    @Test
    @DisplayName("File is a WMV file")
    void fileIsWMV() throws Exception {
        File file = new File("sample_640x360", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "wmv");
        assert fd.getFileType(fd.fileSignature(fd.getInputStreamFromFile(file))).equals("wmv");
    }
}
