package com.fl.saas;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: renamed from: com.fl.saas.v0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class C1440v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ExecutorService f30200a;
    private Map b;

    /* JADX INFO: renamed from: com.fl.saas.v0$b */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static C1440v0 f30201a = new C1440v0();
    }

    /* JADX INFO: renamed from: com.fl.saas.v0$c */
    public class c implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f30202a;
        int b;
        boolean c = false;
        private final Object d = new Object();
        X e;

        public c(String str, int i) {
            this.b = Integer.MAX_VALUE;
            this.f30202a = str;
            if (i > 0) {
                this.b = i;
            }
        }

        private boolean b() {
            return this.c;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            return Boolean.valueOf(a(this.f30202a));
        }

        private boolean a(String str) {
            synchronized (this.d) {
                if (b()) {
                    return false;
                }
                X x = new X(str);
                this.e = x;
                try {
                    try {
                        x.a(0L);
                        byte[] bArr = new byte[8192];
                        int i = 0;
                        do {
                            int iA = this.e.a(bArr);
                            if (iA == -1) {
                                break;
                            }
                            synchronized (this.d) {
                                try {
                                    if (b()) {
                                        break;
                                    }
                                    i += iA;
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        } while (i < this.b);
                        try {
                            return true;
                        } catch (C1448z0 e) {
                            return true;
                        }
                    } catch (C1448z0 e2) {
                        e2.printStackTrace();
                        try {
                            this.e.close();
                        } catch (C1448z0 e3) {
                            e3.printStackTrace();
                        }
                        return false;
                    }
                } finally {
                    try {
                        this.e.close();
                        C1440v0.this.a(str);
                    } catch (C1448z0 e4) {
                        e4.printStackTrace();
                    }
                }
            }
        }
    }

    private C1440v0() {
        this.f30200a = Executors.newFixedThreadPool(5);
        this.b = new HashMap();
    }

    public static C1440v0 a() {
        return b.f30201a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        if (((c) this.b.get(str)) == null) {
            return false;
        }
        this.b.remove(str);
        return true;
    }

    public synchronized boolean a(String str, int i) {
        if (this.b.containsKey(str)) {
            return false;
        }
        c cVar = new c(str, i);
        this.b.put(str, cVar);
        this.f30200a.submit(cVar);
        return true;
    }
}
