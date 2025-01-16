import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Java6Demo {
    public static void main(String[] args) {
        demonstrateSwitchExpressions();
        demonstrateLambdaWithCollections();
    }

    private static void demonstrateSwitchExpressions() {
        System.out.println("\n=== Switch Expression Demo ===");

        // Traditional day of week example using new switch expression syntax
        for (String day : List.of("MONDAY", "FRIDAY", "SUNDAY", "INVALID")) {
            String typeOfDay;
            switch (day) {
                case "MONDAY":
                case "TUESDAY":
                case "WEDNESDAY":
                case "THURSDAY":
                case "FRIDAY":
                    typeOfDay = "Weekday";
                    break;
                case "SATURDAY":
                case "SUNDAY":
                    typeOfDay = "Weekend";
                    break;
                default:
                    System.out.println("Invalid day: " + day);
                    typeOfDay = "Unknown";
                    break;
            }
            System.out.printf("%s is a %s%n", day, typeOfDay);
        }

        // Switch expression with complex return types
        class Person {
            private String name;
            private String role;

            public Person(String name, String role) {
                this.name = name;
                this.role = role;
            }

            public String getRole() {
                return role;
            }
        }

        var employee = new Person("Alice", "DEVELOPER");

        String message;
        switch (employee.getRole()) {
            case "DEVELOPER":
                message = "Technical Team: " + employee.name + " writes code";
                break;
            case "MANAGER":
                message = "Management: " + employee.name + " leads teams";
                break;
            case "DESIGNER":
                message = "Creative: " + employee.name + " designs UIs";
                break;
            default:
                message = employee.name + " has an unknown role";
        }
        System.out.println(message);
    }

    private static void demonstrateLambdaWithCollections() {
        System.out.println("\n=== Lambda with Collections Demo ===");

        // Sample employee data
        class Employee {
            private String name;
            private String department;
            private double salary;

            public Employee(String name, String department, double salary) {
                this.name = name;
                this.department = department;
                this.salary = salary;
            }

            public String getDepartment() {
                return department;
            }

            public double getSalary() {
                return salary;
            }
        }

        var employees = List.of(
                new Employee("John", "IT", 75000),
                new Employee("Alice", "IT", 82000),
                new Employee("Bob", "HR", 65000),
                new Employee("Carol", "HR", 67000),
                new Employee("David", "IT", 85000)
        );

        // Using lambda with filter and map
        System.out.println("IT Department employees with salary > 80000:");
        for (Employee employee : employees) {
            if (employee.getDepartment().equals("IT") && employee.getSalary() > 80000) {
                System.out.println("- " + employee.name);
            }
        }

        // Group employees by department with average salary
        Map<String, Double> avgSalaryByDept = new HashMap<>();
        for (Employee employee : employees) {
            String dept = employee.getDepartment();
            double salary = employee.getSalary();
            if (!avgSalaryByDept.containsKey(dept)) {
                avgSalaryByDept.put(dept, 0.0);
            }
            avgSalaryByDept.put(dept, avgSalaryByDept.get(dept) + salary);
        }

        for (Map.Entry<String, Double> entry : avgSalaryByDept.entrySet()) {
            String dept = entry.getKey();
            double avgSalary = entry.getValue() / employees.size();

            System.out.printf("%s Department: $%.2f%n", dept, avgSalary);
        }

        // Find highest paid employee using lambda and comparison
        Employee highestPaid = null;
        for (Employee employee : employees) {
            if (highestPaid == null || employee.getSalary() > highestPaid.getSalary()) {
                highestPaid = employee;
            }
        }
        System.out.printf("\nHighest paid employee: %s ($%.2f)%n",
                highestPaid.name, highestPaid.salary);

        // Demonstrate method reference and collectors
        Map<String, Integer> departmentCounts = new HashMap<>();
        for (Employee employee : employees) {
            String dept = employee.getDepartment();
            if (!departmentCounts.containsKey(dept)) {
                departmentCounts.put(dept, 0);
            }
            departmentCounts.put(dept, departmentCounts.get(dept) + 1);
        }

        System.out.println("\nEmployee count by department:");
        for (Map.Entry<String, Integer> entry : departmentCounts.entrySet()) {
            String dept = entry.getKey();
            int count = entry.getValue();

            System.out.printf("%s: %d employees%n", dept, count);
        }
    }
}

