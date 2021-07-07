package com.axweb.calculadoradeimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.axweb.calculadoradeimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btCalcular = binding.btCalculate
        val messagem = binding.message

        btCalcular.setOnClickListener {
            val editPeso = binding.editWeight.text.toString()
            val editAltura = binding.editHeight.text.toString()

            if (editPeso.isEmpty()) {
                messagem.setText("Informe o seu Peso")
            } else if (editAltura.isEmpty()) {

                messagem.setText("Informe o sua Altura")
            }else{
                calculateIMC()
            }
        }
    }

    private fun calculateIMC() {
        val pesoID = binding.editWeight
        val alturaID = binding.editHeight

        val peso = Integer.parseInt(pesoID.text.toString())
        val altura = java.lang.Float.parseFloat(alturaID.text.toString())
        val resultado = binding.message
        val imc = peso /(altura * altura)

        val message = when {
            imc <= 18.5 -> "Peso Baixo"
            imc <= 24.9 -> "Peso Normal"
            imc <= 29.9 -> "Sobrepeso"
            imc <= 34.9 -> "Obesidade (grau 1)"
            imc <= 39.9 -> "Obesidade (Grau 2)"
            else -> "Obesidade Mórbida (Grau 3)"
        }
        imc.toString()
        resultado.setText("IMC: $imc \n $message")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {


        return true
    }
}