
public class Catapult {


	
	
	private double arm; 
	private double torque; 
	private double mass; 
	private double angle; 
	private double distance; 
	
	
	public Catapult () {
		
	}
	
	public double getArm() {
		return arm;
	}
	
	public void setArm(double arm) {
		this.arm = arm; 
	}
	
	public double getAngle() {
		return angle; 
	}
	
	public void setAngle(double angle) {
		this.angle = angle; 
	}
	
	public double getMass() {
		return this.mass;
	}
	
	public void setMass(double mass) {
		this.mass = mass; 
	}
	public double getTorque() {
		return torque;
	}
	public void setTorque(double torque) {
		this.torque = torque; 
	}
	public double getDistance() { 
		return distance; 
	}
	
	
	public double fire() {
		
		
		double I = ( (double) 1/12)*(8*arm)*Math.pow(arm, 2); 
		double alpha = ((double) torque/ I); 
		double omega =  Math.pow(((double) 2*alpha*((angle*Math.PI)/180)), 0.5) ;
		
	
		double launchHeight =  (arm * Math.sin(angle));
		double launchVelocity = omega*arm; 
		
		
		double time = ((double) launchVelocity * Math.sin(angle))/9.8;
		double maxHeight = (launchHeight) + (launchVelocity * Math.sin(angle)) + 0.5*(-9.8)* (Math.pow(time,2)) ;
		
		double timeTotal = (double) (time + Math.pow((maxHeight/4.9), 0.5)); 
		
		double distanceTraveled = (launchVelocity); 
		
		
		return  distanceTraveled; 
	}
	
	


}
