package com.byazt.ymw;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.byazt.omf.nu;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 462, 34})
public class a extends nu.c {
    public volatile com.byazt.pop.c c;
    public Handler tt = new Handler(Looper.getMainLooper());

    public a(com.byazt.pop.c cVar) {
        this.c = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.byazt.pop.c cVar) {
        return cVar != null;
    }

    private Handler uj() {
        Handler handler = this.tt;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.tt = handler2;
        return handler2;
    }

    @Override // com.byazt.omf.nu
    public void tt(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.c != null) {
            uj().post(new Runnable() { // from class: com.byazt.ymw.a.3
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.pop.c cVar = a.this.c;
                    if (a.this.c(cVar)) {
                        cVar.tt(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.byazt.omf.nu
    public void ve(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.c != null) {
            uj().post(new Runnable() { // from class: com.byazt.ymw.a.4
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.pop.c cVar = a.this.c;
                    if (a.this.c(cVar)) {
                        cVar.ve(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.byazt.omf.nu
    public void c() throws RemoteException {
        if (this.c != null) {
            uj().post(new Runnable() { // from class: com.byazt.ymw.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.pop.c cVar = a.this.c;
                    if (a.this.c(cVar)) {
                        cVar.c();
                    }
                }
            });
        }
    }

    public void ve() {
        this.c = null;
        this.tt = null;
    }

    @Override // com.byazt.omf.nu
    public void c(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.c != null) {
            uj().post(new Runnable() { // from class: com.byazt.ymw.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.pop.c cVar = a.this.c;
                    if (a.this.c(cVar)) {
                        cVar.c(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.byazt.omf.nu
    public void c(final long j, final String str, final String str2) throws RemoteException {
        if (this.c != null) {
            uj().post(new Runnable() { // from class: com.byazt.ymw.a.5
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.pop.c cVar = a.this.c;
                    if (a.this.c(cVar)) {
                        cVar.c(j, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.byazt.omf.nu
    public void c(final String str, final String str2) throws RemoteException {
        if (this.c != null) {
            uj().post(new Runnable() { // from class: com.byazt.ymw.a.6
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.pop.c cVar = a.this.c;
                    if (a.this.c(cVar)) {
                        String str3 = str;
                        if (str3 == null) {
                            str3 = "";
                        }
                        String str4 = str2;
                        cVar.c(str3, str4 != null ? str4 : "");
                    }
                }
            });
        }
    }
}
