package com.zj.adlib;

import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.Lifecycle;
import com.huachenjie.ad.impl.JzAdLoader;
import com.huachenjie.ad.impl.LinkPageAdLoader;
import com.huachenjie.ad.impl.SigmobAdLoader;
import com.huachenjie.ad.impl.ZJAdLoader;
import com.huachenjie.ad.interfaces.InterstitialAdListener;
import com.huachenjie.ad.interfaces.NativeAdListener;
import com.huachenjie.ad.interfaces.OnUseShanDongAdListener;
import com.huachenjie.ad.interfaces.SplashAdListener;
import com.huachenjie.common.bean.AdPlatformSwitch;
import com.huachenjie.common.bean.AdPositionSwitch;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class i90 {
    @Nullable
    public static AdPositionSwitch e(FragmentActivity fragmentActivity, String str, OnUseShanDongAdListener onUseShanDongAdListener) {
        AdPositionSwitch adPositionSwitchD;
        if (!f() || fragmentActivity == null || (adPositionSwitchD = r90.d(str)) == null) {
            return null;
        }
        if (adPositionSwitchD.getAdType() != 1) {
            return adPositionSwitchD;
        }
        d88 d88VarI = ew.i();
        if (d88VarI == null) {
            return null;
        }
        onUseShanDongAdListener.a(d88VarI, new AdPlatformSwitch(adPositionSwitchD.getAdPositionName(), true, 1, adPositionSwitchD.getLinkUrl(), adPositionSwitchD.getImgUrl(), adPositionSwitchD.getAdvertisementPlanCode()));
        return null;
    }

    public static boolean f() {
        return r90.d("adSwitch") != null;
    }

    public static void k(@Nullable final FragmentActivity fragmentActivity, Lifecycle lifecycle, @Nullable final InterstitialAdListener interstitialAdListener) {
        AdPositionSwitch adPositionSwitchE = e(fragmentActivity, "hpt", new OnUseShanDongAdListener() { // from class: com.zj.adlib.f90
            @Override // com.huachenjie.ad.interfaces.OnUseShanDongAdListener
            public final void a(d88 d88Var, AdPlatformSwitch adPlatformSwitch) {
                d88Var.d(fragmentActivity, adPlatformSwitch, interstitialAdListener);
            }
        });
        if (adPositionSwitchE == null) {
        }
        if (r90.c()) {
            ew.l().d("J7457797467", fragmentActivity, lifecycle, interstitialAdListener);
            return;
        }
        String adAgencyName = adPositionSwitchE.getAdAgencyName();
        adAgencyName.hashCode();
        switch (adAgencyName) {
            case "jizhun":
                JzAdLoader jzAdLoaderF = ew.f();
                if (jzAdLoaderF != null) {
                    jzAdLoaderF.h(hp4.k, fragmentActivity, lifecycle, interstitialAdListener);
                    break;
                }
                break;
            case "tanx":
                ZJAdLoader zJAdLoaderL = ew.l();
                if (zJAdLoaderL != null) {
                    zJAdLoaderL.d("J7457797467", fragmentActivity, lifecycle, interstitialAdListener);
                    break;
                }
                break;
            case "tobid":
                SigmobAdLoader sigmobAdLoaderJ = ew.j();
                if (sigmobAdLoaderJ != null) {
                    sigmobAdLoaderJ.g(vb8.k, fragmentActivity, lifecycle, interstitialAdListener);
                    break;
                }
                break;
        }
    }

    public static void l(@Nullable final FragmentActivity fragmentActivity, Lifecycle lifecycle, @Nullable final InterstitialAdListener interstitialAdListener) {
        SigmobAdLoader sigmobAdLoaderJ;
        AdPositionSwitch adPositionSwitchE = e(fragmentActivity, "rst", new OnUseShanDongAdListener() { // from class: com.zj.adlib.h90
            @Override // com.huachenjie.ad.interfaces.OnUseShanDongAdListener
            public final void a(d88 d88Var, AdPlatformSwitch adPlatformSwitch) {
                d88Var.d(fragmentActivity, adPlatformSwitch, interstitialAdListener);
            }
        });
        if (adPositionSwitchE == null) {
            return;
        }
        if (r90.c()) {
            ew.l().d(r8a.h, fragmentActivity, lifecycle, interstitialAdListener);
            return;
        }
        String adAgencyName = adPositionSwitchE.getAdAgencyName();
        adAgencyName.hashCode();
        if (adAgencyName.equals("tanx")) {
            ZJAdLoader zJAdLoaderL = ew.l();
            if (zJAdLoaderL == null) {
                return;
            }
            zJAdLoaderL.d(r8a.d, fragmentActivity, lifecycle, interstitialAdListener);
            return;
        }
        if (adAgencyName.equals("tobid") && (sigmobAdLoaderJ = ew.j()) != null) {
            sigmobAdLoaderJ.g(vb8.l, fragmentActivity, lifecycle, interstitialAdListener);
        }
    }

    public static void m(@Nullable FragmentActivity fragmentActivity, Lifecycle lifecycle, final ViewGroup viewGroup, int i, int i2, @Nullable final NativeAdListener nativeAdListener) {
        AdPositionSwitch adPositionSwitchE = e(fragmentActivity, "rst", new OnUseShanDongAdListener() { // from class: com.zj.adlib.e90
            @Override // com.huachenjie.ad.interfaces.OnUseShanDongAdListener
            public final void a(d88 d88Var, AdPlatformSwitch adPlatformSwitch) {
                d88Var.e(adPlatformSwitch, viewGroup, nativeAdListener);
            }
        });
        if (adPositionSwitchE == null) {
        }
        String adAgencyName = adPositionSwitchE.getAdAgencyName();
        adAgencyName.hashCode();
        switch (adAgencyName) {
            case "jizhun":
                ew.f();
                break;
            case "lingye":
                LinkPageAdLoader linkPageAdLoaderG = ew.g();
                if (linkPageAdLoaderG != null) {
                    linkPageAdLoaderG.e(fragmentActivity, lifecycle, viewGroup, i, i2, ey4.c, nativeAdListener);
                    break;
                }
                break;
            case "tanx":
                ew.l();
                break;
            case "tobid":
                SigmobAdLoader sigmobAdLoaderJ = ew.j();
                if (sigmobAdLoaderJ != null) {
                    sigmobAdLoaderJ.h(vb8.e, lifecycle, viewGroup, i, i2, nativeAdListener);
                    break;
                }
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0047  */
    public static void n(boolean z, final FragmentActivity fragmentActivity, Lifecycle lifecycle, final ViewGroup viewGroup, int i, int i2, final SplashAdListener splashAdListener) {
        byte b;
        ZJAdLoader zJAdLoaderL;
        AdPositionSwitch adPositionSwitchE = e(fragmentActivity, "os", new OnUseShanDongAdListener() { // from class: com.zj.adlib.g90
            @Override // com.huachenjie.ad.interfaces.OnUseShanDongAdListener
            public final void a(d88 d88Var, AdPlatformSwitch adPlatformSwitch) {
                d88Var.f(fragmentActivity, adPlatformSwitch, viewGroup, splashAdListener);
            }
        });
        if (adPositionSwitchE == null) {
            return;
        }
        String adAgencyName = adPositionSwitchE.getAdAgencyName();
        int iHashCode = adAgencyName.hashCode();
        if (iHashCode != -1159569402) {
            if (iHashCode != 3552503) {
                if (iHashCode == 110532770 && adAgencyName.equals("tobid")) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (adAgencyName.equals("tanx")) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (adAgencyName.equals("jizhun")) {
            b = 2;
        } else {
            b = -1;
        }
        if (b != 0) {
            if (b == 1 && (zJAdLoaderL = ew.l()) != null) {
                zJAdLoaderL.g("J2591425374", fragmentActivity, viewGroup, i, i2, splashAdListener);
                return;
            }
            return;
        }
        SigmobAdLoader sigmobAdLoaderJ = ew.j();
        if (sigmobAdLoaderJ == null) {
            return;
        }
        sigmobAdLoaderJ.j(fragmentActivity, lifecycle, viewGroup, i, i2, splashAdListener);
    }
}
