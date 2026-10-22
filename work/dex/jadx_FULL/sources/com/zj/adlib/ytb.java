package com.zj.adlib;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.ArrayMap;
import cn.hzjizhun.admin.base.ad.RcSdk;
import cn.hzjizhun.admin.base.g;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class ytb {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayMap f20927a = new ArrayMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HashMap f20929a = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f46116a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f20928a = g.b("cn.hzjizhun.admin.base".getBytes());

    public static void a(ytb ytbVar, String str, File file, File file2) {
        ytbVar.getClass();
        if (TextUtils.isEmpty(str) || file == null || !file.exists()) {
            return;
        }
        try {
            FileWriter fileWriter = new FileWriter(file);
            try {
                fileWriter.write(str);
                file.renameTo(file2);
                file.delete();
                fileWriter.close();
            } catch (Throwable th) {
                try {
                    fileWriter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    public final void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strB = hrb.b(str);
        if (!TextUtils.isEmpty(strB) && TextUtils.isEmpty((CharSequence) this.f20929a.get(strB))) {
            blb blbVar = new blb(this, strB);
            if (TextUtils.isEmpty(strB)) {
                return;
            }
            Boolean bool = (Boolean) this.f20927a.get(strB);
            Boolean bool2 = Boolean.TRUE;
            if (bool2.equals(bool)) {
                return;
            }
            this.f20927a.put(strB, bool2);
            File file = new File(new File(RcSdk.e().getFilesDir(), this.f20928a), strB);
            if (!file.exists() || !file.isFile()) {
                c(str, file, blbVar);
                return;
            }
            zlb zlbVar = new zlb(this, blbVar, str, file);
            mib mibVarA = mib.a();
            anb anbVar = new anb(file, zlbVar);
            mibVarA.getClass();
            mib.f18226a.submit(anbVar);
        }
    }

    public final void c(String str, File file, blb blbVar) {
        Throwable th;
        File file2;
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file2 = new File(file.getParentFile(), file.getName() + "temp");
            try {
                if (file2.exists()) {
                    file2.delete();
                }
                file2.createNewFile();
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable th2) {
                th = th2;
                th.getMessage();
            }
        } catch (Throwable th3) {
            th = th3;
            file2 = null;
        }
        mib mibVarA = mib.a();
        cqb cqbVar = new cqb(this, blbVar, file2, file);
        mibVarA.getClass();
        mib.f18226a.submit(new e8b(mibVarA, str, cqbVar));
    }
}
