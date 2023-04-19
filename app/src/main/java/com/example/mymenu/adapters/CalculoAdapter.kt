package com.example.mymenu.adapters

import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymenu.R
import com.example.mymenu.core.CalculoGC
import java.util.Calendar
import java.util.Locale

class CalculoAdapter(private val data:MutableMap<Int, CalculoGC>?) :
    RecyclerView.Adapter<CalculoAdapter.CalculoHolder>(){
    inner class CalculoHolder(var v: View) : RecyclerView.ViewHolder(v){
        var tituloItemLista: TextView
        var estadoItemLista: TextView
        var fechaItemLista: TextView
        var dataItemLista: TextView

        init {
            tituloItemLista = v.findViewById(R.id.titulo_item_lista)
            estadoItemLista = v.findViewById(R.id.estado_item_lista)
            fechaItemLista = v.findViewById(R.id.fecha_item_lista)
            dataItemLista = v.findViewById(R.id.data_item_lista)
        }

        fun bindData(data : CalculoGC) = with(v){
            tituloItemLista.text = "Resultado: ${data.cgcResultado}"
            estadoItemLista.text = data.cgcEstado.uppercase()
            fechaItemLista.text = "Fecha: ${convertDateFormat(data.cgcFechaCalculo.time, "dd/MM/yyyy HH:mm:ss")}"
            dataItemLista.text = "Datos \nEdad: ${data.cgcEdad} años \nMasa Corporal: ${data.cgcIndicadorMasaCorp} "
        }

        fun convertDateFormat(time: Long, format: String): String{
            val calendar = Calendar.getInstance(Locale.getDefault())
            calendar.timeInMillis = (time +1000L)
            val dateString = DateFormat.format(format, calendar).toString().replaceFirstChar{ it.uppercaseChar() }
            return dateString
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalculoHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_lista_calculos, parent, false)
        return CalculoHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: CalculoHolder, position: Int) {
        data?.let {
            it.get(position)?.let { it1 -> holder.bindData(it1) }
        }
    }
}
