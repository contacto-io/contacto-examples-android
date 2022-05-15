package com.contacto.consumer.android.example.initatechat.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.contacto.consumer.android.example.initatechat.activity.ConfigurationActivity
import com.contacto.consumer.android.example.initatechat.activity.CustomerServiceActivity
import com.contacto.consumer.android.example.initatechat.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        binding.customerServiceTab.setOnClickListener {
            Intent(requireActivity(), CustomerServiceActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.configurationTab.setOnClickListener {
            Intent(requireActivity(), ConfigurationActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}