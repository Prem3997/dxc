package demo;

public class PermanentEmployee extends Employee {
	private int regularSalary;
	private int bonus;

	public PermanentEmployee() {
		// TODO Auto-generated constructor stub
	}

	public PermanentEmployee(int employeeId, String employeeName) {
		super(employeeId, employeeName);
		// TODO Auto-generated constructor stub
	}

	public PermanentEmployee(int regularSalary, int bonus) {
		super();
		this.regularSalary = regularSalary;
		this.bonus = bonus;
	}

	public int getRegularSalary() {
		return regularSalary;
	}

	public void setRegularSalary(int regularSalary) {
		this.regularSalary = regularSalary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "PermanentEmployee [regularSalary=" + regularSalary + ", bonus=" + bonus + ", getEmployeeId()="
				+ getEmployeeId() + ", getEmployeeName()=" + getEmployeeName() + "]";
	}	
}
