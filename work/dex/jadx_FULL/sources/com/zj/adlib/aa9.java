package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class aa9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f40497a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f15221a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public vh2 f15223a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public z99 f15224a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15225a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f15229b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f15230b;
    public long c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f15234c;
    public long d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long[] f15227a = new long[0];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f15226a = new int[0];

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int[] f15231b = new int[0];

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long[] f15232b = new long[0];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean[] f15228a = new boolean[0];

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean[] f15233b = new boolean[0];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f15222a = new om6();

    public void a(ExtractorInput extractorInput) throws IOException {
        extractorInput.readFully(this.f15222a.d(), 0, this.f15222a.f());
        this.f15222a.S(0);
        this.f15230b = false;
    }

    public void b(om6 om6Var) {
        om6Var.k(this.f15222a.d(), 0, this.f15222a.f());
        this.f15222a.S(0);
        this.f15230b = false;
    }

    public long c(int i) {
        return this.f15232b[i];
    }

    public void d(int i) {
        this.f15222a.O(i);
        this.f15225a = true;
        this.f15230b = true;
    }

    public void e(int i, int i2) {
        this.f40497a = i;
        this.b = i2;
        if (this.f15226a.length < i) {
            this.f15227a = new long[i];
            this.f15226a = new int[i];
        }
        if (this.f15231b.length < i2) {
            int i3 = (i2 * 125) / 100;
            this.f15231b = new int[i3];
            this.f15232b = new long[i3];
            this.f15228a = new boolean[i3];
            this.f15233b = new boolean[i3];
        }
    }

    public void f() {
        this.f40497a = 0;
        this.d = 0L;
        this.f15234c = false;
        this.f15225a = false;
        this.f15230b = false;
        this.f15224a = null;
    }

    public boolean g(int i) {
        return this.f15225a && this.f15233b[i];
    }
}
