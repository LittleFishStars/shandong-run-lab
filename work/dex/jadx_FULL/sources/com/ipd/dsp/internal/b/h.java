package com.ipd.dsp.internal.b;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.ipd.dsp.internal.a0.p;
import com.ipd.dsp.internal.i.j;
import com.ipd.dsp.internal.w.k;
import com.ipd.dsp.internal.w.n;
import com.ipd.dsp.internal.w.o;
import com.ipd.dsp.internal.w.r;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class h implements ComponentCallbacks2, k, d<g<Drawable>> {
    public static final com.ipd.dsp.internal.z.i r = com.ipd.dsp.internal.z.i.b((Class<?>) Bitmap.class).M();
    public static final com.ipd.dsp.internal.z.i s = com.ipd.dsp.internal.z.i.b((Class<?>) com.ipd.dsp.internal.u.c.class).M();
    public static final com.ipd.dsp.internal.z.i t = com.ipd.dsp.internal.z.i.b(j.c).a(e.LOW).b(true);
    public final com.ipd.dsp.internal.components.glide.a f;
    public final Context g;
    public final com.ipd.dsp.internal.w.j h;

    @GuardedBy("this")
    public final o i;

    @GuardedBy("this")
    public final n j;

    @GuardedBy("this")
    public final r k;
    public final Runnable l;
    public final com.ipd.dsp.internal.w.b m;
    public final CopyOnWriteArrayList<com.ipd.dsp.internal.z.h<Object>> n;

    @GuardedBy("this")
    public com.ipd.dsp.internal.z.i o;
    public boolean p;
    public boolean q;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.h.a(hVar);
        }
    }

    public static class b extends com.ipd.dsp.internal.a0.f<View, Object> {
        public b(@NonNull View view) {
            super(view);
        }

        @Override // com.ipd.dsp.internal.a0.p
        public void onLoadFailed(@Nullable Drawable drawable) {
        }

        @Override // com.ipd.dsp.internal.a0.f
        public void onResourceCleared(@Nullable Drawable drawable) {
        }

        @Override // com.ipd.dsp.internal.a0.p
        public void onResourceReady(@NonNull Object obj, @Nullable com.ipd.dsp.internal.b0.f<? super Object> fVar) {
        }
    }

    public class c implements com.ipd.dsp.internal.w.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @GuardedBy("RequestManager.this")
        public final o f38193a;

        public c(@NonNull o oVar) {
            this.f38193a = oVar;
        }

        @Override // com.ipd.dsp.internal.w.b.a
        public void a(boolean z) {
            if (z) {
                synchronized (h.this) {
                    this.f38193a.e();
                }
            }
        }
    }

    public h(@NonNull com.ipd.dsp.internal.components.glide.a aVar, @NonNull com.ipd.dsp.internal.w.j jVar, @NonNull n nVar, @NonNull Context context) {
        this(aVar, jVar, nVar, new o(), aVar.f(), context);
    }

    @NonNull
    public synchronized h b(@NonNull com.ipd.dsp.internal.z.i iVar) {
        c(iVar);
        return this;
    }

    public synchronized void c(@NonNull com.ipd.dsp.internal.z.i iVar) {
        this.o = iVar.mo997clone().a();
    }

    public final synchronized void d(@NonNull com.ipd.dsp.internal.z.i iVar) {
        this.o = this.o.a(iVar);
    }

    @NonNull
    public synchronized h e() {
        this.q = true;
        return this;
    }

    public final synchronized void f() {
        Iterator<p<?>> it = this.k.b().iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        this.k.a();
    }

    @NonNull
    @CheckResult
    public g<File> g() {
        return a(File.class).c((com.ipd.dsp.internal.z.a<?>) t);
    }

    public List<com.ipd.dsp.internal.z.h<Object>> h() {
        return this.n;
    }

    public synchronized com.ipd.dsp.internal.z.i i() {
        return this.o;
    }

    public synchronized boolean j() {
        return this.i.b();
    }

    public synchronized void k() {
        this.i.c();
    }

    public synchronized void l() {
        k();
        Iterator<h> it = this.j.a().iterator();
        while (it.hasNext()) {
            it.next().k();
        }
    }

    public synchronized void m() {
        this.i.d();
    }

    public synchronized void n() {
        m();
        Iterator<h> it = this.j.a().iterator();
        while (it.hasNext()) {
            it.next().m();
        }
    }

    public synchronized void o() {
        this.i.f();
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.ipd.dsp.internal.w.k
    public synchronized void onDestroy() {
        this.k.onDestroy();
        f();
        this.i.a();
        this.h.b(this);
        this.h.b(this.m);
        com.ipd.dsp.internal.d0.o.b(this.l);
        this.f.b(this);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // com.ipd.dsp.internal.w.k
    public synchronized void onStart() {
        o();
        this.k.onStart();
    }

    @Override // com.ipd.dsp.internal.w.k
    public synchronized void onStop() {
        this.k.onStop();
        if (this.q) {
            f();
        } else {
            m();
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (i == 60 && this.p) {
            l();
        }
    }

    public synchronized void p() {
        com.ipd.dsp.internal.d0.o.b();
        o();
        Iterator<h> it = this.j.a().iterator();
        while (it.hasNext()) {
            it.next().o();
        }
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.i + ", treeNode=" + this.j + "}";
    }

    @NonNull
    @CheckResult
    public g<Drawable> b() {
        return a(Drawable.class);
    }

    @Override // com.ipd.dsp.internal.b.d
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public g<Drawable> a(@Nullable Object obj) {
        return b().a(obj);
    }

    @NonNull
    @CheckResult
    public g<com.ipd.dsp.internal.u.c> d() {
        return a(com.ipd.dsp.internal.u.c.class).c((com.ipd.dsp.internal.z.a<?>) s);
    }

    @Override // com.ipd.dsp.internal.b.d
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public g<Drawable> a(@Nullable Bitmap bitmap) {
        return b().a(bitmap);
    }

    @NonNull
    @CheckResult
    public g<File> c() {
        return a(File.class).c((com.ipd.dsp.internal.z.a<?>) com.ipd.dsp.internal.z.i.e(true));
    }

    public h(com.ipd.dsp.internal.components.glide.a aVar, com.ipd.dsp.internal.w.j jVar, n nVar, o oVar, com.ipd.dsp.internal.w.c cVar, Context context) {
        this.k = new r();
        a aVar2 = new a();
        this.l = aVar2;
        this.f = aVar;
        this.h = jVar;
        this.j = nVar;
        this.i = oVar;
        this.g = context;
        com.ipd.dsp.internal.w.b bVarA = cVar.a(context.getApplicationContext(), new c(oVar));
        this.m = bVarA;
        aVar.a(this);
        if (com.ipd.dsp.internal.d0.o.d()) {
            com.ipd.dsp.internal.d0.o.a(aVar2);
        } else {
            jVar.a(this);
        }
        jVar.a(bVarA);
        this.n = new CopyOnWriteArrayList<>(aVar.h().b());
        c(aVar.h().c());
    }

    @Override // com.ipd.dsp.internal.b.d
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public g<Drawable> a(@Nullable Drawable drawable) {
        return b().a(drawable);
    }

    public final void c(@NonNull p<?> pVar) {
        boolean zB = b(pVar);
        com.ipd.dsp.internal.z.e request = pVar.getRequest();
        if (zB || this.f.a(pVar) || request == null) {
            return;
        }
        pVar.setRequest(null);
        request.clear();
    }

    @Override // com.ipd.dsp.internal.b.d
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public g<Drawable> a(@Nullable String str) {
        return b().a(str);
    }

    @Override // com.ipd.dsp.internal.b.d
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public g<Drawable> a(@Nullable Uri uri) {
        return b().a(uri);
    }

    @Override // com.ipd.dsp.internal.b.d
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public g<Drawable> a(@Nullable File file) {
        return b().a(file);
    }

    @Override // com.ipd.dsp.internal.b.d
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public g<Drawable> a(@Nullable @DrawableRes @RawRes Integer num) {
        return b().a(num);
    }

    @Override // com.ipd.dsp.internal.b.d
    @CheckResult
    @Deprecated
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public g<Drawable> a(@Nullable URL url) {
        return b().a(url);
    }

    @NonNull
    public synchronized h a(@NonNull com.ipd.dsp.internal.z.i iVar) {
        d(iVar);
        return this;
    }

    @Override // com.ipd.dsp.internal.b.d
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public g<Drawable> a(@Nullable byte[] bArr) {
        return b().a(bArr);
    }

    public h a(com.ipd.dsp.internal.z.h<Object> hVar) {
        this.n.add(hVar);
        return this;
    }

    @NonNull
    @CheckResult
    public g<File> b(@Nullable Object obj) {
        return g().a(obj);
    }

    public void a(boolean z) {
        this.p = z;
    }

    public synchronized boolean b(@NonNull p<?> pVar) {
        com.ipd.dsp.internal.z.e request = pVar.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.i.b(request)) {
            return false;
        }
        this.k.b(pVar);
        pVar.setRequest(null);
        return true;
    }

    @NonNull
    @CheckResult
    public g<Bitmap> a() {
        return a(Bitmap.class).c((com.ipd.dsp.internal.z.a<?>) r);
    }

    @NonNull
    @CheckResult
    public <ResourceType> g<ResourceType> a(@NonNull Class<ResourceType> cls) {
        return new g<>(this.f, this, cls, this.g);
    }

    public void a(@NonNull View view) {
        a((p<?>) new b(view));
    }

    public void a(@Nullable p<?> pVar) {
        if (pVar == null) {
            return;
        }
        c(pVar);
    }

    @NonNull
    public <T> i<?, T> b(Class<T> cls) {
        return this.f.h().a(cls);
    }

    public synchronized void a(@NonNull p<?> pVar, @NonNull com.ipd.dsp.internal.z.e eVar) {
        this.k.a(pVar);
        this.i.c(eVar);
    }
}
