package com.example.homework17

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(
    private var listCountry: List<CountryModel>,
): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val country = listCountry[position]
        holder.bind(country)
    }

    override fun getItemCount(): Int {
        return listCountry.size
    }
    fun updateData(newList: List<CountryModel>) {
        listCountry = newList
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val imageViewFlag: ImageView = itemView.findViewById(R.id.imageViewFlag)
        private val textViewCountryName: TextView = itemView.findViewById(R.id.textViewCountryName)
        fun bind(country: CountryModel){
            imageViewFlag.setImageResource(country.imageFlag)
            textViewCountryName.text = country.nameCountry
        }
    }
}