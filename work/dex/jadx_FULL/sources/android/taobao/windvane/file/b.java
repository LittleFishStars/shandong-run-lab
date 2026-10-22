package android.taobao.windvane.file;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f21237a = "success";
    static final int b = 1024;
    private static final String c = "FileManager";

    public static File a(Context context, String str) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        if (!TextUtils.isEmpty(str)) {
            absolutePath = absolutePath + File.separator + str;
        }
        File file = new File(absolutePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String b(Application application, String str, String str2) {
        if (application.getFilesDir() == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(application.getFilesDir().getAbsolutePath());
        if (!TextUtils.isEmpty(str)) {
            sb.append(File.separator);
            sb.append(str);
        }
        sb.append(File.separator);
        sb.append(str2);
        String string = sb.toString();
        TaoLog.d(c, "createInnerfileStorage path:" + string);
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0081  */
    public static String a(Application application, String str, String str2, boolean z) {
        String strA;
        StringBuilder sb;
        if (z) {
            File externalCacheDir = application.getExternalCacheDir();
            if (externalCacheDir != null) {
                sb = new StringBuilder();
                sb.append(externalCacheDir.getAbsolutePath());
                sb.append(File.separator);
            } else {
                File file = new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + application.getPackageName() + "/cache/"));
                if (!file.exists()) {
                    file.mkdirs();
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(file.getAbsolutePath());
                sb2.append(File.separator);
                sb = sb2;
            }
            if (TextUtils.isEmpty(str)) {
                strA = null;
            } else {
                sb.append(str);
                sb.append(File.separator);
                sb.append(str2);
                strA = sb.toString();
            }
        } else {
            strA = null;
        }
        if (strA == null) {
            strA = a(application, str, str2);
        }
        TaoLog.d(c, "createBaseDir path:" + strA);
        return strA;
    }

    public static String a(Application application, String str, String str2) {
        if (application.getFilesDir() == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(application.getCacheDir().getAbsolutePath());
        if (!TextUtils.isEmpty(str)) {
            sb.append(File.separator);
            sb.append(str);
        }
        sb.append(File.separator);
        sb.append(str2);
        String string = sb.toString();
        TaoLog.d(c, "createInnerCacheStorage path:" + string);
        return string;
    }
}
