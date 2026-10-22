package com.kc.openset.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class OSETNativeContainerView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OnViewVisibilityListener f40003a;
    private final ViewTreeObserver.OnPreDrawListener b;

    @Keep
    public interface OnViewVisibilityListener {
        void onWindowVisibilityChanged(boolean z);
    }

    @Keep
    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETNativeContainerView f40004a;

        static {
            OSETSDKProtected.interface11(5074);
        }

        public a(OSETNativeContainerView oSETNativeContainerView) {
            this.f40004a = oSETNativeContainerView;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public native boolean onPreDraw();
    }

    static {
        OSETSDKProtected.interface11(5075);
    }

    public OSETNativeContainerView(Context context) {
        this(context, null);
    }

    public OSETNativeContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OSETNativeContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new a(this);
    }

    public static native /* synthetic */ OnViewVisibilityListener a(OSETNativeContainerView oSETNativeContainerView);

    public native boolean a();

    @Override // android.view.ViewGroup, android.view.View
    public native void onAttachedToWindow();

    @Override // android.view.ViewGroup, android.view.View
    public native void onDetachedFromWindow();

    public native void setOnViewVisibilityChangedListener(OnViewVisibilityListener onViewVisibilityListener);
}
