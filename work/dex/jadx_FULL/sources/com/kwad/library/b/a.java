package com.kwad.library.b;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import com.kwad.library.b.a.b;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.h;
import com.kwad.sdk.utils.y;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends h {
    private b aDG;
    private Resources aDH;

    public a(String str) {
        super(str);
    }

    private b a(File file, File file2) {
        com.kwad.library.b.a.a aVar = new com.kwad.library.b.a.a((BaseDexClassLoader) a.class.getClassLoader());
        String absolutePath = file2.getAbsolutePath();
        String absolutePath2 = this.aEE.getAbsolutePath();
        com.kwad.library.solder.lib.c.b bVar = this.aEK;
        return new b(aVar, absolutePath, file, absolutePath2, bVar.aFz, bVar.aFy);
    }

    private File d(File file) throws IOException {
        File file2 = new File(file.getParentFile(), this.aEj.En());
        y.aa(file2);
        return file2;
    }

    public final b DG() {
        return this.aDG;
    }

    public final Resources getResources() {
        return this.aDH;
    }

    @Override // com.kwad.library.solder.lib.h, com.kwad.library.solder.lib.g, com.kwad.library.solder.lib.a.a
    public final void l(Context context, String str) throws PluginError.LoadError {
        super.l(context, str);
        File file = new File(str);
        try {
            File fileD = d(file);
            try {
                if (Build.VERSION.SDK_INT >= 34 && context != null && context.getApplicationInfo().targetSdkVersion >= 34) {
                    file.setReadOnly();
                    fileD.setReadOnly();
                }
            } catch (Throwable unused) {
            }
            this.aDG = a(fileD, file);
            try {
                this.aDH = com.kwad.library.b.b.b.a(context, context.getResources(), str);
                Objects.toString(this.aDG);
                Objects.toString(this.aDH);
            } catch (Exception e) {
                Log.getStackTraceString(e);
                throw new PluginError.LoadError(e, 4006);
            }
        } catch (IOException e2) {
            throw new PluginError.LoadError(e2, 4002);
        }
    }
}
