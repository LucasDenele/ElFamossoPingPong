package match;

import player.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
	
	//Attributes
	private Player player1;
	private Player player2;
	private int scorePlayer1;
	private int scorePlayer2;
	private List<Set> sets = new ArrayList<Set>();
	
	//Constructor
	public Game(Player player1, Player player2) {
		this.setPlayer1(player1);
		this.setPlayer2(player2);
	}
	
	//Getters & Setters
	public Player getPlayer1() {
		return player1;
	}
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
	public Player getPlayer2() {
		return player2;
	}
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	public int getScorePlayer1() {
		return scorePlayer1;
	}
	public void setScorePlayer1(int scorePlayer1) {
		this.scorePlayer1 = scorePlayer1;
	}
	public int getScorePlayer2() {
		return scorePlayer2;
	}
	public void setScorePlayer2(int scorePlayer2) {
		this.scorePlayer2 = scorePlayer2;
	}
	public List<Set> getSets() {
		return sets;
	}
	public void setSets(List<Set> sets) {
		this.sets = sets;
	}
}
