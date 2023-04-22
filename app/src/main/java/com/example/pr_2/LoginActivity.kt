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
    // переменные будет инициализированы позже
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var btn:Button
    // паттерн для почты
    val pattern = ("[a-zA-Z0-9]{1,100}"+"@"+"[a-z]{1,10}"+"\\."+"[a-z]{1,4}")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // инициализация
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        btn = findViewById(R.id.btn)
        // вызываться при изменении текста в EditText
        email.addTextChangedListener {
            editContent()
        }
        password.addTextChangedListener {
            editContent()
        }
    }

    // функция изменения состояния кнопки
    private fun editContent(){
        if (email.text.toString().isNotEmpty() || password.text.toString().isNotEmpty())
        {
            btn.setBackgroundResource(R.drawable.btn)
            btn.isClickable = true
        }
        else
        {
            btn.setBackgroundResource(R.drawable.btn2)
            btn.isClickable = false
        }
    }

    // функция проверки почты с паттерном
    fun emailValid(text: String):Boolean
    {
        return Pattern.compile(pattern).matcher(text).matches()
    }

    // функция изменения состояния кнопки
    fun login(view: View) {
        if (email.text.toString().isNotEmpty()) {
            if (password.text.toString().isNotEmpty()) {
                if (emailValid(email.text.toString())) {

                    // переход на следующий экран
                    val intent = Intent(this, MainPageActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {

                    // всплывающие сообщения
                    Toast.makeText(this, "Поле e-mail некорректно заполнено", Toast.LENGTH_SHORT).show()
                }
            } else{

                // всплывающие сообщения
                Toast.makeText(this, "Поле password пустое", Toast.LENGTH_SHORT).show()
            }
        } else {

            // всплывающие сообщения
            Toast.makeText(this, "Поле e-mail пустое", Toast.LENGTH_SHORT).show()
        }
    }
}


