package POJOEx5;

import java.util.List;

public class Employee5Pojo {
	private String name;
	private int age;
	private float salary;
	private EmpAddress5POJO empAddress;
	private List<String> bank;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public EmpAddress5POJO getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(EmpAddress5POJO empAddress) {
		this.empAddress = empAddress;
	}
	public List<String> getBank() {
		return bank;
	}
	public void setBank(List<String> bank) {
		this.bank = bank;
	}
	
}
