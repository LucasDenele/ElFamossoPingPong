package match;

import player.Player;

import java.util.ArrayList;
import java.util.List;

public class Tournament {
	//Attributes
	private String name;
	private List<Round> rounds = new ArrayList<Round>();
	private List<Player> players = new ArrayList<Player>();
	private Rank rankTournament;
	private Player winner;
	private boolean finished;
	
	//Constructor
	public Tournament(String name, List<Player> players) {
		this.setName(name);
		this.setPlayers(players);
		this.setFinished(false);
	}
	
	//Getters & Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Round> getRounds() {
		return rounds;
	}
	public void setRounds(List<Round> rounds) {
		this.rounds = rounds;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	public Rank getRankTournament() {
		return rankTournament;
	}
	public void setRankTournament(Rank rankTournament) {
		this.rankTournament = rankTournament;
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

	public void runTournament() {
		
		
		for(int i = 0;i < 7;i++) {
			newRound(i*10);
		}
		this.setFinished(true);
		System.out.println("Tournament "+this.getName()+" - Winner : "+this.getWinner().getName());
	}
	
	public void newRound(int id) {
		System.out.println("Tournament "+this.getName());
		for(Player p : players) {
			//p.display();
		}
		Round currentRound;
		if (!rounds.isEmpty()) {
			currentRound = new Round(id, rounds.get(rounds.size()-1).getWinners());
		}
		else {
			currentRound = new Round(id, players);
		}
		currentRound.runRound();
		
		while(!currentRound.isFinished()) {
			
		}
		System.out.println("Round "+ currentRound.getId());
		for(Player p : currentRound.getPlayersUpdate()) {
			//p.display();
		}
		
		this.rounds.add(currentRound);
		if(currentRound.getWinners().size() == 1) {
			this.setWinner(currentRound.getWinners().remove(0));
		}
	}
	
}
