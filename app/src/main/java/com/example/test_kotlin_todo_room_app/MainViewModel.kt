package com.example.test_kotlin_todo_room_app

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_kotlin_todo_room_app.db.Task
import com.example.test_kotlin_todo_room_app.db.TaskDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val taskDao: TaskDao) : ViewModel() {

    var title by mutableStateOf("")

    var description by mutableStateOf("")

    fun createTask() {
        viewModelScope.launch {
            val newTask = Task(title = title, description = description)
            taskDao.insertTask(newTask)

            Log.d(MainViewModel::class.simpleName, "Success")
        }
    }

    var isShowDialog by mutableStateOf(false)

    val tasks = taskDao.loadAllTasks().distinctUntilChanged()

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            taskDao.deleteTask(task)
        }
    }

    private var editingTask: Task? = null
    val isEditing: Boolean
        get() = editingTask != null

    fun setEditingTask(task: Task) {
        editingTask = task
        title = task.title
        description = task.description
    }

    fun updateTask() {
        editingTask?.let { task ->
            viewModelScope.launch {
                task.title = title
                task.description = description
                taskDao.updateTask(task)
            }
        }
    }

    fun resetProperties(){
        editingTask = null
        title = ""
        description = ""
    }

}
