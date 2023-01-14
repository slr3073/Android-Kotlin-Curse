package com.example.myfirstapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var nbClick : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Compteur"

        Toast.makeText(this, "Application lancée !", Toast.LENGTH_LONG).show()

        val txtCompteur: TextView = findViewById<TextView>(R.id.compteur)
        txtCompteur.text = "Nombre de click : $nbClick"

        val btnClickMe = findViewById<Button>(R.id.clickme)
        btnClickMe.setOnClickListener{
            nbClick += 1
            txtCompteur.text = "Nombre de click : $nbClick"
            btnClickMe.text = "Clique moi plus fort !"
        }
    }
}