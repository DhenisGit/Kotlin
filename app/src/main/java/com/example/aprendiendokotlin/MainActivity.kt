package com.example.aprendiendokotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aprendiendokotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actions()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun actions() {
        onClick()
        var myDouble = 1.2f
        myDouble = 1.3f
        println(myDouble)
    }

    @SuppressLint("SetTextI18n")
    private fun onClick() {
        binding.button.setOnClickListener {
            val text1 = binding.edt1.text.toString()
            val text2 = binding.edt2.text.toString()
            if (text1.isNotEmpty() && text2.isNotEmpty()) {
                try {
                    val num1 = text1.toInt()
                    val num2 = text2.toInt()
                    val suma = num1 + num2
                    binding.result.text = suma.toString()
                    binding.edt1.text.clear()
                    binding.edt2.text.clear()
                } catch (e: NumberFormatException) {
                    Log.d(TAG, "Error al convertir texto a número: ${e.message}")
                }
            } else {
                Log.d(TAG, "Ambos campos deben contener datos")
            }
        }
    }
}