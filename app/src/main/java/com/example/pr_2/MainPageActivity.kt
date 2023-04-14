package com.example.pr_2

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainPageActivity : AppCompatActivity() {

    var modalBottomSheet = ModalBottomSheet()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)
    }

    fun close(view: View) {
        modalBottomSheet.dismiss()
    }

    fun modalBottomSheet(view: View) {
        modalBottomSheet.show(supportFragmentManager, ModalBottomSheet.TAG)
    }
}