package com.example.login

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.*

class InnerActivity: AppCompatActivity() {
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
        val file = File(cacheDir, "info.txt")
        //如果本地存在info.txt
        if (file.exists()) {
            try {
                //创建文件输入流对象
                val fis = FileInputStream(file)
                //把字节流转换成字符流
                val br = BufferedReader(InputStreamReader(fis))
                //读取txt文件里的用户名和密码
                val text: String = br.readLine()
                //使用字符串分割函数分割用户名和密码
                val s = text.split("##").toTypedArray()
                //将用户名和密码设置到用户名和密码的输入框中
                et_username!!.setText(s[0])
                et_password!!.setText(s[1])
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    //登录
    fun onClick(v: View?) {
        //获得输入框中的用户名和密码
        val name = et_username!!.text.toString()
        val pass = et_password!!.text.toString()
            //创建File对象
            //第一个参数：文件的路径
            //第二个参数：文件名
        val file = File(cacheDir, "info.txt")
        try {
            val fos = FileOutputStream(file)
            //将用户名和密码以字节数组的形式写入文件中
            fos.write("$name##$pass".toByteArray())
            //关闭文件输出流
            fos.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show()
        }
    }

