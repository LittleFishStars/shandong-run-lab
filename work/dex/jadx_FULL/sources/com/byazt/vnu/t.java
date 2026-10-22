package com.byazt.vnu;

import com.hzchengdun.securityguard.SecExceptionCode;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SIGNATRUE_UNKNOWN, 66})
public class t {
    public static void c(sp spVar) throws IOException {
        spVar.tt(1835009, 0);
        int i = spVar.readInt();
        int i2 = spVar.readInt();
        int i3 = spVar.readInt();
        spVar.c();
        int i4 = spVar.readInt();
        int i5 = spVar.readInt();
        spVar.skipBytes(i2 * 4);
        if (i3 != 0) {
            spVar.skipBytes(i3 * 4);
        }
        spVar.skipBytes((i5 == 0 ? i : i5) - i4);
        if (i5 == 0) {
            return;
        }
        int i6 = i - i5;
        spVar.skipBytes(i6);
        int i7 = i6 % 4;
        if (i7 <= 0) {
            return;
        }
        while (true) {
            int i8 = i7 - 1;
            if (i7 <= 0) {
                return;
            }
            spVar.readByte();
            i7 = i8;
        }
    }
}
