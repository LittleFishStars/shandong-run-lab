package com.kwad.sdk.core.diskcache.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.i;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b {
    public static void a(@NonNull final com.kwad.sdk.core.diskcache.a.a aVar, @NonNull final String str, @NonNull final String str2) {
        i.execute(new bi() { // from class: com.kwad.sdk.core.diskcache.b.b.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                OutputStream outputStreamEs = null;
                try {
                    com.kwad.sdk.core.diskcache.a.a.C1276a c1276aEo = aVar.eo(str2);
                    if (c1276aEo != null) {
                        outputStreamEs = c1276aEo.es(0);
                        if (b.a(str, outputStreamEs, new com.kwad.sdk.core.network.a.a.C1286a())) {
                            c1276aEo.commit();
                        } else {
                            c1276aEo.abort();
                        }
                        aVar.flush();
                    }
                } catch (IOException unused) {
                } finally {
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStreamEs);
                }
            }
        });
    }

    public static File a(@NonNull com.kwad.sdk.core.diskcache.a.a aVar, @NonNull String str) throws Throwable {
        com.kwad.sdk.core.diskcache.a.a.c cVarEn;
        com.kwad.sdk.core.diskcache.a.a.c cVar = null;
        try {
            cVarEn = aVar.en(str);
            if (cVarEn != null) {
                try {
                    File fileEv = cVarEn.ev(0);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cVarEn);
                    return fileEv;
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th = th;
                    cVar = cVarEn;
                    com.kwad.sdk.crash.utils.b.closeQuietly(cVar);
                    throw th;
                }
            }
        } catch (IOException unused2) {
            cVarEn = null;
        } catch (Throwable th2) {
            th = th2;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cVarEn);
        return null;
    }

    public static boolean a(@NonNull com.kwad.sdk.core.diskcache.a.a aVar, @NonNull String str, @NonNull String str2, com.kwad.sdk.core.network.a.a.C1286a c1286a) {
        boolean z = false;
        OutputStream outputStreamEs = null;
        try {
            try {
                com.kwad.sdk.core.diskcache.a.a.C1276a c1276aEo = aVar.eo(str2);
                if (c1276aEo != null) {
                    outputStreamEs = c1276aEo.es(0);
                    if (a(str, outputStreamEs, c1286a)) {
                        c1276aEo.commit();
                        z = true;
                    } else {
                        c1276aEo.abort();
                    }
                    aVar.flush();
                }
            } catch (IOException e) {
                c1286a.msg = e.getMessage();
            }
            return z;
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStreamEs);
        }
    }

    public static boolean a(String str, OutputStream outputStream, com.kwad.sdk.core.network.a.a.C1286a c1286a) {
        return com.kwad.sdk.core.network.a.a.a(str, outputStream, c1286a, -1L, true, null);
    }
}
