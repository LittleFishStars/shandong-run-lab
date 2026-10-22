package com.beizi.fusion;

import com.alibaba.ariver.kernel.common.network.NetworkUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public enum v6 {
    CONNECT_TYPE_UNKNOWN(0, "unknown"),
    CONNECT_TYPE_WIFI(1, "wifi"),
    CONNECT_TYPE_2G(2, NetworkUtil.NETWORK_TYPE_2G),
    CONNECT_TYPE_3G(3, NetworkUtil.NETWORK_TYPE_3G),
    CONNECT_TYPE_4G(4, NetworkUtil.NETWORK_TYPE_4G),
    CONNECT_TYPE_5G(5, "5G");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f27859a;
    private final String b;

    v6(int i2, String str) {
        this.f27859a = i2;
        this.b = str;
    }

    public int b() {
        return this.f27859a;
    }
}
