package cj.mobile.help.topon;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import cj.mobile.CJRenderNative;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class NativeAdExt extends CustomNativeAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f22262a;
    public boolean b;
    public CJRenderNative c;
    public FrameLayout d;
    public Context e;
    public FrameLayout f;

    public void destroy() {
        super.destroy();
    }

    public View getAdMediaView(Object... objArr) {
    }

    public ViewGroup getCustomAdContainer() {
    }

    public boolean isNativeExpress() {
        return this.b;
    }

    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
    }

    public void setCjRenderNative(CJRenderNative cJRenderNative) {
        this.c = cJRenderNative;
    }

    public void setContext(Context context) {
        this.e = context;
    }

    public void setFlMedia(FrameLayout frameLayout) {
        this.d = frameLayout;
    }

    public void setIsNativeExpress(boolean z) {
        this.b = z;
    }

    public void setView(View view) {
        this.f22262a = view;
    }
}
