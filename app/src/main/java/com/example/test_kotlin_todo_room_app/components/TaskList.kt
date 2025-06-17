package com.example.test_kotlin_todo_room_app.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.test_kotlin_todo_room_app.db.Task

@Composable
fun TaskList(
    tasks: List<Task>,
    onClickRow: (Task) -> Unit,
    onClickDelete: (Task) -> Unit,
) {
    LazyColumn {
        items(tasks) {
            TaskRow(
                task = it,
                onClickRow = onClickRow,
                onClickDelete = onClickDelete
            )
        }
    }
}
