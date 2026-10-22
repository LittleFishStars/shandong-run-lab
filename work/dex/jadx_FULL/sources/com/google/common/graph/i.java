package com.google.common.graph;

import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
public final class i<K, V> extends h<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    public volatile transient a<K, V> f32106a;

    @CheckForNull
    public volatile transient a<K, V> b;

    public static final class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f32107a;
        public final V b;

        public a(K k, V v) {
            this.f32107a = k;
            this.b = v;
        }
    }

    public i(Map<K, V> map) {
        super(map);
    }

    @Override // com.google.common.graph.h
    public void d() {
        super.d();
        this.f32106a = null;
        this.b = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.h
    @CheckForNull
    public V f(Object obj) {
        com.google.common.base.i.E(obj);
        V vG = g(obj);
        if (vG != null) {
            return vG;
        }
        V vH = h(obj);
        if (vH != null) {
            m(obj, vH);
        }
        return vH;
    }

    @Override // com.google.common.graph.h
    @CheckForNull
    public V g(@CheckForNull Object obj) {
        V v = (V) super.g(obj);
        if (v != null) {
            return v;
        }
        a<K, V> aVar = this.f32106a;
        if (aVar != null && aVar.f32107a == obj) {
            return aVar.b;
        }
        a<K, V> aVar2 = this.b;
        if (aVar2 == null || aVar2.f32107a != obj) {
            return null;
        }
        l(aVar2);
        return aVar2.b;
    }

    public final void l(a<K, V> aVar) {
        this.b = this.f32106a;
        this.f32106a = aVar;
    }

    public final void m(K k, V v) {
        l(new a<>(k, v));
    }
}
