package kh.edu.paragoniu.demo.repository;

import kh.edu.paragoniu.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

// no annotation here since its an interface
// can not use generic but this case we need to extend
// kleang extend ng doch brab springboot tha use Student class database hz key ng jea integer
public interface StudentRepository extends JpaRepository<Student, Integer> {

}

