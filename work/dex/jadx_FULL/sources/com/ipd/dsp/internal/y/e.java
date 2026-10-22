package com.ipd.dsp.internal.y;

import androidx.annotation.NonNull;
import com.ipd.dsp.internal.f.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f38610a = new ArrayList();
    public final Map<String, List<a<?, ?>>> b = new HashMap();

    public static class a<T, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<T> f38611a;
        public final Class<R> b;
        public final k<T, R> c;

        public a(@NonNull Class<T> cls, @NonNull Class<R> cls2, k<T, R> kVar) {
            this.f38611a = cls;
            this.b = cls2;
            this.c = kVar;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.f38611a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.b);
        }
    }

    public synchronized void a(@NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(this.f38610a);
        this.f38610a.clear();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.f38610a.add(it.next());
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            String str = (String) obj;
            if (!list.contains(str)) {
                this.f38610a.add(str);
            }
        }
    }

    @NonNull
    public synchronized <T, R> List<Class<R>> b(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.f38610a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.b)) {
                        arrayList.add(aVar.b);
                    }
                }
            }
        }
        return arrayList;
    }

    @NonNull
    public synchronized <T, R> List<k<T, R>> a(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.f38610a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.c);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> void b(@NonNull String str, @NonNull k<T, R> kVar, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        a(str).add(0, new a<>(cls, cls2, kVar));
    }

    public synchronized <T, R> void a(@NonNull String str, @NonNull k<T, R> kVar, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        a(str).add(new a<>(cls, cls2, kVar));
    }

    @NonNull
    public final synchronized List<a<?, ?>> a(@NonNull String str) {
        if (!this.f38610a.contains(str)) {
            this.f38610a.add(str);
        }
        List<a<?, ?>> list = this.b.get(str);
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        this.b.put(str, arrayList);
        return arrayList;
    }
}
