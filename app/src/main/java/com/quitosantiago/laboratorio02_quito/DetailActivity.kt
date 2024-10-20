package com.quitosantiago.laboratorio02_quito

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.quitosantiago.laboratorio02_quito.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val CLIENTE_KEY = "CLIENTE_KEY"
    private val PHONE_KEY = "PHONE_KEY"
    private val PRODUCTO_KEY = "PRODUCTO_KEY"
    private val UBICACION_KEY = "UBICACION_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        showInformation(intent.extras)
        observeButtons(intent.extras)
    }

    private fun showInformation(bundle: Bundle?) {
        if (bundle != null) {
            val cliente = bundle.getString(CLIENTE_KEY)
            val phone = bundle.getString(PHONE_KEY)
            val producto = bundle.getString(PRODUCTO_KEY)
            val ubicacion = bundle.getString(UBICACION_KEY)

            binding.tvName.text = "Nombre completo: $cliente"
            binding.tvPhone.text = "Número telefónico: $phone"
            binding.tvProduct.text = "Productos: $producto"
            binding.tvLocation.text = "Ubicación: $ubicacion"
        }
    }

    private fun observeButtons(bundle: Bundle?) {
        binding.imbWsp.setOnClickListener {
            goWsp(bundle)
        }

        binding.imbDial.setOnClickListener {
            goLlamada(bundle)
        }

        binding.imbUbicacion.setOnClickListener {
            goUbicacion(bundle)
        }
    }

    private fun goWsp(bundle: Bundle?) {
        val phone = "+51${bundle?.getString(PHONE_KEY)}"
        val message = "¡Hola!, te he agregado a mi lista de contactos"

        val intentWsp = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://wa.me/$phone?text=$message")
        }

        startActivity(intentWsp)
    }

    private fun goLlamada(bundle: Bundle?) {
        val phone = bundle?.getString(PHONE_KEY)

        val intentLlamada = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phone")
        }

        startActivity(intentLlamada)
    }

    private fun goUbicacion(bundle: Bundle?) {
        val ubicacion = bundle?.getString(UBICACION_KEY)
        val uri = Uri.parse("geo:0,0?q=$ubicacion")

        val intentUbicacion = Intent(Intent.ACTION_VIEW).apply {
            data = uri
        }

        if (intentUbicacion.resolveActivity(packageManager) != null) {
            startActivity(intentUbicacion)
        } else {
            Toast.makeText(this, "No se pudo abrir la aplicación de mapas", Toast.LENGTH_SHORT).show()
        }
    }
}
