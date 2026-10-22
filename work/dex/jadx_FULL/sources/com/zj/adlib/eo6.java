package com.zj.adlib;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class eo6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f41481a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final rk2 f16368a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final String f16369a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<vz> f16370a;
    public final List<s53> b;

    public eo6(@Nullable String str, long j, List<vz> list) {
        this(str, j, list, Collections.emptyList(), null);
    }

    public int a(int i) {
        int size = this.f16370a.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f16370a.get(i2).b == i) {
                return i2;
            }
        }
        return -1;
    }

    public eo6(@Nullable String str, long j, List<vz> list, List<s53> list2) {
        this(str, j, list, list2, null);
    }

    public eo6(@Nullable String str, long j, List<vz> list, List<s53> list2, @Nullable rk2 rk2Var) {
        this.f16369a = str;
        this.f41481a = j;
        this.f16370a = Collections.unmodifiableList(list);
        this.b = Collections.unmodifiableList(list2);
        this.f16368a = rk2Var;
    }
}
