package com.hailiang.advlib.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public class CPCFileProvider extends FileProvider {
    private boolean c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f32569a = new Handler();
    private int b = 0;
    private final Runnable d = new a(this);

    @Keep
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CPCFileProvider f32570a;

        public a(CPCFileProvider cPCFileProvider) {
            this.f32570a = cPCFileProvider;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f32570a.c = true;
        }
    }

    @Keep
    public class b implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Application f32571a;
        final CPCFileProvider b;

        public b(CPCFileProvider cPCFileProvider, Application application) {
            this.b = cPCFileProvider;
            this.f32571a = application;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Intent intent;
            Uri data;
            try {
                boolean z = this.b.b == 0 || this.b.c;
                CPCFileProvider.c(this.b);
                if (!z || (intent = activity.getIntent()) == null || (data = intent.getData()) == null) {
                    return;
                }
                Uri referrer = activity.getReferrer();
                String authority = referrer != null ? referrer.getAuthority() : null;
                String packageName = activity.getPackageName();
                if (TextUtils.equals(authority, packageName)) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(data);
                sb.append(",");
                if (authority == null) {
                    authority = "";
                }
                sb.append(authority);
                sb.append(",");
                sb.append(packageName);
                this.f32571a.getSharedPreferences("qk_app_fast", 0).edit().putString("sp_value0", sb.toString()).apply();
            } catch (Throwable unused) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.b.b > 0) {
                CPCFileProvider.d(this.b);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            this.b.f32569a.removeCallbacks(this.b.d);
            this.b.f32569a.postDelayed(this.b.d, 500L);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            this.b.c = false;
            this.b.f32569a.removeCallbacks(this.b.d);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    private void a() {
        Context context = getContext();
        if (context != null && context.getSharedPreferences("qk_app_fast", 0).getBoolean("sp_value1", false)) {
            Application application = (Application) context.getApplicationContext();
            application.registerActivityLifecycleCallbacks(new b(this, application));
        }
    }

    public static /* synthetic */ int c(CPCFileProvider cPCFileProvider) {
        int i = cPCFileProvider.b;
        cPCFileProvider.b = i + 1;
        return i;
    }

    public static /* synthetic */ int d(CPCFileProvider cPCFileProvider) {
        int i = cPCFileProvider.b;
        cPCFileProvider.b = i - 1;
        return i;
    }

    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public boolean onCreate() {
        a();
        return super.onCreate();
    }
}
