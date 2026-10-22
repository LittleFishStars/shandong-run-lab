package com.byazt.eg;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 16, 137})
public final class nu {
    public final zb c;
    public final x tt;
    public final List<Certificate> uj;
    public final List<Certificate> ve;

    private nu(zb zbVar, x xVar, List<Certificate> list, List<Certificate> list2) {
        this.c = zbVar;
        this.tt = xVar;
        this.ve = list;
        this.uj = list2;
    }

    public static nu c(SSLSession sSLSession) {
        String cipherSuite;
        Certificate[] peerCertificates = null;
        try {
            cipherSuite = sSLSession.getCipherSuite();
        } catch (Exception unused) {
            cipherSuite = null;
        }
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        x xVarC = x.c(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        zb zbVarC = zb.c(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused2) {
        }
        List listC = peerCertificates != null ? com.byazt.kh.ve.c(peerCertificates) : Collections.emptyList();
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new nu(zbVarC, xVarC, listC, localCertificates != null ? com.byazt.kh.ve.c(localCertificates) : Collections.emptyList());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof nu)) {
            return false;
        }
        nu nuVar = (nu) obj;
        return this.c.equals(nuVar.c) && this.tt.equals(nuVar.tt) && this.ve.equals(nuVar.ve) && this.uj.equals(nuVar.uj);
    }

    public int hashCode() {
        return ((((((this.c.hashCode() + 527) * 31) + this.tt.hashCode()) * 31) + this.ve.hashCode()) * 31) + this.uj.hashCode();
    }

    public x tt() {
        return this.tt;
    }

    public List<Certificate> uj() {
        return this.uj;
    }

    public List<Certificate> ve() {
        return this.ve;
    }

    public zb c() {
        return this.c;
    }
}
