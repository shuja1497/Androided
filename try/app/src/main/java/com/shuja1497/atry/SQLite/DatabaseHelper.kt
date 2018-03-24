package com.shuja1497.atry.SQLite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.provider.ContactsContract
import org.jetbrains.anko.db.*

/**
 * Created by shuja1497 on 3/20/18.
 */
class DatabaseHelper(ctx: Context) :
        ManagedSQLiteOpenHelper(ctx, "MyDatabse", null, 1) {

    companion object {
        private var instance: DatabaseHelper? = null

        fun Instance(context: Context): DatabaseHelper{
            if (instance==null){
                instance = DatabaseHelper(context.applicationContext)
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable("users", true,
                "userid" to INTEGER + PRIMARY_KEY,
                "name" to TEXT,
                "age" to INTEGER)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}

// Access property for Context
val Context.database: DatabaseHelper
    get() = DatabaseHelper.Instance(applicationContext)