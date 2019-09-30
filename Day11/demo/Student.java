package demo;

public class Student {
	private int regNo;
	private String name;
	public Student(int regNo) {
		super();
		this.regNo = regNo;
	}
	public Student(String name) {
		super();
		this.name = name;
	}
	
	public Student(int regNo, String name) {
		super();
		this.regNo = regNo;
		this.name = name;
	}
	public int getRegNo() {
		return regNo;
	}
	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
