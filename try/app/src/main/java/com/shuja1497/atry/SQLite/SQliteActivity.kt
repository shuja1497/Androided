package com.shuja1497.atry.SQLite

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.shuja1497.atry.R

import kotlinx.android.synthetic.main.activity_sqlite.*
import kotlinx.android.synthetic.main.content_sqlite.*
import org.jetbrains.anko.db.*

class SQliteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite)
    }

    @SuppressLint("SetTextI18n")
    public fun onClick(v: View){

        when(v.id){
            R.id.button_add_user->{
                val db = database.writableDatabase
                database.use {
                    insert("users",
                            "userid" to edittext_userid.text.toString(),
                            "name" to edittext_name.text.toString(),
                            "age" to edittext_age.text.toString()
                    )
                }
            }

            R.id.button_delete_user->{
                database.use {
                    delete("users",
                            whereClause = "userid="+edittext_userid.text.toString())
                }
            }

            R.id.button_show_all->{
                val users = database.use {
                    select("users").exec {
//                        parser.toString()
                        parseList(classParser<User>())
                    }
                }
//                textview_result.text = users.toString()

                var str = ""
                users.forEach {
                    str += "userId="+it.userid +"  "+"name="+it.name+"  "+
                            "age="+it.age+"\n"
                }

                textview_result.text = str
            }

            else->{}
        }

    }
}
