package wipro.day5.Maps;

public class Game implements Comparable<Game> {
	
	private Integer gRank;
	private String gName;
	
	public Integer gRank() {
		return gRank;
	}
	
	
	public Integer getgRank() {
		return gRank;
	}


	public void setgRank(Integer gRank) {
		this.gRank = gRank;
	}


	public String getgName() {
		return gName;
	}


	public void setgName(String gName) {
		this.gName = gName;
	}


	public Game(Integer gRank, String gName) {
		super();
		this.gRank = gRank;
		this.gName = gName;
	}
	
	public Game()
	{
		
	}
	
	@Override
	public String toString()
	{
		return gRank +  " " + gName;
	}
	
	@Override
	public int compareTo(Game o) {
		
		/*
		 * if(this.getStid()>o.getStid()) { return -4; } else if(this.getStid() <
		 * o.getStid()) { return +7; } else { return 0; }
		 */
		
		//return o.getStid().compareTo(this.getStid());
	
	     return -this.getgName().compareTo(o.getgName());
	}
 
}
