package match;

import player.Player;

public class Set {
	
	//Attributes
	private Player playerA;
	private Player playerB;
	private int scorePlayerA;
	private int scorePlayerB;
	private boolean finished;
	private Player winner;
	
	//Constructor
	public Set(Player playerA, Player playerB) {
		this.setPlayerA(playerA);
		this.setPlayerB(playerB);
		this.setFinished(false);
		this.setScorePlayerA(0);
		this.setScorePlayerB(0);
	}

	public Set() {
		super();
	}

	//Getters & Setters
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
	public Player getWinner() {
		return winner;
	}
	public void setWinner(Player winner) {
		this.winner = winner;
	}
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}


	//Functions
	public Player runSet() {
		while(!this.isFinished()) {
			runPoint();
		}
		return getWinner();
	}
	
	public void runPoint() {

		this.playerA.setEndurance(this.playerA.getEndurance()-(this.playerA.getPower()/100));
		this.playerB.setEndurance(this.playerB.getEndurance()-(this.playerB.getPower()/100));

		//check concede
		if(this.playerA.getEndurance() <= 0) {
			this.setWinner(this.playerB);
			setScorePlayerB(11);
			this.setFinished(true);
		}
		if(this.playerB.getEndurance() <= 0) {
			this.setWinner(this.playerA);
			setScorePlayerA(11);
			this.setFinished(true);
		}

		//Calculate who wins the point
		float valPlayerA = 0;
		float valPlayerB = 0;

		if(this.playerA.getEndurance()>0) {
			valPlayerA = this.playerA.getPower()/(100-this.playerA.getEndurance())*randInt();
		}
		if(this.playerB.getEndurance()>0) {
			valPlayerB = this.playerB.getPower() / (100 - this.playerB.getEndurance()) * randInt();
		}
		if(valPlayerA > valPlayerB) {
			this.scorePlayerA += 1;
		}
		else if(valPlayerA < valPlayerB) {
			this.scorePlayerB += 1;
		}
		
		//Winner conditions
		//P1 Wins the set
		if((this.scorePlayerA > 10 && this.scorePlayerA - this.scorePlayerB >= 2) || getScorePlayerA() == 21) {
			this.setWinner(playerA);
			this.setFinished(true);
		}
		//P2 Wins the set
		if((this.scorePlayerB > 10 && this.scorePlayerB - this.scorePlayerA >= 2) || getScorePlayerB() == 21) {
			this.setWinner(playerB);
			this.setFinished(true);
		}
	}

	private int randInt() {
		//random integer 0 to 100
		return (int)(Math.random()*101);
	}

	public void resetSet(){
		setFinished(false);
		setScorePlayerA(0);
		setScorePlayerB(0);
	}
	
}
