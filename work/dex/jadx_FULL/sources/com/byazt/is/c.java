package com.byazt.is;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 984, 20})
public class c {
    public List<ve> c = new ArrayList();

    public List<ve> c() {
        return this.c;
    }

    public void c(Set<String> set) {
        ArrayList arrayList = new ArrayList();
        for (ve veVar : this.c) {
            if (!set.contains(veVar.t())) {
                arrayList.add(veVar);
            }
        }
        this.c = arrayList;
    }

    public void c(List<ve> list) {
        this.c = list;
    }
}
