package com.contacto.consumer.android.example.initatechat.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import com.contacto.consumer.android.example.base.ICommon
import com.contacto.consumer.android.example.initatechat.databinding.UserBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class UserBottomSheet(val onClose: () -> Unit) : BottomSheetDialogFragment() {

    private lateinit var binding: UserBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = UserBottomSheetBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
        val fName = (requireActivity().application as ICommon).getFirstName() ?: ""
        val lName = (requireActivity().application as ICommon).getLastName() ?: ""
        val email = (requireActivity().application as ICommon).getEmail() ?: ""
        val phone = (requireActivity().application as ICommon).getPhone() ?: ""

        binding.etFName.setText(fName)
        binding.etLName.setText(lName)
        binding.etEmail.setText(email)
        binding.etPhone.setText(phone)

        binding.etFName.doOnTextChanged { _, _, _, _ ->
            validate()
        }

        binding.etFName.doOnTextChanged { _, _, _, _ ->
            validate()
        }

        binding.etEmail.doOnTextChanged { _, _, _, _ ->
            validate()
        }

        binding.etPhone.doOnTextChanged { _, _, _, _ ->
            validate()
        }

        binding.tvDone.setOnClickListener {
            val etFName = binding.etFName.text.toString()
            val etLName = binding.etLName.text.toString()
            val etEmail = binding.etEmail.text.toString()
            val etPhone = binding.etPhone.text.toString()
            if (etFName.isNotEmpty() && etLName.isNotEmpty() && etEmail.isNotEmpty() && etPhone.isNotEmpty()) {
                (requireActivity().application as ICommon).saveUser(
                    fName = etFName,
                    lName = etLName,
                    email = etEmail,
                    phone = etPhone
                )
                dismiss()
            }
            onClose()
        }

        binding.tvCancel.setOnClickListener {
            dismiss()
        }
    }

    private fun validate() {
        if (binding.etFName.text.isNullOrBlank() || binding.etLName.text.isNullOrBlank() || binding.etEmail.text.isNullOrBlank() || binding.etPhone.text.isNullOrBlank()) {
            binding.tvDone.isEnabled = false
            binding.tvDone.setTextColor(Color.parseColor("#CDCFD5"))
        } else {
            binding.tvDone.isEnabled = true
            binding.tvDone.setTextColor(Color.parseColor("#007AFF"))
        }
    }
}