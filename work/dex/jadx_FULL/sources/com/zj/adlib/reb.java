package com.zj.adlib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class reb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public lhb f44437a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<mhb> f19280a = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<mhb> f19279a = new ArrayList<>();

    public class a implements Comparator<mhb> {
        public a() {
        }

        public static int a(mhb mhbVar, mhb mhbVar2) {
            return mhbVar2.f43306a - mhbVar.f43306a;
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(mhb mhbVar, mhb mhbVar2) {
            return a(mhbVar, mhbVar2);
        }
    }

    public static List<mhb> b(List<mhb> list) {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            mhb mhbVar = list.get(i);
            map.put(Integer.valueOf(mhbVar.f43306a), mhbVar);
        }
        arrayList.addAll(map.values());
        return arrayList;
    }

    public static boolean d(lhb lhbVar, long j, long j2) {
        return j > 0 && j2 - j < ((long) ((((khb) lhbVar).f17701a > 10.0f ? 1 : (((khb) lhbVar).f17701a == 10.0f ? 0 : -1)) >= 0 ? 2000 : 3500));
    }

    public static boolean e(List<mhb> list, List<mhb> list2) {
        if (list != null && list2 != null) {
            int size = list.size();
            int size2 = list2.size();
            int i = size + size2;
            if (size <= size2) {
                list2 = list;
                list = list2;
            }
            HashMap map = new HashMap(list.size());
            Iterator<mhb> it = list.iterator();
            while (it.hasNext()) {
                map.put(Long.valueOf(it.next().f18215a), 1);
            }
            Iterator<mhb> it2 = list2.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                if (((Integer) map.get(Long.valueOf(it2.next().f18215a))) != null) {
                    i2++;
                }
            }
            if (((double) i2) * 2.0d >= ((double) i) * 0.5d) {
                return true;
            }
        }
        return false;
    }

    public final List<mhb> a(lhb lhbVar, List<mhb> list, boolean z, long j, long j2) {
        if (!h(lhbVar, list, z, j, j2)) {
            return null;
        }
        g(this.f19279a, list);
        this.f19280a.clear();
        this.f19280a.addAll(list);
        this.f44437a = lhbVar;
        return this.f19279a;
    }

    public final boolean c(lhb lhbVar) {
        float f = ((khb) lhbVar).f17701a;
        float f2 = 10.0f;
        if (f > 10.0f) {
            f2 = 200.0f;
        } else if (f > 2.0f) {
            f2 = 50.0f;
        }
        return lhbVar.a(this.f44437a) > ((double) f2);
    }

    public final List<mhb> f(List<mhb> list) {
        Collections.sort(list, new a());
        return list;
    }

    public final void g(List<mhb> list, List<mhb> list2) {
        list.clear();
        if (list2 != null) {
            List<mhb> listF = f(b(list2));
            int size = listF.size();
            if (size > 40) {
                size = 40;
            }
            for (int i = 0; i < size; i++) {
                list.add(listF.get(i));
            }
        }
    }

    public final boolean h(lhb lhbVar, List<mhb> list, boolean z, long j, long j2) {
        if (!z || !d(lhbVar, j, j2) || list == null || list.size() <= 0) {
            return false;
        }
        if (this.f44437a == null) {
            return true;
        }
        boolean zC = c(lhbVar);
        return !zC ? true ^ e(list, this.f19280a) : zC;
    }
}
