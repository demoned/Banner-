package com.demons.banner.annotation

import androidx.annotation.IntDef
import com.demons.banner.annotation.IndicatorSlideMode.Companion.COLOR
import com.demons.banner.annotation.IndicatorSlideMode.Companion.NORMAL
import com.demons.banner.annotation.IndicatorSlideMode.Companion.SCALE
import com.demons.banner.annotation.IndicatorSlideMode.Companion.SMOOTH
import com.demons.banner.annotation.IndicatorSlideMode.Companion.WORM

@IntDef(NORMAL, SMOOTH, WORM, COLOR, SCALE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD)
annotation class AIndicatorSlideMode
