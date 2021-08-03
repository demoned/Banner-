package com.demons.banner.annotation;

import android.view.View;

import androidx.annotation.IntDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@IntDef({ View.VISIBLE, View.INVISIBLE, View.GONE })
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.PARAMETER)
public @interface Visibility {

}
