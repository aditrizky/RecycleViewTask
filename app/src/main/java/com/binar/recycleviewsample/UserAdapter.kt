package com.binar.recycleviewsample


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.binar.recycleviewsample.data.User
import com.binar.recycleviewsample.databinding.ItemUserBinding
import com.bumptech.glide.Glide

class UserAdapter(private val user: List<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.binding.nameTextView.text = user[position].userName
        holder.binding.numberTextView.text = user[position].phoneNumber
        //load profile image
        Glide.with(holder.itemView.context)
            .load(user[position].profileURL)
            .into(holder.binding.userImageView)
        val address = user[position].address.toString()
        val imageURL = user[position].profileURL.toString()

        holder.itemView.setOnClickListener {
            val person = User(
                userName = holder.binding.nameTextView.text.toString(),
                phoneNumber = holder.binding.numberTextView.text.toString(),
                address = address,
                profileURL = imageURL
            )
            it.findNavController().navigate(
                RecycleVIewFragmentDirections.actionRecycleVIewFragmentToDetailFragment(data = person)
            )
        }

    }

    override fun getItemCount(): Int {
        return user.size
    }
}