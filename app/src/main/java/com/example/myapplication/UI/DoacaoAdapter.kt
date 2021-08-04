package com.example.myapplication.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.DATA.Doacao

class DoacaoAdapter: androidx.recyclerview.widget.ListAdapter<Doacao, DoacaoAdapter.ViewHolder>(DiffCallback()) {
    var listenerShare:(View) -> Unit ={}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemD.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    inner class ViewHolder(private val binding: ItemDoacaoBinding ):RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Doacao){
            binding.nome.text = item.nome,
            binding.caracteristicas.text = item.caracteristicas,
            binding.contato.text = item.contato


        }

    }
}

class DiffCallback: DiffUtil.ItemCallback<Doacao>(){
    override fun areItemsTheSame(oldItem: Doacao, newItem: Doacao) = oldItem == newItem

    override fun areContentsTheSame(oldItem: Doacao, newItem: Doacao) = oldItem.id == newItem.id


}

