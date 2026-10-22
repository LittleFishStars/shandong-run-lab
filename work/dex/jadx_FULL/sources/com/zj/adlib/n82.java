package com.zj.adlib;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.a;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class n82 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final dd7 f43468a = new dd7(it3.e);

    public final void a(byte[] bArr, int i) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        try {
            this.f43468a.a(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    public final q82 b(a aVar, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        lm9 lm9VarE = aVar.e();
        ErrorCorrectionLevel errorCorrectionLevelD = aVar.d().d();
        k62[] k62VarArrB = k62.b(aVar.c(), lm9VarE, errorCorrectionLevelD);
        int iC = 0;
        for (k62 k62Var : k62VarArrB) {
            iC += k62Var.c();
        }
        byte[] bArr = new byte[iC];
        int i = 0;
        for (k62 k62Var2 : k62VarArrB) {
            byte[] bArrA = k62Var2.a();
            int iC2 = k62Var2.c();
            a(bArrA, iC2);
            int i2 = 0;
            while (i2 < iC2) {
                bArr[i] = bArrA[i2];
                i2++;
                i++;
            }
        }
        return k82.a(bArr, lm9VarE, errorCorrectionLevelD, map);
    }

    public q82 c(tv0 tv0Var) throws ChecksumException, FormatException {
        return d(tv0Var, null);
    }

    public q82 d(tv0 tv0Var, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        ChecksumException e;
        a aVar = new a(tv0Var);
        FormatException formatException = null;
        try {
            return b(aVar, map);
        } catch (ChecksumException e2) {
            e = e2;
            try {
                aVar.f();
                aVar.g(true);
                aVar.e();
                aVar.d();
                aVar.b();
                q82 q82VarB = b(aVar, map);
                q82VarB.p(new c57(true));
                return q82VarB;
            } catch (ChecksumException | FormatException unused) {
                if (formatException != null) {
                    throw formatException;
                }
                throw e;
            }
        } catch (FormatException e3) {
            e = null;
            formatException = e3;
            aVar.f();
            aVar.g(true);
            aVar.e();
            aVar.d();
            aVar.b();
            q82 q82VarB2 = b(aVar, map);
            q82VarB2.p(new c57(true));
            return q82VarB2;
        }
    }

    public q82 e(boolean[][] zArr) throws ChecksumException, FormatException {
        return f(zArr, null);
    }

    public q82 f(boolean[][] zArr, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        return d(tv0.v(zArr), map);
    }
}
