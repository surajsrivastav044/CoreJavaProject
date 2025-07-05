import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
public class BookManagingService {

    List<Books> booksList=new ArrayList<>();
    List<IssueBooks> issueBooksList=new ArrayList<>();

    public BookManagingService(){
        booksList.add(new Books(100,"Java","Gyan Shrivastava", 3));
        booksList.add(new Books(101,"C","Denish Ricchi", 2));
        booksList.add(new Books(103,"Python","Anuj Gupta", 5));
        booksList.add(new Books(104,"DSA in C","Shubham Kolar", 7));
        booksList.add(new Books(105,"DSA in JAVA","Jay Sharma", 2));
        booksList.add(new Books(106,"DBMS","Ankush Rohila", 1));
        booksList.add(new Books(107,"Compiler Design","Prashant Verma", 4));
        booksList.add(new Books(108,"C#","Sadika Shrivastava", 12));
        booksList.add(new Books(109,"Android","Neeraj Shrivastava", 7));
    }

    public Books searchBooks(String bookName){
        for(Books book:booksList){
            if(book.getBookName().equalsIgnoreCase(bookName)){
                return book;
            }
        }
        return null;
    }

    public void showAllBooks(){
        System.out.println("-----------------Total Available Books------------------");
        for(Books book:booksList){
            System.out.println(book);
        }
    }

    public IssueBooks issueBooks(User user, String bookName, int count){

        for(Books book:booksList){
            if(book.getBookName().equalsIgnoreCase(bookName)){
                if(book.issueBook(count)){
                    IssueBooks issueBooks=new IssueBooks(user,book,count);
                    issueBooksList.add(issueBooks);
                    return issueBooks;
                }
            }
        }
        return null;
    }

    public void returnBook(int userId, int bookId){
        for (IssueBooks issueBooks : issueBooksList) {
            if (issueBooks.getUser().getUserId() == userId && issueBooks.getBooks().getBookId() == bookId) {
                issueBooks.getBooks().returnBook(issueBooks.getBooksIssued());
                issueBooksList.remove(issueBooks);
                System.out.println("Book Returned Successful Thanks");
                return;
            }
        }
        System.out.println("Sorry BookID OR User ID is Invalid please try again");
    }

    public IssueBooks showIssueBooksByUser(int userId){
        for(IssueBooks books:issueBooksList){
            if(books.getUser().getUserId()==userId){
                return books;
            }
        }
        return null;
    }

}
