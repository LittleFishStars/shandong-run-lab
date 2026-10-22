package cn.hzjizhun.admin.ad.impl;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import cn.hzjizhun.admin.ad.BaseAd;
import cn.hzjizhun.admin.ad.listener.JZBannerAdListener;
import cn.hzjizhun.admin.view.RootTouchViewGroup;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class JZBannerAd extends BaseAd<JZBannerAdListener> {
    private int closeIconSizeDp;
    private RelativeLayout mContainer;
    private int mInterval;
    private boolean mShowCloseView;

    public JZBannerAd(Activity activity, ViewGroup viewGroup) {
        super(activity);
        this.mInterval = 0;
        this.closeIconSizeDp = 15;
        initContainer(viewGroup);
    }

    private void initContainer(ViewGroup viewGroup) {
        RootTouchViewGroup rootTouchViewGroup = new RootTouchViewGroup(viewGroup.getContext());
        this.mContainer = rootTouchViewGroup;
        viewGroup.addView(rootTouchViewGroup, new ViewGroup.LayoutParams(-1, -1));
    }

    public int getAutoRefreshInterval() {
        return this.mInterval;
    }

    public int getCloseIconSize() {
        return this.closeIconSizeDp;
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

    @Override // cn.hzjizhun.admin.ad.BaseAd
    public void onDestroyed() {
        super.onDestroyed();
        if (this.mContainer != null) {
            this.mContainer = null;
        }
    }

    public void setAutoRefreshInterval(int i) {
        if (i >= 120) {
            this.mInterval = 120;
        } else if (i >= 30) {
            this.mInterval = i;
        } else {
            this.mInterval = 0;
        }
    }

    public void setCloseIconSize(int i) {
        this.closeIconSizeDp = i;
    }

    public void showCloseView() {
        this.mShowCloseView = true;
    }

    @Override // cn.hzjizhun.admin.ad.BaseAd
    public void setJZAdListener(JZBannerAdListener jZBannerAdListener) {
        this.mAdListener = jZBannerAdListener;
    }

    public JZBannerAd(Activity activity, ViewGroup viewGroup, boolean z) {
        super(activity, z);
        this.mInterval = 0;
        this.closeIconSizeDp = 15;
        initContainer(viewGroup);
    }

    public JZBannerAd(Fragment fragment, ViewGroup viewGroup) {
        this(fragment.getActivity(), viewGroup);
    }
}
