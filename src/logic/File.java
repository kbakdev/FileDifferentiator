package logic;

public record File(String name, String path, String extension) {

    // File is a record that represents a file.
    public File {
        // Name cannot be null.
        if (name == null) {
            throw new IllegalArgumentException("File name cannot be null");
        }

        // Path cannot be null.
        if (path == null) {
            throw new IllegalArgumentException("File path cannot be null");
        }

        // Extension cannot be null.
        if (extension == null) {
            throw new IllegalArgumentException("File extension cannot be null");
        }

        // Check if the extension is valid.
        if (!extension.matches("^[a-zA-Z0-9]+$")) {
            throw new IllegalArgumentException("File extension is invalid");
        }

        // Check if the name is valid.
        if (!name.matches("^[a-zA-Z0-9]+$")) {
            throw new IllegalArgumentException("File name is invalid");
        }

        // Check if the file exists under the path.
        if (!java.nio.file.Files.exists(java.nio.file.Path.of(path + "/" + name + "." + extension))) {
            throw new IllegalArgumentException("File does not exist");
        }
    }
}
