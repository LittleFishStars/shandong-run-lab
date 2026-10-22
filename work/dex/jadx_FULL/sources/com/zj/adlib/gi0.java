package com.zj.adlib;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public final class gi0 implements Camera.AutoFocusCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f41908a = 1200;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Collection<String> f16770a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Camera f16771a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AsyncTask<?, ?, ?> f16772a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f16773a;
    public boolean b;
    public final boolean c;

    public static class a extends AsyncTask<Object, Object, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<gi0> f41909a;

        public a(gi0 gi0Var) {
            this.f41909a = new WeakReference<>(gi0Var);
        }

        @Override // android.os.AsyncTask
        public Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(1200L);
            } catch (InterruptedException unused) {
            }
            gi0 gi0Var = this.f41909a.get();
            if (gi0Var == null) {
                return null;
            }
            gi0Var.c();
            return null;
        }
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        f16770a = arrayList;
        arrayList.add("auto");
        arrayList.add("macro");
    }

    public gi0(Context context, Camera camera) {
        this.f16771a = camera;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String focusMode = camera.getParameters().getFocusMode();
        boolean z = defaultSharedPreferences.getBoolean(mx6.p, true) && f16770a.contains(focusMode);
        this.c = z;
        u15.l("Current focus mode '" + focusMode + "'; use auto focus? " + z);
        c();
    }

    public final synchronized void a() {
        if (!this.f16773a && this.f16772a == null) {
            a aVar = new a(this);
            try {
                aVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                this.f16772a = aVar;
            } catch (RejectedExecutionException e) {
                u15.A("Could not request auto focus", e);
            }
        }
    }

    public final synchronized void b() {
        AsyncTask<?, ?, ?> asyncTask = this.f16772a;
        if (asyncTask != null) {
            if (asyncTask.getStatus() != AsyncTask.Status.FINISHED) {
                this.f16772a.cancel(true);
            }
            this.f16772a = null;
        }
    }

    public synchronized void c() {
        try {
            if (this.c) {
                this.f16772a = null;
                if (!this.f16773a && !this.b) {
                    try {
                        this.f16771a.autoFocus(this);
                        this.b = true;
                    } catch (RuntimeException e) {
                        u15.A("Unexpected exception while focusing", e);
                        a();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void d() {
        this.f16773a = true;
        if (this.c) {
            b();
            try {
                this.f16771a.cancelAutoFocus();
            } catch (RuntimeException e) {
                u15.A("Unexpected exception while cancelling focusing", e);
            }
        }
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public synchronized void onAutoFocus(boolean z, Camera camera) {
        this.b = false;
        a();
    }
}
