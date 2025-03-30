package kh.edu.paragoniu.demo.service;


import kh.edu.paragoniu.demo.entity.Faculty;
import kh.edu.paragoniu.demo.repository.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {
    private FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {this.facultyRepository = facultyRepository;}

    public void addFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
    }

    public List<Faculty> getAllFaculty() {return facultyRepository.findAll();}
    public Faculty getFacultyById(int id) {
        Optional<Faculty> faculty = facultyRepository.findById(id);
        if(faculty.isPresent()){
            return faculty.get();
        }
        return null;
    }

    public void updateFaculty(Integer id, Faculty faculty) {
        Faculty updatingFaculty = getFacultyById(id);
        if (updatingFaculty == null) {
            throw new IllegalArgumentException("Faculty with ID " + id + " not found.");
        }
        updatingFaculty.setFirstName(faculty.getFirstName());
        updatingFaculty.setLastName(faculty.getLastName());
        updatingFaculty.setEmail(faculty.getEmail());
        updatingFaculty.setDepartment(faculty.getDepartment());
        updatingFaculty.setDesignation(faculty.getDesignation());
        facultyRepository.save(updatingFaculty);
    }


    public void deleteFaculty(Integer id) {facultyRepository.deleteById(id);}
}
