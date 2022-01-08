package com.example.jlg

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jlg.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHindi.setOnClickListener {
            Toast.makeText(this, "Hindi", Toast.LENGTH_SHORT).show()
            setLocale(this, "hi")
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.btnEnglish.setOnClickListener{
            Toast.makeText(this, "English", Toast.LENGTH_SHORT).show()
            setLocale(this, "en")
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.btnFrench.setOnClickListener{
            Toast.makeText(this, "French", Toast.LENGTH_SHORT).show()
            setLocale(this, "fr")
            startActivity(Intent(this, MainActivity::class.java))
        }


    }

    private fun setLocale(context: Context, lang:String){
        val locale = Locale(lang)
        Locale.setDefault(locale)
        val config = context.resources.configuration
        config.setLocale(locale)
        context.createConfigurationContext(config)
        context.resources.updateConfiguration(config, context.resources.displayMetrics)
    }

}