package com.example.askida

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.askida.Objects.Restoran


class RestoranRecyclerAdapter(val itemList: List<Restoran>, private val listener: (Restoran) -> Unit) :
    RecyclerView.Adapter<RestoranRecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val item_name = itemView.findViewById<TextView>(R.id.item_name)
        private val item_city = itemView.findViewById<TextView>(R.id.item_city)
        fun bind(item: Restoran) {
            item_name.text = item.name
            item_city.text = item.City
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_restoran, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=itemList[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { listener(item) }
    }

    override fun getItemCount(): Int = itemList.size
}
