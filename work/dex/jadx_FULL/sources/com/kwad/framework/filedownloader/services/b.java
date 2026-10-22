package com.kwad.framework.filedownloader.services;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b implements com.kwad.framework.filedownloader.f.c.d {
    @Override // com.kwad.framework.filedownloader.f.c.d
    public final int f(String str, String str2, boolean z) {
        return g(str, str2, z);
    }

    @Override // com.kwad.framework.filedownloader.f.c.d
    public final int g(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return z ? com.kwad.framework.filedownloader.f.f.md5(com.kwad.framework.filedownloader.f.f.c("%sp%s@dir", str, str2)).hashCode() : com.kwad.framework.filedownloader.f.f.md5(com.kwad.framework.filedownloader.f.f.c("%sp%s", str, str2)).hashCode();
        } catch (Throwable unused) {
            return str.hashCode();
        }
    }
}
