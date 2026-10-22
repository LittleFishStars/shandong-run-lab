package com.aliyun.svideosdk.conan;

import android.content.Context;
import android.os.CpuUsageInfo;
import android.os.HardwarePropertiesManager;
import android.os.Process;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Serializable;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d implements Serializable {
    static final int[] y = {32, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 32, 32, 32, 32, 32, 32, 32, 8224, 32, 8224, 32, 8224, 8224, 32, 32, 32, 32, 8224, 32, 8224, 32};
    static final int[] z = {288, 8224, 8224, 8224, 8224, 8224, 8224, 8224};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f25693a;
    private Method b;
    private long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private long o;
    private long p;
    private long q;
    private long r;
    private int s;
    private int t;
    private int u;
    private int v;
    private final long[] w = new long[7];
    private final long[] x = new long[6];

    public d() {
        try {
            this.f25693a = "/proc/" + Process.myPid() + "/stat";
            Method method = Process.class.getMethod("readProcFile", String.class, int[].class, String[].class, long[].class, float[].class);
            this.b = method;
            method.setAccessible(true);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0071 A[Catch: Exception -> 0x0142, TryCatch #3 {Exception -> 0x0142, blocks: (B:7:0x000e, B:10:0x0032, B:12:0x0052, B:14:0x0062, B:16:0x0068, B:18:0x0075, B:17:0x0071), top: B:65:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:41:0x0114  */
    public void a(Context context) {
        int i;
        Method method = this.b;
        if (method == null || this.f25693a == null) {
            i = 0;
        } else {
            try {
                if (!((Boolean) method.invoke(null, "/proc/stat", z, null, this.w, null)).booleanValue()) {
                    return;
                }
                if (((Boolean) this.b.invoke(null, this.f25693a, y, null, this.x, null)).booleanValue()) {
                    long[] jArr = this.x;
                    long j = jArr[2];
                    this.q = j;
                    long j2 = jArr[3];
                    this.r = j2;
                    long j3 = this.o;
                    if (j >= j3) {
                        long j4 = this.p;
                        if (j2 >= j4) {
                            this.s = (int) (j - j3);
                            this.t = (int) (j2 - j4);
                        } else {
                            this.s = 0;
                            this.t = 0;
                        }
                    } else {
                        this.s = 0;
                        this.t = 0;
                    }
                    long[] jArr2 = this.w;
                    long j5 = jArr2[0] + jArr2[1];
                    long j6 = jArr2[2];
                    long j7 = jArr2[3];
                    long j8 = jArr2[4];
                    long j9 = jArr2[5];
                    try {
                        long j10 = jArr2[6];
                        long j11 = this.c;
                        if (j5 >= j11) {
                            long j12 = this.d;
                            if (j6 >= j12) {
                                long j13 = this.e;
                                if (j8 >= j13) {
                                    long j14 = this.f;
                                    if (j9 >= j14) {
                                        long j15 = this.g;
                                        if (j10 >= j15) {
                                            long j16 = this.h;
                                            if (j7 >= j16) {
                                                int i2 = (int) (j5 - j11);
                                                this.i = i2;
                                                int i3 = (int) (j6 - j12);
                                                this.j = i3;
                                                int i4 = (int) (j8 - j13);
                                                this.k = i4;
                                                int i5 = (int) (j9 - j14);
                                                this.l = i5;
                                                int i6 = (int) (j10 - j15);
                                                this.m = i6;
                                                int i7 = (int) (j7 - j16);
                                                this.n = i7;
                                                long j17 = i2 + i3 + i4 + i5 + i6 + i7;
                                                if (j17 > 1) {
                                                    int iAbs = Math.abs((int) (((long) ((this.s + this.t) * 100)) / j17));
                                                    int iAbs2 = Math.abs((int) (((long) ((this.i + this.j) * 100)) / j17));
                                                    this.u = iAbs2;
                                                    this.v = iAbs;
                                                    if (iAbs2 > 100) {
                                                        this.u = 100;
                                                    }
                                                    int i8 = this.u;
                                                    if (iAbs > i8) {
                                                        this.v = i8;
                                                    }
                                                }
                                                i = 0;
                                            } else {
                                                i = 0;
                                                try {
                                                    this.i = 0;
                                                    this.j = 0;
                                                    this.k = 0;
                                                    this.l = 0;
                                                    this.m = 0;
                                                    this.n = 0;
                                                } catch (Exception unused) {
                                                }
                                            }
                                            this.o = this.q;
                                            this.p = this.r;
                                            this.c = j5;
                                            this.d = j6;
                                            this.e = j8;
                                            this.f = j9;
                                            this.g = j10;
                                            this.h = j7;
                                        } else {
                                            i = 0;
                                            this.i = 0;
                                            this.j = 0;
                                            this.k = 0;
                                            this.l = 0;
                                            this.m = 0;
                                            this.n = 0;
                                            this.o = this.q;
                                            this.p = this.r;
                                            this.c = j5;
                                            this.d = j6;
                                            this.e = j8;
                                            this.f = j9;
                                            this.g = j10;
                                            this.h = j7;
                                        }
                                    } else {
                                        i = 0;
                                        this.i = 0;
                                        this.j = 0;
                                        this.k = 0;
                                        this.l = 0;
                                        this.m = 0;
                                        this.n = 0;
                                        this.o = this.q;
                                        this.p = this.r;
                                        this.c = j5;
                                        this.d = j6;
                                        this.e = j8;
                                        this.f = j9;
                                        this.g = j10;
                                        this.h = j7;
                                    }
                                } else {
                                    i = 0;
                                    this.i = 0;
                                    this.j = 0;
                                    this.k = 0;
                                    this.l = 0;
                                    this.m = 0;
                                    this.n = 0;
                                    this.o = this.q;
                                    this.p = this.r;
                                    this.c = j5;
                                    this.d = j6;
                                    this.e = j8;
                                    this.f = j9;
                                    this.g = j10;
                                    this.h = j7;
                                }
                            } else {
                                i = 0;
                                this.i = 0;
                                this.j = 0;
                                this.k = 0;
                                this.l = 0;
                                this.m = 0;
                                this.n = 0;
                                this.o = this.q;
                                this.p = this.r;
                                this.c = j5;
                                this.d = j6;
                                this.e = j8;
                                this.f = j9;
                                this.g = j10;
                                this.h = j7;
                            }
                        } else {
                            i = 0;
                            this.i = 0;
                            this.j = 0;
                            this.k = 0;
                            this.l = 0;
                            this.m = 0;
                            this.n = 0;
                            this.o = this.q;
                            this.p = this.r;
                            this.c = j5;
                            this.d = j6;
                            this.e = j8;
                            this.f = j9;
                            this.g = j10;
                            this.h = j7;
                        }
                    } catch (Exception unused2) {
                        i = 0;
                    }
                }
            } catch (Exception unused3) {
            }
            i = 0;
        }
        if (context != null) {
            try {
                HardwarePropertiesManager hardwarePropertiesManager = (HardwarePropertiesManager) context.getSystemService("hardware_properties");
                if (hardwarePropertiesManager != null) {
                    CpuUsageInfo[] cpuUsages = hardwarePropertiesManager.getCpuUsages();
                    int length = cpuUsages.length;
                    int active = i;
                    while (i < length) {
                        active = (int) (((long) active) + cpuUsages[i].getActive());
                        i++;
                    }
                    this.v = active;
                }
            } catch (Exception unused4) {
            }
        }
    }
}
