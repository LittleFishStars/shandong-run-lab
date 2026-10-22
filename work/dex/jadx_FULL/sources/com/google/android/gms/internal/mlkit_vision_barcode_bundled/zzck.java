package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcj;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzck;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class zzck<MessageType extends zzck<MessageType, BuilderType>, BuilderType extends zzcj<MessageType, BuilderType>> implements zzfo {
    protected int zzb = 0;

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfo
    public final zzdb b() {
        try {
            int iL = l();
            zzdb zzdbVar = zzdb.zzb;
            byte[] bArr = new byte[iL];
            zzdj zzdjVarA = zzdj.a(bArr, 0, iL);
            k(zzdjVarA);
            zzdjVarA.b();
            return new zzcy(bArr);
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    public int c(zzgh zzghVar) {
        throw null;
    }
}
