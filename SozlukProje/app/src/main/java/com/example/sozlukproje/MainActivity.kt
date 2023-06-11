package com.example.sozlukproje

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.SimpleAdapter


class MainActivity : AppCompatActivity() {

    val kelimeler = HashMap<String,String>()
    val trKelimeListe = ArrayList<String>()
    val engKelimeListe = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        kelimeler["elma"]="apple"
        kelimeler["kalem"]="pencil"

        for (kelime in kelimeler) {
            trKelimeListe.add(kelime.key)
            engKelimeListe.add(kelime.value)
        }
    }




    fun TrKelimeAc(view: View) {

        val intent = Intent(this, TrKelimeler::class.java)
        intent.putStringArrayListExtra("trKelimeListe", trKelimeListe)
        intent.putStringArrayListExtra("engKelimeListe",engKelimeListe)
        startActivity(intent)
    }

    fun EngKelimeAc(view:View){
        val intent = Intent(this, EngKelimeler::class.java)
        intent.putStringArrayListExtra("trKelimeListe", trKelimeListe)
        intent.putStringArrayListExtra("engKelimeListe",engKelimeListe)
        startActivity(intent)
    }
}