public class Books {

    private int bookId;
    private String bookName;
    private String author;
    private int totalBooks;
    public int availableBooks;

    public Books(int bookId, String bookName, String author, int totalBooks) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.totalBooks = totalBooks;
        this.availableBooks = totalBooks;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getTotalBooks() {
        return totalBooks;
    }

    public void setTotalBooks(int totalBooks) {
        this.totalBooks = totalBooks;
    }

    public int getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(int availableBooks) {
        this.availableBooks = availableBooks;
    }

    public boolean issueBook(int count){
        if(availableBooks>=count){
            availableBooks-=count;
            return true;
        }
        System.out.println("Books is not available yet please take it another time");
        return false;
    }

    public void returnBook(int count){
        availableBooks+=count;
        System.out.println("Thanks for Returning the Books");
    }

    @Override
    public String toString(){
        return bookId+" | "+bookName+" | "+author+" | "+availableBooks;
    }
}
