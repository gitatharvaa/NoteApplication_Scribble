package com.example.scribble.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date
import java.util.UUID

@Entity(tableName = "scribble_tbl")
data class Note( //Room database table entity
    @PrimaryKey
    val id: UUID = UUID.randomUUID(), //98sdf

    @ColumnInfo(name = "scribble_title")
    val title: String,

    @ColumnInfo(name = "scribble_description")
    val description: String,

    @ColumnInfo(name = "scribble_entry_date")
    val entryDate: Date = Date.from(Instant.now())
)
