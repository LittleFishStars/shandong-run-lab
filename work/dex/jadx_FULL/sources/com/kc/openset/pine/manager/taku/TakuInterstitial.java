package com.kc.openset.pine.manager.taku;

import com.anythink.core.api.ATAdInfo;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.pine.Pine;
import com.kc.openset.pine.callback.MethodHook;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class TakuInterstitial {
    private static final String TAG = OSETSDKProtected.getString2(2298);
    private static Map<String, ATAdInfo> sTakuATAdInfoHashMap;

    /* JADX INFO: renamed from: com.kc.openset.pine.manager.taku.TakuInterstitial$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 extends MethodHook {
        static {
            OSETSDKProtected.interface11(4626);
        }

        @Override // com.kc.openset.pine.callback.MethodHook
        public native void beforeCall(Pine.CallFrame callFrame) throws Throwable;
    }

    static {
        OSETSDKProtected.interface11(4627);
    }

    public static native /* synthetic */ Map access$000();

    public static native void init(Map<String, ATAdInfo> map) throws NoSuchMethodException;
}
