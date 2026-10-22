package com.ipd.dsp.internal.z0;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class b implements com.ipd.dsp.internal.s0.b {
    public com.ipd.dsp.internal.s0.c f;
    public Activity g;

    @Override // com.ipd.dsp.internal.s0.b
    public final void a(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.ipd.dsp.internal.s0.b
    public final void a(com.ipd.dsp.internal.s0.c cVar) {
        this.f = cVar;
    }

    public boolean a(@Nullable MenuItem menuItem) {
        return false;
    }

    public void b(int i, int i2, @Nullable Intent intent) {
    }

    public void b(int i, String[] strArr, int[] iArr) {
    }

    public abstract void b(Bundle bundle);

    public void b(Throwable th) {
    }

    public boolean b(int i) {
        return false;
    }

    @Override // com.ipd.dsp.internal.s0.b
    public final void e() {
        p();
    }

    @Override // com.ipd.dsp.internal.s0.b
    public final void f() {
        k();
    }

    @Override // com.ipd.dsp.internal.s0.b
    public final void g() {
        n();
    }

    @Override // com.ipd.dsp.internal.s0.b
    public final void h() {
        m();
    }

    @Override // com.ipd.dsp.internal.s0.b
    public final void i() {
        l();
    }

    public Activity j() {
        if (this.g == null) {
            try {
                this.g = this.f.a();
            } catch (Throwable unused) {
            }
        }
        return this.g;
    }

    public void k() {
    }

    public void l() {
    }

    public void m() {
    }

    public void n() {
    }

    public void o() {
    }

    public void p() {
    }

    public void q() {
        try {
            this.f.i();
        } catch (Throwable unused) {
        }
    }

    @Override // com.ipd.dsp.internal.s0.b
    public final void a(Bundle bundle) {
        b(bundle);
    }

    @Override // com.ipd.dsp.internal.s0.b
    public final void a(int i, int i2, Intent intent) {
        b(i, i2, intent);
    }

    @Override // com.ipd.dsp.internal.s0.b
    public final boolean a(int i) {
        return b(i);
    }

    @Override // com.ipd.dsp.internal.s0.b
    public final void a() {
        o();
    }

    @Override // com.ipd.dsp.internal.s0.b
    public final boolean a(Object obj) {
        return a(obj instanceof MenuItem ? (MenuItem) obj : null);
    }

    @Override // com.ipd.dsp.internal.s0.b
    public final void a(Throwable th) {
        b(th);
    }
}
