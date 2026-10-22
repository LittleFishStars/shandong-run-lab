package com.kc.cw.ad.d;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class h {
    private String f;
    private f i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f38814a = "OnLineStateClass";
    private int b = 0;
    private boolean c = true;
    private boolean d = false;
    private boolean e = false;
    private final Map<String, String> g = new HashMap();
    private long h = 0;

    public static /* synthetic */ int d(h hVar) {
        int i = hVar.b;
        hVar.b = i + 1;
        return i;
    }

    public static /* synthetic */ int h(h hVar) {
        int i = hVar.b;
        hVar.b = i - 1;
        return i;
    }

    public String a() {
        return this.f;
    }

    public void a(Context context) {
        Application application = (Application) context.getApplicationContext();
        this.h = System.currentTimeMillis() / 1000;
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks(this) { // from class: com.kc.cw.ad.d.h.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final h f38815a;

            {
                this.f38815a = this;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                this.f38815a.f = activity.getClass().getSimpleName();
                this.f38815a.g.put(this.f38815a.f, this.f38815a.f);
                this.f38815a.c = true;
                this.f38815a.d = false;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                this.f38815a.g.remove(activity.getClass().getSimpleName());
                if (this.f38815a.g.isEmpty() && this.f38815a.c) {
                    long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                    if (this.f38815a.i != null) {
                        long unused = this.f38815a.h;
                        this.f38815a.i.a(jCurrentTimeMillis, this.f38815a.h);
                        this.f38815a.h = System.currentTimeMillis() / 1000;
                    }
                    this.f38815a.c = false;
                }
                if (this.f38815a.g.isEmpty()) {
                    this.f38815a.e = true;
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                this.f38815a.d = !activity.getClass().getSimpleName().equals(this.f38815a.f);
                this.f38815a.f = activity.getClass().getSimpleName();
                if (!this.f38815a.c || this.f38815a.e) {
                    this.f38815a.e = false;
                    if (this.f38815a.i != null) {
                        this.f38815a.i.a();
                    }
                    this.f38815a.h = System.currentTimeMillis() / 1000;
                    this.f38815a.c = true;
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                com.kc.cw.ad.d.b.f.a(this.f38815a.f38814a, "onActivityStarted");
                h.d(this.f38815a);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                com.kc.cw.ad.d.b.f.a(this.f38815a.f38814a, "onActivityStopped");
                h.h(this.f38815a);
                if (activity.getClass().getSimpleName().equals(this.f38815a.f)) {
                    if (!this.f38815a.d || this.f38815a.g.size() == 1) {
                        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                        if (this.f38815a.i != null) {
                            long unused = this.f38815a.h;
                            this.f38815a.i.a(this.f38815a.h, jCurrentTimeMillis);
                            this.f38815a.h = System.currentTimeMillis() / 1000;
                        }
                        this.f38815a.c = false;
                    }
                }
            }
        });
    }

    public void a(f fVar) {
        this.i = fVar;
    }
}
