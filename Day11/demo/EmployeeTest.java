package demo;

public class EmployeeTest {
	public static void main(String[] args) {
		PermanentEmployee employee=new PermanentEmployee(11576718,"Prem");
		employee.setRegularSalary(100000);
		employee.setBonus(5000);
		System.out.println("Permanent Employee");
		System.out.println(employee);
		ContractEmployee contractEmployee=new ContractEmployee(12345,"ABC");
		contractEmployee.setContractDuration(12);
		contractEmployee.setPayPerHour(2000);
		System.out.println("Contract Employee");
		System.out.println(contractEmployee);
	}
}
