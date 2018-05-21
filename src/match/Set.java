package match;

import player.Player;

public class Set {
	
	//Attributes
	private int id;
	private Player player1;
	private Player player2;
	private int scorePlayer1;
	private int scorePlayer2;
	private boolean finished;
	private Player winner;
	private boolean concede;
	
	//Constructor
	public Set(int id, Player player1, Player player2) {
		this.setId(id);
		this.setPlayer1(player1);
		this.setPlayer2(player2);
		this.setConcede(false);
		this.setFinished(false);
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
	
	public void runSet() {
		while(!this.isFinished()) {
			runPoint();
		}
		
		//Print results
		//System.out.println("	Winner: "+this.winner.getName()+" score "+this.getScorePlayer1()+" to "+this.getScorePlayer2());
		//System.out.println("--------------------------------------------------------------------");
	}
	/*
	public int[] runSet() {
		while(!this.isFinished()) {
			runPoint();
		}
		
		//Print results
		//System.out.println("score "+this.getScorePlayer1()+" to "+this.getScorePlayer2());
		
		//System.out.println("--------------------------------------------------------------------");
		int[] tmp = new int[2];
		tmp[0] = this.getScorePlayer1();
		tmp[1] = this.getScorePlayer2();
		return tmp;
	}
	*/
	
	private void runPoint() {
		//endurance decrease 
		this.player1.setEndurance(this.player1.getEndurance()-(this.player1.getPower()/100));
		this.player2.setEndurance(this.player2.getEndurance()-(this.player2.getPower()/100));
		
		//System.out.println("	endurance P1 "+this.player1.getEndurance()+" P2 "+this.player2.getEndurance());
		
		//check concede
		if(this.player1.getEndurance() <= 0) {
			this.setConcede(true);
			this.setFinished(true);
			this.setWinner(this.player2);
			System.out.println("P1 has conceded");
		}
		if(this.player2.getEndurance() <= 0) {
			this.setConcede(true);
			this.setFinished(true);
			this.setWinner(this.player1);
			System.out.println("P2 has conceded");
		}
		
		//Calculate who wins the point
		float valPlayer1 = this.player1.getPower()/(100-this.player1.getEndurance())*randInt();
		float valPlayer2 = this.player2.getPower()/(100-this.player2.getEndurance())*randInt();
		
		if(valPlayer1 > valPlayer2) {
			//case 1
			//System.out.println(this.player1.getName()+" wins the point");
			this.scorePlayer1 += 1; 
		}
		else if(valPlayer1 < valPlayer2) {
			//case 2
			//System.out.println(this.player2.getName()+" wins the point");
			this.scorePlayer2 += 1;
		}
		else {
			System.out.println("No body wins the point");
		}
		
		//Winner conditions
		//P1 Wins the set
		if(this.scorePlayer1 > 3 && this.scorePlayer1 - this.scorePlayer2 >= 2) {
			this.setFinished(true);
			this.setWinner(player1);
		}
		//P2 Wins the set
		else if(this.scorePlayer2 > 3 && this.scorePlayer2 - this.scorePlayer1 >= 2) {
			this.setFinished(true);
			this.setWinner(player2);
		}
	}
	
	private int randInt() {
		//random integer 0 to 100
		return (int)(Math.random()*101);
	}
	
}
