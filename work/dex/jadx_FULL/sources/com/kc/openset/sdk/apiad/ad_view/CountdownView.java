package com.kc.openset.sdk.apiad.ad_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class CountdownView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f39883a;
    private Paint b;
    private Handler c;
    private Runnable d;
    private boolean e;
    private OnCountdownFinishListener f;
    private OnSkipListener g;

    @Keep
    public interface OnCountdownFinishListener {
        void onCountdownFinish();
    }

    @Keep
    public interface OnSkipListener {
        void onSkip();
    }

    @Keep
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CountdownView f39884a;

        static {
            OSETSDKProtected.interface11(4815);
        }

        public a(CountdownView countdownView) {
            this.f39884a = countdownView;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        OSETSDKProtected.interface11(4816);
    }

    public CountdownView(Context context) {
        super(context);
        a();
    }

    public CountdownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public CountdownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private native void a();

    public static native /* synthetic */ boolean a(CountdownView countdownView);

    public static native /* synthetic */ int b(CountdownView countdownView);

    public static native /* synthetic */ int c(CountdownView countdownView);

    public static native /* synthetic */ Handler d(CountdownView countdownView);

    public static native /* synthetic */ OnCountdownFinishListener e(CountdownView countdownView);

    public native void a(int i);

    public native void b();

    public native void c();

    public native void d();

    @Override // android.view.View
    public native void onDraw(Canvas canvas);

    @Override // android.view.View
    public native boolean onTouchEvent(MotionEvent motionEvent);

    public native void setOnCountdownFinishListener(OnCountdownFinishListener onCountdownFinishListener);

    public native void setOnSkipListener(OnSkipListener onSkipListener);
}
