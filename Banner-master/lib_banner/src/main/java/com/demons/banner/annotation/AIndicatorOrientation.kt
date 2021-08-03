package com.demons.banner.annotation

import androidx.annotation.IntDef

@IntDef(
  IndicatorOrientation.INDICATOR_HORIZONTAL, IndicatorOrientation.INDICATOR_VERTICAL,
  IndicatorOrientation.INDICATOR_RTL
)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD)
annotation class AIndicatorOrientation()
