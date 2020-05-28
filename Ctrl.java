import java.util.ArrayList;

import processing.core.*;

public class Ctrl extends PApplet  {

	private ArrayList<MovingCircle> circles = new ArrayList<MovingCircle>();

	public static void main(String[] args) {
		//must call PApplet's static main method, and supply the full package and class name of this class as an argument
		PApplet.main("Ctrl");
	}

	public void settings() {
		size(2400,1000);
	}
	
	public void setup() {
		
		this.background(255, 255, 255); //r,g,b between 0 - 255
		
		//instantiate a few moving circle objects		
		//call our custom constructor, which accepts a reference to this PApplet  object
		
		for (int i = 0; i<5; i++) {
			//pass this object to the MovingCircle constructor... see how that constructor stores a reference to this object inside its own object
			this.circles.add(new MovingCircle(this));
		}
		
	}
	
	double t1 = System.currentTimeMillis() % 1000000 / 1000; // time program starts
	double t = 2000000;
	
	float ugh = 5000;
	float ban = 1;
	boolean yet = false; 
	
	public void draw() {
		
		double cc = ((System.currentTimeMillis() % 1000000 / 1000) - t1);
				
			if (cc <= 15) {
				
			}
			else if (cc <= 67) {
				for (int i=0; i<1; i++) {				
					MovingCircle thisCircle = this.circles.get(i);
					thisCircle.move(3, 3);
					thisCircle.show(255, 255, 255);	
				}
			}
			else if (cc <= 124) {
				this.circles.clear();
				this.clear();
				this.background(255, 255, 255);
					this.circles.add(new MovingCircle(this));
					for (int i=0; i<1; i++) {				
						MovingCircle thisCircle = this.circles.get(i);
						thisCircle.move();
						thisCircle.show(0, 0, 0);	
					}
			}
			else if (cc <= 173) {
				this.circles.add(new MovingCircle(this));
				for (int i=0; i<this.circles.size(); i++) {				
					MovingCircle thisCircle = this.circles.get(i);
					thisCircle.move();
					thisCircle.show(0, 100, 92);	
				}
			}
			else if (cc <= 232) {
				if (t == 2000000) {
					t = System.currentTimeMillis() % 1000000 / 1000; // time down is pushed
				}
				float r = (float) (255 * (((System.currentTimeMillis() % 1000000 / 1000) - (t-t1)-t) * 1.0/60)); 
				if (ugh == 5000)
					ugh = r;
				r = r + (ugh * -1);
				float g = 100f; 
				float b = 92f; 
				for (int i=0; i<this.circles.size(); i++) {				
					MovingCircle thisCircle = this.circles.get(i);
					thisCircle.move();
					thisCircle.show(r, g, b);
				}
			}
			else if (cc <= 268) {
				if (this.circles.size() >= 1)
					this.circles.remove(0);
			}
			else if (cc <= 287) {
				if (this.circles.size() < 20)
					this.circles.add(new MovingCircle(this));
				for (int i=0; i<5; i++) {	
					this.circles.add(new MovingCircle(this));
					MovingCircle thisCircle = this.circles.get(i);
					thisCircle.move();
					thisCircle.show(255, 100, 92);	
				}
			}
			else if (cc <= 315) {
				if (yet == false) {
					this.circles.clear();
					this.clear();
					this.background(255, 255, 255);
					yet = true;
				}		
				if (this.circles.size() < 20)
					this.circles.add(new MovingCircle(this));
				for (int i=0; i<5; i++) {	
					this.circles.add(new MovingCircle(this));
					MovingCircle thisCircle = this.circles.get(i);
					thisCircle.move();
					thisCircle.show(255, 100, 92);	
				}
			}
			else {
				this.circles.clear();
				this.clear();
				this.background(0, 0, 0);
			}
			
		}
			
}



