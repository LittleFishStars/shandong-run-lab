package com.igexin.c.a.b.a.a;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class g extends a {
    private static final String P = "GS-W";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f37822a = -2036;
    com.igexin.c.a.b.a.a.a.c j;
    protected com.igexin.c.a.b.d k;
    protected i l;

    public g(i iVar, com.igexin.c.a.b.d dVar) {
        super(-2036, dVar);
        this.k = dVar;
        this.l = iVar;
    }

    private void a(com.igexin.c.a.b.a.a.a.c cVar) {
        this.j = cVar;
    }

    @Override // com.igexin.c.a.b.f, com.igexin.c.a.d.f, com.igexin.c.a.d.a.a
    public final void a() {
        super.a();
        com.igexin.c.a.c.a.a(P, "wt dispose");
        com.igexin.c.a.c.a.a("GS-W|wt dispose", new Object[0]);
        if (this.j != null) {
            if (this.g != a.EnumC0848a.b) {
                this.j.a();
            } else if (!TextUtils.isEmpty(this.h)) {
                this.j.a(new Exception(this.h));
            }
        }
        this.j = null;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void b_() throws Exception {
        super.b_();
        Thread threadCurrentThread = Thread.currentThread();
        com.igexin.c.a.c.a.a("GS-W|" + threadCurrentThread + " running", new Object[0]);
        d dVarA = d.a();
        while (this.i && !threadCurrentThread.isInterrupted() && !this.f) {
            try {
                dVarA.g.lock();
                if (dVarA.k.isEmpty() && this.i) {
                    dVarA.h.await();
                }
                f fVarPoll = dVarA.k.poll();
                if (fVarPoll != null && this.i && this.l != null && this.i) {
                    this.g = a.EnumC0848a.f37811a;
                    if (this.j != null && this.i) {
                        this.j.a(fVarPoll);
                    }
                    Object obj = fVarPoll.d;
                    if (obj != null) {
                        i iVar = this.l;
                        byte[] bArr = (byte[]) this.k.a(null, obj);
                        iVar.f37824a.write(bArr, 0, bArr.length);
                        iVar.f37824a.flush();
                    }
                    if (fVarPoll.d != null) {
                        com.igexin.c.a.c.a.a("GS-W|" + fVarPoll.d.getClass().getName() + " -- send success", new Object[0]);
                    }
                }
                try {
                    dVarA.g.unlock();
                } catch (Exception e) {
                    com.igexin.c.a.c.a.a(e);
                }
            } catch (Throwable th) {
                try {
                    com.igexin.c.a.c.a.a(th);
                    this.i = false;
                    if (this.g != a.EnumC0848a.c) {
                        this.g = a.EnumC0848a.b;
                        this.h = th.toString();
                    }
                    dVarA.g.unlock();
                } catch (Throwable th2) {
                    try {
                        dVarA.g.unlock();
                    } catch (Exception e2) {
                        com.igexin.c.a.c.a.a(e2);
                    }
                    throw th2;
                }
            }
        }
        this.f = true;
        com.igexin.c.a.c.a.a("GS-W|finish ~~~~~~", new Object[0]);
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return -2036;
    }

    @Override // com.igexin.c.a.b.a.a.a
    public final void c_() {
        this.i = false;
        this.g = a.EnumC0848a.c;
        d dVarA = d.a();
        try {
            if (!this.f) {
                dVarA.g.lock();
                dVarA.h.signalAll();
            }
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            com.igexin.c.a.c.a.a(P, e.toString());
        } finally {
            try {
                dVarA.g.unlock();
            } catch (Exception e2) {
                com.igexin.c.a.c.a.a(e2);
            }
        }
    }
}
