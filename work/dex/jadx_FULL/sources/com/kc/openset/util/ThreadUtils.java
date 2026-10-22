package com.kc.openset.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class ThreadUtils {
    public static final String TAG = OSETSDKProtected.getString2(3265);
    private static final Handler mHandler;
    private static final HandlerThread sHandlerThread;
    private static Handler sThreadHandler;

    @Keep
    public interface ThreadCallBack {
        void onThread();
    }

    @Keep
    public interface UICallBack {
        void onUIThread();
    }

    static {
        OSETSDKProtected.interface11(4991);
        mHandler = new Handler(Looper.getMainLooper());
        sHandlerThread = new HandlerThread(OSETSDKProtected.getString2(3265));
        sThreadHandler = null;
    }

    public static native /* synthetic */ void lambda$runOnThread$2(ThreadCallBack threadCallBack);

    public static native /* synthetic */ void lambda$runOnUIThread$0(UICallBack uICallBack);

    public static native /* synthetic */ void lambda$runOnUIThreadDelay$1(UICallBack uICallBack);

    public static native void runOnThread(ThreadCallBack threadCallBack);

    public static native void runOnUIThread(UICallBack uICallBack);

    public static native void runOnUIThreadDelay(UICallBack uICallBack, long j);
}
