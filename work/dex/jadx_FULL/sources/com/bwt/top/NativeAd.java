package com.bwt.top;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.bwt.top.ad.BaseAd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class NativeAd extends BaseAd<NativeAdListener> {
    private int mNativeAdCount;

    public NativeAd(Activity activity) {
        super(activity);
        this.mNativeAdCount = 1;
    }

    public NativeAd(Fragment fragment) {
        this(fragment.getActivity());
    }

    public int getNativeAdCount() {
        return this.mNativeAdCount;
    }

    @Override // com.bwt.top.ad.BaseAd
    public void loadAd() {
        super.loadAd();
    }

    public void loadAd(String str, int i) {
        super.setAdId(str);
        if (i >= 0 && i <= 3) {
            this.mNativeAdCount = i;
        }
        super.loadAd();
    }

    @Override // com.bwt.top.ad.BaseAd
    public void setAdId(String str) {
        super.setAdId(str);
    }

    @Override // com.bwt.top.ad.BaseAd
    public void setAdListener(NativeAdListener nativeAdListener) {
        super.setAdListener(nativeAdListener);
    }

    public void setNativeAdCount(int i) {
        if (i < 0 || i > 3) {
            return;
        }
        this.mNativeAdCount = i;
    }
}
