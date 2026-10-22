package com.kc.cw.ad.internal.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.kc.cw.ad.internal.c.i;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static g f38928a;
    private ArrayList<a> b = new ArrayList<>();
    private Timer c;
    private boolean d;

    /* JADX INFO: renamed from: com.kc.cw.ad.internal.b.g$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final WeakReference f38929a;
        final g b;

        public AnonymousClass1(g gVar, WeakReference weakReference) {
            this.b = gVar;
            this.f38929a = weakReference;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Context context = (Context) this.f38929a.get();
            if (context != null) {
                while (!this.b.b.isEmpty() && this.b.b(context)) {
                    boolean z = false;
                    a aVar = (a) this.b.b.remove(0);
                    if (aVar.b < 3) {
                        new com.kc.cw.ad.internal.c.d(this, z, aVar) { // from class: com.kc.cw.ad.internal.b.g.1.1

                            /* JADX INFO: renamed from: a, reason: collision with root package name */
                            final a f38930a;
                            final AnonymousClass1 b;

                            {
                                this.b = this;
                                this.f38930a = aVar;
                            }

                            @Override // com.kc.cw.ad.internal.c.d
                            public String a() {
                                return this.f38930a.f38931a;
                            }

                            @Override // com.kc.cw.ad.internal.c.d
                            public void a(com.kc.cw.ad.internal.c.e eVar) {
                                if (eVar == null || (!eVar.a() && eVar.c() == i.CONNECTION_FAILURE)) {
                                    this.f38930a.b++;
                                    this.b.b.b.add(this.f38930a);
                                }
                            }
                        }.b();
                    }
                }
                if (!this.b.b.isEmpty()) {
                    return;
                }
            }
            this.b.a();
        }
    }

    @Keep
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f38931a;
        int b = 0;
        final g c;

        public a(g gVar, String str) {
            this.c = gVar;
            this.f38931a = str;
        }
    }

    private g(Context context) {
        if (context != null) {
            this.d = context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0;
        }
    }

    public static g a(Context context) {
        if (f38928a == null) {
            f38928a = new g(context);
        }
        return f38928a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Timer timer = this.c;
        if (timer != null) {
            timer.cancel();
            this.c = null;
        }
    }

    private void c(Context context) {
        if (this.c == null) {
            WeakReference weakReference = new WeakReference(context);
            Timer timer = new Timer();
            this.c = timer;
            timer.scheduleAtFixedRate(new AnonymousClass1(this, weakReference), 10000L, 10000L);
        }
    }

    public void a(String str, Context context) {
        synchronized (this) {
            this.b.add(new a(this, str));
            c(context);
        }
    }

    public boolean b(Context context) {
        if (!this.d) {
            return true;
        }
        if (context == null) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
