
import java.util.ArrayList;

public class Comment {
    private String text;
    private User author;
    private ArrayList<Comment> replies;

    // Constructor
    public Comment(String text, User author) {
        this.text = text;
        this.author = author;
        this.replies = new ArrayList<>();
    }

    // Adds a reply to this comment
    public void addReply(Comment reply) {
        replies.add(reply);
    }

    // Returns the text of the comment
    public String getText() {
        return text;
    }

    // Returns the author of the comment
    public User getAuthor() {
        return author;
    }

    // Returns the list of replies to this comment
    public ArrayList<Comment> getReplies() {
        return replies;
    }

    // Recursively formats the comment and its replies
    public String toString() {
        return toStringIndented(0);
    }

    // Recursive helper to indent replies
    public String toStringIndented(int level) {
        StringBuilder sb = new StringBuilder();
        String indent = "  ".repeat(level);
        sb.append(indent).append(author.getUsername()).append(": ").append(text);
        for (Comment reply : replies) {
            sb.append("\n").append(reply.toStringIndented(level + 1));
        }
        return sb.toString();
    }
}
