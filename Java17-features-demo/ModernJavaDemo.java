import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ModernJavaDemo {
    public static void main(String[] args) {
        demonstrateSwitchExpressions();
        demonstrateLambdaWithCollections();
    }

    private static void demonstrateSwitchExpressions() {
        System.out.println("\n=== Switch Expression Demo ===");

        // Traditional day of week example using new switch expression syntax
        for (var day : List.of("MONDAY", "FRIDAY", "SUNDAY", "INVALID")) {
            var typeOfDay = switch (day) {
                case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> "Weekday";
                case "SATURDAY", "SUNDAY" -> "Weekend";
                default -> {
                    System.out.println("Invalid day: " + day);
                    yield "Unknown";
                }
            };
            System.out.printf("%s is a %s%n", day, typeOfDay);
        }

        // Switch expression with complex return types
        record Person(String name, String role) {}
        var employee = new Person("Alice", "DEVELOPER");

        String message = switch (employee.role()) {
            case "DEVELOPER" -> {
                var prefix = "Technical Team";
                yield prefix + ": " + employee.name() + " writes code";
            }
            case "MANAGER" -> "Management: " + employee.name() + " leads teams";
            case "DESIGNER" -> "Creative: " + employee.name() + " designs UIs";
            default -> employee.name() + " has an unknown role";
        };
        System.out.println(message);
    }

    private static void demonstrateLambdaWithCollections() {
        System.out.println("\n=== Lambda with Collections Demo ===");

        // Sample employee data
        record Employee(String name, String department, double salary) {}

        var employees = List.of(
                new Employee("John", "IT", 75000),
                new Employee("Alice", "IT", 82000),
                new Employee("Bob", "HR", 65000),
                new Employee("Carol", "HR", 67000),
                new Employee("David", "IT", 85000)
        );

        // Using lambda with filter and map
        System.out.println("IT Department employees with salary > 80000:");
        employees.stream()
                .filter(e -> e.department().equals("IT"))
                .filter(e -> e.salary() > 80000)
                .map(Employee::name)
                .forEach(name -> System.out.println("- " + name));

        // Group employees by department with average salary
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.averagingDouble(Employee::salary)
                ));

        System.out.println("\nAverage salary by department:");
        avgSalaryByDept.forEach((dept, avgSalary) ->
                System.out.printf("%s Department: $%.2f%n", dept, avgSalary));

        // Find highest paid employee using lambda and comparison
        var highestPaid = employees.stream()
                .max((e1, e2) -> Double.compare(e1.salary(), e2.salary()))
                .orElseThrow();

        System.out.printf("\nHighest paid employee: %s ($%.2f)%n",
                highestPaid.name(), highestPaid.salary());

        // Demonstrate method reference and collectors
        var departmentCounts = employees.stream()
                .map(Employee::department)
                .collect(Collectors.groupingBy(
                        dept -> dept,
                        Collectors.counting()
                ));

        System.out.println("\nEmployee count by department:");
        departmentCounts.forEach((dept, count) ->
                System.out.printf("%s: %d employees%n", dept, count));
    }
}