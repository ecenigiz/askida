package com.example.askida

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.askida.Objects.Item
import kotlinx.android.synthetic.main.item_restoran_detail.view.*
import kotlinx.android.synthetic.main.item_restoran_items.view.*

class RestoranItemsAdaptor(val itemList : List<Item>, private val listener: (Item) -> Unit) : RecyclerView.Adapter<RestoranItemsAdaptor.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val item_name = itemView.findViewById<TextView>(R.id.item_name)
        private val item_price = itemView.findViewById<TextView>(R.id.item_price)
        fun bind(item: Item){
            item_name.text=item.name
            item_price.text=item.price.toString() + " TL"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v  = LayoutInflater.from(parent.context).inflate(R.layout.item_restoran_items,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=itemList[position]
        holder.bind(item)
        holder.itemView.btn_item_delete.setOnClickListener { listener(item) }    }

    override fun getItemCount(): Int = itemList.size
}