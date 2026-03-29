Click ⭐if you like the project. Pull Requests are highly appreciated. We can connect on [@PraveenKumar](https://www.linkedin.com/in/praveen-kumar-tadipalli)
| No. | Questions |
|-----|----------|
| 1 | [Find list of employees whose name starts with alphabet A](#find-list-of-employees-whose-name-starts-with-alphabet-a) |
| 2 | [Group The employees By Department Names](#group-the-employees-by-department-names) |
| 3 | [Find the total count of employees using stream](#find-the-total-count-of-employees-using-stream) |
| 4 | [Find the max age of employees](#find-the-max-age-of-employees) |
| 5 | [Find all department names](#find-all-department-names) |
| 6 | [Find the count of employee in each department](#find-the-count-of-employee-in-each-department) |
| 7 | [Find the list of employees whose age is less than 30](#find-the-list-of-employees-whose-age-is-less-than-30) |
| 8 | [Find the list of employees whose age is in between 26 and 31](#find-the-list-of-employees-whose-age-is-in-between-26-and-31) |
| 9 | [Find the average age of male and female employee](#find-the-average-age-of-male-and-female-employee) |
| 10 | [Find the department who is having maximum number of employee](#find-the-department-who-is-having-maximum-number-of-employee) |
| 11 | [Find the Employee who stays in Delhi and sort them by their names](#find-the-employee-who-stays-in-delhi-and-sort-them-by-their-names) |
| 12 | [Find the average salary in all departments](#find-the-average-salary-in-all-departments) |
| 13 | [Find the highest salary in each department](#find-the-highest-salary-in-each-department) |
| 14 | [Find the list of employee and sort them by their salary](#find-the-list-of-employee-and-sort-them-by-their-salary) |
| 15 | [Find the employee who has second highest salary](#find-the-employee-who-has-second-highest-salary) |

### Find list of employees whose name starts with alphabet A

```java
 List<Employees> aEmployee = employees.stream()
                .filter(emp -> emp.getName().startsWith("A"))
                .toList();
```
### 2. Group The employees By Department Names
```java
Map<String, List<Employees>> deptGroup = employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.getDepartNames()));
```

### 3. Find the total count of employees using stream
```java
long count = employees.stream()
                .count();
```
### 4. Find the max age of employees
```java
 int maxAge = employees.stream()
                .mapToInt(emp -> emp.getAge())
                .max().getAsInt();
```
### 5. Find all department names
```java
List<String> deptNames = employees.stream()
                .map(Employees::getDepartNames)
                .toList();
```
### 6. Find the count of employee in each department
```java
 Map<String, Long> empDeptCount = employees.stream()
                .collect(Collectors.groupingBy(Employees::getDepartNames, Collectors.counting()));
```
### 7. Find the list of employees whose age is less than 30
```java
List<Employees> employeesLessThanAge30 = employees.stream()
                .filter(emp -> emp.getAge() < 30)
                .toList();
```
### 8. Find the list of employees whose age is in between 26 and 31
```java
List<Employees> emplyeesAgeGreaterThanAndLessThan26And31 = employees.stream()
                .filter(emp -> emp.getAge() > 26 && emp.getAge() < 31)
                .toList();
```
### 9. Find the average age of male and female employee
```java
Map<String, Double> avgOfEmployeesBasedOnGender = employees.stream()
                .collect(Collectors.groupingBy(Employees::getGender, Collectors.averagingInt(Employees::getAge)));
```
### 10. Find the department who is having maximum number of employee
```java
 Map<String, Long> groupByDept = employees.stream()
                .collect(Collectors.groupingBy(Employees::getDepartNames, Collectors.counting()));
        Map.Entry<String, Long> maxEmployeesInDept = groupByDept.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get();
```
### 11. Find the Employee who stays in Delhi and sort them by their names
```java
List<Employees> employeesStayingInDelhi = employees.stream()
                .filter(emp -> emp.getAddress().equals("Delhi"))
                .sorted(Comparator.comparing(Employees::getName))
                .toList();
```
### 12. Find the average salary in all departments
```java
 Map<String, Double> avgSalaryOfEachDept = employees.stream()
                .collect(Collectors.groupingBy(Employees::getDepartNames, Collectors.averagingDouble(Employees::getSalary)));
```
### 13. Find the highest salary in each department
```java
Map<String, Optional<Employees>> highestSalaryInEachDept = employees.stream()
                .collect(Collectors.groupingBy(Employees::getDepartNames, Collectors.maxBy(Comparator.comparingDouble(Employees::getSalary))));
```
### 14. Find the list of employee and sort them by their salary
```java
List<Employees> employeesSortedBySalary = employees.stream()
                .sorted(Comparator.comparing(Employees::getSalary))
                .toList();
```
### 15. Find the employee who has second lowest salary
```java
Employees secondLowestSalaryEmp = employees.stream()
                .sorted(Comparator.comparing(Employees::getSalary))
                .skip(1)
                .findFirst()
                .get();
```
