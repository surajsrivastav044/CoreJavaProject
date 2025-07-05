public class IssueBooks {

    private static int counter = 4000;
    private int issueBookId;
    private User user;
    private Books books;
    private int booksIssued;

    public IssueBooks(User user, Books books, int booksIssued) {
        this.issueBookId = counter++;
        this.user = user;
        this.books = books;
        this.booksIssued = booksIssued;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        IssueBooks.counter = counter;
    }

    public int getIssueBookId() {
        return issueBookId;
    }

    public void setIssueBookId(int issueBookId) {
        this.issueBookId = issueBookId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public int getBooksIssued() {
        return booksIssued;
    }

    public void setBooksIssued(int booksIssued) {
        this.booksIssued = booksIssued;
    }

    @Override
    public String toString(){
        return "BookIssueID: "+issueBookId+" Book Name: "+books.getBookName()+
                " Author: "+books.getAuthor()+" Total books issue"+ booksIssued+
                " Issued By "+user.getFullName();
    }
}
