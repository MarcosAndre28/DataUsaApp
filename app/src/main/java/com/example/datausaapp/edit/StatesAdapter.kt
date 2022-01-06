package com.example.datausaapp.edit

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.datausaapp.R
import com.example.datausaapp.data.model.State

class StatesAdapter(private val onItemClick: (State) -> Unit ) : RecyclerView.Adapter<StatesAdapter.CityViewHolder>() {
    private var list = listOf<State>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val context = parent.context
        val inflate = LayoutInflater.from(context)
        val contactView = inflate.inflate(R.layout.item_rv_city,parent,false)
        return CityViewHolder(contactView)

    }


    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(list[position])
    }
    override fun getItemCount(): Int {
        return list.size
    }
  inner class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var tvName = itemView.findViewById<TextView>(R.id.name_city)
        private  var  tvPopulation = itemView.findViewById<TextView>(R.id.city_population)

       fun bind(state: State){
           tvName.text = state.state
           tvPopulation.text = state.population.toString()

           itemView.setOnClickListener {
            onItemClick(state)
               Log.d("***Adapter", state.toString())
           }
       }
    }
    fun setupRecycleView(lista: List<State>) {
        list = lista
        notifyDataSetChanged()
    }
}