package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeesStreams {
    static List<Employees> employees = Arrays.asList(
            new Employees(1, "Abraham", 29, "IT", "Mumbai", 20000, "Male"),
            new Employees(2, "Mary", 27, "Sales", "Chennai", 25000, "Female"),
            new Employees(3, "Joe", 28, "IT", "Chennai", 22000, "Male"),
            new Employees(4, "John", 29, "Sales", "Gurgaon", 29000, "Male"),
            new Employees(5, "Liza", 25, "Sales", "Bangalore", 32000, "Female"),
            new Employees(6, "Peter", 27, "Admin", "Mumbai", 31500, "Male"),
            new Employees(7, "Harry", 30, "Research", "Kochi", 21000, "Male")
    );
    public static void main(String[] args) {
        //Find list of employees whose name starts with alphabet A
        List<Employees> aEmployee = employees.stream()
                .filter(emp -> emp.getName().startsWith("A"))
                .toList();
        System.out.println("1.list of employees whose name starts with alphabet A\n"+aEmployee);
        //Group The employees By Department Names
        Map<String, List<Employees>> deptGroup = employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.getDepartNames()));
        System.out.println("2.Group The employees By Department Names\n"+deptGroup);
        //Find the total count of employees using stream
        long count = employees.stream()
                .count();
        System.out.println("3.the total count of employees using stream:"+count);
//        Find the max age of employees
//        Employees maxAge = employees.stream()
//                .max(Comparator.comparingInt(emp -> emp.getAge()))
//                .get();
        int maxAge = employees.stream()
                .mapToInt(emp -> emp.getAge())
                .max().getAsInt();
        System.out.println("4.Max age of Employee:"+maxAge);
        //Find all department names
        List<String> deptNames = employees.stream()
                .map(Employees::getDepartNames)
                .toList();
        System.out.println("5.Find all department names\n"+deptNames);
        //Find the count of employee in each department
        Map<String, Long> empDeptCount = employees.stream()
                .collect(Collectors.groupingBy(Employees::getDepartNames, Collectors.counting()));
        System.out.println("6.Find the count of employee in each department\n"+empDeptCount);
        //Find the list of employees whose age is less than 30
        List<Employees> employeesLessThanAge30 = employees.stream()
                .filter(emp -> emp.getAge() < 30)
                .toList();
        System.out.println("7.the list of employees whose age is less than 30\n"+employeesLessThanAge30);
        //Find the list of employees whose age is in between 26 and 31
        List<Employees> emplyeesAgeGreaterThanAndLessThan26And31 = employees.stream()
                .filter(emp -> emp.getAge() > 26 && emp.getAge() < 31)
                .toList();
        System.out.println("8.the list of employees whose age is in between 26 and 31\n"+emplyeesAgeGreaterThanAndLessThan26And31);
        //ind the average age of male and female employee
        Map<String, Double> avgOfEmployeesBasedOnGender = employees.stream()
                .collect(Collectors.groupingBy(Employees::getGender, Collectors.averagingInt(Employees::getAge)));
        System.out.println("9.the average age of male and female employee\n"+avgOfEmployeesBasedOnGender);
        //Find the department who is having maximum number of employee
        Map<String, Long> groupByDept = employees.stream()
                .collect(Collectors.groupingBy(Employees::getDepartNames, Collectors.counting()));
        Map.Entry<String, Long> maxEmployeesInDept = groupByDept.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get();
        System.out.println("10.the department who is having maximum number of employee\n"+maxEmployeesInDept);
        //Find the Employee who stays in Delhi and sort them by their names
        List<Employees> employeesStayingInDelhi = employees.stream()
                .filter(emp -> emp.getAddress().equals("Delhi"))
                .sorted(Comparator.comparing(Employees::getName))
                .toList();
        System.out.println("11.the Employee who stays in Delhi and sort them by their names\n"+employeesStayingInDelhi);
        //Find the average salary in all departments
        Map<String, Double> avgSalaryOfEachDept = employees.stream()
                .collect(Collectors.groupingBy(Employees::getDepartNames, Collectors.averagingDouble(Employees::getSalary)));
        System.out.println("12.the average salary in all departments\n"+avgSalaryOfEachDept);
        //Find the highest salary in each department
        Map<String, Optional<Employees>> highestSalaryInEachDept = employees.stream()
                .collect(Collectors.groupingBy(Employees::getDepartNames, Collectors.maxBy(Comparator.comparingDouble(Employees::getSalary))));
        System.out.println("13.the highest salary in each department\n"+highestSalaryInEachDept);
        //Find the list of employee and sort them by their salary
        List<Employees> employeesSortedBySalary = employees.stream()
                .sorted(Comparator.comparing(Employees::getSalary))
                .toList();
        System.out.println("14.the list of employee and sort them by their salary\n"+employeesSortedBySalary);
        //Find the employee who has second lowest salary
        Employees secondLowestSalaryEmp = employees.stream()
                .sorted(Comparator.comparing(Employees::getSalary))
                .skip(1)
                .findFirst()
                .get();
        System.out.println("15.the employee who has second lowest salary\n"+secondLowestSalaryEmp);
    }
}
