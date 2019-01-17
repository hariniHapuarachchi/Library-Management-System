package lk.ijse.dep.view.util;

public class BookWithAuthorTM {

    private String baId;
    private String bookId;
    private String authorId;

    public BookWithAuthorTM() {
    }

    public BookWithAuthorTM(String baId, String bookId, String authorId) {
        this.baId = baId;
        this.bookId = bookId;
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
