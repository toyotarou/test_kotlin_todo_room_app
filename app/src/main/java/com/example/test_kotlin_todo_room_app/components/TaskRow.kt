package com.example.test_kotlin_todo_room_app.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test_kotlin_todo_room_app.db.Task

@Composable
fun TaskRow(
    task: Task,
    onClickRow: (Task) -> Unit,
    onClickDelete: (Task) -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Row(modifier = Modifier
            .clickable { onClickRow(task) }
            .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(task.title)
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = {
                onClickDelete(task)
            }) {
                Icon(
                    imageVector = Icons.Default.Delete, contentDescription = "delete"
                )
            }
        }
    }
}

@Preview
@Composable
fun TaskRowPreview() {
    TaskRow(task = Task(title = "preview", description = ""), onClickRow = {}, onClickDelete = {})
}
