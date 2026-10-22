package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_common.zziv;
import com.google.android.gms.internal.mlkit_vision_common.zzmb;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class efd implements zzmb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a3d f41430a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public qad f16308a = new qad();

    public efd(a3d a3dVar, int i) {
        this.f41430a = a3dVar;
        ogd.a();
    }

    public static zzmb e(a3d a3dVar) {
        return new efd(a3dVar, 0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzmb
    public final zzmb a(zziv zzivVar) {
        this.f41430a.c(zzivVar);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzmb
    public final String b() {
        cbd cbdVarC = this.f41430a.f().c();
        return (cbdVarC == null || yrc.b(cbdVarC.k())) ? "NA" : (String) yw6.l(cbdVarC.k());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzmb
    public final byte[] c(int i, boolean z) {
        this.f16308a.f(Boolean.valueOf(1 == (i ^ 1)));
        this.f16308a.e(Boolean.FALSE);
        this.f41430a.e(this.f16308a.m());
        try {
            ogd.a();
            if (i == 0) {
                return new JsonDataEncoderBuilder().configureWith(vwc.f45476a).ignoreNullValues(true).build().encode(this.f41430a.f()).getBytes("utf-8");
            }
            i3d i3dVarF = this.f41430a.f();
            r9c r9cVar = new r9c();
            vwc.f45476a.configure(r9cVar);
            return r9cVar.a().a(i3dVarF);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzmb
    public final zzmb d(qad qadVar) {
        this.f16308a = qadVar;
        return this;
    }
}
