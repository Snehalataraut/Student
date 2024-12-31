package com.service;

import com.model.Student;

import java.util.List;

public interface StudentService {

    /**
     * Below method create new entity into MySQL database where entity is @{@link Student}
     *
     * @param student type of @{@link Student}
     * @return student type of @{@link Student}
     */
    Student saveStudent(Student student);

    /**
     * Below method returns the list of student from database.
     *
     * @return list of @{@link Student}
     */
    List<Student> findAll();

    /**
     * Below method fetch the student for matched input integer type ID.
     *
     * @param studentID of type @{@link Integer}
     * @return student of type @{@link Student}
     */
    Student findStudentByID(int studentID);

    /**
     * Below method update the student entity into the table for matched input studentID.
     *
     * @param studentID of type @{@link Integer}
     * @param student of type @{@link Student}
     * @return student of type @{@link Student}
     */
    Student updateStudentByID(int studentID, Student student);

    /**
     * Below method delete the student entity into the table for matched input studentID.
     *
     * @param studentID of type @{@link Integer}
     */
    void deleteStudentByID(int studentID);
}
