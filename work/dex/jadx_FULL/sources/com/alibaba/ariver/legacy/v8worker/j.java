package com.alibaba.ariver.legacy.v8worker;

import java.util.Date;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f24319a;
    private final b b;
    private final a c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f24320a;

        public a(b bVar) {
            this.f24320a = bVar;
        }

        public void finalize() throws Throwable {
            try {
                synchronized (this.f24320a) {
                    this.f24320a.b = true;
                    this.f24320a.notify();
                }
                super.finalize();
            } catch (Throwable th) {
                super.finalize();
                throw th;
            }
        }
    }

    public static final class b extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f24321a;
        private boolean b;
        private volatile boolean c = false;
        private a d = new a();

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f24322a;
            private k[] b;
            private int c;
            private int d;

            private a() {
                this.f24322a = 256;
                this.b = new k[256];
                this.c = 0;
                this.d = 0;
            }

            private void f() {
                int i = this.c - 1;
                int i2 = (i - 1) / 2;
                while (true) {
                    k[] kVarArr = this.b;
                    k kVar = kVarArr[i];
                    long j = kVar.c;
                    k kVar2 = kVarArr[i2];
                    if (j >= kVar2.c) {
                        return;
                    }
                    kVarArr[i] = kVar2;
                    kVarArr[i2] = kVar;
                    int i3 = i2;
                    i2 = (i2 - 1) / 2;
                    i = i3;
                }
            }

            public boolean b() {
                return this.c == 0;
            }

            public void c() {
                this.b = new k[this.f24322a];
                this.c = 0;
            }

            public void d() {
                b(0);
            }

            public void e() {
                int i = 0;
                while (i < this.c) {
                    if (this.b[i].b) {
                        this.d++;
                        a(i);
                        i--;
                    }
                    i++;
                }
            }

            private void b(int i) {
                int i2 = (i * 2) + 1;
                while (true) {
                    int i3 = this.c;
                    if (i2 >= i3 || i3 <= 0) {
                        return;
                    }
                    int i4 = i2 + 1;
                    if (i4 < i3) {
                        k[] kVarArr = this.b;
                        if (kVarArr[i4].c < kVarArr[i2].c) {
                            i2 = i4;
                        }
                    }
                    k[] kVarArr2 = this.b;
                    k kVar = kVarArr2[i];
                    long j = kVar.c;
                    k kVar2 = kVarArr2[i2];
                    if (j < kVar2.c) {
                        return;
                    }
                    kVarArr2[i] = kVar2;
                    kVarArr2[i2] = kVar;
                    int i5 = i2;
                    i2 = (i2 * 2) + 1;
                    i = i5;
                }
            }

            public k a() {
                return this.b[0];
            }

            public void a(k kVar) {
                k[] kVarArr = this.b;
                int length = kVarArr.length;
                int i = this.c;
                if (length == i) {
                    k[] kVarArr2 = new k[i * 2];
                    System.arraycopy(kVarArr, 0, kVarArr2, 0, i);
                    this.b = kVarArr2;
                }
                k[] kVarArr3 = this.b;
                int i2 = this.c;
                this.c = i2 + 1;
                kVarArr3[i2] = kVar;
                f();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int b(k kVar) {
                int i = 0;
                while (true) {
                    k[] kVarArr = this.b;
                    if (i >= kVarArr.length) {
                        return -1;
                    }
                    if (kVarArr[i] == kVar) {
                        return i;
                    }
                    i++;
                }
            }

            public void a(int i) {
                int i2;
                if (i < 0 || i >= (i2 = this.c)) {
                    return;
                }
                k[] kVarArr = this.b;
                int i3 = i2 - 1;
                this.c = i3;
                kVarArr[i] = kVarArr[i3];
                kVarArr[i3] = null;
                b(i);
            }
        }

        public b(String str, boolean z) {
            setName(str);
            setDaemon(z);
            start();
        }

        /* JADX WARN: Code restructure failed: missing block: B:65:0x00a8, code lost:
        
            r2.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00ad, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00ae, code lost:
        
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x00b0, code lost:
        
            r10.f24321a = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x00b3, code lost:
        
            throw r0;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            while (true) {
                if (this.c) {
                    synchronized (this) {
                        try {
                            if (this.c) {
                                wait();
                            }
                        } catch (InterruptedException unused) {
                        }
                    }
                } else {
                    synchronized (this) {
                        if (this.f24321a) {
                            return;
                        }
                        if (!this.d.b()) {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            k kVarA = this.d.a();
                            synchronized (kVarA.f24323a) {
                                if (kVarA.b) {
                                    this.d.a(0);
                                } else {
                                    long j = kVarA.c - jCurrentTimeMillis;
                                    if (j > 0) {
                                        try {
                                            wait(j);
                                        } catch (InterruptedException unused2) {
                                        }
                                    } else {
                                        synchronized (kVarA.f24323a) {
                                            int iB = this.d.a().c != kVarA.c ? this.d.b(kVarA) : 0;
                                            if (kVarA.b) {
                                                a aVar = this.d;
                                                aVar.a(aVar.b(kVarA));
                                            } else {
                                                kVarA.a(kVarA.c);
                                                this.d.a(iB);
                                                long j2 = kVarA.d;
                                                if (j2 >= 0) {
                                                    if (kVarA.e) {
                                                        kVarA.c += j2;
                                                    } else {
                                                        kVarA.c = System.currentTimeMillis() + kVarA.d;
                                                    }
                                                    a(kVarA);
                                                } else {
                                                    kVarA.c = 0L;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (this.b) {
                            return;
                        } else {
                            try {
                                wait();
                            } catch (InterruptedException unused3) {
                            }
                        }
                    }
                }
            }
        }

        public int b() {
            if (this.d.b()) {
                return 0;
            }
            this.d.d = 0;
            this.d.e();
            return this.d.d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(k kVar) {
            this.d.a(kVar);
            notify();
        }

        public synchronized void a() {
            this.f24321a = true;
            this.d.c();
            notify();
        }
    }

    public j(String str, boolean z) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        b bVar = new b(str, z);
        this.b = bVar;
        this.c = new a(bVar);
    }

    private static synchronized long e() {
        long j;
        j = f24319a;
        f24319a = 1 + j;
        return j;
    }

    public void a() {
        synchronized (this.b) {
            this.b.c = true;
            this.b.notify();
        }
    }

    public void b() {
        synchronized (this.b) {
            this.b.c = false;
            this.b.notify();
        }
    }

    public void c() {
        this.b.a();
    }

    public int d() {
        int iB;
        synchronized (this.b) {
            iB = this.b.b();
        }
        return iB;
    }

    public j(String str) {
        this(str, false);
    }

    public void a(k kVar, Date date) {
        if (date.getTime() >= 0) {
            long time = date.getTime() - System.currentTimeMillis();
            a(kVar, time < 0 ? 0L : time, -1L, false);
        } else {
            throw new IllegalArgumentException("when < 0: " + date.getTime());
        }
    }

    public void b(k kVar, long j, long j2) {
        if (j >= 0 && j2 > 0) {
            a(kVar, j, j2, true);
            return;
        }
        throw new IllegalArgumentException();
    }

    public j(boolean z) {
        this("Timer-" + e(), z);
    }

    public j() {
        this(false);
    }

    public void b(k kVar, Date date, long j) {
        if (j > 0 && date.getTime() >= 0) {
            a(kVar, date.getTime() - System.currentTimeMillis(), j, true);
            return;
        }
        throw new IllegalArgumentException();
    }

    public void a(k kVar, long j) {
        if (j >= 0) {
            a(kVar, j, -1L, false);
            return;
        }
        throw new IllegalArgumentException("delay < 0: " + j);
    }

    public void a(k kVar, long j, long j2) {
        if (j >= 0 && j2 > 0) {
            a(kVar, j, j2, false);
            return;
        }
        throw new IllegalArgumentException();
    }

    public void a(k kVar, Date date, long j) {
        if (j > 0 && date.getTime() >= 0) {
            long time = date.getTime() - System.currentTimeMillis();
            a(kVar, time < 0 ? 0L : time, j, false);
            return;
        }
        throw new IllegalArgumentException();
    }

    private void a(k kVar, long j, long j2, boolean z) {
        synchronized (this.b) {
            if (!this.b.f24321a) {
                long jCurrentTimeMillis = j + System.currentTimeMillis();
                if (jCurrentTimeMillis >= 0) {
                    synchronized (kVar.f24323a) {
                        if (!kVar.c()) {
                            if (!kVar.b) {
                                kVar.c = jCurrentTimeMillis;
                                kVar.d = j2;
                                kVar.e = z;
                            } else {
                                throw new IllegalStateException("TimerTask is canceled");
                            }
                        } else {
                            throw new IllegalStateException("TimerTask is scheduled already");
                        }
                    }
                    this.b.a(kVar);
                } else {
                    throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + jCurrentTimeMillis);
                }
            } else {
                throw new IllegalStateException("Timer was canceled");
            }
        }
    }
}
