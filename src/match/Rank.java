package match;

import player.Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Rank {
	
	//Attribute
	private List<Player> playersList = new ArrayList<Player>();

	//Constructor
	public Rank(List<Player> playersList) {
		this.playersList = playersList;
	}
	
	//Getters & Setters
	public List<Player> getPlayersList() {
		return playersList;
	}
	public void setPlayersList(List<Player> playersList) {
		this.playersList = playersList;
	}
	

	public void display() {
		//List of players not sorted
		/*for(Player p : playersList) {
			p.display();
		}*/
		
		//List of players sorted
		System.out.println("-----SORT");
		playersList = (ArrayList<Player>) playersList.stream()
				.sorted(Comparator.comparingDouble(Player::getPoints))
				.collect(Collectors.toList());
		
		//print players
		for(Player p : playersList) {
			p.display();
		}
	}
}
