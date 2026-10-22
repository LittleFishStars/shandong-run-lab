package com.byazt.us;

import android.os.Build;
import androidx.annotation.NonNull;
import com.byazt.gq.t;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 251, 42})
public class i {
    public static boolean c(@NonNull com.byazt.dd.c cVar) {
        return com.byazt.i.n.n() && Build.VERSION.SDK_INT < 29 && t.t() != null && t.t().c() && com.byazt.hu.n.c(cVar).tt("invoke_app_form_background_switch") == 1 && cVar.nu();
    }
}
