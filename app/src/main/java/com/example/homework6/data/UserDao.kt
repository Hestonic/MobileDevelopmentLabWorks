package com.example.homework6.data

import android.os.FileObserver.DELETE
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.homework6.model.Parent
import com.example.homework6.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addParent(parent: Parent)

    @Query("SELECT * FROM parent_table ORDER BY id ASC")
    fun readAllDataParent(): LiveData<List<Parent>>

    @Delete
    suspend fun deleteParent(parent: Parent)

    @Query("DELETE FROM parent_table")
    suspend fun deleteAllParent()

    @Query("DELETE FROM user_table")
    suspend fun deleteAllUser()

}