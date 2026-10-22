package com.alibaba.ariver.app.api.ui.tabbar.model;

import androidx.annotation.ColorInt;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class TabBarBadgeModel {

    @ColorInt
    private int badgeColor;
    private int badgeSize;

    @Nullable
    private String badgeText;

    public int getBadgeColor() {
        return this.badgeColor;
    }

    public int getBadgeSize() {
        return this.badgeSize;
    }

    @Nullable
    public String getBadgeText() {
        return this.badgeText;
    }

    public void setBadgeColor(@ColorInt int i) {
        this.badgeColor = i;
    }

    public void setBadgeSize(int i) {
        this.badgeSize = i;
    }

    public void setBadgeText(@Nullable String str) {
        this.badgeText = str;
    }
}
