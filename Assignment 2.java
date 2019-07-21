package toBeCompleted.stage3;

import toBeCompleted.stage1.Dice;
import toBeCompleted.stage3.ScoreSheet;
import doNotModify.clients.Turn;
import doNotModify.clients.Score;

// Utilities for the module
import java.util.ArrayList;

public class ScoreSheet {

	public ArrayList<Score> scoreTable;

	/*
	 * Constructor for ScoreSheet
	 */
	public ScoreSheet() {
		scoreTable = new ArrayList<Score>();
	}

	// Format list l as a comma separated string
	/*
	 * @param l is an ArrayList<Integer>
	 * return the list as a comma separated
	 * string.
	 * eg. The list [4, 7, 9, 11, 3] should return
	 * "4,7,9,11,3"
	 */
	public static String commaSeparated(ArrayList<Integer> l) {
		String s = "";
		for (Integer j: l ) 
             {
                    s = s + "," + j.toString();   //Returning a comma separated list
               }
                          s = s.substring(1, s.length());     //Creating a substring
		return s;
	}

	/*
	 * Calculate the total score of a player
	 * @param n is the name of the player
	 */
	public int tallyScore(String n) {
		int total=0;
		for (int r = 1; r <= 5; r++) 
   {
                 ArrayList<Turn> turns = playerRound(n, r);    
                 for (Turn t : turns) 
                {
                         if (t.getSign() == 1) 
                 {
                       total = total + t.getTotal();
                 } else 
                 {
                        total = total - t.getTotal();
         }
}
}
		return total;
	}

	/*
	 * Return a list of Turns (see doNotModify.clients.Turn)
	 * @param n is the name of the player
	 * @param r is the round
	 * The list that is returned should contain a separate 'Turn'
	 * for each time the player rolled the dice and set aside one or more dice
	 * the face values of all the dice thrown as an ArrayList<Integer>
	 * the face values of the dice set aside as an ArrayList<Integer>
	 * the total score for the turn, and finally
	 * the sign of the turn. ie. is the score to be added or subtracted?
	 */
	public ArrayList<Turn> playerRound(String n, int r) {
		ArrayList<Integer> thrown, aside;
		ArrayList<Turn> turns = new ArrayList<Turn>();
		int sign, total=0;
		for (int j = 0; j < scoreTable.size(); j++) 
{
Score sr = scoreTable.get(j);
if (n.equals(sr.getPlayer()) && r == sr.getRound()) 
{
thrown = sr.getThrown();
aside = sr.getAside();
int total = 0;
for (int k=0;k< aside.size();k++) 
{
total = total + aside.get(k);
}
total = total - gtotal;
if (sr.getTurn() % 2 != 0) 
{
sign = +1; //if score is to be added
} else 
{
sign = -1; //if score is to be subtracted
}
turns.add(new Turn(thrown, aside, total, sign));
gtotal = gtotal + total;
}
}
		return turns;
	}

	/*
	 * Log a turn in the score table for a player
	 * @param n is the name of the player
	 * @param r is the 'round'. ie. a game consists of 5 rounds
	 * each player taking 4 turns at throwing the dice before the
	 * next player has their go.
	 * @param t is the turn. ie the dice throw within a round
	 * @param k the list of dice to be kept for the next roll
	 * @param a the list of dice that the player set aside
	 */
	public void log(String n, int r, int t, ArrayList<Dice> k, ArrayList<Dice> a) {
		ArrayList<Integer> keep, aside;
		keep = new ArrayList<Integer>();
		aside = new ArrayList<Integer>();
		for (Dice die : k) 
{
keep.add(die.getValue());
}
int s = a.size();
for (int j = (r * 5) - 5; j < s; j++) 
{
aside.add(a.get(j).getValue());
}
scoreTable.add(new Score(n, r, t, keep, aside));
	}

}


