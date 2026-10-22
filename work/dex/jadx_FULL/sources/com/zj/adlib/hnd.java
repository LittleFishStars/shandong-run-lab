package com.zj.adlib;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_common.zzar;
import com.google.android.gms.internal.mlkit_common.zzau;
import com.google.android.gms.internal.mlkit_common.zzlm;
import com.google.android.gms.internal.mlkit_common.zzln;
import com.google.android.gms.internal.mlkit_common.zzls;
import com.google.android.gms.internal.mlkit_common.zzpq;
import com.google.android.gms.internal.mlkit_common.zzpr;
import com.google.android.gms.internal.mlkit_common.zzqa;
import com.google.android.gms.internal.mlkit_common.zzqb;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.b;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class hnd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static zzar f42167a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final zzau f17030a = zzau.zzc("optional-module-barcode", kd6.f17644b);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f17031a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zzpr f17032a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Task f17033a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final e98 f17034a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f17035a;
    public final Task b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String f17037b;
    public final String c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map f17036a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Map f17038b = new HashMap();

    public hnd(Context context, final e98 e98Var, zzpr zzprVar, String str) {
        this.f17035a = context.getPackageName();
        this.f17037b = mq1.a(context);
        this.f17034a = e98Var;
        this.f17032a = zzprVar;
        ood.a();
        this.c = str;
        this.f17033a = b.b().c(new Callable() { // from class: com.zj.adlib.and
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f40565a.a();
            }
        });
        b bVarB = b.b();
        e98Var.getClass();
        this.b = bVarB.c(new Callable() { // from class: com.zj.adlib.bnd
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return e98Var.i();
            }
        });
        zzau zzauVar = f17030a;
        this.f17031a = zzauVar.containsKey(str) ? DynamiteModule.c(context, (String) zzauVar.get(str)) : -1;
    }

    @NonNull
    public static synchronized zzar h() {
        zzar zzarVar = f42167a;
        if (zzarVar != null) {
            return zzarVar;
        }
        LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
        aac aacVar = new aac();
        for (int i = 0; i < locales.size(); i++) {
            aacVar.b(mq1.b(locales.get(i)));
        }
        zzar zzarVarC = aacVar.c();
        f42167a = zzarVarC;
        return zzarVarC;
    }

    public final /* synthetic */ String a() throws Exception {
        return cx4.a().b(this.c);
    }

    public final /* synthetic */ void b(zzpq zzpqVar, zzln zzlnVar, String str) {
        zzpqVar.e(zzlnVar);
        zzpqVar.c(i(zzpqVar.a(), str));
        this.f17032a.a(zzpqVar);
    }

    public final /* synthetic */ void c(zzpq zzpqVar, zzqb zzqbVar, RemoteModel remoteModel) {
        zzpqVar.e(zzln.MODEL_DOWNLOAD);
        zzpqVar.c(i(zzqbVar.e(), j()));
        zzpqVar.d(kod.a(remoteModel, this.f17034a, zzqbVar));
        this.f17032a.a(zzpqVar);
    }

    public final void d(final zzpq zzpqVar, final zzln zzlnVar) {
        final String strJ = j();
        b.g().execute(new Runnable() { // from class: com.zj.adlib.dnd
            @Override // java.lang.Runnable
            public final void run() {
                this.f16050a.b(zzpqVar, zzlnVar, strJ);
            }
        });
    }

    public final void e(zzpq zzpqVar, RemoteModel remoteModel, boolean z, int i) {
        zzqa zzqaVarH = zzqb.h();
        zzqaVarH.f(false);
        zzqaVarH.d(remoteModel.e());
        zzqaVarH.a(zzls.FAILED);
        zzqaVarH.b(zzlm.DOWNLOAD_FAILED);
        zzqaVarH.c(i);
        g(zzpqVar, remoteModel, zzqaVarH.g());
    }

    public final void f(zzpq zzpqVar, RemoteModel remoteModel, zzlm zzlmVar, boolean z, ModelType modelType, zzls zzlsVar) {
        zzqa zzqaVarH = zzqb.h();
        zzqaVarH.f(z);
        zzqaVarH.d(modelType);
        zzqaVarH.b(zzlmVar);
        zzqaVarH.a(zzlsVar);
        g(zzpqVar, remoteModel, zzqaVarH.g());
    }

    public final void g(final zzpq zzpqVar, final RemoteModel remoteModel, final zzqb zzqbVar) {
        b.g().execute(new Runnable() { // from class: com.zj.adlib.fnd
            @Override // java.lang.Runnable
            public final void run() {
                this.f16589a.c(zzpqVar, zzqbVar, remoteModel);
            }
        });
    }

    public final ikd i(String str, String str2) {
        ikd ikdVar = new ikd();
        ikdVar.b(this.f17035a);
        ikdVar.c(this.f17037b);
        ikdVar.h(h());
        ikdVar.g(Boolean.TRUE);
        ikdVar.l(str);
        ikdVar.j(str2);
        ikdVar.i(this.b.v() ? (String) this.b.r() : this.f17034a.i());
        ikdVar.d(10);
        ikdVar.k(Integer.valueOf(this.f17031a));
        return ikdVar;
    }

    @WorkerThread
    public final String j() {
        return this.f17033a.v() ? (String) this.f17033a.r() : cx4.a().b(this.c);
    }
}
