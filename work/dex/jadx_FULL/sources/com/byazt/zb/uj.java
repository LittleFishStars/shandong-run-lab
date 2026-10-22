package com.byazt.zb;

import com.efs.sdk.base.core.util.NetworkUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public enum uj {
    TYPE_2G("2g"),
    TYPE_3G("3g"),
    TYPE_4G("4g"),
    TYPE_5G(NetworkUtil.NETWORK_CLASS_5G),
    TYPE_WIFI("wifi"),
    TYPE_MOBILE("mobile"),
    TYPE_UNKNOWN("unknown");

    public String x;

    uj(String str) {
        this.x = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.x;
    }
}
