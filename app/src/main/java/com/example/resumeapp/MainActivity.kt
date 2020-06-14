package com.example.resumeapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var workHistory = findViewById<Button>(R.id.workHistoryBtn)
        var callMe = findViewById<Button>(R.id.callMeBtn)
        var emailMe = findViewById<Button>(R.id.emailMeBtn)

        workHistory.setOnClickListener(this)
        callMe.setOnClickListener(this)
        emailMe.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            when (v.id){
                R.id.workHistoryBtn -> showWorkHistory()
                R.id.callMeBtn -> startCall()
                R.id.emailMeBtn -> sendEmail()
            }
        }

    private fun showWorkHistory(){
        var moveToWorkHistory = Intent(applicationContext, WorkHistory::class.java)
        startActivity(moveToWorkHistory)
    }

    private fun sendEmail(){
        var emailIntent = Intent(Intent.ACTION_SEND)
        emailIntent.type = "plain/text"
        emailIntent.putExtra(Intent.EXTRA_EMAIL, "test@email.com")
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Nice Resume")
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Testerson")

        startActivity(emailIntent)
    }

    private fun startCall(){
        var phoneUri = Uri.parse("tel:07000000000")
        var callIntent = Intent(Intent.ACTION_DIAL, phoneUri)
        startActivity(callIntent)
    }
}





