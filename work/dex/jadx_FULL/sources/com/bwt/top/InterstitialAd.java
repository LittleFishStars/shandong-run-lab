package com.bwt.top;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import com.bwt.top.ad.BaseAd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class InterstitialAd extends BaseAd<InterstitialAdListener> {
    private Handler mCloseHandler;
    private long mCloseTime;

    public InterstitialAd(Activity activity) {
        super(activity);
        this.mCloseHandler = new Handler(Looper.getMainLooper());
    }

    public InterstitialAd(Fragment fragment) {
        this(fragment.getActivity());
    }

    public Handler getCloseHandler() {
        return this.mCloseHandler;
    }

    public long getCloseTime() {
        return this.mCloseTime;
    }

    @Override // com.bwt.top.ad.BaseAd
    public void loadAd() {
        super.loadAd();
    }

    @Override // com.bwt.top.ad.BaseAd
    public void setAdId(String str) {
        super.setAdId(str);
    }

    @Override // com.bwt.top.ad.BaseAd
    public void setAdListener(InterstitialAdListener interstitialAdListener) {
        this.mAdListener = interstitialAdListener;
    }

    public void setCloseTime(long j) {
        this.mCloseTime = j;
    }
}
