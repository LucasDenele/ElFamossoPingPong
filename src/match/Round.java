package match;

import java.util.ArrayList;
import java.util.List;

import player.Player;

public class Round {
	//Attributes
	private int id;
	private boolean finished = false;
	private List<Match> matches = new ArrayList<Match>();
	private List<Player> players = new ArrayList<Player>();
	private List<Player> winners = new ArrayList<Player>();
	private List<Player> playersUpdate = new ArrayList<Player>();
	
	//Constructor
	public Round(int id, List<Player> players) {
		this.setId(id);
		this.setPlayers(players);
	}
	
	//Getters & Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Match> getMatches() {
		return matches;
	}
	public void setMatches(List<Match> games) {
		this.matches = games;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	public List<Player> getPlayersUpdate() {
		return playersUpdate;
	}
	public void setPlayersUpdate(List<Player> players) {
		this.playersUpdate = players;
	}
	public List<Player> getWinners() {
		return winners;
	}
	public void setWinners(List<Player> allPlayers) {
		this.winners = allPlayers;
	}
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	
	public void runRound() {
		//System.out.println("			R"+this.getId());
		
		if(players.size()%2 != 0) {
			System.out.println("Error, number of players is not pair");
		}
		
		//Dispatch players in the matches
		int tmp = players.size();
		for(int i = 0; i < tmp/2; i++) {
			Match newMatch = new Match(this.getId()+i, this.players.remove(0),this.players.remove(0), false);
			matches.add(newMatch);
			newMatch.start();
		}
		
		while(!allMatchesFinished());
			//Waiting all matches are finished
		//System.out.println("All matches terminated");
		
		for(Match m : matches) {
			
			Player tmpWinner = m.getWinner();
			Player tmpPA = m.getPlayerA();
			Player tmpPB = m.getPlayerB();
			
			//Update of the players statistics with the round number						
			if(m.getWinner() == m.getPlayerA()) { //P1 wins
				//System.out.println("R"+this.getId()+" M"+m.getId()+" Before P1 "+tmpP1.getPoints());
				//System.out.println("P1 Rcv "+(this.getId()+1)*m.getPointsReceivedPlayer1()/7);
				//System.out.println("P2 Rcv "+(this.getId()+1)*m.getPointsReceivedPlayer2()/7);
				tmpPA.setPoints(tmpPA.getPoints()+(this.getId()+1)*m.getPointsReceivedPlayerA()/7);
				tmpPB.setPoints(tmpPB.getPoints()-(this.getId()+1)*m.getPointsReceivedPlayerB()/7);
				tmpWinner.setPoints(tmpPA.getPoints());
				//System.out.println("R"+this.getId()+" M"+m.getId()+" After P1 "+tmpP1.getPoints());
			}
			else if(m.getWinner() == m.getPlayerB()) { //P2 wins
				//System.out.println("R"+this.getId()+" M"+m.getId()+" Before P2 "+tmpP2.getPoints());
				//System.out.println("P1 Rcv "+(this.getId()+1)*m.getPointsReceivedPlayer1()/7);
				//System.out.println("P2 Rcv "+(this.getId()+1)*m.getPointsReceivedPlayer2()/7);
				tmpPA.setPoints(tmpPA.getPoints()-(this.getId()+1)*m.getPointsReceivedPlayerA()/7);
				tmpPB.setPoints(tmpPB.getPoints()+(this.getId()+1)*m.getPointsReceivedPlayerB()/7);
				tmpWinner.setPoints(tmpPB.getPoints());
				//System.out.println("R"+this.getId()+" M"+m.getId()+" After P2 "+tmpP2.getPoints());
			}
			this.playersUpdate.add(tmpPA);
			this.playersUpdate.add(tmpPB);
			this.winners.add(tmpWinner);
		}
		
		this.setFinished(true);
		
	}
		
	public boolean allMatchesFinished(){		
		for(Match g : matches) {
			//System.out.println(g.getId()+" Over ? "+g.isFinished());
			if(!g.isFinished()) {
				return false;
			}
		}
		return true;
	}
}
	
