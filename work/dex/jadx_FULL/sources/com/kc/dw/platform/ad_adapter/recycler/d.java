package com.kc.dw.platform.ad_adapter.recycler;

import android.content.Context;
import android.text.TextUtils;
import com.kc.dw.core.ad.AdSlot;
import com.kc.dw.core.ad.recycler.NativeAdMediaListener;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.z;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class d implements com.kc.dw.ad.nativ.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NativeAdMediaListener f39488a;
    public Context b = com.kc.dw.base.a.getContext();
    public com.kc.dw.ad.nativ.i c;
    public boolean d;

    public d(com.kc.dw.ad.nativ.i iVar, NativeAdMediaListener nativeAdMediaListener) {
        this.c = iVar;
        this.f39488a = nativeAdMediaListener;
    }

    public void a() {
        try {
            LogUtil.d("MeishuAdMediaListenerAdapter", "send onVideoComplete");
            String[] strArr = this.c.n;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(this.b, g0.a(str), new com.kc.dw.core.utils.j());
                    }
                }
            }
            NativeAdMediaListener nativeAdMediaListener = this.f39488a;
            if (nativeAdMediaListener != null) {
                nativeAdMediaListener.onVideoCompleted();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void b() {
        try {
            LogUtil.d("MeishuAdMediaListenerAdapter", "send onVideoOneHalf");
            String[] strArr = this.c.l;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(this.b, g0.a(str), new com.kc.dw.core.utils.j());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void c() {
        try {
            LogUtil.d("MeishuAdMediaListenerAdapter", "send onVideoOneQuarter");
            String[] strArr = this.c.k;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(this.b, g0.a(str), new com.kc.dw.core.utils.j());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void d() {
        try {
            LogUtil.d("MeishuAdMediaListenerAdapter", "send onVideoPause");
            String[] strArr = this.c.o;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(this.b, g0.a(str), new com.kc.dw.core.utils.j());
                    }
                }
            }
            NativeAdMediaListener nativeAdMediaListener = this.f39488a;
            if (nativeAdMediaListener != null) {
                nativeAdMediaListener.onVideoPause();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void e() {
        try {
            LogUtil.d("MeishuAdMediaListenerAdapter", "send onVideoResume");
            String[] strArr = this.c.p;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(this.b, g0.a(str), new com.kc.dw.core.utils.j());
                    }
                }
            }
            NativeAdMediaListener nativeAdMediaListener = this.f39488a;
            if (nativeAdMediaListener != null) {
                nativeAdMediaListener.onVideoResume();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void f() {
        try {
            if (com.kc.dw.core.utils.a.b((AdSlot) this.c)) {
                LogUtil.dev("MeishuAdMediaListenerAdapter", "has video start. return");
                return;
            }
            if (!this.d) {
                LogUtil.d("MeishuAdMediaListenerAdapter", "send onVideoStart");
                this.d = true;
                this.c.setHasVideoStart(true);
                String[] strArr = this.c.j;
                if (strArr != null) {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str)) {
                            z.a(this.b, g0.a(str), new com.kc.dw.core.utils.j());
                        }
                    }
                }
            }
            NativeAdMediaListener nativeAdMediaListener = this.f39488a;
            if (nativeAdMediaListener != null) {
                nativeAdMediaListener.onVideoStart();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void g() {
        try {
            LogUtil.d("MeishuAdMediaListenerAdapter", "send onVideoThreeQuarter");
            String[] strArr = this.c.m;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(this.b, g0.a(str), new com.kc.dw.core.utils.j());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
