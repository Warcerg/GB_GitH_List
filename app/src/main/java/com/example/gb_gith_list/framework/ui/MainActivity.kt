package com.example.gb_gith_list.framework.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gb_gith_list.R
import com.example.gb_gith_list.framework.ui.users.UsersFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, UsersFragment.newInstance())
                .commitNow()
        }
    }
}