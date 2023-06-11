package com.example.sozlukproje
import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.AdapterView
import android.widget.ArrayAdapter

import android.widget.ListView
import android.widget.SearchView


import java.util.*


class TrKelimeler : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tr_kelimeler)

        val trKelimelerListe = intent.getStringArrayListExtra("trKelimeListe")
        val engKelimelerListe = intent.getStringArrayListExtra("engKelimeListe")


          val listeTr = findViewById<ListView>(R.id.listviewTr)
        val adapter =ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,trKelimelerListe!!)
        listeTr.adapter=adapter



            listeTr.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->


                val dialogBuilder = AlertDialog.Builder(this)
                dialogBuilder.setMessage(engKelimelerListe!![position].toString())

                    .setPositiveButton("Ok", DialogInterface.OnClickListener { dialog, id ->
                        dialog.dismiss()
                    })

                val alert = dialogBuilder.create()
                alert.setTitle(trKelimelerListe[position])

                alert.show()

        }


        val searchView = findViewById<SearchView>(R.id.searchViewTr)



        listeTr.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                adapter.filter.filter(newText)
                return true
            }
        })



       // adapter.filter.filter(searchView.query)


    }
    override fun onResume() {
        super.onResume()

        val trKelimelerListe = intent.getStringArrayListExtra("trKelimeListe")
        trKelimelerListe?.let {
            val listeTr = findViewById<ListView>(R.id.listviewTr)
            listeTr.adapter=ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,trKelimelerListe) }

    }




    }