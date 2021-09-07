package com.example.listadecontatos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private  val rvList: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rv_list)
    }
    private val  adpterContact = ContatcAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindViews()
        updateList()
    }
    private fun bindViews(){
        rvList.adapter = adpterContact
        rvList.layoutManager = LinearLayoutManager(this)
    }
    private fun  updateList(){
        adpterContact.updateList(
            arrayListOf(
                Contact(
                    "Ewerton de Oliveira",
                    "11 33333-44444",
                    "img.png"
                ),
                Contact(
                    "Ewerton de Oliveira",
                    "11 11111-2222",
                    "img.png"
                )
            )
        )
    }
}