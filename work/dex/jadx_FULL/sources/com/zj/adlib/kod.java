package com.zj.adlib;

import android.os.SystemClock;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.mlkit_common.zzlw;
import com.google.android.gms.internal.mlkit_common.zzlx;
import com.google.android.gms.internal.mlkit_common.zzqb;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.ModelType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class kod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final su3 f42874a = new su3("RemoteModelUtils", "");

    @WorkerThread
    public static hdd a(RemoteModel remoteModel, e98 e98Var, zzqb zzqbVar) {
        zzlw zzlwVar;
        ModelType modelTypeB = zzqbVar.b();
        String strB = remoteModel.b();
        fed fedVar = new fed();
        kdd kddVar = new kdd();
        kddVar.c(remoteModel.d());
        kddVar.d(zzlx.CLOUD);
        kddVar.a(s8c.b(strB));
        int iOrdinal = modelTypeB.ordinal();
        if (iOrdinal == 2) {
            zzlwVar = zzlw.BASE_TRANSLATE;
        } else if (iOrdinal != 4) {
            zzlwVar = iOrdinal != 5 ? zzlw.TYPE_UNKNOWN : zzlw.BASE_DIGITAL_INK;
        } else {
            zzlwVar = zzlw.CUSTOM;
        }
        kddVar.b(zzlwVar);
        fedVar.b(kddVar.g());
        led ledVarC = fedVar.c();
        zcd zcdVar = new zcd();
        zcdVar.d(zzqbVar.c());
        zcdVar.c(zzqbVar.d());
        zcdVar.b(Long.valueOf(zzqbVar.a()));
        zcdVar.f(ledVarC);
        if (zzqbVar.g()) {
            long j = e98Var.j(remoteModel);
            if (j == 0) {
                f42874a.n("RemoteModelUtils", "Model downloaded without its beginning time recorded.");
            } else {
                long jK = e98Var.k(remoteModel);
                if (jK == 0) {
                    jK = SystemClock.elapsedRealtime();
                    e98Var.p(remoteModel, jK);
                }
                zcdVar.g(Long.valueOf(jK - j));
            }
        }
        if (zzqbVar.f()) {
            long j2 = e98Var.j(remoteModel);
            if (j2 == 0) {
                f42874a.n("RemoteModelUtils", "Model downloaded without its beginning time recorded.");
            } else {
                zcdVar.e(Long.valueOf(SystemClock.elapsedRealtime() - j2));
            }
        }
        return zcdVar.i();
    }
}
