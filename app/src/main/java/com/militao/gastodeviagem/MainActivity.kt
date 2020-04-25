package com.militao.gastodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalcular.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonCalcular) {
            calculate()
        }
    }

    private fun calculate() {
       // Log.e("TESTE2", "FOI !!!")
        if (validationOK()) {
            try {
                val distance = editDistancia.text.toString().toFloat()
                val price = editPreco.text.toString().toFloat()
                val autonomy = editAutonomia.text.toString().toFloat()

                val total = (distance * price) / autonomy

                textTotalValue.text = "R$ ${"%.2f".format(total)}"
            } catch (nfe: NumberFormatException) {
                Toast.makeText(this, getString(R.string.informa_valor_valido), Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, getString(R.string.preencha_todos_campos), Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun validationOK(): Boolean =
        (editDistancia.text.toString() != "" && editAutonomia.text.toString() != "" && editPreco.text.toString() != ""  && editAutonomia.text.toString() != "0")
}
