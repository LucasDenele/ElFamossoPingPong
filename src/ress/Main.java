package ress;

import java.util.ArrayList;
import java.util.List;

import match.Match;
import match.Rank;
import match.Round;
import match.Set;
import match.Tournament;
import player.Player;

public class Main {
	public static void main(String[] args) {
/*
		//Creation players to sort the rank
		 * 
		Player p1 = new Player("Jean-Michel", 0, "FRA", "male", 10, 50, 340);
		Player p2 = new Player("Jean", 1, "FRA", "male", 10, 50, 12);
		Player p3 = new Player("Michel", 2, "FRA", "male", 10, 50, 34);
		Player p4 = new Player("Jeanne", 3, "FRA", "male", 10, 50, 65);
		Player p5 = new Player("Michelle", 4, "FRA", "male", 10, 50, 40);
		Player p6 = new Player("Jean-Mi", 5, "FRA", "male", 10, 50, 30);
		//p1.display();
		//p2.display();
		//p3.display();
		//p4.display();
		//p5.display();
		//p6.display();
		System.out.println("-----LIST");
		
		//Add in the players in the list
		List<Player> test = new ArrayList<Player>();
		test.add(p1);test.add(p2);test.add(p3);test.add(p4);test.add(p5);test.add(p6);
		//sort of the list
		Rank r = new Rank(test);
		r.display();
		System.out.println("-----RANK");
*/	
		/*
		//Creation many sets with 2 players
		Player p1 = new Player("Joueur 1", 0, "FRA", "male", 10, 50, 340);
		Player p2 = new Player("Joueur 2", 1, "FRA", "male", 10, 70, 12);
		Set set1 = new Set(1, p1, p2);
		Set set2 = new Set(2, p1, p2);
		Set set3 = new Set(3, p1, p2);
		Set set4 = new Set(4, p1, p2);
		set1.run();
		set2.run();
		set3.run();
		set4.run();
	*/
		/*
		//Creation a game with many sets
		Player p1 = new Player("Joueur1", 0, "FRA", "male", 70, 50, 300);
		Player p2 = new Player("Joueur2", 1, "FRA", "male", 80, 40, 142);
		Player p3 = new Player("Joueur3", 2, "FRA", "male", 90, 50, 340);
		Player p4 = new Player("Joueur4", 3, "FRA", "male", 80, 60, 12);
		Match game1 = new Match(0, p1, p2);
		
		Match game2 = new Match(1, p3, p4);
		game1.start();
		game2.start();
		*/
		
		/*
		Player p1 = new Player("Joueur1", 0, "FRA", "male", 70, 50, 300);
		Player p2 = new Player("Joueur2", 1, "FRA", "male", 80, 40, 142);
		Player p3 = new Player("Joueur3", 2, "FRA", "male", 90, 50, 340);
		Player p4 = new Player("Joueur4", 3, "FRA", "male", 80, 60, 12);
		Player p5 = new Player("Joueur5", 4, "FRA", "male", 70, 50, 300);
		Player p6 = new Player("Joueur6", 5, "FRA", "male", 80, 40, 142);
		Player p7 = new Player("Joueur7", 6, "FRA", "male", 90, 50, 340);
		Player p8 = new Player("Joueur8", 7, "FRA", "male", 80, 60, 12);
		List<Player> test = new ArrayList<Player>(); 
		test.add(p1);test.add(p2);test.add(p3);test.add(p4);
		test.add(p5);test.add(p6);test.add(p7);test.add(p8);
		List<String[]> allPlayers = new ArrayList<String[]>();
		
		for(Player p : test) {
			String[] r = new String[3];
			r[0] = p.getName(); //name
			r[1] = "1"; //roundMax
			r[2] = "0"; //pointsTournament
			allPlayers.add(r);
		}
		
		Round r1 = new Round(0, test, allPlayers);
		r1.start();
		*/
		
		/*
		Player p1 = new Player("Joueur1", 0, "FRA", "male", 70, 50, 300);
		Player p2 = new Player("Joueur2", 1, "FRA", "male", 80, 40, 142);
		Player p3 = new Player("Joueur3", 2, "FRA", "male", 90, 50, 340);
		Player p4 = new Player("Joueur4", 3, "FRA", "male", 80, 60, 12);
		Player p5 = new Player("Joueur5", 4, "FRA", "male", 70, 50, 300);
		Player p6 = new Player("Joueur6", 5, "FRA", "male", 80, 40, 142);
		Player p7 = new Player("Joueur7", 6, "FRA", "male", 90, 50, 340);
		Player p8 = new Player("Joueur8", 7, "FRA", "male", 80, 60, 12);
		List<Player> test = new ArrayList<Player>(); 
		test.add(p1);test.add(p2);test.add(p3);test.add(p4);
		test.add(p5);test.add(p6);test.add(p7);test.add(p8);
		Tournament t1 = new Tournament("0", test);
		t1.runTournament();
		*/
		Player p1 = new Player("Joueur1", 0, "FRA", "male", 70, 50, 300);
		Player p2 = new Player("Joueur2", 1, "FRA", "male", 80, 40, 142);
		Player p3 = new Player("Joueur3", 2, "FRA", "male", 90, 50, 340);
		Player p4 = new Player("Joueur4", 3, "FRA", "male", 80, 60, 12);
		Player p5 = new Player("Joueur5", 4, "FRA", "male", 70, 50, 300);
		Player p6 = new Player("Joueur6", 5, "FRA", "male", 80, 40, 142);
		Player p7 = new Player("Joueur7", 6, "FRA", "male", 90, 50, 340);
		Player p8 = new Player("Joueur8", 7, "FRA", "male", 80, 60, 12);
		List<Player> test = new ArrayList<Player>(); 
		test.add(p1);test.add(p2);test.add(p3);test.add(p4);
		test.add(p5);test.add(p6);test.add(p7);test.add(p8);
		Year y = new Year(2018);
		y.runTournament("OpenUS");
		y.runTournament("OpenUS");
		//y.runYear();
	}

}
