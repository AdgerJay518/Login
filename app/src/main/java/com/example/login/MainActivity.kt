package com.example.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onClick(view: View) {
        if (view.id == R.id.bt_main_SharedPreferences) {
            startActivity(Intent(this, loginActivity::class.java))
        }
        if (view.id == R.id.bt_main_Inner) {
            startActivity(Intent(this, InnerActivity::class.java))
        }
        if (view.id == R.id.bt_main_external) {
            startActivity(Intent(this, ExternelActivity::class.java))
        }
        if (view.id == R.id.bt_main_DB) {
            startActivity(Intent(this, DBActivity::class.java))
        }
    }

}

