package lk.ijse.dep.entity;

import lk.ijse.dep.dto.AuthorDTO;
import lk.ijse.dep.dto.BookWithAuthorDTO;
import lk.ijse.dep.dto.BookWithPublisherDTO;
import lk.ijse.dep.dto.PublisherDTO;

import java.util.ArrayList;
import java.util.List;

public class Book extends SuperEntity {

    private String bId;
    private String bName;
    private int copies;
    private int availableBooks;


    private List<PublisherDTO> publisherDTOS = new ArrayList<>();
    private List<AuthorDTO> authorDTOS = new ArrayList<>();
    private List<BookWithAuthorDTO> bookWithAuthorDTOS = new ArrayList<>();
    private List<BookWithPublisherDTO> bookWithPublisherDTOS = new ArrayList<>();

    public Book() {
    }

    public Book(String bId, String bName, int copies,int availableBooks) {
        this.bId = bId;
        this.bName = bName;
        this.copies = copies;
        this.availableBooks=availableBooks;
    }

    public Book(String bId, String bName, int copies, List<PublisherDTO> publisherDTOS, List<AuthorDTO> authorDTOS, List<BookWithAuthorDTO> bookWithAuthorDTOS, List<BookWithPublisherDTO> bookWithPublisherDTOS) {
        this.bId = bId;
        this.bName = bName;
        this.copies = copies;
        this.publisherDTOS = publisherDTOS;
        this.authorDTOS = authorDTOS;
        this.bookWithAuthorDTOS = bookWithAuthorDTOS;
        this.bookWithPublisherDTOS = bookWithPublisherDTOS;
    }

    public Book(List<BookWithPublisherDTO> bookWithPublisherDTOS) {
        this.bookWithPublisherDTOS = bookWithPublisherDTOS;
    }

    public Book(String bId, String bName) {
        this.bId = bId;
        this.bName = bName;
    }

    public Book(int copies) {
        this.copies = copies;
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

    public List<PublisherDTO> getPublisherDTOS() {
        return publisherDTOS;
    }

    public void setPublisherDTOS(List<PublisherDTO> publisherDTOS) {
        this.publisherDTOS = publisherDTOS;
    }

    public List<AuthorDTO> getAuthorDTOS() {
        return authorDTOS;
    }

    public void setAuthorDTOS(List<AuthorDTO> authorDTOS) {
        this.authorDTOS = authorDTOS;
    }

    public List<BookWithAuthorDTO> getBookWithAuthorDTOS() {
        return bookWithAuthorDTOS;
    }

    public void setBookWithAuthorDTOS(List<BookWithAuthorDTO> bookWithAuthorDTOS) {
        this.bookWithAuthorDTOS = bookWithAuthorDTOS;
    }

    public List<BookWithPublisherDTO> getBookWithPublisherDTOS() {
        return bookWithPublisherDTOS;
    }

    public void setBookWithPublisherDTOS(List<BookWithPublisherDTO> bookWithPublisherDTOS) {
        this.bookWithPublisherDTOS = bookWithPublisherDTOS;
    }

    public int getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(int availableBooks) {
        this.availableBooks = availableBooks;
    }
    @Override
    public String toString() {
        return "Book{" +
                "bId='" + bId + '\'' +
                ", bName='" + bName + '\'' +
                ", copies='" + copies + '\'' +
                ", publisherDTOS=" + publisherDTOS +
                ", authorDTOS=" + authorDTOS +
                ", bookWithAuthorDTOS=" + bookWithAuthorDTOS +
                ", bookWithPublisherDTOS=" + bookWithPublisherDTOS +
                '}';
    }
}
