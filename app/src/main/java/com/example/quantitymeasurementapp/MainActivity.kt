package com.example.quantitymeasurementapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.quantitymeasurementapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.fragmentButton1.setOnClickListener {
            replaceFragment(Fragment1())
        }

        binding.fragmentButton2.setOnClickListener {
            replaceFragment(Fragment2())
        }
        println("App status : on create")
        Toast.makeText(this,"App status : on create",Toast.LENGTH_SHORT).show()
    }

    fun replaceFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer,fragment)
        fragmentTransaction.commit()
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