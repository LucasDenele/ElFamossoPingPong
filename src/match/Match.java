package match;

import AccessBDD.AccessBDD;
import javafx.util.Pair;
import player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Match extends Thread{
	
	//Attributes
	private Player playerA;
	private Player playerB;
	private Player winner;
	private boolean finished;
	private boolean autoplay;
	private boolean friendly;
	private int setScorePlayerA = 0;
	private int setScorePlayerB = 0;
	private Set currentSet;
	private double rondPointsPlayersFactor;
	private Player winnerSet;
	private Set setToUse;
	private List<String> results = new ArrayList<String>();
	
	//Constructor
	public Match(){
		super();
	}

	public Match(Player playerA, Player playerB, double rondPointsPlayersFactor, boolean friendly) {
		setPlayerA(playerA);
		setPlayerB(playerB);
		setRondPointsPlayersFactor(rondPointsPlayersFactor);
		setFriendly(friendly);
		setToUse = new Set(getPlayerA(), getPlayerB());
	}

	//Getters & Setters

	public void setSetToUse() {
		setToUse = new Set(getPlayerA(), getPlayerB());
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
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	public boolean isAutoplay() {
		return autoplay;
	}
	public void setAutoplay(boolean autoplay) {
		this.autoplay = autoplay;
}
	public void setFriendly(boolean friendly) {
		this.friendly = friendly;
	}
	public int getSetScorePlayerA() {
		return setScorePlayerA;
	}
	public int getSetScorePlayerB() {
		return setScorePlayerB;
	}
	public double getRondPointsPlayersFactor() {
		return rondPointsPlayersFactor;
	}
	public void setRondPointsPlayersFactor(double rondPointsPlayersFactor) {
		this.rondPointsPlayersFactor = rondPointsPlayersFactor;
	}
	public List<String> getResults() {
		return results;
	}

	@Override
	public void run() {
		Player playerWinner;
		while(getSetScorePlayerA() < 3 && getSetScorePlayerB() < 3){
			playerWinner = setToUse.runSet();
			if(playerWinner == getPlayerA()){
				setScorePlayerA++;
			}else{
				setScorePlayerB++;
			}
			results.add(setToUse.getScorePlayerA()+" - "+setToUse.getScorePlayerB());
			setToUse.resetSet();
		}

		if(setScorePlayerA == 3) setWinner(getPlayerA());
		if(setScorePlayerB == 3) setWinner(getPlayerB());

		setFinished(true);

		if(getWinner() == getPlayerA()){
			getPlayerA().setPoints(getPlayerA().getPoints()
									+ getRondPointsPlayersFactor()
									* Math.abs(setScorePlayerA - setScorePlayerB)
									* getPlayerB().getPoints()/getPlayerA().getPoints());

			getPlayerB().setPoints(getPlayerB().getPoints()
					+ getRondPointsPlayersFactor()
					* Math.abs(setScorePlayerA - setScorePlayerB)
					* getPlayerA().getPoints()/getPlayerB().getPoints());


		}else{
			getPlayerA().setPoints(getPlayerA().getPoints()
					+ getRondPointsPlayersFactor()
					* Math.abs(setScorePlayerA - setScorePlayerB)
					* getPlayerB().getPoints()/getPlayerA().getPoints());

			getPlayerB().setPoints(getPlayerB().getPoints()
					+ getRondPointsPlayersFactor()
					* Math.abs(setScorePlayerA - setScorePlayerB)
					* getPlayerA().getPoints()/getPlayerB().getPoints());
		}
	}

	public void runManual(){
		if(!isFinished()){
			if(!setToUse.isFinished()){
				setToUse.runPoint();
				if(setScorePlayerB+setScorePlayerA == results.size()){
					results.add(setToUse.getScorePlayerA()+" - "+setToUse.getScorePlayerB());
				}else{
					results.set(setScorePlayerB+setScorePlayerA, setToUse.getScorePlayerA()+" - "+setToUse.getScorePlayerB());
				}
			}else{
				winnerSet = setToUse.getWinner();
				if(winnerSet == playerA){
					setScorePlayerA++;
				}else{
					setScorePlayerB++;
				}
				setToUse.resetSet();
			}
			if(setScorePlayerA == 3){
				setWinner(getPlayerA());
				setFinished(true);
			}
			if(setScorePlayerB == 3){
				setWinner(getPlayerB());
				setFinished(true);
			}
		}
	}
}
