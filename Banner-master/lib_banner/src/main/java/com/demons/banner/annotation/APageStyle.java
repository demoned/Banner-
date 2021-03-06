package com.demons.banner.annotation;


import static com.demons.banner.constants.PageStyle.MULTI_PAGE;
import static com.demons.banner.constants.PageStyle.MULTI_PAGE_OVERLAP;
import static com.demons.banner.constants.PageStyle.MULTI_PAGE_SCALE;
import static com.demons.banner.constants.PageStyle.NORMAL;

import androidx.annotation.IntDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@IntDef({ NORMAL, MULTI_PAGE, MULTI_PAGE_OVERLAP, MULTI_PAGE_SCALE })
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.PARAMETER)
public @interface APageStyle {
}
