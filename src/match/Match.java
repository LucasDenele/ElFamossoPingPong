package match;

import player.Player;

import java.util.ArrayList;
import java.util.List;

public class Match extends Thread{
	
	//Attributes
	private int id;
	private Player player1;
	private Player player2;
	private Player winner;
	private boolean finished;
	private boolean friendly;
	private int scorePlayer1;
	private int scorePlayer2;
	private double pointsReceivedPlayer1;
	private double pointsReceivedPlayer2;
	private List<Set> sets = new ArrayList<Set>();
	
	//Constructor
	public Match(int id, Player player1, Player player2, boolean friendly) {
		this.setId(id);
		this.setPlayer1(player1);
		this.setPlayer2(player2);
		this.setFinished(false);
		this.setFriendly(friendly);
	}
	
	//Getters & Setters
	public long getId() {
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
	public boolean isFriendly() {
		return friendly;
	}
	public void setFriendly(boolean friendly) {
		this.friendly = friendly;
	}
	public double getPointsReceivedPlayer1() {
		return pointsReceivedPlayer1;
	}
	public void setPointsReceivedPlayer1(double pointsReceivedPlayer1) {
		this.pointsReceivedPlayer1 = pointsReceivedPlayer1;
	}
	public double getPointsReceivedPlayer2() {
		return pointsReceivedPlayer2;
	}
	public void setPointsReceivedPlayer2(double pointsReceivedPlayer2) {
		this.pointsReceivedPlayer2 = pointsReceivedPlayer2;
	}

	@Override
	public void run() {
		int i = 0;
		//System.out.println("	Match "+this.getId()+" : "+this.player1.getName()+" VS "+this.player2.getName());
		while(!isFinished()) {
			newSet(i);
			i++;
		}
		
		if(!isFriendly()) {
			//Player 1
			this.setPointsReceivedPlayer1(this.player2.getPoints()/this.player1.getPoints()*Math.abs(this.getScorePlayer1() - this.getScorePlayer2()));
			//System.out.println("Match "+this.getId()+" - ReceivedP1 :"+this.getPointsReceivedPlayer1());
			//player 2
			this.setPointsReceivedPlayer2(this.player1.getPoints()/this.player2.getPoints()*Math.abs(this.getScorePlayer1() - this.getScorePlayer2()));
			//System.out.println("Match "+this.getId()+" - ReceivedP2 :"+this.getPointsReceivedPlayer2());
	}
		
		//System.out.println("				Results Match "+this.getId()+"  Winner "+this.getWinner().getName()+" : "+this.getScorePlayer1()+" to "+this.getScorePlayer2());
	}
	
	public void newSet(int id) {
		Set currentSet = new Set(id, this.player1, this.player2);
		
		currentSet.runSet();
		
		//check who is the winner of the current set
		if(currentSet.getWinner() == this.player1) {
			//System.out.println(this.player1.getName()+" wins the set");
			this.scorePlayer1 += 1; 
		}
		else if(currentSet.getWinner() == this.player2) {
			//System.out.println(this.player2.getName()+" wins the set");
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
			this.setWinner(player1);
			this.setFinished(true);
		}
		//P2 Wins the game
		else if(this.scorePlayer2 > 2 && this.scorePlayer2 - this.scorePlayer1 >= 2) {
			this.setWinner(player2);
			this.setFinished(true);
		}
		
		sets.add(currentSet);
	}
	
}
