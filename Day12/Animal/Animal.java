package Animal;

public class Animal {
	public void eat() {
		System.out.println("All Animals Eat");
	}
}
class Dog extends Animal{
	public void eat() {
		System.out.println("All Dogs Eat Pedigree");
	}
	public Food eatFood() {
		Food f=new Food();
		f.typesOfFood();
		return f;
	}
}
class Cat extends Animal{
	public void eat() {
		System.out.println("All Cats Eat mouse");
	}
}
class Food{
	public void typesOfFood() {
		System.out.println("Different Types of Food available");
	}
}
class Milk extends Food{
	int quantity;
	public void drinkMilk(){
		System.out.println("Milk is drank");
	}
}