package com.example.pr_2

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import java.util.regex.Pattern


class LoginActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var btn:Button


    val pattern = ("[a-z]{1,100}"+"@"+"[a-z]{1,6}"+"\\."+"[a-z]{1,5}")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // элемент Spinner
        val spinner = findViewById<Spinner>(R.id.spinner)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        btn = findViewById(R.id.btn)


        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>, view: View?, pos: Int,
                id: Long
            ) {
                (parent.getChildAt(0) as TextView).setTextColor(Color.WHITE)
                //(parent.getChildAt(0) as TextView).textSize = 15f

            }

            override fun onNothingSelected(arg0: AdapterView<*>?) {}
        }


        email.addTextChangedListener {
            editContent()
        }
        password.addTextChangedListener {
            editContent()
        }
    }

    private fun editContent(){
        if (email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty())
        {
            btn.setBackgroundResource(R.color.blue)
            btn.isClickable = true
        }
        else
        {
            btn.setBackgroundResource(R.color.blue2)
            btn.isClickable = false
        }
    }

    fun emailValid(text: String):Boolean
    {
        return Pattern.compile(pattern).matcher(text).matches()
    }
    fun login(view: View) {
        if (emailValid(email.text.toString()))
        {
            Toast.makeText(this, "Вход", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,MainPageActivity::class.java)
            startActivity(intent)
            finish()
        }
        else
        {
            Toast.makeText(this, "Поле E-mail некорректно заполнено", Toast.LENGTH_SHORT).show()
        }
    }
}

