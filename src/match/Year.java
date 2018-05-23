package match;

public class Year {
	private int date;
	private boolean ausM = false;
	private boolean braM = false;
	private boolean chiM = false;
	private boolean fraM = false;
	private boolean gerM = false;
	private boolean usM = false;
	private boolean ausW = false;
	private boolean braW = false;
	private boolean chiW = false;
	private boolean fraW = false;
	private boolean gerW = false;
	private boolean usW = false;

		
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}

	public Year(int date) {
		this.setDate(date);
	}
	public Year(){}
	
	public Tournament runTournament(String name) {

		Tournament currentTournament = new Tournament();

		switch(name) {
			case "OpenAusM":
				currentTournament.run("OpenAusM");
				ausM = true;
				break;

			case "OpenBraM":
				currentTournament.run("OpenBraM");
				braM = true;
				break;

			case "OpenChiM":
				currentTournament.run("OpenChiM");
				chiM = true;
				break;

			case "OpenFraM":
				currentTournament.run("OpenFraM");
				fraM = true;
				break;

			case "OpenGerM":
				currentTournament.run("OpenGerM");
				gerM = true;
				break;

			case "OpenUSM":
				currentTournament.run("OpenUSM");
				usM = true;
				break;

			case "OpenAusW":
				currentTournament.run("OpenAusW");
				ausW = true;
				break;

			case "OpenBraW":
				currentTournament.run("OpenBraW");
				braW = true;
				break;

			case "OpenChiW":
				currentTournament.run("OpenChiW");
				chiW = true;
				break;

			case "OpenFraW":
				currentTournament.run("OpenFraW");
				fraW = true;
				break;

			case "OpenGerW":
				currentTournament.run("OpenGerW");
				gerW = true;
				break;

			case "OpenUSW":
				currentTournament.run("OpenUSW");
				usW= true;
				break;

				default:
					System.out.println("Ce tournoi n'est pas simule ici");
					break;
			}

			return currentTournament;
		}
	
}
