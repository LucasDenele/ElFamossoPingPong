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
	private boolean autoplay;
	private boolean friendly;
	private int scorePlayerA;
	private int scorePlayerB;
	private Set currentSet;
	private double pointsReceivedPlayerA;
	private double pointsReceivedPlayerB;
	private List<Set> sets = new ArrayList<Set>();
	private List<String> results = new ArrayList<String>();
	
	//Constructor
	public Match(){}
	public Match(int id, Player playerA, Player playerB, boolean friendly) {
		this.setId(id);
		this.setPlayerA(playerA);
		this.setPlayerB(playerB);
		this.setFinished(false);
		this.setAutoplay(true);
		this.setFriendly(friendly);
		this.setScorePlayerA(0);
		this.setScorePlayerB(0);
	}

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
	public boolean isAutoplay() {
		return autoplay;
	}
	public void setAutoplay(boolean autoplay) {
		this.autoplay = autoplay;
	}
	public Set getCurrentSet() {
		return currentSet;
	}
	public void setCurrentSet(Set currentSet) {
		this.currentSet = currentSet;
	}

	@Override
	public void run() {
		if(autoplay){
			int i = 0;
			//System.out.println("	Match "+this.getId()+" : "+this.player1.getName()+" VS "+this.player2.getName());
			while(!isFinished()) {
				newSet(i);
				i++;
			}
		}
		else{
			//runManual();
		}

		if(!isFriendly()) {
			//Player 1
			this.setPointsReceivedPlayerA(this.playerB.getPoints()/this.playerA.getPoints()
					*Math.abs(this.getScorePlayerA() - this.getScorePlayerB()));
			//System.out.println("Match "+this.getId()+" - ReceivedP1 :"+this.getPointsReceivedPlayer1());
			//player 2
			this.setPointsReceivedPlayerB(this.playerA.getPoints()/this.playerB.getPoints()
					*Math.abs(this.getScorePlayerA() - this.getScorePlayerB()));
			//System.out.println("Match "+this.getId()+" - ReceivedP2 :"+this.getPointsReceivedPlayer2());
		}
	}

	public void runManual(){
		if(!isFinished()) {
			if (sets.isEmpty()) {
				newSet(0);
			}

			if (!currentSet.isFinished()) {
				currentSet.runPoint();
				if (currentSet.isFinished()) {
					//System.out.println("A: " + currentSet.getScorePlayerA() + " B:" + currentSet.getScorePlayerB());
					checkWinner();
				}
			} else {
				checkWinner();
			}

			if (!this.isFinished() && currentSet.isFinished()) {
				newSet(sets.size());
			} else if (this.isFinished()) {
				//System.out.println("fin");
				if(!isFriendly()) {
					//Player 1
					this.setPointsReceivedPlayerA(this.playerB.getPoints()/this.playerA.getPoints()
							*Math.abs(this.getScorePlayerA() - this.getScorePlayerB()));
					//player 2
					this.setPointsReceivedPlayerB(this.playerA.getPoints()/this.playerB.getPoints()
							*Math.abs(this.getScorePlayerA() - this.getScorePlayerB()));
				}
			}
		}
		else {
			System.out.println("Match already terminated");
		}
	}
	
	public void newSet(int id) {
		currentSet = new Set(id, this.playerA, this.playerB);

		if(autoplay){
			currentSet.runSet();
		}
		checkWinner();

	}

	public void checkWinner(){
		//check who is the winner of the current set
		if(currentSet.getWinner() == this.playerA) {
			//System.out.println(this.playerA.getLastName()+" wins the set");
			this.scorePlayerA += 1;
		}
		else if(currentSet.getWinner() == this.playerB) {
			//System.out.println(this.playerB.getLastName()+" wins the set");
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

		//if(currentSet.getWinner() != null)
		sets.add(currentSet);
	}
}
