package com.example.homework6.fragments.update

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.recyclerview.widget.RecyclerView
import com.example.homework6.databinding.ChildrenRowBinding
import com.example.homework6.model.Parent
import com.example.homework6.model.User

class ChildrenAdapter(val mainId: Int, val mainValue: String, val itemClick: (Int, Int, Int, Int) -> Unit) : RecyclerView.Adapter<ChildrenAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()
    private var parentList = emptyList<Parent>()

    inner class MyViewHolder(private val binding: ChildrenRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(currentItem: User) {
            if (currentItem.id !== mainId) {
                binding.idSecond.text = currentItem.id.toString()
                binding.valueSecond.text = currentItem.firstName

                binding.idMain.text = mainId.toString()
                binding.valueMain.text = mainValue

                var isFilled = 0
                var parentId = 0
                for (parent in parentList)
                    if ((parent.parent == mainId) && (parent.children == currentItem.id)) {
                        isFilled = 1
                        itemView.setBackgroundColor(Color.CYAN)
                        binding.rowLayout.setOnClickListener {
                            itemView.setOnClickListener { itemClick(parent.id, mainId, currentItem.id, 1) }
                        }
                        parentId = parent.id
                        break
                    }

                if (isFilled == 1) binding.rowLayout.setOnClickListener {
                    itemView.setOnClickListener { itemClick(parentId, mainId, currentItem.id, isFilled) }
                }
                else binding.rowLayout.setOnClickListener {
                    itemView.setOnClickListener { itemClick(parentId, mainId, currentItem.id, isFilled) }
                }

                for (parent in parentList)
                    if ((parent.children == mainId) && (parent.parent == currentItem.id)) {
                        itemView.isGone = true
                        itemView.layoutParams.height = 0
                        itemView.layoutParams.width = 0
                    }

            } else {
                itemView.isGone = true
                itemView.layoutParams.height = 0
                itemView.layoutParams.width = 0
            }



        }
    }

    override fun getItemCount(): Int = userList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ChildrenRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.bind(currentItem)
    }

    fun setData(user: List<User>) {
        this.userList = user
        notifyDataSetChanged()
    }

    fun setDataParent(parent: List<Parent>) {
        this.parentList = parent
        notifyDataSetChanged()
    }
}