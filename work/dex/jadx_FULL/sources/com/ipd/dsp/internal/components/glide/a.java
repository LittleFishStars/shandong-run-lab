package com.ipd.dsp.internal.components.glide;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ipd.dsp.Dsp;
import com.ipd.dsp.internal.a0.p;
import com.ipd.dsp.internal.b.f;
import com.ipd.dsp.internal.b.h;
import com.ipd.dsp.internal.d0.m;
import com.ipd.dsp.internal.d0.o;
import com.ipd.dsp.internal.i.k;
import com.ipd.dsp.internal.k.j;
import com.ipd.dsp.internal.q.r;
import com.ipd.dsp.internal.q.z;
import com.ipd.dsp.internal.z.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a implements ComponentCallbacks2 {
    public static final String q = "4.16.0";
    public static final String r = "ipd_image_manager_disk_cache";
    public static final String s = "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).";
    public static final String t = "Glide";

    @GuardedBy("Glide.class")
    public static volatile a u;
    public static volatile boolean v;
    public final k f;
    public final com.ipd.dsp.internal.j.e g;
    public final j h;
    public final c i;
    public final com.ipd.dsp.internal.j.b j;
    public final com.ipd.dsp.internal.components.glide.manager.b k;
    public final com.ipd.dsp.internal.w.c l;
    public final InterfaceC0867a n;

    @Nullable
    @GuardedBy("this")
    public com.ipd.dsp.internal.m.b p;

    @GuardedBy("managers")
    public final List<h> m = new ArrayList();
    public com.ipd.dsp.internal.b.c o = com.ipd.dsp.internal.b.c.NORMAL;

    /* JADX INFO: renamed from: com.ipd.dsp.internal.components.glide.a$a, reason: collision with other inner class name */
    public interface InterfaceC0867a {
        @NonNull
        i build();
    }

    public a(@NonNull Context context, @NonNull k kVar, @NonNull j jVar, @NonNull com.ipd.dsp.internal.j.e eVar, @NonNull com.ipd.dsp.internal.j.b bVar, @NonNull com.ipd.dsp.internal.components.glide.manager.b bVar2, @NonNull com.ipd.dsp.internal.w.c cVar, @NonNull InterfaceC0867a interfaceC0867a, @NonNull Map<Class<?>, com.ipd.dsp.internal.b.i<?, ?>> map, @NonNull List<com.ipd.dsp.internal.z.h<Object>> list, @NonNull List<com.ipd.dsp.internal.x.c> list2, @Nullable com.ipd.dsp.internal.x.a aVar, @NonNull d dVar) {
        this.f = kVar;
        this.g = eVar;
        this.j = bVar;
        this.h = jVar;
        this.k = bVar2;
        this.l = cVar;
        this.n = interfaceC0867a;
        this.i = new c(context, bVar, e.b(this, list2, aVar), new com.ipd.dsp.internal.a0.k(), interfaceC0867a, map, list, kVar, dVar);
    }

    @Nullable
    public static File a(@NonNull Context context, @NonNull String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.b("Glide", "default disk cache dir is null");
            }
            return null;
        }
        File file = new File(cacheDir, str);
        if (file.isDirectory() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    @Nullable
    public static GeneratedAppGlideModule b(Context context) {
        return null;
    }

    @GuardedBy("Glide.class")
    public static void b(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        a(context, new b(), generatedAppGlideModule);
    }

    @Nullable
    public static File c(@NonNull Context context) {
        return a(context, "ipd_image_manager_disk_cache");
    }

    @NonNull
    public static String k() {
        return q;
    }

    @VisibleForTesting
    public static synchronized boolean l() {
        return u != null;
    }

    @VisibleForTesting
    public static void m() {
        synchronized (a.class) {
            if (u != null) {
                u.g().getApplicationContext().unregisterComponentCallbacks(u);
                u.f.b();
            }
            u = null;
        }
    }

    @NonNull
    public com.ipd.dsp.internal.j.b d() {
        return this.j;
    }

    @NonNull
    public com.ipd.dsp.internal.j.e e() {
        return this.g;
    }

    public com.ipd.dsp.internal.w.c f() {
        return this.l;
    }

    @NonNull
    public Context g() {
        return this.i.getBaseContext();
    }

    @NonNull
    public c h() {
        return this.i;
    }

    @NonNull
    public f i() {
        return this.i.f();
    }

    @NonNull
    public com.ipd.dsp.internal.components.glide.manager.b j() {
        return this.k;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        b();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        a(i);
    }

    @VisibleForTesting
    public static void c() {
        z.c().g();
    }

    @NonNull
    public static com.ipd.dsp.internal.components.glide.manager.b d(@Nullable Context context) {
        m.a(context, s);
        return a(context).j();
    }

    @NonNull
    public static h e(@NonNull Context context) {
        return d(context).b(context);
    }

    public void b() {
        o.b();
        this.h.a();
        this.g.a();
        this.j.a();
    }

    @NonNull
    public static a a(@NonNull Context context) {
        if (u == null) {
            GeneratedAppGlideModule generatedAppGlideModuleB = b(context.getApplicationContext());
            synchronized (a.class) {
                if (u == null) {
                    a(context, generatedAppGlideModuleB);
                }
            }
        }
        return u;
    }

    public void b(h hVar) {
        synchronized (this.m) {
            if (this.m.contains(hVar)) {
                this.m.remove(hVar);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }

    @GuardedBy("Glide.class")
    @VisibleForTesting
    public static void a(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        if (!v) {
            v = true;
            try {
                b(context, generatedAppGlideModule);
                return;
            } finally {
                v = false;
            }
        }
        throw new IllegalStateException("Glide has been called recursively, this is probably an internal library error!");
    }

    @VisibleForTesting
    @Deprecated
    public static synchronized void a(a aVar) {
        if (u != null) {
            m();
        }
        u = aVar;
    }

    @VisibleForTesting
    public static void a(@NonNull Context context, @NonNull b bVar) {
        GeneratedAppGlideModule generatedAppGlideModuleB = b(context);
        synchronized (a.class) {
            if (u != null) {
                m();
            }
            a(context, bVar, generatedAppGlideModuleB);
        }
    }

    @GuardedBy("Glide.class")
    public static void a(@NonNull Context context, @NonNull b bVar, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List<com.ipd.dsp.internal.x.c> listA = Collections.EMPTY_LIST;
        if (generatedAppGlideModule == null || generatedAppGlideModule.a()) {
            listA = new com.ipd.dsp.internal.x.e(applicationContext).a();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.b().isEmpty()) {
            Set<Class<?>> setB = generatedAppGlideModule.b();
            Iterator<com.ipd.dsp.internal.x.c> it = listA.iterator();
            while (it.hasNext()) {
                com.ipd.dsp.internal.x.c next = it.next();
                if (setB.contains(next.getClass())) {
                    if (Dsp.isDebugLogEnable()) {
                        com.ipd.dsp.internal.c2.k.a("Glide", "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Dsp.isDebugLogEnable()) {
            Iterator<com.ipd.dsp.internal.x.c> it2 = listA.iterator();
            while (it2.hasNext()) {
                com.ipd.dsp.internal.c2.k.a("Glide", "Discovered GlideModule from manifest: " + it2.next().getClass());
            }
        }
        bVar.a(generatedAppGlideModule != null ? generatedAppGlideModule.c() : null);
        Iterator<com.ipd.dsp.internal.x.c> it3 = listA.iterator();
        while (it3.hasNext()) {
            it3.next().a(applicationContext, bVar);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a(applicationContext, bVar);
        }
        a aVarA = bVar.a(applicationContext, listA, generatedAppGlideModule);
        applicationContext.registerComponentCallbacks(aVarA);
        u = aVarA;
    }

    public static void a(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public synchronized void a(@NonNull com.ipd.dsp.internal.m.d.a... aVarArr) {
        if (this.p == null) {
            this.p = new com.ipd.dsp.internal.m.b(this.h, this.g, (com.ipd.dsp.internal.f.b) this.n.build().o().a(r.g));
        }
        this.p.a(aVarArr);
    }

    public void a(int i) {
        o.b();
        synchronized (this.m) {
            Iterator<h> it = this.m.iterator();
            while (it.hasNext()) {
                it.next().onTrimMemory(i);
            }
        }
        this.h.trimMemory(i);
        this.g.trimMemory(i);
        this.j.trimMemory(i);
    }

    public void a() {
        o.a();
        this.f.a();
    }

    @NonNull
    public com.ipd.dsp.internal.b.c a(@NonNull com.ipd.dsp.internal.b.c cVar) {
        o.b();
        this.h.a(cVar.a());
        this.g.a(cVar.a());
        com.ipd.dsp.internal.b.c cVar2 = this.o;
        this.o = cVar;
        return cVar2;
    }

    @NonNull
    @Deprecated
    public static h a(@NonNull Activity activity) {
        return e(activity.getApplicationContext());
    }

    @NonNull
    public static h a(@NonNull FragmentActivity fragmentActivity) {
        return d(fragmentActivity).a(fragmentActivity);
    }

    @NonNull
    public static h a(@NonNull Fragment fragment) {
        return d(fragment.getContext()).a(fragment);
    }

    @NonNull
    @Deprecated
    public static h a(@NonNull android.app.Fragment fragment) {
        Activity activity = fragment.getActivity();
        m.a(activity, s);
        return e(activity.getApplicationContext());
    }

    @NonNull
    public static h a(@NonNull View view) {
        return d(view.getContext()).a(view);
    }

    public boolean a(@NonNull p<?> pVar) {
        synchronized (this.m) {
            Iterator<h> it = this.m.iterator();
            while (it.hasNext()) {
                if (it.next().b(pVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void a(h hVar) {
        synchronized (this.m) {
            if (!this.m.contains(hVar)) {
                this.m.add(hVar);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }
}
