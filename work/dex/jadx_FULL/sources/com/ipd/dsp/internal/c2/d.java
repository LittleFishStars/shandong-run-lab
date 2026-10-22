package com.ipd.dsp.internal.c2;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38217a = "File";

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f38218a = "IPD_DSP_BETA";

        public static String a() {
            return d.b(f38218a);
        }

        public static void a(String str) {
            if (d.a(f38218a, str) || !com.ipd.dsp.internal.l1.a.a().isDebug()) {
                return;
            }
            k.d(f38218a, "write file failed");
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f38219a = "IPD_DSP_ALPHA";

        public static String a() {
            return d.b(f38219a);
        }

        public static boolean b() {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
                return true ^ simpleDateFormat.format(new Date(System.currentTimeMillis())).equals(simpleDateFormat.format(Long.valueOf(Long.parseLong(a()))));
            } catch (Throwable unused) {
                return true;
            }
        }

        public static void a(String str) {
            if (d.a(f38219a, str) || !com.ipd.dsp.internal.l1.a.a().isDebug()) {
                return;
            }
            k.d(f38219a, "write file failed");
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f38220a = "IPD_DSP_GAMMA";

        public static String a() {
            return d.b(f38220a);
        }

        public static void a(String str) {
            if (d.a(f38220a, str) || !com.ipd.dsp.internal.l1.a.a().isDebug()) {
                return;
            }
            k.d(f38220a, "write file failed");
        }
    }

    public static boolean a(String str, String str2) {
        File fileA = a(str);
        if (fileA == null) {
            return false;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(fileA, "rw");
            try {
                randomAccessFile.setLength(0L);
                randomAccessFile.writeUTF(h.a(str2, str));
                randomAccessFile.close();
                return true;
            } catch (Throwable th) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException unused) {
            if (com.ipd.dsp.internal.l1.a.a().isDebug()) {
                k.f(f38217a, "RandomAccessFile error");
            }
            return false;
        }
    }

    public static String b(String str) {
        File fileA = a(str);
        if (fileA == null) {
            return null;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(fileA, "r");
            try {
                String strA = e.a(randomAccessFile.readUTF(), str);
                randomAccessFile.close();
                return strA;
            } catch (Throwable th) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException unused) {
            if (com.ipd.dsp.internal.l1.a.a().isDebug()) {
                k.f(f38217a, "RandomAccessFile error");
            }
            return null;
        }
    }

    public static File a(String str) {
        Context context = com.ipd.dsp.internal.l1.a.a().getContext();
        if (context == null) {
            return null;
        }
        File file = new File(context.getCacheDir(), str);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (Throwable unused) {
            return null;
        }
    }
}
