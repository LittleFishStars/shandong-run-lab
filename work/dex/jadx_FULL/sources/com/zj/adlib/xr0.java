package com.zj.adlib;

import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.common.collect.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class xr0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Long> f45882a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Random f20709a;
    public final Map<Integer, Long> b;
    public final Map<List<Pair<String, Integer>>, vr0> c;

    public xr0() {
        this(new Random());
    }

    public static <T> void b(T t, long j, Map<T, Long> map) {
        if (map.containsKey(t)) {
            j = Math.max(j, ((Long) gj9.k(map.get(t))).longValue());
        }
        map.put(t, Long.valueOf(j));
    }

    public static int d(vr0 vr0Var, vr0 vr0Var2) {
        int iCompare = Integer.compare(vr0Var.f45424a, vr0Var2.f45424a);
        return iCompare != 0 ? iCompare : vr0Var.f20282b.compareTo(vr0Var2.f20282b);
    }

    public static int f(List<vr0> list) {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < list.size(); i++) {
            hashSet.add(Integer.valueOf(list.get(i).f45424a));
        }
        return hashSet.size();
    }

    public static <T> void h(long j, Map<T, Long> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<T, Long> entry : map.entrySet()) {
            if (entry.getValue().longValue() <= j) {
                arrayList.add(entry.getKey());
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            map.remove(arrayList.get(i));
        }
    }

    public final List<vr0> c(List<vr0> list) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        h(jElapsedRealtime, this.f45882a);
        h(jElapsedRealtime, this.b);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            vr0 vr0Var = list.get(i);
            if (!this.f45882a.containsKey(vr0Var.f20282b) && !this.b.containsKey(Integer.valueOf(vr0Var.f45424a))) {
                arrayList.add(vr0Var);
            }
        }
        return arrayList;
    }

    public void e(vr0 vr0Var, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() + j;
        b(vr0Var.f20282b, jElapsedRealtime, this.f45882a);
        int i = vr0Var.f45424a;
        if (i != Integer.MIN_VALUE) {
            b(Integer.valueOf(i), jElapsedRealtime, this.b);
        }
    }

    public int g(List<vr0> list) {
        HashSet hashSet = new HashSet();
        List<vr0> listC = c(list);
        for (int i = 0; i < listC.size(); i++) {
            hashSet.add(Integer.valueOf(listC.get(i).f45424a));
        }
        return hashSet.size();
    }

    public void i() {
        this.f45882a.clear();
        this.b.clear();
        this.c.clear();
    }

    @Nullable
    public vr0 j(List<vr0> list) {
        List<vr0> listC = c(list);
        if (listC.size() < 2) {
            return (vr0) o.v(listC, null);
        }
        Collections.sort(listC, new Comparator() { // from class: com.zj.adlib.wr0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return xr0.d((vr0) obj, (vr0) obj2);
            }
        });
        ArrayList arrayList = new ArrayList();
        int i = listC.get(0).f45424a;
        for (int i2 = 0; i2 < listC.size(); i2++) {
            vr0 vr0Var = listC.get(i2);
            if (i != vr0Var.f45424a) {
                if (arrayList.size() != 1) {
                    break;
                }
                return listC.get(0);
            }
            arrayList.add(new Pair(vr0Var.f20282b, Integer.valueOf(vr0Var.b)));
        }
        vr0 vr0Var2 = this.c.get(arrayList);
        if (vr0Var2 != null) {
            return vr0Var2;
        }
        vr0 vr0VarK = k(listC.subList(0, arrayList.size()));
        this.c.put(arrayList, vr0VarK);
        return vr0VarK;
    }

    public final vr0 k(List<vr0> list) {
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            i += list.get(i2).b;
        }
        int iNextInt = this.f20709a.nextInt(i);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            vr0 vr0Var = list.get(i4);
            i3 += vr0Var.b;
            if (iNextInt < i3) {
                return vr0Var;
            }
        }
        return (vr0) o.w(list);
    }

    @VisibleForTesting
    public xr0(Random random) {
        this.c = new HashMap();
        this.f20709a = random;
        this.f45882a = new HashMap();
        this.b = new HashMap();
    }
}
