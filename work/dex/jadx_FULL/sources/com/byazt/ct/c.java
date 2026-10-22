package com.byazt.ct;

import com.byazt.of.tt;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1336, 20})
public class c {
    public static List<com.byazt.of.c> c(tt ttVar, com.byazt.pty.tt ttVar2) throws Exception {
        return c(com.byazt.jf.c.c(ttVar, ttVar2, 1896449818).c);
    }

    @DungeonFlag
    private static com.byazt.of.c tt(ByteBuffer byteBuffer) throws Exception {
        ByteBuffer byteBufferC = com.byazt.jf.c.c(byteBuffer);
        byteBufferC.get(new byte[byteBufferC.remaining()]);
        byteBufferC.flip();
        byteBufferC.position(0);
        com.byazt.jf.c.c(byteBufferC);
        byte[] bArrTt = com.byazt.jf.c.tt(com.byazt.jf.c.c(byteBufferC));
        try {
            return new com.byazt.of.c(String.valueOf(((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArrTt))).getSubjectDN()), bArrTt);
        } catch (Exception unused) {
            return null;
        }
    }

    public static List<com.byazt.of.c> c(ByteBuffer byteBuffer) {
        try {
            ByteBuffer byteBufferC = com.byazt.jf.c.c(byteBuffer);
            if (!byteBufferC.hasRemaining()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            while (byteBufferC.hasRemaining()) {
                try {
                    arrayList.add(tt(com.byazt.jf.c.c(byteBufferC)));
                } catch (Exception unused) {
                    return null;
                }
            }
            return arrayList;
        } catch (Exception unused2) {
            return null;
        }
    }
}
