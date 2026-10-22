package com.zj.adlib;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.runtime.h;
import com.google.android.gms.internal.mlkit_common.zzpq;
import com.google.android.gms.internal.mlkit_common.zzpr;
import com.google.android.gms.internal.mlkit_common.zzpt;
import com.google.firebase.components.Lazy;
import com.google.firebase.inject.Provider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class cod implements zzpr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzpt f41014a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Provider f15868a;
    public final Provider b;

    public cod(Context context, zzpt zzptVar) {
        this.f41014a = zzptVar;
        o61 o61Var = o61.f43676a;
        h.f(context);
        final TransportFactory transportFactoryG = h.c().g(o61Var);
        if (o61Var.a().contains(f33.b("json"))) {
            this.f15868a = new Lazy(new Provider() { // from class: com.zj.adlib.wnd
                @Override // com.google.firebase.inject.Provider
                public final Object get() {
                    return transportFactoryG.a("FIREBASE_ML_SDK", byte[].class, f33.b("json"), new Transformer() { // from class: com.zj.adlib.aod
                        @Override // com.google.android.datatransport.Transformer
                        public final Object apply(Object obj) {
                            return (byte[]) obj;
                        }
                    });
                }
            });
        }
        this.b = new Lazy(new Provider() { // from class: com.zj.adlib.ynd
            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                return transportFactoryG.a("FIREBASE_ML_SDK", byte[].class, f33.b("proto"), new Transformer() { // from class: com.zj.adlib.und
                    @Override // com.google.android.datatransport.Transformer
                    public final Object apply(Object obj) {
                        return (byte[]) obj;
                    }
                });
            }
        });
    }

    @VisibleForTesting
    public static Event b(zzpt zzptVar, zzpq zzpqVar) {
        return Event.g(zzpqVar.b(zzptVar.a(), false));
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpr
    public final void a(zzpq zzpqVar) {
        if (this.f41014a.a() != 0) {
            ((Transport) this.b.get()).b(b(this.f41014a, zzpqVar));
            return;
        }
        Provider provider = this.f15868a;
        if (provider != null) {
            ((Transport) provider.get()).b(b(this.f41014a, zzpqVar));
        }
    }
}
