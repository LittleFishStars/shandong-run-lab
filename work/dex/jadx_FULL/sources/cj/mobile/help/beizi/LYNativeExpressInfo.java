package cj.mobile.help.beizi;

import android.view.View;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdExpressListener;
import xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class LYNativeExpressInfo implements AMPSNativeAdExpressInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f22224a;
    public int b;
    public AMPSNativeAdExpressListener c;

    public LYNativeExpressInfo(View view, int i) {
    }

    public void destroy() {
        this.f22224a = null;
    }

    public int getECPM() {
        return this.b;
    }

    public AMPSNativeAdExpressListener getListener() {
        return this.c;
    }

    public View getNativeExpressAdView() {
        return this.f22224a;
    }

    public void render() {
    }

    public void setAMPSNativeAdExpressListener(AMPSNativeAdExpressListener aMPSNativeAdExpressListener) {
        this.c = aMPSNativeAdExpressListener;
    }
}
