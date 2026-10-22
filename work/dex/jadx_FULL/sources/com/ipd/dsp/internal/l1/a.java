package com.ipd.dsp.internal.l1;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.ipd.dsp.DspConfig;
import com.ipd.dsp.api.DspLoadManager;
import com.ipd.dsp.api.IDsp;
import com.ipd.dsp.internal.c2.f;
import com.ipd.dsp.internal.c2.g;
import com.ipd.dsp.internal.c2.k;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a implements IDsp {
    public static final String j = "IPDDsp";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f38402a;
    public boolean b;
    public String c;

    @Nullable
    public Context d;

    @Nullable
    public DspLoadManager e;
    public volatile boolean f;
    public boolean g;
    public boolean h;
    public String i;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f38403a = new a();
    }

    public static a a() {
        return b.f38403a;
    }

    public final void b() {
    }

    @Override // com.ipd.dsp.api.IDsp
    public DspLoadManager getAdManager() {
        if (this.e == null) {
            this.e = new com.ipd.dsp.internal.l1.b();
        }
        return this.e;
    }

    @Override // com.ipd.dsp.api.IDsp
    public String getAppId() {
        if (!TextUtils.isEmpty(this.c)) {
            return this.c;
        }
        k.b(j, "dsp is not init mAppId is empty:" + this.f38402a);
        return "";
    }

    @Override // com.ipd.dsp.api.IDsp
    @Nullable
    public Context getContext() {
        if (this.d == null) {
            k.b(j, "getContext is null, mIsSdkInit:" + this.f38402a, new RuntimeException().fillInStackTrace());
        }
        return this.d;
    }

    @Override // com.ipd.dsp.api.IDsp
    public boolean getPersonalRecommend() {
        return this.f;
    }

    @Override // com.ipd.dsp.api.IDsp
    public boolean getProgrammaticRecommend() {
        return this.g;
    }

    @Override // com.ipd.dsp.api.IDsp
    public String getWxOpenId() {
        return this.i;
    }

    @Override // com.ipd.dsp.api.IDsp
    public synchronized void init(Context context, DspConfig dspConfig) {
        if (this.f38402a) {
            if (dspConfig != null) {
                this.f = dspConfig.personalRecommend;
                this.g = dspConfig.programmaticRecommend;
                g.a().b(dspConfig.customController);
                if (dspConfig.oaid != null) {
                    g.a().b(dspConfig.oaid);
                }
                a(dspConfig);
                return;
            }
            return;
        }
        if (context != null && dspConfig != null) {
            try {
                if (!TextUtils.isEmpty(dspConfig.appId)) {
                    k.a(j, "IPDDsp init appId = " + dspConfig.appId);
                    this.d = context.getApplicationContext();
                    this.b = dspConfig.isDebug;
                    this.c = dspConfig.appId;
                    this.f = dspConfig.personalRecommend;
                    this.g = dspConfig.programmaticRecommend;
                    this.h = dspConfig.httpsOnly;
                    this.i = dspConfig.wxOpenId;
                    a(this.d, dspConfig);
                    a(dspConfig);
                    this.f38402a = true;
                    b();
                    return;
                }
            } catch (Throwable th) {
                k.b(j, "Dsp init error", th);
                a(dspConfig, com.ipd.dsp.internal.f1.a.e(Log.getStackTraceString(th)));
                return;
            }
        }
        k.b(j, "Dsp init error, please check context and config item");
        a(dspConfig, com.ipd.dsp.internal.f1.a.d());
    }

    @Override // com.ipd.dsp.api.IDsp
    public boolean isDebug() {
        return this.b;
    }

    @Override // com.ipd.dsp.api.IDsp
    public boolean isHttpsOnly() {
        return this.h;
    }

    @Override // com.ipd.dsp.api.IDsp
    public void setPersonalRecommend(boolean z) {
        this.f = z;
    }

    @Override // com.ipd.dsp.api.IDsp
    public void setProgrammaticRecommend(boolean z) {
        this.g = z;
    }

    public a() {
        this.f38402a = false;
        this.f = true;
        this.g = true;
    }

    public final void a(Context context, DspConfig dspConfig) {
        com.ipd.dsp.internal.z1.a.a().a(dspConfig.hosts);
        g.a().a(dspConfig.customController);
        if (dspConfig.oaid != null) {
            g.a().b(dspConfig.oaid);
        }
        f.a().a(context);
        com.ipd.dsp.internal.u0.a.a().b();
    }

    public static void a(DspConfig dspConfig, com.ipd.dsp.internal.f1.a aVar) {
        if (dspConfig != null) {
            try {
                DspConfig.DspInitCallback dspInitCallback = dspConfig.initCallback;
                if (dspInitCallback != null) {
                    dspInitCallback.onFail(aVar.f38306a, aVar.b);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(DspConfig dspConfig) {
        if (dspConfig != null) {
            try {
                DspConfig.DspInitCallback dspInitCallback = dspConfig.initCallback;
                if (dspInitCallback != null) {
                    dspInitCallback.onSuccess();
                }
            } catch (Throwable unused) {
            }
        }
        if (dspConfig != null) {
            dspConfig.initCallback = null;
        }
    }
}
