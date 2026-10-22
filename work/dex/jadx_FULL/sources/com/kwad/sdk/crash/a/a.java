package com.kwad.sdk.crash.a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.y;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {
    private static Context aWI;
    private static String bem;

    public static boolean A(File file) {
        if (file == null) {
            return false;
        }
        return file.exists() || file.mkdirs();
    }

    public static File Qm() {
        File file;
        if (TextUtils.isEmpty(bem)) {
            Context contextHD = aWI;
            if (contextHD == null) {
                contextHD = ServiceProvider.Ud();
            }
            if (contextHD == null) {
                try {
                    contextHD = ab.HD();
                } catch (Throwable unused) {
                }
            }
            file = contextHD != null ? new File(getDataDir(contextHD), "kwad_ex") : null;
        } else {
            file = new File(bem);
        }
        if (file != null && !file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static File Qn() {
        return new File(Qm(), "java_crash/dump");
    }

    public static File Qo() {
        return new File(Qm(), "anr_log/dump");
    }

    public static File Qp() {
        return new File(Qm(), "native_crash_log/dump");
    }

    private static File getDataDir(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return new File(context.getExternalFilesDir(null).getAbsolutePath());
        }
        File dataDir = context.getDataDir();
        if (dataDir != null) {
            return dataDir;
        }
        File file = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
        if (file.exists()) {
            return file;
        }
        return new File("/data/data/" + context.getPackageName());
    }

    public static void init(@NonNull Context context, @Nullable String str) {
        aWI = context;
        bem = str;
        bem = y.T(context, "kwad_ex");
    }
}
