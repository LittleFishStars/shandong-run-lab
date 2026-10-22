package com.kwad.sdk.core.adlog.c;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.utils.al;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b {
    private final a aMU = new a();

    public final a Jh() {
        return this.aMU;
    }

    public final b aC(long j) {
        this.aMU.zV = j;
        return this;
    }

    public final b b(com.kwad.sdk.core.adlog.a.C1273a c1273a) {
        this.aMU.QZ = c1273a;
        return this;
    }

    public final b ec(int i) {
        this.aMU.nm = i;
        return this;
    }

    public final b ed(int i) {
        this.aMU.aMh = i;
        return this;
    }

    public final b ee(int i) {
        this.aMU.aMi = i;
        return this;
    }

    public final b ef(int i) {
        this.aMU.downloadSource = i;
        return this;
    }

    public final b eg(int i) {
        this.aMU.aMA = i;
        return this;
    }

    public final b eh(int i) {
        this.aMU.aMD = i;
        return this;
    }

    public final b ei(int i) {
        this.aMU.aME = i;
        return this;
    }

    public final b ej(int i) {
        this.aMU.aMs = i;
        return this;
    }

    public final b ek(int i) {
        this.aMU.aMK = i;
        return this;
    }

    public final b el(int i) {
        this.aMU.aMO = i;
        return this;
    }

    public final b em(int i) {
        this.aMU.dV(i);
        return this;
    }

    public final b en(int i) {
        this.aMU.aMQ = i;
        return this;
    }

    public final b eo(int i) {
        this.aMU.Rb = i;
        return this;
    }

    public final b ep(int i) {
        this.aMU.aMS = i;
        return this;
    }

    public final b eq(int i) {
        this.aMU.Ra = i;
        return this;
    }

    public final b er(int i) {
        this.aMU.aMv = i;
        return this;
    }

    public final b f(al.a aVar) {
        this.aMU.no = aVar;
        return this;
    }

    public final b j(double d) {
        this.aMU.np = d;
        return this;
    }

    public final b z(int i, int i2) {
        this.aMU.aMj = i + "," + i2;
        return this;
    }

    public final b b(AdTemplate adTemplate, String str, String str2, com.kwad.sdk.g.a<AdTrackLog> aVar) {
        a aVar2 = this.aMU;
        if (aVar2.QZ == null) {
            aVar2.QZ = new com.kwad.sdk.core.adlog.a.C1273a();
        }
        this.aMU.QZ.a(adTemplate, str, str2, aVar);
        return this;
    }

    public final b ec(String str) {
        this.aMU.QY = str;
        return this;
    }

    public final b ed(String str) {
        this.aMU.aMB = str;
        return this;
    }

    public final b ee(String str) {
        this.aMU.aMC = str;
        return this;
    }

    public final b ef(String str) {
        this.aMU.aMM = str;
        return this;
    }
}
