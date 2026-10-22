package com.netease.nis.wrapper;

import android.content.pm.ApplicationInfo;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/peek/classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static File f7a = null;
    private static final int b = 4096;

    public static ApplicationInfo a() {
        try {
            Class<?> cls = Class.forName(a.auu.a.c("LwsQFw4aAWAEBBVPMgY6DAIMFQoxJhcRBAU="));
            Object objInvoke = cls.getMethod(a.auu.a.c("LRAGFwQdEQ8GAAwXGhE3MRwXBBIB"), new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField(a.auu.a.c("IycbEA8XJD4VGAwCEhEnCho="));
            declaredField.setAccessible(true);
            Object obj = declaredField.get(objInvoke);
            Field declaredField2 = obj.getClass().getDeclaredField(a.auu.a.c("LxUELA8VCg=="));
            declaredField2.setAccessible(true);
            return (ApplicationInfo) declaredField2.get(obj);
        } catch (Exception e) {
            String str = MyApplication.TAG;
            new StringBuilder(a.auu.a.c("KQAAJBEDCScGFREIHAsHCxIKQRUEJwkRAUFJRQ==")).append(e.toString());
            return null;
        }
    }

    private static File a(ApplicationInfo applicationInfo) {
        if (f7a == null) {
            File file = new File(applicationInfo.dataDir, a.auu.a.c("KAwYABI="));
            f7a = file;
            if (!file.exists()) {
                f7a.mkdirs();
            }
        }
        return f7a;
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
        byte[] bArr = new byte[b];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            }
            for (int i2 = 0; i2 < i; i2++) {
                bArr[i2] = (byte) (bArr[i2] ^ 127);
            }
            outputStream.write(bArr, 0, i);
        }
    }

    public static boolean a(ClassLoader classLoader, ApplicationInfo applicationInfo) {
        String strC = a.auu.a.c("IAAHAAI=");
        if (MyApplication.needX86So() && MyJni.a()) {
            strC = strC + a.auu.a.c("Yx1MUw==");
        }
        b(classLoader, applicationInfo);
        try {
            System.loadLibrary(strC);
            String str = MyApplication.TAG;
            new StringBuilder(a.auu.a.c("DQoZFUEfCi8BOAwDAQQ8HFQ=")).append(strC).append(a.auu.a.c("bhYBBgIWFj0="));
            MyApplication.mLoadShell = true;
            return true;
        } catch (UnsatisfiedLinkError e) {
            String str2 = MyApplication.TAG;
            new StringBuilder(a.auu.a.c("DQoZFUEfCi8BOAwDAQQ8HFQ=")).append(strC).append(a.auu.a.c("bgMVDA0WAW5fVA==")).append(e.toString());
            return false;
        }
    }

    private static boolean a(String str, String str2, String str3) throws Throwable {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        Closeable closeable = null;
        String str4 = MyApplication.TAG;
        new StringBuilder(a.auu.a.c("PREVFxVTECAfHRVB")).append(str2).append(a.auu.a.c("bgMGCgw=")).append(str).append(a.auu.a.c("bhEbRQ==")).append(str3);
        try {
            ZipFile zipFile = new ZipFile(new File(str), 1);
            ZipEntry entry = zipFile.getEntry(str2);
            if (entry == null) {
                String str5 = MyApplication.TAG;
                new StringBuilder(a.auu.a.c("KAwaAUEWCzoXDUU=")).append(str2).append(a.auu.a.c("KAQdCQQX"));
                return false;
            }
            try {
                inputStream = zipFile.getInputStream(entry);
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(str3);
                    try {
                        a(inputStream, fileOutputStream2);
                        a(inputStream);
                        a(fileOutputStream2);
                        return true;
                    } catch (FileNotFoundException e) {
                        fileOutputStream = fileOutputStream2;
                        closeable = inputStream;
                        a(closeable);
                        a(fileOutputStream);
                        return false;
                    } catch (IOException e2) {
                        closeable = fileOutputStream2;
                        a(inputStream);
                        a(closeable);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        closeable = fileOutputStream2;
                        a(inputStream);
                        a(closeable);
                        throw th;
                    }
                } catch (FileNotFoundException e3) {
                    fileOutputStream = null;
                    closeable = inputStream;
                } catch (IOException e4) {
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (FileNotFoundException e5) {
                fileOutputStream = null;
            } catch (IOException e6) {
                inputStream = null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
        } catch (IOException e7) {
            return false;
        }
    }

    private static boolean b(ClassLoader classLoader, ApplicationInfo applicationInfo) {
        boolean z = false;
        long jLastModified = new File(applicationInfo.sourceDir).lastModified();
        String str = a(applicationInfo) + a.auu.a.c("YRERCBEfDCw=");
        String str2 = str + a.auu.a.c("YQ==") + jLastModified;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            com.netease.nis.wrapper.plugin.c.a(classLoader, file);
        } catch (Throwable th) {
            String str3 = MyApplication.TAG;
            th.toString();
        }
        File file2 = new File(str2);
        if (file2.exists()) {
            return false;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file3 : fileArrListFiles) {
                if (file3.isFile()) {
                    file3.delete();
                }
            }
        }
        try {
            String str4 = a(applicationInfo) + a.auu.a.c("YRERCBEfDCxKGAwDAEs0DAQ=");
            String str5 = applicationInfo.nativeLibraryDir;
            if (a(applicationInfo.sourceDir, a.auu.a.c("LxYHABUASmALERYEEDo+BAAGCQ=="), str4)) {
                String str6 = MyApplication.TAG;
                if (com.netease.nis.wrapper.plugin.c.a(str4, str, str5)) {
                    String str7 = MyApplication.TAG;
                    z = true;
                } else {
                    String str8 = MyApplication.TAG;
                }
            } else {
                String str9 = MyApplication.TAG;
            }
            if (z) {
                file2.createNewFile();
            }
        } catch (Exception e) {
            String str10 = MyApplication.TAG;
            e.toString();
        }
        return true;
    }
}
