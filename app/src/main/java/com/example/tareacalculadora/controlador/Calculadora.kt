package com.example.tareacalculadora.controlador

import java.lang.Exception

class Calculadora {

    // singleton
    companion object {
        val instance = Calculadora()
    }

    enum class State {
        N1, N2, RS // estado entre esperando numero 1, numero 2 o resultado
    }

    enum class Operacion {
        Suma, Resta, Dividir, Multiplicor
    }

    var state : State = State.N1;
    var n1 : Int = 0
    var n2 : Int = 0
    var op : Operacion = Operacion.Suma

    fun enterNum (n : Int) {

        if (state == State.RS)
            reset()

        if (state == State.N1) {
            n1 = (n1.toString() + n.toString()).toInt()
        }
        else if (state == State.N2) {
            n2 = (n2.toString() + n.toString()).toInt()
        }
    }

    fun enterOperacion (op : Operacion) {
        if (state == State.N1) {
            this.op = op;
            state = State.N2
        }
    }

    fun operar() {
        if (state == State.N2) {
            state = State.RS
        }
    }

    override fun toString() : String {
        return try {
            when (state) {
                State.N1 -> "$n1"
                State.N2 -> "$n1 ${getOpSymbol()} $n2"
                State.RS -> "$n1 ${getOpSymbol()} $n2 = ${getResult()}"
                else -> "---"
            }
        } catch (e: Exception) {
            "Error aritmético"
        }
    }

    private fun getOpSymbol () : String {
        return when (op) {
            Operacion.Suma -> "+"
            Operacion.Resta -> "-"
            Operacion.Multiplicor -> "*"
            Operacion.Dividir -> "/"
            else -> "?"
        }
    }

    private fun getResult() : Int {
        return when (op) {
            Operacion.Suma -> n1 + n2
            Operacion.Resta -> n1 - n2
            Operacion.Multiplicor -> n1 * n2
            Operacion.Dividir -> n1 / n2
            else -> 0
        }
    }

    fun reset() {
        n1 = 0
        n2 = 0
        op = Operacion.Suma
        state = State.N1
    }


}