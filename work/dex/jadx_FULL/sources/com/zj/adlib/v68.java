package com.zj.adlib;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class v68<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f45296a = "Set contributions cannot be null";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<T> f20186a;

    public v68(int i) {
        this.f20186a = new ArrayList(i);
    }

    public static <T> v68<T> d(int i) {
        return new v68<>(i);
    }

    public v68<T> a(T t) {
        this.f20186a.add((T) xw6.c(t, f45296a));
        return this;
    }

    public v68<T> b(Collection<? extends T> collection) {
        Iterator<? extends T> it = collection.iterator();
        while (it.hasNext()) {
            xw6.c(it.next(), f45296a);
        }
        this.f20186a.addAll(collection);
        return this;
    }

    public Set<T> c() {
        int size = this.f20186a.size();
        if (size != 0) {
            return size != 1 ? Collections.unmodifiableSet(new HashSet(this.f20186a)) : Collections.singleton(this.f20186a.get(0));
        }
        return Collections.emptySet();
    }
}
