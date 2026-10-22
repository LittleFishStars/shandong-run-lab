package cn.hzjizhun.admin.ad.impl;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import cn.hzjizhun.admin.ad.BaseAd;
import cn.hzjizhun.admin.ad.listener.JZInterstitialAdListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class JZInterstitialAd extends BaseAd<JZInterstitialAdListener> {
    private boolean mCancelable;
    private Handler mCloseHandler;
    private long mCloseTime;
    private boolean mIsCloseViewTop;
    private boolean mIsOutsideCancel;

    public JZInterstitialAd(Activity activity) {
        super(activity);
        this.mCloseHandler = new Handler(Looper.getMainLooper());
        this.mCancelable = true;
    }

    public Handler getCloseHandler() {
        return this.mCloseHandler;
    }

    public long getCloseTime() {
        return this.mCloseTime;
    }

    public boolean isCancelable() {
        return this.mCancelable;
    }

    public boolean isCloseViewTop() {
        return this.mIsCloseViewTop;
    }

    public boolean isOutsideCancel() {
        return this.mIsOutsideCancel;
    }

    @Override // cn.hzjizhun.admin.ad.BaseAd
    public void loadJZAd() {
        super.loadJZAd();
    }

    public void setCancelable(boolean z) {
        this.mCancelable = z;
    }

    public void setCanceledOnTouchOutside(boolean z) {
    }

    public void setCloseTime(long j) {
    }

    public void setCloseViewTop() {
        this.mIsCloseViewTop = true;
    }

    @Override // cn.hzjizhun.admin.ad.BaseAd
    public void setJZAdId(String str) {
        super.setJZAdId(str);
    }

    @Override // cn.hzjizhun.admin.ad.BaseAd
    public void setJZAdListener(JZInterstitialAdListener jZInterstitialAdListener) {
        this.mAdListener = jZInterstitialAdListener;
    }

    public JZInterstitialAd(Activity activity, boolean z) {
        super(activity, z);
        this.mCloseHandler = new Handler(Looper.getMainLooper());
        this.mCancelable = true;
    }

    public JZInterstitialAd(Fragment fragment) {
        this(fragment.getActivity());
    }
}
