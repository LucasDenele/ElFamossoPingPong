package match;

import player.Player;

import java.util.ArrayList;
import java.util.List;

public class Tournament {
	private List<Game> games = new ArrayList<Game>();
	private List<Player> players = new ArrayList<Player>();
	private Rank rankTournament;
	public List<Game> getGames() {
		return games;
	}
	public void setGames(List<Game> games) {
		this.games = games;
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
}
