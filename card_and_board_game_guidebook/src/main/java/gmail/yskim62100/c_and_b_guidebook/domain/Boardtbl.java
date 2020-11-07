package gmail.yskim62100.c_and_b_guidebook.domain;



public class Boardtbl {
	private Integer boardnum;
	private String boardtitle;
	private String boardcontent;
	private String boardwritedate;
	private Integer boardreadcnt;
	private String boardattachment;
	private String membernickname;

	public Integer getBoardnum() {
		return boardnum;
	}

	public void setBoardnum(Integer boardnum) {
		this.boardnum = boardnum;
	}

	public String getBoardtitle() {
		return boardtitle;
	}

	public void setBoardtitle(String boardtitle) {
		this.boardtitle = boardtitle;
	}

	public String getBoardcontent() {
		return boardcontent;
	}

	public void setBoardcontent(String boardcontent) {
		this.boardcontent = boardcontent;
	}

	public String getBoardwritedate() {
		return boardwritedate;
	}

	public void setBoardwritedate(String boardwritedate) {
		this.boardwritedate = boardwritedate;
	}

	public Integer getBoardreadcnt() {
		return boardreadcnt;
	}

	public void setBoardreadcnt(Integer boardreadcnt) {
		this.boardreadcnt = boardreadcnt;
	}

	public String getBoardattachment() {
		return boardattachment;
	}

	public void setBoardattachment(String boardattachment) {
		this.boardattachment = boardattachment;
	}

	public String getMembernickname() {
		return membernickname;
	}

	public void setMembernickname(String membernickname) {
		this.membernickname = membernickname;
	}

	@Override
	public String toString() {
		return "Boardtbl [boardnum=" + boardnum + ", boardtitle=" + boardtitle + ", boardcontent=" + boardcontent
				+ ", boardwritedate=" + boardwritedate + ", boardreadcnt=" + boardreadcnt + ", boardattachment="
				+ boardattachment + ", membernickname=" + membernickname + "]";
	}

}
