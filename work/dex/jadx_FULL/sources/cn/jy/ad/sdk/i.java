package cn.jy.ad.sdk;

import android.content.Context;
import android.os.Build;
import dalvik.system.DexClassLoader;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class i implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f22773a = 0;

    public final ClassLoader a(Context context, File file, ClassLoader classLoader) {
        try {
            if (file.exists() && file.length() > 0) {
                String absolutePath = file.getAbsolutePath();
                String absolutePath2 = context.getFilesDir().getAbsolutePath();
                a(file);
                if (classLoader == null) {
                    classLoader = context.getClassLoader();
                }
                DexClassLoader dexClassLoader = new DexClassLoader(absolutePath, absolutePath2, null, classLoader);
                b(file);
                int iA = j.a(dexClassLoader);
                String.valueOf(iA);
                if (iA >= 21061) {
                    return dexClassLoader;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    @Override // cn.jy.ad.sdk.c
    public ClassLoader a(Context context, ClassLoader classLoader) {
        a(context);
        return b(context, classLoader);
    }

    public final void a(File file) {
        if (file == null || !file.exists() || Build.VERSION.SDK_INT < 34) {
            return;
        }
        file.setReadOnly();
    }

    public final boolean a(Context context) {
        try {
            File fileC = j.c(context);
            if (fileC == null || !fileC.exists()) {
                return false;
            }
            if (fileC.length() > 0 && j.a(fileC, "Implementation-Version") >= 21061) {
                File fileB = j.b(context);
                b(fileB);
                if (j.a(fileC, fileB)) {
                    fileC.delete();
                    fileC.exists();
                    return true;
                }
            }
            fileC.delete();
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final ClassLoader b(Context context, ClassLoader classLoader) {
        ClassLoader classLoaderA = null;
        try {
            File fileB = j.b(context);
            if (!fileB.exists() || fileB.length() == 0) {
                if (fileB.exists()) {
                    b(fileB);
                    fileB.delete();
                }
                j.d(context);
                fileB = j.b(context);
            }
            classLoaderA = a(context, fileB, classLoader);
            String.valueOf(classLoaderA);
            if (classLoaderA == null) {
                if (fileB.exists()) {
                    b(fileB);
                    fileB.delete();
                }
                int i = this.f22773a + 1;
                this.f22773a = i;
                if (i <= 2) {
                    return b(context, classLoader);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return classLoaderA;
    }

    public final void b(File file) {
        if (file == null || !file.exists() || file.canWrite()) {
            return;
        }
        file.setWritable(true);
    }
}
