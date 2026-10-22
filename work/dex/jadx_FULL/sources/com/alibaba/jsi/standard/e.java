package com.alibaba.jsi.standard;

import android.content.Context;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String f24576a = null;
    private static String b = null;
    private static String c = null;
    private static String d = null;
    private static boolean e = true;
    private static boolean f = false;
    private static String g;
    private static String h;

    public static void a(Context context) {
        if (h != null) {
            return;
        }
        h = context.getApplicationInfo().dataDir;
        f24576a = h + "/app_jsi";
        g = context.getApplicationInfo().nativeLibraryDir;
        d = f24576a + "/sopaths";
        File file = new File(f24576a);
        if (file.isFile()) {
            file.delete();
        }
        if (file.exists() || file.mkdirs()) {
            return;
        }
        Log.e("jsi", "Make JSI data dir failed: " + f24576a);
    }

    private static boolean b(File file) {
        File[] fileArrListFiles;
        File[] fileArrListFiles2;
        File[] fileArrListFiles3 = file.listFiles();
        if (fileArrListFiles3 == null) {
            return false;
        }
        for (File file2 : fileArrListFiles3) {
            if (file2.isDirectory() && (fileArrListFiles = file2.listFiles()) != null) {
                for (File file3 : fileArrListFiles) {
                    if (file3.isDirectory() && (fileArrListFiles2 = file3.listFiles()) != null) {
                        for (File file4 : fileArrListFiles2) {
                            File file5 = new File(file4, "lib");
                            if (c(file5)) {
                                return true;
                            }
                            File[] fileArrListFiles4 = file5.listFiles();
                            if (fileArrListFiles4 != null) {
                                for (File file6 : fileArrListFiles4) {
                                    if (c(file6)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean c(File file) {
        if (!file.isDirectory()) {
            return false;
        }
        File file2 = new File(file, "libjsi.so");
        if (file2.isFile()) {
            b = file2.getPath();
        }
        File file3 = new File(file, "libwebviewuc.so");
        if (file3.isFile()) {
            c = file3.getPath();
        }
        return (b == null || c == null) ? false : true;
    }

    private static String d(File file) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i <= 0) {
                        String string = sb.toString();
                        a(fileInputStream);
                        return string;
                    }
                    sb.append(new String(bArr, 0, i));
                }
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    return null;
                } finally {
                    a(fileInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static boolean a(String str, String str2) {
        if (f) {
            return true;
        }
        if (b == null && str != null) {
            File file = new File(str);
            if (file.isFile() && file.getName().equals("libjsi.so")) {
                b = str;
            }
        }
        if (c == null && str2 != null && new File(str2).isFile()) {
            c = str2;
        }
        if (b != null && c != null) {
            e = false;
        } else if (!a()) {
            if (b == null) {
                File file2 = new File(g, "libjsi.so");
                if (file2.isFile()) {
                    b = file2.getPath();
                }
            }
            if (c == null) {
                File file3 = new File(g, "libwebviewuc.so");
                if (file3.isFile()) {
                    c = file3.getPath();
                }
            }
            if (b == null || c == null) {
                File file4 = new File(h, "app_h5container");
                if (!file4.isDirectory() || !a(file4)) {
                    File file5 = new File(h, "app_ucmsdk");
                    if (file5.isDirectory()) {
                        b(file5);
                    }
                }
            }
        }
        String str3 = b;
        if (str3 != null) {
            if (c != null) {
                System.load(str3);
                long jNativeCommand = JNIBridge.nativeCommand(1L, 0L, new Object[]{c});
                if (jNativeCommand != 0) {
                    if (jNativeCommand == 1) {
                        Log.i("jsi", "UC linker is disabled, loaded JS engine so by default.");
                    } else {
                        throw new RuntimeException("Load JS engine '" + c + "' failed, code: " + jNativeCommand);
                    }
                }
                if (e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(b);
                    sb.append("`");
                    sb.append(c);
                    sb.append("`");
                    sb.append(String.valueOf(new File(b).length()));
                    File file6 = new File(d + ".tmp");
                    a(file6, sb.toString());
                    File file7 = new File(d);
                    try {
                        file7.delete();
                        file6.renameTo(file7);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                f = true;
                return true;
            }
            throw new RuntimeException("Can not locate JS engine so: libwebviewuc.so");
        }
        throw new RuntimeException("Can not locate jsi so: libjsi.so");
    }

    private static boolean a(File file) {
        File[] fileArrListFiles;
        File file2 = new File(file, "uc");
        if (!file2.isDirectory() || (fileArrListFiles = file2.listFiles()) == null) {
            return false;
        }
        for (File file3 : fileArrListFiles) {
            if (file3.isDirectory() && c(new File(file3, "so/lib"))) {
                return true;
            }
        }
        return false;
    }

    private static boolean a() {
        String strD;
        long j;
        File file = new File(d);
        if (!file.isFile() || (strD = d(file)) == null) {
            return false;
        }
        String[] strArrSplit = strD.trim().split("`");
        if (strArrSplit.length != 3) {
            return false;
        }
        try {
            j = Long.parseLong(strArrSplit[2]);
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            j = 0;
        }
        if (j == 0) {
            return false;
        }
        File file2 = new File(strArrSplit[0]);
        if (file2.isFile() && file2.getName().equals("libjsi.so") && file2.length() == j) {
            b = strArrSplit[0];
            if (new File(strArrSplit[1]).isFile()) {
                c = strArrSplit[1];
                e = false;
            }
            if (c != null) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(File file, String str) {
        FileWriter fileWriter = null;
        try {
            FileWriter fileWriter2 = new FileWriter(file);
            try {
                fileWriter2.write(str, 0, str.length());
                a(fileWriter2);
                return true;
            } catch (Throwable th) {
                th = th;
                fileWriter = fileWriter2;
                try {
                    th.printStackTrace();
                    return false;
                } finally {
                    a(fileWriter);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
