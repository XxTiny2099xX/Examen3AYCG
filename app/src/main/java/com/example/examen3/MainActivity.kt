package com.example.examen3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtUsuario = findViewById<EditText>(R.id.txtUsuario)
        val txtContrasena = findViewById<EditText>(R.id.txtContrasena)
        val btnIniciar = findViewById<Button>(R.id.btnIniciar)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)
        val lblMensaje = findViewById<TextView>(R.id.lblMensaje)

        btnIniciar.setOnClickListener {
            val usuario = txtUsuario.text.toString()
            val contrasena = txtContrasena.text.toString()

            if (usuario.isNotEmpty() && contrasena.isNotEmpty()) {
                lblMensaje.text = "Hola $usuario, ¡bienvenido!"
            } else {
                lblMensaje.text = "Por favor, completa todos los campos."
            }
        }

        btnRegistrar.setOnClickListener {
            lblMensaje.text = "Función de registro en desarrollo."
        }
    }
}
