package com.zj.adlib;

import androidx.annotation.Nullable;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class aa1 implements Comparable<aa1> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f40491a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final File f15218a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f15219a;
    public final long b;
    public final long c;
    public final String f;

    public aa1(String str, long j, long j2) {
        this(str, j, j2, -9223372036854775807L, null);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(aa1 aa1Var) {
        if (!this.f.equals(aa1Var.f)) {
            return this.f.compareTo(aa1Var.f);
        }
        long j = this.f40491a - aa1Var.f40491a;
        if (j == 0) {
            return 0;
        }
        return j < 0 ? -1 : 1;
    }

    public boolean b() {
        return !this.f15219a;
    }

    public boolean c() {
        return this.b == -1;
    }

    public String toString() {
        return "[" + this.f40491a + ", " + this.b + "]";
    }

    public aa1(String str, long j, long j2, long j3, @Nullable File file) {
        this.f = str;
        this.f40491a = j;
        this.b = j2;
        this.f15219a = file != null;
        this.f15218a = file;
        this.c = j3;
    }
}
