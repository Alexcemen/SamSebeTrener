package com.example.samsebetrener

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.samsebetrener.utils.initialActivity

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialActivity(R.layout.activity_auth, R.id.main)

        val linkToReg: TextView = findViewById(R.id.link_to_reg)
        val userLogin: EditText = findViewById(R.id.user_login_auth)
        val userPass: EditText = findViewById(R.id.user_pass_auth)
        val button: Button = findViewById(R.id.button_auth)

        linkToReg.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if (login == "" || pass == "")
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            else {
                val db = DbHelper(this, null)
                if (db.getUser(login = login, pass = pass)) {
                    userLogin.text.clear()
                    userPass.text.clear()
                    val intent = Intent(this, MenuActivity::class.java)
                    startActivity(intent)

                } else {
                    Toast.makeText(this, "Такого логина или пароля нет", Toast.LENGTH_LONG).show()
                }
                db.close()
            }
        }
    }
}