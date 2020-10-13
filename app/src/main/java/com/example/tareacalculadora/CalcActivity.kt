package com.example.tareacalculadora

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tareacalculadora.controlador.Calculadora

class CalcActivity : AppCompatActivity() {

    private lateinit var textViewOutput : TextView
    private lateinit var textViewBienvenida : TextView

    private var bienvenida : String = "Bienvenid@ "
    private var nombreBinvenida : String = ""

    private val INSTANCE_KEY_NOMBRE = "nombreString"

    private var calc : Calculadora = Calculadora.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)

        textViewOutput = findViewById<TextView>(R.id.textViewCalcOutput)
        textViewBienvenida = findViewById<TextView>(R.id.textViewCalcBienvenida)

        nombreBinvenida = intent.getStringExtra("nombre").toString()
    }

    override fun onStart() {
        super.onStart()

        // print mensaje bienvenida
        textViewBienvenida.text = bienvenida + nombreBinvenida
        // update textViewOutput
        updateOut()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState!!)
        // Read values from the "savedInstanceState"
        nombreBinvenida = savedInstanceState.getString(INSTANCE_KEY_NOMBRE).toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        // Save the values you need into "outState"
        outState.putString(INSTANCE_KEY_NOMBRE, nombreBinvenida)
        super.onSaveInstanceState(outState!!)
    }


    fun onClick7(view: View) {
        calc.enterNum(7)
        updateOut()
    }
    fun onClick8(view: View) {
        calc.enterNum(8)
        updateOut()
    }
    fun onClick9(view: View) {
        calc.enterNum(9)
        updateOut()
    }
    fun onClickDividir(view: View) {
        calc.enterOperacion(Calculadora.Operacion.Dividir)
        updateOut()
    }
    fun onClick4(view: View) {
        calc.enterNum(4)
        updateOut()
    }
    fun onClick5(view: View) {
        calc.enterNum(5)
        updateOut()
    }
    fun onClick6(view: View) {
        calc.enterNum(6)
        updateOut()
    }
    fun onClickMultiplicar(view: View) {
        calc.enterOperacion(Calculadora.Operacion.Multiplicor)
        updateOut()
    }
    fun onClick1(view: View) {
        calc.enterNum(1)
        updateOut()
    }
    fun onClick2(view: View) {
        calc.enterNum(2)
        updateOut()
    }
    fun onClick3(view: View) {
        calc.enterNum(3)
        updateOut()
    }
    fun onClickResta(view: View) {
        calc.enterOperacion(Calculadora.Operacion.Resta)
        updateOut()
    }
    fun onClickReset(view: View) {
        calc.reset()
        updateOut()
    }
    fun onClick0(view: View) {
        calc.enterNum(0)
        updateOut()
    }
    fun onClickOperar(view: View) {
        calc.operar()
        updateOut()
    }
    fun onClickSumar(view: View) {
        calc.enterOperacion(Calculadora.Operacion.Suma)
        updateOut()
    }

    fun updateOut() {
        textViewOutput.text = calc.toString()
    }
}