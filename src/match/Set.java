package match;

import player.Player;

public class Set {
	
	//Attributes
	private int id;
	private Player playerA;
	private Player playerB;
	private int scorePlayerA;
	private int scorePlayerB;
	private boolean finished;
	private Player winner;
	private boolean concede;
	
	//Constructor
	public Set(int id, Player playerA, Player playerB) {
		this.setId(id);
		this.setPlayerA(playerA);
		this.setPlayerB(playerB);
		this.setConcede(false);
		this.setFinished(false);
		this.setScorePlayerA(0);
		this.setScorePlayerB(0);
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isConcede() {
		return concede;
	}
	public void setConcede(boolean concede) {
		this.concede = concede;
	}
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	
	//Functions
	public void runSet() {
		while(!this.isFinished()) {
			runPoint();
		}
	}
	
	public void runPoint() {
		//endurance decrease 
		this.playerA.setEndurance(this.playerA.getEndurance()-(this.playerA.getPower()/100));
		this.playerB.setEndurance(this.playerB.getEndurance()-(this.playerB.getPower()/100));
		
		//check concede
		if(this.playerA.getEndurance() <= 0) {
			this.setConcede(true);
			this.setFinished(true);
			this.setWinner(this.playerB);
			System.out.println("PA has conceded");
		}
		if(this.playerB.getEndurance() <= 0) {
			this.setConcede(true);
			this.setFinished(true);
			this.setWinner(this.playerA);
			System.out.println("PB has conceded");
		}
		
		//Calculate who wins the point
		float valPlayerA = this.playerA.getPower()/(100-this.playerA.getEndurance())*randInt();
		float valPlayerB = this.playerB.getPower()/(100-this.playerB.getEndurance())*randInt();
		
		if(valPlayerA > valPlayerB) {
			//case 1
			this.scorePlayerA += 1;
			//System.out.println("A: "+this.scorePlayerA);
		}
		else if(valPlayerA < valPlayerB) {
			//case 2
			this.scorePlayerB += 1;
			//System.out.println("B: "+this.scorePlayerB);
		}
		else {
			System.out.println("No body wins the point");
		}
		
		//Winner conditions
		//P1 Wins the set
		if(this.scorePlayerA > 3 && this.scorePlayerA - this.scorePlayerB >= 2) {
			this.setWinner(playerA);
			this.setFinished(true);
		}
		//P2 Wins the set
		else if(this.scorePlayerB > 3 && this.scorePlayerB - this.scorePlayerA >= 2) {
			this.setWinner(playerB);
			this.setFinished(true);
		}
	}
	
	private int randInt() {
		//random integer 0 to 100
		return (int)(Math.random()*101);
	}
	
}
