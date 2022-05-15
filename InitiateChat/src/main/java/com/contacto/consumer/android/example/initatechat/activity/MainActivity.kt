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
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    setCurrentFragment(Fragment())
                }
                R.id.category -> {
                    setCurrentFragment(Fragment())
                }
                R.id.buy -> {
                    setCurrentFragment(OrdersFragment())
                }
                R.id.settings -> {
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