package com.example.kotlincircle

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class Draw2D(context: Context?) : View(context) {
    private var mPaint: Paint? = null
    private var circle:Circle?=null
    init {
        init()
    }
    public fun initCircle(x:Float, y:Float, r:Float, color:Int)
    {
        circle= Circle(x,y,r,color)
    }
    private fun init() {
        mPaint = Paint()
        mPaint!!.setStrokeWidth(10.0f)

    }

    override fun onDraw(canvas: Canvas) {
        if(circle!=null) circle?.draw(canvas)
    }
}