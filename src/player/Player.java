package player;

public class Player{
	
	//Attributes
	private String firstName;
	private String lastName;
	private String country;
	private double points;
	private String gender;
	private float endurance;
	private float power;

	
	//Constructor
	public Player(String firstName, String lastName, String country, double points, String gender, float endurance, float power) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setCountry(country);
		this.setGender(gender);
		this.setEndurance(endurance);
		this.setPower(power);
		this.setPoints(points);
	}
	
	//Getters & Setters
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCountry() {
		return this.country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public float getEndurance() {
		return endurance;
	}
	public void setEndurance(float endurance2) {
		this.endurance = endurance2;
	}
	public float getPower() {
		return power;
	}
	public void setPower(float power2) {
		this.power = power2;
	}
	public double getPoints() {
		return points;
	}
	public void setPoints(double points) {
		this.points = points;
	}


}
