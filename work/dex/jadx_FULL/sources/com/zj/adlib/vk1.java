package com.zj.adlib;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class vk1 {
    public static final int i = 512;
    public static final int j = 1667497984;
    public static final int k = 1650720768;
    public static final int l = 1651965952;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f45373a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f20232a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TrackOutput f20233a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f20234a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long[] f20235a;
    public final int b;
    public final int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;

    public vk1(int i2, int i3, long j2, int i4, TrackOutput trackOutput) {
        boolean z = true;
        if (i3 != 1 && i3 != 2) {
            z = false;
        }
        sb0.a(z);
        this.f20232a = j2;
        this.c = i4;
        this.f20233a = trackOutput;
        this.f45373a = d(i2, i3 == 2 ? j : l);
        this.b = i3 == 2 ? d(i2, k) : -1;
        this.f20235a = new long[512];
        this.f20234a = new int[512];
    }

    public static int d(int i2, int i3) {
        return (((i2 % 10) + 48) << 8) | ((i2 / 10) + 48) | i3;
    }

    public void a() {
        this.f++;
    }

    public void b(long j2) {
        if (this.h == this.f20234a.length) {
            long[] jArr = this.f20235a;
            this.f20235a = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
            int[] iArr = this.f20234a;
            this.f20234a = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
        }
        long[] jArr2 = this.f20235a;
        int i2 = this.h;
        jArr2[i2] = j2;
        this.f20234a[i2] = this.g;
        this.h = i2 + 1;
    }

    public void c() {
        this.f20235a = Arrays.copyOf(this.f20235a, this.h);
        this.f20234a = Arrays.copyOf(this.f20234a, this.h);
    }

    public final long e(int i2) {
        return (this.f20232a * ((long) i2)) / ((long) this.c);
    }

    public long f() {
        return e(this.f);
    }

    public long g() {
        return e(1);
    }

    public final x38 h(int i2) {
        return new x38(((long) this.f20234a[i2]) * g(), this.f20235a[i2]);
    }

    public SeekMap.a i(long j2) {
        int iG = (int) (j2 / g());
        int i2 = gj9.i(this.f20234a, iG, true, true);
        if (this.f20234a[i2] == iG) {
            return new SeekMap.a(h(i2));
        }
        x38 x38VarH = h(i2);
        int i3 = i2 + 1;
        return i3 < this.f20235a.length ? new SeekMap.a(x38VarH, h(i3)) : new SeekMap.a(x38VarH);
    }

    public boolean j(int i2) {
        return this.f45373a == i2 || this.b == i2;
    }

    public void k() {
        this.g++;
    }

    public boolean l() {
        return (this.f45373a & l) == 1651965952;
    }

    public boolean m() {
        return Arrays.binarySearch(this.f20234a, this.f) >= 0;
    }

    public boolean n() {
        return (this.f45373a & j) == 1667497984;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public boolean o(ExtractorInput extractorInput) throws IOException {
        int i2 = this.e;
        int iB = i2 - this.f20233a.b(extractorInput, i2, false);
        this.e = iB;
        boolean z = iB == 0;
        if (z) {
            if (this.d > 0) {
                this.f20233a.e(f(), m() ? 1 : 0, this.d, 0, null);
            }
            a();
        }
        return z;
    }

    public void p(int i2) {
        this.d = i2;
        this.e = i2;
    }

    public void q(long j2) {
        if (this.h == 0) {
            this.f = 0;
        } else {
            this.f = this.f20234a[gj9.j(this.f20235a, j2, true, true)];
        }
    }
}
