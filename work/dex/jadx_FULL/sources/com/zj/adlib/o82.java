package com.zj.adlib;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.google.zxing.datamatrix.decoder.DecodedBitStreamParser;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class o82 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final dd7 f43688a = new dd7(it3.f);

    public final void a(byte[] bArr, int i) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        try {
            this.f43688a.a(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    public q82 b(tv0 tv0Var) throws ChecksumException, FormatException {
        vv0 vv0Var = new vv0(tv0Var);
        l62[] l62VarArrB = l62.b(vv0Var.c(), vv0Var.b());
        int iC = 0;
        for (l62 l62Var : l62VarArrB) {
            iC += l62Var.c();
        }
        byte[] bArr = new byte[iC];
        int length = l62VarArrB.length;
        for (int i = 0; i < length; i++) {
            l62 l62Var2 = l62VarArrB[i];
            byte[] bArrA = l62Var2.a();
            int iC2 = l62Var2.c();
            a(bArrA, iC2);
            for (int i2 = 0; i2 < iC2; i2++) {
                bArr[(i2 * length) + i] = bArrA[i2];
            }
        }
        return DecodedBitStreamParser.a(bArr);
    }

    public q82 c(boolean[][] zArr) throws ChecksumException, FormatException {
        return b(tv0.v(zArr));
    }
}
