package com.beizi.fusion;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.zj.adlib.c49;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class g7 {

    public interface a {
        void a(b bVar);

        void a(d dVar);

        void destroy();
    }

    public interface b {
        void a(int i);

        void a(long j, long j2);

        void a(File file);

        boolean b(File file);
    }

    public static final class c implements a, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private HandlerThread f27340a;
        private b b;
        private Handler c;
        private Handler d = new Handler(Looper.getMainLooper());
        private d e;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f27341a;
            final /* synthetic */ long b;

            public a(long j, long j2) {
                this.f27341a = j;
                this.b = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = c.this.b;
                if (bVar != null) {
                    bVar.a(this.f27341a, this.b);
                }
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ File f27342a;

            public b(File file) {
                this.f27342a = file;
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = c.this.b;
                if (bVar != null) {
                    bVar.a(this.f27342a);
                }
            }
        }

        /* JADX INFO: renamed from: com.beizi.fusion.g7$c$c, reason: collision with other inner class name */
        public class RunnableC0310c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f27343a;

            public RunnableC0310c(int i) {
                this.f27343a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = c.this.b;
                if (bVar != null) {
                    bVar.a(this.f27343a);
                }
            }
        }

        public c() {
            HandlerThread handlerThread = new HandlerThread("download");
            this.f27340a = handlerThread;
            handlerThread.start();
            this.c = new Handler(this.f27340a.getLooper());
        }

        private void b(File file) {
            this.d.post(new b(file));
        }

        @Override // com.beizi.fusion.g7.a
        public void a(b bVar) {
            this.b = bVar;
        }

        @Override // com.beizi.fusion.g7.a
        public void destroy() {
            HandlerThread handlerThread = this.f27340a;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            this.c = null;
            this.f27340a = null;
        }

        /* JADX WARN: Code duplicated, block: B:120:0x01ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:124:0x01a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:128:0x01a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:159:? A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:95:0x01b3  */
        @Override // java.lang.Runnable
        public void run() throws Throwable {
            RandomAccessFile randomAccessFile;
            InputStream inputStream;
            HttpURLConnection httpURLConnection;
            RandomAccessFile randomAccessFile2;
            d dVar = this.e;
            dVar.f = true;
            File file = new File(dVar.b);
            if (!file.exists() && !file.mkdirs()) {
                a(3);
                return;
            }
            String str = dVar.b + File.separator + dVar.c;
            File file2 = new File(str);
            HttpURLConnection httpURLConnection2 = null;
            RandomAccessFile randomAccessFile3 = null;
            randomAccessFile = null;
            randomAccessFile = null;
            randomAccessFile = null;
            RandomAccessFile randomAccessFile4 = null;
            try {
                httpURLConnection = (HttpURLConnection) new URL(dVar.f27344a).openConnection();
                try {
                    if (dVar.e != 0) {
                        httpURLConnection.setRequestProperty("Range", "bytes=" + dVar.e + c49.f40900a);
                    }
                    httpURLConnection.setRequestProperty("Connection", com.google.common.net.b.t0);
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200 || responseCode == 206) {
                        String headerField = httpURLConnection.getHeaderField("Content-Disposition");
                        String contentType = httpURLConnection.getContentType();
                        long contentLengthLong = httpURLConnection.getContentLengthLong();
                        if (responseCode == 200) {
                            dVar.e = 0L;
                            dVar.d = contentLengthLong;
                        }
                        Log.d("download", headerField + contentType);
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            try {
                                byte[] bArr = new byte[8192];
                                randomAccessFile2 = new RandomAccessFile(str, "rw");
                                try {
                                    randomAccessFile2.seek(dVar.e);
                                    int i = 0;
                                    while (true) {
                                        int i2 = inputStream.read(bArr);
                                        if (i2 == -1) {
                                            randomAccessFile2.getFD().sync();
                                            if (a(file2)) {
                                                dVar.f = false;
                                                b(file2);
                                            } else {
                                                dVar.f = false;
                                                a(4);
                                            }
                                            randomAccessFile3 = randomAccessFile2;
                                            break;
                                        }
                                        i++;
                                        randomAccessFile2.write(bArr, 0, i2);
                                        dVar.e += (long) i2;
                                        if (i % 64 == 0) {
                                            if (dVar.g) {
                                                dVar.f = false;
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
                                            if (dVar.h) {
                                                dVar.f = false;
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
                                                a(dVar.e, dVar.d);
                                            }
                                        }
                                    }
                                } catch (IOException e) {
                                    e = e;
                                    randomAccessFile4 = randomAccessFile2;
                                    e.printStackTrace();
                                    dVar.f = false;
                                    a(5);
                                    if (randomAccessFile4 != null) {
                                        try {
                                            randomAccessFile4.getFD().sync();
                                        } catch (IOException unused7) {
                                        }
                                    }
                                    if (randomAccessFile4 != null) {
                                        try {
                                            randomAccessFile4.close();
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
                                    if (randomAccessFile2 != null) {
                                        try {
                                            randomAccessFile2.getFD().sync();
                                        } catch (IOException unused10) {
                                        }
                                    }
                                    if (randomAccessFile2 != null) {
                                        try {
                                            randomAccessFile2.close();
                                        } catch (IOException unused11) {
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException unused12) {
                                        }
                                    }
                                    if (httpURLConnection != null) {
                                        throw th;
                                    }
                                    httpURLConnection.disconnect();
                                    throw th;
                                }
                            } catch (IOException e2) {
                                e = e2;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            randomAccessFile = randomAccessFile4;
                            httpURLConnection2 = httpURLConnection;
                            randomAccessFile2 = randomAccessFile;
                            httpURLConnection = httpURLConnection2;
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.getFD().sync();
                            }
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (httpURLConnection != null) {
                                throw th;
                            }
                            httpURLConnection.disconnect();
                            throw th;
                        }
                    } else {
                        dVar.f = false;
                        a(2);
                        inputStream = null;
                    }
                    if (randomAccessFile3 != null) {
                        try {
                            randomAccessFile3.getFD().sync();
                        } catch (IOException unused13) {
                        }
                    }
                    if (randomAccessFile3 != null) {
                        try {
                            randomAccessFile3.close();
                        } catch (IOException unused14) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused15) {
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    inputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    randomAccessFile = null;
                    inputStream = null;
                    httpURLConnection2 = httpURLConnection;
                    randomAccessFile2 = randomAccessFile;
                    httpURLConnection = httpURLConnection2;
                    if (randomAccessFile2 != null) {
                        randomAccessFile2.getFD().sync();
                    }
                    if (randomAccessFile2 != null) {
                        randomAccessFile2.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection != null) {
                        throw th;
                    }
                    httpURLConnection.disconnect();
                    throw th;
                }
            } catch (IOException e4) {
                e = e4;
                httpURLConnection = null;
                inputStream = null;
            } catch (Throwable th4) {
                th = th4;
                randomAccessFile = null;
                inputStream = null;
                randomAccessFile2 = randomAccessFile;
                httpURLConnection = httpURLConnection2;
                if (randomAccessFile2 != null) {
                    randomAccessFile2.getFD().sync();
                }
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection != null) {
                    throw th;
                }
                httpURLConnection.disconnect();
                throw th;
            }
            httpURLConnection.disconnect();
        }

        @Override // com.beizi.fusion.g7.a
        public void a(d dVar) {
            if (dVar.f) {
                throw new IllegalArgumentException("Invalid request,it's downloading");
            }
            d dVar2 = this.e;
            if (dVar2 != null && !dVar.equals(dVar2)) {
                this.e.g = true;
            }
            this.e = dVar;
            dVar.a();
            Handler handler = this.c;
            if (handler != null) {
                handler.post(this);
            }
        }

        private void a(long j, long j2) {
            this.d.post(new a(j, j2));
        }

        private boolean a(File file) {
            b bVar = this.b;
            return bVar != null && bVar.b(file);
        }

        private void a(int i) {
            this.d.post(new RunnableC0310c(i));
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f27344a;
        private String b;
        private String c;
        private volatile long d;
        private volatile long e;
        public volatile boolean f;
        public volatile boolean g;
        public volatile boolean h;

        public d(String str, String str2, String str3) {
            this.f27344a = str;
            this.b = str2;
            this.c = str3;
            a();
        }

        public void a() {
            this.d = 0L;
            this.e = 0L;
            this.g = false;
            this.h = false;
            this.f = false;
        }
    }

    public static a a() {
        return new c();
    }
}
