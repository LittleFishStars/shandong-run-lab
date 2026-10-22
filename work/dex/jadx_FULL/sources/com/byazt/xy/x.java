package com.byazt.xy;

import android.content.Context;
import android.util.Pair;
import com.byazt.ga.t;
import com.bytedance.component.sdk.annotation.WorkerThread;
import com.zj.adlib.ze1;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2098, 71})
public class x {
    public final sp c;
    public final a tt;

    public x(sp spVar, a aVar) {
        this.c = spVar;
        this.tt = aVar;
    }

    @WorkerThread
    private com.byazt.ga.a tt(Context context, String str, String str2) {
        sp spVar;
        Pair<ve, InputStream> pairC;
        if (str2 == null || (spVar = this.c) == null || (pairC = spVar.c(str2)) == null) {
            return null;
        }
        ve veVar = (ve) pairC.first;
        InputStream inputStream = (InputStream) pairC.second;
        t<com.byazt.ga.a> tVarC = veVar == ve.ZIP ? com.byazt.ga.sp.c(context, new ZipInputStream(inputStream), str2) : com.byazt.ga.sp.tt(inputStream, str2);
        if (tVarC.c() != null) {
            return tVarC.c();
        }
        return null;
    }

    @WorkerThread
    private t<com.byazt.ga.a> ve(Context context, String str, String str2) {
        com.byazt.kk.a.c("Fetching " + str);
        Closeable closeable = null;
        try {
            try {
                uj ujVarC = this.tt.c(str);
                if (!ujVarC.c()) {
                    t<com.byazt.ga.a> tVar = new t<>(new IllegalArgumentException(ujVarC.uj()));
                    try {
                        ujVarC.close();
                    } catch (IOException e) {
                        com.byazt.kk.a.c("LottieFetchResult close failed ", e);
                    }
                    return tVar;
                }
                t<com.byazt.ga.a> tVarC = c(context, str, ujVarC.tt(), ujVarC.ve(), str2);
                StringBuilder sb = new StringBuilder("Completed fetch from network. Success: ");
                sb.append(tVarC.c() != null);
                com.byazt.kk.a.c(sb.toString());
                try {
                    ujVarC.close();
                } catch (IOException e2) {
                    com.byazt.kk.a.c("LottieFetchResult close failed ", e2);
                }
                return tVarC;
            } catch (Exception e3) {
                t<com.byazt.ga.a> tVar2 = new t<>(e3);
                if (0 != 0) {
                    try {
                        closeable.close();
                    } catch (IOException e4) {
                        com.byazt.kk.a.c("LottieFetchResult close failed ", e4);
                    }
                }
                return tVar2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    closeable.close();
                } catch (IOException e5) {
                    com.byazt.kk.a.c("LottieFetchResult close failed ", e5);
                }
            }
            throw th;
        }
    }

    @WorkerThread
    public t<com.byazt.ga.a> c(Context context, String str, String str2) {
        com.byazt.ga.a aVarTt = tt(context, str, str2);
        if (aVarTt != null) {
            return new t<>(aVarTt);
        }
        com.byazt.kk.a.c("Animation for " + str + " not found in cache. Fetching from network.");
        return ve(context, str, str2);
    }

    private t<com.byazt.ga.a> c(Context context, String str, InputStream inputStream, String str2, String str3) throws IOException {
        t<com.byazt.ga.a> tVarC;
        ve veVar;
        sp spVar;
        if (str2 == null) {
            str2 = ze1.g;
        }
        if (!str2.contains("application/zip") && !str2.contains("application/x-zip") && !str2.contains("application/x-zip-compressed") && !str.split("\\?")[0].endsWith(".lottie")) {
            com.byazt.kk.a.c("Received json response.");
            veVar = ve.JSON;
            tVarC = c(str, inputStream, str3);
        } else {
            com.byazt.kk.a.c("Handling zip response.");
            ve veVar2 = ve.ZIP;
            tVarC = c(context, str, inputStream, str3);
            veVar = veVar2;
        }
        if (str3 != null && tVarC.c() != null && (spVar = this.c) != null) {
            spVar.c(str3, veVar);
        }
        return tVarC;
    }

    private t<com.byazt.ga.a> c(Context context, String str, InputStream inputStream, String str2) throws IOException {
        sp spVar;
        if (str2 != null && (spVar = this.c) != null) {
            return com.byazt.ga.sp.c(context, new ZipInputStream(new FileInputStream(spVar.c(str2, inputStream, ve.ZIP))), str);
        }
        return com.byazt.ga.sp.c(context, new ZipInputStream(inputStream), (String) null);
    }

    private t<com.byazt.ga.a> c(String str, InputStream inputStream, String str2) throws IOException {
        sp spVar;
        if (str2 != null && (spVar = this.c) != null) {
            return com.byazt.ga.sp.tt(new FileInputStream(spVar.c(str2, inputStream, ve.JSON).getAbsolutePath()), str);
        }
        return com.byazt.ga.sp.tt(inputStream, (String) null);
    }
}
