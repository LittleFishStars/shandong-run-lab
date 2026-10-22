package com.ipd.dsp.internal.l0;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.ipd.dsp.internal.f0.h;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f38395a;
    public boolean b;
    public boolean c;
    public boolean d;
    public final com.ipd.dsp.internal.f0.f e;
    public final com.ipd.dsp.internal.h0.b f;
    public final long g;

    public a(@NonNull com.ipd.dsp.internal.f0.f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar, long j) {
        this.e = fVar;
        this.f = bVar;
        this.g = j;
    }

    public void a() {
        this.b = d();
        this.c = e();
        boolean zF = f();
        this.d = zF;
        this.f38395a = (this.c && this.b && zF) ? false : true;
    }

    @NonNull
    public com.ipd.dsp.internal.i0.b b() {
        if (!this.c) {
            return com.ipd.dsp.internal.i0.b.INFO_DIRTY;
        }
        if (!this.b) {
            return com.ipd.dsp.internal.i0.b.FILE_NOT_EXIST;
        }
        if (!this.d) {
            return com.ipd.dsp.internal.i0.b.OUTPUT_STREAM_NOT_SUPPORT;
        }
        throw new IllegalStateException("No cause find with dirty: " + this.f38395a);
    }

    public boolean c() {
        return this.f38395a;
    }

    public boolean d() {
        Uri uriX = this.e.x();
        if (com.ipd.dsp.internal.g0.c.c(uriX)) {
            return com.ipd.dsp.internal.g0.c.b(uriX) > 0;
        }
        File fileH = this.e.h();
        return fileH != null && fileH.exists();
    }

    public boolean e() {
        int iB = this.f.b();
        if (iB <= 0 || this.f.k() || this.f.d() == null) {
            return false;
        }
        if (!this.f.d().equals(this.e.h()) || this.f.d().length() > this.f.h()) {
            return false;
        }
        if (this.g > 0 && this.f.h() != this.g) {
            return false;
        }
        for (int i = 0; i < iB; i++) {
            if (this.f.b(i).b() <= 0) {
                return false;
            }
        }
        return true;
    }

    public boolean f() {
        if (h.j().h().a()) {
            return true;
        }
        return this.f.b() == 1 && !h.j().i().b(this.e);
    }

    public String toString() {
        return "fileExist[" + this.b + "] infoRight[" + this.c + "] outputStreamSupport[" + this.d + "] " + super.toString();
    }
}
