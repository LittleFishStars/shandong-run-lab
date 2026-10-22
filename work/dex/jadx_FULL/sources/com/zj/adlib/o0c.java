package com.zj.adlib;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class o0c implements OnCompleteListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q0c f43643a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ z09 f18538a;

    public o0c(q0c q0cVar, z09 z09Var) {
        this.f43643a = q0cVar;
        this.f18538a = z09Var;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(@NonNull Task task) {
        this.f43643a.b.remove(this.f18538a);
    }
}
