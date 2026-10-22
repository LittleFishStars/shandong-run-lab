package com.kc.dw.core.utils;

import android.text.TextUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class o0 {
    public static volatile o0 d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f39392a;
    public volatile PackageBean b;
    public final Object c = new Object();

    public o0() {
        try {
            System.currentTimeMillis();
            this.f39392a = new File(com.kc.dw.base.a.getContext().getFilesDir(), "file_cg_preferences.json");
            b();
            System.currentTimeMillis();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static o0 a() {
        if (d == null) {
            synchronized (o0.class) {
                try {
                    if (d == null) {
                        d = new o0();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    public final void a(String str) {
        try {
            synchronized (this.c) {
                File file = this.f39392a;
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                    try {
                        bufferedWriter.write(str);
                        bufferedWriter.close();
                    } catch (Throwable th) {
                        try {
                            bufferedWriter.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        } catch (Throwable th4) {
            th4.printStackTrace();
        }
    }

    public final void b() {
        try {
            if (!this.f39392a.exists()) {
                try {
                    this.f39392a.createNewFile();
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            synchronized (this.c) {
                String strB = t.b(this.f39392a);
                if (TextUtils.isEmpty(strB)) {
                    strB = com.kc.dw.base.a.getSharedPreferences().getString("packageKey", "");
                }
                if (TextUtils.isEmpty(strB)) {
                    return;
                }
                this.b = (PackageBean) v.f39411a.fromJson(strB, PackageBean.class);
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        th.printStackTrace();
    }
}
