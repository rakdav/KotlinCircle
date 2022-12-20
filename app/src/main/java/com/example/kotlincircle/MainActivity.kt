package com.example.kotlincircle

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var draw2D:Draw2D
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        draw2D=Draw2D(this);
        setContentView(draw2D)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id:Int=item.itemId
        when(id)
        {
            R.id.action_input-> {
                var intent: Intent =Intent(this,InputActivity::class.java)
                getResult.launch(intent)
            }

            R.id.action_exit->this.finish()
        }
        return super.onOptionsItemSelected(item)
    }
    private val getResult=
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        {
            if(it.resultCode== Activity.RESULT_OK){
                var intent:Intent=it.data!!
                var x:Float=intent.getFloatExtra("X",0.0f)
                var y:Float=intent.getFloatExtra("Y",0.0f)
                var R:Float=intent.getFloatExtra("R",0.0f)
                var color:Int=intent.getIntExtra("COLOR",0)
                draw2D.initCircle(x,y,R,color)
            }
        }
}