package kh.edu.paragoniu.demo.controller;

import kh.edu.paragoniu.demo.entity.Faculty;
import kh.edu.paragoniu.demo.service.FacultyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/faculties")
public class FacultyController {
    private FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    //Get&Post mapping for add_faculty page
    @GetMapping("/add_faculty")
    public String addFaculty(Model model) {
        model.addAttribute("faculty", new Faculty());
        return "add_faculty";
    }

    @PostMapping("/add_faculty")
    public String addFaculty(@ModelAttribute Faculty faculty) {
        facultyService.addFaculty(faculty);
        return "redirect:/faculties/all_facultys";
    }

    @GetMapping("/all_facultys")
    public String allFaculty(Model model) {
        model.addAttribute("faculties", facultyService.getAllFaculty());
        return "all_facultys";
    }

    @GetMapping("/faculty/{id}")
    public String showFaculty(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("faculty", facultyService.getFacultyById(id));
        return "show_faculty";
    }

    @GetMapping("/faculty/edit/{id}")
    public String editFaculty(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("faculty", facultyService.getFacultyById(id));
        return "edit_faculty";
    }

    @PostMapping("/faculty/edit/{id}")
    public String editFaculty(@PathVariable("id") Integer id, Faculty faculty) {
        facultyService.updateFaculty(id, faculty);
        return "redirect:/faculties/all_facultys";
    }

    @PostMapping("/faculty/delete/{id}")
    public String deleteFaculty(@PathVariable("id") Integer id) {
        facultyService.deleteFaculty(id);
        return "redirect:/faculties/all_facultys";
    }

}
