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
		System.out.println("			R"+this.getId());
		
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
		
		while(!allMatchesFinished()) {
			//Waiting all matches are finished
		}
		//System.out.println("All matches terminated");
		
		for(Match m : matches) {
			
			Player tmpWinner = m.getWinner();
			Player tmpP1 = m.getPlayer1();
			Player tmpP2 = m.getPlayer2();
			
			//Update of the players statistics with the round number						
			if(m.getWinner() == m.getPlayer1()) { //P1 wins
				tmpP1.setPoints(tmpP1.getPoints()+(this.getId()+1)*m.getPointsReceivedPlayer1()/7);
				tmpP2.setPoints(tmpP2.getPoints()-(this.getId()+1)*m.getPointsReceivedPlayer2()/7);
				tmpWinner.setPoints(tmpP1.getPoints());
			}
			else if(m.getWinner() == m.getPlayer2()) { //P2 wins
				tmpP1.setPoints(tmpP1.getPoints()-(this.getId()+1)*m.getPointsReceivedPlayer1()/7);
				tmpP2.setPoints(tmpP2.getPoints()+(this.getId()+1)*m.getPointsReceivedPlayer2()/7);
				tmpWinner.setPoints(tmpP2.getPoints());
			}
			this.playersUpdate.add(tmpP1);
			this.playersUpdate.add(tmpP2);
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
	
