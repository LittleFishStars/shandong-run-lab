package com.ipd.dsp.internal.s1;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AlertDialog f38536a;
    public DialogInterface.OnClickListener b = new DialogInterface.OnClickListener() { // from class: com.zj.adlib.m2b
        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            this.f43207a.a(dialogInterface, i);
        }
    };
    public Runnable c;
    public Runnable d;

    public f(@NonNull Context context, Runnable runnable, Runnable runnable2) {
        this.c = runnable;
        this.d = runnable2;
        this.f38536a = new AlertDialog.Builder(context).setMessage("即将跳转到其他应用").setPositiveButton(R.string.ok, this.b).setNegativeButton(R.string.cancel, this.b).setCancelable(false).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.zj.adlib.u2b
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f45051a.a(dialogInterface);
            }
        }).create();
    }

    public final /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            Runnable runnable = this.c;
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        Runnable runnable2 = this.d;
        if (runnable2 != null) {
            runnable2.run();
        }
    }

    public void b() {
        AlertDialog alertDialog = this.f38536a;
        if (alertDialog != null) {
            alertDialog.show();
        }
    }

    public final /* synthetic */ void a(DialogInterface dialogInterface) {
        a();
    }

    public void a() {
        AlertDialog alertDialog = this.f38536a;
        if (alertDialog != null) {
            try {
                if (alertDialog.isShowing()) {
                    this.f38536a.dismiss();
                }
            } catch (Throwable unused) {
            }
            this.f38536a = null;
        }
        this.b = null;
        this.c = null;
        this.d = null;
    }
}
