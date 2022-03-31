package com.binar.recycleviewsample


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.binar.recycleviewsample.data.User
import com.bumptech.glide.Glide

class UserAdapter(private val user: List<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val usernameTextView: TextView = view.findViewById(R.id.name_text_view)
        val phoneNumberTextView: TextView = view.findViewById(R.id.number_text_view)
        val userImageView: ImageView = view.findViewById(R.id.user_imageView)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.usernameTextView.text = user[position].userName
        holder.phoneNumberTextView.text = user[position].phoneNumber
        //load profile image
        Glide.with(holder.itemView.context)
            .load(user[position].profileURL)
            .into(holder.userImageView)
        val address = user[position].address.toString()
        val imageURL = user[position].profileURL.toString()

        holder.itemView.setOnClickListener {
            val person = User(
                userName = holder.usernameTextView.text.toString(),
                phoneNumber = holder.phoneNumberTextView.text.toString(),
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