package gmail.yskim62100.c_and_b_guidebook.domain;

public class Membertbl {
	private String memberemail;
	private String memberpassword;
	private String membername;
	private String memberphone;
	private String membernickname;
	private String membergender;
	private String memberleave;
	

	public Membertbl() {
		super();
	}
	

	public Membertbl(String memberemail, String memberpassword, String membername, String memberphone,
			String membernickname, String membergender, String memberleave) {
		super();
		this.memberemail = memberemail;
		this.memberpassword = memberpassword;
		this.membername = membername;
		this.memberphone = memberphone;
		this.membernickname = membernickname;
		this.membergender = membergender;
		this.memberleave = memberleave;
	}

	public String getMemberemail() {
		return memberemail;
	}

	public void setMemberemail(String memberemail) {
		this.memberemail = memberemail;
	}

	public String getMemberpassword() {
		return memberpassword;
	}

	public void setMemberpassword(String memberpassword) {
		this.memberpassword = memberpassword;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getMemberphone() {
		return memberphone;
	}

	public void setMemberphone(String memberphone) {
		this.memberphone = memberphone;
	}

	public String getMembernickname() {
		return membernickname;
	}

	public void setMembernickname(String membernickname) {
		this.membernickname = membernickname;
	}

	public String getMembergender() {
		return membergender;
	}

	public void setMembergender(String membergender) {
		this.membergender = membergender;
	}

	public String getMemberleave() {
		return memberleave;
	}

	public void setMemberleave(String memberleave) {
		this.memberleave = memberleave;
	}

	@Override
	public String toString() {
		return "Member [ememberemail=" + memberemail + ", memberpassword=" + memberpassword + ", membername="
				+ membername + ", memberphone=" + memberphone + ", membernickname=" + membernickname + ", membergender="
				+ membergender + ", memberleave=" + memberleave + "]";
	}

}
