package com.zj.adlib;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_vision_common.zzii;
import com.google.android.gms.internal.mlkit_vision_common.zzio;
import com.google.android.gms.internal.mlkit_vision_common.zziv;
import com.google.android.gms.internal.mlkit_vision_common.zzmb;
import com.google.android.gms.internal.mlkit_vision_common.zzmc;
import com.google.android.gms.internal.mlkit_vision_common.zzp;
import com.google.android.gms.internal.mlkit_vision_common.zzr;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.sdkinternal.b;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class bfd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static zzp f40744a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final zzr f15512a = zzr.zzc("optional-module-barcode", kd6.f17644b);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f15513a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zzmc f15514a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Task f15515a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final e98 f15516a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f15517a;
    public final Task b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String f15519b;
    public final String c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map f15518a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Map f15520b = new HashMap();

    public bfd(Context context, final e98 e98Var, zzmc zzmcVar, String str) {
        this.f15517a = context.getPackageName();
        this.f15519b = mq1.a(context);
        this.f15516a = e98Var;
        this.f15514a = zzmcVar;
        ogd.a();
        this.c = str;
        this.f15515a = b.b().c(new Callable() { // from class: com.zj.adlib.sed
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f44677a.a();
            }
        });
        b bVarB = b.b();
        e98Var.getClass();
        this.b = bVarB.c(new Callable() { // from class: com.zj.adlib.ved
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return e98Var.i();
            }
        });
        zzr zzrVar = f15512a;
        this.f15513a = zzrVar.containsKey(str) ? DynamiteModule.c(context, (String) zzrVar.get(str)) : -1;
    }

    @NonNull
    public static synchronized zzp d() {
        zzp zzpVar = f40744a;
        if (zzpVar != null) {
            return zzpVar;
        }
        LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
        wdd wddVar = new wdd();
        for (int i = 0; i < locales.size(); i++) {
            wddVar.c(mq1.b(locales.get(i)));
        }
        zzp zzpVarD = wddVar.d();
        f40744a = zzpVarD;
        return zzpVarD;
    }

    public final /* synthetic */ String a() throws Exception {
        return cx4.a().b(this.c);
    }

    public final /* synthetic */ void b(zzmb zzmbVar, zziv zzivVar, String str) {
        zzmbVar.a(zzivVar);
        String strB = zzmbVar.b();
        qad qadVar = new qad();
        qadVar.b(this.f15517a);
        qadVar.c(this.f15519b);
        qadVar.h(d());
        qadVar.g(Boolean.TRUE);
        qadVar.l(strB);
        qadVar.j(str);
        qadVar.i(this.b.v() ? (String) this.b.r() : this.f15516a.i());
        qadVar.d(10);
        qadVar.k(Integer.valueOf(this.f15513a));
        zzmbVar.d(qadVar);
        this.f15514a.a(zzmbVar);
    }

    @WorkerThread
    public final void c(fgd fgdVar, final zziv zzivVar) {
        zzii zziiVar;
        zzio zzioVar;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f15518a.get(zzivVar) != null && jElapsedRealtime - ((Long) this.f15518a.get(zzivVar)).longValue() <= TimeUnit.SECONDS.toMillis(30L)) {
            return;
        }
        this.f15518a.put(zzivVar, Long.valueOf(jElapsedRealtime));
        int i = fgdVar.f41671a;
        int i2 = fgdVar.b;
        int i3 = fgdVar.c;
        int i4 = fgdVar.d;
        int i5 = fgdVar.e;
        long j = fgdVar.f16525a;
        int i6 = fgdVar.f;
        v1d v1dVar = new v1d();
        if (i == -1) {
            zziiVar = zzii.BITMAP;
        } else if (i == 35) {
            zziiVar = zzii.YUV_420_888;
        } else if (i == 842094169) {
            zziiVar = zzii.YV12;
        } else if (i != 16) {
            zziiVar = i != 17 ? zzii.UNKNOWN_FORMAT : zzii.NV21;
        } else {
            zziiVar = zzii.NV16;
        }
        v1dVar.d(zziiVar);
        if (i2 == 1) {
            zzioVar = zzio.BITMAP;
        } else if (i2 == 2) {
            zzioVar = zzio.BYTEARRAY;
        } else if (i2 != 3) {
            zzioVar = i2 != 4 ? zzio.ANDROID_MEDIA_IMAGE : zzio.FILEPATH;
        } else {
            zzioVar = zzio.BYTEBUFFER;
        }
        v1dVar.f(zzioVar);
        v1dVar.c(Integer.valueOf(i3));
        v1dVar.e(Integer.valueOf(i4));
        v1dVar.g(Integer.valueOf(i5));
        v1dVar.b(Long.valueOf(j));
        v1dVar.h(Integer.valueOf(i6));
        f2d f2dVarJ = v1dVar.j();
        a3d a3dVar = new a3d();
        a3dVar.d(f2dVarJ);
        final zzmb zzmbVarE = efd.e(a3dVar);
        final String strB = this.f15515a.v() ? (String) this.f15515a.r() : cx4.a().b(this.c);
        b.g().execute(new Runnable() { // from class: com.zj.adlib.yed
            @Override // java.lang.Runnable
            public final void run() {
                this.f20845a.b(zzmbVarE, zzivVar, strB);
            }
        });
    }
}
