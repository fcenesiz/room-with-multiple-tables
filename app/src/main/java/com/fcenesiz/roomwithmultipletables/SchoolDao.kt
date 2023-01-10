package com.fcenesiz.roomwithmultipletables

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Transaction
import com.fcenesiz.roomwithmultipletables.entities.Director
import com.fcenesiz.roomwithmultipletables.entities.School
import com.fcenesiz.roomwithmultipletables.entities.Student
import com.fcenesiz.roomwithmultipletables.entities.Subject
import com.fcenesiz.roomwithmultipletables.entities.relations.*

@Dao
interface SchoolDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = REPLACE)
    suspend fun insertStudent(student: Student)

    @Insert(onConflict = REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = REPLACE)
    suspend fun insertStudentSubjectCrossRef(crossRef: StudentSubjectCrossRef)

    @Transaction // to prevent multithreading issue
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String): List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolWithStudents(schoolName: String): List<SchoolWithStudents>

    @Transaction
    @Query("SELECT * FROM subject WHERE subjectName = :subjectName")
    suspend fun getStudentsOfSubject(subjectName: String): List<SubjectWithStudents>

    @Transaction
    @Query("SELECT * FROM student WHERE studentName = :studentName")
    suspend fun getSubjectsOfStudent(studentName: String): List<StudentWithSubjects>


}