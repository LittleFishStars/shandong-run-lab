package com.zj.adlib;

import com.amap.api.col.p0003l.ij;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class vbb extends ij {
    public vbb() {
    }

    @Override // com.amap.api.col.p0003l.ij
    public final byte[] a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
        stringBuffer.append(" ");
        stringBuffer.append(UUID.randomUUID().toString());
        stringBuffer.append(" ");
        if (stringBuffer.length() != 53) {
            return new byte[0];
        }
        byte[] bArrP = s4b.p(stringBuffer.toString());
        byte[] bArr2 = new byte[bArrP.length + bArr.length];
        System.arraycopy(bArrP, 0, bArr2, 0, bArrP.length);
        System.arraycopy(bArr, 0, bArr2, bArrP.length, bArr.length);
        return bArr2;
    }

    public vbb(ij ijVar) {
        super(ijVar);
    }
}
