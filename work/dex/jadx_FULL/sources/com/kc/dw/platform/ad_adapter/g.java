package com.kc.dw.platform.ad_adapter;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f39476a = 0;

    public boolean a(int i, int i2) {
        if (!(i == -1 || i == this.f39476a) || i2 <= this.f39476a) {
            return false;
        }
        this.f39476a = i2;
        return true;
    }
}
