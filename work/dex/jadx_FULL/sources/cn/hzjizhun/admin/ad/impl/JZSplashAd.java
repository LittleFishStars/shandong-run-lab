package cn.hzjizhun.admin.ad.impl;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import cn.hzjizhun.admin.ad.BaseAd;
import cn.hzjizhun.admin.ad.listener.JZSplashAdListener;
import cn.hzjizhun.admin.ad.loader.AdLoader;
import cn.hzjizhun.admin.api.ApiManager;
import cn.hzjizhun.admin.view.RootTouchViewGroup;
import com.zj.adlib.ghb;
import com.zj.adlib.nva;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class JZSplashAd extends BaseAd<JZSplashAdListener> {
    private RelativeLayout mContainer;
    private boolean mIsImmersive;
    private boolean mIsSkipViewTop;
    private SkipGravity mSkipGravity;
    private long mSkipTime;
    private View mSkipView;

    public enum SkipGravity {
        LEFT_TOP,
        LEFT_BOTTOM,
        RIGHT_TOP,
        RIGHT_BOTTOM
    }

    public JZSplashAd(Activity activity) {
        super(activity);
        this.mSkipTime = 5000L;
        this.mSkipGravity = SkipGravity.RIGHT_BOTTOM;
        this.isLoadLocation = false;
    }

    private void initContainer(ViewGroup viewGroup) {
        RootTouchViewGroup rootTouchViewGroup = new RootTouchViewGroup(viewGroup.getContext());
        this.mContainer = rootTouchViewGroup;
        viewGroup.addView(rootTouchViewGroup, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // cn.hzjizhun.admin.ad.BaseAd
    public ghb createAdLoader() {
        return new nva(this);
    }

    public RelativeLayout getContainer() {
        RelativeLayout relativeLayout = this.mContainer;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        return null;
    }

    public SkipGravity getSkipGravity() {
        return this.mSkipGravity;
    }

    public long getSkipTime() {
        if (this.mSkipTime < 5000) {
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

    public void loadJZAd(String str) {
        setJZAdId(str);
        super.loadJZAd();
    }

    @Override // cn.hzjizhun.admin.ad.BaseAd
    public void onDestroyed() {
        super.onDestroyed();
        if (this.mContainer != null) {
            this.mContainer = null;
        }
    }

    public void setImmersive(boolean z) {
        this.mIsImmersive = z;
    }

    @Override // cn.hzjizhun.admin.ad.BaseAd
    public void setJZAdId(String str) {
        super.setJZAdId(str);
    }

    public void setSkipTime(long j) {
        this.mSkipTime = j;
    }

    public void setSkipView(View view, long j) {
        this.mSkipView = view;
        this.mSkipTime = j;
    }

    public void setSkipViewGravity(SkipGravity skipGravity) {
        this.mSkipGravity = skipGravity;
    }

    public void setSkipViewToTop() {
        this.mIsSkipViewTop = true;
    }

    @Override // cn.hzjizhun.admin.ad.BaseAd
    public void setJZAdListener(JZSplashAdListener jZSplashAdListener) {
        super.setJZAdListener(jZSplashAdListener);
    }

    @Override // cn.hzjizhun.admin.ad.BaseAd
    public void loadJZAd() {
        try {
            AdLoader adLoader = this.mAdLoader;
            if (adLoader != null && (adLoader instanceof nva)) {
                ((nva) adLoader).e(ApiManager.checkAdSdkInitStatus());
            }
        } catch (Throwable unused) {
        }
        realLoadAd();
    }

    public JZSplashAd(Activity activity, ViewGroup viewGroup) {
        this(activity);
        initContainer(viewGroup);
    }

    public JZSplashAd(Activity activity, ViewGroup viewGroup, boolean z) {
        super(activity, z);
        this.mSkipTime = 5000L;
        this.mSkipGravity = SkipGravity.RIGHT_BOTTOM;
        initContainer(viewGroup);
    }

    public JZSplashAd(Fragment fragment, ViewGroup viewGroup) {
        super(fragment.getActivity());
        this.mSkipTime = 5000L;
        this.mSkipGravity = SkipGravity.RIGHT_BOTTOM;
        initContainer(viewGroup);
    }
}
