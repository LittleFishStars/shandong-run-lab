package com.kc.openset.pine.manager;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.security.SecureRandom;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class Range {
    int end;
    int start;
    double weight;

    static {
        OSETSDKProtected.interface11(4608);
    }

    public Range(int i, int i2, double d) {
        this.start = i;
        this.end = i2;
        this.weight = d;
    }

    public native int getRandomInRange(SecureRandom secureRandom);

    public native String toString();
}
