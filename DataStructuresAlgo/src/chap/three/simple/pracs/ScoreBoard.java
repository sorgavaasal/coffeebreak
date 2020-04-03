package chap.three.simple.pracs;

/**
 * Simple datastructure created to store a list 
 * of scores and the name of the player in descending order
 * @author Sridhar Raman
 *
 */

public class ScoreBoard {
	
	private int numOfEntries = 0;
	private GameEntry[] scoreList;
	
	public ScoreBoard(int capacity) {
		scoreList = new GameEntry[capacity];
	}
	
	/**
	 * makes an entry in the scoreList array in descending order. 
	 * @param entry
	 */
	public void addEntry(GameEntry entry) {
		long newScore = entry.getPlayerScore();
		
		if (numOfEntries < scoreList.length || newScore > scoreList[numOfEntries - 1].getPlayerScore()) {
			if (numOfEntries < scoreList.length) {
				numOfEntries++;
			}
			int j = numOfEntries -1;

			while (j > 0 && scoreList[j-1].getPlayerScore() < newScore) {
				scoreList[j] = scoreList[j-1];
				j--;
			}
			scoreList[j] = entry;
		}
	}
	
	/**
	 * takes an index position for the scoreList
	 * and removes it from the array and reorder the array
	 * accordingly 
	 * @param i
	 * @return
	 */
	public GameEntry removeEntry(int i) {

		if (i < 0 || i > scoreList.length) {
			throw new IndexOutOfBoundsException(" incorrect index entry " + i);
		}

		GameEntry entry = scoreList[i];

		for (int j = i; j < numOfEntries - 1; ++j) {
			scoreList[j] = scoreList[j - 1];
		}
		scoreList[numOfEntries - 1] = null;
		numOfEntries--;
		return entry;
	}

}
