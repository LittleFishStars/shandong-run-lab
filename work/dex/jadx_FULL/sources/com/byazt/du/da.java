package com.byazt.du;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 441, 72})
public class da {
    public static float c(float f) {
        return (float) Math.ceil((f * 16.0f) / 16.0f);
    }

    public static List<tt.c> c(float f, List<tt.c> list) {
        ArrayList<tt.c> arrayList = new ArrayList();
        Iterator<tt.c> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((tt.c) it.next().clone());
        }
        boolean z = true;
        int i = 0;
        int i2 = 0;
        for (tt.c cVar : arrayList) {
            if (cVar.tt) {
                i = (int) (i + cVar.c);
            } else {
                i2 = (int) (i2 + cVar.c);
                z = false;
            }
        }
        if (z && f > i) {
            return arrayList;
        }
        float f2 = i;
        float f3 = f < f2 ? f / f2 : 1.0f;
        float f4 = f > f2 ? (f - f2) / i2 : 0.0f;
        if (f4 > 1.0f) {
            ArrayList arrayList2 = new ArrayList();
            boolean z2 = false;
            for (tt.c cVar2 : arrayList) {
                if (!cVar2.tt) {
                    float f5 = cVar2.ve;
                    if (f5 != 0.0f && cVar2.c * f4 > f5) {
                        cVar2.c = f5;
                        cVar2.tt = true;
                        z2 = true;
                    }
                }
                arrayList2.add(cVar2);
            }
            if (z2) {
                return c(f, arrayList2);
            }
        }
        int i3 = 0;
        for (tt.c cVar3 : arrayList) {
            if (cVar3.tt) {
                cVar3.c = c(cVar3.c * f3);
            } else {
                cVar3.c = c(cVar3.c * f4);
            }
            i3 = (int) (i3 + cVar3.c);
        }
        float f6 = i3;
        if (f6 < f) {
            float f7 = f - f6;
            for (int size = 0; size < arrayList.size() && f7 > 0.0f; size = (size + 1) % arrayList.size()) {
                tt.c cVar4 = (tt.c) arrayList.get(size);
                if ((f < f2 && cVar4.tt) || (f > f2 && !cVar4.tt)) {
                    cVar4.c += 0.0625f;
                    f7 -= 0.0625f;
                }
            }
        }
        return arrayList;
    }
}
