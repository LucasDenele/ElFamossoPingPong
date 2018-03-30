package player;

public class Player {
	
	//Attributes
	private String name;
	private int id;
	private String gender;
	private int endurance;
	private int power;
	private double points;
	
	//Constructor
	public Player(String name, int id, String gender, int endurance, int power, double points) {
		this.setName(name);
		this.setId(id);
		this.setGender(gender);
		this.setEndurance(endurance);
		this.setPower(power);
		this.setPoints(points);
	}
	
	//Getters & Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getEndurance() {
		return endurance;
	}
	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public double getPoints() {
		return points;
	}
	public void setPoints(double points) {
		this.points = points;
	}

}
