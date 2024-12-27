package vo;

public class BookVO {

    private int bookNum; // 책 번호
    private String bookName; // 책이름
    private String bookAuthor; // 책 저자
    private String bookPublish; // 출판사
    private int bookPrice; // 책 가격

    public BookVO(){

    }
    public BookVO(int bookNum, String bookName, String bookAuthor, String bookPublish, int bookPrice){
        this.bookNum=bookNum;
        this.bookName=bookName;
        this.bookAuthor = bookAuthor;
        this.bookPublish=bookPublish;
        this.bookPrice = bookPrice;
    }

    @Override
    public String toString() {
        return bookNum +"\t"+ bookName +"\t"+ bookAuthor +"\t"+ bookPublish +"\t"+ bookPrice;
    }

    public int getBookNum() {
        return bookNum;
    }

    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublish() {
        return bookPublish;
    }

    public void setBookPublish(String bookPublish) {
        this.bookPublish = bookPublish;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

}
