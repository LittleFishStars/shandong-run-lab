package com.baidu.b;

import java.util.Comparator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class d implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f26293a;

    public d(c cVar) {
        this.f26293a = cVar;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(b bVar, b bVar2) {
        int i = bVar2.b - bVar.b;
        if (i == 0) {
            boolean z = bVar.d;
            if (z && bVar2.d) {
                return 0;
            }
            if (z) {
                return -1;
            }
            if (bVar2.d) {
                return 1;
            }
        }
        return i;
    }
}
