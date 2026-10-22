package com.byazt.po;

import android.support.v4.media.session.PlaybackStateCompat;
import com.byazt.is.uj;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1403, 20})
public class c {
    private void tt(RandomAccessFile randomAccessFile, uj ujVar) throws IOException {
        com.byazt.is.c cVar = new com.byazt.is.c();
        ArrayList arrayList = new ArrayList();
        long jTt = ujVar.tt().tt();
        long jC = ujVar.tt().c();
        randomAccessFile.seek(jTt);
        for (int i = 0; i < jC; i++) {
            com.byazt.is.ve veVar = new com.byazt.is.ve();
            if (ujVar.uj().c(randomAccessFile) != 33639248) {
                throw new IOException("Expected central directory entry not found (#" + (i + 1) + ")");
            }
            randomAccessFile.skipBytes(6);
            veVar.c(ujVar.uj().tt(randomAccessFile));
            randomAccessFile.skipBytes(4);
            veVar.c(ujVar.uj().c(randomAccessFile));
            veVar.tt(ujVar.uj().c(randomAccessFile));
            veVar.ve(ujVar.uj().c(randomAccessFile));
            int iTt = ujVar.uj().tt(randomAccessFile);
            veVar.ve(iTt);
            veVar.uj(ujVar.uj().tt(randomAccessFile));
            int iTt2 = ujVar.uj().tt(randomAccessFile);
            randomAccessFile.skipBytes(8);
            veVar.uj(ujVar.uj().c(randomAccessFile));
            if (iTt <= 0) {
                throw new IOException("Invalid entry name in file header");
            }
            byte[] bArr = new byte[iTt];
            randomAccessFile.readFully(bArr);
            veVar.c(c(bArr));
            randomAccessFile.skipBytes(veVar.sl());
            if (iTt2 > 0) {
                randomAccessFile.skipBytes(iTt2);
            }
            long filePointer = randomAccessFile.getFilePointer();
            randomAccessFile.seek(veVar.u() + 28);
            veVar.tt(ujVar.uj().tt(randomAccessFile));
            randomAccessFile.seek(filePointer);
            arrayList.add(veVar);
        }
        cVar.c(arrayList);
        ujVar.c(cVar);
    }

    private long uj(RandomAccessFile randomAccessFile, uj ujVar) throws IOException {
        long length = randomAccessFile.length() - 22;
        long length2 = randomAccessFile.length();
        long length3 = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        if (length2 < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
            length3 = randomAccessFile.length();
        }
        while (length3 > 0 && length > 0) {
            length--;
            randomAccessFile.seek(length);
            if (ujVar.uj().c(randomAccessFile) == 101010256) {
                return length;
            }
            length3--;
        }
        throw new IOException("Zip headers not found. Probably not a zip file");
    }

    private long ve(RandomAccessFile randomAccessFile, uj ujVar) throws IOException {
        long length = randomAccessFile.length();
        if (length < 22) {
            throw new IOException("Zip file size less than size of zip headers. Probably not a zip file.");
        }
        long j = length - 22;
        randomAccessFile.seek(j);
        return ((long) ujVar.uj().c(randomAccessFile)) == 101010256 ? j : uj(randomAccessFile, ujVar);
    }

    public uj c(String str) throws Throwable {
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "r");
            try {
                if (randomAccessFile2.length() < 22) {
                    throw new IOException("Zip file size less than minimum expected zip file size. Probably not a zip file or a corrupted zip file");
                }
                uj ujVar = new uj(str);
                c(randomAccessFile2, ujVar);
                if (ujVar.tt().c() == 0) {
                    try {
                        randomAccessFile2.close();
                    } catch (IOException unused) {
                    }
                    return ujVar;
                }
                tt(randomAccessFile2, ujVar);
                try {
                    randomAccessFile2.close();
                } catch (IOException unused2) {
                }
                return ujVar;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void c(RandomAccessFile randomAccessFile, uj ujVar) throws IOException {
        randomAccessFile.seek(ve(randomAccessFile, ujVar) + 4);
        com.byazt.is.tt ttVar = new com.byazt.is.tt();
        randomAccessFile.skipBytes(6);
        ttVar.c(ujVar.uj().tt(randomAccessFile));
        randomAccessFile.skipBytes(4);
        ttVar.c(ujVar.uj().c(randomAccessFile));
        ujVar.c(ttVar);
    }

    private String c(byte[] bArr) {
        return new String(bArr, Charset.forName("UTF-8"));
    }
}
