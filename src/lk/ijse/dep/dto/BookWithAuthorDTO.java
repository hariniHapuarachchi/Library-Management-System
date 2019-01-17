package lk.ijse.dep.dto;

import java.util.ArrayList;
import java.util.List;

public class BookWithAuthorDTO extends SuperDTO {

    private String baId;
    private String bookId;
    private String authorId;
    private List<AuthorDTO> authorDTOS = new ArrayList<>();

    public BookWithAuthorDTO() {
    }

    public BookWithAuthorDTO(String baId, String bookId, String authorId) {
        this.baId = baId;
        this.bookId = bookId;
        this.authorId = authorId;
    }

    public BookWithAuthorDTO(List<AuthorDTO> authorDTOS) {
        this.authorDTOS = authorDTOS;
    }

    public BookWithAuthorDTO(String baId, String bookId, String authorId, List<AuthorDTO> authorDTOS) {
        this.baId = baId;
        this.bookId = bookId;
        this.authorId = authorId;
        this.authorDTOS = authorDTOS;
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

    public List<AuthorDTO> getAuthorDTOS() {
        return authorDTOS;
    }

    public void setAuthorDTOS(List<AuthorDTO> authorDTOS) {
        this.authorDTOS = authorDTOS;
    }

    @Override
    public String toString() {
        return "BookWithAuthorDTO{" +
                "baId='" + baId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", authorId='" + authorId + '\'' +
                ", authorDTOS=" + authorDTOS +
                '}';
    }
}
