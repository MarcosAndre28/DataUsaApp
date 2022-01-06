package com.example.datausaapp.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.datausaapp.R
import com.example.datausaapp.edit.StatesFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        setFragmentCity()
    }
    private fun setFragmentCity() {
        supportFragmentManager.beginTransaction().replace(R.id.container, StatesFragment()).commit()
    }

}
