package com.contacto.consumer.android.example.initatechat.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import com.contacto.consumer.android.example.base.ICommon
import com.contacto.consumer.android.example.initatechat.databinding.ConfigurationBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ConfigurationBottomSheet : BottomSheetDialogFragment() {

    private lateinit var binding: ConfigurationBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ConfigurationBottomSheetBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
        val appId = (requireActivity().application as ICommon).getAppId() ?: ""
        val appKey = (requireActivity().application as ICommon).getAppKey() ?: ""

        binding.etAppId.setText(appId)
        binding.etChatKey.setText(appKey)

        binding.etAppId.doOnTextChanged { _, _, _, _ ->
            validate()
        }

        binding.etChatKey.doOnTextChanged { _, _, _, _ ->
            validate()
        }

        binding.tvDone.setOnClickListener {
            val key = binding.etChatKey.text.toString()
            val id = binding.etAppId.text.toString()
            if(id.isNotEmpty() && key.isNotEmpty()) {
                (requireActivity().application as ICommon).savePref(id, key)
                dismiss()
            }
        }

        binding.tvCancel.setOnClickListener {
            dismiss()
        }
    }

    private fun validate() {
        if(binding.etAppId.text.isNullOrBlank() || binding.etChatKey.text.isNullOrBlank()) {
            binding.tvDone.isEnabled = false
            binding.tvDone.setTextColor(Color.parseColor("#CDCFD5"))
        } else {
            binding.tvDone.isEnabled = true
            binding.tvDone.setTextColor(Color.parseColor("#007AFF"))
        }
    }
}