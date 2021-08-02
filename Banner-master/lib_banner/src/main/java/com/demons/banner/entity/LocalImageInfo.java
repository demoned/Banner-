package com.demons.banner.entity;


import androidx.annotation.DrawableRes;

/**
 * 本地资源图片
 */
public class LocalImageInfo extends SimpleBannerInfo {

    @DrawableRes
    private int bannerRes;

    public LocalImageInfo(int bannerRes) {
        this.bannerRes = bannerRes;
    }

    @Override
    public Integer getXBannerUrl() {
        return bannerRes;
    }
}
