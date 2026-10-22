package com.byazt.vnu;

import com.hzchengdun.securityguard.SecExceptionCode;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SIGNATRUE_UNKNOWN, 15})
public final class uj {
    public static <T> T c(T t) {
        t.getClass();
        return t;
    }

    public static int tt(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        c(inputStream);
        c(bArr);
        int i3 = 0;
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", Integer.valueOf(i2)));
        }
        c(i, i + i2, bArr.length);
        while (i3 < i2) {
            int i4 = inputStream.read(bArr, i + i3, i2 - i3);
            if (i4 == -1) {
                break;
            }
            i3 += i4;
        }
        return i3;
    }

    public static void c(InputStream inputStream, byte[] bArr) throws IOException {
        c(inputStream, bArr, 0, bArr.length);
    }

    public static void c(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        int iTt = tt(inputStream, bArr, i, i2);
        if (iTt == i2) {
            return;
        }
        throw new EOFException("reached end of stream after reading " + iTt + " bytes; " + i2 + " bytes expected");
    }

    public static void c(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append(i2);
            sb.append(i3);
            throw new IndexOutOfBoundsException(sb.toString());
        }
    }
}
