package com.kwad.framework.filedownloader.services;

import android.content.Intent;
import com.zj.adlib.ze1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class f {
    public static void f(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException();
        }
        if (cVar.AH() != -3) {
            throw new IllegalStateException();
        }
        Intent intent = new Intent("filedownloader.intent.action.completed");
        intent.putExtra(ze1.k, cVar);
        com.kwad.framework.filedownloader.f.c.Dx().sendBroadcast(intent);
    }
}
