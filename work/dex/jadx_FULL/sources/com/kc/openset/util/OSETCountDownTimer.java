package com.kc.openset.util;

import android.os.Handler;
import android.os.Message;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public abstract class OSETCountDownTimer {
    private static final int MSG = 1;
    private final long mCountdownInterval;
    private long mMillisInFuture;
    private long mStopTimeInFuture;
    private String TAG = OSETSDKProtected.getString2(3213);
    private boolean mCancelled = false;
    private Handler mHandler = new a(this);

    @Keep
    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETCountDownTimer f39951a;

        static {
            OSETSDKProtected.interface11(4961);
        }

        public a(OSETCountDownTimer oSETCountDownTimer) {
            this.f39951a = oSETCountDownTimer;
        }

        @Override // android.os.Handler
        public native void handleMessage(Message message);
    }

    static {
        OSETSDKProtected.interface11(4962);
    }

    public OSETCountDownTimer(long j, long j2) {
        this.mMillisInFuture = j;
        this.mCountdownInterval = j2;
    }

    public static native /* synthetic */ boolean access$000(OSETCountDownTimer oSETCountDownTimer);

    public static native /* synthetic */ long access$100(OSETCountDownTimer oSETCountDownTimer);

    public static native /* synthetic */ long access$200(OSETCountDownTimer oSETCountDownTimer);

    public final native void cancel();

    public abstract void onFinish();

    public abstract void onTick(long j);

    public final native OSETCountDownTimer start();

    public final native void updateMillisAndStart(long j);
}
