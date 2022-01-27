package com.example.homework6.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "parent_table")
data class Parent(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val parent: Int,
    val children: Int
): Parcelable