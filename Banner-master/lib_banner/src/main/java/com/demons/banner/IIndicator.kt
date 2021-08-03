package com.demons.banner

import androidx.viewpager.widget.ViewPager


interface IIndicator : ViewPager.OnPageChangeListener {

  fun notifyDataChanged()

  fun setIndicatorOptions(options: IndicatorOptions)
}
