package test;

import logic.BytesChecker;
import logic.File;
import logic.FileDifferentiator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class BytesCheckerTest {

    @Test
    @DisplayName("checkBytes")
    void checkBytes() throws Exception {
        FileDifferentiator fileDifferentiator = new FileDifferentiator();
        File file = new File("zyzz", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "jpg");
        fileDifferentiator.getFileType(fileDifferentiator.fileSignature(fileDifferentiator.getInputStreamFromFile(file)));
    }

    @Test
    @DisplayName("Get file type from file")
    void getFileTypeFromFile() throws Exception {
        FileDifferentiator fd = new FileDifferentiator();
        assert fd.getFileType(fd.fileSignature(fd.getInputStreamFromFile(new File("zyzz", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "jpg")))).equals("JPG");
    }

    @Test
    @DisplayName("bytesChecker - JPG")
    void bytesCheckerJPG() throws Exception {
        String result = BytesChecker.checkBytes(new byte[]{(byte) 0xFF, (byte) 0xD8, (byte) 0xFF, (byte) 0xE0});
        assert result.equals("JPG");
    }

    @Test
    @DisplayName("bytesChecker - PNG")
    void bytesCheckerPNG() throws Exception {
        String result = BytesChecker.checkBytes(new byte[]{(byte) 0x89, (byte) 0x50, (byte) 0x4E, (byte) 0x47, 0x0D, 0x0A, 0x1A, 0x0A});
        assert result.equals("PNG");
    }

    @Test
    @DisplayName("bytesChecker - GIF")
    void bytesCheckerGIF() throws Exception {
        String result = BytesChecker.checkBytes(new byte[]{(byte) 0x47, (byte) 0x49, (byte) 0x46, (byte) 0x38, 0x37, 0x61});
        assert result.equals("GIF");
    }
    @Test
    @DisplayName("bytesChecker - BMP")
    void bytesCheckerBMP() throws Exception {
        String result = BytesChecker.checkBytes(new byte[]{(byte) 0x42, (byte) 0x4D});
        assert result.equals("BMP");
    }
    @Test
    @DisplayName("bytesChecker - TIFF")
    void bytesCheckerTIFF() throws Exception {
        String result = BytesChecker.checkBytes(new byte[]{(byte) 0x49, (byte) 0x49, (byte) 0x2A, (byte) 0x00});
        assert result.equals("TIFF");
    }
    @Test
    @DisplayName("bytesChecker - TIFF")
    void bytesCheckerTIFF2() throws Exception {
        String result = BytesChecker.checkBytes(new byte[]{(byte) 0x4D, (byte) 0x4D, (byte) 0x00, (byte) 0x2A});
        assert result.equals("TIFF");
    }
    @Test
    @DisplayName("bytesChecker - ZIP")
    void bytesCheckerZIP() throws Exception {
        String result = BytesChecker.checkBytes(new byte[]{(byte) 0x50, (byte) 0x4B, (byte) 0x03, (byte) 0x04});
        assert result.equals("ZIP");
    }
    @Test
    @DisplayName("bytesChecker - RAR")
    void bytesCheckerRAR() throws Exception {
        String result = BytesChecker.checkBytes(new byte[]{(byte) 0x52, (byte) 0x61, (byte) 0x72, (byte) 0x21, 0x1A, 0x07, 0x00});
        assert result.equals("RAR");
    }
    @Test
    @DisplayName("bytesChecker - 7Z")
    void bytesChecker7Z() throws Exception {
        String result = BytesChecker.checkBytes(new byte[]{(byte) 0x37, (byte) 0x7A, (byte) 0xBC, (byte) 0xAF, 0x27, 0x1C});
        assert result.equals("7Z");
    }
    @Test
    @DisplayName("bytesChecker - PDF")
    void bytesCheckerPDF() throws Exception {
        String result = BytesChecker.checkBytes(new byte[]{(byte) 0x25, (byte) 0x50, (byte) 0x44, (byte) 0x46, 0x2D});
        assert result.equals("PDF");
    }
    @Test
    @DisplayName("bytesChecker - MP3")
    void bytesCheckerMP3() throws Exception {
        String result = BytesChecker.checkBytes(new byte[]{(byte) 0x49, (byte) 0x44, (byte) 0x33});
        assert result.equals("MP3");
    }
    @Test
    @DisplayName("bytesChecker - MP4")
    void bytesCheckerMP4() throws Exception {
        String result = BytesChecker.checkBytes(new byte[]{0x00, 0x00, 0x00,(byte) 0x66, (byte) 0x74, (byte) 0x79, (byte) 0x70, 0x69, 0x73, 0x6F, 0x6D});
        assert result.equals("MP4");
    }
    @Test
    @DisplayName("bytesChecker - AVI")
    void bytesCheckerAVI() throws Exception {
        String result = BytesChecker.checkBytes(new byte[]{(byte) 0x52, (byte) 0x49, (byte) 0x46, (byte) 0x46, 0x24, 0x00, 0x00, 0x00, 0x41, 0x56, 0x49, 0x20, 0x4C, 0x49, 0x53, 0x54});
        assert result.equals("AVI");
    }
    @Test
    @DisplayName("bytesChecker - FLV")
    void bytesCheckerFLV() throws Exception {
        String result = BytesChecker.checkBytes(new byte[]{(byte) 0x46, (byte) 0x4C, (byte) 0x56, (byte) 0x01});
        assert result.equals("FLV");
    }
    @Test
    @DisplayName("bytesChecker - SWF")
    void bytesCheckerSWF() throws Exception {
        String result = BytesChecker.checkBytes(new byte[]{(byte) 0x46, (byte) 0x57, (byte) 0x53});
        assert result.equals("SWF");
    }
    @Test
    @DisplayName("bytesChecker - EXE")
    void bytesCheckerEXE() throws Exception {
        String result = BytesChecker.checkBytes(new byte[]{(byte) 0x5A, (byte) 0x4D});
        assert result.equals("EXE");
    }
}
