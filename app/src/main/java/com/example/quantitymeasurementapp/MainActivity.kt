package com.example.quantitymeasurementapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.quantitymeasurementapp.databinding.ActivityMainBinding

/**
 * MainActivity class implements activity life cycle methods and replaces the fragments
 */
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.fragmentButton1.setOnClickListener {
            binding.fragmentButton1.setBackgroundColor(Color.RED)
            binding.fragmentButton2.setBackgroundColor(Color.BLACK)
            replaceFragment(Fragment1())
        }

        binding.fragmentButton2.setOnClickListener {
            binding.fragmentButton1.setBackgroundColor(Color.BLACK)
            binding.fragmentButton2.setBackgroundColor(Color.RED)
            replaceFragment(Fragment2())
        }
        Log.d("MainActivity", "App status : on create")
    }

    /**
     * replacing the fragments
     * @param fragment
     */
    fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "App status : on start")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "App status : on resume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "App status : on pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "App status : on stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "App status : on destroy")
    }
}