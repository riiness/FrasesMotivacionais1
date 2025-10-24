package com.example.appfrasesmotivacionais

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val FrasesRepository = FrasesRepository()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var nome = findViewById<TextView>(R.id.text_view_nome)
         var nomeRecuperacao = this.getSharedPreferences("motivacao",MODE_PRIVATE).getString("nome","Olá, Mariane")
        nome.text = nomeRecuperacao

        var novaFrase = findViewById<TextView>(R.id.text_view_frase)
        var botaoFrase = findViewById<Button>(R.id.botao)
        var imageAll = findViewById<ImageView>(R.id.img)
        var imageHappy = findViewById<ImageView>(R.id.emoji)
        var imageSun = findViewById<ImageView>(R.id.light)

        imageAll.setOnClickListener {
            imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
            imageSun.setColorFilter(ContextCompat.getColor(this, R.color.black))
            imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.black))
            var fraseSorteada = FrasesRepository.getFrase(0)
            novaFrase.text= fraseSorteada
        }

        imageHappy.setOnClickListener {
            imageAll.setColorFilter(ContextCompat.getColor(this, R.color.black))
            imageSun.setColorFilter(ContextCompat.getColor(this, R.color.black))
            imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
            var fraseSorteada = FrasesRepository.getFrase(1)
            novaFrase.text=fraseSorteada
        }

        imageSun.setOnClickListener {
            imageAll.setColorFilter(ContextCompat.getColor(this, R.color.black))
            imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.black))
            imageSun.setColorFilter(ContextCompat.getColor(this, R.color.white))
            var fraseSorteada = FrasesRepository.getFrase(2)
            novaFrase.text=fraseSorteada
        }

        botaoFrase.setOnClickListener {
            var fraseSorteada = FrasesRepository.getFrase(0)
            novaFrase.text = fraseSorteada
        }
    }
}