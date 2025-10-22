package POJOEx2;

public class Employee2pojo {
	
	private String name;
	private String job;
	private boolean isMarried;
	private float salary;
	private EmpAddressPojo empAddress;
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
	public EmpAddressPojo getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(EmpAddressPojo empAddress) {
		this.empAddress = empAddress;
	}
	
	
}
