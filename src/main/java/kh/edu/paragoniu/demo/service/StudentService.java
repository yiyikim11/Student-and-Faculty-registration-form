package kh.edu.paragoniu.demo.service;

import kh.edu.paragoniu.demo.entity.Student;
import kh.edu.paragoniu.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;
//whenever a student create a class, they gonna have their own repository
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
}
//CRUD: Create
    public void addStudent(Student student) {
        studentRepository.save(student);
    }
//Read
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    public Student getStudentById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        }
        return null;
    }
    // Update, integer use to find the thing we want to update
//    public void updateStudent(Integer id, Student student) {
//        Student updatingStudent = getStudentById(id);
//        updatingStudent.setUserName(student.getUserName());
//        updatingStudent.setFirstName(student.getFirstName());
//        updatingStudent.setLastName(student.getLastName());
//        updatingStudent.setGender(student.getGender());
//        updatingStudent.setDepartment(student.getDepartment());
//        studentRepository.save(updatingStudent);
//    }
    public void updateStudent(Integer id, Student student) {
        Student updatingStudent = getStudentById(id);
        if (updatingStudent == null) {
            throw new IllegalArgumentException("Student with ID " + id + " not found.");
        }
        updatingStudent.setUserName(student.getUserName());
        updatingStudent.setFirstName(student.getFirstName());
        updatingStudent.setLastName(student.getLastName());
        updatingStudent.setGender(student.getGender());
        updatingStudent.setDepartment(student.getDepartment());
        studentRepository.save(updatingStudent);
    }


    //Delete student
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
}
