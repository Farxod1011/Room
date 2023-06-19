package uz.farxod.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    // id avtoinkrement bo'lsin
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    // kolonna qushamiz
    @ColumnInfo("username")
    val username: String,
    @ColumnInfo("phone")
    val phone: String,
    @ColumnInfo("email")
    val email: String
)
