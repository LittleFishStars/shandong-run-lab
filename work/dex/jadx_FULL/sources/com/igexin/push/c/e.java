package com.igexin.push.c;

import android.annotation.SuppressLint;
import com.alibaba.android.arouter.utils.Consts;
import com.zj.adlib.u15;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class e {
    private static final String e = "DT_DetectRunTask";
    private static final long f = 60;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Future<d> f37891a;
    d b;
    i c;
    boolean d;

    /* JADX INFO: renamed from: com.igexin.push.c.e$1, reason: invalid class name */
    public class AnonymousClass1 implements Callable<d> {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        @SuppressLint({"NewApi"})
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public d call() throws Throwable {
            Thread.currentThread().hashCode();
            com.igexin.b.a.a().f37791a.getActiveCount();
            if (!Thread.currentThread().isInterrupted()) {
                Socket socket = null;
                try {
                    try {
                        if (Thread.currentThread().isInterrupted()) {
                            com.igexin.c.a.c.a.a(e.e, Thread.currentThread().getName() + " is interrupted ######");
                            Thread.currentThread().hashCode();
                            com.igexin.b.a.a().f37791a.getActiveCount();
                            return null;
                        }
                        synchronized (i.class) {
                        }
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        String[] strArrA = com.igexin.c.a.b.g.a(e.this.b.a());
                        Socket socket2 = new Socket();
                        try {
                            socket2.connect(new InetSocketAddress(strArrA[1], e.this.b.b), 2500);
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            String strA = e.a(socket2.getInetAddress());
                            e.this.b.a("socket://" + strA + u15.f19942b + e.this.b.b, jCurrentTimeMillis2 - jCurrentTimeMillis, jCurrentTimeMillis2);
                            e.this.c();
                            com.igexin.c.a.c.a.a("DT_DetectRunTask|detect " + e.this.c() + "|time = " + e.this.b.c(), new Object[0]);
                            synchronized (i.class) {
                                if (e.this.c != null && !Thread.currentThread().isInterrupted()) {
                                    e eVar = e.this;
                                    eVar.c.a(b.a.f37887a, eVar.b);
                                }
                                if (!socket2.isClosed()) {
                                    try {
                                        socket2.close();
                                    } catch (Exception e) {
                                        e = e;
                                        com.igexin.c.a.c.a.a(e);
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            socket = socket2;
                            com.igexin.c.a.c.a.b(e.e, "|detect " + e.this.c() + "thread -->" + e.getMessage());
                            synchronized (i.class) {
                                e eVar2 = e.this;
                                if (eVar2.c != null) {
                                    eVar2.b.b();
                                    e eVar3 = e.this;
                                    eVar3.c.a(b.a.c, eVar3.b);
                                }
                                if (socket != null && !socket.isClosed()) {
                                    try {
                                        socket.close();
                                    } catch (Exception e3) {
                                        e = e3;
                                        com.igexin.c.a.c.a.a(e);
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            socket = socket2;
                            if (socket != null && !socket.isClosed()) {
                                try {
                                    socket.close();
                                } catch (Exception e4) {
                                    com.igexin.c.a.c.a.a(e4);
                                }
                            }
                            Thread.currentThread().hashCode();
                            com.igexin.b.a.a().f37791a.getActiveCount();
                            throw th;
                        }
                        Thread.currentThread().hashCode();
                        com.igexin.b.a.a().f37791a.getActiveCount();
                    } catch (Exception e5) {
                        e = e5;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            return e.this.b;
        }
    }

    public static String a(InetAddress inetAddress) throws NoSuchMethodException {
        try {
            Method declaredMethod = Class.forName("java.net.InetAddress").getDeclaredMethod("holder", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(inetAddress, new Object[0]);
            Field declaredField = objInvoke.getClass().getDeclaredField("address");
            declaredField.setAccessible(true);
            int iIntValue = ((Integer) declaredField.get(objInvoke)).intValue();
            String str = ((iIntValue >>> 24) & 255) + Consts.DOT + ((iIntValue >>> 16) & 255) + Consts.DOT + ((iIntValue >>> 8) & 255) + Consts.DOT + (iIntValue & 255);
            com.igexin.c.a.c.a.b(e, "i new Str: ".concat(String.valueOf(str)));
            return str;
        } catch (Throwable unused) {
            if (!com.igexin.push.config.d.ah) {
                throw new NoSuchMethodException("can't get ad by new method");
            }
            com.igexin.c.a.c.a.b(e, "get ad by original method");
            return inetAddress.getHostAddress();
        }
    }

    private void a(d dVar) {
        this.b = dVar;
    }

    private void a(boolean z) {
        this.d = z;
    }

    private d d() {
        return this.b;
    }

    private void e() {
        synchronized (i.class) {
            if (this.c != null) {
                this.f37891a = com.igexin.b.a.a().f37791a.submit(new AnonymousClass1());
            }
        }
    }

    private void f() {
        this.f37891a = com.igexin.b.a.a().f37791a.submit(new AnonymousClass1());
    }

    private void g() {
        try {
            Future<d> future = this.f37891a;
            if (future == null || future.isCancelled() || this.f37891a.isDone()) {
                return;
            }
            this.f37891a.cancel(true);
            this.f37891a = null;
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    public final void a() {
        c();
        com.igexin.c.a.c.a.a("DT_DetectRunTask|stop " + c() + " task", new Object[0]);
        g();
    }

    public final void a(i iVar) {
        synchronized (i.class) {
            this.c = iVar;
        }
    }

    public final void b() {
        a((i) null);
        g();
    }

    public final String c() {
        return this.b.a() + "|" + this.b.f37890a;
    }
}
