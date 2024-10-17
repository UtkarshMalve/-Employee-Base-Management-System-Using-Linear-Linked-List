package DSProblem;

import java.util.Scanner;

class Employee {
    int id;
    String name;
    double sal;
    String email;
	public Employee next;

    Employee(int id, String name, double sal, String email) {
        this.id = id;
        this.name = name;
        this.sal = sal;
        this.email = email;
    }
}

class LinkedList {
    Employee head;

    void addEmployee(Employee newEmployee) {
        if (head == null) {
            head = newEmployee;
        } else {
            Employee current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newEmployee;
        }
        System.out.println("Employee added successfully.");
    }

    Employee findEmployeeById(int id) {
        Employee current = head;
        while (current != null) {
            if (current.id == id) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    void displayEmployees() {
        Employee current = head;
        System.out.println("Employee Information:");
        while (current != null) {
            System.out.println("ID: " + current.id + ", Name: " + current.name + ", Salary: " + current.sal + ", Email: " + current.email);
            current = current.next;
        }
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList employeeList = new LinkedList();

        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Find Employee by ID");
            System.out.println("3. Display All Employees");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter employee name: ");
                    String name = scanner.next();
                    System.out.print("Enter employee salary: ");
                    double salary = scanner.nextDouble();
                    System.out.print("Enter employee email: ");
                    String email = scanner.next();
                    employeeList.addEmployee(new Employee(id, name, salary, email));
                    break;
                case 2:
                    System.out.print("Enter employee ID to search: ");
                    int searchId = scanner.nextInt();
                    Employee foundEmployee = employeeList.findEmployeeById(searchId);
                    if (foundEmployee != null) {
                        System.out.println("Employee found:");
                        System.out.println("ID: " + foundEmployee.id + ", Name: " + foundEmployee.name + ", Salary: " + foundEmployee.sal + ", Email: " + foundEmployee.email);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 3:
                    employeeList.displayEmployees();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}