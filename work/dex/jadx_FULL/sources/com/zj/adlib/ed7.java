package com.zj.adlib;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class ed7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final it3 f41410a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<jt3> f16298a;

    public ed7(it3 it3Var) {
        this.f41410a = it3Var;
        ArrayList arrayList = new ArrayList();
        this.f16298a = arrayList;
        arrayList.add(new jt3(it3Var, new int[]{1}));
    }

    public final jt3 a(int i) {
        if (i >= this.f16298a.size()) {
            List<jt3> list = this.f16298a;
            jt3 jt3VarI = list.get(list.size() - 1);
            for (int size = this.f16298a.size(); size <= i; size++) {
                it3 it3Var = this.f41410a;
                jt3VarI = jt3VarI.i(new jt3(it3Var, new int[]{1, it3Var.c((size - 1) + it3Var.d())}));
                this.f16298a.add(jt3VarI);
            }
        }
        return this.f16298a.get(i);
    }

    public void b(int[] iArr, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        jt3 jt3VarA = a(i);
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        int[] iArrE = new jt3(this.f41410a, iArr2).j(i, 1).b(jt3VarA)[1].e();
        int length2 = i - iArrE.length;
        for (int i2 = 0; i2 < length2; i2++) {
            iArr[length + i2] = 0;
        }
        System.arraycopy(iArrE, 0, iArr, length + length2, iArrE.length);
    }
}
