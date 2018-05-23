package match;

public class Year {
	private int date;
	private boolean aus = false;
	private boolean bra = false;
	private boolean chi = false;
	private boolean fra = false;
	private boolean ger = false;
	private boolean us = false;

		
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
	public Year(){}
	
	public Tournament runTournament(String name) {

		Tournament currentTournament = new Tournament();

		switch(name) {
			case "OpenAus":
				currentTournament.run("OpenAus");
				aus = true;
				break;

			case "OpenBra":
				currentTournament.run("OpenBra");
				bra = true;
				break;

			case "OpenChi":
				currentTournament.run("OpenChi");
				chi = true;
				break;

			case "OpenFra":
				currentTournament.run("OpenFra");
				fra = true;
				break;

			case "OpenGer":
				currentTournament.run("OpenGer");
				ger = true;
				break;

				case "OpenUS":
					currentTournament.run("OpenUS");
					us = true;
					break;

				default:
					System.out.println("Ce tournoi n'est pas simule ici");
					break;
			}

			return currentTournament;
		}
	
}
