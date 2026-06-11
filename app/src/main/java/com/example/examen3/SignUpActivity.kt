package com.example.examen3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.signupLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtUsuario = findViewById<EditText>(R.id.txtUsuarioRegistro)
        val txtContrasena = findViewById<EditText>(R.id.txtContrasenaRegistro)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)
        val lblMensaje = findViewById<TextView>(R.id.lblMensajeRegistro)

        btnRegistrar.setOnClickListener {
            val usuario = txtUsuario.text.toString()
            val contrasena = txtContrasena.text.toString()

            if (usuario.isNotEmpty() && contrasena.isNotEmpty()) {
                lblMensaje.text = "Usuario $usuario registrado correctamente."
            } else {
                lblMensaje.text = "Por favor, ingresa nombre de usuario y contraseña."
            }
        }
    }
}
