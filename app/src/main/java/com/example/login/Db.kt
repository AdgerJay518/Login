package com.example.login

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log


class Db(context: Context?) : SQLiteOpenHelper(context, "user", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        //创建user表
        db.execSQL(
            "CREATE TABLE user(" + "_id integer primary key autoincrement,"
                    + "username text not null,"
                    + "password text not null )"
        )
        Log.d("MainActivity", "数据库创建成功")
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.d("MainActivity", "数据库升级成功")
    }

    companion object {
        private val DBAdapter: String? = null
    }
}
