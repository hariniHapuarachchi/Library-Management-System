package lk.ijse.dep.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BookDTO extends SuperDTO {

    private String bId;
    private String bName;
    private int copies;
    private int availableBooks;

    private int k=1;
    private List<PublisherDTO> publisherDTOS1 = new ArrayList<>();
    private List<AuthorDTO> authorDTOS1 = new ArrayList<>();
    private List<BookWithAuthorDTO> bookWithAuthorDTOS1 = new ArrayList<>();
    private List<BookWithPublisherDTO> bookWithPublisherDTOS1 = new ArrayList<>();

    private PublisherDTO publisherDTOS = new PublisherDTO();
    private AuthorDTO authorDTOS = new AuthorDTO();
    private BookWithAuthorDTO bookWithAuthorDTOS = new BookWithAuthorDTO();
    private BookWithPublisherDTO bookWithPublisherDTOS = new BookWithPublisherDTO();

    public BookDTO() {
    }

    public BookDTO(String bId, String bName, int copies) {
        this.bId = bId;
        this.bName = bName;
        this.copies = copies;
    }

    public BookDTO(String bId, String bName, int copies, List<PublisherDTO> publisherDTOS1, List<AuthorDTO> authorDTOS1, List<BookWithAuthorDTO> bookWithAuthorDTOS1, List<BookWithPublisherDTO> bookWithPublisherDTOS1) {
        this.bId = bId;
        this.bName = bName;
        this.copies = copies;
        this.publisherDTOS1 = publisherDTOS1;
        this.authorDTOS1 = authorDTOS1;
        this.bookWithAuthorDTOS1 = bookWithAuthorDTOS1;
        this.bookWithPublisherDTOS1 = bookWithPublisherDTOS1;
    }

    public BookDTO(List<AuthorDTO> authorDTOS1) {
        this.authorDTOS1=authorDTOS1;
    }

    public BookDTO(BookWithPublisherDTO bookWithPublisherDTOS1, List<PublisherDTO> publisherDTOS1) {
        this.bookWithPublisherDTOS1 = Collections.singletonList(bookWithPublisherDTOS1);
        this.publisherDTOS1=publisherDTOS1;
    }

    public BookDTO(String bId, String bName, int copies, List<AuthorDTO> authorDTOS1, List<PublisherDTO> publisherDTOS1, List<BookWithPublisherDTO> bookWithPublisherDTOS1) {
        this.bId = bId;
        this.bName = bName;
        this.copies = copies;
        this.publisherDTOS1 = publisherDTOS1;
        this.authorDTOS1 = authorDTOS1;
        this.bookWithPublisherDTOS1 = bookWithPublisherDTOS1;
    }


    public BookDTO(String bId, String bName, int copies,int availableBooks, PublisherDTO publisherDTOS, AuthorDTO authorDTOS, BookWithAuthorDTO bookWithAuthorDTOS, BookWithPublisherDTO bookWithPublisherDTOS) {
        this.bId = bId;
        this.bName = bName;
        this.copies = copies;
        this.availableBooks=availableBooks;
        this.publisherDTOS = publisherDTOS;
        this.authorDTOS = authorDTOS;
        this.bookWithAuthorDTOS = bookWithAuthorDTOS;
        this.bookWithPublisherDTOS = bookWithPublisherDTOS;
    }

    public BookDTO(int k,List<PublisherDTO> publisherDTOS1) {
        this.k=k;
        this.publisherDTOS1=publisherDTOS1;
    }

    public BookDTO(String bId, String bName, List<AuthorDTO> authorDTOS1, List<PublisherDTO> publisherDTOS1, List<BookWithPublisherDTO> bookWithPublisherDTOS1, int copies) {
        this.bId = bId;
        this.bName = bName;
        this.authorDTOS1 = authorDTOS1;
        this.publisherDTOS1 = publisherDTOS1;
        this.bookWithPublisherDTOS1 = bookWithPublisherDTOS1;
        this.copies = copies;
    }

    public BookDTO(String bId) {
       this.bId=bId;
    }

    public BookDTO(int availableBooks,String bId) {
        this.availableBooks=availableBooks;
        this.bId=bId;
        System.out.println("DTO"+this.availableBooks);

    }

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public PublisherDTO getPublisherDTOS() {
        return publisherDTOS;
    }

    public void setPublisherDTOS(PublisherDTO publisherDTOS) {
        this.publisherDTOS = publisherDTOS;
    }

    public AuthorDTO getAuthorDTOS() {
        return authorDTOS;
    }

    public void setAuthorDTOS(AuthorDTO authorDTOS) {
        this.authorDTOS = authorDTOS;
    }

    public BookWithAuthorDTO getBookWithAuthorDTOS() {
        return bookWithAuthorDTOS;
    }

    public void setBookWithAuthorDTOS(BookWithAuthorDTO bookWithAuthorDTOS) {
        this.bookWithAuthorDTOS = bookWithAuthorDTOS;
    }

    public BookWithPublisherDTO getBookWithPublisherDTOS() {
        return bookWithPublisherDTOS;
    }

    public void setBookWithPublisherDTOS(BookWithPublisherDTO bookWithPublisherDTOS) {
        this.bookWithPublisherDTOS = bookWithPublisherDTOS;
    }

//    public List<PublisherDTO> getPublisherDTOS() {
//        return publisherDTOS;
//    }
//
//    public void setPublisherDTOS(List<PublisherDTO> publisherDTOS) {
//        this.publisherDTOS = publisherDTOS;
//    }
//
//    public List<BookWithAuthorDTO> getBookWithAuthorDTOS() {
//        return bookWithAuthorDTOS;
//    }
//
//    public void setBookWithAuthorDTOS(List<BookWithAuthorDTO> bookWithAuthorDTOS) {
//        this.bookWithAuthorDTOS = bookWithAuthorDTOS;
//    }
//
//    public List<BookWithPublisherDTO> getBookWithPublisherDTOS() {
//        return bookWithPublisherDTOS;
//    }
//
//    public void setBookWithPublisherDTOS(List<BookWithPublisherDTO> bookWithPublisherDTOS) {
//        this.bookWithPublisherDTOS = bookWithPublisherDTOS;
//    }
//
//    public List<AuthorDTO> getAuthorDTOS() {
//        return authorDTOS;
//    }
//
//    public void setAuthorDTOS(List<AuthorDTO> authorDTOS) {
//        this.authorDTOS = authorDTOS;
//    }

    public List<PublisherDTO> getPublisherDTOS1() {
        return publisherDTOS1;
    }

    public void setPublisherDTOS1(List<PublisherDTO> publisherDTOS1) {
        this.publisherDTOS1 = publisherDTOS1;
    }

    public List<AuthorDTO> getAuthorDTOS1() {
        return authorDTOS1;
    }

    public void setAuthorDTOS1(List<AuthorDTO> authorDTOS1) {
        this.authorDTOS1 = authorDTOS1;
    }

    public List<BookWithAuthorDTO> getBookWithAuthorDTOS1() {
        return bookWithAuthorDTOS1;
    }

    public void setBookWithAuthorDTOS1(List<BookWithAuthorDTO> bookWithAuthorDTOS1) {
        this.bookWithAuthorDTOS1 = bookWithAuthorDTOS1;
    }

    public List<BookWithPublisherDTO> getBookWithPublisherDTOS1() {
        return bookWithPublisherDTOS1;
    }

    public void setBookWithPublisherDTOS1(List<BookWithPublisherDTO> bookWithPublisherDTOS1) {
        this.bookWithPublisherDTOS1 = bookWithPublisherDTOS1;
    }

    public int getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(int availableBooks) {
        this.availableBooks = availableBooks;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "bId='" + bId + '\'' +
                ", bName='" + bName + '\'' +
                ", copies='" + copies + '\'' +
                ", publisherDTOS1=" + publisherDTOS1 +
                ", authorDTOS1=" + authorDTOS1 +
                ", bookWithAuthorDTOS1=" + bookWithAuthorDTOS1 +
                ", bookWithPublisherDTOS1=" + bookWithPublisherDTOS1 +
                ", publisherDTOS=" + publisherDTOS +
                ", authorDTOS=" + authorDTOS +
                ", bookWithAuthorDTOS=" + bookWithAuthorDTOS +
                ", bookWithPublisherDTOS=" + bookWithPublisherDTOS +
                '}';
    }
}
