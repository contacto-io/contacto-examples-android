package com.contacto.consumer.android.example.initatechat.activity

import android.content.Intent
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.contacto.consumer.android.example.initatechat.R
import com.contacto.consumer.android.example.initatechat.databinding.ActivityMainBinding
import com.contacto.consumer.android.example.initatechat.fragments.OrdersFragment
import com.contacto.consumer.android.example.initatechat.fragments.SettingsFragment
import com.contacto.consumer.android.utility.Constants
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
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
        binding.actionBar.tvTitle.text = "Home"
        binding.actionBar.chat.setOnClickListener {
            startActivity(Intent(this, ChatActivity::class.java))
        }
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    binding.actionBar.chat.visibility = GONE
                    binding.actionBar.tvTitle.text = "Home"
                    setCurrentFragment(Fragment())
                }
                R.id.category -> {
                    binding.actionBar.chat.visibility = GONE
                    binding.actionBar.tvTitle.text = "Category"
                    setCurrentFragment(Fragment())
                }
                R.id.buy -> {
                    binding.actionBar.chat.visibility = GONE
                    binding.actionBar.tvTitle.text = "My Orders"
                    setCurrentFragment(OrdersFragment())
                }
                R.id.settings -> {
                    binding.actionBar.tvTitle.text = "Profile"
                    binding.actionBar.chat.visibility = VISIBLE
                    setCurrentFragment(SettingsFragment())
                }
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            commit()
        }
}