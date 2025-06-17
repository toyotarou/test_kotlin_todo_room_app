package com.example.test_kotlin_todo_room_app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.test_kotlin_todo_room_app.components.EditDialog
import com.example.test_kotlin_todo_room_app.components.TaskList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                MainContent()
            }
        }
    }
}

@Composable
fun MainContent(viewModel: MainViewModel = hiltViewModel()) {

    if (viewModel.isShowDialog) {
        EditDialog()
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.isShowDialog = true
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "新規作成"
                )
            }
        }
    ) {

        val tasks by viewModel.tasks.collectAsState(initial = emptyList())
        Log.d("COUNT", tasks.size.toString())

        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            TaskList(tasks = tasks,
                onClickRow = {
//                    viewModel.setEditingTask(it)
                    viewModel.isShowDialog = true
                },
                onClickDelete = {
//                    viewModel.deleteTask(it)
                }
            )
        }
    }
}
