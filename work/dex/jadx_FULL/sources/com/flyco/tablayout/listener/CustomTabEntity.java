package com.flyco.tablayout.listener;

import androidx.annotation.DrawableRes;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface CustomTabEntity {
    @DrawableRes
    int getTabSelectedIcon();

    String getTabTitle();

    @DrawableRes
    int getTabUnselectedIcon();
}
