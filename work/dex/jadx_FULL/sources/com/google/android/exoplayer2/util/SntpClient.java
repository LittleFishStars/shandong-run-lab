package com.google.android.exoplayer2.util;

import android.os.SystemClock;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.Loader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.ConcurrentModificationException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class SntpClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31168a = 10000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final long f5287a = 2208988800L;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f5289a = "time.android.com";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("valueLock")
    public static boolean f5290a = false;
    public static final int b = 24;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @GuardedBy("valueLock")
    public static long f5291b = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @GuardedBy("valueLock")
    public static String f5293b = "time.android.com";
    public static final int c = 32;
    public static final int d = 40;
    public static final int e = 48;
    public static final int f = 123;
    public static final int g = 3;
    public static final int h = 4;
    public static final int i = 5;
    public static final int j = 3;
    public static final int k = 3;
    public static final int l = 0;
    public static final int m = 15;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Object f5288a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final Object f5292b = new Object();

    public interface InitializationCallback {
        void onInitializationFailed(IOException iOException);

        void onInitialized();
    }

    public static final class b implements Loader.Callback<Loader.Loadable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final InitializationCallback f31169a;

        public b(@Nullable InitializationCallback initializationCallback) {
            this.f31169a = initializationCallback;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public Loader.b A(Loader.Loadable loadable, long j, long j2, IOException iOException, int i) {
            InitializationCallback initializationCallback = this.f31169a;
            if (initializationCallback != null) {
                initializationCallback.onInitializationFailed(iOException);
            }
            return Loader.f5050c;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void K(Loader.Loadable loadable, long j, long j2) {
            if (this.f31169a != null) {
                if (SntpClient.k()) {
                    this.f31169a.onInitialized();
                } else {
                    this.f31169a.onInitializationFailed(new IOException(new ConcurrentModificationException()));
                }
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void M(Loader.Loadable loadable, long j, long j2, boolean z) {
        }
    }

    public static final class c implements Loader.Loadable {
        public c() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void cancelLoad() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void load() throws IOException {
            synchronized (SntpClient.f5288a) {
                synchronized (SntpClient.f5292b) {
                    if (SntpClient.f5290a) {
                        return;
                    }
                    long jL = SntpClient.l();
                    synchronized (SntpClient.f5292b) {
                        long unused = SntpClient.f5291b = jL;
                        boolean unused2 = SntpClient.f5290a = true;
                    }
                }
            }
        }
    }

    public static void g(byte b2, byte b3, int i2, long j2) throws IOException {
        if (b2 == 3) {
            throw new IOException("SNTP: Unsynchronized server");
        }
        if (b3 != 4 && b3 != 5) {
            throw new IOException("SNTP: Untrusted mode: " + ((int) b3));
        }
        if (i2 != 0 && i2 <= 15) {
            if (j2 == 0) {
                throw new IOException("SNTP: Zero transmitTime");
            }
        } else {
            throw new IOException("SNTP: Untrusted stratum: " + i2);
        }
    }

    public static long h() {
        long j2;
        synchronized (f5292b) {
            j2 = f5290a ? f5291b : -9223372036854775807L;
        }
        return j2;
    }

    public static String i() {
        String str;
        synchronized (f5292b) {
            str = f5293b;
        }
        return str;
    }

    public static void j(@Nullable Loader loader, @Nullable InitializationCallback initializationCallback) {
        if (k()) {
            if (initializationCallback != null) {
                initializationCallback.onInitialized();
            }
        } else {
            if (loader == null) {
                loader = new Loader("SntpClient");
            }
            loader.l(new c(), new b(initializationCallback), 1);
        }
    }

    public static boolean k() {
        boolean z;
        synchronized (f5292b) {
            z = f5290a;
        }
        return z;
    }

    public static long l() throws IOException {
        InetAddress byName = InetAddress.getByName(i());
        DatagramSocket datagramSocket = new DatagramSocket();
        try {
            datagramSocket.setSoTimeout(10000);
            byte[] bArr = new byte[48];
            DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, byName, 123);
            bArr[0] = com.google.common.base.a.E;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            p(bArr, 40, jCurrentTimeMillis);
            datagramSocket.send(datagramPacket);
            datagramSocket.receive(new DatagramPacket(bArr, 48));
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            long j2 = jCurrentTimeMillis + (jElapsedRealtime2 - jElapsedRealtime);
            byte b2 = bArr[0];
            int i2 = bArr[1] & 255;
            long jN = n(bArr, 24);
            long jN2 = n(bArr, 32);
            long jN3 = n(bArr, 40);
            g((byte) ((b2 >> 6) & 3), (byte) (b2 & 7), i2, jN3);
            long j3 = (j2 + (((jN2 - jN) + (jN3 - j2)) / 2)) - jElapsedRealtime2;
            datagramSocket.close();
            return j3;
        } catch (Throwable th) {
            try {
                datagramSocket.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static long m(byte[] bArr, int i2) {
        int i3 = bArr[i2];
        int i4 = bArr[i2 + 1];
        int i5 = bArr[i2 + 2];
        int i6 = bArr[i2 + 3];
        if ((i3 & 128) == 128) {
            i3 = (i3 & 127) + 128;
        }
        if ((i4 & 128) == 128) {
            i4 = (i4 & 127) + 128;
        }
        if ((i5 & 128) == 128) {
            i5 = (i5 & 127) + 128;
        }
        if ((i6 & 128) == 128) {
            i6 = (i6 & 127) + 128;
        }
        return (((long) i3) << 24) + (((long) i4) << 16) + (((long) i5) << 8) + ((long) i6);
    }

    public static long n(byte[] bArr, int i2) {
        long jM = m(bArr, i2);
        long jM2 = m(bArr, i2 + 4);
        if (jM == 0 && jM2 == 0) {
            return 0L;
        }
        return ((jM - f5287a) * 1000) + ((jM2 * 1000) / 4294967296L);
    }

    public static void o(String str) {
        synchronized (f5292b) {
            if (!f5293b.equals(str)) {
                f5293b = str;
                f5290a = false;
            }
        }
    }

    public static void p(byte[] bArr, int i2, long j2) {
        if (j2 == 0) {
            Arrays.fill(bArr, i2, i2 + 8, (byte) 0);
            return;
        }
        long j3 = j2 / 1000;
        long j4 = j2 - (j3 * 1000);
        long j5 = j3 + f5287a;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (j5 >> 24);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (j5 >> 16);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (j5 >> 8);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (j5 >> 0);
        long j6 = (j4 * 4294967296L) / 1000;
        int i7 = i6 + 1;
        bArr[i6] = (byte) (j6 >> 24);
        int i8 = i7 + 1;
        bArr[i7] = (byte) (j6 >> 16);
        bArr[i8] = (byte) (j6 >> 8);
        bArr[i8 + 1] = (byte) (Math.random() * 255.0d);
    }
}
