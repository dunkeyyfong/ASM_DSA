package com.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentManagement {
    private final List<StudentInformation> students = new ArrayList<>();

    public void addStudent(StudentInformation student) {
        for (StudentInformation estStudent : students) {
            if (estStudent.getId().equals(student.getId())) {
                System.out.println("Student ID already exists!");
                return;
            }
        }

        if(student.getMarks() < 0 || student.getMarks() > 10) {
            System.out.println("Marks must be between 0 and 10!");
            return;
        }

        students.add(student);
        System.out.println("Add student successfully!");
    }

    public void editStudent(String id, String newName, double newMarks) {
        for (StudentInformation student : students) {

            if(newMarks < 0 || newMarks > 10) {
                System.out.println("Marks must be between 0 and 10!");
                return;
            }

            if (student.getId().equals(id)) {
                student.setName(newName);
                student.setMarks(newMarks);
                System.out.println("Edit student successfully!");
                return;
            }
        }

        System.out.println("Student ID does not exist!");
    }

    public void deleteStudent(String id) {
        students.removeIf(student -> student.getId().equals(id));

    }

    public void sortStudents(int sc) {
        int n = students.size();
    
        switch (sc) {
            case 1:
                // Bubble sort
                for (int i = 0; i < n - 1; i++) {
                    for (int j = i + 1; j < n; j++) {
                        if (students.get(j).getMarks() < students.get(i).getMarks()) {
                            StudentInformation temp = students.get(i);
                            students.set(i, students.get(j));
                            students.set(j, temp);
                        }
                    }
                }
                break;
    
            case 2:
                // Selection sort
                for (int i = 0; i < n - 1; i++) {
                    int min = i;
                    for (int j = i + 1; j < n; j++) {
                        if (students.get(j).getMarks() < students.get(min).getMarks()) {
                            min = j;
                        }
                    }
                    StudentInformation temp = students.get(min);
                    students.set(min, students.get(i));
                    students.set(i, temp);
                }
                break;
    
            case 3:
                // Quick sort
                quickSort(0, n - 1);
                break;
    
            default:
                break;
        }
    }

    public void displayStudents() {
        if(!students.isEmpty()) {
            for (StudentInformation student : students) {
                System.out.println(student);
            }
        } else {
            System.out.println("No student in the list!");
        }
    }

    public void searchStudent(String id) {
        for (StudentInformation student : students) {
            if (student.getId().equals(id)) {
                System.out.println(student);
                return;
            }
        }

        System.out.println("Student ID does not exist!");
    }
    
    private void quickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }
    
    private int partition(int low, int high) {
        double pivot = students.get(high).getMarks();
        int i = low - 1;
    
        for (int j = low; j < high; j++) {
            if (students.get(j).getMarks() < pivot) {
                i++;
                StudentInformation temp = students.get(i);
                students.set(i, students.get(j));
                students.set(j, temp);
            }
        }
    
        StudentInformation temp = students.get(i + 1);
        students.set(i + 1, students.get(high));
        students.set(high, temp);
    
        return i + 1;
    }
}
