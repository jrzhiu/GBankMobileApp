package com.example.gbank

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val chkMovement1 = findViewById<CheckBox>(R.id.chkMovement1) as CheckBox
        val chkMovement2 = findViewById<CheckBox>(R.id.chkMovement2) as CheckBox
        val chkMovement3 = findViewById<CheckBox>(R.id.chkMovement3) as CheckBox
        val butStartChat = findViewById<Button>(R.id.butStartChat) as Button
        butStartChat.setOnClickListener{
            //if (chkMovement1.isChecked ==true && chkMovement2.isChecked ==true)
            //{
            val Intent = Intent(this,ChatActivity::class.java)
            startActivity(Intent)
            //Toast.makeText(baseContext, "Seleccionado 1", Toast.LENGTH_LONG).show()
            //}
        }
    }
}