package ress;

import java.util.List;

import match.Tournament;
import player.Player;

public class Year {
	private boolean finished;
	private int date;
	private List<Player> players;
	private Tournament openAus = new Tournament(null, null);
	private Tournament openFra = new Tournament(null, null);
	private Tournament openUS = new Tournament(null, null);
	private Tournament openChi = new Tournament(null, null);
	private Tournament openGer = new Tournament(null, null);
	private Tournament openBra = new Tournament(null, null);
	
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
		
	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public Tournament getOpenAus() {
		return openAus;
	}

	public void setOpenAus(Tournament openAustralia) {
		this.openAus = openAustralia;
	}

	public Tournament getOpenFra() {
		return openFra;
	}

	public void setOpenFra(Tournament openFrance) {
		this.openFra = openFrance;
	}

	public Tournament getOpenUS() {
		return openUS;
	}

	public void setOpenUS(Tournament openUS) {
		this.openUS = openUS;
	}

	public Tournament getOpenChi() {
		return openChi;
	}

	public void setOpenChi(Tournament openChina) {
		this.openChi = openChina;
	}

	public Tournament getOpenGer() {
		return openGer;
	}

	public void setOpenGer(Tournament openGermany) {
		this.openGer = openGermany;
	}

	public Tournament getOpenBra() {
		return openBra;
	}

	public void setOpenBra(Tournament openBrasil) {
		this.openBra = openBrasil;
	}

	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	public Year(int date, List<Player> players) {
		this.setDate(date);
		this.setPlayers(players);
	}
	
	public void runYear() {
		runOpenAus();
		runOpenBra();
		runOpenChi();
		runOpenFra();
		runOpenGer();
		runOpenUS();
	}
	
	public void runOpenAus() {
		if(this.openAus.isFinished()) {
			System.out.println("L'Open d'Australie "+this.getDate()+" est termine");
		}
		else {
			this.setOpenAus(new Tournament("Australian Open "+this.getDate(), players));
			this.openAus.runTournament();
		}
	}
	
	public void runOpenBra() {
		if(this.openBra.isFinished()) {
			System.out.println("L'Open du Bresil "+this.getDate()+" est termine");
		}
		else {
			this.setOpenBra(new Tournament("Brasil Open "+this.getDate(), players));
			this.openBra.runTournament();
		}
	}
	
	public void runOpenChi() {
		if(this.openChi.isFinished()) {
			System.out.println("L'Open de Chine "+this.getDate()+" est termine");
		}
		else {
			this.setOpenChi(new Tournament("China Open "+this.getDate(), players));
			this.openChi.runTournament();
		}
	}
	
	public void runOpenFra() {
		if(this.openFra.isFinished()) {
			System.out.println("L'Open de France "+this.getDate()+" est termine");
		}
		else {
			this.setOpenFra(new Tournament("France Open "+this.getDate(), players));
			this.openFra.runTournament();
		}
	}
	
	public void runOpenGer() {
		if(this.openGer.isFinished()) {
			System.out.println("L'Open d'Allemagne "+this.getDate()+" est termine");
		}
		else {
			this.setOpenGer(new Tournament("Germany Open "+this.getDate(), players));
			this.openGer.runTournament();
		}
	}
	
	public void runOpenUS() {
		if(this.openUS.isFinished()) {
			System.out.println("L'US Open "+this.getDate()+" est termine");
		}
		else {
			this.setOpenUS(new Tournament("US Open "+this.getDate(), players));
			this.openUS.runTournament();
		}
	}
}
