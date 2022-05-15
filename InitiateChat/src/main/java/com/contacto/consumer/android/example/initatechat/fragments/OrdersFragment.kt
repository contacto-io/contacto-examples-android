package com.contacto.consumer.android.example.initatechat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.contacto.consumer.android.example.initatechat.databinding.FragmentMyOrdersBinding

class OrdersFragment : Fragment() {

    private lateinit var binding: FragmentMyOrdersBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyOrdersBinding.inflate(layoutInflater)
        return binding.root
    }
}