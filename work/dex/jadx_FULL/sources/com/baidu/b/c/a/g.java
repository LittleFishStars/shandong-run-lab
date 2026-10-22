package com.baidu.b.c.a;

import com.ipd.dsp.internal.q.u;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile byte[] f26282a;

    public static byte[] a() throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (f26282a == null) {
            synchronized (g.class) {
                if (f26282a == null) {
                    byte[] bArr = new byte[16];
                    System.arraycopy(com.baidu.b.c.c.b.b(), 0, bArr, 0, 16);
                    c cVar = new c();
                    cVar.a(2, bArr, bArr);
                    f26282a = cVar.a(new byte[]{-71, -100, -115, com.google.common.base.a.D, com.google.android.exoplayer2.text.cea.a.i, -124, com.google.common.base.a.p, com.google.common.base.a.p, u.B7, -46, -56, 1, com.google.common.base.a.C, -127, -99, -107, u.v7, com.alibaba.ariver.resource.parser.a.e.l, com.google.android.exoplayer2.text.cea.a.o, com.google.common.base.a.p, 68, -68, -19, com.google.common.base.a.F, 66, 19, -113, 5, com.google.common.base.a.C, -11, -123, com.alibaba.ariver.resource.parser.a.e.k});
                }
            }
        }
        return f26282a;
    }
}
