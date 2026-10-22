package com.king.zxing;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import com.zj.adlib.u15;
import java.lang.ref.WeakReference;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public final class InactivityTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f40013a = 300000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Activity f15012a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AsyncTask<Object, Object, Object> f15014a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BroadcastReceiver f15013a = new PowerStatusReceiver(this);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15015a = false;

    public static class PowerStatusReceiver extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<InactivityTimer> f40014a;

        public PowerStatusReceiver(InactivityTimer inactivityTimer) {
            this.f40014a = new WeakReference<>(inactivityTimer);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            InactivityTimer inactivityTimer;
            if (!"android.intent.action.BATTERY_CHANGED".equals(intent.getAction()) || (inactivityTimer = this.f40014a.get()) == null) {
                return;
            }
            if (intent.getIntExtra("plugged", -1) <= 0) {
                inactivityTimer.c();
            } else {
                inactivityTimer.b();
            }
        }
    }

    public static class a extends AsyncTask<Object, Object, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<Activity> f40015a;

        public a(Activity activity) {
            this.f40015a = new WeakReference<>(activity);
        }

        @Override // android.os.AsyncTask
        public Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(300000L);
                u15.l("Finishing activity due to inactivity");
                Activity activity = this.f40015a.get();
                if (activity == null) {
                    return null;
                }
                activity.finish();
                return null;
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }

    public InactivityTimer(Activity activity) {
        this.f15012a = activity;
        c();
    }

    public final void b() {
        AsyncTask<Object, Object, Object> asyncTask = this.f15014a;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.f15014a = null;
        }
    }

    public void c() {
        b();
        a aVar = new a(this.f15012a);
        this.f15014a = aVar;
        try {
            aVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        } catch (RejectedExecutionException unused) {
            u15.z("Couldn't schedule inactivity task; ignoring");
        }
    }

    public void d() {
        b();
        if (!this.f15015a) {
            u15.z("PowerStatusReceiver was never registered?");
        } else {
            this.f15012a.unregisterReceiver(this.f15013a);
            this.f15015a = false;
        }
    }

    public void e() {
        if (this.f15015a) {
            u15.z("PowerStatusReceiver was already registered?");
        } else {
            this.f15012a.registerReceiver(this.f15013a, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            this.f15015a = true;
        }
        c();
    }

    public void f() {
        b();
    }
}
