package com.SpringHibernate.springJpa.jpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringHibernate.springJpa.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
