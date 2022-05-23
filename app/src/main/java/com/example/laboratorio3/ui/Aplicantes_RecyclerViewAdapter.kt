package com.example.laboratorio3.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio3.R

class Aplicantes_RecyclerViewAdapter(private var items: ArrayList<Aplicante>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), Filterable{

    var itemList: ArrayList<Aplicante>? = null

    init {
        this.itemList = items
    }
    //Este metodo le pasara las vistas a variables
    inner class AplicanteHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //Aqui se inflara el layout (Osea cargara las filas)

        //Se crea un inflater y luego se devuelve el inner class osea el AplicanteHolder con el view creado
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_row, parent, false)
        return AplicanteHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //Aqui se asigna los valores a las vistas creadas en el recycler view
        // esto se hara basado en la posicion en el recycler view
        val item = itemList?.get(position)
        holder.itemView.findViewById<TextView>(R.id.nombreAplicante)?.text = item?.firstName
        holder.itemView.findViewById<TextView>(R.id.tvLastNameCard)?.text = item?.lastName
        holder.itemView.findViewById<TextView>(R.id.tvCityCard)?.text = item?.city
        holder.itemView.findViewById<TextView>(R.id.tvProvinceCard)?.text = item?.province
        holder.itemView.findViewById<TextView>(R.id.tvPositionCard)?.text = item?.applyPosition
        holder.itemView.findViewById<ImageView>(R.id.iVfoto).setImageResource(item?.foto!!)
    }


    override fun getItemCount(): Int {
        // ?. es una llamada segura
        // !! es una llamada que permite null
       return itemList?.size!!
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    itemList = items
                } else {
                    val resultList = ArrayList<Aplicante>()
                    for (row in items) {
                        if (row.firstName.toLowerCase().contains(charSearch.toLowerCase())) {
                            resultList.add(row)
                        }
                    }
                    itemList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = itemList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                itemList = results?.values as ArrayList<Aplicante>
                notifyDataSetChanged()
            }

        }
    }

}