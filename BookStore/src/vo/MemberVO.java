package vo;

public class MemberVO {
    private int memberNum;  //회원번호
    private String memberName; //책이름
    private String memberTel; //회원전화번호
    private String memberId; //회원아이디

    public MemberVO(){

    }
    public MemberVO(int memberNum, String memberName, String memberTel,String memberId){
        this.memberNum=memberNum;
        this.memberName=memberName;
        this.memberTel=memberTel;
        this.memberId=memberId;
    }

    public int getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(int memberNum) {
        this.memberNum = memberNum;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberTel() {
        return memberTel;
    }

    public void setMemberTel(String memberTel) {
        this.memberTel = memberTel;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}

