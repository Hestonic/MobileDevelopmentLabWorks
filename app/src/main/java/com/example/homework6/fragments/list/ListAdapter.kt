package com.example.homework6.fragments.list

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework6.model.User
import com.example.homework6.databinding.CustomRowBinding
import com.example.homework6.MAIN
import com.example.homework6.model.Parent

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()
    private var parentList = emptyList<Parent>()

    inner class MyViewHolder(private val binding: CustomRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(currentItem: User) {
            binding.idTxt.text = currentItem.id.toString()
            binding.nodeValue.text = currentItem.firstName

            binding.rowLayout.setOnClickListener {
                val id = currentItem.id
                val node = currentItem.firstName
                val action = ListFragmentDirections.actionListFragmentToParentFragment(id, node)
                MAIN.navController.navigate(action)
            }

            var isParent = 0
            var isChild = 0
            for (parent in parentList) {
                if (parent.parent == currentItem.id) {
                    binding.rowLayout.setBackgroundColor(Color.YELLOW)
                    isParent = 1
                }
                if (parent.children == currentItem.id) {
                    binding.rowLayout.setBackgroundColor(Color.BLUE)
                    isChild = 1
                }
                if (isParent > 0 && isChild > 0) {
                    binding.rowLayout.setBackgroundColor(Color.RED)
                    break
                }
            }
        }
    }

    override fun getItemCount(): Int = userList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = CustomRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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