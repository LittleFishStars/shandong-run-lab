package com.alibaba.ariver.v8worker;

import java.util.Date;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f24521a;
    private final b b;
    private final a c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f24522a;

        public a(b bVar) {
            this.f24522a = bVar;
        }

        public void finalize() throws Throwable {
            try {
                synchronized (this.f24522a) {
                    this.f24522a.b = true;
                    this.f24522a.notify();
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
        private boolean f24523a;
        private boolean b;
        private volatile boolean c = false;
        private a d = new a();

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f24524a;
            private m[] b;
            private int c;
            private int d;

            private a() {
                this.f24524a = 256;
                this.b = new m[256];
                this.c = 0;
                this.d = 0;
            }

            private void f() {
                int i = this.c - 1;
                int i2 = (i - 1) / 2;
                while (true) {
                    m[] mVarArr = this.b;
                    m mVar = mVarArr[i];
                    long j = mVar.c;
                    m mVar2 = mVarArr[i2];
                    if (j >= mVar2.c) {
                        return;
                    }
                    mVarArr[i] = mVar2;
                    mVarArr[i2] = mVar;
                    int i3 = i2;
                    i2 = (i2 - 1) / 2;
                    i = i3;
                }
            }

            public boolean b() {
                return this.c == 0;
            }

            public void c() {
                this.b = new m[this.f24524a];
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
                        m[] mVarArr = this.b;
                        if (mVarArr[i4].c < mVarArr[i2].c) {
                            i2 = i4;
                        }
                    }
                    m[] mVarArr2 = this.b;
                    m mVar = mVarArr2[i];
                    long j = mVar.c;
                    m mVar2 = mVarArr2[i2];
                    if (j < mVar2.c) {
                        return;
                    }
                    mVarArr2[i] = mVar2;
                    mVarArr2[i2] = mVar;
                    int i5 = i2;
                    i2 = (i2 * 2) + 1;
                    i = i5;
                }
            }

            public m a() {
                return this.b[0];
            }

            public void a(m mVar) {
                m[] mVarArr = this.b;
                int length = mVarArr.length;
                int i = this.c;
                if (length == i) {
                    m[] mVarArr2 = new m[i * 2];
                    System.arraycopy(mVarArr, 0, mVarArr2, 0, i);
                    this.b = mVarArr2;
                }
                m[] mVarArr3 = this.b;
                int i2 = this.c;
                this.c = i2 + 1;
                mVarArr3[i2] = mVar;
                f();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int b(m mVar) {
                int i = 0;
                while (true) {
                    m[] mVarArr = this.b;
                    if (i >= mVarArr.length) {
                        return -1;
                    }
                    if (mVarArr[i] == mVar) {
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
                m[] mVarArr = this.b;
                int i3 = i2 - 1;
                this.c = i3;
                mVarArr[i] = mVarArr[i3];
                mVarArr[i3] = null;
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
        
            r10.f24523a = true;
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
                        if (this.f24523a) {
                            return;
                        }
                        if (!this.d.b()) {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            m mVarA = this.d.a();
                            synchronized (mVarA.f24525a) {
                                if (mVarA.b) {
                                    this.d.a(0);
                                } else {
                                    long j = mVarA.c - jCurrentTimeMillis;
                                    if (j > 0) {
                                        try {
                                            wait(j);
                                        } catch (InterruptedException unused2) {
                                        }
                                    } else {
                                        synchronized (mVarA.f24525a) {
                                            int iB = this.d.a().c != mVarA.c ? this.d.b(mVarA) : 0;
                                            if (mVarA.b) {
                                                a aVar = this.d;
                                                aVar.a(aVar.b(mVarA));
                                            } else {
                                                mVarA.a(mVarA.c);
                                                this.d.a(iB);
                                                long j2 = mVarA.d;
                                                if (j2 >= 0) {
                                                    if (mVarA.e) {
                                                        mVarA.c += j2;
                                                    } else {
                                                        mVarA.c = System.currentTimeMillis() + mVarA.d;
                                                    }
                                                    a(mVarA);
                                                } else {
                                                    mVarA.c = 0L;
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
        public void a(m mVar) {
            this.d.a(mVar);
            notify();
        }

        public synchronized void a() {
            this.f24523a = true;
            this.d.c();
            notify();
        }
    }

    public l(String str, boolean z) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        b bVar = new b(str, z);
        this.b = bVar;
        this.c = new a(bVar);
    }

    private static synchronized long e() {
        long j;
        j = f24521a;
        f24521a = 1 + j;
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

    public l(String str) {
        this(str, false);
    }

    public void a(m mVar, Date date) {
        if (date.getTime() >= 0) {
            long time = date.getTime() - System.currentTimeMillis();
            a(mVar, time < 0 ? 0L : time, -1L, false);
        } else {
            throw new IllegalArgumentException("when < 0: " + date.getTime());
        }
    }

    public void b(m mVar, long j, long j2) {
        if (j >= 0 && j2 > 0) {
            a(mVar, j, j2, true);
            return;
        }
        throw new IllegalArgumentException();
    }

    public l(boolean z) {
        this("Timer-" + e(), z);
    }

    public l() {
        this(false);
    }

    public void b(m mVar, Date date, long j) {
        if (j > 0 && date.getTime() >= 0) {
            a(mVar, date.getTime() - System.currentTimeMillis(), j, true);
            return;
        }
        throw new IllegalArgumentException();
    }

    public void a(m mVar, long j) {
        if (j >= 0) {
            a(mVar, j, -1L, false);
            return;
        }
        throw new IllegalArgumentException("delay < 0: " + j);
    }

    public void a(m mVar, long j, long j2) {
        if (j >= 0 && j2 > 0) {
            a(mVar, j, j2, false);
            return;
        }
        throw new IllegalArgumentException();
    }

    public void a(m mVar, Date date, long j) {
        if (j > 0 && date.getTime() >= 0) {
            long time = date.getTime() - System.currentTimeMillis();
            a(mVar, time < 0 ? 0L : time, j, false);
            return;
        }
        throw new IllegalArgumentException();
    }

    private void a(m mVar, long j, long j2, boolean z) {
        synchronized (this.b) {
            if (!this.b.f24523a) {
                long jCurrentTimeMillis = j + System.currentTimeMillis();
                if (jCurrentTimeMillis >= 0) {
                    synchronized (mVar.f24525a) {
                        if (!mVar.c()) {
                            if (!mVar.b) {
                                mVar.c = jCurrentTimeMillis;
                                mVar.d = j2;
                                mVar.e = z;
                            } else {
                                throw new IllegalStateException("TimerTask is canceled");
                            }
                        } else {
                            throw new IllegalStateException("TimerTask is scheduled already");
                        }
                    }
                    this.b.a(mVar);
                } else {
                    throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + jCurrentTimeMillis);
                }
            } else {
                throw new IllegalStateException("Timer was canceled");
            }
        }
    }
}
