package com.alipay.android.app.helper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Tid extends com.alipay.sdk.tid.Tid {
    public Tid(String str, String str2, long j) {
        super(str, str2, j);
    }

    public static Tid fromRealTidModel(com.alipay.sdk.tid.Tid tid) {
        if (tid == null) {
            return null;
        }
        return new Tid(tid.getTid(), tid.getTidSeed(), tid.getTimestamp());
    }
}
