package com.zj.adlib;

import com.google.android.gms.internal.mlkit_common.zzln;
import com.google.android.gms.internal.mlkit_common.zzlw;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.a;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.b;
import com.google.mlkit.common.sdkinternal.model.ModelInfoRetrieverInterop;
import com.google.mlkit.common.sdkinternal.model.RemoteModelManagerInterface;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class csc implements RemoteModelManagerInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hnd f41037a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final hq5 f15887a;

    public csc(hq5 hq5Var) {
        hnd hndVarB = iod.b("common");
        this.f15887a = hq5Var;
        this.f41037a = hndVarB;
    }

    @Override // com.google.mlkit.common.sdkinternal.model.RemoteModelManagerInterface
    public final Task<Set<kz1>> a() {
        return a.d(new MlKitException("Custom Remote model does not support listing downloaded models", 12));
    }

    @Override // com.google.mlkit.common.sdkinternal.model.RemoteModelManagerInterface
    public final /* bridge */ /* synthetic */ Task b(RemoteModel remoteModel, sp2 sp2Var) {
        final com.google.mlkit.common.sdkinternal.model.a aVarI = i((kz1) remoteModel);
        aVarI.k(sp2Var);
        return a.e(null).x(b.g(), new SuccessContinuation() { // from class: com.zj.adlib.zac
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task a(Object obj) {
                return aVarI.a();
            }
        });
    }

    @Override // com.google.mlkit.common.sdkinternal.model.RemoteModelManagerInterface
    public final /* bridge */ /* synthetic */ Task c(RemoteModel remoteModel) {
        final kz1 kz1Var = (kz1) remoteModel;
        final z09 z09Var = new z09();
        b.g().execute(new Runnable() { // from class: com.zj.adlib.gec
            @Override // java.lang.Runnable
            public final void run() {
                this.f41886a.f(kz1Var, z09Var);
            }
        });
        return z09Var.a().e(new OnCompleteListener() { // from class: com.zj.adlib.ohc
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f43753a.g(task);
            }
        });
    }

    @Override // com.google.mlkit.common.sdkinternal.model.RemoteModelManagerInterface
    public final /* bridge */ /* synthetic */ Task d(RemoteModel remoteModel) {
        final kz1 kz1Var = (kz1) remoteModel;
        return b.b().c(new Callable() { // from class: com.zj.adlib.dlc
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f41226a.e(kz1Var);
            }
        }).e(new OnCompleteListener() { // from class: com.zj.adlib.moc
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f43352a.h(task);
            }
        });
    }

    public final /* synthetic */ Boolean e(kz1 kz1Var) throws Exception {
        return Boolean.valueOf(i(kz1Var).h());
    }

    public final /* synthetic */ void f(kz1 kz1Var, z09 z09Var) {
        try {
            new qq5(this.f15887a).a(ModelType.CUSTOM, (String) yw6.l(kz1Var.c()));
            z09Var.setResult(null);
        } catch (RuntimeException e) {
            z09Var.b(new MlKitException("Internal error has occurred when executing ML Kit tasks", 13, e));
        }
    }

    public final /* synthetic */ void g(Task task) {
        boolean zV = task.v();
        hnd hndVar = this.f41037a;
        qcd qcdVar = new qcd();
        v8d v8dVar = new v8d();
        v8dVar.b(zzlw.CUSTOM);
        v8dVar.a(Boolean.valueOf(zV));
        qcdVar.e(v8dVar.c());
        hndVar.d(snd.f(qcdVar), zzln.REMOTE_MODEL_DELETE_ON_DEVICE);
    }

    public final /* synthetic */ void h(Task task) {
        boolean zBooleanValue = ((Boolean) task.r()).booleanValue();
        hnd hndVar = this.f41037a;
        qcd qcdVar = new qcd();
        uad uadVar = new uad();
        uadVar.b(zzlw.CUSTOM);
        uadVar.a(Boolean.valueOf(zBooleanValue));
        qcdVar.g(uadVar.c());
        hndVar.d(snd.f(qcdVar), zzln.REMOTE_MODEL_IS_DOWNLOADED);
    }

    public final com.google.mlkit.common.sdkinternal.model.a i(kz1 kz1Var) {
        com.google.mlkit.common.sdkinternal.model.b bVar = new com.google.mlkit.common.sdkinternal.model.b(this.f15887a, kz1Var, null, new qq5(this.f15887a), new q6c(this.f15887a, kz1Var.f()));
        hq5 hq5Var = this.f15887a;
        return com.google.mlkit.common.sdkinternal.model.a.g(hq5Var, kz1Var, new qq5(hq5Var), bVar, (ModelInfoRetrieverInterop) hq5Var.a(ModelInfoRetrieverInterop.class));
    }
}
