package com.binar.recycleviewsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.binar.recycleviewsample.data.User
import com.binar.recycleviewsample.databinding.FragmentRecycleVIewBinding

class RecycleVIewFragment : Fragment() {

    private var _binding : FragmentRecycleVIewBinding?=null
    private val binding : FragmentRecycleVIewBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRecycleVIewBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userRecyclerView = binding.recycleview

        val userlist = listOf(
            User(
                userName = "aditya",
                phoneNumber = "08226454564",
                address = "Denpasar",
                profileURL = "https://cdn4.iconfinder.com/data/icons/avatars-xmas-giveaway/128/indian_man_male_person-512.png"
            ),
            User(
                userName = "rizky",
                phoneNumber = "08226454564",
                address = "Bali",
                profileURL = "https://cdn4.iconfinder.com/data/icons/avatars-xmas-giveaway/128/muslim_man_avatar-512.png"
            ),
            User(
                userName = "dananjaya",
                phoneNumber = "08226454564",
                address = "Tabanan",
                profileURL = "https://cdn4.iconfinder.com/data/icons/avatars-xmas-giveaway/128/girl_female_woman_avatar-512.png"
            ),
            User(
                userName = "i wayan",
                phoneNumber = "08226454564",
                address = "jakarta"
            ),
            User(
                userName = "adit",
                phoneNumber = "08226454564"
            ),
            User(
                userName = "adit",
                phoneNumber = "08226454564"
            ),
            User(
                userName = "adit",
                phoneNumber = "08226454564"
            ),
            User(
                userName = "adit",
                phoneNumber = "08226454564"
            ),
            User(
                userName = "adit",
                phoneNumber = "08226454564"
            ),
            User(
                userName = "adit",
                phoneNumber = "08226454564"
            ),
            User(
                userName = "adit",
                phoneNumber = "08226454564"
            ),
            User(
                userName = "adit",
                phoneNumber = "08226454564"
            ),
            User(
                userName = "adit",
                phoneNumber = "08226454564"
            ),
            User(
                userName = "adit",
                phoneNumber = "08226454564"
            ),
            User(
                userName = "adit",
                phoneNumber = "08226454564"
            )
        )
        val userAdapter = UserAdapter(userlist)
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        userRecyclerView.layoutManager = layoutManager
        userRecyclerView.adapter = userAdapter
    }

}