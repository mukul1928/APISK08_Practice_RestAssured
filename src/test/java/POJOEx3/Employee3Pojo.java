package POJOEx3;

import java.util.List;

public class Employee3Pojo {
	
	private String name;
	private String job;
	private boolean isMarried;
	private float salary;
	private EmployeeAddress3Pojo empAddress;
	private List<String> banks;
	
	
	
	
	
	public List<String> getBanks() {
		return banks;
	}
	public void setBanks(List<String> banks) {
		this.banks = banks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public boolean isMarried() {
		return isMarried;
	}
	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public EmployeeAddress3Pojo getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(EmployeeAddress3Pojo empAddress) {
		this.empAddress = empAddress;
	}
	
	
}
