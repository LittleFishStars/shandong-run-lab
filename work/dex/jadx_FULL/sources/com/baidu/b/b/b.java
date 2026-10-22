package com.baidu.b.b;

import java.util.Comparator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class b implements Comparator {
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(a aVar, a aVar2) {
        long jB = aVar.b() - aVar2.b();
        if (jB != 0) {
            return jB > 0 ? -1 : 1;
        }
        return aVar.a().compareTo(aVar2.a());
    }
}
