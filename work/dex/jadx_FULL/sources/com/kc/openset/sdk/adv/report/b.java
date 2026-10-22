package com.kc.openset.sdk.adv.report;

import com.hzchengdun.securityguard.SecExceptionCode;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<Integer, String> f39857a;
    public int b;
    public Map<String, Object> c;

    static {
        OSETSDKProtected.interface11(4770);
        HashMap map = new HashMap();
        f39857a = map;
        map.put(899, OSETSDKProtected.getString2(2772));
        map.put(900, OSETSDKProtected.getString2(2773));
        map.put(901, OSETSDKProtected.getString2(2774));
        map.put(902, OSETSDKProtected.getString2(2775));
        map.put(903, OSETSDKProtected.getString2(2776));
        map.put(904, OSETSDKProtected.getString2(2777));
        map.put(10, OSETSDKProtected.getString2(2778));
        map.put(20, OSETSDKProtected.getString2(2779));
        map.put(30, OSETSDKProtected.getString2(2780));
        map.put(31, OSETSDKProtected.getString2(2781));
        map.put(40, OSETSDKProtected.getString2(2782));
        map.put(41, OSETSDKProtected.getString2(2783));
        map.put(42, OSETSDKProtected.getString2(2784));
        map.put(43, OSETSDKProtected.getString2(2785));
        map.put(50, OSETSDKProtected.getString2(com.google.android.exoplayer2.extractor.ts.a.f));
        map.put(51, OSETSDKProtected.getString2(2787));
        map.put(52, OSETSDKProtected.getString2(2788));
        map.put(60, OSETSDKProtected.getString2(2789));
        map.put(61, OSETSDKProtected.getString2(2790));
        map.put(62, OSETSDKProtected.getString2(2791));
        map.put(63, OSETSDKProtected.getString2(2792));
        map.put(64, OSETSDKProtected.getString2(2793));
        map.put(65, OSETSDKProtected.getString2(2794));
        map.put(66, OSETSDKProtected.getString2(2795));
        map.put(67, OSETSDKProtected.getString2(2796));
        map.put(68, OSETSDKProtected.getString2(2797));
        map.put(70, OSETSDKProtected.getString2(2798));
        map.put(71, OSETSDKProtected.getString2(2799));
        map.put(80, OSETSDKProtected.getString2(SecExceptionCode.SEC_ERROR_SENSOR));
        map.put(905, OSETSDKProtected.getString2(2801));
    }

    public b(int i, Map<String, Object> map) {
        this.b = i;
        this.c = map;
    }

    public static native String a(int i);

    public native String a();

    public native String toString();
}
