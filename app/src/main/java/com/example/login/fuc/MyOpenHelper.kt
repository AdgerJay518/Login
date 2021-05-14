package com.example.login.fuc

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

//创建一个抽象类SQLiteOpenHelper的实现类MyOpenHelper
class MyOpenHelper
/**
 * MyOpenHelper构造方法
 *
 * @param context 上下文
 * @param name    数据库文件的名字
 * @param factory 游标工厂(结果集)
 * @param version 数据库的版本号(用于升级)
 */
    (context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) :
    SQLiteOpenHelper(context, name, factory, version) {
    //创建数据库时,调用此方法
    override fun onCreate(db: SQLiteDatabase) {

        //创建一个学生表
        db.execSQL("create table user(_id integer primary key autoincrement, username char(10), password char(10))")
    }

    //数据库升级时调用此方法
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.d("MainActivity", "数据库升级成功")
    }
}
