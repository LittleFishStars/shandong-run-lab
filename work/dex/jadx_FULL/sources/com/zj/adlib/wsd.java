package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode.zzpk;
import com.google.android.gms.internal.mlkit_vision_barcode.zztm;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class wsd implements zztm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f45684a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final kmd f20537a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public vqd f20538a = new vqd();

    public wsd(kmd kmdVar, int i) {
        this.f20537a = kmdVar;
        ftd.a();
        this.f45684a = i;
    }

    public static zztm e(kmd kmdVar) {
        return new wsd(kmdVar, 0);
    }

    public static zztm f(kmd kmdVar, int i) {
        return new wsd(kmdVar, 1);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zztm
    public final String a() {
        xqd xqdVarG = this.f20537a.k().g();
        return (xqdVarG == null || zbc.c(xqdVarG.k())) ? "NA" : (String) yw6.l(xqdVarG.k());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zztm
    public final byte[] b(int i, boolean z) {
        this.f20538a.f(Boolean.valueOf(1 == (i ^ 1)));
        this.f20538a.e(Boolean.FALSE);
        this.f20537a.j(this.f20538a.m());
        try {
            ftd.a();
            if (i == 0) {
                return new JsonDataEncoderBuilder().configureWith(vhd.f45356a).ignoreNullValues(true).build().encode(this.f20537a.k()).getBytes("utf-8");
            }
            omd omdVarK = this.f20537a.k();
            tpc tpcVar = new tpc();
            vhd.f45356a.configure(tpcVar);
            return tpcVar.a().a(omdVarK);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zztm
    public final zztm c(zzpk zzpkVar) {
        this.f20537a.f(zzpkVar);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zztm
    public final zztm d(vqd vqdVar) {
        this.f20538a = vqdVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zztm
    public final int zza() {
        return this.f45684a;
    }
}
