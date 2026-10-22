package com.kc.dw.platform.ad_adapter.splash;

import android.text.TextUtils;
import android.view.View;
import com.google.gson.Gson;
import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.ad.splash.SplashAdListener;
import com.kc.dw.core.router.log.bean.ShowAdState;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.SdkHandler;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.s1;
import com.kc.dw.core.utils.t0;
import com.kc.dw.core.utils.z;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class e implements com.kc.dw.ad.splash.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String[] f39548a;
    public SplashAdListener b;
    public j c;
    public k d;
    public boolean e;
    public boolean f;
    public final com.kc.dw.ad.k g;
    public boolean h;
    public View i;
    public c j;

    @Keep
    public class a extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f39549a;

        /* JADX INFO: renamed from: com.kc.dw.platform.ad_adapter.splash.e$a$a, reason: collision with other inner class name */
        @Keep
        public class C1075a extends com.kc.dw.core.safe.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final a f39550a;

            public C1075a(a aVar) {
                this.f39550a = aVar;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                try {
                    e eVar = this.f39550a.f39549a;
                    SplashAdListener splashAdListener = eVar.b;
                    if (splashAdListener != null) {
                        splashAdListener.onAdPresent(eVar.d);
                        this.f39550a.f39549a.b.onAdExposure();
                    }
                    k kVar = this.f39550a.f39549a.d;
                    if (kVar != null && kVar.getInteractionListener() != null) {
                        this.f39550a.f39549a.d.getInteractionListener().onAdExposure();
                    }
                    c cVar = this.f39550a.f39549a.j;
                    if (cVar != null) {
                        cVar.onExposure();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        public a(e eVar) {
            this.f39549a = eVar;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            try {
                e eVar = this.f39549a;
                j jVar = eVar.c;
                if (jVar != null) {
                    t0.a(((com.kc.dw.ad.splash.d) jVar.f39477a).getPosId(), 3);
                    String[] monitorUrl = ((com.kc.dw.ad.splash.d) this.f39549a.c.f39477a).getMonitorUrl();
                    com.kc.dw.ad.k kVar = this.f39549a.g;
                    if (kVar != null) {
                        g0.b(monitorUrl, kVar.a());
                    }
                    try {
                        if (e.a(this.f39549a) == AdType.SPLASH.value()) {
                            g0.a(monitorUrl, this.f39549a.i, (View) null);
                        } else {
                            g0.a(monitorUrl, this.f39549a.i.findViewById(R.id.activity_sdk_splash_mediaContainer), this.f39549a.i);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (monitorUrl != null) {
                        LogUtil.d("SplashAdListenerAdapter", "send onADExposure");
                        for (String str : monitorUrl) {
                            if (!TextUtils.isEmpty(str)) {
                                z.a(this.f39549a.c.getContext(), g0.a(g0.a(g0.a(str, ((com.kc.dw.ad.splash.d) this.f39549a.c.f39477a).getAct_type(), AdType.SPLASH), this.f39549a.i.getWidth(), this.f39549a.i.getHeight())), new com.kc.dw.core.utils.j());
                            }
                        }
                    } else {
                        try {
                            s1.a(this.f39549a.f39548a, 12, 9000002, "monitorUrls 为空");
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                        }
                    }
                } else {
                    try {
                        s1.a(eVar.f39548a, 12, 9000002, "adWrapper 为空");
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            SdkHandler.getInstance().runOnUiThread(new C1075a(this));
        }
    }

    @Keep
    public class b extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f39551a;
        public final String b;
        public final e c;

        public b(e eVar, int i, String str) {
            this.c = eVar;
            this.f39551a = i;
            this.b = str;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            try {
                j jVar = this.c.c;
                if (jVar != null && ((com.kc.dw.ad.splash.d) jVar.f39477a).getErrorUrl() != null) {
                    z.a(((com.kc.dw.ad.splash.d) this.c.c.f39477a).getErrorUrl()[0], Integer.valueOf(this.f39551a), this.b);
                }
                SplashAdListener splashAdListener = this.c.b;
                if (splashAdListener != null) {
                    splashAdListener.onAdRenderFail(this.b, this.f39551a);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Keep
    public interface c {
        void onExposure();
    }

    public e(j jVar, SplashAdListener splashAdListener, boolean z, com.kc.dw.ad.k kVar) {
        this.c = jVar;
        this.b = splashAdListener;
        this.f = z;
        this.g = kVar;
        try {
            this.f39548a = jVar.a().getErrorUrl();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int a(e eVar) {
        T t;
        int ad_type;
        j jVar = eVar.c;
        return (jVar == null || (t = jVar.f39477a) == 0 || (ad_type = ((com.kc.dw.ad.splash.d) t).getAd_type()) == 0) ? AdType.SPLASH.value() : ad_type;
    }

    public final Integer a() {
        T t;
        j jVar = this.c;
        if (jVar == null || (t = jVar.f39477a) == 0) {
            return null;
        }
        return Integer.valueOf(((com.kc.dw.ad.splash.d) t).getAdPatternType());
    }

    @Override // com.kc.dw.ad.z
    public void onADExposure() {
        try {
            try {
                Gson gson = new Gson();
                HashMap map = new HashMap();
                map.put("stepNum", 6);
                map.put("msg", "start exposure");
                Integer numA = a();
                if (numA != null) {
                    map.put("creativeType", numA);
                }
                map.put("adView", this.i != null ? 1 : 0);
                map.put("hasExposed", this.e ? 1 : 0);
                map.put("adWrapper", this.c != null ? 1 : 0);
                s1.a(this.f39548a, gson.toJson(map));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.e) {
                try {
                    s1.a(this.f39548a, 12, 9000002, "已经曝光，hasExposed=true");
                    return;
                } catch (Exception e2) {
                    e = e2;
                }
            } else {
                View view = this.i;
                if (view != null) {
                    this.e = true;
                    view.post(new a(this));
                    return;
                } else {
                    try {
                        s1.a(this.f39548a, 12, 9000002, "adView 为空");
                        com.kc.dw.core.service.logrecord.a.a(5, "f7", this.c, new ShowAdState().setFail(1, 9000002, "adView 为空"));
                        return;
                    } catch (Exception e3) {
                        e = e3;
                    }
                }
            }
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kc.dw.ad.z
    public void onAdRenderFail(String str, int i) {
        SdkHandler.getInstance().runOnUiThread(new b(this, i, str));
    }
}
