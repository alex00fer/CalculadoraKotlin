package com.example.tareacalculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textViewNombre : TextView
    private lateinit var textViewApellido : TextView

    private val INSTANCE_KEY_NOMBRE = "nombreValue"
    private val INSTANCE_KEY_APELLIDO = "apellidoValue"

    private var nombre : String = ""
    private var apellido : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewNombre = findViewById<TextView>(R.id.editTextMainNombre)
        textViewApellido = findViewById<TextView>(R.id.editTextMainApellido)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Read values
        nombre = savedInstanceState.getString(INSTANCE_KEY_NOMBRE).toString()
        apellido = savedInstanceState.getString(INSTANCE_KEY_APELLIDO).toString()
        // Set values
        textViewNombre.text = nombre
        textViewApellido.text = apellido
    }

    override fun onSaveInstanceState(outState: Bundle) {
        // Get values
        nombre = textViewNombre.text.toString()
        apellido = textViewApellido.text.toString()
        // Save the values
        outState.putString(INSTANCE_KEY_NOMBRE, nombre)
        outState.putString(INSTANCE_KEY_APELLIDO, apellido)
        super.onSaveInstanceState(outState)
    }

    fun onClickSalir(view: View) {
        finish()
    }

    fun onClickAcceder(view: View) {
        var calcActivityIntent = Intent(this, CalcActivity::class.java)
        calcActivityIntent.putExtra("nombre", textViewNombre.text.toString() + " " + textViewApellido.text.toString())
        startActivity(calcActivityIntent)
    }
}