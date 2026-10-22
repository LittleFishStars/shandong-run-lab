package com.zj.adlib;

import androidx.annotation.NonNull;
import com.alipay.sdk.m.k0.c;
import com.aliyun.tea.logging.DefaultLogger;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class lq1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f43128a = -1;
    public static final int b = 0;

    @Deprecated
    public static final int c = 2;

    @Deprecated
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 6;
    public static final int h = 7;
    public static final int i = 8;
    public static final int j = 10;
    public static final int k = 13;
    public static final int l = 14;
    public static final int m = 15;
    public static final int n = 16;
    public static final int o = 17;
    public static final int p = 19;
    public static final int q = 20;
    public static final int r = 21;
    public static final int s = 22;

    @KeepForSdk
    public lq1() {
    }

    @NonNull
    public static String a(int i2) {
        switch (i2) {
            case -1:
                return "SUCCESS_CACHE";
            case 0:
                return c.p;
            case 1:
            case 9:
            case 11:
            case 12:
            default:
                return "unknown status code: " + i2;
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 10:
                return "DEVELOPER_ERROR";
            case 13:
                return DefaultLogger.ERROR;
            case 14:
                return "INTERRUPTED";
            case 15:
                return "TIMEOUT";
            case 16:
                return "CANCELED";
            case 17:
                return "API_NOT_CONNECTED";
            case 18:
                return "DEAD_CLIENT";
            case 19:
                return "REMOTE_EXCEPTION";
            case 20:
                return "CONNECTION_SUSPENDED_DURING_CALL";
            case 21:
                return "RECONNECTION_TIMED_OUT_DURING_UPDATE";
            case 22:
                return "RECONNECTION_TIMED_OUT";
        }
    }
}
