package com.fcenesiz.roomwithmultipletables.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.fcenesiz.roomwithmultipletables.entities.School
import com.fcenesiz.roomwithmultipletables.entities.Student

data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<Student>
)
