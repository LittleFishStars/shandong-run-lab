package com.ipd.dsp.internal.h0;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final HashMap<String, Integer> f38318a;

    @NonNull
    public final SparseArray<String> b;

    public f() {
        this(new HashMap(), new SparseArray());
    }

    public void a(int i) {
        String str = this.b.get(i);
        if (str != null) {
            this.f38318a.remove(str);
            this.b.remove(i);
        }
    }

    @Nullable
    public Integer b(@NonNull com.ipd.dsp.internal.f0.f fVar) {
        Integer num = this.f38318a.get(a(fVar));
        if (num != null) {
            return num;
        }
        return null;
    }

    public f(@NonNull HashMap<String, Integer> map, @NonNull SparseArray<String> sparseArray) {
        this.f38318a = map;
        this.b = sparseArray;
    }

    public void a(@NonNull com.ipd.dsp.internal.f0.f fVar, int i) {
        String strA = a(fVar);
        this.f38318a.put(strA, Integer.valueOf(i));
        this.b.put(i, strA);
    }

    public String a(@NonNull com.ipd.dsp.internal.f0.f fVar) {
        return fVar.e() + fVar.x() + fVar.a();
    }
}
