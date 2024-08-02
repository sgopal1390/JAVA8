import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class OperationOnEmployeeObject {
	
	public static void main(String[] args) {
		
		List<EmployeeStreamOperation> empList = new ArrayList<>();
		empList.add(new EmployeeStreamOperation(1, "abc", 28, 123, "F", "HR", "Blore", 2020));
		empList.add(new EmployeeStreamOperation(2, "xyz", 29, 120, "F", "HR", "Hyderabad", 2015));
		empList.add(new EmployeeStreamOperation(3, "efg", 30, 115, "M", "HR", "Chennai", 2014));
		empList.add(new EmployeeStreamOperation(4, "def", 32, 125, "F", "HR", "Chennai", 2013));

		empList.add(new EmployeeStreamOperation(5, "ijk", 22, 150, "F", "IT", "Noida", 2013));
		empList.add(new EmployeeStreamOperation(6, "mno", 27, 140, "M", "IT", "Gurugram", 2017));
		empList.add(new EmployeeStreamOperation(7, "uvw", 26, 130, "F", "IT", "Pune", 2016));
		empList.add(new EmployeeStreamOperation(8, "pqr", 23, 145, "M", "IT", "Trivandam", 2015));
		empList.add(new EmployeeStreamOperation(9, "stv", 25, 160, "M", "IT", "Blore", 2010));
		
		System.err.println("=====================sort by city=======================");
		
		//sort by city
		empList.stream().collect(Collectors.groupingBy(EmployeeStreamOperation::getCity)).entrySet().stream().forEach(System.out::println);
		
		System.err.println("======================find the count of male and female======================");
		
		//find the count of male and female
		empList.stream().collect(Collectors.groupingBy(EmployeeStreamOperation::getGender,Collectors.counting())).entrySet().stream().forEach(System.out::println);
	
		System.err.println("====================get all names of departments========================");
		
		//get all names of departments
		empList.stream().collect(Collectors.groupingBy(EmployeeStreamOperation::getDeptName)).entrySet().stream().map(m->m.getKey()).collect(Collectors.toUnmodifiableList()).forEach(System.out::println);
		
		System.err.println("========================employee id whose age is greater than 25====================");
		
		//employee id whose age is greater than 25
		empList.stream().filter(e->e.getAge()>25).map(EmployeeStreamOperation::getId).collect(Collectors.toList()).forEach(System.out::println);;
		
		System.err.println("======================employee details age greater than 25======================");
		
		//employee details age greater than 25
		empList.stream().filter(e->e.getAge()>25).collect(Collectors.toList()).forEach(System.out::println);
		
		System.err.println("=====================find Maximum Age of Employee=======================");
		
		//find Maximum Age of Employee
		System.out.println(empList.stream().sorted(Comparator.comparing(EmployeeStreamOperation::getAge).reversed()).findFirst().get());
		
		System.err.println("=====================Find the department which has the highest number of employees.=======================");
		
		//Find the department which has the highest number of employees.
		System.out.println(empList.stream().collect(Collectors.groupingBy(EmployeeStreamOperation::getDeptName, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get());
		
		System.err.println("=====================Average salary of each department.=======================");
		
		//Average salary of each department.
		empList.stream().collect(Collectors.groupingBy(EmployeeStreamOperation::getDeptName,Collectors.averagingDouble(EmployeeStreamOperation::getSalary))).entrySet().stream().forEach(System.out::println);
	
		System.err.println("=====================Find Highest salary in the organisation..=======================");
		
		//Find Highest salary in the organisation.
		System.out.println(empList.stream().sorted(Comparator.comparing(EmployeeStreamOperation::getSalary).reversed()).findFirst().get());
	
		System.err.println("=====================Find Second Highest salary in the organisation.=======================");
		
	    //Find Second Highest salary in the organisation.
		System.out.println(empList.stream().sorted(Comparator.comparing(EmployeeStreamOperation::getSalary).reversed()).skip(1).findFirst().get());
	
	}
}


class EmployeeStreamOperation {
	private int id;
    private String name;
    private int age;
    private long salary;
    private String gender;
    private String deptName;
    private String city;
    private int yearOfJoining;

    public EmployeeStreamOperation(int id, String name, int age, long salary, String gender, 
                    String deptName, String city, int yearOfJoining) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.deptName = deptName;
        this.city = city;
        this.yearOfJoining = yearOfJoining;
    }

    @Override
    public String toString() {
        return "EmployeeObjectJava8Scenario{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", deptName='" + deptName + '\'' +
                ", city='" + city + '\'' +
                ", yearOfJoining='" + yearOfJoining + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }
}