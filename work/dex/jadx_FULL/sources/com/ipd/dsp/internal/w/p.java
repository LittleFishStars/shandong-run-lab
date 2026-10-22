package com.ipd.dsp.internal.w;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.igexin.sdk.PushConsts;
import com.ipd.dsp.Dsp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class p {
    public static volatile p d = null;
    public static final String e = "ConnectivityMonitor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f38585a;

    @GuardedBy("this")
    public final Set<com.ipd.dsp.internal.w.b.a> b = new HashSet();

    @GuardedBy("this")
    public boolean c;

    public class a implements com.ipd.dsp.internal.d0.h.b<ConnectivityManager> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f38586a;

        public a(Context context) {
            this.f38586a = context;
        }

        @Override // com.ipd.dsp.internal.d0.h.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ConnectivityManager get() {
            return (ConnectivityManager) this.f38586a.getSystemService("connectivity");
        }
    }

    public class b implements com.ipd.dsp.internal.w.b.a {
        public b() {
        }

        @Override // com.ipd.dsp.internal.w.b.a
        public void a(boolean z) {
            ArrayList arrayList;
            com.ipd.dsp.internal.d0.o.b();
            synchronized (p.this) {
                arrayList = new ArrayList(p.this.b);
            }
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((com.ipd.dsp.internal.w.b.a) obj).a(z);
            }
        }
    }

    public interface c {
        void a();

        boolean b();
    }

    @RequiresApi(24)
    public static final class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f38588a;
        public final com.ipd.dsp.internal.w.b.a b;
        public final com.ipd.dsp.internal.d0.h.b<ConnectivityManager> c;
        public final ConnectivityManager.NetworkCallback d = new a();

        public class a extends ConnectivityManager.NetworkCallback {

            /* JADX INFO: renamed from: com.ipd.dsp.internal.w.p$d$a$a, reason: collision with other inner class name */
            public class RunnableC0926a implements Runnable {
                public final /* synthetic */ boolean f;

                public RunnableC0926a(boolean z) {
                    this.f = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(this.f);
                }
            }

            public a() {
            }

            public void a(boolean z) {
                com.ipd.dsp.internal.d0.o.b();
                d dVar = d.this;
                boolean z2 = dVar.f38588a;
                dVar.f38588a = z;
                if (z2 != z) {
                    dVar.b.a(z);
                }
            }

            public final void b(boolean z) {
                com.ipd.dsp.internal.d0.o.a(new RunnableC0926a(z));
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(@NonNull Network network) {
                b(true);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(@NonNull Network network) {
                b(false);
            }
        }

        public d(com.ipd.dsp.internal.d0.h.b<ConnectivityManager> bVar, com.ipd.dsp.internal.w.b.a aVar) {
            this.c = bVar;
            this.b = aVar;
        }

        @Override // com.ipd.dsp.internal.w.p.c
        public void a() {
            this.c.get().unregisterNetworkCallback(this.d);
        }

        @Override // com.ipd.dsp.internal.w.p.c
        @SuppressLint({"MissingPermission"})
        public boolean b() {
            this.f38588a = this.c.get().getActiveNetwork() != null;
            try {
                this.c.get().registerDefaultNetworkCallback(this.d);
                return true;
            } catch (RuntimeException e) {
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.e("ConnectivityMonitor", "Failed to register callback", e);
                }
                return false;
            }
        }
    }

    public static final class e implements c {
        public static final Executor g = AsyncTask.SERIAL_EXECUTOR;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f38590a;
        public final com.ipd.dsp.internal.w.b.a b;
        public final com.ipd.dsp.internal.d0.h.b<ConnectivityManager> c;
        public volatile boolean d;
        public volatile boolean e;
        public final BroadcastReceiver f = new a();

        public class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(@NonNull Context context, Intent intent) {
                e.this.d();
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.d = eVar.c();
                try {
                    e eVar2 = e.this;
                    eVar2.f38590a.registerReceiver(eVar2.f, new IntentFilter(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
                    e.this.e = true;
                } catch (SecurityException e) {
                    if (Dsp.isDebugLogEnable()) {
                        com.ipd.dsp.internal.c2.k.e("ConnectivityMonitor", "Failed to register", e);
                    }
                    e.this.e = false;
                }
            }
        }

        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.e) {
                    e.this.e = false;
                    e eVar = e.this;
                    eVar.f38590a.unregisterReceiver(eVar.f);
                }
            }
        }

        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z = e.this.d;
                e eVar = e.this;
                eVar.d = eVar.c();
                if (z != e.this.d) {
                    if (Dsp.isDebugLogEnable()) {
                        com.ipd.dsp.internal.c2.k.a("ConnectivityMonitor", "connectivity changed, isConnected: " + e.this.d);
                    }
                    e eVar2 = e.this;
                    eVar2.a(eVar2.d);
                }
            }
        }

        /* JADX INFO: renamed from: com.ipd.dsp.internal.w.p$e$e, reason: collision with other inner class name */
        public class RunnableC0927e implements Runnable {
            public final /* synthetic */ boolean f;

            public RunnableC0927e(boolean z) {
                this.f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.b.a(this.f);
            }
        }

        public e(Context context, com.ipd.dsp.internal.d0.h.b<ConnectivityManager> bVar, com.ipd.dsp.internal.w.b.a aVar) {
            this.f38590a = context.getApplicationContext();
            this.c = bVar;
            this.b = aVar;
        }

        @Override // com.ipd.dsp.internal.w.p.c
        public void a() {
            g.execute(new c());
        }

        @Override // com.ipd.dsp.internal.w.p.c
        public boolean b() {
            g.execute(new b());
            return true;
        }

        @SuppressLint({"MissingPermission"})
        public boolean c() {
            try {
                NetworkInfo activeNetworkInfo = this.c.get().getActiveNetworkInfo();
                return activeNetworkInfo != null && activeNetworkInfo.isConnected();
            } catch (RuntimeException e) {
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.e("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e);
                }
                return true;
            }
        }

        public void d() {
            g.execute(new d());
        }

        public void a(boolean z) {
            com.ipd.dsp.internal.d0.o.a(new RunnableC0927e(z));
        }
    }

    public p(@NonNull Context context) {
        this.f38585a = new d(com.ipd.dsp.internal.d0.h.a(new a(context)), new b());
    }

    public static p a(@NonNull Context context) {
        if (d == null) {
            synchronized (p.class) {
                if (d == null) {
                    d = new p(context.getApplicationContext());
                }
            }
        }
        return d;
    }

    @VisibleForTesting
    public static void c() {
        d = null;
    }

    public synchronized void b(com.ipd.dsp.internal.w.b.a aVar) {
        this.b.remove(aVar);
        b();
    }

    @GuardedBy("this")
    public final void b() {
        if (this.c && this.b.isEmpty()) {
            this.f38585a.a();
            this.c = false;
        }
    }

    public synchronized void a(com.ipd.dsp.internal.w.b.a aVar) {
        this.b.add(aVar);
        a();
    }

    @GuardedBy("this")
    public final void a() {
        if (this.c || this.b.isEmpty()) {
            return;
        }
        this.c = this.f38585a.b();
    }
}
