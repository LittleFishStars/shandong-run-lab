package com.zj.adlib;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.p002lifecycle.ViewModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class i62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f42289a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SparseArray f17158a = new SparseArray();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ViewModel f17159a;
    public final int b;

    public i62(@NonNull Integer layout, @NonNull Integer vmVariableId, @NonNull ViewModel stateViewModel) {
        this.f42289a = layout.intValue();
        this.b = vmVariableId.intValue();
        this.f17159a = stateViewModel;
    }

    public i62 a(@NonNull Integer variableId, @NonNull Object object) {
        if (this.f17158a.get(variableId.intValue()) == null) {
            this.f17158a.put(variableId.intValue(), object);
        }
        return this;
    }

    public SparseArray b() {
        return this.f17158a;
    }

    public int c() {
        return this.f42289a;
    }

    public ViewModel d() {
        return this.f17159a;
    }

    public int e() {
        return this.b;
    }
}
