package com.alipay.sdk.tid;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Tid {
    public final String key;
    public final String tid;
    public final long time;

    public Tid(String str, String str2, long j) {
        this.tid = str;
        this.key = str2;
        this.time = j;
    }

    public static boolean isEmpty(Tid tid) {
        return tid == null || TextUtils.isEmpty(tid.tid);
    }

    public String getTid() {
        return this.tid;
    }

    public String getTidSeed() {
        return this.key;
    }

    public long getTimestamp() {
        return this.time;
    }
}
