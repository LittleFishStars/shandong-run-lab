package com.byazt.pp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1434, 15})
public final class uj {
    public static Toast c;

    public static void c(Context context, String str) {
        c(context, str, 0);
    }

    public static void c(Context context, String str, int i) {
        Toast toastC = c(context);
        if (toastC == null) {
            com.byazt.eu.tt.tt("TToast", "toast msg: ".concat(String.valueOf(str)));
            return;
        }
        toastC.setDuration(i);
        toastC.setText(String.valueOf(str));
        toastC.show();
    }

    @SuppressLint({"ShowToast"})
    private static Toast c(Context context) {
        if (context == null) {
            return c;
        }
        Toast toastMakeText = Toast.makeText(context.getApplicationContext(), "", 0);
        c = toastMakeText;
        return toastMakeText;
    }
}
