package com.ipd.dsp.internal.g0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class a {
    public static final String f = "";
    public static final File g = new File("");

    @Nullable
    public abstract String a();

    public boolean a(a aVar) {
        if (!e().equals(aVar.e()) || e().equals("") || c().equals(g) || d().equals(aVar.c())) {
            return false;
        }
        String strA = a();
        String strA2 = aVar.a();
        return strA2 != null && strA2.equals(strA);
    }

    public abstract int b();

    @NonNull
    public abstract File c();

    @NonNull
    public abstract File d();

    @NonNull
    public abstract String e();
}
