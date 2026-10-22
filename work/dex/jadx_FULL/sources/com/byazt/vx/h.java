package com.byazt.vx;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 962, 518})
public class h {
    public static <T> void c(List<T> list, @NonNull Comparator<T> comparator) {
        if (list == null || list.size() <= 1) {
            return;
        }
        try {
            Collections.sort(list, comparator);
        } catch (Throwable unused) {
            List listAsList = Arrays.asList(list.toArray());
            Collections.sort(listAsList, comparator);
            list.clear();
            list.addAll(listAsList);
        }
    }

    public static <T extends Comparable<? super T>> void c(List<T> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        try {
            Collections.sort(list);
        } catch (Throwable unused) {
            List listAsList = Arrays.asList(list.toArray());
            Collections.sort(listAsList);
            list.clear();
            list.addAll(listAsList);
        }
    }
}
