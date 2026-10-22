package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import com.zj.adlib.alc;
import com.zj.adlib.iud;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class e<TResult, TContinuationResult> implements OnSuccessListener<TContinuationResult>, OnFailureListener, OnCanceledListener, zzq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Continuation f31412a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final iud f5847a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f5848a;

    public e(@NonNull Executor executor, @NonNull Continuation continuation, @NonNull iud iudVar) {
        this.f5848a = executor;
        this.f31412a = continuation;
        this.f5847a = iudVar;
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void a(@NonNull Task task) {
        this.f5848a.execute(new alc(this, task));
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void onCanceled() {
        this.f5847a.A();
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(@NonNull Exception exc) {
        this.f5847a.y(exc);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.f5847a.z(tcontinuationresult);
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void zzc() {
        throw new UnsupportedOperationException();
    }
}
