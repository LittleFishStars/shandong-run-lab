package com.kc.dw.core.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.lang.ref.SoftReference;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class u0 extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SoftReference f39409a;

    public u0(SoftReference softReference) {
        this.f39409a = softReference;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        try {
            Context context = (Context) this.f39409a.get();
            if (w0.g == null) {
                try {
                    w0.g = context.getResources().getDisplayMetrics();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            DisplayMetrics displayMetrics = w0.g;
            w0.E = w0.g((Context) this.f39409a.get());
            w0.F = w0.l((Context) this.f39409a.get());
            try {
                if (TextUtils.isEmpty(w0.t) && !w0.m()) {
                    DecimalFormat decimalFormat = new DecimalFormat("0.00");
                    File externalFilesDir = com.kc.dw.base.a.getContext().getExternalFilesDir(null);
                    if (externalFilesDir != null) {
                        w0.t = decimalFormat.format(externalFilesDir.getUsableSpace() / 1048576);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            w0.e();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
