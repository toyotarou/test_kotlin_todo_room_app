package com.example.test_kotlin_todo_room_app.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks") // 👈 ここに @Entity アノテーションを追加
data class Task(
    @PrimaryKey(autoGenerate = true) // 👈 id を主キーとして自動生成
    val id: Int = 0, // 👈 autoGenerate を使う場合はデフォルト値を設定

    @ColumnInfo(name = "task_title") // 👈 カラム名を指定 (任意だが推奨)
    var title: String,

    @ColumnInfo(name = "task_description") // 👈 カラム名を指定 (任意だが推奨)
    var description: String
)
