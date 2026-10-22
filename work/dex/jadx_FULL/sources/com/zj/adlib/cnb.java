package com.zj.adlib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class cnb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<Integer, a> f41006a = new ConcurrentHashMap<>();

    public class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public List<T> f15860a = Collections.synchronizedList(new ArrayList());

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public T f15859a = null;

        public a() {
        }
    }

    public final <T> List<T> a(int i) {
        try {
            a aVar = this.f41006a.get(Integer.valueOf(i));
            if (aVar != null) {
                return aVar.f15860a;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final <T> void b() {
        ConcurrentHashMap<Integer, a> concurrentHashMap = this.f41006a;
        if (concurrentHashMap == null) {
            return;
        }
        try {
            Iterator<Map.Entry<Integer, a>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                a value = it.next().getValue();
                value.f15860a.clear();
                value.f15859a = null;
            }
            this.f41006a.clear();
        } catch (Throwable unused) {
        }
    }

    public final <T> void c(int i, T t) {
        ConcurrentHashMap<Integer, a> concurrentHashMap = this.f41006a;
        if (concurrentHashMap == null) {
            return;
        }
        try {
            a aVar = concurrentHashMap.get(Integer.valueOf(i));
            if (aVar == null) {
                aVar = new a();
                this.f41006a.putIfAbsent(Integer.valueOf(i), aVar);
            }
            if (aVar.f15859a == t) {
                return;
            }
            f(Integer.valueOf(i), aVar.f15859a);
            aVar.f15859a = t;
            e(Integer.valueOf(i), t);
        } catch (Throwable unused) {
        }
    }

    public final <T> void d(Integer num) {
        a aVar;
        List<T> list;
        try {
            if (!this.f41006a.containsKey(num) || (aVar = this.f41006a.get(num)) == null || (list = aVar.f15860a) == null) {
                return;
            }
            list.clear();
        } catch (Throwable unused) {
        }
    }

    public final <T> void e(Integer num, T t) {
        ConcurrentHashMap<Integer, a> concurrentHashMap;
        if (t == null || (concurrentHashMap = this.f41006a) == null) {
            return;
        }
        try {
            a aVar = concurrentHashMap.get(num);
            if (aVar == null) {
                aVar = new a();
                this.f41006a.putIfAbsent(num, aVar);
            }
            List<T> list = aVar.f15860a;
            if (list == null || list.contains(t)) {
                return;
            }
            aVar.f15860a.add(t);
        } catch (Throwable unused) {
        }
    }

    public final <T> void f(Integer num, T t) {
        ConcurrentHashMap<Integer, a> concurrentHashMap;
        a aVar;
        List<T> list;
        if (t == null || (concurrentHashMap = this.f41006a) == null) {
            return;
        }
        try {
            if (!concurrentHashMap.containsKey(num) || (aVar = this.f41006a.get(num)) == null || (list = aVar.f15860a) == null || !list.contains(t)) {
                return;
            }
            aVar.f15860a.remove(t);
        } catch (Throwable unused) {
        }
    }
}
