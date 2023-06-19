package uz.farxod.room

import androidx.room.*

@Dao
interface UserDao {
    @Insert
    fun addUser(user: User)

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY id DESC") // jadvaldagi barcha ma'lumotni oxirgi qushilgan id bo'yicha ol
    fun getAllUsers() : List<User>
}