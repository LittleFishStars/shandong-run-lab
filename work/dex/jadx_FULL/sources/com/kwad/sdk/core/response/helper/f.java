package com.kwad.sdk.core.response.helper;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.y;
import java.io.File;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class f {
    private String aXD;

    public static class a {
        private static final f aXE = new f(0);
    }

    public /* synthetic */ f(byte b) {
        this();
    }

    @Nullable
    @WorkerThread
    private static String NB() {
        try {
            File file = new File(bg.ej(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext()));
            if (file.exists()) {
                return y.a(file, Charset.forName("UTF-8"));
            }
            return null;
        } catch (Exception e) {
            if (!com.kwad.framework.a.a.pe.booleanValue()) {
                return null;
            }
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    public static f Nz() {
        return a.aXE;
    }

    @WorkerThread
    private static void fo(String str) {
        try {
            y.a(new File(bg.ej(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())), str, Charset.forName("UTF-8"), false);
        } catch (Exception e) {
            if (com.kwad.framework.a.a.pe.booleanValue()) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
        }
    }

    @Nullable
    @WorkerThread
    public final String NA() {
        return this.aXD;
    }

    @WorkerThread
    public final void fn(String str) {
        if (br.isEquals(this.aXD, str)) {
            return;
        }
        this.aXD = str;
        fo(str);
    }

    private f() {
        this.aXD = NB();
    }
}
