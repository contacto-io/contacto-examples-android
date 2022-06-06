package com.contacto.consumer.android.example.initatechat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.contacto.consumer.android.ContactoClient
import com.contacto.consumer.android.example.base.ICommon
import com.contacto.consumer.android.example.initatechat.databinding.FragmentMyOrdersBinding
import com.contacto.consumer.android.ui.model.User

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
        binding.btnChat1.setOnClickListener {
            loadChat()
        }

        binding.btnChat2.setOnClickListener {
            loadChat()
        }
    }

    private fun loadChat() {
        val appId = (requireActivity().application as ICommon).getAppId() ?: ""
        val appKey = (requireActivity().application as ICommon).getAppKey() ?: ""
        if(appId.isEmpty() || appKey.isEmpty()) {
            Toast.makeText(requireContext(), "Please provide AppId and AppKey", Toast.LENGTH_LONG).show()
            return
        }

        val user = User(
            mobile = "918050574001",
            email = "abcdef@gmail.com"
        )

        ContactoClient.init(appId = appId, appKey = appKey)
        ContactoClient.loadChat(requireContext(), /*Pass user info*/)
    }
}