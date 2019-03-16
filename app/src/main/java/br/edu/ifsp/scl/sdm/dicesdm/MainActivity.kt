package br.edu.ifsp.scl.sdm.dicesdm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.startActivity
import java.util.*

class MainActivity: AppCompatActivity() {

    // Gerador de números randômicos usado para simular o lançamento do dado
    val geradorRandomico: Random = Random(System.currentTimeMillis())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.frame_main)

        setSupportActionBar(toolbar)
        supportActionBar?.title = resources.getString(R.string.app_name)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val abreFechaToggle: ActionBarDrawerToggle =
                ActionBarDrawerToggle(this,
                        menuLateralDrawerLayout,
                        toolbar,
                        R.string.menu_aberto,
                        R.string.menu_fechado
                )
        menuLateralDrawerLayout.addDrawerListener(abreFechaToggle)
        abreFechaToggle.syncState()

        menuNavigationView.setNavigationItemSelectedListener { onNavigationItemSelected(it) }
    }

    fun onNavigationItemSelected(it: MenuItem): Boolean {
        var retorno: Boolean = false
        when(it.itemId) {
            R.id.modoTextoMenuItem -> {
                //TODO()
                retorno = true
            }
            R.id.modoGraficoMenuItem -> {
                TODO()
                retorno = true
            }
            R.id.sairMenuItem -> {
                finish()
                retorno = true
            }
        }
        menuLateralDrawerLayout.closeDrawer(GravityCompat.START)
        return retorno
    }

    override fun onBackPressed() {
        if(menuLateralDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            menuLateralDrawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.configuracoesMenuItem ->
                //startActivity(Intent(this, ConfigActivity::class.java))
            startActivity<ConfigActivity>()
        }
        return super.onOptionsItemSelected(item)
    }

//    fun jogarDados(view: View) {
//        if(view == jogarDadoButton) {
//            val numDices: Int = numDicesSpinner.selectedItem.toString().toInt()
//            val numFaces = numFacesEditText.text.toString().toInt()
//
//            if(numFaces > 6) {
//                resultadoImageView.visibility = View.GONE
//                resultado2ImageView.visibility = View.GONE
//            } else {
//                resultadoImageView.visibility = View.VISIBLE
//                if (numDices == 2) {
//                    resultado2ImageView.visibility = View.VISIBLE
//                }
//                else{
//                    resultado2ImageView.visibility = View.GONE
//                }
//            }
//
//            var resultadoText = ""
//
//            for(i in 1..numDices) {
//                val resultado = geradorRandomico.nextInt(numFaces) + 1
//
//                resultadoText = "$resultadoText $resultado"
//
//                val resourceName: String = "dice_${resultado}"
//                val imageView = if (i == 1) resultadoImageView else resultado2ImageView
//                imageView.setImageResource(resources.getIdentifier(resourceName, "drawable", packageName))
//            }
//
//            resultadoTextView.text = "A face sorteada foi: $resultadoText"
//        }
//    }

}