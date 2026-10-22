package com.zj.adlib;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d86 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15942a;
    public int b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final e86 f15940a = new e86();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f15941a = new om6(new byte[65025], 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f41126a = -1;

    public final int a(int i) {
        int i2;
        int i3 = 0;
        this.b = 0;
        do {
            int i4 = this.b;
            int i5 = i + i4;
            e86 e86Var = this.f15940a;
            if (i5 >= e86Var.c) {
                break;
            }
            int[] iArr = e86Var.f16230a;
            this.b = i4 + 1;
            i2 = iArr[i4 + i];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    public e86 b() {
        return this.f15940a;
    }

    public om6 c() {
        return this.f15941a;
    }

    public boolean d(ExtractorInput extractorInput) throws IOException {
        int i;
        sb0.i(extractorInput != null);
        if (this.f15942a) {
            this.f15942a = false;
            this.f15941a.O(0);
        }
        while (!this.f15942a) {
            if (this.f41126a < 0) {
                if (!this.f15940a.c(extractorInput) || !this.f15940a.a(extractorInput, true)) {
                    return false;
                }
                e86 e86Var = this.f15940a;
                int iA = e86Var.d;
                if ((e86Var.b & 1) == 1 && this.f15941a.f() == 0) {
                    iA += a(0);
                    i = this.b + 0;
                } else {
                    i = 0;
                }
                if (!fc3.e(extractorInput, iA)) {
                    return false;
                }
                this.f41126a = i;
            }
            int iA2 = a(this.f41126a);
            int i2 = this.f41126a + this.b;
            if (iA2 > 0) {
                om6 om6Var = this.f15941a;
                om6Var.c(om6Var.f() + iA2);
                if (!fc3.d(extractorInput, this.f15941a.d(), this.f15941a.f(), iA2)) {
                    return false;
                }
                om6 om6Var2 = this.f15941a;
                om6Var2.R(om6Var2.f() + iA2);
                this.f15942a = this.f15940a.f16230a[i2 + (-1)] != 255;
            }
            if (i2 == this.f15940a.c) {
                i2 = -1;
            }
            this.f41126a = i2;
        }
        return true;
    }

    public void e() {
        this.f15940a.b();
        this.f15941a.O(0);
        this.f41126a = -1;
        this.f15942a = false;
    }

    public void f() {
        if (this.f15941a.d().length == 65025) {
            return;
        }
        om6 om6Var = this.f15941a;
        om6Var.Q(Arrays.copyOf(om6Var.d(), Math.max(65025, this.f15941a.f())), this.f15941a.f());
    }
}
