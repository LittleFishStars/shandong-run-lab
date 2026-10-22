package com.igexin.c.a.b.a.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.igexin.c.a.b.a.a.d.AnonymousClass1;
import java.net.Socket;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class c extends Handler {

    /* JADX INFO: renamed from: com.igexin.c.a.b.a.a.c$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f37813a;

        static {
            int[] iArr = new int[j.a().length];
            f37813a = iArr;
            try {
                iArr[j.d - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37813a[j.e - 1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37813a[j.c - 1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f37813a[j.f - 1] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f37813a[j.g - 1] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f37813a[j.f37825a - 1] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f37813a[j.h - 1] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public c(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            int i = AnonymousClass1.f37813a[j.a()[message.what] - 1];
            if (i == 1) {
                d dVarA = d.a();
                Socket socket = dVarA.f37814a;
                boolean z = (socket == null || socket.isClosed()) ? false : true;
                if (!z && dVarA.d == null) {
                    com.igexin.c.a.c.a.a("GS-M|disconnect = true, reconnect", new Object[0]);
                    dVarA.d = new b(dVarA.new AnonymousClass1());
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) dVarA.d, true);
                    return;
                }
                com.igexin.c.a.c.a.a("GS-Mstart connect, isConnected = " + z + ", ctask = " + dVarA.d, new Object[0]);
                return;
            }
            if (i == 3) {
                d.a().a((Socket) message.obj);
                return;
            }
            if (i == 4) {
                d dVarA2 = d.a();
                if (!dVarA2.i() || dVarA2.f) {
                    return;
                }
                dVarA2.b();
                dVarA2.f = true;
                return;
            }
            if (i == 5) {
                d dVarA3 = d.a();
                dVarA3.j();
                if ((dVarA3.d == null && dVarA3.c == null && dVarA3.b == null) || dVarA3.i()) {
                    dVarA3.b();
                    return;
                } else {
                    dVarA3.h();
                    return;
                }
            }
            if (i == 6) {
                d.a();
                com.igexin.push.core.d unused = com.igexin.push.core.d.a.f37984a;
                com.igexin.push.e.a.a(j.f37825a);
            } else {
                if (i != 7) {
                    return;
                }
                d dVarA4 = d.a();
                com.igexin.c.a.c.a.b("GS-M", ((String) message.obj) + " write task response timeout");
                dVarA4.c();
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }
}
