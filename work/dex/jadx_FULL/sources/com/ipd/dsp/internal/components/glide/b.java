package com.ipd.dsp.internal.components.glide;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.ipd.dsp.internal.b.i;
import com.ipd.dsp.internal.d0.m;
import com.ipd.dsp.internal.i.k;
import com.ipd.dsp.internal.j.f;
import com.ipd.dsp.internal.k.j;
import com.ipd.dsp.internal.k.l;
import com.ipd.dsp.internal.z.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b {
    public k c;
    public com.ipd.dsp.internal.j.e d;
    public com.ipd.dsp.internal.j.b e;
    public j f;
    public com.ipd.dsp.internal.l.a g;
    public com.ipd.dsp.internal.l.a h;
    public com.ipd.dsp.internal.k.a.InterfaceC0888a i;
    public l j;
    public com.ipd.dsp.internal.w.c k;

    @Nullable
    public com.ipd.dsp.internal.components.glide.manager.b.InterfaceC0873b m;
    public com.ipd.dsp.internal.l.a n;
    public boolean o;

    @Nullable
    public List<h<Object>> p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, i<?, ?>> f38240a = new ArrayMap();
    public final com.ipd.dsp.internal.components.glide.d.a b = new com.ipd.dsp.internal.components.glide.d.a();
    public com.ipd.dsp.internal.components.glide.a.InterfaceC0867a l = new a();

    public class a implements com.ipd.dsp.internal.components.glide.a.InterfaceC0867a {
        public a() {
        }

        @Override // com.ipd.dsp.internal.components.glide.a.InterfaceC0867a
        @NonNull
        public com.ipd.dsp.internal.z.i build() {
            return new com.ipd.dsp.internal.z.i();
        }
    }

    /* JADX INFO: renamed from: com.ipd.dsp.internal.components.glide.b$b, reason: collision with other inner class name */
    public class C0868b implements com.ipd.dsp.internal.components.glide.a.InterfaceC0867a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ipd.dsp.internal.z.i f38242a;

        public C0868b(com.ipd.dsp.internal.z.i iVar) {
            this.f38242a = iVar;
        }

        @Override // com.ipd.dsp.internal.components.glide.a.InterfaceC0867a
        @NonNull
        public com.ipd.dsp.internal.z.i build() {
            com.ipd.dsp.internal.z.i iVar = this.f38242a;
            return iVar != null ? iVar : new com.ipd.dsp.internal.z.i();
        }
    }

    public static final class c implements com.ipd.dsp.internal.components.glide.d.b {
    }

    public static final class d implements com.ipd.dsp.internal.components.glide.d.b {
    }

    public static final class e implements com.ipd.dsp.internal.components.glide.d.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f38243a;

        public e(int i) {
            this.f38243a = i;
        }
    }

    @NonNull
    public b a(@Nullable com.ipd.dsp.internal.j.e eVar) {
        this.d = eVar;
        return this;
    }

    @Deprecated
    public b a(boolean z) {
        return this;
    }

    @NonNull
    public b b(@Nullable com.ipd.dsp.internal.l.a aVar) {
        this.h = aVar;
        return this;
    }

    @Deprecated
    public b c(@Nullable com.ipd.dsp.internal.l.a aVar) {
        return d(aVar);
    }

    @NonNull
    public b d(@Nullable com.ipd.dsp.internal.l.a aVar) {
        this.g = aVar;
        return this;
    }

    @NonNull
    public b a(@Nullable com.ipd.dsp.internal.j.b bVar) {
        this.e = bVar;
        return this;
    }

    public b b(boolean z) {
        this.b.a(new c(), z && Build.VERSION.SDK_INT >= 29);
        return this;
    }

    @NonNull
    public b c(boolean z) {
        this.o = z;
        return this;
    }

    public b d(boolean z) {
        this.b.a(new d(), z);
        return this;
    }

    @NonNull
    public b a(@Nullable j jVar) {
        this.f = jVar;
        return this;
    }

    @NonNull
    public b a(@Nullable com.ipd.dsp.internal.k.a.InterfaceC0888a interfaceC0888a) {
        this.i = interfaceC0888a;
        return this;
    }

    @NonNull
    public b a(@Nullable com.ipd.dsp.internal.l.a aVar) {
        this.n = aVar;
        return this;
    }

    @NonNull
    public b a(@Nullable com.ipd.dsp.internal.z.i iVar) {
        return a(new C0868b(iVar));
    }

    @NonNull
    public b a(@NonNull com.ipd.dsp.internal.components.glide.a.InterfaceC0867a interfaceC0867a) {
        this.l = (com.ipd.dsp.internal.components.glide.a.InterfaceC0867a) m.a(interfaceC0867a);
        return this;
    }

    @NonNull
    public <T> b a(@NonNull Class<T> cls, @Nullable i<?, T> iVar) {
        this.f38240a.put(cls, iVar);
        return this;
    }

    @NonNull
    public b a(@NonNull l.a aVar) {
        return a(aVar.a());
    }

    @NonNull
    public b a(@Nullable l lVar) {
        this.j = lVar;
        return this;
    }

    @NonNull
    public b a(@Nullable com.ipd.dsp.internal.w.c cVar) {
        this.k = cVar;
        return this;
    }

    @NonNull
    public b a(@NonNull h<Object> hVar) {
        if (this.p == null) {
            this.p = new ArrayList();
        }
        this.p.add(hVar);
        return this;
    }

    public void a(@Nullable com.ipd.dsp.internal.components.glide.manager.b.InterfaceC0873b interfaceC0873b) {
        this.m = interfaceC0873b;
    }

    public b a(k kVar) {
        this.c = kVar;
        return this;
    }

    @NonNull
    public com.ipd.dsp.internal.components.glide.a a(@NonNull Context context, List<com.ipd.dsp.internal.x.c> list, com.ipd.dsp.internal.x.a aVar) {
        if (this.g == null) {
            this.g = com.ipd.dsp.internal.l.a.h();
        }
        if (this.h == null) {
            this.h = com.ipd.dsp.internal.l.a.f();
        }
        if (this.n == null) {
            this.n = com.ipd.dsp.internal.l.a.d();
        }
        if (this.j == null) {
            this.j = new l.a(context).a();
        }
        if (this.k == null) {
            this.k = new com.ipd.dsp.internal.w.e();
        }
        if (this.d == null) {
            int iB = this.j.b();
            if (iB > 0) {
                this.d = new com.ipd.dsp.internal.j.k(iB);
            } else {
                this.d = new f();
            }
        }
        if (this.e == null) {
            this.e = new com.ipd.dsp.internal.j.j(this.j.a());
        }
        if (this.f == null) {
            this.f = new com.ipd.dsp.internal.k.i(this.j.c());
        }
        if (this.i == null) {
            this.i = new com.ipd.dsp.internal.k.h(context);
        }
        if (this.c == null) {
            this.c = new k(this.f, this.i, this.h, this.g, com.ipd.dsp.internal.l.a.i(), this.n, this.o);
        }
        List<h<Object>> list2 = this.p;
        if (list2 == null) {
            this.p = Collections.EMPTY_LIST;
        } else {
            this.p = Collections.unmodifiableList(list2);
        }
        return new com.ipd.dsp.internal.components.glide.a(context, this.c, this.f, this.d, this.e, new com.ipd.dsp.internal.components.glide.manager.b(this.m), this.k, this.l, this.f38240a, this.p, list, aVar, this.b.a());
    }
}
