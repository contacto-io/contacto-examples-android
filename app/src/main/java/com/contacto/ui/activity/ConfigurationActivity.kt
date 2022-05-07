package com.contacto.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.contacto.databinding.ActivityConfigurationBinding
import com.contacto.ui.fragments.ConfigurationBottomSheet

class ConfigurationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfigurationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityConfigurationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI() {
        binding.llConfig.setOnClickListener {
            ConfigurationBottomSheet().show(supportFragmentManager, "config")
        }
    }
}