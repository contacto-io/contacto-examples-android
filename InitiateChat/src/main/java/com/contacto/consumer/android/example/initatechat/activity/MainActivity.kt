package com.contacto.consumer.android.example.initatechat.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.contacto.consumer.android.example.initatechat.R
import com.contacto.consumer.android.example.initatechat.databinding.ActivityMainBinding
import com.contacto.consumer.android.example.initatechat.fragments.OrdersFragment
import com.contacto.consumer.android.example.initatechat.fragments.SettingsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI() {
        binding.actionBar.tvTitle.text = "Home"
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    binding.actionBar.tvTitle.text = "Home"
                    setCurrentFragment(Fragment())
                }
                R.id.category -> {
                    binding.actionBar.tvTitle.text = "Category"
                    setCurrentFragment(Fragment())
                }
                R.id.buy -> {
                    binding.actionBar.tvTitle.text = "My Orders"
                    setCurrentFragment(OrdersFragment())
                }
                R.id.settings -> {
                    binding.actionBar.tvTitle.text = "Profile"
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