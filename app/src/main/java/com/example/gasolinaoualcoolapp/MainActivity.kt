package com.example.gasolinaoualcoolapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcularCombustivel(view: View){

        //Reculperar valor com findByID
        var valorGasolina = txtGasolina.text.toString()
        var valorAlcool = txtAlcool.text.toString()

       var validaCampos = validarCampos(valorAlcool, valorGasolina)

        if ( validaCampos ){

            calcularMelhorPreco(valorAlcool, valorGasolina)

        }else Toast.makeText(this, "Campo alcool ou Gasolina tem que ser Preenchido", Toast.LENGTH_SHORT).show()


    }

    private fun calcularMelhorPreco(valorAlcool: String, valorGasolina: String) {

        var sun = (valorAlcool.toDouble() /  valorGasolina.toDouble())

        if (sun >= 0.7){
            txtResultado.text = "Melhor Usar a Gasolina"
        }else txtResultado.text = "Melhor usar Alcool"

    }

    private fun validarCampos(valorAlcool: String, valorGasolina: String): Boolean {

        var camposValidados = true;

        if (valorAlcool == null || valorAlcool.trim() == "") camposValidados = false

       else if (valorGasolina == null || valorAlcool.trim() == "") camposValidados = false

        return camposValidados

    }



}