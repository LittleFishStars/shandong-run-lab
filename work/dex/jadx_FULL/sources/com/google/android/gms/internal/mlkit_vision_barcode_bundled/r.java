package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.r;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class r<MessageType extends zzed<MessageType, BuilderType>, BuilderType extends r<MessageType, BuilderType>> extends zzcj<MessageType, BuilderType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzed f31392a;
    public zzed b;

    public r(MessageType messagetype) {
        this.f31392a = messagetype;
        if (messagetype.q()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.b = messagetype.m();
    }

    public static void n(Object obj, Object obj2) {
        g0.a().b(obj.getClass()).d(obj, obj2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp
    public final /* bridge */ /* synthetic */ zzfo a() {
        throw null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp
    public final boolean i() {
        return zzed.zzW(this.b, false);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcj
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final r clone() {
        r rVar = (r) this.f31392a.zzg(5, null, null);
        rVar.b = K1();
        return rVar;
    }

    public final r p(zzed zzedVar) {
        if (!this.f31392a.equals(zzedVar)) {
            if (!this.b.q()) {
                zzn();
            }
            n(this.b, zzedVar);
        }
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public final MessageType L1() {
        MessageType messagetype = (MessageType) K1();
        if (messagetype.i()) {
            return messagetype;
        }
        throw new zzgx(messagetype);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public MessageType K1() {
        if (!this.b.q()) {
            return (MessageType) this.b;
        }
        this.b.zzS();
        return (MessageType) this.b;
    }

    public final void zzm() {
        if (this.b.q()) {
            return;
        }
        zzn();
    }

    public void zzn() {
        zzed zzedVarM = this.f31392a.m();
        n(zzedVarM, this.b);
        this.b = zzedVarM;
    }
}
