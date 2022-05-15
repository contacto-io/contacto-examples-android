package com.contacto.consumer.android.example.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.contacto.consumer.android.ContactoClient
import com.contacto.consumer.android.example.databinding.ActivityCustomerSupportBinding
import com.contacto.consumer.android.ui.model.Config
import com.contacto.consumer.android.ui.model.ContactoConfig
import com.contacto.consumer.android.ui.model.ContactoUser

class CustomerServiceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomerSupportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomerSupportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI() {
        val user = ContactoUser(
            mobile = "918050574001",
            email = "abcdef@gmail.com"
        )
        val config = Config(
            appId = "a4ef65e8-5908-4c65-8b65-52ff7a2bf8eb",
            appKey = "665255e3914bb5060b0ba7102a8bade8d7dcf21e734093818863ac759725b3f6"
        )
        val contactoConfig = ContactoConfig(
            config = config,
            user = user
        )

        binding.llAddressIssue.setOnClickListener {
            ContactoClient.getInstance().loadChat(this, contactoConfig)
        }
        binding.llOrderIssue.setOnClickListener {
            ContactoClient.getInstance().loadChat(this, contactoConfig)
        }
        binding.llPaymentIssue.setOnClickListener {
            ContactoClient.getInstance().loadChat(this, contactoConfig)
        }
        binding.btnChat.setOnClickListener {
            ContactoClient.getInstance().loadChat(this, contactoConfig)
        }
    }
}