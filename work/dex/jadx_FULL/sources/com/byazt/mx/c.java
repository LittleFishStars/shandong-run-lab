package com.byazt.mx;

import com.byazt.is.uj;
import com.byazt.is.ve;
import com.byazt.uq.i;
import com.byazt.uq.sp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_INFOS, 20})
public class c {
    public final uj c;
    public final com.byazt.po.tt tt = new com.byazt.po.tt();

    public c(uj ujVar) {
        this.c = ujVar;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0113 A[Catch: all -> 0x0138, TryCatch #3 {all -> 0x0138, blocks: (B:24:0x00c6, B:26:0x0128, B:25:0x0113), top: B:59:0x00c6 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0176  */
    /* JADX WARN: Code duplicated, block: B:50:0x017b  */
    public void c(boolean z, boolean z2) throws Throwable {
        File file;
        RandomAccessFile randomAccessFile;
        File file2;
        File file3 = new File(this.c.ve().getAbsolutePath() + ".rm_tmp");
        if (file3.exists()) {
            file3.delete();
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file3, "rw");
            try {
                RandomAccessFile randomAccessFile3 = new RandomAccessFile(this.c.ve(), "r");
                try {
                    List<ve> listC = this.c.c().c();
                    HashSet hashSet = new HashSet();
                    Iterator<ve> it = listC.iterator();
                    int iVe = 0;
                    while (it.hasNext()) {
                        ve next = it.next();
                        if (c(next, z, z2)) {
                            hashSet.add(next.t());
                        } else {
                            long jU = next.u();
                            if ("resources.arsc".equals(next.t())) {
                                long filePointer = randomAccessFile.getFilePointer() + next.uj();
                                long jA = filePointer % 4096 == 0 ? 0L : 4096 - ((filePointer - ((long) next.a())) % 4096);
                                if (jA != 0) {
                                    int iA = next.a();
                                    int i = (int) jA;
                                    next.tt(i);
                                    file2 = file3;
                                    try {
                                        c(randomAccessFile3, randomAccessFile, jU, next.n(), next.t());
                                        this.c.uj().c(randomAccessFile, i);
                                        c(randomAccessFile3, randomAccessFile, jU + next.n() + 2, next.da(), next.t());
                                        randomAccessFile.write(new byte[i]);
                                        c(randomAccessFile3, randomAccessFile, jU + next.n() + 2 + ((long) next.da()) + ((long) iA), next.tt(), next.t());
                                    } catch (Throwable th) {
                                        th = th;
                                        randomAccessFile2 = randomAccessFile3;
                                        file = file2;
                                        if (randomAccessFile2 != null) {
                                            randomAccessFile2.close();
                                        }
                                        if (randomAccessFile != null) {
                                            randomAccessFile.close();
                                        }
                                        c(file);
                                        throw th;
                                    }
                                } else {
                                    file2 = file3;
                                    c(randomAccessFile3, randomAccessFile, jU, next.ve(), next.t());
                                }
                            } else {
                                file2 = file3;
                                c(randomAccessFile3, randomAccessFile, jU, next.ve(), next.t());
                            }
                            long j = iVe;
                            next.uj(j);
                            iVe = (int) (j + next.ve());
                            it = it;
                            file3 = file2;
                        }
                    }
                    File file4 = file3;
                    try {
                        this.c.c().c(hashSet);
                        this.tt.c(this.c, randomAccessFile);
                        file = file4;
                        try {
                            c(this.c.ve(), file);
                            randomAccessFile3.close();
                            randomAccessFile.close();
                            c(file);
                        } catch (Throwable th2) {
                            th = th2;
                            randomAccessFile2 = randomAccessFile3;
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.close();
                            }
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            c(file);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        file = file4;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    file = file3;
                }
            } catch (Throwable th5) {
                th = th5;
                file = file3;
            }
        } catch (Throwable th6) {
            th = th6;
            file = file3;
            randomAccessFile = null;
        }
    }

    private boolean c(ve veVar, boolean z, boolean z2) {
        if (z) {
            if (i.n() && veVar.t().equals("classes.dex")) {
                return false;
            }
            if (veVar.t().startsWith("classes") && veVar.t().endsWith(".dex")) {
                return true;
            }
        }
        return z2 && veVar.t().startsWith("lib/") && veVar.t().endsWith(".so");
    }

    public void c(File file) throws ZipException {
        if (file.exists() && !file.delete()) {
            throw new ZipException("Could not delete temporary file");
        }
    }

    public void c(RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2, long j, long j2, String str) throws IOException {
        sp.c(randomAccessFile, randomAccessFile2, j, j + j2, str);
    }

    private void c(File file, File file2) throws ZipException {
        if (!file2.renameTo(file)) {
            throw new ZipException("cannot rename modified zip file");
        }
    }
}
