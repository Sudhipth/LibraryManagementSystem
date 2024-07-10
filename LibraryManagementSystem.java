package Daily_Problem;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {
    private static class Book {
        private String title;
        private String author;
        private String isbn;
        private boolean isAvailable;

        public Book(String title, String author, String isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
            this.isAvailable = true;
        }

        // Getters and Setters
        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public String getIsbn() {
            return isbn;
        }

        public boolean isAvailable() {
            return isAvailable;
        }

        public void setAvailable(boolean available) {
            isAvailable = available;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", isbn='" + isbn + '\'' +
                    ", isAvailable=" + isAvailable +
                    '}';
        }
    }

    private static ArrayList<Book> books = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);
    }

    private static void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        books.add(new Book(title, author, isbn));
        System.out.println("Book added successfully!");
    }

    private static void removeBook() {
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        books.removeIf(book -> book.getIsbn().equals(isbn));
        System.out.println("Book removed successfully!");
    }

    private static void searchBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found: " + book);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private static void borrowBook() {
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && book.isAvailable()) {
                book.setAvailable(false);
                System.out.println("Book borrowed successfully!");
                return;
            }
        }
        System.out.println("Book not found or already borrowed.");
    }

    private static void returnBook() {
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && !book.isAvailable()) {
                book.setAvailable(true);
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("Book not found or not borrowed.");
    }
}
