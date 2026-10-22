package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface SysUpdateObserver {
    void init(String str);

    void updateCuid(String str);

    void updateNetworkInfo(Context context);

    void updateNetworkProxy(Context context);

    void updatePhoneInfo(String str);

    void updateZid(String str);
}
