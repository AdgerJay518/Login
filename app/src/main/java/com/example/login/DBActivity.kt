package com.example.login

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class DBActivity: AppCompatActivity()  {
    private var et_username: EditText? = null
    private var et_password: EditText? = null
    var db = Db(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        et_username = findViewById<EditText>(R.id.et_loginactivity_username)
        et_password = findViewById<EditText>(R.id.et_loginactivity_password)
        //读取保存在数据库的用户名和密码
        sqlitequery()
    }
    fun sqliteinsert() {
        val dbWrite: SQLiteDatabase = db.getReadableDatabase()
        val username = et_username!!.text.toString()
        val password = et_password!!.text.toString()
        //以键值对的形式存入数据
        val kv = ContentValues()
        kv.put("username", username)
        kv.put("password", password)
        Log.d("db", db.toString())
        dbWrite.insert("user", null, kv)
    }
    fun sqlitequery() {
        val dbRead = db.readableDatabase
        val cursor: Cursor = dbRead.query("user", null, null, null, null, null, null)
        while (cursor.moveToLast()) {
            val userid: String = cursor.getString(cursor.getColumnIndex("username"))
            val psw: String = cursor.getString(cursor.getColumnIndex("password"))
            //读出数据显示在edittext中
            Log.d("userid",userid)
            Log.d("psw",psw)
            et_username!!.setText(userid)
            et_password!!.setText(psw)
            break
        }
        cursor.close()
    }
    fun onClick(v: View?){
        sqliteinsert()
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show()
    }
}
