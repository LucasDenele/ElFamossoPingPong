package match;

import player.Player;

import java.util.ArrayList;
import java.util.List;

public class Tournament {
	
	//Attributes
	private String name;
	private List<Round> rounds = new ArrayList<Round>();
	private List<Player> players = new ArrayList<Player>();
	private List<Player> playersUpdate = new ArrayList<Player>();
	private Player winner;
	private boolean finished = false;
	
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
	public List<Player> getPlayersUpdate() {
		return playersUpdate;
	}
	public void setPlayersUpdate(List<Player> playersUpdate) {
		this.playersUpdate = playersUpdate;
	}
	
	//Functions
	public void run(String name) {

		//Choice of the selected tournament
		switch(name) {
			case "OpenAus":
				//Request for the 128 best players
				this.setName("Australian Open");
				fillPlayers();
				break;
				
			case "OpenBra":
				//Request for the 128 worst players
				this.setName("Brasilian Open");
				fillPlayers();
				break;
				
			case "OpenChi":
				//Request for the 128 worst players
				this.setName("Chinese Open");
				fillPlayers();
				break;
				
			case "OpenFra":
				//Request for 128 random players
				this.setName("French Open");
				fillPlayers();
				break;
				
			case "OpenGer":
				//Request for 128 random players
				this.setName("German Open");
				fillPlayers();
				break;
				
			case "OpenUS":
				//Request for the 128 best players
				this.setName("US Open");
				fillPlayers();
				break;
			
			default:
				//Without DTB
				fillPlayers();
				break;
		}
		
		for(int i = 0;i < 7;i++) {
			newRound(i*10);
		}
		this.setFinished(true);
		//System.out.println("Tournament "+this.getName()+" - Winner : "+this.getWinner().getName());
		
		this.setPlayersUpdate(rounds.get(0).getPlayersUpdate());
		/*
		for(Player p : playersUpdate) {
			p.display();
		}
		*/
	}
	
	public void newRound(int id) {
		//System.out.println("Tournament "+this.getName());
		
		Round currentRound;
			//check if it's the first round
		if (!rounds.isEmpty()) {
			currentRound = new Round(id, rounds.get(rounds.size()-1).getWinners());
		}
		else {
			currentRound = new Round(id, players);
		}
		currentRound.runRound();
		
		while(!currentRound.isFinished());
		//System.out.println("Round "+ currentRound.getId());
		
		this.rounds.add(currentRound);
		if(currentRound.getWinners().size() == 1) {
			this.setWinner(currentRound.getWinners().remove(0));
		}
	}
	
	public void fillPlayers() {
		//if the DTB is not found
		/*Player p1 = new Player("Joueur1", 0, "FRA", "male", 70, 50, 300);
		Player p2 = new Player("Joueur2", 1, "FRA", "male", 80, 40, 142);
		Player p3 = new Player("Joueur3", 2, "FRA", "male", 90, 50, 340);
		Player p4 = new Player("Joueur4", 3, "FRA", "male", 80, 60, 110);
		Player p5 = new Player("Joueur5", 4, "FRA", "male", 70, 50, 300);
		Player p6 = new Player("Joueur6", 5, "FRA", "male", 80, 40, 142);
		Player p7 = new Player("Joueur7", 6, "FRA", "male", 90, 50, 340);
		Player p8 = new Player("Joueur8", 7, "FRA", "male", 80, 60, 120);
		
		players.add(p1);players.add(p2);players.add(p3);players.add(p4);
		players.add(p5);players.add(p6);players.add(p7);players.add(p8);*/
	}
	
}
