
public class Pendulum {


	private double mass; 
	private double length; 
	private double deltaH; 
	private double lengthCM ; 
	
	public Pendulum(double mass, double length) {
		this.mass = mass; 
		this.length = length; 	
	}
	
	



	public double getMass() { 
		return this.mass; 
	}
	public void setMass(double mass) {
		this.mass = mass ;
	}
	public double getLength() {
		return this.length; 
	}
	public void setLength(double length) {
		this.length = length; 
	}
	public double getDeltaH() {
		return this.deltaH; 
	}
	
	public double getLenghtCM () {
		return this.lengthCM; 
	}
	
	/**
	 * calculates the angle at which a pendulum would swing if it were hit by a point mass in an elastic collision.
	 * @param mass
	 * @param angle
	 * @param velocity
	 * @param lengthOfHit
	 * @return
	 */
	public double pendulumHitElastic(double mass, double angle, double velocity, double lengthOfHit) {
		
		angle = Math.toRadians(angle);
		
		
		System.out.println(Math.sin(angle));
		System.out.println(1/12.0);
		double I = (double) (1/12.0)*this.mass*Math.pow(length, 2) ;
		double W =  ((double)lengthOfHit * mass *(double) velocity * Math.sin(angle))/I; 
		double deltaH = (double)(((double) 0.5 * I * Math.pow(W, 2)) / ((double) (this.mass) * 9.81));
		double lengthCM = ((double) (((double) this.mass*length/2) /this.mass)) ;  
		double angleOfSwing = Math.toDegrees(Math.acos(((double) ((lengthCM - deltaH)/lengthCM))));
		this.lengthCM= lengthCM;
		
		System.out.println(I + " The moment of inertia of the pendulum");
		System.out.println(W + "The angular velocity imediately after collision");
		System.out.println(deltaH + " The change in height of the center of mass for the pendulum");
		System.out.println(lengthCM + " The length of the center of mass of the pendulum"); 
		
		
		return angleOfSwing; 
	}
	/**
	 * calculates the angle at which a pendulum would swing if it were hit by a point mass in an inelastic collision
	 * @param mass
	 * @param angle
	 * @param velocity
	 * @param lengthOfHit
	 * @return
	 */
	public double pendulumHitInelastic(double mass, double angle, double velocity, double lengthOfHit) {
		double newMass = this.mass + mass; 
		angle = Math.toRadians(angle);
		System.out.println(velocity);
		
		System.out.println(Math.sin(angle));
		System.out.println(1/12.0);
		double I = (double) (1/12.0)*this.mass*Math.pow(length, 2) + ((double)mass * Math.pow(lengthOfHit, 2));
		double W =  ((double)lengthOfHit * mass *(double) velocity * Math.sin(angle))/I; 
		double deltaH = (double)(((double) 0.5 * I * Math.pow(W, 2)) / ((double) (this.mass+mass) * 9.81));
		double lengthCM = ((double) (((double) this.mass*length/2) + ((double) mass *lengthOfHit))/newMass) ;  
		double angleOfSwing = Math.toDegrees(Math.acos(((double) ((lengthCM - deltaH)/lengthCM))));
		this.lengthCM= lengthCM;
		System.out.println(newMass + " The mass of the system after the collision"); 
		System.out.println(I + " The moment of inertia of the mass and pendulum system" );
		System.out.println(W + " The angular velocity of the mass and pendulum system immediately after collision");
		System.out.println(deltaH + " The change in height of the center of mass of the mass and pendulum system");
		System.out.println(lengthCM + " The center of mass of the mass and pendulum system"); 
		
		return angleOfSwing; 
	}
	/*
	0.08333333333333333
	83.33333333333333
	1.429517921217319
	10.691345543811806
	0.8679584977410316
	50.0
	10.691345543811806
	
	*/
	/**
	 * calculates the angle at which a pendulum would swing if it were hit by a point mass at 90degrees on the end of the pendulum in an elastic collision
	 * @param mass
	 * @return
	 */
	public double pendulumPerfectHitElastic(Mass mass) {
		System.out.println(mass.getVelocity());
		double I = (0.0833333333333)*this.mass*Math.pow(length, 2);
		double W = (double) ((double)this.length * mass.getMass() * mass.getVelocity() * Math.sin(Math.toRadians(90)))/I; 
		double deltaH = (double)(((double) 0.5 * I * Math.pow(W, 2)) / (double) (this.mass * 9.81));
		double lengthCM = ((double) this.mass*length/2)  ;  
		double angle = Math.toDegrees(Math.acos(((double) ((lengthCM - deltaH)/lengthCM))));
		this.lengthCM= lengthCM;
		
		System.out.println(I + "(Kg m^2) The moment of inertia of the pendulum");
		System.out.println(W + "(rads/s) The angular velocity of the pendulum immediately after collision");
		System.out.println(deltaH + "(m) The change in the height of the center of mass of the pendulum");
		System.out.println(lengthCM + "(m) The center of mass of the pendulum");
		
		return angle; 
		
		
	}
	/**
	 * calculates the angle at which a pendulum would swing if it were hit by a point mass at 90 degrees on the end of the pendulum in an inelastic collison
	 * @param mass
	 * @return
	 */
	public double pendulumPerfectHitInelastic(Mass mass) {
		double newMass = this.mass + mass.getMass(); 
		System.out.println(mass.getVelocity());
		double I = (0.0833333333333)*this.mass*Math.pow(length, 2) + (mass.getMass() * Math.pow(this.length, 2));
		double W = (double) ((double)this.length * mass.getMass() * mass.getVelocity() * Math.sin(Math.toRadians(90)))/I; 
		double deltaH = (double)(((double) 0.5 * I * Math.pow(W, 2)) / ((double) (this.mass+mass.getMass()) * 9.81));
		double lengthCM = ((double) (((double) this.mass*length/2) + ((double) mass.getMass() *length))/newMass) ;  
		double angle = Math.toDegrees(Math.acos(((double) ((lengthCM - deltaH)/lengthCM))));
		this.lengthCM= lengthCM;
		
		
		System.out.println(newMass + "mass of the block and pendulum system"); 
		System.out.println(I + "(Kg m^2) The moment of inertia of the pendulum and the block (assuming the block to be a point mass)");
		System.out.println(W + "(rads/s) The angular velocity of the system immediately after collision");
		System.out.println(deltaH + "(m) The change in the height of the center of mass of the system");
		System.out.println(lengthCM + "(m) The center of mass of the system");
		return angle; 
	}
	
	


}
