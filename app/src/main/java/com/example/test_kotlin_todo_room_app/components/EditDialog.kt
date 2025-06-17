package com.example.test_kotlin_todo_room_app.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.test_kotlin_todo_room_app.MainViewModel

@Composable
fun EditDialog(
    viewModel: MainViewModel = hiltViewModel()
) {

    DisposableEffect(Unit) {
        onDispose {
            viewModel.resetProperties()
        }
    }

    AlertDialog(
        onDismissRequest = {
            viewModel.isShowDialog = false
        },
        title = {
            Text(
                if (viewModel.isEditing) "更新" else
                    "新規作成"
            )
        },
        text = {
            Column {
                Text(
                    "タイトル"
                )
                TextField(
                    value = viewModel.title,
                    onValueChange = {
                        viewModel.title = it
                    },
                )
                Text("詳細")
                TextField(
                    value = viewModel.description,
                    onValueChange = {
                        viewModel.description = it
                    },
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (viewModel.isEditing) viewModel.updateTask() else
                        viewModel.createTask()

                    viewModel.isShowDialog = false
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                ),
            ) {
                Text(
                    text = "OK",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        },
        dismissButton = {
            Button(
                onClick = {
                    viewModel.isShowDialog = false
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                ),
            ) {
                Text(
                    text = "キャンセル",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        },
    )
}
