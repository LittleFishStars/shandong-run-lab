package com.kc.openset.advertisers.bash;

import android.app.Activity;
import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public abstract class BaseConfig {
    public static final String SUFFIX_AD = OSETSDKProtected.getString2(1008);
    public static final String SUFFIX_CT = OSETSDKProtected.getString2(1009);
    public static final String SUFFIX_EMBED = OSETSDKProtected.getString2(1010);
    private static final String TAG = OSETSDKProtected.getString2(1011);
    private static final Map<String, BaseConfig> sMap;

    static {
        OSETSDKProtected.interface11(4244);
        sMap = new HashMap();
    }

    public static native BaseConfig getInstance(Class<? extends BaseConfig> cls);

    public static native int getSecondPrice(int i);

    public abstract void addAdapter();

    public native Context getContext();

    public abstract String getCurrentVersion();

    public abstract void init(String str, String str2);

    public native void initAndStart(String str, String str2);

    public abstract void initialize();

    public abstract void start(String str, String str2);

    public native void startTestTool(Activity activity);
}
