package com.kc.openset.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class OSETShakeView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f40005a;
    private LinearLayout b;
    private ImageView c;
    private TextView d;
    private ObjectAnimator e;

    static {
        OSETSDKProtected.interface11(5076);
    }

    public OSETShakeView(Context context) {
        this(context, null);
    }

    public OSETShakeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OSETShakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private native void a(Context context);

    public native void a();

    public native void a(boolean z);

    public native void b();

    @Override // android.view.ViewGroup, android.view.View
    public native void onAttachedToWindow();

    @Override // android.view.ViewGroup, android.view.View
    public native void onDetachedFromWindow();

    public native void setTiltSensorSen(boolean z);
}
