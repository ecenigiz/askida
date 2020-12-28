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
        private val item_quantity = itemView.findViewById<TextView>(R.id.item_quantity)
        private val item_price = itemView.findViewById<TextView>(R.id.item_price)
        fun bind(item: Item){
            item_name.text=item.name
            item_quantity.text=item.quantity.toString() + " Quantity"
            item_price.text=item.price.toString() + " TL"
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