package com.demons.banner;

import static com.demons.banner.Banner.MAX_VALUE;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import androidx.annotation.DrawableRes;
import androidx.core.view.ViewCompat;

import java.util.List;

/**
 *  XBanner轮播控件的工具类
 */
public class BannerUtils {

    /**
     * 设置背景选择器
     *
     * @param pressedDraw
     * @param normalDraw
     * @return
     */
    public static StateListDrawable getSelector(Drawable normalDraw, Drawable pressedDraw) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled}, pressedDraw);
        stateListDrawable.addState(new int[]{}, normalDraw);
        return stateListDrawable;
    }

    public static Drawable getDrawable(Context context, @DrawableRes int resId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return context.getDrawable(resId);
        } else {
            return context.getResources().getDrawable(resId);
        }
    }

    public static int dp2px(Context context, float dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, context.getResources().getDisplayMetrics());
    }

    public static int sp2px(Context context, float spValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spValue, context.getResources().getDisplayMetrics());
    }

    public static int getScreenWidth(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static void resetPageTransformer(List<? extends View> views) {
        if (views == null) {
            return;
        }
        for (View view : views) {
            view.setVisibility(View.VISIBLE);
            ViewCompat.setAlpha(view, 1);
            ViewCompat.setPivotX(view, view.getMeasuredWidth() * 0.5f);
            ViewCompat.setPivotY(view, view.getMeasuredHeight() * 0.5f);
            ViewCompat.setTranslationX(view, 0);
            ViewCompat.setTranslationY(view, 0);
            ViewCompat.setScaleX(view, 1);
            ViewCompat.setScaleY(view, 1);
            ViewCompat.setRotationX(view, 0);
            ViewCompat.setRotationY(view, 0);
            ViewCompat.setRotation(view, 0);
        }
    }

    private static boolean debugMode = false;

    private static final String TAG = "BVP";

    public static void setDebugMode(boolean isDebug) {
        debugMode = isDebug;
    }

    public static boolean isDebugMode() {
        return debugMode;
    }

    public static int dp2px(float dpValue) {
        return (int) (0.5F + dpValue * Resources.getSystem().getDisplayMetrics().density);
    }

    public static void log(String tag, String msg) {
        if (isDebugMode()) {
            Log.e(tag, msg);
        }
    }

    public static void log(String msg) {
        if (isDebugMode()) {
            log(TAG, msg);
        }
    }

    /**
     * 在循环模式下{@link BannerViewPager2}会初始化一个item为
     * {@link BaseBannerAdapter#MAX_VALUE}的ViewPager2,并将当前position设置为ViewPager2
     * 的中间位置，因此，此时的position需要通过该方法进行转换为真实的position。
     *
     * @param position  当前position
     * @param pageSize  轮播图页面数
     * @return 真实的position
     */
    public static int getRealPosition(int position, int pageSize) {
        if (pageSize == 0) {
            return 0;
        }
        return (position + pageSize) % pageSize;
    }

    /**
     * @param pageSize 轮播图页面数
     * @return 轮播图初始位置
     */
    public static int getOriginalPosition(int pageSize) {
        return MAX_VALUE / 2 - ((MAX_VALUE / 2) % pageSize);
    }
}
