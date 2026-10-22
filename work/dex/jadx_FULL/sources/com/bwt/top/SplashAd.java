package com.bwt.top;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import com.bwt.top.ad.BaseAd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class SplashAd extends BaseAd<SplashAdListener> {
    private AdSize mAdSize;
    private RelativeLayout mContainer;
    private boolean mIsImmersive;
    private boolean mIsSkipViewTop;
    private long mSkipTime;
    private View mSkipView;

    public static class AdSize {
        int heightPixel;
        int widthPixels;

        public AdSize(int i, int i2) {
            this.widthPixels = i;
            this.heightPixel = i2;
        }

        public int getHeightPixel() {
            return this.heightPixel;
        }

        public int getWidthPixels() {
            return this.widthPixels;
        }
    }

    public SplashAd(Activity activity) {
        super(activity);
        this.mSkipTime = 5000L;
    }

    public SplashAd(Activity activity, ViewGroup viewGroup) {
        super(activity);
        this.mSkipTime = 5000L;
        initContainer(viewGroup);
    }

    public SplashAd(Fragment fragment, ViewGroup viewGroup) {
        super(fragment.getActivity());
        this.mSkipTime = 5000L;
        initContainer(viewGroup);
    }

    private void initContainer(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
        this.mContainer = relativeLayout;
        viewGroup.addView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
    }

    public AdSize getAdSize() {
        return this.mAdSize;
    }

    public RelativeLayout getContainer() {
        RelativeLayout relativeLayout = this.mContainer;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        return null;
    }

    public long getSkipTime() {
        if (this.mSkipTime < 3000) {
            this.mSkipTime = 3000L;
        }
        if (this.mSkipTime > 5000) {
            this.mSkipTime = 5000L;
        }
        return this.mSkipTime;
    }

    public View getSkipView() {
        return this.mSkipView;
    }

    public boolean isImmersive() {
        return this.mIsImmersive;
    }

    public boolean isSkipViewTop() {
        return this.mIsSkipViewTop;
    }

    @Override // com.bwt.top.ad.BaseAd
    public void loadAd() {
        super.loadAd();
    }

    public void loadAd(String str) {
        setAdId(str);
        super.loadAd();
    }

    @Override // com.bwt.top.ad.BaseAd
    public void release() {
        super.release();
        if (this.mContainer != null) {
            this.mContainer = null;
        }
    }

    @Override // com.bwt.top.ad.BaseAd
    public void setAdId(String str) {
        super.setAdId(str);
    }

    @Override // com.bwt.top.ad.BaseAd
    public void setAdListener(SplashAdListener splashAdListener) {
        super.setAdListener(splashAdListener);
    }

    public void setAdSize(AdSize adSize) {
        this.mAdSize = adSize;
    }

    public void setImmersive(boolean z) {
        this.mIsImmersive = z;
    }

    public void setSkipTime(long j) {
        this.mSkipTime = j;
    }

    public void setSkipView(View view, long j) {
        this.mSkipView = view;
        this.mSkipTime = j;
    }

    public void setSkipViewToTop() {
        this.mIsSkipViewTop = true;
    }
}
