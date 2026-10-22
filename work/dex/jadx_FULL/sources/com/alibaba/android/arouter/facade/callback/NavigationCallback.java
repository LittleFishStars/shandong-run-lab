package com.alibaba.android.arouter.facade.callback;

import com.alibaba.android.arouter.facade.Postcard;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface NavigationCallback {
    void onArrival(Postcard postcard);

    void onFound(Postcard postcard);

    void onInterrupt(Postcard postcard);

    void onLost(Postcard postcard);
}
