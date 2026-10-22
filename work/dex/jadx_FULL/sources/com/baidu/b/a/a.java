package com.baidu.b.a;

import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    g[] f26254a = {new h(8, 0), new j(0, 1), new j(1, 1), new h(7, 1)};

    public byte[] a(byte[] bArr) {
        f fVar = new f();
        byte[] bArrA = c.a(bArr, bArr.length + ((this.f26254a.length + 1) * f.f26256a));
        c.a(bArrA, fVar.a(), bArr.length);
        int i = 0;
        while (true) {
            g[] gVarArr = this.f26254a;
            if (i >= gVarArr.length) {
                return Arrays.copyOf(fVar.a(), f.f26256a);
            }
            g gVar = gVarArr[i];
            i++;
            int length = bArr.length + (f.f26256a * i);
            fVar.a(gVar.a(bArrA, 0, length), gVar.a(), gVar.b(), gVar.c());
            c.a(bArrA, fVar.a(), length);
        }
    }
}
