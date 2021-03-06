package com.example.myapplication.Ui

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Data.Doacao
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityItemDoacaoBinding


class DoacaoAdapter: androidx.recyclerview.widget.ListAdapter<Doacao, DoacaoAdapter.ViewHolder>(DiffCallback()) {
    var listenerDelete:(Doacao) -> Unit ={}
    var listernerUpdate:(Doacao) -> Unit ={}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ActivityItemDoacaoBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))


    }
    inner class ViewHolder(private val binding: ActivityItemDoacaoBinding ):RecyclerView.ViewHolder(binding.root) {
        fun bind(itens: Doacao){
            binding.nome.text = itens.nome
            binding.contato.text = itens.contato
            binding.caracteristicas.text = itens.caracteristicas
            binding.more.setOnClickListener{
                showPopup(itens)
            }


        }
        private fun showPopup(itens: Doacao) {
            val iconMore = binding.more
            val popupMenu = PopupMenu(iconMore.context, iconMore)
            popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.mvc_delete -> listenerDelete(itens)
                    R.id.edit -> listernerUpdate(itens)
                }
                return@setOnMenuItemClickListener true
            }
            popupMenu.show()
        }


}
}

class DiffCallback: DiffUtil.ItemCallback<Doacao>(){
    override fun areItemsTheSame(oldItem: Doacao, newItem: Doacao) = oldItem == newItem

    override fun areContentsTheSame(oldItem: Doacao, newItem: Doacao) = oldItem.id == newItem.id


}

