package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class k0 extends a {
    public k0(boolean z, int i, byte[] bArr) {
        super(z, i, bArr);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.a, com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        int i = this.f26605a ? 96 : 64;
        int i2 = this.b;
        byte[] bArr = this.c;
        pVar.a(i, i2);
        pVar.b(bArr.length);
        pVar.f26634a.write(bArr);
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        if (this.f26605a) {
            stringBuffer.append("CONSTRUCTED ");
        }
        stringBuffer.append("APPLICATION ");
        stringBuffer.append(Integer.toString(this.b));
        stringBuffer.append("]");
        if (this.c != null) {
            stringBuffer.append(" #");
            byte[] bArr = this.c;
            com.baidu.mapauto.auth.org.spongycastle.util.encoders.e eVar = com.baidu.mapauto.auth.org.spongycastle.util.encoders.d.f26663a;
            int length = bArr.length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                eVar.getClass();
                for (int i = 0; i < 0 + length; i++) {
                    int i2 = bArr[i] & 255;
                    byteArrayOutputStream.write(eVar.f26664a[i2 >>> 4]);
                    byteArrayOutputStream.write(eVar.f26664a[i2 & 15]);
                }
                stringBuffer.append(com.baidu.mapauto.auth.org.spongycastle.util.d.a(byteArrayOutputStream.toByteArray()));
            } catch (Exception e) {
                StringBuilder sbA = com.baidu.mapauto.auth.a.a("exception encoding Hex string: ");
                sbA.append(e.getMessage());
                throw new com.baidu.mapauto.auth.org.spongycastle.util.encoders.c(sbA.toString(), e);
            }
        } else {
            stringBuffer.append(" #null");
        }
        stringBuffer.append(" ");
        return stringBuffer.toString();
    }
}
