private lateinit var dbHelper: DatabaseHelper

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_sign_up)

    dbHelper = DatabaseHelper(this)

    val txtUsuario = findViewById<EditText>(R.id.txtUsuarioRegistro)
    val txtContrasena = findViewById<EditText>(R.id.txtContrasenaRegistro)
    val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)
    val lblMensaje = findViewById<TextView>(R.id.lblMensajeRegistro)

    btnRegistrar.setOnClickListener {
        val usuario = txtUsuario.text.toString()
        val contrasena = txtContrasena.text.toString()

        if (usuario.isNotEmpty() && contrasena.isNotEmpty()) {
            val resultado = dbHelper.insertarJugador(usuario, contrasena)
            if (resultado != -1L) {
                lblMensaje.text = "Usuario $usuario registrado correctamente."
            } else {
                lblMensaje.text = "Error al registrar usuario."
            }
        } else {
            lblMensaje.text = "Por favor, ingresa nombre de usuario y contraseña."
        }
    }
}
