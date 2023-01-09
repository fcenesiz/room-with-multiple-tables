package com.fcenesiz.roomwithmultipletables

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Transaction
import com.fcenesiz.roomwithmultipletables.entities.Director
import com.fcenesiz.roomwithmultipletables.entities.School
import com.fcenesiz.roomwithmultipletables.entities.relations.SchoolAndDirector

@Dao
interface SchoolDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = REPLACE)
    suspend fun insertDirector(director: Director)

    @Transaction // to prevent multithreading issue
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String): List<SchoolAndDirector>

}