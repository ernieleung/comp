import java.util.ArrayList;

public class PostW {
    private final String content;
    private final ArrayList<Comment> comments;

    public PostW(String content) {
        if (content == null || content.isEmpty()) {
            throw new IllegalArgumentException("Post content cannot be empty.");
        }
        this.content = content;
        this.comments = new ArrayList<>();
    }

    public String getContent() {
        return content;
    }

    public void addComment(Comment comment) {
        if (comment != null) {
            comments.add(comment);
        }
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public String toCSV() {
        return content.replace(",", " ");
    }

    public static PostW fromCSV(String line) {
        return new PostW(line);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\"").append(content).append("\"");
        if (!comments.isEmpty()) {
            sb.append("\n--- Comments ---");
            for (Comment c : comments) {
                sb.append("\n").append(c.toString());
            }
        }
        return sb.toString();
    }
}
