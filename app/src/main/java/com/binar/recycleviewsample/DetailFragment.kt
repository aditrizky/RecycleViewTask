package com.binar.recycleviewsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide

class DetailFragment : Fragment() {

    val args: DetailFragmentArgs by navArgs()

    private lateinit var usernameTextView: TextView
    private lateinit var phoneNUmberTextView: TextView
    private lateinit var addressTextView: TextView
    private lateinit var profileImageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        usernameTextView= view.findViewById(R.id.username_text_view)
        phoneNUmberTextView=view.findViewById(R.id.phonenumber_text_view)
        addressTextView= view.findViewById(R.id.address_text_view)
        profileImageView= view.findViewById(R.id.profile_imageView)

        Glide.with(this)
            .load(args.data.profileURL)
            .circleCrop()
            .into(profileImageView)


        usernameTextView.text= args.data.userName
        phoneNUmberTextView.text= args.data.phoneNumber
        if(args.data.address != "null") {
            addressTextView.text = args.data.address
        }
    }

}