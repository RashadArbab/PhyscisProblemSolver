
public class Spring {
	
	private double k ;
	private double energyGoingIn; 
	public Spring (double k) {
		this.k = k ; 
	}
	
	public double getK () {
		return k; 
	}
	
	public void setK (double k) {
		this.k = k;
	}
	
	public double getEnergyGoingIn(double mass, double velocity) {
		double energyGoingIn = ((0.5)*mass) * Math.pow(velocity, 2); 
		return energyGoingIn; 
	}
	public double getCompression (double mass, double velocity) { 
		double energyGoingIn = ((0.5)*mass) * Math.pow(velocity, 2) ; 
		
		double x = Math.pow( ( 2*energyGoingIn)/k, 0.5); 
		
		return x; 
	}
	
	public double getForce (double mass, double velocity) {
		double force = -k*getCompression(mass, velocity) ; 
		return force ; 
		
	}
	

}
