package com.example.askida

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.askida.Objects.Item

class CartRecyclerAdapter(val itemList : List<Item>) : RecyclerView.Adapter<CartRecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val item_name = itemView.findViewById<TextView>(R.id.item_name)
        fun bind(item: Item){
            item_name.text=item.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v  = LayoutInflater.from(parent.context).inflate(R.layout.item_cart,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size
}