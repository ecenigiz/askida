package com.example.askida.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.askida.Objects.Item
import com.example.askida.Objects.Restoran
import com.example.askida.R
import kotlinx.android.synthetic.main.item_restoran_detail.view.*

class UserRestoranDetailAdapter(val itemList: List<Item>, private val listener: (Item) -> Unit) :
    RecyclerView.Adapter<UserRestoranDetailAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val item_name = itemView.findViewById<TextView>(R.id.item_name)
        private val item_quantity = itemView.findViewById<NumberPicker>(R.id.item_quantity)
        private val item_price_total = itemView.findViewById<TextView>(R.id.item_price_total)
        private val item_price = itemView.findViewById<TextView>(R.id.item_price)
        private val btn_add = itemView.findViewById<TextView>(R.id.btn_add)
        fun bind(item: Item) {
            item_name.text = item.name
            item_quantity.minValue = 1
            item_quantity.maxValue = 100
            item_quantity.wrapSelectorWheel = true
            item_price.text = item.price.toString()
            //item_price_total.text = (item.quantity * item.price).toString() + " TL"

            item_quantity.setOnValueChangedListener { picker, oldVal, newVal ->
              //  item.quantity=newVal
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_restoran_detail, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=itemList[position]
        holder.bind(item)
        holder.itemView.btn_add.setOnClickListener { listener(item) }
    }

    override fun getItemCount(): Int = itemList.size
}