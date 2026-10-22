package com.baidu.mapsdkplatform.comapi;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class NativeLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f26672a = "NativeLoader";
    private static Context b;
    private static NativeLoader e;
    private static final Set<String> c = new HashSet();
    private static final Set<String> d = new HashSet();
    private static c f = c.ARMEABI;
    private static boolean g = false;
    private static String h = null;

    public class a implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f26673a;

        public a(String str) {
            this.f26673a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return (str == null || !str.contains("libBaiduMapSDK_") || str.contains(this.f26673a)) ? false : true;
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f26674a;

        static {
            int[] iArr = new int[c.values().length];
            f26674a = iArr;
            try {
                iArr[c.ARM64.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26674a[c.ARMV7.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26674a[c.ARMEABI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f26674a[c.X86_64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f26674a[c.X86.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum c {
        ARMEABI("armeabi"),
        ARMV7("armeabi-v7a"),
        ARM64("arm64-v8a"),
        X86("x86"),
        X86_64("x86_64");

        private String g;

        c(String str) {
            this.g = str;
        }

        public String a() {
            return this.g;
        }
    }

    private NativeLoader() {
    }

    public static void a(boolean z, String str) {
        g = z;
        h = str;
    }

    private boolean b(String str) {
        try {
            Set<String> set = c;
            synchronized (set) {
                if (set.contains(str)) {
                    return true;
                }
                System.loadLibrary(str);
                synchronized (set) {
                    set.add(str);
                }
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return a(str);
        }
    }

    private boolean c(String str, String str2) {
        c cVar = c.ARMEABI;
        if (a(str2, cVar)) {
            return g(str2, str);
        }
        Log.e(f26672a, "found lib " + cVar.a() + WVNativeCallbackUtil.SEPERATER + str + ".so error");
        return false;
    }

    private boolean d(String str, String str2) {
        return !a(str2, c.ARMV7) ? c(str, str2) : g(str2, str);
    }

    private boolean e(String str, String str2) {
        return !a(str2, c.X86_64) ? f(str, str2) : g(str2, str);
    }

    private boolean f(String str, String str2) {
        return !a(str2, c.X86) ? d(str, str2) : g(str2, str);
    }

    private boolean g(String str, String str2) {
        try {
            System.loadLibrary(new File(b(), str).getAbsolutePath());
            Set<String> set = c;
            synchronized (set) {
                set.add(str2);
            }
            a(str, str2);
            return true;
        } catch (Throwable th) {
            Set<String> set2 = d;
            synchronized (set2) {
                set2.add(str2);
                a(th);
                return false;
            }
        }
    }

    public static synchronized NativeLoader getInstance() {
        if (e == null) {
            e = new NativeLoader();
            f = c();
        }
        return e;
    }

    public static void setContext(Context context) {
        b = context;
    }

    public synchronized boolean loadLibrary(String str) {
        if (!g) {
            return b(str);
        }
        String str2 = h;
        if (str2 == null || str2.isEmpty()) {
            Log.e(f26672a, "Given custom so file path is null, please check!");
            return false;
        }
        return a(str);
    }

    private boolean a(String str) {
        boolean zB;
        String strMapLibraryName = System.mapLibraryName(str);
        Set<String> set = c;
        synchronized (set) {
            if (set.contains(str)) {
                return true;
            }
            int i = b.f26674a[f.ordinal()];
            if (i == 1) {
                zB = b(str, strMapLibraryName);
            } else if (i == 2) {
                zB = d(str, strMapLibraryName);
            } else if (i == 3) {
                zB = c(str, strMapLibraryName);
            } else if (i != 4) {
                zB = i != 5 ? false : f(str, strMapLibraryName);
            } else {
                zB = e(str, strMapLibraryName);
            }
            synchronized (set) {
                set.add(str);
            }
            return zB;
        }
    }

    @TargetApi(21)
    private static c c() {
        String str = Build.SUPPORTED_ABIS[0];
        if (str == null) {
            return c.ARMEABI;
        }
        if (str.contains("arm") && str.contains("v7")) {
            f = c.ARMV7;
        }
        if (str.contains("arm") && str.contains("64") && d()) {
            f = c.ARM64;
        }
        if (str.contains("x86")) {
            if (str.contains("64")) {
                f = c.X86_64;
            } else {
                f = c.X86;
            }
        }
        return f;
    }

    private static boolean d() {
        return Process.is64Bit();
    }

    private boolean b(String str, String str2) {
        if (!a(str2, c.ARM64)) {
            return d(str, str2);
        }
        return g(str2, str);
    }

    private String b() {
        if (b == null) {
            return "";
        }
        File file = new File(b.getFilesDir(), "libs" + File.separator + f.a());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private boolean a(String str, c cVar) throws Throwable {
        String strA;
        File file = new File(b(), str);
        if (file.exists() && file.length() > 0) {
            return true;
        }
        String str2 = a(cVar) + str;
        if (!g) {
            strA = a();
        } else {
            strA = h;
        }
        if (strA == null || strA.isEmpty()) {
            return false;
        }
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(strA);
                try {
                    ZipEntry entry = zipFile2.getEntry(str2);
                    if (entry == null) {
                        try {
                            zipFile2.close();
                        } catch (IOException e2) {
                            Log.e(f26672a, "Release file failed", e2);
                        }
                        return false;
                    }
                    a(zipFile2.getInputStream(entry), new FileOutputStream(new File(b(), str)));
                    try {
                        zipFile2.close();
                    } catch (IOException e3) {
                        Log.e(f26672a, "Release file failed", e3);
                    }
                    return true;
                } catch (Exception e4) {
                    e = e4;
                    zipFile = zipFile2;
                    Log.e(f26672a, "Copy library file error", e);
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e5) {
                            Log.e(f26672a, "Release file failed", e5);
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e6) {
                            Log.e(f26672a, "Release file failed", e6);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e7) {
            e = e7;
        }
    }

    private void a(String str, String str2) {
        if (str == null || str.isEmpty() || !str.contains("libBaiduMapSDK_")) {
            return;
        }
        try {
            String[] strArrSplit = str.split("_v");
            if (strArrSplit.length <= 1) {
                return;
            }
            File[] fileArrListFiles = new File(b()).listFiles(new a(strArrSplit[1]));
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                return;
            }
            for (File file : fileArrListFiles) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    @TargetApi(8)
    private String a() {
        return b == null ? "" : b.getPackageCodePath();
    }

    private void a(Throwable th) {
        Log.e(f26672a, "loadException", th);
        for (String str : d) {
            Log.e(f26672a, str + " Failed to load.");
        }
    }

    private void a(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    break;
                } else {
                    fileOutputStream.write(bArr, 0, i);
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    Log.e(f26672a, "Close InputStream error", e2);
                }
                try {
                    fileOutputStream.close();
                    throw th;
                } catch (IOException e3) {
                    Log.e(f26672a, "Close OutputStream error", e3);
                    throw th;
                }
            }
        }
        fileOutputStream.flush();
        try {
            inputStream.close();
        } catch (IOException e4) {
            Log.e(f26672a, "Close InputStream error", e4);
        }
        try {
            fileOutputStream.close();
        } catch (IOException e5) {
            Log.e(f26672a, "Close OutputStream error", e5);
        }
    }

    private String a(c cVar) {
        return "lib/" + cVar.a() + WVNativeCallbackUtil.SEPERATER;
    }
}
