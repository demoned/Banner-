package com.demons.banner

import android.graphics.Canvas
import com.zhpan.indicator.drawer.BaseDrawer

interface IDrawer {

  fun onLayout(
      changed: Boolean,
      left: Int,
      top: Int,
      right: Int,
      bottom: Int
  )

  fun onMeasure(
      widthMeasureSpec: Int,
      heightMeasureSpec: Int
  ): BaseDrawer.MeasureResult

  fun onDraw(canvas: Canvas)
}
