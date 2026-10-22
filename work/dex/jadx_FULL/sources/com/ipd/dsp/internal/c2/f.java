package com.ipd.dsp.internal.c2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.byazt.hv.TTDownloadField;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class f {
    public static final String d = "ALH";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f38221a;
    public WeakReference<Activity> b;
    public final HashMap<b, WeakReference<Activity>> c;

    public class a implements Application.ActivityLifecycleCallbacks {
        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
            Iterator it = f.this.c.entrySet().iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) ((Map.Entry) it.next()).getValue();
                if (weakReference != null && activity == weakReference.get()) {
                    weakReference.clear();
                    it.remove();
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
            for (b bVar : f.this.c.keySet()) {
                WeakReference weakReference = (WeakReference) f.this.c.get(bVar);
                if (weakReference != null && activity == weakReference.get()) {
                    bVar.onPause();
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
            if (f.this.b == null || f.this.b.get() != activity) {
                if (f.this.b != null) {
                    f.this.b.clear();
                }
                f.this.b = new WeakReference(activity);
            }
            for (b bVar : f.this.c.keySet()) {
                WeakReference weakReference = (WeakReference) f.this.c.get(bVar);
                if (weakReference != null && activity == weakReference.get()) {
                    bVar.onResume();
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
        }
    }

    public interface b {
        void onPause();

        void onResume();
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f38223a = new f(null);
    }

    public /* synthetic */ f(a aVar) {
        this();
    }

    @SuppressLint({"DiscouragedPrivateApi", "PrivateApi"})
    public final Activity c() throws Throwable {
        Class<?> cls = Class.forName(ProcessUtils.ACTIVITY_THREAD);
        Object objInvoke = cls.getMethod(ProcessUtils.CURRENT_ACTIVITY_THREAD, null).invoke(null, null);
        Field declaredField = cls.getDeclaredField("mActivities");
        declaredField.setAccessible(true);
        Map map = (Map) declaredField.get(objInvoke);
        if (map != null) {
            for (Object obj : map.values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField(TTDownloadField.TT_ACTIVITY);
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(obj);
                }
            }
        }
        return null;
    }

    public f() {
        this.c = new HashMap<>();
        this.f38221a = false;
    }

    public void b(b bVar) {
        WeakReference<Activity> weakReferenceRemove;
        if (bVar == null || (weakReferenceRemove = this.c.remove(bVar)) == null) {
            return;
        }
        weakReferenceRemove.clear();
    }

    public static f a() {
        return c.f38223a;
    }

    public void a(b bVar) {
        if (bVar != null) {
            HashMap<b, WeakReference<Activity>> map = this.c;
            WeakReference<Activity> weakReference = this.b;
            map.put(bVar, new WeakReference<>(weakReference != null ? weakReference.get() : null));
        }
    }

    @Nullable
    public Activity b() {
        try {
            WeakReference<Activity> weakReference = this.b;
            Activity activity = weakReference != null ? weakReference.get() : null;
            return activity == null ? c() : activity;
        } catch (Throwable unused) {
            return null;
        }
    }

    public synchronized void a(Context context) {
        if (this.f38221a) {
            return;
        }
        if (context instanceof Application) {
            try {
                this.f38221a = true;
                ((Application) context).registerActivityLifecycleCallbacks(new a());
                return;
            } catch (Throwable th) {
                k.b(d, "error registerActivityLifecycleCallbacks", th);
                return;
            }
        }
        k.b(d, "init lifecycle error, context not instance of android.app.Application");
    }
}
