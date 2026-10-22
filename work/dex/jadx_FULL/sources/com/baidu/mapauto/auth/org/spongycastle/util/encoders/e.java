package com.baidu.mapauto.auth.org.spongycastle.util.encoders;

import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f26664a = {com.alibaba.ariver.resource.parser.a.e.i, com.alibaba.ariver.resource.parser.a.e.j, com.alibaba.ariver.resource.parser.a.e.k, com.alibaba.ariver.resource.parser.a.e.l, com.alibaba.ariver.resource.parser.a.e.m, com.alibaba.ariver.resource.parser.a.e.n, com.alibaba.ariver.resource.parser.a.e.o, com.alibaba.ariver.resource.parser.a.e.p, MaterialProgressDrawable.d, 57, 97, 98, 99, 100, 101, 102};
    public final byte[] b = new byte[128];

    public e() {
        a();
    }

    public final void a() {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.b;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        while (true) {
            byte[] bArr2 = this.f26664a;
            if (i >= bArr2.length) {
                byte[] bArr3 = this.b;
                bArr3[65] = bArr3[97];
                bArr3[66] = bArr3[98];
                bArr3[67] = bArr3[99];
                bArr3[68] = bArr3[100];
                bArr3[69] = bArr3[101];
                bArr3[70] = bArr3[102];
                return;
            }
            this.b[bArr2[i]] = (byte) i;
            i++;
        }
    }
}
