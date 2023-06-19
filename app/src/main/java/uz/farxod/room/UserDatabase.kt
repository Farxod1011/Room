package uz.farxod.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase(){
    abstract fun userDao():UserDao

    companion object{
        private var instance: UserDatabase? = null

        fun getDatabaseInstance(context: Context): UserDatabase{
            return instance ?: Room.databaseBuilder(context, UserDatabase::class.java, "user_database")
                .allowMainThreadQueries().build()
        }
    }
}