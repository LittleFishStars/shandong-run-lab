package cn.jy.ad.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import cn.jy.ad.sdk.jyact.JYTD;
import cn.jy.ad.sdk.jycfg.JyConfig;
import cn.jy.ad.sdk.jyinter.IEventProcessor;
import cn.jy.ad.sdk.jyinter.IJyAdSdk;
import cn.jy.ad.sdk.jyinter.ILoader;
import cn.jy.ad.sdk.jyinter.JyAdNative;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Future<?> f22764a;
    public IJyAdSdk b;
    public ClassLoader c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f22765a;
        public final /* synthetic */ JyConfig b;

        public a(Context context, JyConfig jyConfig) {
            this.f22765a = context;
            this.b = jyConfig;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (g.this.b == null) {
                    g gVar = g.this;
                    gVar.b = gVar.b(this.f22765a);
                    g.this.b.init(this.f22765a, cn.jy.ad.sdk.a.a(this.b));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            g.this.f22764a = null;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ cn.jy.ad.sdk.b f22766a;

        public b(cn.jy.ad.sdk.b bVar) {
            this.f22766a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (g.this.f22764a != null) {
                    g.this.f22764a.get();
                }
            } catch (Throwable unused) {
            }
            if (g.this.b != null) {
                g.this.b(this.f22766a);
            } else {
                g.this.a(this.f22766a);
            }
        }
    }

    public class c implements cn.jy.ad.sdk.e<cn.jy.ad.sdk.e<ILoader>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ILoader f22767a;
        public final /* synthetic */ SoftReference b;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ cn.jy.ad.sdk.e f22768a;

            public a(cn.jy.ad.sdk.e eVar) {
                this.f22768a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (g.this.f22764a != null) {
                        g.this.f22764a.get();
                    }
                } catch (Throwable unused) {
                }
                if (g.this.b != null) {
                    try {
                        c cVar = c.this;
                        cVar.f22767a = g.this.b.createLoader((Context) c.this.b.get());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                cn.jy.ad.sdk.e eVar = this.f22768a;
                if (eVar != null) {
                    eVar.a(c.this.f22767a);
                }
            }
        }

        public c(SoftReference softReference) {
            this.b = softReference;
        }

        @Override // cn.jy.ad.sdk.e
        public void a(cn.jy.ad.sdk.e<ILoader> eVar) {
            ILoader iLoader = this.f22767a;
            if (iLoader == null) {
                h.a().execute(new a(eVar));
            } else if (eVar != null) {
                eVar.a(iLoader);
            }
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ cn.jy.ad.sdk.b f22769a;

        public d(g gVar, cn.jy.ad.sdk.b bVar) {
            this.f22769a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            cn.jy.ad.sdk.b bVar = this.f22769a;
            if (bVar != null) {
                bVar.onFail(10002, "SDK初始化错误");
            }
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ cn.jy.ad.sdk.b f22770a;

        public e(g gVar, cn.jy.ad.sdk.b bVar) {
            this.f22770a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            cn.jy.ad.sdk.b bVar = this.f22770a;
            if (bVar != null) {
                bVar.onSuccess();
            }
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f22771a = new g();
    }

    public static g a() {
        return f.f22771a;
    }

    public JYTD a(Activity activity) {
        return (JYTD) this.c.loadClass(activity.getIntent().getStringExtra("activityImp")).newInstance();
    }

    public synchronized JyAdNative a(Context context) {
        return new cn.jy.ad.sdk.f(new c(new SoftReference(context)));
    }

    public void a(int i, Throwable th) {
        try {
            HashMap map = new HashMap();
            map.put("type", 1);
            map.put("code", Integer.valueOf(i));
            map.put("detail", th);
            IEventProcessor iEventProcessorC = c();
            if (iEventProcessorC != null) {
                iEventProcessorC.processEvent(map);
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized void a(Context context, JyConfig jyConfig) {
        if (this.b != null) {
            return;
        }
        if (this.f22764a == null) {
            this.f22764a = h.a().submit(new a(context, jyConfig));
        }
    }

    public final void a(cn.jy.ad.sdk.b bVar) {
        h.a(new d(this, bVar));
    }

    public final cn.jy.ad.sdk.c b() {
        return new i();
    }

    public final IJyAdSdk b(Context context) {
        ClassLoader classLoaderA = b().a(context, context.getClassLoader());
        this.c = classLoaderA;
        return (IJyAdSdk) classLoaderA.loadClass("cn.jy.ad.code.JySdkIter").getDeclaredMethod("create", Bundle.class).invoke(null, new Bundle());
    }

    public final void b(cn.jy.ad.sdk.b bVar) {
        h.a(new e(this, bVar));
    }

    public final IEventProcessor c() {
        IJyAdSdk iJyAdSdk = this.b;
        if (iJyAdSdk != null) {
            return iJyAdSdk.getEventProcessor();
        }
        return null;
    }

    public synchronized void c(cn.jy.ad.sdk.b bVar) {
        if (this.b != null) {
            b(bVar);
        } else {
            h.a().submit(new b(bVar));
        }
    }
}
