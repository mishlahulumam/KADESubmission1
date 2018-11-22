package com.example.muhammadmishlahulumam.kadesubmission1

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.intentFor

class Adapter(private val context: Context, private val item: List<Model>, private val listener: (Model) -> Unit)
    : RecyclerView.Adapter<Adapter.ViewHolder>(){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        init{
            view.setOnClickListener {
                view.context.startActivity(view.context.intentFor<DetailActivity>())
            }
        }

        private val namaKlub = view.findViewById<TextView>(R.id.nama_club)
        private val gambarKlub = view.findViewById<ImageView>(R.id.gambar_club)

        fun bindItem(item: Model, listener: (Model) -> Unit) {
            namaKlub.text = item.nama
            Glide.with(itemView.context).load(item.gambar).into(gambarKlub)
            itemView.setOnClickListener {
                itemView.context.startActivity(itemView.context.intentFor<DetailActivity>("gambar" to item.gambar, "nama" to item.nama, "deskripsi" to item.deskripsi))
            }
        }
    }
    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(item[position], listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_club, parent, false))
}