package process;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import data.BookDataSet;
import login.Login;
import data.MemberDataSet;
import vo.BookVO;
import vo.MemberVO;

public class BookStart {
    Scanner scan = new Scanner(System.in);

    public BookStart() {

    }

    public void start() {

        BookDataSet.setBookList();
        MemberDataSet.setMemberList();

        //아이디와 비밀번호를 입력받아 로그인 구현하기
        Login.id = conInput("아이디");
        Login.pwd = conInput("비밀번호");
        Login.num = intInput("관리자면 1번 일반회원이면 2번을 입력하세요");

        while (true) {
            if (Login.login() && Login.id.equals("user")) { // 일반 회원

                System.out.println("===================회원 프로그램===================");
                String menu = conInput("메뉴[1.책 목록, 2.책 검색, 3.로그아웃, 0.프로그램종료]");
                System.out.println("=================================================");
                if (menu.equals("0")) { // 프로그램 종료
                    break;
                } else if (menu.equals("1")) { // 책 목록
                    bookOutput();

                } else if (menu.equals("2")) { // 책검색
                    bookSearch();

                } else if (menu.equals("3")) { // 로그아웃
                    start();
                }
                System.out.println("");

            } else if (Login.login() && Login.id.equals("master")) { // 관리자
                System.out.println("================================================관리자 프로그램====================================================");
                String menu = conInput("메뉴[1.책 목록, 2.책 등록 , 3.책 수정, 4.책 삭제, 5.회원 목록 6.회원 등록 7.회원 수정 8. 회원 삭제 9.로그아웃, 0.프로그램종료]");
                System.out.println("================================================================================================================");
                if (menu.equals("0")) { // 프로그램종료
                    break;
                } else if (menu.equals("1")) { // 책 목록
                    bookOutput();
                } else if (menu.equals("2")) { // 책 등록
                    bookInsert();
                } else if (menu.equals("3")) { // 책 수정
                    bookEdit();
                } else if (menu.equals("4")) { // 책 삭제
                    bookDel();
                } else if (menu.equals("5")) { // 회원 목록
                    memberOutput();
                } else if (menu.equals("6")) { // 회원 등록
                    memberInsert();
                } else if (menu.equals("7")) { // 회원 수정
                    memberEdit();
                } else if (menu.equals("8")) { // 회원 삭제
                    memberDel();
                } else if (menu.equals("9")) { // 로그아웃
                    start();
                }
                System.out.println("");
            } else { // 로그인 실패시
                System.out.println("잘못 입력하셨습니다.");
                break;
            }
        }
    }

    // 회원 기능영역
    // 책 검색
    public void bookSearch() {
        String bookName = conInput("찾고싶은 책 이름를 검색하세요");

        //BookVO vo = BookDataSet.BookList.get(bookName);

        Set<String> keys = BookDataSet.BookList.keySet();
        Iterator<String> ii = keys.iterator();
        int cnt=0;
        while (ii.hasNext()){
            String k = ii.next();
            if(k.indexOf(bookName)>=0){
                BookVO vo = BookDataSet.BookList.get(k);
                System.out.println(vo.toString());
                cnt++;
            }
        }
        if(cnt==0){
            System.out.println("해당 이름의 책은 없습니다.");
        }

    }

    // 관리자 책 관리
    // 책 목록
    public void bookOutput() {
        Set<String> keyList = BookDataSet.BookList.keySet();
        Iterator<String> ii = keyList.iterator();
        while (ii.hasNext()) {
            BookVO vo = BookDataSet.BookList.get(ii.next());
            System.out.printf("%-5d\t%-20s\t%-10s\t%-15s\t%-10d\t\n", vo.getBookNum(), vo.getBookName(), vo.getBookAuthor(), vo.getBookPublish(), vo.getBookPrice());
        }
    }

    // 책 등록
    public void bookInsert() {
        try {
            int bookNum = Integer.parseInt(conInput("책번호"));
            String bookName = conInput("책이름");
            String bookAuthor = conInput("책저자");
            String bookPublish = conInput("출판사");
            int bookPrice = intInput("책가격");

            BookDataSet.BookList.put(bookName, new BookVO(bookNum, bookName, bookAuthor, bookPublish, bookPrice));
        } catch (NumberFormatException ne) {
            System.out.println("잘못입력하셨습니다. 다시 시도해주세요");
        }
    }

    // 책 수정
    public void bookEdit() {
        // 책 이름
        String bookName = conInput("책이름");
        // 해당 책의 정보가 없을 때
        BookVO vo = BookDataSet.BookList.get(bookName);
        if (vo == null) {
            System.out.println("존재하지 않는 책입니다.");
        } else { // 해당 책의 정보가 있을 때
            // 책 이름, 작가
            String subMenu = conInput("수정할 필드 선택[1.작가, 2.출판사]");
            if (subMenu.equals("1")) {
                String author = conInput("수정할 작가");
                vo.setBookAuthor(author);
            } else if (subMenu.equals("2")) {
                String publish = conInput("수정할 출판사");
                vo.setBookPublish(publish);
            }
        }
    }

    // 책 삭제
    public void bookDel() {
        String bookName = conInput("삭제할 책 이름");
        BookVO vo = BookDataSet.BookList.get(bookName);
        if (vo == null) {
            System.out.println("책 이름을 잘못 입력하셨습니다.");
        } else {
            BookDataSet.BookList.remove(bookName);
            System.out.println("삭제되었습니다.");
        }
        System.out.println("================================================================================================================");
        bookOutput();
    }

    // 관리자 회원관리
    // 회원 목록
    public void memberOutput() {
        Set<String> keyList = MemberDataSet.MemberList.keySet();
        Iterator<String> ii = keyList.iterator();
        while (ii.hasNext()) {
            MemberVO vo = MemberDataSet.MemberList.get(ii.next());
            System.out.printf("%d\t %s\t %s\t %s\t \n", vo.getMemberNum(), vo.getMemberName(), vo.getMemberTel(), vo.getMemberId());
        }
    }

    // 회원 등록
    public void memberInsert() {
        try {
            int num = Integer.parseInt(conInput("회원번호"));
            String name = conInput("회원이름");
            String tel = conInput("회원전화번호");
            String id = conInput("회원아이디");
            int charge = 0;

            MemberDataSet.MemberList.put(name, new MemberVO(num, name, tel, id));
        } catch (NumberFormatException ne) {
            System.out.println("잘못입력하셨습니다. 다시 시도해주세요");
        }
    }

    // 회원 수정
    public void memberEdit() {
        // 회원명
        String memberName = conInput("회원명");
        MemberVO vo = MemberDataSet.MemberList.get(memberName);
        if (vo == null) { // 해당 회원의 정보가 없을 때
            System.out.println("존재하지않는 회원입니다.");
        } else { // 해당 회원의 정보가 있을 때
            // 회원 번호, 이름, 전화번호, 아이디
            String subMenu = conInput("수정할 필드 선택[1.회원전화번호, 2.회원아이디]");
            if (subMenu.equals("1")) {
                String Tel = conInput("수정할 회원전화번호");
                vo.setMemberTel(Tel);
            } else if (subMenu.equals("2")) {
                String Id = conInput("수정할 회원아이디");
                vo.setMemberId(Id);
            }
        }
    }

    // 회원 삭제
    public void memberDel() {
        String memberNameName = conInput("삭제할 회원이름");
        MemberDataSet.MemberList.remove(memberNameName);
        memberOutput();
    }

    //콘솔에서 문자를 입력받아 리턴하는 메소드
    public String conInput(String msg) {
        System.out.print(msg + "=");
        return scan.nextLine();// 소년이 온다
    }

    //콘솔에서 인트형 입력받아 리턴하는 메소드
    public int intInput(String msg) {
        System.out.print(msg + "=");
        return scan.nextInt();
    }
}