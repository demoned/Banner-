package com.zhpan.indicator.drawer

import com.demons.banner.IDrawer
import com.demons.banner.IndicatorOptions
import com.demons.banner.annotation.IndicatorStyle


internal object DrawerFactory {
  fun createDrawer(indicatorOptions: IndicatorOptions): IDrawer {
    return when (indicatorOptions.indicatorStyle) {
        IndicatorStyle.DASH -> DashDrawer(indicatorOptions)
        IndicatorStyle.ROUND_RECT -> RoundRectDrawer(indicatorOptions)
      else -> CircleDrawer(indicatorOptions)
    }
  }
}
