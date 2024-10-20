package com.quitosantiago.laboratorio02_quito

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.quitosantiago.laboratorio02_quito.databinding.ActivityEjercicio02Binding

class Ejercicio02Activity : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio02Binding
    private val CLIENTE_KEY = "CLIENTE_KEY"
    private val PHONE_KEY = "PHONE_KEY"
    private val PRODUCTO_KEY = "PRODUCTO_KEY"
    private val UBICACION_KEY = "UBICACION_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio02Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        observeButtons()
    }

    private fun observeButtons() {
        binding.btnRegistrar.setOnClickListener {
            goDetailActivity()
        }
    }

    private fun goDetailActivity() {
        val cliente = binding.nombre_cliente.text.toString()
        val phone = binding.numero_cliente.text.toString()
        val ubicacion = binding.ciudad.text.toString()
        val intent = Intent(this, DetailActivity::class.java)

        intent.putExtra(CLIENTE_KEY, cliente)
        intent.putExtra(PHONE_KEY, phone)
        intent.putExtra(PRODUCTO_KEY, producto)
        intent.putExtra(UBICACION_KEY, ubicacion)

        startActivity(intent)
    }
}
