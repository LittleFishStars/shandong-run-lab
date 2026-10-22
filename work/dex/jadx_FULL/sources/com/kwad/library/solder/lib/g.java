package com.kwad.library.solder.lib;

import android.content.Context;
import com.kwad.library.solder.lib.ext.PluginError;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class g extends com.kwad.library.solder.lib.a.a {
    public g(String str) {
        super(str);
    }

    private static void e(File file) throws PluginError.LoadError {
        if (!file.exists()) {
            throw new PluginError.LoadError("Apk file not exist.", 4001);
        }
        if (file.getAbsolutePath().trim().startsWith("/data/")) {
            return;
        }
        file.getAbsolutePath();
    }

    @Override // com.kwad.library.solder.lib.a.a
    public void l(Context context, String str) throws PluginError.LoadError {
        e(new File(str));
    }
}
