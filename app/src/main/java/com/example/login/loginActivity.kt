package com.example.login

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class loginActivity: AppCompatActivity(), View.OnClickListener {
    private var et_username: EditText? = null
    private var et_password: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        et_username = findViewById<EditText>(R.id.et_loginactivity_username)
        et_password = findViewById<EditText>(R.id.et_loginactivity_password)
        //读取保存在本地的用户名和密码
        readAccount()
    }

    //读取保存在本地的用户名和密码
    fun readAccount() {
        //创建SharedPreferences对象
        val sp: SharedPreferences = getSharedPreferences("info", MODE_PRIVATE)
        //获得保存在SharedPredPreferences中的用户名和密码
        val username: String? = sp.getString("username", "")
        val password: String? = sp.getString("password", "")
        //在用户名和密码的输入框中显示用户名和密码
        et_username?.setText(username);
        et_password?.setText(password);
    }
    override fun onClick(v: View) {
        //获得用户输入的用户名和密码
        val username = et_username!!.text.toString()
        val password = et_password!!.text.toString()
        //创建sharedPreference对象，info表示文件名，MODE_PRIVATE表示访问权限为私有的
        val sp: SharedPreferences = getSharedPreferences("info", MODE_PRIVATE)
        val ed: SharedPreferences.Editor = sp.edit()
        //以键值对的显示将用户名和密码保存到sp中
        ed.putString("username", username)
        ed.putString("password", password)
        //提交用户名和密码
        ed.commit()
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show()
    }

}
