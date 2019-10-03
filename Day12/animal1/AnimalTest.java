package animal1;

public class AnimalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Animal cat=new Cat();
		Cat cat=new Cat();
		cat.sleep();
		cat.roam();
		cat.eat();
		cat.makeNoise();
		Animal a=new Cat();
		a.sleep();
		a.roam();
		a.eat();
		a.makeNoise();
		a=new Lion();
		a.sleep();
		a.roam();
		a.eat();
		a.makeNoise();
		Animal Cat1=new Cat(1);
		Animal Cat2=new Cat(1);
		System.out.println(Cat1.equals(Cat2));
	}

}
