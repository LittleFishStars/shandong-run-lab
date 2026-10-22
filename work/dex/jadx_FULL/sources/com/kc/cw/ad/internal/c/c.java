package com.kc.cw.ad.internal.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.c49;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c {

    @Keep
    public interface a {
        void a();

        void a(b bVar);

        void a(d dVar);
    }

    @Keep
    public interface b {
        void a(int i);

        void a(long j, long j2);

        boolean a(File file);

        void b(File file);
    }

    /* JADX INFO: renamed from: com.kc.cw.ad.internal.c.c$c, reason: collision with other inner class name */
    @Keep
    public static final class RunnableC1006c implements a, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private HandlerThread f38937a;
        private b b;
        private Handler c;
        private Handler d = new Handler(Looper.getMainLooper());
        private d e;

        public RunnableC1006c() {
            HandlerThread handlerThread = new HandlerThread("download");
            this.f38937a = handlerThread;
            handlerThread.start();
            this.c = new Handler(this.f38937a.getLooper());
        }

        private void a(int i) {
            this.d.post(new Runnable(this, i) { // from class: com.kc.cw.ad.internal.c.c.c.3

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final int f38940a;
                final RunnableC1006c b;

                {
                    this.b = this;
                    this.f38940a = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this.b.b != null) {
                        this.b.b.a(this.f38940a);
                    }
                }
            });
        }

        private void a(long j, long j2) {
            this.d.post(new Runnable(this, j, j2) { // from class: com.kc.cw.ad.internal.c.c.c.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final long f38938a;
                final long b;
                final RunnableC1006c c;

                {
                    this.c = this;
                    this.f38938a = j;
                    this.b = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this.c.b != null) {
                        this.c.b.a(this.f38938a, this.b);
                    }
                }
            });
        }

        private boolean a(File file) {
            b bVar = this.b;
            return bVar != null && bVar.a(file);
        }

        private void b(File file) {
            this.d.post(new Runnable(this, file) { // from class: com.kc.cw.ad.internal.c.c.c.2

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final File f38939a;
                final RunnableC1006c b;

                {
                    this.b = this;
                    this.f38939a = file;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this.b.b != null) {
                        this.b.b.b(this.f38939a);
                    }
                }
            });
        }

        @Override // com.kc.cw.ad.internal.c.c.a
        public void a() {
            HandlerThread handlerThread = this.f38937a;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            this.c = null;
            this.f38937a = null;
            this.b = null;
        }

        @Override // com.kc.cw.ad.internal.c.c.a
        public void a(b bVar) {
            this.b = bVar;
        }

        @Override // com.kc.cw.ad.internal.c.c.a
        public void a(d dVar) {
            if (dVar.f38941a) {
                throw new IllegalArgumentException("Invalid request,it's downloading");
            }
            d dVar2 = this.e;
            if (dVar2 != null && !dVar.equals(dVar2)) {
                this.e.b = true;
            }
            this.e = dVar;
            dVar.a();
            Handler handler = this.c;
            if (handler != null) {
                handler.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            HttpURLConnection httpURLConnection;
            InputStream inputStream;
            d dVar = this.e;
            dVar.f38941a = true;
            File file = new File(dVar.e);
            if (!file.exists() && !file.mkdirs()) {
                a(3);
                return;
            }
            String str = dVar.e + File.separator + dVar.f;
            File file2 = new File(str);
            RandomAccessFile randomAccessFile = null;
            try {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(dVar.d).openConnection();
                    try {
                        if (dVar.h != 0) {
                            httpURLConnection.setRequestProperty("Range", "bytes=" + dVar.h + c49.f40900a);
                        }
                        httpURLConnection.setRequestProperty("Connection", com.google.common.net.b.t0);
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == 200 || responseCode == 206) {
                            String headerField = httpURLConnection.getHeaderField("Content-Disposition");
                            String contentType = httpURLConnection.getContentType();
                            long contentLengthLong = httpURLConnection.getContentLengthLong();
                            if (responseCode == 200) {
                                dVar.h = 0L;
                                dVar.g = contentLengthLong;
                            }
                            com.kc.cw.ad.d.b.f.a("download", headerField + contentType);
                            inputStream = httpURLConnection.getInputStream();
                            try {
                                byte[] bArr = new byte[8192];
                                RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "rw");
                                try {
                                    randomAccessFile2.seek(dVar.h);
                                    int i = 0;
                                    while (true) {
                                        int i2 = inputStream.read(bArr);
                                        if (i2 == -1) {
                                            randomAccessFile2.getFD().sync();
                                            if (a(file2)) {
                                                dVar.f38941a = false;
                                                b(file2);
                                            } else {
                                                dVar.f38941a = false;
                                                a(4);
                                            }
                                            randomAccessFile = randomAccessFile2;
                                            break;
                                        }
                                        i++;
                                        randomAccessFile2.write(bArr, 0, i2);
                                        d.c(dVar, i2);
                                        if (i % 64 == 0) {
                                            if (dVar.b) {
                                                dVar.f38941a = false;
                                                a(1);
                                                try {
                                                    randomAccessFile2.getFD().sync();
                                                } catch (IOException unused) {
                                                }
                                                try {
                                                    randomAccessFile2.close();
                                                } catch (IOException unused2) {
                                                }
                                                try {
                                                    inputStream.close();
                                                } catch (IOException unused3) {
                                                }
                                                httpURLConnection.disconnect();
                                                return;
                                            }
                                            if (dVar.c) {
                                                dVar.f38941a = false;
                                                a(6);
                                                try {
                                                    randomAccessFile2.getFD().sync();
                                                } catch (IOException unused4) {
                                                }
                                                try {
                                                    randomAccessFile2.close();
                                                } catch (IOException unused5) {
                                                }
                                                try {
                                                    inputStream.close();
                                                } catch (IOException unused6) {
                                                }
                                                httpURLConnection.disconnect();
                                                return;
                                            }
                                            if (i % 16 == 0) {
                                                a(dVar.h, dVar.g);
                                            }
                                        }
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    randomAccessFile = randomAccessFile2;
                                    com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
                                    dVar.f38941a = false;
                                    a(5);
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.getFD().sync();
                                        } catch (IOException unused7) {
                                        }
                                    }
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.close();
                                        } catch (IOException unused8) {
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException unused9) {
                                        }
                                    }
                                    if (httpURLConnection == null) {
                                        return;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    randomAccessFile = randomAccessFile2;
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.getFD().sync();
                                        } catch (IOException unused10) {
                                        }
                                    }
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.close();
                                        } catch (IOException unused11) {
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException unused12) {
                                        }
                                    }
                                    if (httpURLConnection == null) {
                                        throw th;
                                    }
                                    httpURLConnection.disconnect();
                                    throw th;
                                }
                            } catch (Exception e2) {
                                e = e2;
                            }
                        } else {
                            dVar.f38941a = false;
                            a(2);
                            inputStream = null;
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.getFD().sync();
                            } catch (IOException unused13) {
                            }
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException unused14) {
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused15) {
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        inputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = inputStream;
                    randomAccessFile = randomAccessFile;
                }
            } catch (Exception e4) {
                e = e4;
                httpURLConnection = null;
                inputStream = null;
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection = null;
                inputStream = null;
            }
            httpURLConnection.disconnect();
        }
    }

    @Keep
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile boolean f38941a;
        public volatile boolean b;
        public volatile boolean c;
        private String d;
        private String e;
        private String f;
        private volatile long g;
        private volatile long h;

        public d(String str, String str2, String str3) {
            this.d = str;
            this.e = str2;
            this.f = str3;
            a();
        }

        public static /* synthetic */ long c(d dVar, long j) {
            long j2 = dVar.h + j;
            dVar.h = j2;
            return j2;
        }

        public void a() {
            this.g = 0L;
            this.h = 0L;
            this.b = false;
            this.c = false;
            this.f38941a = false;
        }
    }

    public static a a() {
        return new RunnableC1006c();
    }
}
