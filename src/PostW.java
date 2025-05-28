public class PostW {
    private final String content;

    public PostW(String content) {
        if (content == null || content.isEmpty()) {
            throw new IllegalArgumentException("Post content cannot be empty.");
        }
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String toCSV() {
        return content.replace(",", " ");
    }

    public static PostW fromCSV(String line) {
        return new PostW(line);
    }

    public String toString() {
        return "\"" + content + "\"";
    }
}
