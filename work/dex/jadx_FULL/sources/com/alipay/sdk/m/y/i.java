package com.alipay.sdk.m.y;

import com.alibaba.ariver.kernel.common.network.NetworkUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum i {
    WIFI(0, NetworkUtil.NETWORK_TYPE_WIFI),
    NETWORK_TYPE_1(1, "unicom2G"),
    NETWORK_TYPE_2(2, "mobile2G"),
    NETWORK_TYPE_4(4, "telecom2G"),
    NETWORK_TYPE_5(5, "telecom3G"),
    NETWORK_TYPE_6(6, "telecom3G"),
    NETWORK_TYPE_12(12, "telecom3G"),
    NETWORK_TYPE_8(8, "unicom3G"),
    NETWORK_TYPE_3(3, "unicom3G"),
    NETWORK_TYPE_13(13, "LTE"),
    NETWORK_TYPE_11(11, "IDEN"),
    NETWORK_TYPE_9(9, "HSUPA"),
    NETWORK_TYPE_10(10, "HSPA"),
    NETWORK_TYPE_15(15, "HSPAP"),
    NETWORK_TYPE_20(20, "5G"),
    NONE(-1, "none");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f25531a;
    public String b;

    i(int i, String str) {
        this.f25531a = i;
        this.b = str;
    }

    public final int b() {
        return this.f25531a;
    }

    public final String c() {
        return this.b;
    }

    public static i a(int i) {
        for (i iVar : values()) {
            if (iVar.b() == i) {
                return iVar;
            }
        }
        return NONE;
    }
}
