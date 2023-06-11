package com.example.sozlukproje

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class EngKelimeler : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eng_kelimeler)

        val trKelimelerListe = intent.getStringArrayListExtra("trKelimeListe")
        val engKelimelerListe = intent.getStringArrayListExtra("engKelimeListe")

        if ( trKelimelerListe != null && engKelimelerListe !=null) {
            val listeTr = findViewById<ListView>(R.id.listviewEng)
            listeTr.adapter= ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,engKelimelerListe)



            listeTr.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->


                val dialogBuilder = AlertDialog.Builder(this)
                dialogBuilder.setMessage(trKelimelerListe[position].toString())

                    .setPositiveButton("Ok", DialogInterface.OnClickListener { dialog, id ->
                        dialog.dismiss()
                    })

                val alert = dialogBuilder.create()
                alert.setTitle(engKelimelerListe[position])

                alert.show()

            }

        }

    }

    override fun onResume() {
        super.onResume()

        val engKelimelerListe = intent.getStringArrayListExtra("engKelimeListe")
        if(engKelimelerListe !=null){
            val listeTr = findViewById<ListView>(R.id.listviewEng)
            listeTr.adapter=ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,engKelimelerListe)

        }}

    }



