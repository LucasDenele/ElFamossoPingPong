package player;

public class Player{
	
	//Attributes
	private String name;
	private int id;
	private String gender;
	private String country;
	private float endurance;
	private float power;
	private double points;
	
	//Constructor
	public Player(String name, int id, String country, String gender, float endurance, float power, double points) {
		this.setName(name);
		this.setId(id);
		this.setCountry(country);
		this.setGender(gender);
		this.setEndurance(endurance);
		this.setPower(power);
		this.setPoints(points);
	}
	
	public void display() {
		System.out.println("Name : "+this.getName()+
						"| ID : "+this.getId()+
						"| Country : "+this.getCountry()+
						"| Gender : "+this.getGender()+
						"| Endurance : "+this.getEndurance()+
						"| Power : "+this.getPower()+
						"| Points : "+this.getPoints());
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
