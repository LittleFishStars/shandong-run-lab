package cn.hzjizhun.admin.ad.impl;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import cn.hzjizhun.admin.ad.loader.AdLoader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class JZInterstitialAsyncAd extends JZInterstitialAd {
    public JZInterstitialAsyncAd(Activity activity) {
        super(activity, false);
    }

    public void releaseAd() {
        AdLoader adLoader = this.mAdLoader;
        if (adLoader != null) {
            adLoader.release();
        }
    }

    public JZInterstitialAsyncAd(Fragment fragment) {
        super(fragment);
    }
}
