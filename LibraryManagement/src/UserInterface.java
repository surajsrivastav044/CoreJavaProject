import java.sql.SQLOutput;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner;
    BookManagingService bookManagingService=new BookManagingService();
    UserService userService=new UserService();
    public static void main(String[] args) {
        new UserInterface().start();
    }


    public void start(){
        scanner=new Scanner(System.in);
        while(true){
            System.out.println("------------------Welcome to Library---------------------");
            System.out.println("1. Register \n2. Login\n3. Seel All Available Books\n4. Exit App");
            System.out.print("Please Enter your choice: ");
            int choice=scanner.nextInt();
            switch(choice){
                case 1 -> registerUser();
                case 2 -> loginUser();
                case 3 -> bookManagingService.showAllBooks();
                case 4 -> System.exit(0);
                default -> System.out.print("Invalid Choice Please Enter again: ");
            }
        }
    }

    private void registerUser() {
        System.out.print("Enter user id: ");
        int userId=scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter password: ");
        String password=scanner.next();
        scanner.nextLine();

        System.out.print("Enter contact number: ");
        String contact=scanner.next();
        scanner.nextLine();

        System.out.print("Enter user full name: ");
        String userName=scanner.nextLine();

        userService.registerUser(userId, userName, password, contact);

    }

    public void loginUser() {
        System.out.println("--------------Please Login-------------");
        System.out.print("Enter user id: ");
        int userId=scanner.nextInt();

        System.out.print("Enter password: ");
        String password=scanner.next();

        if(userService.loginUser(userId,password)) {
            while (true) {
                System.out.println("1. See All Available Books\n2. Search Book\n3. View Issue Book" +
                        "\n4. Return Book\n5. Logout\n6.Issue Book");
                System.out.print("Please Enter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> bookManagingService.showAllBooks();
                    case 2 -> searchBook();
                    case 3 -> viewIssueBook();
                    case 4 -> returnBook();
                    case 5 -> {
                        if(userService.logoutUser()){
                            start();
                        }
                    }
                    case 6 -> issueBook();
                    default -> System.out.print("Invalid Choice Please Enter again: ");
                }
            }
        }

    }

    private void searchBook() {
        System.out.print("Enter Book Name Which you want to Search:");
        scanner.nextLine();
        String bookName=scanner.nextLine();

        Books book=bookManagingService.searchBooks(bookName);
        if(book!=null){
            System.out.print("Your Book is here: ");
            System.out.println(book);
            return;
        }
        System.out.println("Sorry this book is not available right now");
    }

    private void viewIssueBook() {
        System.out.println("Please Enter User id to see the issue book details: ");
        int userId=scanner.nextInt();
        IssueBooks book=bookManagingService.showIssueBooksByUser(userId);
        if(book!=null){
            System.out.print("Your Issue Book Detail is here: ");
            System.out.println(book);
        }
        System.out.println("Sorry No book issue to you right now");
    }

    public void returnBook() {
        System.out.println("Please Enter User id: ");
        int userId=scanner.nextInt();

        System.out.println("Please Enter Book id: ");
        int bookId=scanner.nextInt();

        bookManagingService.returnBook(userId, bookId);
    }

    private void issueBook() {
        System.out.println("Please Enter User id: ");
        int userId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please Enter Book Name: ");
        String bookName = scanner.nextLine();

        System.out.println("Please Enter Count: ");
        int count = scanner.nextInt();

        IssueBooks issueBooks = bookManagingService.issueBooks(userService.userMap.get(userId), bookName, count);
        if (issueBooks != null) {
            System.out.println("Issue book to you: " + issueBooks);
            return;
        }
        System.out.println("Book is not issued to you something went wrong");
    }

}
