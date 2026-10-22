package com.zj.adlib;

import com.google.android.gms.internal.mlkit_common.zzln;
import com.google.android.gms.internal.mlkit_common.zzpq;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class snd implements zzpq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ikd f44727a = new ikd();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final qcd f19614a;

    public snd(qcd qcdVar, int i) {
        this.f19614a = qcdVar;
        ood.a();
    }

    public static zzpq f(qcd qcdVar) {
        return new snd(qcdVar, 0);
    }

    public static zzpq g() {
        return new snd(new qcd(), 0);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpq
    public final String a() {
        mkd mkdVarF = this.f19614a.k().f();
        return (mkdVarF == null || s8c.c(mkdVarF.k())) ? "NA" : (String) yw6.l(mkdVarF.k());
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpq
    public final byte[] b(int i, boolean z) {
        this.f44727a.f(Boolean.valueOf(1 == (i ^ 1)));
        this.f44727a.e(Boolean.FALSE);
        this.f19614a.j(this.f44727a.m());
        try {
            ood.a();
            if (i == 0) {
                return new JsonDataEncoderBuilder().configureWith(s5d.f44615a).ignoreNullValues(true).build().encode(this.f19614a.k()).getBytes("utf-8");
            }
            wcd wcdVarK = this.f19614a.k();
            hdc hdcVar = new hdc();
            s5d.f44615a.configure(hdcVar);
            return hdcVar.a().a(wcdVarK);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpq
    public final zzpq c(ikd ikdVar) {
        this.f44727a = ikdVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpq
    public final zzpq d(hdd hddVar) {
        this.f19614a.i(hddVar);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzpq
    public final zzpq e(zzln zzlnVar) {
        this.f19614a.f(zzlnVar);
        return this;
    }
}
