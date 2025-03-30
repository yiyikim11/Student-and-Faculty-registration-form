package kh.edu.paragoniu.demo.controller;

import kh.edu.paragoniu.demo.entity.Student;
import kh.edu.paragoniu.demo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //following the steps of CRUD (Create, Read(All, One), Update, Delete)
    @GetMapping("/add_student")
    //Create
    public String addStudent(Model model) { //get info from student as model and link it to mysql
        model.addAttribute("student", new Student()); //add attribute to html file and create new class Student for that one
        return "add_student";
    }
    @PostMapping("/add_student") //this method get info from html as model and in getMethod vea store jea class so need to have object here
    public String addStudent(Student student){
        studentService.addStudent(student);
        return "redirect:/students/all_students";
    } //redirect ng pause & request again. ber ot redirect te vea continue to add 2 student

    //Read all
//    @GetMapping("/all_students")
//    public String allStudents(Model model){
//        model.addAttribute("students", studentService.getAllStudents());
//        return "all_students";
//    }

    @GetMapping("/all_students")
    public String allStudents(Model model){
        List<Student> studentList = studentService.getAllStudents();
        System.out.println("Fetched Students: " + studentList);
        model.addAttribute("students", studentList);
        return "all_students";
    }


    //read one
    @GetMapping("/student/{id}")
    public String showStudent(@PathVariable("id") Integer id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "show_student";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") Integer id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") Integer id, Student student){
        studentService.updateStudent(id, student);
        return "redirect:/students/all_students";
    }

    //delete
    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id){
        studentService.deleteStudent(id);
        return "redirect:/students/all_students";
    }
}

