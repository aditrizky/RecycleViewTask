package com.binar.recycleviewsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.binar.recycleviewsample.databinding.FragmentDetailBinding
import com.bumptech.glide.Glide

class DetailFragment : Fragment() {

    private var _binding : FragmentDetailBinding?=null
    private val binding :FragmentDetailBinding get() = _binding!!

    val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(this)
            .load(args.data.profileURL)
            .circleCrop()
            .into(binding.profileImageView)


        binding.usernameTextView.text= args.data.userName
        binding.phonenumberTextView.text= args.data.phoneNumber
        if(args.data.address != "null") {
            binding.addressTextView.text = args.data.address
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}