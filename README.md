Click ⭐if you like the project. Pull Requests are highly appreciated. We can connect on [@PraveenKumar](https://www.linkedin.com/in/praveen-kumar-tadipalli)
| No. | Questions |
|-----|----------|
| 1 | [Find list of employees whose name starts with alphabet A](#q1) |
| 2 | [Group The employees By Department Names](#q2) |
| 3 | [Find the total count of employees using stream](#q3) |
| 4 | [Find the max age of employees](#q4) |
| 5 | [Find all department names](#q5) |
| 6 | [Find the count of employee in each department](#q6) |
| 7 | [Find the list of employees whose age is less than 30](#q7) |
| 8 | [Find the list of employees whose age is in between 26 and 31](#q8) |
| 9 | [Find the average age of male and female employee](#q9) |
| 10 | [Find the department who is having maximum number of employee](#q10) |
| 11 | [Find the Employee who stays in Delhi and sort them by their names](#q11) |
| 12 | [Find the average salary in all departments](#q12) |
| 13 | [Find the highest salary in each department](#q13) |
| 14 | [Find the list of employee and sort them by their salary](#q14) |
| 15 | [Find the employee who has second highest salary](#q15) |

<a name="q1"></a>
### 1. Find list of employees whose name starts with alphabet A

```java
 List<Employees> aEmployee = employees.stream()
                .filter(emp -> emp.getName().startsWith("A"))
                .toList();
```
<a name="q2"></a>
### 2. Group The employees By Department Names
```java
Map<String, List<Employees>> deptGroup = employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.getDepartNames()));
```
<a name="q3"></a>
### 3. Find the total count of employees using stream
```java
long count = employees.stream()
                .count();
```
<a name="q4"></a>
### 4. Find the max age of employees
```java
 int maxAge = employees.stream()
                .mapToInt(emp -> emp.getAge())
                .max().getAsInt();
```
<a name="q5"></a>
### 5. Find all department names
```java
List<String> deptNames = employees.stream()
                .map(Employees::getDepartNames)
                .toList();
```
<a name="q6"></a>
### 6. Find the count of employee in each department
```java
 Map<String, Long> empDeptCount = employees.stream()
                .collect(Collectors.groupingBy(Employees::getDepartNames, Collectors.counting()));
```
<a name="q7"></a>
### 7. Find the list of employees whose age is less than 30
```java
List<Employees> employeesLessThanAge30 = employees.stream()
                .filter(emp -> emp.getAge() < 30)
                .toList();
```
<a name="q8"></a>
### 8. Find the list of employees whose age is in between 26 and 31
```java
List<Employees> emplyeesAgeGreaterThanAndLessThan26And31 = employees.stream()
                .filter(emp -> emp.getAge() > 26 && emp.getAge() < 31)
                .toList();
```
<a name="q9"></a>
### 9. Find the average age of male and female employee
```java
Map<String, Double> avgOfEmployeesBasedOnGender = employees.stream()
                .collect(Collectors.groupingBy(Employees::getGender, Collectors.averagingInt(Employees::getAge)));
```
<a name="q10"></a>
### 10. Find the department who is having maximum number of employee
```java
 Map<String, Long> groupByDept = employees.stream()
                .collect(Collectors.groupingBy(Employees::getDepartNames, Collectors.counting()));
        Map.Entry<String, Long> maxEmployeesInDept = groupByDept.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get();
```
<a name="q11"></a>
### 11. Find the Employee who stays in Delhi and sort them by their names
```java
List<Employees> employeesStayingInDelhi = employees.stream()
                .filter(emp -> emp.getAddress().equals("Delhi"))
                .sorted(Comparator.comparing(Employees::getName))
                .toList();
```
<a name="q12"></a>
### 12. Find the average salary in all departments
```java
 Map<String, Double> avgSalaryOfEachDept = employees.stream()
                .collect(Collectors.groupingBy(Employees::getDepartNames, Collectors.averagingDouble(Employees::getSalary)));
```
<a name="q13"></a>
### 13. Find the highest salary in each department
```java
Map<String, Optional<Employees>> highestSalaryInEachDept = employees.stream()
                .collect(Collectors.groupingBy(Employees::getDepartNames, Collectors.maxBy(Comparator.comparingDouble(Employees::getSalary))));
```
<a name="q14"></a>
### 14. Find the list of employee and sort them by their salary
```java
List<Employees> employeesSortedBySalary = employees.stream()
                .sorted(Comparator.comparing(Employees::getSalary))
                .toList();
```
<a name="q15"></a>
### 15. Find the employee who has second lowest salary
```java
Employees secondLowestSalaryEmp = employees.stream()
                .sorted(Comparator.comparing(Employees::getSalary))
                .skip(1)
                .findFirst()
                .get();
```
