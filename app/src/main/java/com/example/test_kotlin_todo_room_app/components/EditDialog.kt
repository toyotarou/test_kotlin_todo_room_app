package com.example.test_kotlin_todo_room_app.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun EditDialog(
) {
    AlertDialog(
        onDismissRequest = {},
        title = {
            Text(
                "新規作成"
            )
        },
        text = {
            Column {
                Text(
                    "タイトル"
                )
                TextField(value = "", onValueChange = {})
                Text("詳細")
                TextField(value = "", onValueChange = {})
            }
        },
        confirmButton = {
            Button(
                onClick = {
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
