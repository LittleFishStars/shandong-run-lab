package com.bwt.top;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import com.bwt.top.ad.BaseAd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BannerAd extends BaseAd<BannerAdListener> {
    private RelativeLayout mContainer;
    private int mInterval;
    private boolean mShowCloseView;

    public BannerAd(Activity activity, ViewGroup viewGroup) {
        super(activity);
        this.mInterval = 0;
        initContainer(viewGroup);
    }

    public BannerAd(Fragment fragment, ViewGroup viewGroup) {
        this(fragment.getActivity(), viewGroup);
    }

    private void initContainer(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
        this.mContainer = relativeLayout;
        viewGroup.addView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
    }

    public int getAutoRefreshInterval() {
        return this.mInterval;
    }

    public RelativeLayout getContainer() {
        RelativeLayout relativeLayout = this.mContainer;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        return null;
    }

    public boolean isShowCloseView() {
        return this.mShowCloseView;
    }

    @Override // com.bwt.top.ad.BaseAd
    public void release() {
        super.release();
        if (this.mContainer != null) {
            this.mContainer = null;
        }
    }

    @Override // com.bwt.top.ad.BaseAd
    public void setAdListener(BannerAdListener bannerAdListener) {
        this.mAdListener = bannerAdListener;
    }

    public void setAutoRefreshInterval(int i) {
        if (i >= 120) {
            this.mInterval = 120;
            return;
        }
        if (i < 30) {
            i = 0;
        }
        this.mInterval = i;
    }

    public void showCloseView() {
        this.mShowCloseView = true;
    }
}
