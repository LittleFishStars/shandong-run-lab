package com.byazt.oi;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1933, 13})
public class tt {
    public static void c(List<Integer> list) {
        if (list == null) {
            return;
        }
        while (list.contains(null)) {
            list.remove((Object) null);
        }
        if (list.size() <= 1) {
            return;
        }
        int size = list.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = list.get(i).intValue();
        }
        for (int i2 = 1; i2 < size; i2++) {
            int i3 = iArr[i2];
            int i4 = i2;
            while (i4 > 0) {
                int i5 = iArr[i4 - 1];
                if (i5 <= i3) {
                    break;
                }
                iArr[i4] = i5;
                i4--;
            }
            iArr[i4] = i3;
        }
        list.clear();
        for (int i6 = 0; i6 < size; i6++) {
            try {
                list.add(Integer.valueOf(iArr[i6]));
            } catch (RuntimeException unused) {
                return;
            }
        }
    }
}
