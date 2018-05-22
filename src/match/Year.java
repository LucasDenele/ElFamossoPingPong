package match;

import match.Tournament;

public class Year {
	private boolean finished;
	private int date;
	private boolean aus = false;
	private boolean bra = false;
	private boolean chi = false;
	private boolean fra = false;
	private boolean ger = false;
	private boolean us = false;
	
	
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

	public boolean isAus() {
		return aus;
	}
	public void setAus(boolean aus) {
		this.aus = aus;
	}
	public boolean isBra() {
		return bra;
	}
	public void setBra(boolean bra) {
		this.bra = bra;
	}
	public boolean isChi() {
		return chi;
	}
	public void setChi(boolean chi) {
		this.chi = chi;
	}
	public boolean isFra() {
		return fra;
	}
	public void setFra(boolean fra) {
		this.fra = fra;
	}
	public boolean isGer() {
		return ger;
	}
	public void setGer(boolean ger) {
		this.ger = ger;
	}
	public boolean isUs() {
		return us;
	}
	public void setUs(boolean us) {
		this.us = us;
	}

	public Year(int date) {
		this.setDate(date);
	}
	
	public void runYear() {
		runTournament("OpenAus");
		runTournament("OpenBra");
		runTournament("OpenChi");
		runTournament("OpenFra");
		runTournament("OpenGer");
		runTournament("OpenUS");
		
	}
	
	public void runTournament(String name) {
		if(aus && bra && chi && fra && ger && us) {
			setFinished(true);
		}
		
		if(!isFinished()) {
					
			switch(name) {
			case "OpenAus":
				if(aus) {
					System.out.println("Australian Open "+this.getDate()+" is passed");
				}
				else {
					Tournament currentTournament = new Tournament();
					currentTournament.run("OpenAus");
					aus = true;
				}
				break;
				
			case "OpenBra":
				if(bra) {
					System.out.println("Brasilian Open "+this.getDate()+" is passed");
				}
				else {
					Tournament currentTournament = new Tournament();
					currentTournament.run("OpenBra");
					bra = true;
				}
				break;
				
			case "OpenChi":
				if(chi) {
					System.out.println("Chinese Open "+this.getDate()+" is passed");
				}
				else {
					Tournament currentTournament = new Tournament();
					currentTournament.run("OpenChi");
					chi = true;
				}
				break;
				
			case "OpenFra":
				if(fra) {
					System.out.println("French Open "+this.getDate()+" is passed");
				}
				else {
					Tournament currentTournament = new Tournament();
					currentTournament.run("OpenFra");
					fra = true;
				}
				break;
				
			case "OpenGer":
				if(ger) {
					System.out.println("German Open"+this.getDate()+" is passed");
				}
				else {
					Tournament currentTournament = new Tournament();
					currentTournament.run("OpenGer");
					ger = true;
				}
				break;
				
			case "OpenUS":
				if(us) {
					System.out.println("US Open "+this.getDate()+" is passed");
				}
				else {
					Tournament currentTournament = new Tournament();
					currentTournament.run("OpenUS");
					us = true;
				}
				break;
			
			default:
				System.out.println("Ce tournoi n'est pas simule ici");
				break;
			}
		}
		else {
			System.out.println("Year is passed");
		}
	}
	
}
