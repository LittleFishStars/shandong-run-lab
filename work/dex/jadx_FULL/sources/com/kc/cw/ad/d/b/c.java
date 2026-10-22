package com.kc.cw.ad.d.b;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.widget.Toast;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c {
    public static final File a(Context context) {
        File fileB = b(context);
        if (fileB == null) {
            return null;
        }
        File file = new File(fileB.getPath() + "/SSAd/download/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static void a(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setFlags(268435456);
                context.startActivity(launchIntentForPackage);
            }
        } catch (Exception unused) {
            Toast.makeText(context, "启动失败:" + str, 1).show();
        }
    }

    public static void a(String str) {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static File b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            File externalFilesDir = ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) ? context.getExternalFilesDir(null) : null;
            return externalFilesDir == null ? context.getFilesDir() : externalFilesDir;
        } catch (Exception unused) {
            return context.getFilesDir();
        }
    }

    public static File c(Context context) {
        File externalCacheDir = ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) ? context.getExternalCacheDir() : null;
        return externalCacheDir == null ? context.getCacheDir() : externalCacheDir;
    }
}
