package com.hailiang.advlib.core;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public interface IQLocation {
    public static final int TYPE_BAIDU = 2;
    public static final int TYPE_CGJ02 = 0;
    public static final int TYPE_WGS84 = 1;

    double getLatitude();

    double getLongitude();

    int getType();
}
