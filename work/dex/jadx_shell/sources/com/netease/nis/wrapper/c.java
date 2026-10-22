package com.netease.nis.wrapper;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Looper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/peek/classes.dex */
final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f4a;
    final /* synthetic */ String b;

    c(Context context, String str) {
        this.f4a = context;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Looper.prepare();
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this.f4a).setMessage(this.b).setCancelable(false).setPositiveButton(a.auu.a.c("qcTagM/p"), new d(this)).create();
        alertDialogCreate.getWindow().setType(2005);
        alertDialogCreate.show();
        Looper.loop();
    }
}
