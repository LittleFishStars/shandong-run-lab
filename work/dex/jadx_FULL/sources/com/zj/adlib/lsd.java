package com.zj.adlib;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.camera.video.AudioStats;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_vision_barcode.zzbz;
import com.google.android.gms.internal.mlkit_vision_barcode.zzcv;
import com.google.android.gms.internal.mlkit_vision_barcode.zzcx;
import com.google.android.gms.internal.mlkit_vision_barcode.zzdb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzpk;
import com.google.android.gms.internal.mlkit_vision_barcode.zztm;
import com.google.android.gms.internal.mlkit_vision_barcode.zztn;
import com.google.android.gms.internal.mlkit_vision_barcode.zztw;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.sdkinternal.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class lsd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static zzcv f43143a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final zzcx f18038a = zzcx.zzc("optional-module-barcode", kd6.f17644b);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f18039a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zztn f18040a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Task f18041a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final e98 f18042a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f18043a;
    public final Task b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String f18045b;
    public final String c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map f18044a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Map f18046b = new HashMap();

    public lsd(Context context, final e98 e98Var, zztn zztnVar, String str) {
        this.f18043a = context.getPackageName();
        this.f18045b = mq1.a(context);
        this.f18042a = e98Var;
        this.f18040a = zztnVar;
        ftd.a();
        this.c = str;
        this.f18041a = b.b().c(new Callable() { // from class: com.zj.adlib.gsd
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f41979a.b();
            }
        });
        b bVarB = b.b();
        e98Var.getClass();
        this.b = bVarB.c(new Callable() { // from class: com.zj.adlib.hsd
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return e98Var.i();
            }
        });
        zzcx zzcxVar = f18038a;
        this.f18039a = zzcxVar.containsKey(str) ? DynamiteModule.c(context, (String) zzcxVar.get(str)) : -1;
    }

    @VisibleForTesting
    public static long a(List list, double d) {
        return ((Long) list.get(Math.max(((int) Math.ceil((d / 100.0d) * ((double) list.size()))) - 1, 0))).longValue();
    }

    @NonNull
    public static synchronized zzcv i() {
        zzcv zzcvVar = f43143a;
        if (zzcvVar != null) {
            return zzcvVar;
        }
        LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
        ugc ugcVar = new ugc();
        for (int i = 0; i < locales.size(); i++) {
            ugcVar.e(mq1.b(locales.get(i)));
        }
        zzcv zzcvVarG = ugcVar.g();
        f43143a = zzcvVarG;
        return zzcvVarG;
    }

    public final /* synthetic */ String b() throws Exception {
        return cx4.a().b(this.c);
    }

    public final /* synthetic */ void c(zztm zztmVar, zzpk zzpkVar, String str) {
        zztmVar.c(zzpkVar);
        String strA = zztmVar.a();
        vqd vqdVar = new vqd();
        vqdVar.b(this.f18043a);
        vqdVar.c(this.f18045b);
        vqdVar.h(i());
        vqdVar.g(Boolean.TRUE);
        vqdVar.l(strA);
        vqdVar.j(str);
        vqdVar.i(this.b.v() ? (String) this.b.r() : this.f18042a.i());
        vqdVar.d(10);
        vqdVar.k(Integer.valueOf(this.f18039a));
        zztmVar.d(vqdVar);
        this.f18040a.a(zztmVar);
    }

    public final void d(zztm zztmVar, zzpk zzpkVar) {
        e(zztmVar, zzpkVar, j());
    }

    public final void e(final zztm zztmVar, final zzpk zzpkVar, final String str) {
        b.g().execute(new Runnable() { // from class: com.zj.adlib.isd
            @Override // java.lang.Runnable
            public final void run() {
                this.f17265a.c(zztmVar, zzpkVar, str);
            }
        });
    }

    @WorkerThread
    public final void f(zztw zztwVar, zzpk zzpkVar) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (k(zzpkVar, jElapsedRealtime, 30L)) {
            this.f18044a.put(zzpkVar, Long.valueOf(jElapsedRealtime));
            e(zztwVar.a(), zzpkVar, j());
        }
    }

    public final /* synthetic */ void g(zzpk zzpkVar, s3d s3dVar) {
        zzdb zzdbVar = (zzdb) this.f18046b.get(zzpkVar);
        if (zzdbVar != null) {
            for (Object obj : zzdbVar.zzw()) {
                ArrayList arrayList = new ArrayList(zzdbVar.zze(obj));
                Collections.sort(arrayList);
                dkd dkdVar = new dkd();
                Iterator it = arrayList.iterator();
                long jLongValue = 0;
                while (it.hasNext()) {
                    jLongValue += ((Long) it.next()).longValue();
                }
                dkdVar.a(Long.valueOf(jLongValue / ((long) arrayList.size())));
                dkdVar.c(Long.valueOf(a(arrayList, 100.0d)));
                dkdVar.f(Long.valueOf(a(arrayList, 75.0d)));
                dkdVar.d(Long.valueOf(a(arrayList, 50.0d)));
                dkdVar.b(Long.valueOf(a(arrayList, 25.0d)));
                dkdVar.e(Long.valueOf(a(arrayList, AudioStats.AUDIO_AMPLITUDE_NONE)));
                e(s3dVar.a(obj, arrayList.size(), dkdVar.g()), zzpkVar, j());
            }
            this.f18046b.remove(zzpkVar);
        }
    }

    public final /* synthetic */ void h(final zzpk zzpkVar, Object obj, long j, final s3d s3dVar) {
        if (!this.f18046b.containsKey(zzpkVar)) {
            this.f18046b.put(zzpkVar, zzbz.zzz());
        }
        ((zzdb) this.f18046b.get(zzpkVar)).zzt(obj, Long.valueOf(j));
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (k(zzpkVar, jElapsedRealtime, 30L)) {
            this.f18044a.put(zzpkVar, Long.valueOf(jElapsedRealtime));
            b.g().execute(new Runnable() { // from class: com.zj.adlib.ksd
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17782a.g(zzpkVar, s3dVar);
                }
            });
        }
    }

    @WorkerThread
    public final String j() {
        return this.f18041a.v() ? (String) this.f18041a.r() : cx4.a().b(this.c);
    }

    @WorkerThread
    public final boolean k(zzpk zzpkVar, long j, long j2) {
        return this.f18044a.get(zzpkVar) == null || j - ((Long) this.f18044a.get(zzpkVar)).longValue() > TimeUnit.SECONDS.toMillis(30L);
    }
}
