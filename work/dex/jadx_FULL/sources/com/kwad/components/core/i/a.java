package com.kwad.components.core.i;

import android.content.Context;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.i;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {

    /* JADX INFO: renamed from: com.kwad.components.core.i.a$a, reason: collision with other inner class name */
    public static final class C1204a {
        private static final a SN = new a(0);
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    private static File au(Context context) {
        return new File(context.getApplicationInfo().dataDir, "ksad_dynamic");
    }

    public static a ra() {
        return C1204a.SN;
    }

    public final void at(final Context context) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        i.schedule(new Runnable() { // from class: com.kwad.components.core.i.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.a(context, jCurrentTimeMillis);
                } catch (Throwable th) {
                    c.printStackTraceOnly(th);
                }
            }
        }, 10L, TimeUnit.SECONDS);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, long j) {
        File[] fileArrListFiles = au(context).listFiles(new FileFilter() { // from class: com.kwad.components.core.i.a.2
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                String name = file.getName();
                return name.startsWith("dynamic-") && name.endsWith(".apk");
            }
        });
        if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
            return;
        }
        long jMax = 0;
        for (File file : fileArrListFiles) {
            jMax = Math.max(jMax, file.lastModified());
        }
        long jMin = Math.min(j, jMax);
        for (File file2 : fileArrListFiles) {
            if (file2.exists() && file2.lastModified() < jMin) {
                file2.delete();
            }
        }
    }
}
