package com.kwad.library.solder.lib;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.by;
import com.zj.adlib.c49;
import com.zj.adlib.u15;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class i {

    @Nullable
    private static a aEA;
    private static volatile i aEx;
    private static Map<String, Integer> aEz = new ConcurrentHashMap(8);
    private e aEy;
    private volatile boolean mHasInit = false;

    public interface a {
        boolean DT();

        void b(String str, File file);

        void f(String str, Throwable th);

        int getCorePoolSize();

        int getMaxRetryCount();
    }

    private i() {
    }

    public static i DQ() {
        if (aEx == null) {
            synchronized (i.class) {
                if (aEx == null) {
                    aEx = new i();
                }
            }
        }
        return aEx;
    }

    public static boolean cA(String str) {
        try {
            Map<String, Integer> map = aEz;
            if (map != null) {
                return map.containsKey(str);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static ExecutorService df(int i) {
        return new ThreadPoolExecutor(i, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.library.solder.lib.i.1
            private final AtomicInteger poolNumber = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                try {
                    String name = thread.getName();
                    thread.setName(name + c49.f40900a);
                    i.aEz.put(name, 1);
                } catch (Throwable th) {
                    com.kwad.library.solder.lib.a.e("Sodler", Log.getStackTraceString(th));
                }
                return thread;
            }
        });
    }

    private synchronized void init(Context context) {
        if (this.mHasInit) {
            return;
        }
        com.kwad.library.solder.lib.ext.c.a aVarCI = new com.kwad.library.solder.lib.ext.c.a().cI("sodler");
        a aVar = aEA;
        com.kwad.library.solder.lib.ext.c.a aVarBz = aVarCI.di(aVar != null ? aVar.getMaxRetryCount() : 1).bz(false);
        a aVar2 = aEA;
        com.kwad.library.solder.lib.ext.c.a aVarBA = aVarBz.bA(aVar2 != null && aVar2.DT());
        a aVar3 = aEA;
        com.kwad.library.solder.lib.ext.c.a aVarA = aVarBA.a(df(aVar3 != null ? aVar3.getCorePoolSize() : 0));
        a aVar4 = aEA;
        com.kwad.library.solder.lib.ext.c cVarEw = aVarA.dj(aVar4 != null ? aVar4.getCorePoolSize() : 0).Ew();
        d dVar = new d(context);
        c cVar = new c(context, cVarEw);
        f fVar = new f(context);
        fVar.a(new com.kwad.library.solder.lib.a.f.a() { // from class: com.kwad.library.solder.lib.i.2
            @Override // com.kwad.library.solder.lib.a.f.a
            public final void a(com.kwad.library.solder.lib.a.e eVar, File file) throws PluginError.UpdateError {
                if (i.aEA != null) {
                    try {
                        eVar.getDownloadUrl();
                        file.getAbsolutePath();
                        i.aEA.b(eVar.getDownloadUrl(), file);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        i.aEA.f(eVar.getDownloadUrl(), th);
                        throw new PluginError.UpdateError(th.getMessage(), 2010);
                    }
                }
            }
        });
        this.aEy = new e(dVar, fVar, cVar, cVarEw, new com.kwad.library.solder.lib.ext.a());
        this.mHasInit = true;
    }

    public final com.kwad.library.solder.lib.ext.c DK() {
        if (this.mHasInit) {
            return this.aEy.DK();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    public final void o(Context context, final String str) {
        if (!this.mHasInit && context != null) {
            init(context);
        }
        if (DK() == null || DK().Eu() == null) {
            return;
        }
        DK().Eu().execute(new Runnable() { // from class: com.kwad.library.solder.lib.i.4
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    i.this.aEy.DN().cw(str);
                } catch (Throwable th) {
                    Log.getStackTraceString(th);
                }
            }
        });
    }

    @Nullable
    public final com.kwad.library.solder.lib.a.a p(Context context, String str) {
        if (!this.mHasInit && context != null) {
            init(context);
        }
        e eVar = this.aEy;
        if (eVar != null) {
            return eVar.DL().cy(str);
        }
        return null;
    }

    public static void a(a aVar) {
        aEA = aVar;
    }

    public final <P extends com.kwad.library.solder.lib.a.a, R extends com.kwad.library.solder.lib.a.e<P>> void a(Context context, @NonNull R r, com.kwad.library.solder.lib.ext.b<P, R> bVar) {
        init(context);
        r.dh(this.aEy.DK().getRetryCount());
        r.a(new b<P, R>(bVar, new com.kwad.library.solder.lib.ext.b.C1264b()) { // from class: com.kwad.library.solder.lib.i.3
            /* JADX WARN: Incorrect types in method signature: (TR;Lcom/kwad/library/solder/lib/ext/PluginError;)V */
            @Override // com.kwad.library.solder.lib.b, com.kwad.library.solder.lib.ext.b
            public final void a(final com.kwad.library.solder.lib.a.e eVar, PluginError pluginError) {
                super.a(eVar, pluginError);
                com.kwad.library.solder.lib.a.e("Sodler", "load failed:" + pluginError.getCode() + u15.f19942b + pluginError.getMessage());
                i.this.aEy.i(eVar);
                by.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.library.solder.lib.i.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (eVar.Ea()) {
                            i.this.aEy.a(eVar, 16);
                        }
                    }
                }, eVar.DZ() instanceof PluginError.UpdateError ? 1000L : 0L);
            }
        });
        this.aEy.a(r, 16);
    }
}
