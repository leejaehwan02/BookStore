package data;

import vo.MemberVO;

import java.util.HashMap;

public class MemberDataSet {

    public static HashMap<String, MemberVO> MemberList = new HashMap<String, MemberVO>();

    public MemberDataSet() {
    }

    public static void setMemberList() {
        MemberList.put("가나다", new MemberVO(1, "가나다", "010-1111-1111", "111"));
        MemberList.put("나다라", new MemberVO(2, "나다라", "010-2222-2222", "222"));
        MemberList.put("다라마", new MemberVO(3, "다라마", "010-3333-3333", "333"));
        MemberList.put("라마바", new MemberVO(4, "라마바", "010-4444-4444", "444"));
        MemberList.put("마바사", new MemberVO(5, "마바사", "010-5555-5555", "555"));
    }
}
