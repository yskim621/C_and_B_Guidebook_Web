package gmail.yskim62100.c_and_b_guidebook.domain;

public class Replytbl {
	private int replynum;
	private String boardreply;
	private int boardnum;

	public Replytbl() {
		super();
	}

	public Replytbl(int replynum, String boardreply, int boardnum) {
		super();
		this.replynum = replynum;
		this.boardreply = boardreply;
		this.boardnum = boardnum;
	}

	public String getBoardreply() {
		return boardreply;
	}

	public void setBoardreply(String boardreply) {
		this.boardreply = boardreply;
	}

	public int getReplynum() {
		return replynum;
	}

	public int getBoardnum() {
		return boardnum;
	}

	@Override
	public String toString() {
		return "replytbl [replynum=" + replynum + ", boardreply=" + boardreply + ", boardnum=" + boardnum + "]";
	}

}
