package com.byazt.po;

import com.byazt.is.uj;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1403, 13})
public class tt {
    public void c(uj ujVar, RandomAccessFile randomAccessFile) throws Throwable {
        if (ujVar == null || randomAccessFile == null) {
            throw new IOException("input parameters is null, cannot finalize zip file");
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                long filePointer = randomAccessFile.getFilePointer();
                c(ujVar, byteArrayOutputStream2);
                c(ujVar, byteArrayOutputStream2.size(), (int) filePointer, byteArrayOutputStream2);
                randomAccessFile.write(byteArrayOutputStream2.toByteArray());
                byteArrayOutputStream2.close();
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void c(uj ujVar, ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        if (ujVar.c() == null || ujVar.c().c() == null || ujVar.c().c().size() <= 0) {
            return;
        }
        Iterator<com.byazt.is.ve> it = ujVar.c().c().iterator();
        while (it.hasNext()) {
            c(it.next(), byteArrayOutputStream, ujVar.uj());
        }
    }

    private void c(com.byazt.is.ve veVar, ByteArrayOutputStream byteArrayOutputStream, ve veVar2) throws IOException {
        if (veVar != null) {
            byte[] bArr = {0, 0};
            veVar2.c((OutputStream) byteArrayOutputStream, 33639248);
            veVar2.c(byteArrayOutputStream, 0);
            veVar2.c(byteArrayOutputStream, 0);
            veVar2.c(byteArrayOutputStream, 0);
            veVar2.c(byteArrayOutputStream, veVar.c());
            veVar2.c(byteArrayOutputStream, 2081);
            veVar2.c(byteArrayOutputStream, 545);
            veVar2.c((OutputStream) byteArrayOutputStream, (int) veVar.sp());
            veVar2.c((OutputStream) byteArrayOutputStream, (int) veVar.x());
            veVar2.c((OutputStream) byteArrayOutputStream, (int) veVar.i());
            byte[] bArrC = new byte[0];
            if (veVar.t() != null && veVar.t().trim().length() > 0) {
                bArrC = c(veVar.t());
            }
            veVar2.c(byteArrayOutputStream, bArrC.length);
            int iSl = veVar.sl();
            veVar2.c(byteArrayOutputStream, iSl);
            veVar2.c(byteArrayOutputStream, 0);
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(bArr);
            veVar2.c((OutputStream) byteArrayOutputStream, (int) veVar.u());
            if (bArrC.length > 0) {
                byteArrayOutputStream.write(bArrC);
            }
            if (iSl > 0) {
                byteArrayOutputStream.write(new byte[iSl]);
                return;
            }
            return;
        }
        throw new IOException("input parameters is null, cannot write local file header");
    }

    private void c(uj ujVar, int i, int i2, ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        ujVar.uj().c((OutputStream) byteArrayOutputStream, 101010256);
        ujVar.uj().c(byteArrayOutputStream, 0);
        ujVar.uj().c(byteArrayOutputStream, 0);
        int size = ujVar.c().c().size();
        ujVar.uj().c(byteArrayOutputStream, size);
        ujVar.uj().c(byteArrayOutputStream, size);
        ujVar.uj().c((OutputStream) byteArrayOutputStream, i);
        ujVar.uj().c((OutputStream) byteArrayOutputStream, i2);
        ujVar.uj().c(byteArrayOutputStream, 0);
    }

    private byte[] c(String str) {
        return str.getBytes(Charset.forName("UTF-8"));
    }
}
