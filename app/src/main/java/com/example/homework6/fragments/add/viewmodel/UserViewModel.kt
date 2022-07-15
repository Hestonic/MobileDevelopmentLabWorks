package com.example.homework6.fragments.add.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.homework6.data.UserDatabase
import com.example.homework6.model.Parent
import com.example.homework6.model.User
import com.example.homework6.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<User>>
    val readAllDataParents: LiveData<List<Parent>>
    private val repository: UserRepository


    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
        readAllDataParents = repository.readAllDataParents
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

    fun addParent(parent: Parent){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addParent(parent)
        }
    }

    fun deleteParent(parent: Parent) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteParent(parent)
        }
    }

    fun deleteAllParent() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllParent()
        }
    }

    fun deleteAllUser() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllUser()
        }
    }
}