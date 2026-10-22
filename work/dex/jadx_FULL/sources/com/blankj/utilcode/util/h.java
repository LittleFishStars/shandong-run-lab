package com.blankj.utilcode.util;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.p002lifecycle.Lifecycle;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class h implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final h f1451a = new h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Activity f28231a = new Activity();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LinkedList<Activity> f1452a = new LinkedList<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<Utils.OnAppStatusChangedListener> f1453a = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<Activity, List<Utils.a>> f1454a = new ConcurrentHashMap();
    public int K = 0;
    public int L = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1455a = false;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f28232a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Utils.a f1456a;

        public a(Activity activity, Utils.a aVar) {
            this.f28232a = activity;
            this.f1456a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.f(this.f28232a, this.f1456a);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f28233a;

        public b(Activity activity) {
            this.f28233a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.f1454a.remove(this.f28233a);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f28234a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Utils.a f1459a;

        public c(Activity activity, Utils.a aVar) {
            this.f28234a = activity;
            this.f1459a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.w(this.f28234a, this.f1459a);
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f28235a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Object f1462a;

        public d(Activity activity, Object obj) {
            this.f28235a = activity;
            this.f1462a = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Window window = this.f28235a.getWindow();
                if (window != null) {
                    window.setSoftInputMode(((Integer) this.f1462a).intValue());
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void x() {
        if (ValueAnimator.areAnimatorsEnabled()) {
            return;
        }
        try {
            Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
            declaredField.setAccessible(true);
            if (((Float) declaredField.get(null)).floatValue() == 0.0f) {
                declaredField.set(null, Float.valueOf(1.0f));
                Log.i("UtilsActivityLifecycle", "setAnimatorsEnabled: Animators are enabled now!");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    public void addOnAppStatusChangedListener(Utils.OnAppStatusChangedListener onAppStatusChangedListener) {
        this.f1453a.add(onAppStatusChangedListener);
    }

    public void d(Activity activity, Utils.a aVar) {
        if (activity == null || aVar == null) {
            return;
        }
        i.T0(new a(activity, aVar));
    }

    public void e(Utils.a aVar) {
        d(f28231a, aVar);
    }

    public final void f(Activity activity, Utils.a aVar) {
        List<Utils.a> copyOnWriteArrayList = this.f1454a.get(activity);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f1454a.put(activity, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(aVar)) {
            return;
        }
        copyOnWriteArrayList.add(aVar);
    }

    public final void g(Activity activity, Lifecycle.Event event) {
        h(activity, event, this.f1454a.get(activity));
        h(activity, event, this.f1454a.get(f28231a));
    }

    public final void h(Activity activity, Lifecycle.Event event, List<Utils.a> list) {
        if (list == null) {
            return;
        }
        for (Utils.a aVar : list) {
            aVar.g(activity, event);
            if (event.equals(Lifecycle.Event.ON_CREATE)) {
                aVar.a(activity);
            } else if (event.equals(Lifecycle.Event.ON_START)) {
                aVar.e(activity);
            } else if (event.equals(Lifecycle.Event.ON_RESUME)) {
                aVar.d(activity);
            } else if (event.equals(Lifecycle.Event.ON_PAUSE)) {
                aVar.c(activity);
            } else if (event.equals(Lifecycle.Event.ON_STOP)) {
                aVar.f(activity);
            } else if (event.equals(Lifecycle.Event.ON_DESTROY)) {
                aVar.b(activity);
            }
        }
        if (event.equals(Lifecycle.Event.ON_DESTROY)) {
            this.f1454a.remove(activity);
        }
    }

    public final List<Activity> i() {
        LinkedList linkedList = new LinkedList();
        Activity activity = null;
        try {
            Object objK = k();
            Field declaredField = objK.getClass().getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(objK);
            if (!(obj instanceof Map)) {
                return linkedList;
            }
            for (Object obj2 : ((Map) obj).values()) {
                Class<?> cls = obj2.getClass();
                Field declaredField2 = cls.getDeclaredField("activities_run");
                declaredField2.setAccessible(true);
                Activity activity2 = (Activity) declaredField2.get(obj2);
                if (activity == null) {
                    Field declaredField3 = cls.getDeclaredField("paused");
                    declaredField3.setAccessible(true);
                    if (declaredField3.getBoolean(obj2)) {
                        linkedList.add(activity2);
                    } else {
                        activity = activity2;
                    }
                } else {
                    linkedList.add(activity2);
                }
            }
        } catch (Exception e) {
            Log.e("UtilsActivityLifecycle", "getActivitiesByReflect: " + e.getMessage());
        }
        if (activity != null) {
            linkedList.addFirst(activity);
        }
        return linkedList;
    }

    public List<Activity> j() {
        if (!this.f1452a.isEmpty()) {
            return new LinkedList(this.f1452a);
        }
        this.f1452a.addAll(i());
        return new LinkedList(this.f1452a);
    }

    public final Object k() {
        Object objL = l();
        return objL != null ? objL : m();
    }

    public final Object l() {
        try {
            Field declaredField = Class.forName(ProcessUtils.ACTIVITY_THREAD).getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticField: " + e.getMessage());
            return null;
        }
    }

    public final Object m() {
        try {
            return Class.forName(ProcessUtils.ACTIVITY_THREAD).getMethod(ProcessUtils.CURRENT_ACTIVITY_THREAD, new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticMethod: " + e.getMessage());
            return null;
        }
    }

    public Application n() {
        try {
            Class<?> cls = Class.forName(ProcessUtils.ACTIVITY_THREAD);
            Object objInvoke = cls.getMethod("getApplication", new Class[0]).invoke(k(), new Object[0]);
            if (objInvoke == null) {
                return null;
            }
            return (Application) objInvoke;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public Activity o() {
        for (Activity activity : j()) {
            if (i.o0(activity)) {
                return activity;
            }
        }
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, Bundle bundle) {
        if (this.f1452a.size() == 0) {
            r(activity, true);
        }
        com.blankj.utilcode.util.d.b(activity);
        x();
        y(activity);
        g(activity, Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
        this.f1452a.remove(activity);
        i.D(activity);
        g(activity, Lifecycle.Event.ON_DESTROY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
        g(activity, Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostDestroyed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostPaused(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostSaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStarted(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStopped(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreDestroyed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPrePaused(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreResumed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreSaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStarted(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStopped(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
        y(activity);
        if (this.f1455a) {
            this.f1455a = false;
            r(activity, true);
        }
        s(activity, false);
        g(activity, Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
        if (!this.f1455a) {
            y(activity);
        }
        int i = this.L;
        if (i < 0) {
            this.L = i + 1;
        } else {
            this.K++;
        }
        g(activity, Lifecycle.Event.ON_START);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (activity.isChangingConfigurations()) {
            this.L--;
        } else {
            int i = this.K - 1;
            this.K = i;
            if (i <= 0) {
                this.f1455a = true;
                r(activity, false);
            }
        }
        s(activity, true);
        g(activity, Lifecycle.Event.ON_STOP);
    }

    public void p(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    public boolean q() {
        return !this.f1455a;
    }

    public final void r(Activity activity, boolean z) {
        if (this.f1453a.isEmpty()) {
            return;
        }
        for (Utils.OnAppStatusChangedListener onAppStatusChangedListener : this.f1453a) {
            if (z) {
                onAppStatusChangedListener.b(activity);
            } else {
                onAppStatusChangedListener.a(activity);
            }
        }
    }

    public void removeOnAppStatusChangedListener(Utils.OnAppStatusChangedListener onAppStatusChangedListener) {
        this.f1453a.remove(onAppStatusChangedListener);
    }

    public final void s(Activity activity, boolean z) {
        try {
            if (z) {
                Window window = activity.getWindow();
                window.getDecorView().setTag(-123, Integer.valueOf(window.getAttributes().softInputMode));
                window.setSoftInputMode(3);
            } else {
                Object tag = activity.getWindow().getDecorView().getTag(-123);
                if (!(tag instanceof Integer)) {
                } else {
                    i.U0(new d(activity, tag), 100L);
                }
            }
        } catch (Exception unused) {
        }
    }

    public void t(Activity activity) {
        if (activity == null) {
            return;
        }
        i.T0(new b(activity));
    }

    public void u(Activity activity, Utils.a aVar) {
        if (activity == null || aVar == null) {
            return;
        }
        i.T0(new c(activity, aVar));
    }

    public void v(Utils.a aVar) {
        u(f28231a, aVar);
    }

    public final void w(Activity activity, Utils.a aVar) {
        List<Utils.a> list = this.f1454a.get(activity);
        if (list == null || list.isEmpty()) {
            return;
        }
        list.remove(aVar);
    }

    public final void y(Activity activity) {
        if (!this.f1452a.contains(activity)) {
            this.f1452a.addFirst(activity);
        } else {
            if (this.f1452a.getFirst().equals(activity)) {
                return;
            }
            this.f1452a.remove(activity);
            this.f1452a.addFirst(activity);
        }
    }

    public void z(Application application) {
        this.f1452a.clear();
        application.unregisterActivityLifecycleCallbacks(this);
    }
}
