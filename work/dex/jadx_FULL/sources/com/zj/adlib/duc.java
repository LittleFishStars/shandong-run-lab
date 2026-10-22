package com.zj.adlib;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class duc implements Map.Entry, Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bvc f41277a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Comparable f16089a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f16090a;

    public duc(bvc bvcVar, Comparable comparable, Object obj) {
        this.f41277a = bvcVar;
        this.f16089a = comparable;
        this.f16090a = obj;
    }

    public static final boolean b(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public final Comparable a() {
        return this.f16089a;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.f16089a.compareTo(((duc) obj).f16089a);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return b(this.f16089a, entry.getKey()) && b(this.f16090a, entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f16089a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f16090a;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f16089a;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f16090a;
        return iHashCode ^ (obj != null ? obj.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f41277a.o();
        Object obj2 = this.f16090a;
        this.f16090a = obj;
        return obj2;
    }

    public final String toString() {
        return String.valueOf(this.f16089a) + "=" + String.valueOf(this.f16090a);
    }
}
