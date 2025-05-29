Group Name: x Assignment Monday 5pm – formed 1 ||||
Group Members: Sufyan Nadeem, Muhammad Raad Ibn Hasan, Ernie Leung, Nahid Shikdar
=======
Project Description
=======
MQGram is a social network prototype where users can manage contacts and posts with comments. The program includes functionality to:
- Add and remove contacts
- Save/load contacts to a file
- Create posts with media links
- Add comments to posts
- Display all posts with nested comments
==========
UML Diagram
==========
[Client | +main(String[]): void]
[PostW | -postId: int; -postText: String; -mediaLink: String; -commentList: ArrayList<Comment> | +PostW(postText: String, mediaLink: String); +addComment(Comment): void; +getPostId(): int; +getPostText(): String; +getMediaLink(): String; +getComments(): ArrayList<Comment>; +toString(): String]
[Comment | -commentId: int; -author: String; -commentText: String | +Comment(author: String, text: String); +getCommentId(): int; +getAuthor(): String; +getCommentText(): String; +toString(): String]
[Contact | -firstName: String; -lastName: String; -email: String | +Contact(firstName: String, lastName: String, email: String); +getFirstName(): String; +getLastName(): String; +getEmail(): String; +toString(): String]
[ContactManager | -contacts: ArrayList<Contact> | +addContact(Contact): void; +getContacts(): ArrayList<Contact>; +saveContacts(String): void; +loadContacts(String): void]
[PostW]<>->[Comment]
[ContactManager]<>->[Contact]
[Client]->[PostW]
[Client]->[ContactManager]
Diagram can be visualized at: https://www.yuml.me/preview/583c8f18
=========
Description of Classes
=========
Contact.java: Represents a user contact. Contains first name, last name, and email. Includes methods to access and display contact details.
ContactManager.java: Maintains a list of contacts. Supports adding/removing contacts and saving/loading them to/from a CSV file.
PostW.java: Represents a post with optional media and associated comments. Includes methods to add comments and return post details.
Comment.java: Represents a comment tied to a post. Includes an author, comment text, and a unique comment ID.
Client.java: Main driver class that contains the user interface and handles user input for managing contacts, posts, and comments.
===========
Testing Explanation
===========
We manually tested the program using terminal inputs. The following were tested:
Adding/removing contacts via ContactManager
Verifying contacts saved and loaded correctly from CSV
Creating multiple posts and attaching multiple comments
Viewing full post listings with nested comment structures
Exception handling for file input/output
Testing was performed by executing Client.java and interacting with all menu options. Additional edge cases like empty files and duplicate contacts were tested and handled.
================
Contribution Breakdown
================
Sufyan Nadeem - Implemented the PostW.java class, which manages post creation, storage, and interaction with comments, and also contributed to the main driver logic in Client.java to integrate post functionality with user interaction.
Muhammad Raad Ibn Hasan – Created Comment.java with nested comment logic and helped with Client.Java. 
Ernie Leung – Created Client.java, Contact.java, ContactManager.java, and helped with PostW.java
Nahid Shikdar - Did not contribute, did not attend team meetings.

All group members contributed equally to planning and design. Code was written separately and shared via GitHub.
================
Execution
================
java Client
=================
