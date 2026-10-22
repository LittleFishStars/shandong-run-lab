package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import com.zj.adlib.gjd;
import com.zj.adlib.iud;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class j<TResult, TContinuationResult> implements OnSuccessListener<TContinuationResult>, OnFailureListener, OnCanceledListener, zzq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SuccessContinuation f31417a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final iud f5857a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f5858a;

    public j(@NonNull Executor executor, @NonNull SuccessContinuation successContinuation, @NonNull iud iudVar) {
        this.f5858a = executor;
        this.f31417a = successContinuation;
        this.f5857a = iudVar;
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void a(@NonNull Task task) {
        this.f5858a.execute(new gjd(this, task));
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void onCanceled() {
        this.f5857a.A();
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(@NonNull Exception exc) {
        this.f5857a.y(exc);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.f5857a.z(tcontinuationresult);
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void zzc() {
        throw new UnsupportedOperationException();
    }
}
