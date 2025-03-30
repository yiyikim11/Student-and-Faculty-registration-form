package kh.edu.paragoniu.demo.repository;

import kh.edu.paragoniu.demo.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {}