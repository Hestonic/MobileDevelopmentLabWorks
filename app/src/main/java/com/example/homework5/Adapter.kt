package com.example.homework5


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework5.databinding.ItemBinding

class Adapter(private val list: List<Item>) : RecyclerView.Adapter<Adapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val models = list[position]
        holder.bind(models)
    }

    override fun getItemCount(): Int = list.size

    inner class Holder internal constructor(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(models: Item) = binding.run {
            recyclerText.text = models.info
        }

    }
}