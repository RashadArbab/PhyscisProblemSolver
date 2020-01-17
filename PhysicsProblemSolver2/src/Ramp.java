
public class Ramp {
	private double dimX;
	private double dimY;  
	private double angle; 
	private final double g = 9.81; 
	public Ramp (double x, double y) {
		this.dimX = x; 
		this.dimY = y; 
		this.angle = Math.toDegrees(Math.atan(y/x));
	}
	
	public double getHeight() {
		return dimY; 
	}
	
	public double getLength() {
		return dimX; 
		
	}
	
	public double getAngle() {
		return this.angle;
	}
	
	public void goDown(Mass mass) {
		
		double velocity = Math.pow((2*9.81*dimY), 0.5);
		
		mass.setVelocity(velocity);
		
	}
	
	
}
