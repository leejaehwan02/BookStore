package data;

import vo.BookVO;

import java.util.HashMap;

public class BookDataSet {
    public static HashMap<String, BookVO> BookList = new HashMap<String, BookVO>();

    public BookDataSet() {

    }

    public static void setBookList() {
        BookList.put("소년이 온다", new BookVO(1, "소년이 온다", "한강", "창비", 13500));
        BookList.put("채식주의자", new BookVO(2, "채식주의자", "한강", "창비", 13300));
        BookList.put("작별하지 않는다", new BookVO(3, "작별하지 않는다", "한강", "문학동네", 15120));
        BookList.put("흔한남매 18", new BookVO(4, "흔한남매 18", "백난도", "미래엔아이세움", 14220));
        BookList.put("작은 땅의 야수들", new BookVO(5, "작은 땅의 야수들", "김주혜", "다산책방", 16200));
        BookList.put("어른의 행복은 조용하다", new BookVO(6, "어른의 행복은 조용하다", "태수", "페이지2북스", 16020));
        BookList.put("흰", new BookVO(7, "흰", "한강", "문학동네", 16020));
        BookList.put("트렌드 코리아 2025", new BookVO(8, "트렌드 코리아 2025", "김난도", "미래의창", 18000));
        BookList.put("서랍에 저녁을 넣어 두었다", new BookVO(9, "서랍에 저녁을 넣어 두었다", "한강", "문학과지성사", 10800));
        BookList.put("해커스 토익 기출 보카", new BookVO(10, "해커스 토익 기출 보카", "David Cho", "해커스어학연구소", 11610));
    }
}