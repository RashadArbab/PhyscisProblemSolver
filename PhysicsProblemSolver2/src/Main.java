import java.util.Scanner;
public class Main {
	

		
		public static void main (String args []) {
			
			Scanner scan = new Scanner(System.in); 
			
			System.out.println("What would you like to do?");
			System.out.println("1. To launch a mass with a catapult");
			System.out.println("2. To send a mass down a ramp and colide with a spring"); 
			System.out.println("3. To colide a mass into a spring");
			System.out.println("4. To send a mass down a ramp and into a pendulum for a perfectly elastic collison"); 
			System.out.println("5. to colide a mass into a pendulum at any angle and at any height") ; 
			int option = scan.nextInt(); 
			
			Catapult cat = new Catapult() ;
			if (option == 1 ){ 
				int num = 1; 
				
				while( num != 0) { 
					
					System.out.println("For maximum distance try to have a smaller arm and more torque, the longer the arm the greater the moment of inertia and the generally the shorter the distance") ; 
					System.out.println("");
					System.out.println("");
					
					System.out.println("Set arm length (m)");
					double arm = scan.nextDouble();
					cat.setArm(arm);
					
					System.out.println("Set Torque (Nm)"); 
					double torque = scan.nextDouble(); 
					cat.setTorque(torque); 
					
					System.out.println("Set Mass (kg)"); 
					double mass = scan.nextDouble();
					cat.setMass(mass);
					
					System.out.println("Set launch angle (degrees) "); 
					double angle = scan.nextDouble();
					cat.setAngle(angle);
					
					System.out.println(cat.fire() + "(m) distance traveled"); 
					
					System.out.println("Press 1 to: Would you like to change the settings and fire again?");
					System.out.println("Press 0 to: quit"); 
					num = scan.nextInt();
				}
				
			}
			
			else if (option == 2) {
				
				System.out.println("length of the bottom of the triangle (m) ");
				double x = scan.nextDouble();
				System.out.println("height of the triangle (m) ") ; 
				double y = scan.nextDouble();
				System.out.println("how much does the block weigh? (kg)");
				double weight = scan.nextDouble() ; 
				System.out.println("what is the spring constant (N/m)");
				double k = scan.nextDouble();
				Mass mass = new Mass(weight, 0); 
				Ramp ramp = new Ramp(x,y); 
				Spring spring = new Spring(k);
				ramp.goDown(mass);
				System.out.println(ramp.getAngle() + "(degrees) is the angle of incline of the ramp");
				System.out.println(mass.getVelocity() + "(m/s) the velocity of the block after coming down the ramp"); 
				System.out.println(spring.getEnergyGoingIn(mass.getMass(), mass.getVelocity()) + "(J) the energy of the block after going down the ramp");
				System.out.println(spring.getCompression(mass.getMass(), mass.getVelocity()) + "(m) the maximum compression of the spring");
			} 
			
			else if (option ==3) {
				System.out.println("What is the mass of the block?");
				double m = scan.nextDouble(); 
				System.out.println("Velocity of the block? (m/s)");
				double v = scan.nextDouble(); 
				System.out.println("What is the spring constant? (N/m)");
				double k = scan.nextDouble() ; 
				
				Mass mass = new Mass(m , v); 
				Spring spring = new Spring (k); 
				
				System.out.println(spring.getEnergyGoingIn(mass.getMass(), mass.getVelocity()) + "(J) the energy of the block going into the spring");
				System.out.println(spring.getCompression(mass.getMass(), mass.getVelocity()) + "(m) the maximum compression of the ramp");
				
			}
			
			else if (option == 4) {
				System.out.println("length of the bottom of the triangle ");
				double x = scan.nextDouble();
				System.out.println("height of the triangle") ; 
				double y = scan.nextDouble();
				System.out.println("how much does the block weigh? (kg)");
				double weight = scan.nextDouble() ; 
				
				System.out.println("What is the mass of the pendulum? (kg) Rememeber the pendulum must be uniform in mass."); 
				double pendulumMass = scan.nextDouble();
				System.out.println("What is the length of the pendulum? (m)");
				double pendulumLength = scan.nextDouble();
				
				Ramp ramp = new Ramp(x, y) ;
				Mass mass = new Mass(weight, 0);
				ramp.goDown(mass);
				Pendulum pendulum = new Pendulum(pendulumMass, pendulumLength);
				
				System.out.println("1. elastic collision"); 
				System.out.println("2. inelastic collision");
				int input = scan.nextInt() ; 
					if (input == 1) {
						System.out.print("the pendulum swung " + pendulum.pendulumPerfectHitElastic(mass) +" degreees");
					
					}
					else if (input == 2) { 
						System.out.println("the pendulum swung " + pendulum.pendulumPerfectHitInelastic(mass) + " degrees"); 
					}
				
				
				
				
				
				}
			
			else if (option == 5) { 
				
				System.out.println("whats the mass of the pendulum? (kg)");
				double pendulumMass = scan.nextDouble() ; 
				System.out.println("how long is the pendulum? (m)");
				double pendulumLength = scan.nextDouble(); 
				System.out.println(""); 
				
				
				System.out.println ("How heavy is the mass? (kg) remember this has to be a point mass.");
				double mass = scan.nextDouble() ; 
				System.out.println("What is the velocity of the mass? (m/s)");
				double velocity = scan.nextDouble() ; 
				System.out.println("What is the angle of impact using the pendulum as the axis (degrees)");
				double angle = scan.nextDouble();  
				System.out.print("how far down the pendulum did the mass hit (m) ");
				double lengthOfHit = scan.nextDouble() ; 
				Pendulum pendulum = new Pendulum(pendulumMass, pendulumLength); 
				
				
				
				
				System.out.println("");
				System.out.println("Was it an elastic collision or an inelastic collision?"); 
				System.out.println("1. elastic");
				System.out.println("2. inelastic"); 
				double input = scan.nextDouble();
				if (input == 1) {
					System.out.println(pendulum.pendulumHitElastic(mass, angle, velocity, lengthOfHit)); 
				}
				else if (input == 2) {
					System.out.println(pendulum.pendulumHitInelastic(mass, angle, velocity, lengthOfHit)); 
				}
				
			}
			
			
	}
}
			

