package lk.ijse.dep.view.util;

public class AddBookTM {

    private String bookId;
    private String bookName;
    private String authorName;
    private String publishName;
    private String publishDate;
    private int copies;
    private int availableBooks;


    public AddBookTM() {
    }

    public AddBookTM(String bookId, String bookName, String authorName, String publishName, String publishDate, int copies) {
        System.out.println("BOOK ID ="+this.bookId);
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.publishName = publishName;
        this.publishDate = publishDate;
        this.copies = copies;
    }

    public AddBookTM(String bookId, String bookName, String authorName, String publishName, String publishDate, int copies, int availableBooks) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.publishName = publishName;
        this.publishDate = publishDate;
        this.copies = copies;
        this.availableBooks=availableBooks;
    }


    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublishName() {
        return publishName;
    }

    public void setPublishName(String publishName) {
        this.publishName = publishName;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public int getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(int availableBooks) {
        this.availableBooks = availableBooks;
    }


}
