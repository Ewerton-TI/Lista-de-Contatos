package com.example.listadecontatos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ContatcAdapter : RecyclerView.Adapter<ContatcAdapter.ContactAdapterViewHolder>(){
        private val  list: MutableList<Contact> = mutableListOf()

// Responsavel por criar cada item na tela
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent,false)
    return ContactAdapterViewHolder(view)
    }
//informar quantos itens tem dentro da minha lista
    override fun getItemCount(): Int {
    //retorna o tamanho da lista de contatos
       return list.size
    }
//Responsvel por percorrer cada item do array e popula o seu item na lista do recicler view
    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
    //responsavel por pegar o item do contactAdapterViewHolder pela posição
        holder.bind(list[position])
    }

    fun updateList(list: List<Contact>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
    //responsavel por controlar cada item da lista
    class ContactAdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val tvName:TextView = itemView.findViewById(R.id.tv_name)
        private val tvPhone:TextView = itemView.findViewById(R.id.tv_phone)
        private val imPhoto:ImageView = itemView.findViewById(R.id.im_photo)

        fun bind(contact: Contact){
        tvName.text = contact.name
        tvPhone.text = contact.phone

        }
    }
}