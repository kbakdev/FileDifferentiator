package test;

import logic.File;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileTest {

    File file;

    @BeforeEach
    void setUp() {
        file = new File("zyzz", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "jpg");
    }

    @Test
    @DisplayName("File name cannot be null")
    void nameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new File(null, "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "jpg"));
    }

    @Test
    @DisplayName("File path cannot be null")
    void pathCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new File("zyzz", null, "jpg"));
    }

    @Test
    @DisplayName("File extension cannot be null")
    void extensionCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new File("zyzz", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", null));
    }

    @Test
    @DisplayName("File extension is invalid")
    void extensionIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new File("zyzz", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "jpg."));
    }

    @Test
    @DisplayName("File name is invalid")
    void nameIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new File("zyzz.", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "jpg"));
    }

    @Test
    @DisplayName("File does not exist")
    void fileDoesNotExist() {
        assertThrows(IllegalArgumentException.class, () -> new File("zyzz", "/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles", "txt"));
    }

    @Test
    @DisplayName("File name is correct")
    void nameIsCorrect() {
        assert file.name().equals("zyzz");
    }

    @Test
    @DisplayName("File path is correct")
    void pathIsCorrect() {
        assert file.path().equals("/home/kacper/IdeaProjects/FileDifferentiator/src/testFiles");
    }

    @Test
    @DisplayName("File extension is correct")
    void extensionIsCorrect() {
        assert file.extension().equals("jpg");
    }
}
