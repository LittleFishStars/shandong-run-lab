package cn.jy.ad.sdk;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.jar.JarFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class j {
    public static int a(File file, String str) {
        JarFile jarFile;
        try {
            jarFile = new JarFile(file);
            try {
                String value = jarFile.getManifest().getMainAttributes().getValue(str);
                if (!TextUtils.isEmpty(value)) {
                    int i = Integer.parseInt(value);
                    try {
                        jarFile.close();
                    } catch (Throwable unused) {
                    }
                    return i;
                }
            } catch (Throwable unused2) {
                if (jarFile == null) {
                    return -1;
                }
            }
        } catch (Throwable unused3) {
            jarFile = null;
        }
        try {
            jarFile.close();
            return -1;
        } catch (Throwable unused4) {
            return -1;
        }
    }

    public static int a(ClassLoader classLoader) {
        try {
            return ((Integer) classLoader.loadClass("cn.jy.ad.code.JySdkIter").getDeclaredMethod("version", new Class[0]).invoke(null, new Object[0])).intValue();
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static File a(Context context) {
        File file = new File(context.getFilesDir(), "_jy_file_");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static boolean a(Context context, String str) {
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            File file = new File(b(context).getAbsolutePath());
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStreamOpen.read(bArr);
                if (i == -1) {
                    fileOutputStream.close();
                    inputStreamOpen.close();
                    return true;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(File file, File file2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i == -1) {
                    fileOutputStream.close();
                    fileInputStream.close();
                    return true;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    public static File b(Context context) {
        return new File(a(context), "jy_run.jar");
    }

    public static File c(Context context) {
        return new File(a(context), "jy_up.jar");
    }

    public static boolean d(Context context) {
        return a(context, "jy.jar");
    }
}
