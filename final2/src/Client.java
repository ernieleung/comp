package src;
import java.util.*;
import java.io.*;

public class Client {
    public static void main(String[] args) {
        ContactManager cm = new ContactManager();
        ArrayList<PostW> posts = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String choice;

        cm.loadFromCSV("contacts.csv");
        posts = loadPosts("posts.csv");

        do {
            System.out.println("\n=== MQGram ===");
            System.out.println("1. Contacts");
            System.out.println("2. Post");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = input.nextLine();

            switch (choice) {
                case "1":
                    handleContacts(input, cm);
                    break;
                case "2":
                    handleFeed(input, posts);
                    break;
                case "0":
                    cm.saveToCSV("contacts.csv");
                    savePosts(posts, "posts.csv");
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (!choice.equals("0"));

        input.close();
    }

    public static void handleContacts(Scanner input, ContactManager cm) {
        String choice;
        do {
            System.out.println("\n=== Contacts Menu ===");
            System.out.println("1. Add contact");
            System.out.println("2. Remove contact");
            System.out.println("3. Show contacts");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = input.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter contact username: ");
                    String username = input.nextLine();
                    System.out.print("Enter display name: ");
                    String displayName = input.nextLine();
                    cm.addContact(username, displayName);
                    break;
                case "2":
                    System.out.print("Enter username to remove: ");
                    String toRemove = input.nextLine();
                    cm.removeContact(toRemove);
                    break;
                case "3":
                    cm.listContacts();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (!choice.equals("0"));
    }

    public static void handleFeed(Scanner input, ArrayList<PostW> posts) {
        String choice;
        do {
            System.out.println("\n=== Feed Menu ===");
            System.out.println("1. Make a post");
            System.out.println("2. View posts");
            System.out.println("3. Comment on a post");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = input.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter your post content: ");
                    String postContent = input.nextLine();
                    posts.add(new PostW(postContent));
                    savePosts(posts, "posts.csv");
                    System.out.println("Post created!");
                    break;
                case "2":
                    if (posts.isEmpty()) {
                        System.out.println("No posts yet.");
                    } else {
                        for (int i = 0; i < posts.size(); i++) {
                            System.out.println("Post ID: (" + i + ") - " + posts.get(i));
                            System.out.println();
                        }
                    }
                    break;
                case "3":
                    if (posts.isEmpty()) {
                        System.out.println("No posts available.");
                    } else {
                        for (int i = 0; i < posts.size(); i++) {
                            System.out.println("Post ID: (" + i + ") - " + posts.get(i).getContent());
                        }
                        System.out.print("Enter post ID to comment on: ");
                        int postId = Integer.parseInt(input.nextLine());

                        if (postId >= 0 && postId < posts.size()) {
                            System.out.print("Enter your name: ");
                            String commenter = input.nextLine();
                            System.out.print("Enter your comment: ");
                            String commentText = input.nextLine();
                            Comment comment = new Comment(commentText, commenter);
                            posts.get(postId).addComment(comment);
                            System.out.println("Comment added.");
                        } else {
                            System.out.println("Invalid post ID.");
                        }
                    }
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (!choice.equals("0"));
    }

    public static ArrayList<PostW> loadPosts(String filename) {
        ArrayList<PostW> loadedPosts = new ArrayList<>();
        File file = new File(filename);
        if (!file.exists()) return loadedPosts;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                PostW post = PostW.fromCSV(line);
                if (post != null) {
                    loadedPosts.add(post);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading posts: " + e.getMessage());
        }

        return loadedPosts;
    }

    public static void savePosts(ArrayList<PostW> posts, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (PostW p : posts) {
                writer.println(p.toCSV());
            }
        } catch (IOException e) {
            System.out.println("Error saving posts: " + e.getMessage());
        }
    }
}
