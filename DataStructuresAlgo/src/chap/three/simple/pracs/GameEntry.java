package chap.three.simple.pracs;

/**
 * Simple GameEntry class, contains 
 * name of the player and the score he has taken
 * @author Sridhar Raman
 *
 */

public class GameEntry {
	
	private String playerName;
	private Long playerScore;
	
	public GameEntry(String name, long score) {
		this.playerName = name;
		this.playerScore = score;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	public Long getPlayerScore() {
		return playerScore;
	}
	
	public String toString() {
		StringBuilder returnString = new StringBuilder("[");
		returnString.append(this.playerName).append("--").append(this.playerScore).append("]");
		return returnString.toString();
	}

}
