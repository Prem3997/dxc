package animal1;

public  abstract class Animal {
	int picture;
	String food;
	int hunger;
	int boundaries;
	String location;
	public  void sleep() {
		System.out.println("All Animals wil Sleep");
	}
	public abstract void eat();
	public abstract void makeNoise();
	public abstract void roam();
}
