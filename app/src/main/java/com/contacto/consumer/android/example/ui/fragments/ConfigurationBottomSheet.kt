package com.contacto.consumer.android.example.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.contacto.consumer.android.example.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ConfigurationBottomSheet : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.configuration_bottom_sheet, container, false)
    }

}