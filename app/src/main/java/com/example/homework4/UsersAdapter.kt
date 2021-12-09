package com.example.homework4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework4.databinding.ItemUsersBinding

class UsersAdapter(
    private val list: List<Picture>,
    private val clickItem: (Picture) -> Unit,
    private val clickLike: (Picture) -> Unit
) : RecyclerView.Adapter<UsersAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding, clickItem, clickLike)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val picture = list[position]
        holder.bind(picture)
    }

    override fun getItemCount(): Int = list.size

    inner class Holder internal constructor(
        private val binding: ItemUsersBinding,
        private val clickItem: (Picture) -> Unit,
        private val clickLike: (Picture) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(picture: Picture) = binding.run {
            userName.text = picture.name
            userPicture.setImageResource(picture.imageDrawableRes)
            userYears.text = picture.year
            userBio.text = picture.bio
            userSex.text = picture.sex
            binding.root.setOnClickListener { clickItem.invoke(picture) }
            binding.userLike.setOnClickListener { clickLike.invoke(picture) }
        }
    }
}