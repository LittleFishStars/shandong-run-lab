package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import com.zj.adlib.iud;
import java.util.concurrent.ExecutionException;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c<T> implements zzae<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f31410a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final iud f5841a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("mLock")
    public Exception f5842a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f5843a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("mLock")
    public boolean f5844a;

    @GuardedBy("mLock")
    public int b;

    @GuardedBy("mLock")
    public int c;

    @GuardedBy("mLock")
    public int d;

    public c(int i, iud iudVar) {
        this.f31410a = i;
        this.f5841a = iudVar;
    }

    @GuardedBy("mLock")
    public final void a() {
        if (this.b + this.c + this.d == this.f31410a) {
            if (this.f5842a == null) {
                if (this.f5844a) {
                    this.f5841a.A();
                    return;
                } else {
                    this.f5841a.z(null);
                    return;
                }
            }
            this.f5841a.y(new ExecutionException(this.c + " out of " + this.f31410a + " underlying tasks failed", this.f5842a));
        }
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void onCanceled() {
        synchronized (this.f5843a) {
            this.d++;
            this.f5844a = true;
            a();
        }
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(@NonNull Exception exc) {
        synchronized (this.f5843a) {
            this.c++;
            this.f5842a = exc;
            a();
        }
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(T t) {
        synchronized (this.f5843a) {
            this.b++;
            a();
        }
    }
}
