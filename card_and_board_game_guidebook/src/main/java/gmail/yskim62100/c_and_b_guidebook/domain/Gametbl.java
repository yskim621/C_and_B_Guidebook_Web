package gmail.yskim62100.c_and_b_guidebook.domain;

public class Gametbl {
	// trumpcard - bacara, blackjack, poker, hoola
	// hwatu - gostop, seosda
	// boardgame - go, chess, janggi, omok
	
	
	private String gamecode;
	private String gamecategory;
	private String gameinfo;
	private String gamerule;
	
	
	public Gametbl() {
		super();
	}



	public Gametbl(String gamecode, String gamecategory, String gameinfo, String gamerule) {
		super();
		this.gamecode = gamecode;
		this.gamecategory = gamecategory;
		this.gameinfo = gameinfo;
		this.gamerule = gamerule;
	}



	public String getGamecode() {
		return gamecode;
	}



	public void setGamecode(String gamecode) {
		this.gamecode = gamecode;
	}



	public String getGamecategory() {
		return gamecategory;
	}



	public void setGamecategory(String gamecategory) {
		this.gamecategory = gamecategory;
	}


	public String getGameinfo() {
		return gameinfo;
	}



	public void setGameinfo(String gameinfo) {
		this.gameinfo = gameinfo;
	}



	public String getGamerule() {
		return gamerule;
	}



	public void setGamerule(String gamerule) {
		this.gamerule = gamerule;
	}



	@Override
	public String toString() {
		return "Gametbl [gamecode=" + gamecode + ", gamecategory=" + gamecategory + ", gameinfo=" + gameinfo + ", gamerule=" + gamerule + "]";
	}
	
	
}
