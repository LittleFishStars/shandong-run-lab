package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import com.zj.adlib.b8c;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b<T> implements zzae<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CountDownLatch f31409a = new CountDownLatch(1);

    public b() {
    }

    public final void a() throws InterruptedException {
        this.f31409a.await();
    }

    public final boolean b(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.f31409a.await(j, timeUnit);
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void onCanceled() {
        this.f31409a.countDown();
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(@NonNull Exception exc) {
        this.f31409a.countDown();
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(T t) {
        this.f31409a.countDown();
    }

    public /* synthetic */ b(b8c b8cVar) {
    }
}
