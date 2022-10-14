package logic;

public record File(String name, String path, String extension) {
    public File {
        if (name == null) {
            throw new IllegalArgumentException("File name cannot be null");
        }
        if (path == null) {
            throw new IllegalArgumentException("File path cannot be null");
        }
        if (extension == null) {
            throw new IllegalArgumentException("File extension cannot be null");
        }
        if (!extension.matches("^[a-zA-Z0-9]+$")) {
            throw new IllegalArgumentException("File extension is invalid");
        }
        if (!name.matches("^[\\w,\\s-]+\\w$")) {
            throw new IllegalArgumentException("File name is invalid");
        }
        if (!java.nio.file.Files.exists(java.nio.file.Path.of(path + "/" + name + "." + extension))) {
            throw new IllegalArgumentException("File does not exist");
        }
    }
}