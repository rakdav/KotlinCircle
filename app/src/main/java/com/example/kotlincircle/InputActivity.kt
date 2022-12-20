package com.example.kotlincircle

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton

class InputActivity : AppCompatActivity() {
    private lateinit var sizeX: EditText
    private lateinit var sizeY:EditText
    private lateinit var radius:EditText
    private lateinit var red: RadioButton
    private lateinit var green:RadioButton
    private lateinit var blue:RadioButton
    private lateinit var okButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)
        sizeX=findViewById(R.id.sizeX)
        sizeY=findViewById(R.id.sizeY)
        radius=findViewById(R.id.radius);
        red=findViewById(R.id.red)
        green=findViewById(R.id.green)
        blue=findViewById(R.id.blue)
        okButton=findViewById(R.id.OK)
        okButton.setOnClickListener {
            val intent: Intent = Intent()
            intent.putExtra("X", sizeX.text.toString().toFloat())
            intent.putExtra("Y", sizeY.text.toString().toFloat())
            intent.putExtra("R", radius.text.toString().toFloat())
            if (red.isChecked)
                intent.putExtra("COLOR", Color.RED)
            if (green.isChecked)
                intent.putExtra("COLOR", Color.GREEN)
            if (blue.isChecked)
                intent.putExtra("COLOR", Color.BLUE)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}