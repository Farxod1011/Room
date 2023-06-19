package uz.farxod.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.farxod.room.fragments.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, MainFragment()).commit()
    }
}