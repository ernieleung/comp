public class Contact {
    private String username;
    private String displayName;

    public Contact(String username, String displayName) {
        this.username = username;
        this.displayName = displayName;
    }

    public String getUsername() {
        return username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String toCSV() {
        return username + "," + displayName;
    }

    public static Contact fromCSV(String line) {
        String[] parts = line.split(",", 2);
        if (parts.length < 2) return null;
        return new Contact(parts[0], parts[1]);
    }

    public String toString() {
        return "@" + username + " (" + displayName + ")";
    }
}
