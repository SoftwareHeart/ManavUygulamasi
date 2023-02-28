package com.example.manavuygulamasi

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.example.manavuygulamasi.databinding.ActivityAlisVerisBinding
import kotlin.properties.Delegates

class AlisVerisActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlisVerisBinding
    private lateinit var sharedPreferences: SharedPreferences
    private var bakiye: Int? = null
    private var ucret = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlisVerisBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        sharedPreferences = this.getSharedPreferences(packageName, MODE_PRIVATE)
        bakiye = sharedPreferences.getInt("bakiye",0)
        Log.e("Deneme Sonuc",bakiye.toString())

        bakiye = bakiye!! + intent.getIntExtra("bakiye",0)

        Log.e("Deneme Sonuc2",bakiye.toString())
        binding.textViewBakiye.text = "Bakiye : $bakiye"
        var muzUcret = 0
        var elmaUcret = 0
        var havucUcret = 0
        var portakalUcret = 0

        binding.buttonBakiyeYukle.setOnClickListener {
            val yeniIntent = Intent(this,BakiyeActivity::class.java)
            sharedPreferences.edit().putInt("bakiye",bakiye!!).apply()
            startActivity(yeniIntent)
        }

        binding.buttonSepet.setOnClickListener {
            if(TextUtils.isEmpty(binding.editTextMuz.getText())){
                binding.editTextMuz.setText("0")
            }
            if(TextUtils.isEmpty(binding.editTextElma.getText())){
                binding.editTextElma.setText("0")
            }
            if(TextUtils.isEmpty(binding.editTextHavuc.getText())){
                binding.editTextHavuc.setText("0")
            }
            if(TextUtils.isEmpty(binding.editTextPortakal.getText())){
                binding.editTextPortakal.setText("0")
            }
            muzUcret = binding.editTextMuz.text.toString().toInt() * 12
            elmaUcret = binding.editTextElma.text.toString().toInt() * 6
            portakalUcret = binding.editTextPortakal.text.toString().toInt() * 10
            havucUcret = binding.editTextHavuc.text.toString().toInt() * 15

            ucret = muzUcret + elmaUcret + portakalUcret + havucUcret

            binding.textViewBakiyeSepet.text = "Sepet : $ucret"
            binding.editTextMuz.setText("0")
            binding.editTextElma.setText("0")
            binding.editTextHavuc.setText("0")
            binding.editTextPortakal.setText("0")

        }

        binding.buttonBitir.setOnClickListener {
            if(bakiye!! >=ucret)
            {
                bakiye = bakiye!! - ucret
                val yeniIntent = Intent(this@AlisVerisActivity,SonucActivity::class.java)
                yeniIntent.putExtra("guncel_Bakiye",bakiye)
                sharedPreferences.edit().putInt("bakiye",bakiye!!).apply()
                finish()
                startActivity(yeniIntent)
            }
            if (bakiye!! < ucret)
            {
                Toast.makeText(this@AlisVerisActivity,"Bakiye yetersiz!!",Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonCKS.setOnClickListener {
            val yeniIntent = Intent(this,MainActivity::class.java)
            sharedPreferences.edit().putInt("bakiye",bakiye!!).apply()
            finish()
            startActivity(yeniIntent)
        }
        binding.buttonSepetTemizle.setOnClickListener {
            ucret = 0
            binding.textViewBakiyeSepet.text = "Sepet : $ucret"
        }



    }


}