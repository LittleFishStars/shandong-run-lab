package com.baidu.location.b;

import androidx.camera.video.AudioStats;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static j f26363a = null;
    private static String b = "Temp_in.dat";
    private static File c = new File(com.baidu.location.e.g.f26474a, b);
    private static StringBuffer d = null;
    private static boolean e = true;
    private static int f = 0;
    private static int g = 0;
    private static long h = 0;
    private static long i = 0;
    private static long j = 0;
    private static double k = AudioStats.AUDIO_AMPLITUDE_NONE;
    private static double l = AudioStats.AUDIO_AMPLITUDE_NONE;
    private static int m = 0;
    private static int n = 0;
    private static int o = 0;

    public static String a() {
        int i2;
        File file = c;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(c, "rw");
            randomAccessFile.seek(0L);
            int i3 = randomAccessFile.readInt();
            int i4 = randomAccessFile.readInt();
            int i5 = randomAccessFile.readInt();
            if (!a(i3, i4, i5)) {
                randomAccessFile.close();
                c();
                return null;
            }
            if (i4 != 0 && i4 != i5) {
                long j2 = ((long) (((i4 - 1) * 1024) + 12)) + 0;
                randomAccessFile.seek(j2);
                int i6 = randomAccessFile.readInt();
                byte[] bArr = new byte[i6];
                randomAccessFile.seek(j2 + 4);
                for (int i7 = 0; i7 < i6; i7++) {
                    bArr[i7] = randomAccessFile.readByte();
                }
                String str = new String(bArr);
                int i8 = com.baidu.location.e.h.ae;
                int i9 = 1;
                if (i3 < i8) {
                    i2 = i4 + 1;
                } else {
                    if (i4 != i8) {
                        i9 = 1 + i4;
                    }
                    i2 = i9;
                }
                randomAccessFile.seek(4L);
                randomAccessFile.writeInt(i2);
                randomAccessFile.close();
                return str;
            }
            randomAccessFile.close();
            return null;
        } catch (IOException unused) {
        }
    }

    private static boolean a(int i2, int i3, int i4) {
        int i5;
        int i6;
        return i2 >= 0 && i2 <= (i5 = com.baidu.location.e.h.ae) && i3 >= 0 && i3 <= (i6 = i2 + 1) && i4 >= 1 && i4 <= i6 && i4 <= i5;
    }

    private static void b() {
        e = true;
        d = null;
        f = 0;
        g = 0;
        h = 0L;
        i = 0L;
        j = 0L;
        k = AudioStats.AUDIO_AMPLITUDE_NONE;
        l = AudioStats.AUDIO_AMPLITUDE_NONE;
        m = 0;
        n = 0;
        o = 0;
    }

    private static boolean c() {
        if (c.exists()) {
            c.delete();
        }
        if (!c.getParentFile().exists()) {
            c.getParentFile().mkdirs();
        }
        try {
            c.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(c, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(1);
            randomAccessFile.close();
            b();
            return c.exists();
        } catch (IOException unused) {
            return false;
        }
    }
}
