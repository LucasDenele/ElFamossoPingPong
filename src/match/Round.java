package match;

import java.util.ArrayList;
import java.util.List;

import player.Player;

public class Round {
	//Attributes
	private int id;
	private boolean finished;
	private List<Match> matches = new ArrayList<Match>();
	private List<Player> players = new ArrayList<Player>();
	private List<Player> winners = new ArrayList<Player>();
	private List<Player> playersUpdate = new ArrayList<Player>();
	private List<String[]> results = new ArrayList<String[]>(); //[name, roundMax, points]
	
	//Constructor
	public Round(int id, List<Player> players/*, List<String[]> allPlayers*/) {
		this.setId(id);
		//this.setAllPlayers(allPlayers);
		this.setPlayers(players);
		setFinished(false);
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
	public List<String[]> getResults() {
		return results;
	}
	public void setResults(List<String[]> results) {
		this.results = results;
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
			
		int tmp = players.size();
		for(int i = 0; i < tmp/2; i++) {
			Match newMatch = new Match(this.getId()+i, this.players.remove(0),this.players.remove(0), false);
			matches.add(newMatch);
			newMatch.start();
		}
		
		while(!allMatchesFinished()) {
			
		}
		//System.out.println("READY");
		
		for(Match m : matches) {
			
			Player tmpWinner = m.getWinner();
			Player tmpP1 = m.getPlayer1();
			Player tmpP2 = m.getPlayer2();
			
			
						
			if(m.getWinner() == m.getPlayer1()) { //P1 wins
				tmpP1.setPoints(tmpP1.getPoints()+this.getId()*m.getPointsReceivedPlayer1()/7);
				tmpP2.setPoints(tmpP2.getPoints()-this.getId()*m.getPointsReceivedPlayer2()/7);
				tmpWinner.setPoints(tmpWinner.getPoints()+this.getId()*m.getPointsReceivedPlayer1()/7);
			}
			else if(m.getWinner() == m.getPlayer2()) { //P2 wins
				tmpP1.setPoints(tmpP1.getPoints()-this.getId()*m.getPointsReceivedPlayer1()/7);
				tmpP2.setPoints(tmpP2.getPoints()+this.getId()*m.getPointsReceivedPlayer2()/7);
				tmpWinner.setPoints(tmpWinner.getPoints()+this.getId()*m.getPointsReceivedPlayer2()/7);
			}
			this.playersUpdate.add(tmpP1);
			this.playersUpdate.add(tmpP2);
			this.winners.add(tmpWinner);
		}
		
		this.setFinished(true);
		/*
		for(Match g :matches) {
			for(int b =0; b < allPlayers.size(); b++) {
				String[] tmpPlayer = allPlayers.get(b);
				
				if(tmpPlayer[0] == g.getPlayer1().getName()) {
					
					if(g.getWinner() == g.getPlayer1()) {
						tmpPlayer[1] = Integer.toString(this.getId());
					}
					double tmpPoints = (this.getId()*g.getPlayer2().getPoints())
									/(7*g.getPlayer1().getPoints())
									*Math.abs(g.getScorePlayer1() - g.getScorePlayer2());
					
					tmpPlayer[2] = Double.toString(tmpPoints);
				}
				else if(tmpPlayer[0] == g.getPlayer2().getName()) {
					
					if(g.getWinner() == g.getPlayer2()) {
						tmpPlayer[1] = Integer.toString(this.getId());
					}
					double tmpPoints = (this.getId()*g.getPlayer1().getPoints())
							/(7*g.getPlayer2().getPoints())
							*Math.abs(g.getScorePlayer2() - g.getScorePlayer1());
					
					tmpPlayer[2] = Double.toString(tmpPoints);
				}
				allPlayers.set(b, tmpPlayer);
			}
			
		}
		*/
		
		/*
		//points win by the winner
		if(!isFriendly()) {
				setPointsReceivedPlayer1(this.player2.getPoints()/this.player1.getPoints()*Math.abs(this.getScorePlayer1() - this.getScorePlayer2()));
				setPointsReceivedPlayer2(this.player1.getPoints()/this.player2.getPoints()*Math.abs(this.getScorePlayer1() - this.getScorePlayer2()));
		}
		*/
		
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
	
