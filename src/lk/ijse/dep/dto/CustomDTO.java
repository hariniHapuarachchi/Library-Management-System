package lk.ijse.dep.dto;

import java.util.List;

public class CustomDTO extends SuperDTO {

    private String issuedId;
    private String iBookId;
    private String iMemId;

    private String rId;
    private String exDate;
    private String status;
    private String issuedDate;
    private String returnDate;

    private String bId;
    private String bName;
    private int copies;
    private int availableBooks;

    private String aId;
    private String aName;

    private String pId;
    private String pName;

    private String publishDate;

    private int k;
    private int y;

    private List<ReturnBookDTO> returnBookDTOS;
    private List<AuthorDTO> authorDTOS;
    private ReturnBookDTO returnBookDTO;
    private List<BookDTO> bookDTOS;
    private List<PublisherDTO> publisherDTOS;
    private BookWithPublisherDTO bookWithPublisherDTO;
    private List<BookWithPublisherDTO> bookWithPublisherDTOS;

    public CustomDTO() {
    }

    public CustomDTO(String issuedId, String iBookId, String iMemId, String rId, String exDate, String bId, String bName, int copies, String aId, String aName, String pId, String pName, String publishDate) {
        this.issuedId = issuedId;
        this.iBookId = iBookId;
        this.iMemId = iMemId;
        this.rId = rId;
        this.exDate = exDate;
        this.bId = bId;
        this.bName = bName;
        this.copies = copies;
        this.aId = aId;
        this.aName = aName;
        this.pId = pId;
        this.pName = pName;
        this.publishDate = publishDate;
    }

    public CustomDTO(String issuedId, String iMemId,String iBookId, String returnId, List<ReturnBookDTO> returnBookDTOS) {
        this.issuedId = issuedId;
        this.iMemId = iMemId;
        this.iBookId = iBookId;
        this.rId = returnId;
        this.returnBookDTOS=returnBookDTOS;

    }

    public CustomDTO(String issuedId, String iMemId,String iBookId, List<ReturnBookDTO> returnBookDTOS) {
        this.issuedId = issuedId;
        this.iMemId = iMemId;
        this.iBookId = iBookId;
        this.returnBookDTOS=returnBookDTOS;

    }

    public CustomDTO(List<AuthorDTO> authorDTOS) {
        this.authorDTOS=authorDTOS;
    }



    public CustomDTO(String bId,String bName,String aName,String pName,String publishDate,int copies,int availableBooks) {
        this.bId=bId;
        this.bName=bName;
        this.aName = aName;
        this.pName = pName;
        this.publishDate = publishDate;
        this.copies=copies;
        this.availableBooks=availableBooks;

    }

    public CustomDTO(String issuedId,String rId,String iBookId,String bName,String iMemId,String exDate,String status,String issuedDate,int copies,int availableBooks) {
        this.issuedId=issuedId;
        this.rId=rId;
        this.iBookId = iBookId;
        this.bName = bName;
        this.iMemId = iMemId;
        this.exDate=exDate;
        this.status=status;
        this.issuedDate=issuedDate;
        this.copies=copies;
        this.availableBooks=availableBooks;


    }

    public CustomDTO(int k, List<PublisherDTO> publisherDTOS) {
        this.k=k;
        this.publisherDTOS=publisherDTOS;
    }

    public CustomDTO(String bId, String bName, int copies) {
        this.bId=bId;
        this.bName=bName;
        this.copies=copies;
    }

    public CustomDTO(int k,int y,List<BookDTO> bookDTOS) {
        this.y=y;
        this.k=k;
        this.bookDTOS=bookDTOS;
    }

    public CustomDTO(String issuedId, String iMemId,String iBookId, String exDate,String rId) {
        this.issuedId = issuedId;
        this.iMemId = iMemId;
        this.iBookId = iBookId;
        this.exDate=exDate;
        this.rId=rId;
        System.out.println(issuedId);
        System.out.println(iMemId);
        System.out.println(iBookId);
        System.out.println(exDate);
    }

    public CustomDTO(String issueId,String rId, String iMemId, String iBookId, String issuedDate, String returnDate) {
        this.issuedId = issueId;
        this.rId=rId;
        this.iMemId = iMemId;
        this.iBookId = iBookId;
        this.issuedDate=issuedDate;
        this.returnDate=returnDate;
    }

    public CustomDTO(String issueId) {
        this.issuedId = issueId;
    }

//    public CustomDTO(List<ReturnBookDTO> returnBookDTOS) {
//        this.returnBookDTOS=returnBookDTOS;
//    }



    public String getIssuedId() {
        return issuedId;
    }

    public void setIssuedId(String issuedId) {
        this.issuedId = issuedId;
    }

    public String getiBookId() {
        return iBookId;
    }

    public void setiBookId(String iBookId) {
        this.iBookId = iBookId;
    }

    public String getiMemId() {
        return iMemId;
    }

    public void setiMemId(String iMemId) {
        this.iMemId = iMemId;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public String getExDate() {
        return exDate;
    }

    public void setExDate(String exDate) {
        this.exDate = exDate;
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

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }


    public List<ReturnBookDTO> getReturnBookDTOS() {
        return returnBookDTOS;
    }

    public void setReturnBookDTOS(List<ReturnBookDTO> returnBookDTOS) {
        this.returnBookDTOS = returnBookDTOS;
    }


    public List<AuthorDTO> getAuthorDTOS() {
        return authorDTOS;
    }

    public void setAuthorDTOS(List<AuthorDTO> authorDTOS) {
        this.authorDTOS = authorDTOS;
    }

    public List<PublisherDTO> getPublisherDTOS() {
        return publisherDTOS;
    }

    public void setPublisherDTOS(List<PublisherDTO> publisherDTOS) {
        this.publisherDTOS = publisherDTOS;
    }

    public BookWithPublisherDTO getBookWithPublisherDTO() {
        return bookWithPublisherDTO;
    }

    public void setBookWithPublisherDTO(BookWithPublisherDTO bookWithPublisherDTO) {
        this.bookWithPublisherDTO = bookWithPublisherDTO;
    }

    public List<BookWithPublisherDTO> getBookWithPublisherDTOS() {
        return bookWithPublisherDTOS;
    }

    public void setBookWithPublisherDTOS(List<BookWithPublisherDTO> bookWithPublisherDTOS) {
        this.bookWithPublisherDTOS = bookWithPublisherDTOS;
    }


    public List<BookDTO> getBookDTOS() {
        return bookDTOS;
    }

    public void setBookDTOS(List<BookDTO> bookDTOS) {
        this.bookDTOS = bookDTOS;
    }


    public ReturnBookDTO getReturnBookDTO() {
        return returnBookDTO;
    }

    public void setReturnBookDTO(ReturnBookDTO returnBookDTO) {
        this.returnBookDTO = returnBookDTO;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
    }

    public int getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(int availableBooks) {
        this.availableBooks = availableBooks;
    }


    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "CustomDTO{" +
                "issuedId='" + issuedId + '\'' +
                ", iBookId='" + iBookId + '\'' +
                ", iMemId='" + iMemId + '\'' +
                ", rId='" + rId + '\'' +
                ", exDate='" + exDate + '\'' +
                ", status='" + status + '\'' +
                ", issuedDate='" + issuedDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", bId='" + bId + '\'' +
                ", bName='" + bName + '\'' +
                ", copies=" + copies +
                ", availableBooks=" + availableBooks +
                ", aId='" + aId + '\'' +
                ", aName='" + aName + '\'' +
                ", pId='" + pId + '\'' +
                ", pName='" + pName + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", k=" + k +
                ", y=" + y +
                ", returnBookDTOS=" + returnBookDTOS +
                ", authorDTOS=" + authorDTOS +
                ", returnBookDTO=" + returnBookDTO +
                ", bookDTOS=" + bookDTOS +
                ", publisherDTOS=" + publisherDTOS +
                ", bookWithPublisherDTO=" + bookWithPublisherDTO +
                ", bookWithPublisherDTOS=" + bookWithPublisherDTOS +
                '}';
    }
}
