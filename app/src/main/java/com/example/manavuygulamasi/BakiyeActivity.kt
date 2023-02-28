package com.example.manavuygulamasi

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.manavuygulamasi.databinding.ActivityAlisVerisBinding
import com.example.manavuygulamasi.databinding.ActivityBakiyeBinding

class BakiyeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBakiyeBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBakiyeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var bakiye = 0;
        val yeniIntent = Intent(this,AlisVerisActivity::class.java)
        binding.button10Tl.setOnClickListener {
            bakiye = 10
        }
        binding.button20TL.setOnClickListener {
            bakiye = 20
        }
        binding.button30TL.setOnClickListener {
            bakiye = 30
        }
        binding.button40TL.setOnClickListener {
            bakiye = 40
        }
        binding.button50TL.setOnClickListener {
            bakiye = 50
        }
        binding.button100TL.setOnClickListener {
            bakiye = 100
        }
        binding.buttonYukle.setOnClickListener {
            yeniIntent.putExtra("bakiye",bakiye)
            Log.e("Bakiye",bakiye.toString())
            Toast.makeText(this,"Bakiye yüklendi..",Toast.LENGTH_SHORT).show()
            finish()
            startActivity(yeniIntent)
        }
    }
}