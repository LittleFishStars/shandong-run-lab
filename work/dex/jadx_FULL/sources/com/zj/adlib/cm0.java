package com.zj.adlib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class cm0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, Integer> f40995a = new HashMap();

    public Integer a(int i) {
        return this.f40995a.get(Integer.valueOf(i));
    }

    public int[] b() {
        ArrayList arrayList = new ArrayList();
        int iIntValue = -1;
        for (Map.Entry<Integer, Integer> entry : this.f40995a.entrySet()) {
            if (entry.getValue().intValue() > iIntValue) {
                iIntValue = entry.getValue().intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
            } else if (entry.getValue().intValue() == iIntValue) {
                arrayList.add(entry.getKey());
            }
        }
        return lh6.c(arrayList);
    }

    public void c(int i) {
        Integer num = this.f40995a.get(Integer.valueOf(i));
        if (num == null) {
            num = 0;
        }
        this.f40995a.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
    }
}
