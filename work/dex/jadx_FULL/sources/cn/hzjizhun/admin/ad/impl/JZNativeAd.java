package cn.hzjizhun.admin.ad.impl;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import cn.hzjizhun.admin.ad.BaseAd;
import cn.hzjizhun.admin.ad.listener.JZNativeAdListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class JZNativeAd extends BaseAd<JZNativeAdListener> {
    private boolean mInFunctionAd;
    private int mNativeAdCount;

    public JZNativeAd(Activity activity) {
        super(activity);
        this.mInFunctionAd = false;
        this.mNativeAdCount = 1;
    }

    public int getNativeAdCount() {
        return this.mNativeAdCount;
    }

    public boolean isInFunctionAd() {
        return this.mInFunctionAd;
    }

    public void loadJZAd(String str, int i) {
        super.setJZAdId(str);
        if (i >= 0 && i <= 3) {
            this.mNativeAdCount = i;
        }
        super.loadJZAd();
    }

    public void setInFunctionAd(boolean z) {
        this.mInFunctionAd = z;
    }

    @Override // cn.hzjizhun.admin.ad.BaseAd
    public void setJZAdId(String str) {
        super.setJZAdId(str);
    }

    public void setNativeAdCount(int i) {
        if (i < 0 || i > 3) {
            return;
        }
        this.mNativeAdCount = i;
    }

    @Override // cn.hzjizhun.admin.ad.BaseAd
    public void setJZAdListener(JZNativeAdListener jZNativeAdListener) {
        super.setJZAdListener(jZNativeAdListener);
    }

    public JZNativeAd(Fragment fragment) {
        this(fragment.getActivity());
    }

    @Override // cn.hzjizhun.admin.ad.BaseAd
    public void loadJZAd() {
        super.loadJZAd();
    }

    public JZNativeAd(Activity activity, boolean z) {
        super(activity, z);
        this.mInFunctionAd = false;
        this.mNativeAdCount = 1;
    }
}
