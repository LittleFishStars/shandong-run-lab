package com.zj.adlib;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.google.android.datatransport.Priority;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class sy6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SparseArray<Priority> f44812a = new SparseArray<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static HashMap<Priority, Integer> f19682a;

    static {
        HashMap<Priority, Integer> map = new HashMap<>();
        f19682a = map;
        map.put(Priority.DEFAULT, 0);
        f19682a.put(Priority.VERY_LOW, 1);
        f19682a.put(Priority.HIGHEST, 2);
        for (Priority priority : f19682a.keySet()) {
            f44812a.append(f19682a.get(priority).intValue(), priority);
        }
    }

    public static int a(@NonNull Priority priority) {
        Integer num = f19682a.get(priority);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + priority);
    }

    @NonNull
    public static Priority b(int i) {
        Priority priority = f44812a.get(i);
        if (priority != null) {
            return priority;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i);
    }
}
