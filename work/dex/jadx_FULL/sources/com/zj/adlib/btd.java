package com.zj.adlib;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.runtime.h;
import com.google.android.gms.internal.mlkit_vision_barcode.zztm;
import com.google.android.gms.internal.mlkit_vision_barcode.zztn;
import com.google.android.gms.internal.mlkit_vision_barcode.zztp;
import com.google.firebase.components.Lazy;
import com.google.firebase.inject.Provider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class btd implements zztn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zztp f40837a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Provider f15634a;
    public final Provider b;

    public btd(Context context, zztp zztpVar) {
        this.f40837a = zztpVar;
        o61 o61Var = o61.f43676a;
        h.f(context);
        final TransportFactory transportFactoryG = h.c().g(o61Var);
        if (o61Var.a().contains(f33.b("json"))) {
            this.f15634a = new Lazy(new Provider() { // from class: com.zj.adlib.ysd
                @Override // com.google.firebase.inject.Provider
                public final Object get() {
                    return transportFactoryG.a("FIREBASE_ML_SDK", byte[].class, f33.b("json"), new Transformer() { // from class: com.zj.adlib.atd
                        @Override // com.google.android.datatransport.Transformer
                        public final Object apply(Object obj) {
                            return (byte[]) obj;
                        }
                    });
                }
            });
        }
        this.b = new Lazy(new Provider() { // from class: com.zj.adlib.zsd
            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                return transportFactoryG.a("FIREBASE_ML_SDK", byte[].class, f33.b("proto"), new Transformer() { // from class: com.zj.adlib.xsd
                    @Override // com.google.android.datatransport.Transformer
                    public final Object apply(Object obj) {
                        return (byte[]) obj;
                    }
                });
            }
        });
    }

    @VisibleForTesting
    public static Event b(zztp zztpVar, zztm zztmVar) {
        int iA = zztpVar.a();
        return zztmVar.zza() != 0 ? Event.e(zztmVar.b(iA, false)) : Event.g(zztmVar.b(iA, false));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zztn
    public final void a(zztm zztmVar) {
        if (this.f40837a.a() != 0) {
            ((Transport) this.b.get()).b(b(this.f40837a, zztmVar));
            return;
        }
        Provider provider = this.f15634a;
        if (provider != null) {
            ((Transport) provider.get()).b(b(this.f40837a, zztmVar));
        }
    }
}
