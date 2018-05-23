package match;

import java.util.ArrayList;
import java.util.List;

import player.Player;

public class Round {
	//Attributes
	private double roundPlayerFactor;
	private  String roundName;
	private List<Match> matches = new ArrayList<Match>();
	private List<Player> players = new ArrayList<Player>();
	private List<Player> winners = new ArrayList<Player>();
	
	//Constructor
	public Round(double roundPlayerFactor, String roundName, List<Player> players) {
		setRoundPlayerFactor(roundPlayerFactor);
		setRoundName(roundName);
		setPlayers(players);
	}
	public Round(){}

	//Getters & Setters

	public double getRoundPlayerFactor() {
		return roundPlayerFactor;
	}
	private void setRoundPlayerFactor(double roundPlayerFactor) {
		this.roundPlayerFactor = roundPlayerFactor;
	}
	public String getRoundName() {
		return roundName;
	}
	private void setRoundName(String roundName) {
		this.roundName = roundName;
	}
	public List<Match> getMatches() {
		return matches;
	}
	private void setPlayers(List<Player> players) {
		this.players = players;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public List<Player> getWinners() {
		return winners;
	}
	
	public void runRound() {

		if(players.size()%2 != 0) {
			System.out.println("Error, number of players is not pair");
		}
		
		//Dispatch players in the matches
		int tmp = getPlayers().size()/2;
		for(int i = 0; i < tmp; i++) {
			Match newMatch = new Match(getPlayers().remove(0), getPlayers().remove(0), getRoundPlayerFactor(),  false);
			matches.add(newMatch);
			newMatch.start();
		}
		
		while(!allMatchesFinished());

		for(Match it : matches){
			winners.add(it.getWinner());
		}
		
	}
		
	private boolean allMatchesFinished(){
		for(Match g : matches) {
			if(!g.isFinished()) {
				return false;
			}
		}
		return true;
	}
}
	
