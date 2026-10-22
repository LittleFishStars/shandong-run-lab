package com.google.mlkit.common.sdkinternal.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.mlkit_common.zzlm;
import com.google.android.gms.internal.mlkit_common.zzls;
import com.google.android.gms.internal.mlkit_common.zzpq;
import com.google.android.gms.internal.mlkit_common.zzqa;
import com.google.android.gms.internal.mlkit_common.zzqb;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.RemoteModel;
import com.zj.adlib.hnd;
import com.zj.adlib.jec;
import com.zj.adlib.snd;
import com.zj.adlib.z09;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@WorkerThread
final class zzd extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f32465a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ a f6666a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z09 f6667a;

    public /* synthetic */ zzd(a aVar, long j, z09 z09Var, jec jecVar) {
        this.f6666a = aVar;
        this.f32465a = j;
        this.f6667a = z09Var;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        long longExtra = intent.getLongExtra("extra_download_id", -1L);
        if (longExtra != this.f32465a) {
            return;
        }
        Integer numE = this.f6666a.e();
        synchronized (this.f6666a) {
            try {
                this.f6666a.f6656a.b().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                a.f32463a.o("ModelDownloadManager", "Exception thrown while trying to unregister the broadcast receiver for the download", e);
            }
            this.f6666a.f6649a.remove(this.f32465a);
            this.f6666a.b.remove(this.f32465a);
        }
        if (numE != null) {
            if (numE.intValue() == 16) {
                hnd hndVar = this.f6666a.f6655a;
                zzpq zzpqVarG = snd.g();
                a aVar = this.f6666a;
                RemoteModel remoteModel = aVar.f6650a;
                Long lValueOf = Long.valueOf(longExtra);
                hndVar.e(zzpqVarG, remoteModel, false, aVar.f(lValueOf));
                this.f6667a.b(this.f6666a.x(lValueOf));
                return;
            }
            if (numE.intValue() == 8) {
                hnd hndVar2 = this.f6666a.f6655a;
                zzpq zzpqVarG2 = snd.g();
                RemoteModel remoteModel2 = this.f6666a.f6650a;
                zzqa zzqaVarH = zzqb.h();
                zzqaVarH.b(zzlm.NO_ERROR);
                zzqaVarH.e(true);
                zzqaVarH.d(this.f6666a.f6650a.e());
                zzqaVarH.a(zzls.SUCCEEDED);
                hndVar2.g(zzpqVarG2, remoteModel2, zzqaVarH.g());
                this.f6667a.setResult(null);
                return;
            }
        }
        this.f6666a.f6655a.e(snd.g(), this.f6666a.f6650a, false, 0);
        this.f6667a.b(new MlKitException("Model downloading failed", 13));
    }
}
