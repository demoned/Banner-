package com.demons.banner_master;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.demons.banner.Banner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Banner mBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBanner = findViewById(R.id.banner);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, getScreenWidth(this) / 2);
        mBanner.setLayoutParams(layoutParams);
        initBanner(mBanner);

        ArrayList<BannerInfoBean> bannerInfoBeans = new ArrayList<>();
        bannerInfoBeans.add(new BannerInfoBean(R.mipmap.guide_mouse, "1.鼠标模式"));
        bannerInfoBeans.add(new BannerInfoBean(R.mipmap.guide_touch_screen, "2.触屏模式"));
        bannerInfoBeans.add(new BannerInfoBean(R.mipmap.guide_call_out_keyboard, "3.三指点击呼出打字键盘"));
        bannerInfoBeans.add(new BannerInfoBean(R.mipmap.guide_right_click_to_call_out, "4.二指点击触发鼠标右键"));
        bannerInfoBeans.add(new BannerInfoBean(R.mipmap.guide_verification_code, "5.长按拖动滑块验证"));
        mBanner.setAutoPlayAble(bannerInfoBeans.size() > 1);
        mBanner.setIsClipChildrenMode(true);
        mBanner.setBannerData(R.layout.item_image, bannerInfoBeans);
    }

    /**
     * 初始化XBanner
     */
    private void initBanner(Banner banner) {
        //设置广告图片点击事件
        banner.setOnItemClickListener(new Banner.OnItemClickListener() {
            @Override
            public void onItemClick(Banner banner, Object model, View view, int position) {
                Log.i(TAG, "click pos:" + position);
            }
        });
        //加载广告图片
        banner.loadImage(new Banner.XBannerAdapter() {
            @Override
            public void loadBanner(Banner banner, Object model, View view, int position) {
                BannerInfoBean bannerInfoBean = (BannerInfoBean) model;
                GuideManager.getInstance().load(MainActivity.this, bannerInfoBean.getGitId(), (ImageView) view);
            }
        });
        banner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                Log.i("onPageSelected===>", i + "");
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    public int getScreenWidth(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        display.getMetrics(dm);
        return dm.widthPixels;
    }
}