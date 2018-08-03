package com.example.mikhno_ua.p0062_activity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_hw3_second_screen.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "First screen"

        buttonToFirstScreen.setOnClickListener { view ->
            val intent = Intent(this, HW3SecondScreenActivity::class.java)
            intent.putExtra("textFromFirstScreen", editTextFirstScreen.text.toString())
            startActivityForResult(intent, 123)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == 123 && resultCode == Activity.RESULT_OK){
            editTextFirstScreen.setText(data?.getStringExtra("textFromUnknownScreen"))
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

}
