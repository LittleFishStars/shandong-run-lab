package com.zj.adlib;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class w68<T> implements Factory<Set<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Factory<Set<Object>> f45531a = jb4.a(Collections.emptySet());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<Provider<T>> f20381a;
    public final List<Provider<Collection<T>>> b;

    public static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ boolean f45532a = false;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final List<Provider<T>> f20382a;
        public final List<Provider<Collection<T>>> b;

        public b<T> a(Provider<? extends Collection<? extends T>> provider) {
            this.b.add(provider);
            return this;
        }

        public b<T> b(Provider<? extends T> provider) {
            this.f20382a.add(provider);
            return this;
        }

        public w68<T> c() {
            return new w68<>(this.f20382a, this.b);
        }

        public b(int i, int i2) {
            this.f20382a = r52.e(i);
            this.b = r52.e(i2);
        }
    }

    public static <T> b<T> a(int i, int i2) {
        return new b<>(i, i2);
    }

    public static <T> Factory<Set<T>> b() {
        return (Factory<Set<T>>) f45531a;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Set<T> get() {
        int size = this.f20381a.size();
        ArrayList arrayList = new ArrayList(this.b.size());
        int size2 = this.b.size();
        for (int i = 0; i < size2; i++) {
            Collection collection = (Collection) this.b.get(i).get();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet hashSetC = r52.c(size);
        int size3 = this.f20381a.size();
        for (int i2 = 0; i2 < size3; i2++) {
            hashSetC.add(xw6.b(this.f20381a.get(i2).get()));
        }
        int size4 = arrayList.size();
        for (int i3 = 0; i3 < size4; i3++) {
            Iterator it = ((Collection) arrayList.get(i3)).iterator();
            while (it.hasNext()) {
                hashSetC.add(xw6.b(it.next()));
            }
        }
        return Collections.unmodifiableSet(hashSetC);
    }

    public w68(List<Provider<T>> list, List<Provider<Collection<T>>> list2) {
        this.f20381a = list;
        this.b = list2;
    }
}
