package com.igexin.push.g;

import android.content.Context;
import android.os.Build;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.util.Base64;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.util.CommonUtil;
import com.getui.gtc.base.util.io.IOUtils;
import com.igexin.push.core.ServiceManager;
import com.igexin.sdk.main.SdkInitSwitch;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f38150a = null;
    public static String b = null;
    public static String c = null;
    public static String d = null;
    public static String e = null;
    public static String f = null;
    public static String g = null;
    private static final String h = "FileUtils";
    private static final Object i = new Object();
    private static String j;

    public static String a(String str) {
        Exception e2;
        String str2;
        try {
            str2 = f + com.igexin.assist.util.a.a(str) + ".bin";
            try {
                File file = new File(str2);
                if (!file.exists() || !file.canRead()) {
                    if (com.igexin.push.core.e.l.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", com.igexin.push.core.e.l.getPackageName()) == 0) {
                        return "";
                    }
                    f = com.igexin.push.core.e.l.getCacheDir() + "/ImgCache/";
                    return "";
                    com.igexin.c.a.c.a.a(e2);
                }
            } catch (Exception e3) {
                e2 = e3;
                com.igexin.c.a.c.a.a(e2);
            }
        } catch (Exception e4) {
            e2 = e4;
            str2 = "";
        }
        return str2;
    }

    public static void a() {
        try {
            String packageName = com.igexin.push.core.e.l.getPackageName();
            b = "/sdcard/libs/" + packageName + ".db";
            c = "/sdcard/libs/com.igexin.sdk.deviceId.db";
            f38150a = "/sdcard/libs/" + packageName + ".properties";
            d = "/sdcard/libs/" + packageName + ".bin";
            e = com.igexin.push.core.e.l.getFilesDir().getPath() + WVNativeCallbackUtil.SEPERATER + packageName + ".properties";
            g = com.igexin.push.core.e.l.getFilesDir().getPath() + WVNativeCallbackUtil.SEPERATER + packageName + "-guard.properties";
            StringBuilder sb = new StringBuilder();
            sb.append(com.igexin.push.core.e.l.getCacheDir());
            sb.append("/ImgCache/");
            f = sb.toString();
            j = "/sdcard/libs/com.getui.sdk.deviceId.db";
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private static void a(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                while (file2.exists()) {
                    if (file2.isFile()) {
                        file2.delete();
                    } else if (!file2.delete()) {
                        a(file2);
                    }
                }
            }
        }
        file.delete();
    }

    public static void a(byte[] bArr, String str) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (str.startsWith("/sdcard/libs") && !k()) {
                    return;
                }
                File file = new File(str);
                if (!b(file)) {
                    return;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, false);
                try {
                    fileOutputStream2.write(bArr);
                    try {
                        fileOutputStream2.close();
                        return;
                    } catch (Exception e2) {
                        com.igexin.c.a.c.a.a(e2);
                        return;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e4) {
                            com.igexin.c.a.c.a.a(e4);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
        }
        com.igexin.c.a.c.a.a(e);
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e6) {
                com.igexin.c.a.c.a.a(e6);
            }
        }
    }

    public static boolean a(Context context) {
        return (new File(context.getFilesDir().getAbsolutePath(), com.igexin.push.core.d.d.f37992a).exists() || new SdkInitSwitch(context).isSwitchOn()) ? false : true;
    }

    public static String b(Context context) {
        return context.getExternalFilesDir("gtpush") + "/log/";
    }

    public static void b() throws Throwable {
        if (!k()) {
            com.igexin.c.a.c.a.a("FileUtils | save session to file no permission , v-" + Build.VERSION.SDK_INT, new Object[0]);
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(b);
                if (!file.exists() && !file.createNewFile()) {
                    com.igexin.c.a.c.a.a("FileUtils | create file : " + file.toString() + " failed !!!", new Object[0]);
                    return;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(b);
                try {
                    String str = com.igexin.push.config.c.w + n.c();
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(com.igexin.push.core.e.z);
                    sb.append("|");
                    sb.append(com.igexin.push.core.e.f38001a);
                    sb.append("|");
                    sb.append(com.igexin.push.core.e.A);
                    sb.append("|");
                    ServiceManager.getInstance();
                    sb.append(ServiceManager.d(com.igexin.push.core.e.l));
                    fileOutputStream2.write(com.igexin.c.a.a.a.b(sb.toString().getBytes(), com.igexin.push.core.e.M));
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e2) {
                        com.igexin.c.a.c.a.a(e2);
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    com.igexin.c.a.c.a.a(e);
                    com.igexin.c.a.c.a.a("FileUtils | " + e.toString(), new Object[0]);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            com.igexin.c.a.c.a.a(e4);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            com.igexin.c.a.c.a.a(e5);
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean b(File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            return file.canWrite();
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    private static byte[] b(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        byte[] byteArray = null;
        if (!new File(str).exists()) {
            com.igexin.c.a.c.a.a(h, "get data from file = " + str + " file not exist ######");
            com.igexin.c.a.c.a.a("FileUtils|get data from file = " + str + " file not exist ######", new Object[0]);
            return null;
        }
        if (!c(new File(str))) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    try {
                        try {
                            int i2 = fileInputStream.read(bArr);
                            if (i2 == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i2);
                        } catch (Exception e2) {
                            e = e2;
                            com.igexin.c.a.c.a.a(e);
                            com.igexin.c.a.c.a.a("FileUtils|" + e.toString(), new Object[0]);
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream;
                        IOUtils.safeClose(fileInputStream2);
                        IOUtils.safeClose(byteArrayOutputStream);
                        throw th;
                    }
                }
                byteArray = byteArrayOutputStream.toByteArray();
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
                fileInputStream2 = fileInputStream;
                IOUtils.safeClose(fileInputStream2);
                IOUtils.safeClose(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            byteArrayOutputStream = null;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            IOUtils.safeClose(fileInputStream2);
            IOUtils.safeClose(byteArrayOutputStream);
            throw th;
        }
        IOUtils.safeClose(fileInputStream);
        IOUtils.safeClose(byteArrayOutputStream);
        return byteArray;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0050  */
    public static String c() throws Throwable {
        String str = null;
        if (!p()) {
            com.igexin.c.a.c.a.a("FileUtils | read file cid no permission , v-" + Build.VERSION.SDK_INT, new Object[0]);
            return null;
        }
        try {
            byte[] bArrB = b(b);
            if (bArrB == null) {
                com.igexin.c.a.c.a.a("FileUtils | read file cid id = null", new Object[0]);
                return null;
            }
            String[] strArrSplit = new String(com.igexin.c.a.a.a.a(bArrB, com.igexin.push.core.e.M)).split("\\|");
            if (strArrSplit.length > 2) {
                String str2 = strArrSplit[2];
                if (str2 != null) {
                    try {
                        if (!str2.equals("null")) {
                            str = str2;
                        }
                    } catch (Exception e2) {
                        str = str2;
                        e = e2;
                        com.igexin.c.a.c.a.a(e);
                    }
                } else {
                    str = str2;
                }
            }
            com.igexin.c.a.c.a.a("FileUtils|get cid from file cid = ".concat(String.valueOf(str)), new Object[0]);
            return str;
        } catch (Exception e3) {
            e = e3;
        }
    }

    private static void c(String str) throws Throwable {
        if (!k()) {
            com.igexin.c.a.c.a.a("FileUtils | saveDeviceIdToNewFile no permission , v-" + Build.VERSION.SDK_INT, new Object[0]);
            return;
        }
        com.igexin.c.a.c.a.a("FileUtils|save deviceId = " + str + " to " + j, new Object[0]);
        ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (writeLock.tryLock()) {
                    File file = new File(j);
                    if (!file.exists() && !file.createNewFile()) {
                        com.igexin.c.a.c.a.a("FileUtils|create file " + file.toString() + " failed", new Object[0]);
                        com.igexin.c.a.b.g.a((Closeable) null);
                        writeLock.unlock();
                        return;
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(j);
                    try {
                        fileOutputStream2.write(com.igexin.c.b.a.b("V1|".concat(String.valueOf(str)).getBytes("utf-8")));
                        fileOutputStream = fileOutputStream2;
                    } catch (Exception e2) {
                        e = e2;
                        fileOutputStream = fileOutputStream2;
                        com.igexin.c.a.c.a.a(e);
                        com.igexin.c.a.c.a.a("FileUtils|" + e.toString(), new Object[0]);
                        com.igexin.c.a.b.g.a(fileOutputStream);
                        writeLock.unlock();
                        return;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.igexin.c.a.b.g.a(fileOutputStream);
                        writeLock.unlock();
                        throw th;
                    }
                }
                com.igexin.c.a.b.g.a(fileOutputStream);
                writeLock.unlock();
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean c(File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            return file.canRead();
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    public static String d() throws Throwable {
        String str = null;
        if (!k()) {
            com.igexin.c.a.c.a.a("FileUtils | get device id from file no permission , v-" + Build.VERSION.SDK_INT, new Object[0]);
            return null;
        }
        try {
            com.igexin.c.a.c.a.a("FileUtils|get device id from file : " + c, new Object[0]);
            byte[] bArrB = b(c);
            if (bArrB == null) {
                com.igexin.c.a.c.a.a(h, "read file device id = null");
                com.igexin.c.a.c.a.a("FileUtils|read file device id = null", new Object[0]);
                return null;
            }
            String str2 = new String(bArrB, "utf-8");
            try {
                com.igexin.c.a.c.a.a("FileUtils|read file device id = ".concat(str2), new Object[0]);
                return str2;
            } catch (Exception e2) {
                e = e2;
                str = str2;
                com.igexin.c.a.c.a.a(e);
                com.igexin.c.a.c.a.a("FileUtils|get device id from file : " + e.toString(), new Object[0]);
                return str;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    private static void d(String str) {
        try {
            com.igexin.push.core.e.f.a().a(str);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public static long e() throws Throwable {
        long j2 = 0;
        if (!p()) {
            com.igexin.c.a.c.a.a("FileUtils | get session from file no permission , v-" + Build.VERSION.SDK_INT, new Object[0]);
            return 0L;
        }
        try {
            byte[] bArrB = b(b);
            if (bArrB == null) {
                com.igexin.c.a.c.a.a(h, "read session from file, not exist");
                com.igexin.c.a.c.a.a("FileUtils|read session from file, not exist", new Object[0]);
                return 0L;
            }
            String str = new String(com.igexin.c.a.a.a.a(bArrB, com.igexin.push.core.e.M));
            String strSubstring = str.contains("null") ? str.substring(7) : str.substring(20);
            int iIndexOf = strSubstring.indexOf("|");
            if (iIndexOf >= 0) {
                strSubstring = strSubstring.substring(0, iIndexOf);
            }
            long j3 = Long.parseLong(strSubstring);
            if (j3 != 0) {
                j2 = j3;
            }
            com.igexin.c.a.c.a.a("FileUtils|session : ".concat(String.valueOf(j2)), new Object[0]);
            return j2;
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(h, e2.toString());
            com.igexin.c.a.c.a.a("FileUtils|" + e2.toString(), new Object[0]);
        }
    }

    public static void f() throws Throwable {
        if (com.igexin.push.core.e.H == null) {
            return;
        }
        if (!k()) {
            com.igexin.c.a.c.a.a("FileUtils | save device id to file no permission , v-" + Build.VERSION.SDK_INT, new Object[0]);
            return;
        }
        com.igexin.c.a.c.a.a("FileUtils|save device id to file : " + c, new Object[0]);
        ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (writeLock.tryLock()) {
                    File file = new File(c);
                    if (!file.exists() && !file.createNewFile()) {
                        com.igexin.c.a.c.a.a("FileUtils|create file : " + file.toString() + " failed !!!", new Object[0]);
                        writeLock.unlock();
                        return;
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(c);
                    try {
                        byte[] bytes = com.igexin.push.core.e.H.getBytes("utf-8");
                        new String(bytes, "utf-8");
                        fileOutputStream2.write(bytes);
                        fileOutputStream = fileOutputStream2;
                    } catch (Exception e2) {
                        e = e2;
                        fileOutputStream = fileOutputStream2;
                        com.igexin.c.a.c.a.a(e);
                        com.igexin.c.a.c.a.a("FileUtils|" + e.toString(), new Object[0]);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e3) {
                                com.igexin.c.a.c.a.a(e3);
                            }
                        }
                        writeLock.unlock();
                        return;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                com.igexin.c.a.c.a.a(e4);
                            }
                        }
                        writeLock.unlock();
                        throw th;
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e5) {
                        com.igexin.c.a.c.a.a(e5);
                    }
                }
                writeLock.unlock();
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void g() {
        byte[] bytes = com.igexin.push.core.e.A.getBytes();
        byte[] bArr = new byte[bytes.length];
        for (int i2 = 0; i2 < bytes.length; i2++) {
            bArr[i2] = (byte) (bytes[i2] ^ com.igexin.push.core.e.ad[i2]);
        }
        com.igexin.push.core.d.d.a().a("c", Base64.encodeToString(bArr, 0));
    }

    public static void h() {
        File[] fileArrListFiles;
        File file = new File(f);
        if (file.exists() && (fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.igexin.push.g.j.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final long f38151a = System.currentTimeMillis();
            final long b = 604800000;

            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                return this.f38151a - file2.lastModified() >= 604800000;
            }
        })) != null) {
            for (File file2 : fileArrListFiles) {
                file2.delete();
            }
        }
    }

    public static void i() {
        File[] fileArrListFiles;
        if (k()) {
            File file = new File(GtcProvider.getSdcardPath() + "/Sdk/WebCache/");
            if (file.exists() && (fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.igexin.push.g.j.2

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final long f38152a = System.currentTimeMillis();
                final long b = 604800000;

                @Override // java.io.FileFilter
                public final boolean accept(File file2) {
                    return this.f38152a - file2.lastModified() >= 604800000;
                }
            })) != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2.exists()) {
                        a(file2);
                    }
                }
            }
        }
    }

    public static void j() throws Throwable {
        if (!k()) {
            com.igexin.c.a.c.a.a("FileUtilsupdateDeviceId no permission , v-" + Build.VERSION.SDK_INT, new Object[0]);
            return;
        }
        String strN = n();
        String str = com.igexin.push.core.e.H;
        com.igexin.c.a.c.a.a("FileUtils|read deviceId.db = " + strN + "; CoreRuntimeInfo.deviceId = " + com.igexin.push.core.e.H, new Object[0]);
        if (strN != null) {
            if (strN.equals(com.igexin.push.core.e.H)) {
                return;
            }
            com.igexin.push.core.e.H = strN;
            try {
                com.igexin.push.core.e.f.a().a(strN);
                return;
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
                return;
            }
        }
        String str2 = com.igexin.push.core.e.H;
        if (str2 == null) {
            return;
        }
        if (!k()) {
            com.igexin.c.a.c.a.a("FileUtils | saveDeviceIdToNewFile no permission , v-" + Build.VERSION.SDK_INT, new Object[0]);
            return;
        }
        com.igexin.c.a.c.a.a("FileUtils|save deviceId = " + str2 + " to " + j, new Object[0]);
        ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (writeLock.tryLock()) {
                    File file = new File(j);
                    if (!file.exists() && !file.createNewFile()) {
                        com.igexin.c.a.c.a.a("FileUtils|create file " + file.toString() + " failed", new Object[0]);
                        com.igexin.c.a.b.g.a((Closeable) null);
                        writeLock.unlock();
                        return;
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(j);
                    try {
                        fileOutputStream2.write(com.igexin.c.b.a.b("V1|".concat(String.valueOf(str2)).getBytes("utf-8")));
                        fileOutputStream = fileOutputStream2;
                    } catch (Exception e2) {
                        e = e2;
                        fileOutputStream = fileOutputStream2;
                        com.igexin.c.a.c.a.a(e);
                        com.igexin.c.a.c.a.a("FileUtils|" + e.toString(), new Object[0]);
                        com.igexin.c.a.b.g.a(fileOutputStream);
                        writeLock.unlock();
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        com.igexin.c.a.b.g.a(fileOutputStream);
                        writeLock.unlock();
                        throw th;
                    }
                }
                com.igexin.c.a.b.g.a(fileOutputStream);
                writeLock.unlock();
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static boolean k() {
        boolean z;
        boolean z2;
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                return false;
            }
            String[] strArrSplit = com.igexin.push.config.d.aj.split("\\|");
            boolean z3 = true;
            if (strArrSplit.length == 2) {
                String binaryString = Integer.toBinaryString(Integer.parseInt(strArrSplit[0]));
                z2 = binaryString.length() >= 2 && binaryString.charAt(binaryString.length() - 2) == '1';
                z = "2".equals(strArrSplit[1]) || ("1".equals(strArrSplit[1]) && CommonUtil.isAppForeground());
            } else {
                z = false;
                z2 = false;
            }
            boolean zHasPermission = CommonUtil.hasPermission(com.igexin.push.core.e.l, "android.permission.WRITE_EXTERNAL_STORAGE", false);
            if (!z2 || !z || !zHasPermission) {
                z3 = false;
            }
            if (z3) {
                File file = new File("/sdcard/libs");
                if (file.exists() && file.isFile()) {
                    com.igexin.c.a.c.a.a(h, "libs is file not directory, delete libs file +++++");
                    com.igexin.c.a.c.a.a("FileUtils|libs is file not directory, delete libs file ++++", new Object[0]);
                    file.delete();
                }
                if (!file.exists() && !file.mkdir()) {
                    com.igexin.c.a.c.a.a(h, "create libs directory failed ++++++++");
                    com.igexin.c.a.c.a.a("FileUtils|create libs directory failed ++++++", new Object[0]);
                }
            }
            return z3;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    public static boolean l() {
        return true;
    }

    private static List<JSONObject> m() {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        byte[] byteArray;
        if (!p()) {
            com.igexin.c.a.c.a.a("FileUtils | get appid cid list no permission , v-" + Build.VERSION.SDK_INT, new Object[0]);
            return null;
        }
        String str = GtcProvider.getSdcardPath() + "/libs";
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File(str);
            if (!file.exists() || !c(file)) {
                return null;
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2 != null && file2.isFile() && file2.getName().indexOf(".db") > 0 && !file2.getName().equals("com.gt.sdk.deviceId.db") && !file2.getName().equals("com.getui.sdk.deviceId.db") && !file2.getName().equals("app.db") && !file2.getName().equals("imsi.db")) {
                        file2.getName();
                        String strSubstring = file2.getName().substring(0, file2.getName().length() - 3);
                        if (c.d(strSubstring) && !com.igexin.push.core.e.l.getPackageName().equals(strSubstring)) {
                            byte[] bArr = new byte[1024];
                            try {
                                fileInputStream = new FileInputStream(file2);
                                try {
                                    byteArrayOutputStream = new ByteArrayOutputStream();
                                    while (true) {
                                        try {
                                            try {
                                                int i2 = fileInputStream.read(bArr);
                                                if (i2 == -1) {
                                                    break;
                                                }
                                                byteArrayOutputStream.write(bArr, 0, i2);
                                            } catch (Exception e2) {
                                                e = e2;
                                                com.igexin.c.a.c.a.a(e);
                                                com.igexin.c.a.c.a.a("FileUtils| read " + strSubstring + "excetpion:" + e.toString(), new Object[0]);
                                                if (fileInputStream != null) {
                                                    fileInputStream.close();
                                                }
                                                if (byteArrayOutputStream != null) {
                                                    byteArrayOutputStream.close();
                                                }
                                                byteArray = null;
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            if (fileInputStream != null) {
                                                fileInputStream.close();
                                            }
                                            if (byteArrayOutputStream != null) {
                                                byteArrayOutputStream.close();
                                            }
                                            throw th;
                                        }
                                    }
                                    byteArray = byteArrayOutputStream.toByteArray();
                                    fileInputStream.close();
                                    byteArrayOutputStream.close();
                                } catch (Exception e3) {
                                    e = e3;
                                    byteArrayOutputStream = null;
                                } catch (Throwable th2) {
                                    th = th2;
                                    byteArrayOutputStream = null;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                byteArrayOutputStream = null;
                                fileInputStream = null;
                            } catch (Throwable th3) {
                                th = th3;
                                byteArrayOutputStream = null;
                                fileInputStream = null;
                            }
                            if (byteArray == null) {
                                com.igexin.c.a.c.a.a("FileUtils|read " + strSubstring + "bytes == null", new Object[0]);
                            } else {
                                String[] strArrSplit = new String(com.igexin.c.a.a.a.a(byteArray, com.igexin.push.core.e.M)).split("\\|");
                                if (strArrSplit.length > 2) {
                                    try {
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("cid", strArrSplit[2]);
                                        jSONObject.put("appid", strArrSplit[1]);
                                        arrayList.add(jSONObject);
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return arrayList;
        } catch (Throwable th4) {
            com.igexin.c.a.c.a.a(th4);
            return null;
        }
    }

    private static String n() throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        String str = null;
        str = null;
        str = null;
        str = null;
        FileInputStream fileInputStream2 = null;
        if (!p()) {
            com.igexin.c.a.c.a.a("FileUtils | getDeviceIdFromNewFile no permission , v-" + Build.VERSION.SDK_INT, new Object[0]);
            return null;
        }
        File file = new File(j);
        if (!c(file)) {
            return null;
        }
        if (file.exists()) {
            byte[] bArr = new byte[1024];
            try {
                fileInputStream = new FileInputStream(j);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            try {
                                int i2 = fileInputStream.read(bArr);
                                if (i2 == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, i2);
                            } catch (Exception e2) {
                                e = e2;
                                com.igexin.c.a.c.a.a(e);
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream2 = fileInputStream;
                            com.igexin.c.a.b.g.a(fileInputStream2);
                            com.igexin.c.a.b.g.a(byteArrayOutputStream);
                            throw th;
                        }
                    }
                    String[] strArrSplit = new String(com.igexin.c.b.a.c(byteArrayOutputStream.toByteArray()), "utf-8").split("\\|");
                    if (strArrSplit.length > 1 && com.igexin.push.core.g.e.equals(strArrSplit[0])) {
                        str = strArrSplit[1];
                    }
                } catch (Exception e3) {
                    e = e3;
                    byteArrayOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = null;
                    fileInputStream2 = fileInputStream;
                    com.igexin.c.a.b.g.a(fileInputStream2);
                    com.igexin.c.a.b.g.a(byteArrayOutputStream);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                fileInputStream = null;
                byteArrayOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
                com.igexin.c.a.b.g.a(fileInputStream2);
                com.igexin.c.a.b.g.a(byteArrayOutputStream);
                throw th;
            }
            com.igexin.c.a.b.g.a(fileInputStream);
            com.igexin.c.a.b.g.a(byteArrayOutputStream);
        }
        return str;
    }

    private static void o() {
        File file = new File("/sdcard/libs");
        if (file.exists() && file.isFile()) {
            com.igexin.c.a.c.a.a(h, "libs is file not directory, delete libs file +++++");
            com.igexin.c.a.c.a.a("FileUtils|libs is file not directory, delete libs file ++++", new Object[0]);
            file.delete();
        }
        if (file.exists() || file.mkdir()) {
            return;
        }
        com.igexin.c.a.c.a.a(h, "create libs directory failed ++++++++");
        com.igexin.c.a.c.a.a("FileUtils|create libs directory failed ++++++", new Object[0]);
    }

    private static boolean p() {
        boolean z;
        boolean z2;
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                return false;
            }
            String[] strArrSplit = com.igexin.push.config.d.aj.split("|");
            if (strArrSplit.length == 2) {
                String binaryString = Integer.toBinaryString(Integer.parseInt(strArrSplit[0]));
                z2 = binaryString.length() >= 2 && binaryString.charAt(binaryString.length() - 2) == '1';
                z = "2".equals(strArrSplit[1]) || ("1".equals(strArrSplit[1]) && CommonUtil.isAppForeground());
            } else {
                z = false;
                z2 = false;
            }
            return z2 && z && CommonUtil.hasPermission(com.igexin.push.core.e.l, "android.permission.READ_EXTERNAL_STORAGE", false);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }
}
