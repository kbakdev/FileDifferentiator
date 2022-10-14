package test;

import logic.File;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileTest {

    String s = Paths.get("").toAbsolutePath() + "/src/test/resources";

    File file;

    @BeforeEach
    void setUp() {
        file = new File("zyzz", s, "jpg");
    }

    @Test
    @DisplayName("File name cannot be null")
    void nameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new File(null, s, "jpg"));
    }

    @Test
    @DisplayName("File path cannot be null")
    void pathCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new File("zyzz", null, "jpg"));
    }

    @Test
    @DisplayName("File extension cannot be null")
    void extensionCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new File("zyzz", s, null));
    }

    @Test
    @DisplayName("File extension is invalid")
    void extensionIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new File("zyzz", s, "jpg."));
    }

    @Test
    @DisplayName("File name is invalid")
    void nameIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new File("zyzz.", s, "jpg"));
    }

    @Test
    @DisplayName("File does not exist")
    void fileDoesNotExist() {
        assertThrows(IllegalArgumentException.class, () -> new File("zyzz", s, "zip"));
    }

    @Test
    @DisplayName("File name is correct")
    void nameIsCorrect() {
        assert file.name().equals("zyzz");
    }

    @Test
    @DisplayName("File path is correct")
    void pathIsCorrect() {
        assert file.path().equals(s);
    }

    @Test
    @DisplayName("File extension is correct")
    void extensionIsCorrect() {
        assert file.extension().equals("jpg");
    }

    @Test
    @DisplayName("File is a record")
    void isRecord() {
        assert file != null;
    }

    @Test
    @DisplayName("Check file zyzz.gif")
    void checkFile() {
        assert new File("zyzz", s, "gif").equals(new File("zyzz", s, "gif"));
    }
}
