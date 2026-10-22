package com.byazt.w;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1017, 71})
public class x<K, T> extends LinkedHashMap<K, T> {
    public int c;

    public x() {
        this(4, 4);
    }

    public void c(int i) {
        this.c = i;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, T> entry) {
        return size() > this.c;
    }

    public x(int i, int i2) {
        this(i, i2, true);
    }

    public x(int i, int i2, boolean z) {
        super(i, 0.75f, z);
        c(i2);
    }
}
