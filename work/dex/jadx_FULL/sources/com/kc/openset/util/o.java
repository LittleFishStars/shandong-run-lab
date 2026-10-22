package com.kc.openset.util;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.DummyBtnConfig;
import com.kc.openset.ad.config.AdType;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class o {
    static {
        OSETSDKProtected.interface11(5030);
    }

    private static native DummyBtnConfig a(JSONArray jSONArray, String str);

    public static native List<com.kc.openset.ad.e> a(JSONArray jSONArray, JSONArray jSONArray2, boolean z, String str, String str2, int i, int i2, String str3, AdType adType, int i3, int i4, double d, JSONArray jSONArray3);

    public static native void a(JSONObject jSONObject);

    private static native boolean b(JSONArray jSONArray, String str);
}
