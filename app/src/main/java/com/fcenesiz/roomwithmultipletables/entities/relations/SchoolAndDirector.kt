package com.fcenesiz.roomwithmultipletables.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.fcenesiz.roomwithmultipletables.entities.Director
import com.fcenesiz.roomwithmultipletables.entities.School


data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)