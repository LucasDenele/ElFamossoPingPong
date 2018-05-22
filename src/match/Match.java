package match;

import player.Player;

import java.util.ArrayList;
import java.util.List;

public class Match extends Thread{
	
	//Attributes
	private int id;
	private Player playerA;
	private Player playerB;
	private Player winner;
	private boolean finished;
	private boolean friendly;
	private int scorePlayerA;
	private int scorePlayerB;
	private double pointsReceivedPlayerA;
	private double pointsReceivedPlayerB;
	private List<Set> sets = new ArrayList<Set>();
	private List<String> results = new ArrayList<String>();
	
	//Constructor
	public Match(int id, Player playerA, Player playerB, boolean friendly) {
		this.setId(id);
		this.setPlayerA(playerA);
		this.setPlayerB(playerB);
		this.setFinished(false);
		this.setFriendly(friendly);
	}

	public Match(){}
	
	//Getters & Setters
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Player getPlayerA() {
		return playerA;
	}
	public void setPlayerA(Player playerA) {
		this.playerA = playerA;
	}
	public Player getPlayerB() {
		return playerB;
	}
	public void setPlayerB(Player playerB) {
		this.playerB = playerB;
	}
	public Player getWinner() {
		return winner;
	}
	public void setWinner(Player winner) {
		this.winner = winner;
	}
	public int getScorePlayerA() {
		return scorePlayerA;
	}
	public void setScorePlayerA(int scorePlayerA) {
		this.scorePlayerA = scorePlayerA;
	}
	public int getScorePlayerB() {
		return scorePlayerB;
	}
	public void setScorePlayerB(int scorePlayerB) {
		this.scorePlayerB = scorePlayerB;
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
	public double getPointsReceivedPlayerA() {
		return pointsReceivedPlayerA;
	}
	public void setPointsReceivedPlayerA(double pointsReceivedPlayerA) {
		this.pointsReceivedPlayerA = pointsReceivedPlayerA;
	}
	public double getPointsReceivedPlayerB() {
		return pointsReceivedPlayerB;
	}
	public void setPointsReceivedPlayerB(double pointsReceivedPlayerB) {
		this.pointsReceivedPlayerB = pointsReceivedPlayerB;
	}
	public List<String> getResults() {
		return results;
	}
	public void setResults(List<String> results) {
		this.results = results;
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
			this.setPointsReceivedPlayerA(this.playerB.getPoints()/this.playerA.getPoints()*Math.abs(this.getScorePlayerA() - this.getScorePlayerB()));
			//System.out.println("Match "+this.getId()+" - ReceivedP1 :"+this.getPointsReceivedPlayer1());
			//player 2
			this.setPointsReceivedPlayerB(this.playerA.getPoints()/this.playerB.getPoints()*Math.abs(this.getScorePlayerA() - this.getScorePlayerB()));
			//System.out.println("Match "+this.getId()+" - ReceivedP2 :"+this.getPointsReceivedPlayer2());
	}
<<<<<<< HEAD
		
=======
		/*
		for(String s : this.results) {
			System.out.print(s);
		}
		*/
>>>>>>> 2030774fe52ef4637ff8ce183c899de2c58ba341
		//System.out.println("				Results Match "+this.getId()+"  Winner "+this.getWinner().getName()+" : "+this.getScorePlayer1()+" to "+this.getScorePlayer2());
	}
	
	public void newSet(int id) {
		Set currentSet = new Set(id, this.playerA, this.playerB);
		
		currentSet.runSet();
		
		//check who is the winner of the current set
		if(currentSet.getWinner() == this.playerA) {
			//System.out.println(this.player1.getName()+" wins the set");
			this.scorePlayerA += 1; 
		}
		else if(currentSet.getWinner() == this.playerB) {
			//System.out.println(this.player2.getName()+" wins the set");
			this.scorePlayerB += 1; 
		}
		else {
			System.out.println("No body wins the set");
		}
		
		//Case if a player has endurance = 0
		if(currentSet.isConcede()) {
			this.setFinished(true);
		}
		
		this.results.add(currentSet.getScorePlayerA()+"-"+currentSet.getScorePlayerB());	
		
		//Winner conditions
		//P1 Wins the game
		if(this.scorePlayerA > 2 && this.scorePlayerA - this.scorePlayerB >= 2) {
			this.setWinner(playerA);
			this.setFinished(true);
		}
		//P2 Wins the game
		else if(this.scorePlayerB > 2 && this.scorePlayerB - this.scorePlayerA >= 2) {
			this.setWinner(playerB);
			this.setFinished(true);
		}
		
		sets.add(currentSet);
	}
	
}
