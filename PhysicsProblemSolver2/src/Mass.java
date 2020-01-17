
public class Mass {
	
	private double mass; 
	private double velocity; 
	public Mass (double mass, double velocity) {
		this.mass = mass; 
		this.velocity = velocity; 
	}
	public Mass(Mass mass) {
		this.mass = mass.getMass(); 
		this.velocity = mass.getVelocity(); 
	}
	
	public double getMass() {
		return this.mass; 
	}
	
	public double getVelocity() {
		return this.velocity; 
	}
	
	public void setVelocity(double velocity) {
		this.velocity = velocity; 
	}
	
	public double getEnergy() {
		double energy = 0.5 * mass * Math.pow(velocity, 2); 
		return energy; 
	}
	
}
