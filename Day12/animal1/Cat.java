package animal1;

public class Cat extends Felline {
	int place;
	
	public Cat() {
		super();
	}
	public Cat(int place) {
		super();
		this.place = place;
	}
	public int getPlace() {
		return place;
	}
	public void setPlace(int place) {
		this.place = place;
	}
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("All Cat will eat Mouse");

	}

	@Override
	public void makeNoise() {
		// TODO Auto-generated method stub
		System.out.println("All Cat will make MEOW");

	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + place;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		if (place != other.place)
			return false;
		return true;
	}
}
