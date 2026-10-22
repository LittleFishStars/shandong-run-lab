package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import com.zj.adlib.b50;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a implements Allocator {
    public static final int e = 100;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f31125a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f5082a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final byte[] f5083a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b50[] f5084a;
    public int b;
    public int c;
    public int d;

    public a(boolean z, int i) {
        this(z, i, 0);
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized void a(b50 b50Var) {
        b50[] b50VarArr = this.f5084a;
        int i = this.d;
        this.d = i + 1;
        b50VarArr[i] = b50Var;
        this.c--;
        notifyAll();
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized void b(@Nullable Allocator.AllocationNode allocationNode) {
        while (allocationNode != null) {
            b50[] b50VarArr = this.f5084a;
            int i = this.d;
            this.d = i + 1;
            b50VarArr[i] = allocationNode.a();
            this.c--;
            allocationNode = allocationNode.b();
        }
        notifyAll();
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized b50 c() {
        b50 b50Var;
        this.c++;
        int i = this.d;
        if (i > 0) {
            b50[] b50VarArr = this.f5084a;
            int i2 = i - 1;
            this.d = i2;
            b50Var = (b50) sb0.g(b50VarArr[i2]);
            this.f5084a[this.d] = null;
        } else {
            b50Var = new b50(new byte[this.f31125a], 0);
            int i3 = this.c;
            b50[] b50VarArr2 = this.f5084a;
            if (i3 > b50VarArr2.length) {
                this.f5084a = (b50[]) Arrays.copyOf(b50VarArr2, b50VarArr2.length * 2);
            }
        }
        return b50Var;
    }

    public synchronized void d() {
        if (this.f5082a) {
            e(0);
        }
    }

    public synchronized void e(int i) {
        boolean z = i < this.b;
        this.b = i;
        if (z) {
            trim();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public int getIndividualAllocationLength() {
        return this.f31125a;
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized int getTotalBytesAllocated() {
        return this.c * this.f31125a;
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized void trim() {
        int i = 0;
        int iMax = Math.max(0, gj9.m(this.b, this.f31125a) - this.c);
        int i2 = this.d;
        if (iMax >= i2) {
            return;
        }
        if (this.f5083a != null) {
            int i3 = i2 - 1;
            while (i <= i3) {
                b50 b50Var = (b50) sb0.g(this.f5084a[i]);
                if (b50Var.f15443a == this.f5083a) {
                    i++;
                } else {
                    b50 b50Var2 = (b50) sb0.g(this.f5084a[i3]);
                    if (b50Var2.f15443a != this.f5083a) {
                        i3--;
                    } else {
                        b50[] b50VarArr = this.f5084a;
                        b50VarArr[i] = b50Var2;
                        b50VarArr[i3] = b50Var;
                        i3--;
                        i++;
                    }
                }
            }
            iMax = Math.max(iMax, i);
            if (iMax >= this.d) {
                return;
            }
        }
        Arrays.fill(this.f5084a, iMax, this.d, (Object) null);
        this.d = iMax;
    }

    public a(boolean z, int i, int i2) {
        sb0.a(i > 0);
        sb0.a(i2 >= 0);
        this.f5082a = z;
        this.f31125a = i;
        this.d = i2;
        this.f5084a = new b50[i2 + 100];
        if (i2 <= 0) {
            this.f5083a = null;
            return;
        }
        this.f5083a = new byte[i2 * i];
        for (int i3 = 0; i3 < i2; i3++) {
            this.f5084a[i3] = new b50(this.f5083a, i3 * i);
        }
    }
}
