package com.example.listadecontatos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
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

    private fun showToast(message: String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT). show()
    }
    // Método para adicionar um menu suspenso no app
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.item_menu_1 ->{
                showToast("Exibindo item de menu 1")
                return true
            }
            R.id.item_menu_2 ->{
                showToast("Exibindo item de menu 2")
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}