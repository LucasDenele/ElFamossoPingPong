package match;

import java.util.ArrayList;
import java.util.List;

import player.Player;

public class Game {
	
	//Attributes
	private int id;
	private Player player1;
	private Player player2;
	private Player winner;
	private boolean finished;
	private int scorePlayer1;
	private int scorePlayer2;
	private List<Set> sets = new ArrayList<Set>();
	
	//Constructor
	public Game(int id, Player player1, Player player2) {
		this.setId(id);
		this.setPlayer1(player1);
		this.setPlayer2(player2);
		this.setFinished(false);
	}
	
	//Getters & Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public void start() {
		int i = 0;
		
		while(!isFinished()) {
		startNewSet(i);
		i++;
		}
		
		//print of the results
		for(Set s : sets) {
			System.out.println("Set "+s.getId()+" Winner: "+s.getWinner().getName());
		}
		System.out.print("	ID Game : "+this.getId());
		System.out.println(" Winner game : "+this.getWinner().getName()+" "+this.getScorePlayer1()+" to "+this.getScorePlayer2());
	}
	
	public void startNewSet(int id) {
		Set currentSet = new Set(id, this.player1, this.player2);
		currentSet.run();
		
		//check who is the winner of the current set
		if(currentSet.getWinner() == this.player1) {
			System.out.println(this.player1.getName()+" wins the set");
			this.scorePlayer1 += 1; 
		}
		else if(currentSet.getWinner() == this.player2) {
			System.out.println(this.player2.getName()+" wins the set");
			this.scorePlayer2 += 1; 
		}
		else {
			System.out.println("No body wins the set");
		}
		
		//Case if a player has endurance = 0
		if(currentSet.isConcede()) {
			this.setFinished(true);
		}
		
		//Winner conditions
		//P1 Wins the game
		if(this.scorePlayer1 > 2 && this.scorePlayer1 - this.scorePlayer2 >= 2) {
			this.setFinished(true);
			this.setWinner(player1);
		}
		//P2 Wins the game
		else if(this.scorePlayer2 > 2 && this.scorePlayer2 - this.scorePlayer1 >= 2) {
			this.setFinished(true);
			this.setWinner(player2);
		}
		
		System.out.println("____________________________________________________________");
		sets.add(currentSet);
	}
}
