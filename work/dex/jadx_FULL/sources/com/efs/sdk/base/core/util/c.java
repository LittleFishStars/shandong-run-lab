package com.efs.sdk.base.core.util;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f29616a = "";

    public static String a(Context context) {
        if (TextUtils.isEmpty(f29616a)) {
            synchronized (c.class) {
                if (TextUtils.isEmpty(f29616a)) {
                    String strB = b(context);
                    f29616a = strB;
                    if (TextUtils.isEmpty(strB)) {
                        f29616a = c(context);
                    }
                }
            }
        }
        return f29616a;
    }

    private static String b(Context context) {
        try {
            File file = new File(a.a(context), "efsid");
            if (file.exists()) {
                return FileUtil.read(file);
            }
            return null;
        } catch (Exception e) {
            Log.e("efs.base", "get uuid error", e);
            return null;
        }
    }

    private static String c(Context context) {
        String string = "";
        for (int i = 0; i < 3; i++) {
            try {
                string = UUID.randomUUID().toString();
                if (!TextUtils.isEmpty(string)) {
                    break;
                }
            } catch (Throwable unused) {
            }
        }
        try {
            File fileA = a.a(context);
            File file = new File(fileA, "efsid" + Process.myPid());
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileUtil.write(file, string);
            if (file.renameTo(new File(fileA, "efsid"))) {
                file.delete();
            }
        } catch (Exception e) {
            Log.e("efs.base", "save uuid '" + string + "' error", e);
        }
        return string;
    }
}
