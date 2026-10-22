package com.kc.dw.platform.ad_adapter.banner;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.android.arouter.utils.Consts;
import com.kc.dw.ad.banner.SsdBannerRootView;
import com.kc.dw.core.ad.banner.BannerAdLoadListener;
import com.kc.dw.core.ad.banner.BannerCommonAdLoader;
import com.kc.dw.core.bquery.d;
import com.kc.dw.core.router.log.bean.TypeMsg;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.c0;
import com.kc.dw.core.utils.s1;
import com.kc.dw.core.view.DownloadView;
import com.kc.dw.core.view.TouchAdContainer;
import com.kc.dw.core.view.TouchPositionListener;
import com.kc.dw.core.view.gif.GifImageView;
import com.kc.dw.platform.ad_adapter.g;
import com.kc.dw.platform.ad_adapter.h;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c extends h<com.kc.dw.ad.banner.a, BannerCommonAdLoader, BannerAdLoadListener> {
    public long f;
    public long g;
    public String[] h;
    public a i;
    public OwnBannerSingleListener j;
    public final g k;
    public ViewGroup l;
    public boolean m;
    public boolean n;

    public c(BannerCommonAdLoader bannerCommonAdLoader, com.kc.dw.ad.banner.a aVar) {
        super(bannerCommonAdLoader, aVar);
        this.k = new g();
        this.m = false;
        this.n = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(c cVar, View view, a aVar) {
        cVar.getClass();
        com.kc.dw.core.service.logrecord.a.a(5, "e5", cVar, new TypeMsg().setData(cVar.n ? 2 : 1));
        TouchAdContainer touchAdContainer = new TouchAdContainer(view.getContext());
        touchAdContainer.setTouchPositionListener(new TouchPositionListener(aVar));
        touchAdContainer.addView(view);
        cVar.k.a(-1, 5);
        aVar.setAdView(touchAdContainer);
        try {
            if (((BannerCommonAdLoader) cVar.getAdLoader()).getAdSlot().getWidth() > 0 && ((BannerCommonAdLoader) cVar.getAdLoader()).getAdSlot().getHeight() > 0) {
                aVar.setWidthAndHeight(((BannerCommonAdLoader) cVar.getAdLoader()).getAdSlot().getWidth(), ((BannerCommonAdLoader) cVar.getAdLoader()).getAdSlot().getHeight());
            }
            aVar.adView.findViewById(R.id.ms_banner_close_button).setVisibility(((BannerCommonAdLoader) cVar.getAdLoader()).getAdSlot().isCloseButtonVisible() ? 0 : 4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        OwnBannerSingleListener ownBannerSingleListener = cVar.j;
        if (ownBannerSingleListener != null) {
            ownBannerSingleListener.onRenderSuccess(aVar);
        }
        cVar.innerShowAd();
    }

    public void a(com.kc.dw.ad.banner.a aVar) {
        if (this.k.f39476a != 0) {
            return;
        }
        this.k.a(-1, 1);
        try {
            this.h = aVar.getErrorUrl();
        } catch (Exception e) {
            e.printStackTrace();
        }
        SsdBannerRootView ssdBannerRootView = (SsdBannerRootView) LayoutInflater.from(this.context).inflate(R.layout.ssd_banner_ad_layout, (ViewGroup) null);
        d dVar = new d(ssdBannerRootView);
        GifImageView gifImageView = (GifImageView) ssdBannerRootView.findViewById(R.id.ms_banner_image);
        if (aVar.getAdPatternType() == 2) {
            StringBuilder sbA = com.kc.dw.activity.a.a("unsupported type: ");
            sbA.append(aVar.getAdPatternType());
            LogUtil.i("MeishuViewWrapper", sbA.toString());
            a("unsupported type", com.kc.dw.core.exception.b.e.intValue());
            return;
        }
        if (!com.kc.dw.base.a.adConfig().showLogo()) {
            dVar.b(R.id.ssd_img_ad_tag).d(8);
        } else if (!TextUtils.isEmpty(aVar.getFromLogo())) {
            dVar.b(R.id.ssd_img_ad_tag).a(aVar.getFromLogo(), false);
        }
        new DownloadView().handleDownloadView(ssdBannerRootView, aVar);
        com.kc.dw.core.service.logrecord.a.a(5, "e4", this);
        this.f = System.currentTimeMillis();
        c0.a(aVar.getImageUrls()[0], new b(this, aVar, ssdBannerRootView, gifImageView, dVar));
    }

    public final void a(String str, int i) {
        OwnBannerSingleListener ownBannerSingleListener;
        a aVar;
        AdError adError;
        int i2;
        this.k.a(-1, 6);
        s1.a(this.h, 12, i, str);
        if (this.j != null) {
            if (this.k.f39476a >= 5) {
                ownBannerSingleListener = this.j;
                aVar = this.i;
                adError = new AdError(i, str);
                i2 = 1;
            } else {
                ownBannerSingleListener = this.j;
                aVar = this.i;
                adError = new AdError(i, str);
                i2 = 0;
            }
            ownBannerSingleListener.onAdFail(aVar, adError, i2);
        }
    }

    @Override // com.kc.dw.platform.ad_adapter.h
    public String b() {
        return this.f + Consts.DOT + 0L + Consts.DOT + this.g;
    }

    public final void innerShowAd() {
        if (this.m && this.i != null && this.k.a(5, 7)) {
            com.kc.dw.core.service.logrecord.a.a(5, "e7", this);
            this.i.showAd(this.l);
            this.k.a(-1, 8);
        }
    }

    @Override // com.kc.dw.platform.BasePlatformLoader, com.kc.dw.core.loader.b
    public void loadAd() {
        T t = this.f39477a;
        if (t == 0 || ((com.kc.dw.ad.banner.a) t).getImageUrls() == null || ((com.kc.dw.ad.banner.a) this.f39477a).getImageUrls().length == 0) {
            LogUtil.i("MeishuViewWrapper", "资源url为空");
            OwnBannerSingleListener ownBannerSingleListener = this.j;
            if (ownBannerSingleListener != null) {
                ownBannerSingleListener.onLoadFail(new AdError(com.kc.dw.core.exception.b.d.intValue(), "资源url为空"));
                return;
            }
            return;
        }
        if (((com.kc.dw.ad.banner.a) this.f39477a).getAdPatternType() == 2) {
            StringBuilder sbA = com.kc.dw.activity.a.a("unsupported type: ");
            sbA.append(((com.kc.dw.ad.banner.a) this.f39477a).getAdPatternType());
            LogUtil.i("MeishuViewWrapper", sbA.toString());
            OwnBannerSingleListener ownBannerSingleListener2 = this.j;
            if (ownBannerSingleListener2 != null) {
                ownBannerSingleListener2.onLoadFail(new AdError(com.kc.dw.core.exception.b.e.intValue(), "不支持视频类型"));
                return;
            }
            return;
        }
        a aVar = new a((com.kc.dw.ad.banner.a) this.f39477a);
        this.i = aVar;
        OwnBannerSingleListener ownBannerSingleListener3 = this.j;
        if (ownBannerSingleListener3 != null) {
            ownBannerSingleListener3.onLoadSuccess(aVar);
        }
        if (getLoaderListener() instanceof BannerAdLoadListener) {
            if (!isAutoRender()) {
                LogUtil.w("MeishuViewWrapper", "please call render() when loadSuccess()");
                return;
            }
            com.kc.dw.ad.banner.a aVar2 = (com.kc.dw.ad.banner.a) this.f39477a;
            a(aVar2);
        }
    }
}
