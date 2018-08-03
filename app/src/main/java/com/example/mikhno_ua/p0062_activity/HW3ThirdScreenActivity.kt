package com.example.mikhno_ua.p0062_activity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_hw3_third_screen.*
import javax.xml.transform.Result

class HW3ThirdScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw3_third_screen)

        supportActionBar?.title = "Third screen"
        editTextThirdScreen.setText(intent.getStringExtra("textFromFirstScreen"))
    }

    override fun onBackPressed() {

        val intent = Intent()
        intent.putExtra("textFromThirdScreen", editTextThirdScreen.text.toString())
        setResult(Activity.RESULT_OK, intent)
        finish()
        //Почему обращение к конструктору должно происходить в конце? Иначе попросту не работат.
        super.onBackPressed()
    }
}
