package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
final class e<TResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f37390a = new Object();
    private final int b;
    private final i<Void> c;
    private int d;
    private Exception e;
    private boolean f;

    public e(int i, i<Void> iVar) {
        this.b = i;
        this.c = iVar;
    }

    private void a() {
        if (this.d >= this.b) {
            if (this.e != null) {
                this.c.a(new ExecutionException("a task failed", this.e));
            } else if (this.f) {
                this.c.a();
            } else {
                this.c.a((Void) null);
            }
        }
    }

    @Override // com.huawei.hmf.tasks.OnCanceledListener
    public final void onCanceled() {
        synchronized (this.f37390a) {
            this.d++;
            this.f = true;
            a();
        }
    }

    @Override // com.huawei.hmf.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        synchronized (this.f37390a) {
            this.d++;
            this.e = exc;
            a();
        }
    }

    @Override // com.huawei.hmf.tasks.OnSuccessListener
    public final void onSuccess(TResult tresult) {
        synchronized (this.f37390a) {
            this.d++;
            a();
        }
    }
}
