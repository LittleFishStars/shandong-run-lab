package com.kc.openset.pine.manager.tobid;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.camera.video.AudioStats;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.pine.Pine;
import com.kc.openset.pine.callback.MethodHook;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class ToBidRewardHook {
    private static final String TAG = OSETSDKProtected.getString2(2356);
    private static final Handler sHandler;
    private static final Map<String, ToBidBean> sMap;
    private static String sMaxNetwork;
    private static double sMaxPrice;
    private static double sSubsidyRatio;
    private static int sSubsidyTimeout;
    private static final Map<String, Message> sTobidMessageHashMap;

    /* JADX INFO: renamed from: com.kc.openset.pine.manager.tobid.ToBidRewardHook$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 extends MethodHook {
        static {
            OSETSDKProtected.interface11(4661);
        }

        public static native /* synthetic */ ToBidBean lambda$beforeCall$0(String str);

        @Override // com.kc.openset.pine.callback.MethodHook
        public native void beforeCall(Pine.CallFrame callFrame) throws Throwable;
    }

    /* JADX INFO: renamed from: com.kc.openset.pine.manager.tobid.ToBidRewardHook$3, reason: invalid class name */
    @Keep
    public class AnonymousClass3 extends MethodHook {
        static {
            OSETSDKProtected.interface11(4662);
        }

        @Override // com.kc.openset.pine.callback.MethodHook
        public native void beforeCall(Pine.CallFrame callFrame) throws Throwable;
    }

    /* JADX INFO: renamed from: com.kc.openset.pine.manager.tobid.ToBidRewardHook$4, reason: invalid class name */
    @Keep
    public class AnonymousClass4 extends MethodHook {
        static {
            OSETSDKProtected.interface11(4663);
        }

        @Override // com.kc.openset.pine.callback.MethodHook
        public native void beforeCall(Pine.CallFrame callFrame) throws Throwable;
    }

    static {
        OSETSDKProtected.interface11(4664);
        sSubsidyTimeout = 1500;
        sMap = new ConcurrentHashMap();
        sMaxPrice = AudioStats.AUDIO_AMPLITUDE_NONE;
        sMaxNetwork = "";
        sTobidMessageHashMap = new ConcurrentHashMap();
        sHandler = new Handler(Looper.getMainLooper()) { // from class: com.kc.openset.pine.manager.tobid.ToBidRewardHook.1
            static {
                OSETSDKProtected.interface11(4659);
            }

            public static native /* synthetic */ boolean lambda$handleMessage$0(Object obj);

            @Override // android.os.Handler
            public native void handleMessage(Message message);
        };
    }

    public static native /* synthetic */ Map access$000();

    public static native /* synthetic */ Map access$100();

    public static native /* synthetic */ boolean access$200(Object obj);

    public static native /* synthetic */ double access$300();

    public static native /* synthetic */ double access$302(double d);

    public static native /* synthetic */ String access$400();

    public static native /* synthetic */ String access$402(String str);

    public static native /* synthetic */ double access$500();

    public static native /* synthetic */ int access$600();

    public static native /* synthetic */ Handler access$700();

    public static native /* synthetic */ ToBidBean access$800(Object obj);

    public static native /* synthetic */ void access$900(ToBidBean toBidBean);

    private static native void checkSize(ToBidBean toBidBean);

    public static native void init(double d, int i);

    private static native boolean isNotQd(Object obj);

    private static native ToBidBean removeObj(Object obj);
}
