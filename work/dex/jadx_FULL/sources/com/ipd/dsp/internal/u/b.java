package com.ipd.dsp.internal.u;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b implements com.ipd.dsp.internal.e.a.InterfaceC0876a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ipd.dsp.internal.j.e f38545a;

    @Nullable
    public final com.ipd.dsp.internal.j.b b;

    public b(com.ipd.dsp.internal.j.e eVar) {
        this(eVar, null);
    }

    @Override // com.ipd.dsp.internal.e.a.InterfaceC0876a
    @NonNull
    public Bitmap a(int i, int i2, @NonNull Bitmap.Config config) {
        return this.f38545a.b(i, i2, config);
    }

    @Override // com.ipd.dsp.internal.e.a.InterfaceC0876a
    @NonNull
    public int[] b(int i) {
        com.ipd.dsp.internal.j.b bVar = this.b;
        return bVar == null ? new int[i] : (int[]) bVar.b(i, int[].class);
    }

    public b(com.ipd.dsp.internal.j.e eVar, @Nullable com.ipd.dsp.internal.j.b bVar) {
        this.f38545a = eVar;
        this.b = bVar;
    }

    @Override // com.ipd.dsp.internal.e.a.InterfaceC0876a
    public void a(@NonNull Bitmap bitmap) {
        this.f38545a.a(bitmap);
    }

    @Override // com.ipd.dsp.internal.e.a.InterfaceC0876a
    @NonNull
    public byte[] a(int i) {
        com.ipd.dsp.internal.j.b bVar = this.b;
        if (bVar == null) {
            return new byte[i];
        }
        return (byte[]) bVar.b(i, byte[].class);
    }

    @Override // com.ipd.dsp.internal.e.a.InterfaceC0876a
    public void a(@NonNull byte[] bArr) {
        com.ipd.dsp.internal.j.b bVar = this.b;
        if (bVar == null) {
            return;
        }
        bVar.put(bArr);
    }

    @Override // com.ipd.dsp.internal.e.a.InterfaceC0876a
    public void a(@NonNull int[] iArr) {
        com.ipd.dsp.internal.j.b bVar = this.b;
        if (bVar == null) {
            return;
        }
        bVar.put(iArr);
    }
}
