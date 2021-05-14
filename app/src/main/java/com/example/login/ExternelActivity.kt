package com.example.login

import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.*


class ExternelActivity: AppCompatActivity() {
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

    //读取保存在SD卡中的用户名和密码
    fun readAccount() {
        //如果SD卡的状态为正常挂载状态
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            //创建File对象
            //参数为用户名和密码的储存路径
            val file = File("sdcard/info.txt")
            var fis: FileInputStream? = null
            //如果SD卡中存在info.txt
            if (file.exists()) {
                //捕获文件操作中可能出现的异常
                try {
                    //创建文件输入流
                    fis = FileInputStream(file)
                    //把字节流转换成字符流
                    val br = BufferedReader(InputStreamReader(fis))
                    //读取txt文件里的用户名和密码
                    val text: String = br.readLine()
                    //使用字符串分割函数将用户名和密码分开
                    val s = text.split("##").toTypedArray()
                    //将用户名和密码设置到输入框
                    et_username!!.setText(s[0])
                    et_password!!.setText(s[1])
                    //处理文件操作中产生的异常
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    //登录
    fun onClick(v: View?) {
        //获得用户输入的用户名和密码
        val name = et_username!!.text.toString()
        val pass = et_password!!.text.toString()
        //如果SD卡的状态为已经挂载状态
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            val file = File(getExternalFilesDir(null), "info.txt")
            var fos: FileOutputStream? = null
            try {
                fos = FileOutputStream(file)
                fos.write("$name##$pass".toByteArray())
                fos.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {
            Toast.makeText(this, "sd卡不可用", Toast.LENGTH_SHORT).show()
        }
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show()
    }
}
