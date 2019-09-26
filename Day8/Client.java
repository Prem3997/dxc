class Apple{
	public void displayApple(){
		System.out.println("Apple is Displayed");
	}
}
class Ball{
	public void displayBall() {
		System.out.println("Ball is Displayed");
	}
}
class Cat{
	public void displayCat() {
		System.out.println("Cat is Displayed");
	}
}
class Dog{
	public void displayDog() {
		System.out.println("Dog is Displayed");
	}
}
class Elephant{
	public void displayElephant() {
		System.out.println("Elephant is Displayed");
	}
}
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Apple a=new Apple();
		Ball b=new Ball();
		Cat c=new Cat();
		Dog d=new Dog();
		Elephant e=new Elephant();
		a.displayApple();
		b.displayBall();
		c.displayCat();
		d.displayDog();
		e.displayElephant();
		hr.Customer cust=new hr.Customer();
		cust.displayCustomer();
	}

}
