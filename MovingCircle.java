
public class MovingCircle {
	
	private int x = (int)(Math.random() * ((800) + 1));
	private int y = (int)(Math.random() * ((800) + 1));
	
	private int maxSpeed = 6;
	
	private int speedX = 1;
	private int speedY = 1;
	
	TestMovingCircle parent;
	
	public MovingCircle(TestMovingCircle p) {
		//generate a random location for this object in both x and y coordinates
		this.x = (int) (Math.random() * p.width);
		this.y = (int) (Math.random() * p.height);
		
		//generate random speed for this object in both the x and y directions.
		this.speedX = (int) (Math.random() * this.maxSpeed);
		this.speedY = (int) (Math.random() * this.maxSpeed);
		
		//keep a reference to the parent object.  By "parent object", I mean the  object which called this constructor by instantiating this object.
		this.parent = p;
		
	}
	
	

	public void move() {
		//update the x and y variables by the amount determined in the speedX  and speedY variables.
		this.x += this.speedX;
		this.y += this.speedY;
	}
	
	public void move(float a, float b) {
		this.x += (int) a;
		this.y += (int) b;
	}
	
	public void show() {
		//first check that this object stays within bounds
		this.checkBounds();
		
		//now draw it to the screen
		parent.fill(255, 255, 255); //change the fill color to white
		parent.ellipse(x, y, 50, 50); //draw the ellipse representing this  object to the parent object's screen.
	}
	
	public void show(float a, float b, float c) {
		this.checkBounds();
		
		parent.fill(a, b, c); //change the fill color to white
		parent.ellipse(x, y, 50, 50);
	}
	
	public void checkBounds() {
		//check whether the object went out of bounds in the x direction
		if (this.x > parent.width) {
			//if the object went too far to the right, start it from the left  again.
			this.x = 0;
		}
		else if (this.x < 0) {
			//if the object went too far to the left, start it from the right  again.
			this.x = parent.width;
		}
		
		//check whether the object went out of bounds in the y direction
		if (this.y > parent.height){
			//if the object went too far down, start it from the top again.
			this.y = 0;
		}
		else if (this.y < 0) {
			//if the object went too far up, start it from the bottom again.
			this.y = parent.height;
		}
		
	}
}
	
