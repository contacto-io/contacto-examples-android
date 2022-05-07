package com.contacto.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.contacto.consumer.android.ContactoClient
import com.contacto.consumer.android.ui.model.ContactoConfig
import com.contacto.databinding.ActivityCustomerSupportBinding

class CustomerServiceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomerSupportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomerSupportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI() {
        val config = ContactoConfig(
            appId = "a4ef65e8-5908-4c65-8b65-52ff7a2bf8eb",
            appKey = "665255e3914bb5060b0ba7102a8bade8d7dcf21e734093818863ac759725b3f6"
        )

        binding.llAddressIssue.setOnClickListener {
            ContactoClient.getInstance().loadChat(this, config)
        }
        binding.llOrderIssue.setOnClickListener {
            ContactoClient.getInstance().loadChat(this, config)
        }
        binding.llPaymentIssue.setOnClickListener {
            ContactoClient.getInstance().loadChat(this, config)
        }
        binding.btnChat.setOnClickListener {
            ContactoClient.getInstance().loadChat(this, config)
        }
    }
}