package com.byazt.xy;

import android.util.Pair;
import com.alibaba.android.arouter.utils.Consts;
import com.bytedance.component.sdk.annotation.WorkerThread;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2098, 91})
public class sp {
    public final n c;

    public sp(n nVar) {
        this.c = nVar;
    }

    private File tt(String str) throws FileNotFoundException {
        File file = new File(c(), c(str, ve.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(c(), c(str, ve.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    @WorkerThread
    public Pair<ve, InputStream> c(String str) {
        try {
            File fileTt = tt(str);
            if (fileTt == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(fileTt);
            ve veVar = fileTt.getAbsolutePath().endsWith(".zip") ? ve.ZIP : ve.JSON;
            com.byazt.kk.a.c("Cache hit for " + str + " at " + fileTt.getAbsolutePath());
            return new Pair<>(veVar, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    public File c(String str, InputStream inputStream, ve veVar) throws IOException {
        File file = new File(c(), c(str, veVar, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i != -1) {
                        fileOutputStream.write(bArr, 0, i);
                    } else {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        inputStream.close();
                        return file;
                    }
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            inputStream.close();
            throw th2;
        }
    }

    public void c(String str, ve veVar) {
        File file = new File(c(), c(str, veVar, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean zRenameTo = file.renameTo(file2);
        com.byazt.kk.a.c("Copying temp file to real file (" + file2 + ")");
        if (zRenameTo) {
            return;
        }
        com.byazt.kk.a.tt("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + Consts.DOT);
    }

    private File c() {
        File fileC = this.c.c();
        if (fileC.isFile()) {
            fileC.delete();
        }
        if (!fileC.exists()) {
            fileC.mkdirs();
        }
        return fileC;
    }

    private static String c(String str, ve veVar, boolean z) {
        StringBuilder sb = new StringBuilder("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? veVar.c() : veVar.ve);
        return sb.toString();
    }
}
