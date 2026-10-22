package com.zj.adlib;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.runtime.h;
import com.google.android.gms.internal.mlkit_vision_common.zzmb;
import com.google.android.gms.internal.mlkit_vision_common.zzmc;
import com.google.android.gms.internal.mlkit_vision_common.zzme;
import com.google.firebase.components.Lazy;
import com.google.firebase.inject.Provider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class tfd implements zzmc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzme f44909a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Provider f19788a;
    public final Provider b;

    public tfd(Context context, zzme zzmeVar) {
        this.f44909a = zzmeVar;
        o61 o61Var = o61.f43676a;
        h.f(context);
        final TransportFactory transportFactoryG = h.c().g(o61Var);
        if (o61Var.a().contains(f33.b("json"))) {
            this.f19788a = new Lazy(new Provider() { // from class: com.zj.adlib.kfd
                @Override // com.google.firebase.inject.Provider
                public final Object get() {
                    return transportFactoryG.a("FIREBASE_ML_SDK", byte[].class, f33.b("json"), new Transformer() { // from class: com.zj.adlib.qfd
                        @Override // com.google.android.datatransport.Transformer
                        public final Object apply(Object obj) {
                            return (byte[]) obj;
                        }
                    });
                }
            });
        }
        this.b = new Lazy(new Provider() { // from class: com.zj.adlib.nfd
            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                return transportFactoryG.a("FIREBASE_ML_SDK", byte[].class, f33.b("proto"), new Transformer() { // from class: com.zj.adlib.hfd
                    @Override // com.google.android.datatransport.Transformer
                    public final Object apply(Object obj) {
                        return (byte[]) obj;
                    }
                });
            }
        });
    }

    @VisibleForTesting
    public static Event b(zzme zzmeVar, zzmb zzmbVar) {
        return Event.g(zzmbVar.c(zzmeVar.a(), false));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzmc
    public final void a(zzmb zzmbVar) {
        if (this.f44909a.a() != 0) {
            ((Transport) this.b.get()).b(b(this.f44909a, zzmbVar));
            return;
        }
        Provider provider = this.f19788a;
        if (provider != null) {
            ((Transport) provider.get()).b(b(this.f44909a, zzmbVar));
        }
    }
}
