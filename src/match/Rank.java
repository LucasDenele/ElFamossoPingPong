package match;

import player.Player;

import java.util.ArrayList;
import java.util.List;

public class Rank {
	private List<Player> playersList = new ArrayList<Player>();

	public List<Player> getPlayersList() {
		return playersList;
	}

	public void setPlayersList(List<Player> playersList) {
		this.playersList = playersList;
	}
}
