package match;

import AccessBDD.AccessBDD;
import player.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Tournament {
	
	//Attributes
	private String name;
	private List<Round> rounds = new ArrayList<Round>();
	private List<Player> players = new ArrayList<Player>();
	private Player winner;
	private AccessBDD playersAccessBDD = new AccessBDD();


	//Constructors
	public Tournament(){
		super();
	}

	public Tournament(String name){
		this.name = name;
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
	public Player getWinner() {
		return winner;
	}
	public void setWinner(Player winner) {
		this.winner = winner;
	}
	
	//Functions
	public void run(String name) {
        Vector<Player> playersDTB = new Vector<>();
		//Choice of the selected tournament
		System.out.println(name);
		switch(name) {
			case "OpenAusM":
				//Request for the 128 best players
                playersDTB = playersAccessBDD.<Player>request("select * from PLAYER where GENDER = 'h' order by POINTS desc limit 128");
				this.setName("Australian Open Men");
				break;
				
			case "OpenBraM":
				//Request for the 128 worst players
                playersDTB = playersAccessBDD.<Player>request("select * from PLAYER where GENDER = 'h' order by POINTS limit 128");
				this.setName("Brasilian Open Men");
				break;
				
			case "OpenChiM":
				//Request for the 128 worst players
                playersDTB = playersAccessBDD.<Player>request("select * from PLAYER where GENDER = 'h' order by POINTS limit 128");
                this.setName("Chinese Open Men");
				break;
				
			case "OpenFraM":
				//Request for 128 random players
                playersDTB = playersAccessBDD.<Player>request("select * from PLAYER where GENDER = 'h' order by POINTS desc limit 128");
				this.setName("French Open Men");
				break;
				
			case "OpenGerM":
				//Request for 128 random players
                playersDTB = playersAccessBDD.<Player>request("select * from PLAYER where GENDER = 'h' order by POINTS limit 128");
				this.setName("German Open Men");
				break;
				
			case "OpenUSM":
				//Request for the 128 best players
                playersDTB = playersAccessBDD.<Player>request("select * from PLAYER where GENDER = 'h' order by POINTS desc limit 128");
				this.setName("US Open Men");
				break;
			case "OpenAusW":
				//Request for the 128 best players
				playersDTB = playersAccessBDD.<Player>request("select * from PLAYER where GENDER = 'f' order by POINTS desc limit 128");
				this.setName("Australian Open Women");
				break;

			case "OpenBraW":
				//Request for the 128 worst players
				playersDTB = playersAccessBDD.<Player>request("select * from PLAYER where GENDER = 'f' order by POINTS limit 128");
				this.setName("Brasilian Open Women");
				break;

			case "OpenChiW":
				//Request for the 128 worst players
				playersDTB = playersAccessBDD.<Player>request("select * from PLAYER where GENDER = 'f' order by POINTS limit 128");
				this.setName("Chinese Open Women");
				break;

			case "OpenFraW":
				//Request for 128 random players
				playersDTB = playersAccessBDD.<Player>request("select * from PLAYER where GENDER = 'f' order by POINTS desc limit 128");
				this.setName("French Open Women");
				break;

			case "OpenGerW":
				//Request for 128 random players
				playersDTB = playersAccessBDD.<Player>request("select * from PLAYER where GENDER = 'f' order by POINTS limit 128");
				this.setName("German Open Women");
				break;

			case "OpenUSW":
				//Request for the 128 best players
				playersDTB = playersAccessBDD.<Player>request("select * from PLAYER where GENDER = 'f' order by POINTS desc limit 128");
				this.setName("US Open Women");
				break;
			
			default:
				break;
		}

		players.addAll(playersDTB);
		playersDTB.clear();

		for(int i = 0;i < 7;i++) {
			if(i <= 2)  newRound(i+1/7, "Round "+(i+1));
			if(i == 3) newRound(i+1/7, "Knockout");
			if(i == 4) newRound(i+1/7, "Quater Final");
			if(i == 5) newRound(i+1/7, "Semi Final");
			if(i == 6) newRound(i+1/7, "Final");
		}
	}
	
	private void newRound(double roundPointsPlayerFactor ,String roundName) {
		
		Round currentRound;

		//check if it's the first round
		if (!rounds.isEmpty()) {
			currentRound = new Round(roundPointsPlayerFactor, roundName, rounds.get(rounds.size()-1).getWinners());
		}
		else {
			currentRound = new Round(roundPointsPlayerFactor, roundName, players);
		}
		currentRound.runRound();
		
		this.rounds.add(currentRound);
		if(currentRound.getWinners().size() == 1) {
			this.setWinner(currentRound.getWinners().remove(0));
		}
	}
	
}
