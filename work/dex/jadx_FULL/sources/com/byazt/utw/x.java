package com.byazt.utw;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 450, 71})
public class x {
    public static final Set<String> c = new HashSet();
    public static final Set<String> tt = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f29116a;
    public int n = -1;
    public final int sp;
    public final int uj;
    public final ArrayList<c> ve;

    @com.byazt.zqa.c(c = {0, 1, 450, 62})
    public class c {
        public final String c;
        public int tt;

        public c(String str) {
            this.c = str;
        }

        public void c() {
            x.c.add(this.c);
        }

        public String toString() {
            return this.c;
        }

        public void tt() {
            x.tt.add(this.c);
        }
    }

    public x(List<String> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("urls can't be empty");
        }
        int size = list.size();
        this.uj = size;
        this.ve = new ArrayList<>(size);
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (String str : list) {
            c cVar = new c(str);
            if (c.contains(str)) {
                arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                arrayList2.add(cVar);
            } else if (tt.contains(str)) {
                arrayList = arrayList == null ? new ArrayList() : arrayList;
                arrayList.add(cVar);
            } else {
                this.ve.add(cVar);
            }
        }
        if (arrayList != null) {
            this.ve.addAll(arrayList);
        }
        if (arrayList2 != null) {
            this.ve.addAll(arrayList2);
        }
        Integer num = uj.uj;
        this.sp = (num == null || num.intValue() <= 0) ? this.uj >= 2 ? 1 : 2 : num.intValue();
    }

    public boolean c() {
        return this.f29116a < this.sp;
    }

    public c tt() {
        if (!c()) {
            throw new NoSuchElementException();
        }
        int i = this.n + 1;
        if (i >= this.uj - 1) {
            this.n = -1;
            this.f29116a++;
        } else {
            this.n = i;
        }
        c cVar = this.ve.get(i);
        cVar.tt = (this.f29116a * this.uj) + this.n;
        return cVar;
    }
}
