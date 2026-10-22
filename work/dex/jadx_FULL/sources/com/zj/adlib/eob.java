package com.zj.adlib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.col.p0003l.it;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class eob extends Thread {
    public static int K = 0;
    public static int L = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f41484a = 30000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f16372a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public IAMapDelegate f16374a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WeakReference<Context> f16376a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f16375a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Handler f16373a = new a(Looper.getMainLooper());

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (eob.f16372a) {
                return;
            }
            if (eob.this.f16375a == null) {
                eob eobVar = eob.this;
                eobVar.f16375a = new b(eobVar.f16374a, eob.this.f16376a == null ? null : (Context) eob.this.f16376a.get());
            }
            ywa.a().b(eob.this.f16375a);
        }
    }

    public static class b extends it {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public eqb f41486a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public WeakReference<IAMapDelegate> f16377a;
        public WeakReference<Context> b;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ IAMapDelegate f41487a;

            public a(IAMapDelegate iAMapDelegate) {
                this.f41487a = iAMapDelegate;
            }

            @Override // java.lang.Runnable
            public final void run() {
                IAMapDelegate iAMapDelegate = this.f41487a;
                if (iAMapDelegate == null || iAMapDelegate.getMapConfig() == null) {
                    return;
                }
                MapConfig mapConfig = this.f41487a.getMapConfig();
                mapConfig.setProFunctionAuthEnable(false);
                if (mapConfig.isUseProFunction()) {
                    this.f41487a.setMapCustomEnable(mapConfig.isCustomStyleEnable(), true);
                    this.f41487a.reloadMapCustomStyle();
                    dva.b(b.this.b == null ? null : (Context) b.this.b.get(), "鉴权失败，当前key没有自定义纹理的使用权限，自定义纹理相关内容，将不会呈现！");
                }
            }
        }

        public b(IAMapDelegate iAMapDelegate, Context context) {
            this.f16377a = null;
            this.b = null;
            this.f16377a = new WeakReference<>(iAMapDelegate);
            if (context != null) {
                this.b = new WeakReference<>(context);
            }
        }

        @Override // com.amap.api.col.p0003l.it
        public final void runTask() {
            eqb.a aVarM;
            WeakReference<Context> weakReference;
            try {
                if (eob.f16372a) {
                    return;
                }
                if (this.f41486a == null && (weakReference = this.b) != null && weakReference.get() != null) {
                    this.f41486a = new eqb(this.b.get(), "");
                }
                eob.c();
                if (eob.K > eob.L) {
                    eob.h();
                    a();
                    return;
                }
                eqb eqbVar = this.f41486a;
                if (eqbVar == null || (aVarM = eqbVar.m()) == null) {
                    return;
                }
                if (!aVarM.f16389a) {
                    a();
                }
                eob.h();
            } catch (Throwable th) {
                a7b.m(th, "authForPro", "loadConfigData_uploadException");
                bxa.l(axa.c, "auth exception get data " + th.getMessage());
            }
        }

        public final void a() {
            IAMapDelegate iAMapDelegate;
            WeakReference<IAMapDelegate> weakReference = this.f16377a;
            if (weakReference == null || weakReference.get() == null || (iAMapDelegate = this.f16377a.get()) == null || iAMapDelegate.getMapConfig() == null) {
                return;
            }
            iAMapDelegate.queueEvent(new a(iAMapDelegate));
        }
    }

    public eob(Context context, IAMapDelegate iAMapDelegate) {
        this.f16376a = null;
        if (context != null) {
            this.f16376a = new WeakReference<>(context);
        }
        this.f16374a = iAMapDelegate;
        i();
    }

    public static /* synthetic */ int c() {
        int i = K;
        K = i + 1;
        return i;
    }

    public static /* synthetic */ boolean h() {
        f16372a = true;
        return true;
    }

    public static void i() {
        K = 0;
        f16372a = false;
    }

    @Override // java.lang.Thread
    public final void interrupt() {
        this.f16374a = null;
        this.f16376a = null;
        Handler handler = this.f16373a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.f16373a = null;
        this.f16375a = null;
        i();
        super.interrupt();
    }

    public final void j() {
        if (f16372a) {
            return;
        }
        int i = 0;
        while (i <= L) {
            i++;
            this.f16373a.sendEmptyMessageDelayed(0, ((long) i) * f41484a);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            j();
        } catch (Throwable th) {
            a7b.m(th, "AMapDelegateImpGLSurfaceView", "mVerfy");
            th.printStackTrace();
            bxa.l(axa.c, "auth pro exception " + th.getMessage());
        }
    }
}
