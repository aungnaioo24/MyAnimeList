package com.example.myanimelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myanimelist.databinding.ListItemsBinding
import com.example.myanimelist.network.Serie

class ListItemAdapter : ListAdapter<Serie, ListItemAdapter.SerieViewHolder>(DiffCallback) {
    class SerieViewHolder(private var binding: ListItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(serie: Serie) {
            binding.serie = serie
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Serie>() {
        override fun areItemsTheSame(oldItem: Serie, newItem: Serie): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Serie, newItem: Serie): Boolean {
            return oldItem.id == newItem.id
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListItemAdapter.SerieViewHolder {
        return SerieViewHolder(ListItemsBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ListItemAdapter.SerieViewHolder, position: Int) {
        val serie = getItem(position)
        holder.bind(serie)
    }
}