package com.example.hw_3_5month

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hw_3_5month.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        counter()
    }

    private fun counter() = with(binding) {
        btnIncrement.setOnClickListener {
            viewModel.increment()
        }
        btnDecrement.setOnClickListener {
            viewModel.decrement()
        }
        viewModel.counterLD.observe(this@MainActivity, Observer { count ->
            when (count) {
                10 -> Toast.makeText(this@MainActivity, "поздравляем",Toast.LENGTH_LONG).show()
                15 -> tvCount.setTextColor(Color.GREEN)

            }

            tvCount.text = count.toString()
        })

    }
}