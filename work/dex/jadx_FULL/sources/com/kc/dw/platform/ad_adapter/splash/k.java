package com.kc.dw.platform.ad_adapter.splash;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.google.gson.Gson;
import com.kc.dw.ad.nativ.NormalMediaView;
import com.kc.dw.ad.splash.SsdSplashRootView;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.ad.splash.ISplashFinishingTouchListener;
import com.kc.dw.core.ad.splash.SplashAd;
import com.kc.dw.core.loader.InteractionListener;
import com.kc.dw.core.safe.m;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.ResultBean;
import com.kc.dw.core.utils.s1;
import com.kc.dw.core.view.gif.GifImageView;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class k extends SplashAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f39558a;
    public com.kc.dw.ad.splash.b b;
    public boolean c;

    @Keep
    public class a extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.kc.dw.ad.splash.c f39559a;
        public final k b;

        public a(k kVar, com.kc.dw.ad.splash.c cVar) {
            this.b = kVar;
            this.f39559a = cVar;
        }

        @Override // com.kc.dw.core.safe.m
        public void safeOnClick(View view) {
            k.a(this.b, this.f39559a, true);
        }
    }

    @Keep
    public class b extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.kc.dw.ad.splash.c f39560a;
        public final k b;

        public b(k kVar, com.kc.dw.ad.splash.c cVar) {
            this.b = kVar;
            this.f39560a = cVar;
        }

        @Override // com.kc.dw.core.safe.m
        public void safeOnClick(View view) {
            k.a(this.b, this.f39560a, true);
            this.f39560a.b.setClkActType(1);
            if (this.f39560a.getInteractionListener() != null && this.f39560a.b.getCbc() == 0) {
                this.f39560a.getInteractionListener().onAdClicked();
            }
            com.kc.dw.core.utils.f.a((com.kc.dw.platform.ad_adapter.c) this.f39560a, false);
        }
    }

    @Keep
    public class c extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.kc.dw.ad.splash.c f39561a;
        public final k b;

        public c(k kVar, com.kc.dw.ad.splash.c cVar) {
            this.b = kVar;
            this.f39561a = cVar;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            k.a(this.b, this.f39561a, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(com.kc.dw.ad.splash.b bVar, j jVar, e eVar, boolean z) {
        super(null, "SSD");
        this.b = bVar;
        this.f39558a = jVar;
        if (bVar instanceof SplashAd) {
            SplashAd splashAd = (SplashAd) bVar;
            setWidth(splashAd.getWidth());
            setHeight(splashAd.getHeight());
        }
    }

    public static void a(k kVar, com.kc.dw.ad.splash.c cVar, boolean z) {
        kVar.getClass();
        try {
            if (cVar.b.getAdPatternType() != 1 && cVar.b.getAdPatternType() != 12) {
                if (cVar.b.getAdPatternType() != 2) {
                    return;
                }
                if (!cVar.g && !z) {
                    return;
                }
                NormalMediaView normalMediaView = cVar.d;
                if (normalMediaView != null) {
                    normalMediaView.c();
                }
            }
            kVar.c();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void c() {
        try {
            View view = this.adView;
            if (view != null) {
                try {
                    if (view instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view;
                        for (int i = 0; i < viewGroup.getChildCount(); i++) {
                            View childAt = viewGroup.getChildAt(i);
                            if (childAt instanceof SsdSplashRootView) {
                                for (int i2 = 0; i2 < ((SsdSplashRootView) childAt).getChildCount(); i2++) {
                                    View childAt2 = ((SsdSplashRootView) childAt).getChildAt(i);
                                    if (childAt2 instanceof GifImageView) {
                                        ((GifImageView) childAt2).clear();
                                        break;
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ViewParent parent = this.adView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.adView);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public ResultBean getData() {
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setCid(((com.kc.dw.ad.splash.d) this.f39558a.f39477a).getCid());
            resultBean.setCat(((com.kc.dw.ad.splash.d) this.f39558a.f39477a).getCat());
            resultBean.setAderId(((com.kc.dw.ad.splash.d) this.f39558a.f39477a).getAder_id());
            resultBean.setFromId(((com.kc.dw.ad.splash.d) this.f39558a.f39477a).getFromId());
            resultBean.setDrawing(((com.kc.dw.ad.splash.d) this.f39558a.f39477a).getDrawing());
            resultBean.setPid(((com.kc.dw.ad.splash.d) this.f39558a.f39477a).getPosId());
            resultBean.setInteractionType(((com.kc.dw.ad.splash.d) this.f39558a.f39477a).getInteractionType());
            resultBean.setReqId(((com.kc.dw.ad.splash.d) this.f39558a.f39477a).getReq_id());
            resultBean.setPrice(((com.kc.dw.ad.splash.d) this.f39558a.f39477a).getEcpm());
            resultBean.setEcpm(((com.kc.dw.ad.splash.d) this.f39558a.f39477a).getEcpm() + "");
            resultBean.setS_ext(((com.kc.dw.ad.splash.d) this.f39558a.f39477a).getS_ext());
            resultBean.setS_code(((com.kc.dw.ad.splash.d) this.f39558a.f39477a).getS_code());
            resultBean.setAdInfo(com.kc.dw.core.utils.a.a((BaseAdSlot) this.f39558a.f39477a));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        resultBean.setSdkName("SSD");
        return resultBean;
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public boolean isAdValid() {
        try {
            int expire_timestamp = ((com.kc.dw.ad.splash.d) this.f39558a.f39477a).getExpire_timestamp();
            return SystemClock.uptimeMillis() - ((com.kc.dw.ad.splash.d) this.f39558a.f39477a).getLoadedTime() < (expire_timestamp <= 0 ? 1740000L : (long) (expire_timestamp * 1000));
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    @Override // com.kc.dw.core.ad.splash.SplashAd, com.kc.dw.core.ad.splash.ISplashAd
    public void render() {
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.s2s.ISBidding
    public void sendLossNotification(Map map) {
        com.kc.dw.core.s2s.a.a(this.f39558a.getContext(), ((com.kc.dw.ad.splash.c) this.b).b.getLossUrl(), map);
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.s2s.ISBidding
    public void sendWinNotification(Map map) {
        com.kc.dw.core.s2s.a.b(this.f39558a.getContext(), ((com.kc.dw.ad.splash.c) this.b).b.getWinUrl(), map);
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public void setInteractionListener(InteractionListener interactionListener) {
        super.setInteractionListener(interactionListener);
        ((com.kc.dw.core.ad.a) this.b).setInteractionListener(interactionListener);
    }

    @Override // com.kc.dw.core.ad.splash.SplashAd, com.kc.dw.core.ad.splash.ISplashAd
    public void setSplashFinishingTouchListener(ISplashFinishingTouchListener iSplashFinishingTouchListener) {
        super.setSplashFinishingTouchListener(iSplashFinishingTouchListener);
        View view = this.adView;
        if (view != null) {
            try {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        View childAt = viewGroup.getChildAt(i);
                        if (childAt instanceof SsdSplashRootView) {
                            for (int i2 = 0; i2 < ((SsdSplashRootView) childAt).getChildCount(); i2++) {
                                View childAt2 = ((SsdSplashRootView) childAt).getChildAt(i);
                                if (childAt2 instanceof GifImageView) {
                                    ((GifImageView) childAt2).setCanClear(false);
                                    break;
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.kc.dw.core.ad.splash.SplashAd, com.kc.dw.core.ad.splash.ISplashAd
    public void showAd(ViewGroup viewGroup) {
        try {
            try {
                if (viewGroup == null) {
                    try {
                        s1.a(((com.kc.dw.ad.splash.c) this.b).b.getErrorUrl(), 12, 9000002, "adContainer 为空");
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                try {
                    Gson gson = new Gson();
                    HashMap map = new HashMap();
                    map.put("stepNum", 1);
                    map.put("msg", "showAd invoke");
                    com.kc.dw.ad.splash.b bVar = this.b;
                    if (((com.kc.dw.ad.splash.c) bVar).b instanceof com.kc.dw.ad.splash.d) {
                        map.put("creativeType", Integer.valueOf(((com.kc.dw.ad.splash.c) bVar).b.getAdPatternType()));
                    }
                    s1.a(((com.kc.dw.ad.splash.c) this.b).b.getErrorUrl(), gson.toJson(map));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (this.c) {
                    try {
                        s1.a(((com.kc.dw.ad.splash.c) this.b).b.getErrorUrl(), 12, 9000002, "重复调用showAd");
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    LogUtil.e("MeishuSplashAd", "ad has been called show");
                    return;
                }
                com.kc.dw.ad.splash.b bVar2 = this.b;
                if (bVar2 instanceof com.kc.dw.ad.splash.c) {
                    viewGroup.removeAllViews();
                    ((com.kc.dw.ad.splash.c) this.b).showAd(viewGroup);
                    this.c = true;
                    return;
                } else {
                    try {
                        s1.a(((com.kc.dw.ad.splash.c) bVar2).b.getErrorUrl(), 12, 9000002, "nativeAd 不是SplashAdImpl实例");
                        return;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        return;
                    }
                }
            } catch (Throwable th) {
                s1.a(((com.kc.dw.ad.splash.c) this.b).b.getErrorUrl(), 12, 9000001, th.getMessage());
                th.printStackTrace();
            }
            s1.a(((com.kc.dw.ad.splash.c) this.b).b.getErrorUrl(), 12, 9000001, th.getMessage());
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        th.printStackTrace();
    }

    @Override // com.kc.dw.core.ad.splash.SplashAd, com.kc.dw.core.ad.splash.ISplashAd
    public void splashAnimationFinish() {
        try {
            com.kc.dw.ad.splash.b bVar = this.b;
            if (bVar == null || !(bVar instanceof com.kc.dw.ad.splash.c)) {
                return;
            }
            com.kc.dw.ad.splash.c cVar = (com.kc.dw.ad.splash.c) bVar;
            cVar.h = true;
            SsdSplashRootView ssdSplashRootView = cVar.e;
            ImageView imageView = (ImageView) ssdSplashRootView.findViewById(R.id.ms_click_eye_close);
            ssdSplashRootView.findViewById(R.id.ssd_skipView).setVisibility(8);
            imageView.setVisibility(0);
            imageView.setOnClickListener(new a(this, cVar));
            ssdSplashRootView.setOnClickListener(new b(this, cVar));
            new Handler(Looper.getMainLooper()).postDelayed(new c(this, cVar), 5000L);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
