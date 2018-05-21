package ress;

import java.util.List;

import match.Set;
import player.Player;

public class MatchSave {
	//Attributes
	private int idMatch ;
	private Player player1;
	private Player player2;
	private Player winner;
	private List<Set> results;
	
	//Constructor
	public MatchSave(int id, Player p1, Player p2) {
		this.setIdMatch(id);
		this.setPlayer1(p1);
		this.setPlayer2(p2);
	}
	
	//Getters & Setters
	public int getIdMatch() {
		return idMatch;
	}
	public void setIdMatch(int idMatch) {
		this.idMatch = idMatch;
	}
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
	public Player getWinner() {
		return winner;
	}
	public void setWinner(Player winner) {
		this.winner = winner;
	}
	public List<Set> getResults() {
		return results;
	}
	public void setResults(List<Set> results) {
		this.results = results;
	}
	
	public void addResults(Set s) {
		this.results.add(s);
	}
	
	public void generateSave() {
		//TO DO
			//List<Set> to String[]
	}

}