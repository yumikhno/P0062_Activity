package com.example.mikhno_ua.p0062_activity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_hw3_second_screen.*
import kotlinx.android.synthetic.main.activity_hw3_third_screen.*
import kotlinx.android.synthetic.main.activity_main.*

class HW3SecondScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw3_second_screen)

        supportActionBar?.title = "Second screen"
        val textFromFirstScreen = intent.getStringExtra("textFromFirstScreen")

        textViewFromFirstScreen.setText(textFromFirstScreen)
        buttonToThirdScreen.setOnClickListener({view ->
            val intent = Intent(this, HW3ThirdScreenActivity::class.java)
            intent.putExtra("textFromFirstScreen", textFromFirstScreen)
            startActivityForResult(intent, 234)
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == 234 && resultCode == Activity.RESULT_OK){
            labelTextViewFromThirdScreen.visibility = View.VISIBLE
            textViewFromThirdScreen.visibility = View.VISIBLE
            textViewFromThirdScreen.setText(data?.getStringExtra("textFromThirdScreen"))
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun onBackPressed() {
        val intent = Intent()
        if(textViewFromThirdScreen.visibility != View.GONE) {
            intent.putExtra("textFromUnknownScreen", textViewFromThirdScreen.text)
        } else {
            intent.putExtra("textFromUnknownScreen", textViewFromFirstScreen.text)
        }
        setResult(Activity.RESULT_OK, intent)
        finish()
        //Почему обращение к конструктору должно происходить в конце? Иначе попросту не работат.
        super.onBackPressed()
    }
}
