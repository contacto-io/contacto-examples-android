package com.contacto.consumer.android.example.initatechat.activity

import android.content.Intent
import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.contacto.consumer.android.ContactoClient
import com.contacto.consumer.android.example.base.ICommon
import com.contacto.consumer.android.example.initatechat.databinding.ActivityCustomerSupportBinding
import com.contacto.consumer.android.ui.model.User
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
        binding.llAddressIssue.setOnClickListener {
            loadChat()
        }
        binding.llOrderIssue.setOnClickListener {
            loadChat()
        }
        binding.llPaymentIssue.setOnClickListener {
            loadChat()
        }
        binding.btnChat.setOnClickListener {
            loadChat()
        }
    }

    private fun loadChat() {
        val fName = (application as ICommon).getFirstName() ?: "Alex"
        val lName = (application as ICommon).getLastName() ?: "Nikiforov"
        val email = (application as ICommon).getEmail() ?: "alex@example.com"
        val phone = (application as ICommon).getPhone() ?: "9980965754"

        val appId = (application as ICommon).getAppId() ?: ""
        val appKey = (application as ICommon).getAppKey() ?: ""
        if(appId.isEmpty() || appKey.isEmpty()) {
            Toast.makeText(this, "Please provide AppId and AppKey", Toast.LENGTH_LONG).show()
            return
        }

        val user = User(
            firstName = fName,
            lastName = lName,
            phoneNumber = phone,
            email = email
        )

        ContactoClient.init(appId = appId, appKey = appKey)
        ContactoClient.loadChat(this, user)
    }
}