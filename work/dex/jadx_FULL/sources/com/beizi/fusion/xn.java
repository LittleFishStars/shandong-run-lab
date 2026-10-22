package com.beizi.fusion;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class xn {
    private static xn d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList f28038a = new ArrayList();
    private Timer b;
    private boolean c;

    public class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference f28039a;

        /* JADX INFO: renamed from: com.beizi.fusion.xn$a$a, reason: collision with other inner class name */
        public class AsyncTaskC0335a extends v8 {
            final /* synthetic */ b d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AsyncTaskC0335a(boolean z, boolean z2, b bVar) {
                super(z, z2);
                this.d = bVar;
            }

            @Override // com.beizi.fusion.v8
            public String a() {
                return this.d.f28040a;
            }

            @Override // android.os.AsyncTask
            public void onPostExecute(w8 w8Var) {
                if (w8Var == null || (!w8Var.d() && w8Var.b() == i9.CONNECTION_FAILURE)) {
                    b bVar = this.d;
                    bVar.b++;
                    xn.this.f28038a.add(bVar);
                }
            }
        }

        public a(WeakReference weakReference) {
            this.f28039a = weakReference;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Context context = (Context) this.f28039a.get();
            if (context == null) {
                xn.this.a();
                return;
            }
            while (!xn.this.f28038a.isEmpty() && xn.this.b(context)) {
                b bVar = (b) xn.this.f28038a.remove(0);
                if (bVar.b < 3) {
                    new AsyncTaskC0335a(false, true, bVar).execute(new Void[0]);
                }
            }
            if (xn.this.f28038a.isEmpty()) {
                xn.this.a();
            }
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f28040a;
        int b = 0;

        public b(String str) {
            this.f28040a = str;
        }
    }

    private xn(Context context) {
        if (context != null) {
            this.c = context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0;
        }
    }

    public static xn a(Context context) {
        if (d == null) {
            d = new xn(context);
        }
        return d;
    }

    private void c(Context context) {
        if (this.b == null) {
            WeakReference weakReference = new WeakReference(context);
            Timer timer = new Timer();
            this.b = timer;
            timer.scheduleAtFixedRate(new a(weakReference), 10000L, 10000L);
        }
    }

    public boolean b(Context context) {
        try {
            if (!this.c) {
                return true;
            }
            if (context != null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public synchronized void a(String str, Context context) {
        this.f28038a.add(new b(str));
        c(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Timer timer = this.b;
        if (timer != null) {
            timer.cancel();
            this.b = null;
        }
    }
}
