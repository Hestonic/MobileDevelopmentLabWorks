package com.example.homework6.repository

import androidx.lifecycle.LiveData
import com.example.homework6.model.User
import com.example.homework6.data.UserDao
import com.example.homework6.model.Parent

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    val readAllDataParents: LiveData<List<Parent>> = userDao.readAllDataParent()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    suspend fun addParent(parent: Parent){
        userDao.addParent(parent)
    }

    suspend fun deleteParent(parent: Parent) {
        userDao.deleteParent(parent)
    }

    suspend fun deleteAllParent() {
        userDao.deleteAllParent()
    }

    suspend fun deleteAllUser() {
        userDao.deleteAllUser()
    }


}