package com.example.listadecontatos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listadecontatos.ContactDetail.Companion.EXTRA_CONTACT

class MainActivity : AppCompatActivity(), ClickItemContactListener {
    private  val rvList: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rv_list)
    }
    private val  adpterContact = ContatcAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawe_menu)

        initDrawer()
        bindViews()
        updateList()
    }

    private fun initDrawer(){
        val drawerLayout = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val toogle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()
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
                    "Jose de Oliveira",
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

    override fun clickItemContact(contact: Contact) {
        val intent = Intent(this, ContactDetail::class.java)
        intent.putExtra(EXTRA_CONTACT, contact)
        startActivity(intent)
    }
}