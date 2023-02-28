package com.example.manavuygulamasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.manavuygulamasi.databinding.ActivityAlisVerisBinding
import com.example.manavuygulamasi.databinding.ActivitySonucBinding

class SonucActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySonucBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySonucBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val sonUcret = intent.getIntExtra("guncel_Bakiye",0)
        binding.textViewsonBakiye.text = "Güncel Bakiye : $sonUcret"
        binding.buttonCikis.setOnClickListener {
            val yeniIntent = Intent(this,MainActivity::class.java)
            finish()
            startActivity(yeniIntent)
        }
        binding.buttonSepet.setOnClickListener {
            val yeniIntent = Intent(this@SonucActivity,AlisVerisActivity::class.java)
            yeniIntent.putExtra("guncel",sonUcret)
            finish()
            startActivity(yeniIntent)
        }

    }
}