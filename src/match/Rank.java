package match;

import java.util.ArrayList;
import java.util.List;

import player.Player;

public class Rank {
	private List<Player> playersList = new ArrayList<Player>();

	public List<Player> getPlayersList() {
		return playersList;
	}

	public void setPlayersList(List<Player> playersList) {
		this.playersList = playersList;
	}
}
