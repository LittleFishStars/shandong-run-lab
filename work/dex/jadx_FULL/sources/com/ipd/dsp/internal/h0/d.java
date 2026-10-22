package com.ipd.dsp.internal.h0;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class d implements e {
    public static final int g = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<b> f38317a;
    public final HashMap<String, String> b;

    @NonNull
    public final f c;
    public final SparseArray<com.ipd.dsp.internal.g0.a> d;
    public final List<Integer> e;
    public final List<Integer> f;

    public d() {
        this(new SparseArray(), new ArrayList(), new HashMap());
    }

    @Override // com.ipd.dsp.internal.h0.e
    public void a(@NonNull b bVar, int i, long j) throws IOException {
        b bVar2 = this.f38317a.get(bVar.f38316a);
        if (bVar != bVar2) {
            throw new IOException("Info not on store!");
        }
        bVar2.b(i).a(j);
    }

    @Override // com.ipd.dsp.internal.h0.c
    public boolean a() {
        return true;
    }

    @Override // com.ipd.dsp.internal.h0.c
    @NonNull
    public b b(@NonNull com.ipd.dsp.internal.f0.f fVar) {
        int iB = fVar.b();
        b bVar = new b(iB, fVar.e(), fVar.c(), fVar.a());
        synchronized (this) {
            this.f38317a.put(iB, bVar);
            this.d.remove(iB);
        }
        return bVar;
    }

    @Override // com.ipd.dsp.internal.h0.e
    public void b(int i) {
    }

    @Override // com.ipd.dsp.internal.h0.e
    public boolean c(int i) {
        if (this.f.contains(Integer.valueOf(i))) {
            return false;
        }
        synchronized (this.f) {
            if (this.f.contains(Integer.valueOf(i))) {
                return false;
            }
            this.f.add(Integer.valueOf(i));
            return true;
        }
    }

    @Override // com.ipd.dsp.internal.h0.e
    public boolean d(int i) {
        boolean zRemove;
        synchronized (this.f) {
            zRemove = this.f.remove(Integer.valueOf(i));
        }
        return zRemove;
    }

    @Override // com.ipd.dsp.internal.h0.e
    @Nullable
    public b e(int i) {
        return null;
    }

    @Override // com.ipd.dsp.internal.h0.c
    public b get(int i) {
        return this.f38317a.get(i);
    }

    @Override // com.ipd.dsp.internal.h0.c
    public synchronized void remove(int i) {
        this.f38317a.remove(i);
        if (this.d.get(i) == null) {
            this.e.remove(Integer.valueOf(i));
        }
        this.c.a(i);
    }

    public d(SparseArray<b> sparseArray, List<Integer> list, HashMap<String, String> map, SparseArray<com.ipd.dsp.internal.g0.a> sparseArray2, List<Integer> list2, f fVar) {
        this.d = sparseArray2;
        this.f = list;
        this.f38317a = sparseArray;
        this.b = map;
        this.e = list2;
        this.c = fVar;
    }

    @Override // com.ipd.dsp.internal.h0.c
    public boolean a(@NonNull b bVar) {
        String strE = bVar.e();
        if (bVar.m() && strE != null) {
            this.b.put(bVar.j(), strE);
        }
        b bVar2 = this.f38317a.get(bVar.f38316a);
        if (bVar2 == null) {
            return false;
        }
        if (bVar2 == bVar) {
            return true;
        }
        synchronized (this) {
            this.f38317a.put(bVar.f38316a, bVar.a());
        }
        return true;
    }

    public synchronized int b() {
        int iIntValue;
        int i = 0;
        int size = 0;
        int i2 = 0;
        while (true) {
            iIntValue = 1;
            if (size >= this.e.size()) {
                size = 0;
                break;
            }
            Integer num = this.e.get(size);
            if (num == null) {
                i = i2 + 1;
                break;
            }
            int iIntValue2 = num.intValue();
            if (i2 != 0) {
                int i3 = i2 + 1;
                if (iIntValue2 != i3) {
                    i = i3;
                    break;
                }
                size++;
                i2 = iIntValue2;
            } else {
                if (iIntValue2 != 1) {
                    size = 0;
                    i = 1;
                    break;
                }
                size++;
                i2 = iIntValue2;
            }
            throw th;
        }
        if (i != 0) {
            iIntValue = i;
        } else if (!this.e.isEmpty()) {
            List<Integer> list = this.e;
            iIntValue = 1 + list.get(list.size() - 1).intValue();
            size = this.e.size();
        }
        this.e.add(size, Integer.valueOf(iIntValue));
        return iIntValue;
    }

    public d(SparseArray<b> sparseArray, List<Integer> list, HashMap<String, String> map) {
        this.d = new SparseArray<>();
        this.f38317a = sparseArray;
        this.f = list;
        this.b = map;
        this.c = new f();
        int size = sparseArray.size();
        this.e = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.e.add(Integer.valueOf(sparseArray.valueAt(i).f38316a));
        }
        Collections.sort(this.e);
    }

    @Override // com.ipd.dsp.internal.h0.e
    public void a(int i, @NonNull com.ipd.dsp.internal.i0.a aVar, @Nullable Exception exc) {
        if (aVar == com.ipd.dsp.internal.i0.a.COMPLETED) {
            remove(i);
        }
    }

    @Override // com.ipd.dsp.internal.h0.c
    public synchronized int a(@NonNull com.ipd.dsp.internal.f0.f fVar) {
        Integer numB = this.c.b(fVar);
        if (numB != null) {
            return numB.intValue();
        }
        int size = this.f38317a.size();
        for (int i = 0; i < size; i++) {
            b bVarValueAt = this.f38317a.valueAt(i);
            if (bVarValueAt != null && bVarValueAt.a(fVar)) {
                return bVarValueAt.f38316a;
            }
        }
        int size2 = this.d.size();
        for (int i2 = 0; i2 < size2; i2++) {
            com.ipd.dsp.internal.g0.a aVarValueAt = this.d.valueAt(i2);
            if (aVarValueAt != null && aVarValueAt.a(fVar)) {
                return aVarValueAt.b();
            }
        }
        int iB = b();
        this.d.put(iB, fVar.b(iB));
        this.c.a(fVar, iB);
        return iB;
    }

    @Override // com.ipd.dsp.internal.h0.c
    public b a(@NonNull com.ipd.dsp.internal.f0.f fVar, @NonNull b bVar) {
        SparseArray<b> sparseArrayClone;
        synchronized (this) {
            sparseArrayClone = this.f38317a.clone();
        }
        int size = sparseArrayClone.size();
        for (int i = 0; i < size; i++) {
            b bVarValueAt = sparseArrayClone.valueAt(i);
            if (bVarValueAt != bVar && bVarValueAt.a(fVar)) {
                return bVarValueAt;
            }
        }
        return null;
    }

    @Override // com.ipd.dsp.internal.h0.c
    public boolean a(int i) {
        return this.f.contains(Integer.valueOf(i));
    }

    @Override // com.ipd.dsp.internal.h0.c
    @Nullable
    public String a(String str) {
        return this.b.get(str);
    }
}
