package com.example.kotlincircle

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Circle(private val x:Float, private val y:Float, private val r:Float, var color:Int)
{
    public fun draw(canvas:Canvas) {
        var paint:Paint=Paint()
        paint.let {
            it.color=color
            it.style=Paint.Style.FILL
        }
        canvas.drawCircle(x,y,r,paint)
    }

}