package com.service;

import com.model.Student;
import com.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements StudentService {

    private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        Student newStudent = studentRepository.save(student);
        log.debug("The saved entity intoDB is : {}", newStudent);
        return newStudent;
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = studentRepository.findAll();
        List<Student> listOfStudents = !students.isEmpty() ? students : Collections.emptyList();
        System.out.println("The students : ");
        listOfStudents.forEach(System.out::println);
        return students;
    }

    @Override
    public Student findStudentByID(int studentID) {
        Optional<Student> studentByID = studentRepository.findById(studentID);
        Student student = studentByID.orElse(new Student());
        log.debug("The student retrieved by ID is : {}", student);
        return student;
    }

    @Override
    public Student updateStudentByID(int studentID, Student student) {
        Optional<Student> studentById = studentRepository.findById(studentID);
        if (studentById.isPresent()) {
            Student studentToUpdate = studentById.get();
            studentToUpdate.setId(student.getId());
            studentToUpdate.setName(student.getName());
            studentToUpdate.setDeptName(student.getDeptName());
            Student newStudent = studentRepository.save(student);
            log.debug("The updated student entity is : {}", newStudent);
        }
        return new Student();
    }

    @Override
    public void deleteStudentByID(int studentByID) {
        Optional<Student> studentById = studentRepository.findById(studentByID);
        if (studentById.isPresent()) {
            studentRepository.delete(studentById.get());
            System.out.println("The deleted studentID is : " + studentById.get());
        }
    }
}
