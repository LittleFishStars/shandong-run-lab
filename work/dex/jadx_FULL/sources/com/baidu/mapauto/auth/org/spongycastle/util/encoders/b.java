package com.baidu.mapauto.auth.org.spongycastle.util.encoders;

import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.zj.adlib.aq6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f26661a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, aq6.f40585a, 121, 122, com.alibaba.ariver.resource.parser.a.e.i, com.alibaba.ariver.resource.parser.a.e.j, com.alibaba.ariver.resource.parser.a.e.k, com.alibaba.ariver.resource.parser.a.e.l, com.alibaba.ariver.resource.parser.a.e.m, com.alibaba.ariver.resource.parser.a.e.n, com.alibaba.ariver.resource.parser.a.e.o, com.alibaba.ariver.resource.parser.a.e.p, MaterialProgressDrawable.d, 57, com.google.android.exoplayer2.text.cea.a.l, 47};
    public final byte[] b = new byte[128];

    public b() {
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
            byte[] bArr2 = this.f26661a;
            if (i >= bArr2.length) {
                return;
            }
            this.b[bArr2[i]] = (byte) i;
            i++;
        }
    }
}
