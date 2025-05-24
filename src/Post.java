import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Post.java - Handled by Member B
// Represents a post made by a user, including content, timestamp, and comments.

public class Post {
    private final String content;              // The main text content of the post
    private final User author;                 // The user who created the post
    private final LocalDateTime timestamp;     // When the post was created
    private final ArrayList<Comment> comments; // Comments attached to this post

    // Constructor ensures valid input and initializes fields
    public Post(String content, User author) {
        if (content == null || content.isEmpty()) {
            throw new IllegalArgumentException("Post content cannot be empty.");
        }
        if (author == null) {
            throw new IllegalArgumentException("Author cannot be null.");
        }

        this.content = content;
        this.author = author;
        this.timestamp = LocalDateTime.now();
        this.comments = new ArrayList<>();
    }

    // Adds a comment to the post, ignoring null inputs
    public void addComment(Comment comment) {
        if (comment != null) {
            comments.add(comment);
        }
    }

    // Getters for post properties
    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    // String representation for displaying post info and comments
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm");

        sb.append("Posted by @").append(author.getUsername())
          .append(" at ").append(timestamp.format(formatter))
          .append("\n\"").append(content).append("\"");

        // Include comments section only if there are comments
        if (!comments.isEmpty()) {
            sb.append("\n--- Comments ---");
            for (Comment comment : comments) {
                sb.append("\n").append(comment.toString());
            }
        }

        return sb.toString();
    }
}
