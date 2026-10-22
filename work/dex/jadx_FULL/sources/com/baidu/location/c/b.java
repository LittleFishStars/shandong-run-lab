package com.baidu.location.c;

import com.alibaba.ariver.kernel.common.network.NetworkUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class b {
    public static String a(int i) {
        if (f.a().l()) {
            return NetworkUtil.NETWORK_TYPE_WIFI;
        }
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return NetworkUtil.NETWORK_TYPE_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return NetworkUtil.NETWORK_TYPE_3G;
            case 13:
                return NetworkUtil.NETWORK_TYPE_4G;
            default:
                return "unknown";
        }
    }
}
