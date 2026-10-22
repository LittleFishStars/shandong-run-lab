package com.netease.nis.wrapper;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import dalvik.system.PathClassLoader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/peek/classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f13a = "lib";
    private static final int b = 5;
    private static final int c = 4096;

    private o() {
    }

    private static File a(Context context) {
        return context.getDir(a.auu.a.c("IgwW"), 0);
    }

    private static Object a(Object obj) throws NoSuchFieldException {
        Field declaredField = Class.forName(a.auu.a.c("KgQYEwgYSz0cBxEEHksMBAcAJRYdDQkVFhI/Ci8BERc=")).getDeclaredField(a.auu.a.c("PgQADS0aFjo="));
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    private static Object a(Object obj, Class cls, String str) throws NoSuchFieldException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    private static void a(Context context, File file) {
        boolean z = false;
        if (b()) {
            try {
                PathClassLoader pathClassLoader = (PathClassLoader) context.getClassLoader();
                Field declaredField = Class.forName(a.auu.a.c("KgQYEwgYSz0cBxEEHksMBAcAJRYdDQkVFhI/Ci8BERc=")).getDeclaredField(a.auu.a.c("PgQADS0aFjo="));
                declaredField.setAccessible(true);
                Object obj = declaredField.get(pathClassLoader);
                Field declaredField2 = obj.getClass().getDeclaredField(a.auu.a.c("IAQADBcWKScHBgQTCiEnFxEGFRwXJwAH"));
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(obj);
                if (!(obj2 instanceof Object[])) {
                    if (obj2 instanceof ArrayList) {
                        ArrayList arrayList = (ArrayList) obj2;
                        if (arrayList.indexOf(file) == -1) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                it.next();
                            }
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(file);
                            arrayList2.addAll(arrayList);
                            Iterator it2 = arrayList2.iterator();
                            while (it2.hasNext()) {
                                it2.next();
                            }
                            declaredField2.set(obj, arrayList2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                File[] fileArr = (File[]) obj2;
                for (File file2 : fileArr) {
                    if (file2 == file || (file != null && file.equals(file2))) {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    return;
                }
                int length = fileArr.length + 1;
                Object objNewInstance = Array.newInstance((Class<?>) File.class, length);
                Array.set(objNewInstance, 0, file);
                for (int i = 1; i < length; i++) {
                    Array.set(objNewInstance, i, fileArr[i - 1]);
                }
                declaredField2.set(obj, objNewInstance);
            } catch (Exception e) {
            }
        }
    }

    public static void a(Context context, String str) {
        String str2 = MyApplication.TAG;
        if (context == null) {
            throw new IllegalArgumentException(a.auu.a.c("CQwCAA9TBiELAAAZB0UnFlQLFB8J"));
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(a.auu.a.c("CQwCAA9TCScHBgQTCkUnFlQACAcNKxdUCxQfCW4KBkUEHhU6HA=="));
        }
        try {
            System.loadLibrary(str);
            String str3 = MyApplication.TAG;
            new StringBuilder(a.auu.a.c("HRwHEQQeSyIKFQEtGgc8BAYcQQ==")).append(str).append(a.auu.a.c("bhYBBgIWFj0="));
        } catch (UnsatisfiedLinkError e) {
            String str4 = MyApplication.TAG;
            new StringBuilder(a.auu.a.c("IgoVAS0aBzwEBhxBFQQnCREBWw==")).append(e.toString());
            String str5 = MyApplication.TAG;
            new StringBuilder(a.auu.a.c("HRwHEQQeSyIKFQEtGgc8BAYcQQ==")).append(str).append(a.auu.a.c("bgMVDA0WAQ=="));
            File fileB = b(context, str);
            if (!fileB.exists()) {
                c(context, str);
            }
            try {
                System.load(fileB.getAbsolutePath());
                String str6 = MyApplication.TAG;
                new StringBuilder(a.auu.a.c("PAAYDA8YRSIKFQFB")).append(str).append(a.auu.a.c("bhYBBgIWFj0="));
            } catch (UnsatisfiedLinkError e2) {
                String str7 = MyApplication.TAG;
                new StringBuilder(a.auu.a.c("PAAYDA8YRSIKFQFB")).append(str).append(a.auu.a.c("bgMVDA0WAXQ=")).append(e2.toString());
                try {
                    File file = new File(fileB.getParent());
                    if (b()) {
                        try {
                            b(context, file);
                        } catch (Exception e3) {
                        }
                    }
                    System.loadLibrary(str);
                    String str8 = MyApplication.TAG;
                    new StringBuilder(a.auu.a.c("LwIVDA9TCSEEECkIERcvFw1F")).append(str).append(a.auu.a.c("bhYBBgIWFj0="));
                } catch (UnsatisfiedLinkError e4) {
                    String str9 = MyApplication.TAG;
                    new StringBuilder(a.auu.a.c("LwIVDA9TCSEEECkIERcvFw1F")).append(str).append(a.auu.a.c("bgMVDA0WAXQ=")).append(e4.toString());
                    String str10 = MyApplication.TAG;
                }
            }
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    private static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[c];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
    }

    private static boolean a(Object[] objArr, Object obj) {
        for (Object obj2 : objArr) {
            if (obj2 == obj || (obj != null && obj.equals(obj2))) {
                return true;
            }
        }
        return false;
    }

    private static String[] a() {
        if (Build.VERSION.SDK_INT < 21 || Build.SUPPORTED_ABIS.length <= 0) {
            return !TextUtils.isEmpty(Build.CPU_ABI2) ? new String[]{Build.CPU_ABI, Build.CPU_ABI2} : new String[]{Build.CPU_ABI};
        }
        return Build.SUPPORTED_ABIS;
    }

    private static File b(Context context, String str) {
        return new File(context.getDir(a.auu.a.c("IgwW"), 0), System.mapLibraryName(str));
    }

    private static void b(Context context, File file) throws IllegalAccessException, NoSuchFieldException {
        boolean z;
        PathClassLoader pathClassLoader = (PathClassLoader) context.getClassLoader();
        Field declaredField = Class.forName(a.auu.a.c("KgQYEwgYSz0cBxEEHksMBAcAJRYdDQkVFhI/Ci8BERc=")).getDeclaredField(a.auu.a.c("PgQADS0aFjo="));
        declaredField.setAccessible(true);
        Object obj = declaredField.get(pathClassLoader);
        Field declaredField2 = obj.getClass().getDeclaredField(a.auu.a.c("IAQADBcWKScHBgQTCiEnFxEGFRwXJwAH"));
        declaredField2.setAccessible(true);
        Object obj2 = declaredField2.get(obj);
        if (!(obj2 instanceof Object[])) {
            if (obj2 instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) obj2;
                if (arrayList.indexOf(file) == -1) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(file);
                    arrayList2.addAll(arrayList);
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        it2.next();
                    }
                    declaredField2.set(obj, arrayList2);
                    return;
                }
                return;
            }
            return;
        }
        File[] fileArr = (File[]) obj2;
        int length = fileArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            File file2 = fileArr[i];
            if (file2 == file || file.equals(file2)) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            return;
        }
        int length2 = fileArr.length + 1;
        Object objNewInstance = Array.newInstance((Class<?>) File.class, length2);
        Array.set(objNewInstance, 0, file);
        for (int i2 = 1; i2 < length2; i2++) {
            Array.set(objNewInstance, i2, fileArr[i2 - 1]);
        }
        declaredField2.set(obj, objNewInstance);
    }

    private static boolean b() {
        try {
            Class.forName(a.auu.a.c("KgQYEwgYSz0cBxEEHksMBAcAJRYdDQkVFhI/Ci8BERc="));
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private static void c(Context context, String str) throws Throwable {
        ZipFile zipFile;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        boolean z;
        ZipFile zipFile2 = null;
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i >= b) {
                    zipFile = null;
                    break;
                } else {
                    try {
                        zipFile = new ZipFile(new File(applicationInfo.sourceDir), 1);
                        break;
                    } catch (IOException e) {
                        i = i2;
                    }
                }
            }
            if (zipFile == null) {
                if (zipFile != null) {
                    try {
                        zipFile.close();
                        return;
                    } catch (IOException e2) {
                        return;
                    }
                }
                return;
            }
            int i3 = 0;
            while (true) {
                i3++;
                if (i3 >= b) {
                    break;
                }
                try {
                    ZipEntry entry = null;
                    String str2 = null;
                    for (String str3 : (Build.VERSION.SDK_INT < 21 || Build.SUPPORTED_ABIS.length <= 0) ? !TextUtils.isEmpty(Build.CPU_ABI2) ? new String[]{Build.CPU_ABI, Build.CPU_ABI2} : new String[]{Build.CPU_ABI} : Build.SUPPORTED_ABIS) {
                        str2 = a.auu.a.c("IgwW") + File.separatorChar + str3 + File.separatorChar + System.mapLibraryName(str);
                        entry = zipFile.getEntry(str2);
                        if (entry != null) {
                            break;
                        }
                    }
                    if (entry == null) {
                        if (str2 == null) {
                            throw new p(str);
                        }
                        entry = zipFile.getEntry(a.auu.a.c("IgwW") + File.separatorChar + a.auu.a.c("LxcZAAARDA==") + File.separatorChar + System.mapLibraryName(str));
                        if (entry == null) {
                            throw new p(str2);
                        }
                    }
                    File fileB = b(context, str);
                    fileB.delete();
                    try {
                        if (fileB.createNewFile()) {
                            try {
                                inputStream = zipFile.getInputStream(entry);
                                try {
                                    fileOutputStream = new FileOutputStream(fileB);
                                    try {
                                        a(inputStream, fileOutputStream);
                                        a((Closeable) inputStream);
                                        a((Closeable) fileOutputStream);
                                        z = false;
                                    } catch (FileNotFoundException e3) {
                                        a((Closeable) inputStream);
                                        a((Closeable) fileOutputStream);
                                        z = true;
                                    } catch (IOException e4) {
                                        a((Closeable) inputStream);
                                        a((Closeable) fileOutputStream);
                                        z = true;
                                    } catch (Throwable th) {
                                        zipFile2 = inputStream;
                                        th = th;
                                        a((Closeable) zipFile2);
                                        a((Closeable) fileOutputStream);
                                        throw th;
                                    }
                                } catch (FileNotFoundException e5) {
                                    fileOutputStream = null;
                                } catch (IOException e6) {
                                    fileOutputStream = null;
                                } catch (Throwable th2) {
                                    fileOutputStream = null;
                                    zipFile2 = inputStream;
                                    th = th2;
                                }
                            } catch (FileNotFoundException e7) {
                                inputStream = null;
                                fileOutputStream = null;
                            } catch (IOException e8) {
                                inputStream = null;
                                fileOutputStream = null;
                            } catch (Throwable th3) {
                                th = th3;
                                fileOutputStream = null;
                            }
                            if (!z && fileB.exists() && fileB.length() != 0) {
                                fileB.setReadable(true, false);
                                fileB.setExecutable(true, false);
                                fileB.setWritable(true);
                                break;
                            }
                        }
                    } catch (IOException e9) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    zipFile2 = zipFile;
                    if (zipFile2 != null) {
                        try {
                            zipFile2.close();
                        } catch (IOException e10) {
                        }
                    }
                    throw th;
                }
            }
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e11) {
                }
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }
}
