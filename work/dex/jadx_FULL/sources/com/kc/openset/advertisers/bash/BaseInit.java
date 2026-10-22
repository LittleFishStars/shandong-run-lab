package com.kc.openset.advertisers.bash;

import android.app.Activity;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public abstract class BaseInit {
    private static final String TAG = OSETSDKProtected.getString2(1013);
    private static final Map<String, BaseInit> sMap;

    static {
        OSETSDKProtected.interface11(4245);
        sMap = new HashMap();
    }

    public static native BaseInit getInstance(Class<? extends BaseInit> cls);

    public abstract String getCurrentVersion();

    public abstract void init(String str, String str2);

    public native void initFail(String str);

    public native void initSuccess(String str);

    public abstract void start(String str, String str2);

    public native void startFail(String str);

    public native void startInit(String str);

    public native void startSuccess(String str);

    public native void startTestTool(Activity activity);

    public native void starting(String str);
}
