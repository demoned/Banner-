package com.demons.banner.annotation;


import static com.demons.banner.constants.IndicatorGravity.CENTER;
import static com.demons.banner.constants.IndicatorGravity.END;
import static com.demons.banner.constants.IndicatorGravity.START;

import androidx.annotation.IntDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@IntDef({ CENTER, START, END })
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.PARAMETER)
public @interface AIndicatorGravity {

}
