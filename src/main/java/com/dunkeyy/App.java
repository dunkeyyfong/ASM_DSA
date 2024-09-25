package com.dunkeyy;

import java.util.Scanner;

import com.Student.StudentInformation;
import com.Student.StudentManagement;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        Scanner sc = new Scanner(System.in);

        while (true) { 

            StudentInformation student = null;

            System.out.println("====================================");
            System.out.println("|    STUDENT MANAGEMENT SYSTEM      |");
            System.out.println("====================================");
            System.out.println("| Options:                          |");
            System.out.println("|        1. Add Student             |");
            System.out.println("|        2. Edit Students           |");
            System.out.println("|        3. Delete Student          |");
            System.out.println("|        4. Sort Students           |");
            System.out.println("|        5. Display Students        |");
            System.out.println("|        6. Search                  |");
            System.out.println("|        7. Exit                    |");
            System.out.println("====================================");
            System.out.print("Select option: ");

            try {
                
                int option = sc.nextInt();
                sc.nextLine();


                switch (option) {
                    case 1:
                        System.out.print("Enter Student ID: ");
                        String id = sc.nextLine();
                        System.out.print("Enter Student Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Student Marks: ");
                        double marks = sc.nextDouble();
                
                        student = new StudentInformation(id, name, marks);
                        studentManagement.addStudent(student);
                        System.out.println("Add Student");
                        break;

                    case 2:
                        System.out.print("Enter Student ID: ");
                        String idEdit = sc.nextLine();
                        System.out.print("Enter New Student Name: ");
                        String nameEdit = sc.nextLine();
                        System.out.print("Enter New Student Marks: ");
                        double marksEdit = sc.nextDouble();
                        studentManagement.editStudent(idEdit, nameEdit, marksEdit);
                        System.out.println("Edited Student!");

                        break;
                    case 3:
                        System.out.println("Enter Student ID: ");
                        String idDelete = sc.next();
                        studentManagement.deleteStudent(idDelete);
                        System.out.println("Deleted Student!");
                        break;
                    case 4:
                        System.out.println("====================================");
                        System.out.println("| 1. Bubble Sort                   |");
                        System.out.println("| 2. Selection Sort                |");
                        System.out.println("| 3. Quick Sort                    |");
                        System.out.println("====================================");
                        System.out.print("Choose an sort option: ");
                        int sortchoice = sc.nextInt();
                        sc.nextLine();

                        switch (sortchoice) {
                            case 1:
                                studentManagement.sortStudents(1);
                                System.out.println("Sorted by Bubble Sort");
                                break;

                            case 2:
                                studentManagement.sortStudents(2);
                                System.out.println("Sorted by Selection Sort");
                                break;

                            case 3:
                                studentManagement.sortStudents(3);
                                System.out.println("Sorted by Quick Sort");
                                break;

                            default:
                                throw new AssertionError();
                        }

                        break;
                    case 5:
                        System.out.println("Display Students");
                        studentManagement.displayStudents();
                        break;
                    case 6:
                        System.out.println("Enter Student ID: ");
                        String idSearch = sc.next();
                        studentManagement.searchStudent(idSearch);
                        break;
                    case 7:
                        System.out.println("Exit");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Option");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Invalid Input");
                sc.next();
            }
        }
    }
}
