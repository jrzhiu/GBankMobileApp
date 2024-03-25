package com.example.gbank

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.gbank.databinding.ActivityLoginBinding
import com.genesys.cloud.core.utils.visibility

class LoginActivity : AppCompatActivity() {

    lateinit var b1: Button
    lateinit var b2: Button
    lateinit var ed1: EditText
    lateinit var ed2: EditText
    lateinit var tx1: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        b1 = findViewById(R.id.butLogin) as Button
        ed1 = findViewById(R.id.editText) as EditText
        ed2 = findViewById(R.id.editText2) as EditText

        b2 = findViewById(R.id.butCancel) as Button
        tx1 = findViewById(R.id.textView) as TextView

        b1.setOnClickListener {

            val Intent = Intent(this,MainActivity::class.java)
            startActivity(Intent)

        }
        b2.setOnClickListener {
            finish()
        }
    }


}