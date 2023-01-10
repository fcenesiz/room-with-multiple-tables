package com.fcenesiz.roomwithmultipletables

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Transaction
import com.fcenesiz.roomwithmultipletables.entities.Director
import com.fcenesiz.roomwithmultipletables.entities.School
import com.fcenesiz.roomwithmultipletables.entities.Student
import com.fcenesiz.roomwithmultipletables.entities.relations.SchoolAndDirector
import com.fcenesiz.roomwithmultipletables.entities.relations.SchoolWithStudents

@Dao
interface SchoolDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = REPLACE)
    suspend fun insertStudent(student: Student)

    @Transaction // to prevent multithreading issue
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String): List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolWithStudents(schoolName: String): List<SchoolWithStudents>

}