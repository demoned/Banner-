package com.demons.banner_master;

import com.demons.banner.entity.BaseBannerInfo;

/**
 * 动画banner实体
 */
public class BannerInfoBean implements BaseBannerInfo {
    private int gitId;
    private String title;

    public BannerInfoBean(int gitId, String title) {
        this.gitId = gitId;
        this.title = title;
    }

    public int getGitId() {
        return gitId;
    }

    public void setGitId(int gitId) {
        this.gitId = gitId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BannerInfoBean{" +
                "gitId=" + gitId +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public Object getXBannerUrl() {
        return null;
    }

    @Override
    public String getXBannerTitle() {
        return null;
    }
}
