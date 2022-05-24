package com.contacto.consumer.android.example.initatechat.activity

import android.content.Intent
import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.contacto.consumer.android.ContactoClient
import com.contacto.consumer.android.example.base.ICommon
import com.contacto.consumer.android.example.initatechat.databinding.ActivityCustomerSupportBinding
import com.contacto.consumer.android.ui.model.Config
import com.contacto.consumer.android.ui.model.ContactoConfig
import com.contacto.consumer.android.ui.model.ContactoUser
import com.contacto.consumer.android.utility.Constants
import com.google.android.material.snackbar.Snackbar

class CustomerServiceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomerSupportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomerSupportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Constants.ERROR_CODE) {
            val error = data?.getStringExtra(Constants.PARAM_ERROR)
            Snackbar.make(binding.root, error ?: "Something went wrong!", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun initUI() {
        binding.actionBar1.backAction.visibility = VISIBLE
        binding.actionBar1.backAction.setOnClickListener {
            finish()
        }

        binding.actionBar1.tvTitle.text = "Customer Service"
        val user = ContactoUser(
            mobile = "918050574001",
            email = "abcdef@gmail.com"
        )
        val config = Config(
            appId = (application as ICommon).getAppId() ?: "",
            appKey = (application as ICommon).getAppKey() ?: ""
        )

        val contactoConfig = ContactoConfig(
            config = config
        )

        binding.llAddressIssue.setOnClickListener {
            loadChat(contactoConfig)
        }
        binding.llOrderIssue.setOnClickListener {
            loadChat(contactoConfig)
        }
        binding.llPaymentIssue.setOnClickListener {
            loadChat(contactoConfig)
        }
        binding.btnChat.setOnClickListener {
            loadChat(contactoConfig)
        }
    }

    private fun loadChat(config: ContactoConfig) {
        val appId = (application as ICommon).getAppId() ?: ""
        val appKey = (application as ICommon).getAppKey() ?: ""
        if(appId.isEmpty() || appKey.isEmpty()) {
            Toast.makeText(this, "Please provide AppId and AppKey", Toast.LENGTH_LONG).show()
            return
        }
        ContactoClient.getInstance().loadChat(this, config)
    }
}