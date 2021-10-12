package com.example.quantitymeasurementapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("App status : on create")
        Toast.makeText(this,"App status : on create",Toast.LENGTH_SHORT).show()
    }
    override fun onStart() {
        super.onStart()
        println("App status : on start")
        Toast.makeText(this,"App status : on start", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        println("App status : on resume")
        Toast.makeText(this,"App status : on resume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        println("App status : on pause")
        Toast.makeText(this,"App status : on pause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        println("App status : on stop")
        Toast.makeText(this,"App status : on stop", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        println("App status : on destroy")
        Toast.makeText(this,"App status : on destroy", Toast.LENGTH_SHORT).show()
    }
}