package lk.ijse.dep.entity;

public class BookWithAuthor extends SuperEntity {

    private String baId;
    private String bookId;
    private String authorId;

    public BookWithAuthor() {
    }

    public BookWithAuthor(String baId, String bookId, String authorId) {
        this.baId = baId;
        this.bookId = bookId;
        this.authorId = authorId;
    }

    public BookWithAuthor(String authorId) {
        this.authorId = authorId;
    }

    public String getBaId() {
        return baId;
    }

    public void setBaId(String baId) {
        this.baId = baId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "BookWithAuthor{" +
                "baId='" + baId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", authorId='" + authorId + '\'' +
                '}';
    }
}
