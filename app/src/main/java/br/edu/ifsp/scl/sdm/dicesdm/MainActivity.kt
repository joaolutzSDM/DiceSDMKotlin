package br.edu.ifsp.scl.sdm.dicesdm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity: AppCompatActivity() {

    // Gerador de números randômicos usado para simular o lançamento do dado
    val geradorRandomico: Random = Random(System.currentTimeMillis())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun jogarDados(view: View) {
        if(view == jogarDadoButton) {
            val numDices: Int = numDicesSpinner.selectedItem.toString().toInt()
            val numFaces = numFacesEditText.text.toString().toInt()

            if(numFaces > 6) {
                resultadoImageView.visibility = View.GONE
                resultado2ImageView.visibility = View.GONE
            } else {
                resultadoImageView.visibility = View.VISIBLE
                if (numDices == 2) {
                    resultado2ImageView.visibility = View.VISIBLE
                }
                else{
                    resultado2ImageView.visibility = View.GONE
                }
            }

            var resultadoText = ""

            for(i in 1..numDices) {
                val resultado = geradorRandomico.nextInt(numFaces) + 1

                resultadoText = "$resultadoText $resultado"

                val resourceName: String = "dice_${resultado}"
                val imageView = if (i == 1) resultadoImageView else resultado2ImageView
                imageView.setImageResource(resources.getIdentifier(resourceName, "drawable", packageName))
            }

            resultadoTextView.text = "A face sorteada foi: $resultadoText"
        }
    }

}