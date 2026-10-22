package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode.zzek;
import com.google.android.gms.internal.mlkit_vision_barcode.zzez;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class nmc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzek f43562a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Future f18465a;

    public nmc(Future future, zzek zzekVar) {
        this.f18465a = future;
        this.f43562a = zzekVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Throwable thA = roc.a((zzez) this.f18465a);
        if (thA != null) {
            this.f43562a.b(thA);
            return;
        }
        try {
            Future future = this.f18465a;
            boolean z = false;
            if (!future.isDone()) {
                throw new IllegalStateException(zbc.b("Future was expected to be done: %s", future));
            }
            while (true) {
                try {
                    obj = future.get();
                    break;
                } catch (InterruptedException unused) {
                    z = true;
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            this.f43562a.a(obj);
        } catch (Error e) {
            e = e;
            this.f43562a.b(e);
        } catch (RuntimeException e2) {
            e = e2;
            this.f43562a.b(e);
        } catch (ExecutionException e3) {
            this.f43562a.b(e3.getCause());
        }
    }

    public final String toString() {
        qac qacVarA = uac.a(this);
        qacVarA.a(this.f43562a);
        return qacVarA.toString();
    }
}
