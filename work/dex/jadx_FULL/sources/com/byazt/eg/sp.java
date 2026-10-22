package com.byazt.eg;

import com.zj.adlib.u15;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 16, 91})
public final class sp {
    public static final sp c = new c().c();
    public final Set<tt> tt;
    public final com.byazt.wt.ve ve;

    @com.byazt.zqa.c(c = {0, 1, 16, 180})
    public static final class c {
        public final List<tt> c = new ArrayList();

        public sp c() {
            return new sp(new LinkedHashSet(this.c), null);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 16, 904})
    public static final class tt {
        public final String c;
        public final String tt;
        public final com.byazt.mk.a uj;
        public final String ve;

        public boolean c(String str) {
            if (!this.c.startsWith("*.")) {
                return str.equals(this.tt);
            }
            int iIndexOf = str.indexOf(46);
            if ((str.length() - iIndexOf) - 1 != this.tt.length()) {
                return false;
            }
            String str2 = this.tt;
            return str.regionMatches(false, iIndexOf + 1, str2, 0, str2.length());
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof tt)) {
                return false;
            }
            tt ttVar = (tt) obj;
            return this.c.equals(ttVar.c) && this.ve.equals(ttVar.ve) && this.uj.equals(ttVar.uj);
        }

        public int hashCode() {
            return ((((this.c.hashCode() + 527) * 31) + this.ve.hashCode()) * 31) + this.uj.hashCode();
        }

        public String toString() {
            return this.ve + this.uj.tt();
        }
    }

    public sp(Set<tt> set, com.byazt.wt.ve veVar) {
        this.tt = set;
        this.ve = veVar;
    }

    public static com.byazt.mk.a tt(X509Certificate x509Certificate) {
        return com.byazt.mk.a.c(x509Certificate.getPublicKey().getEncoded()).uj();
    }

    public void c(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<tt> listC = c(str);
        if (listC.isEmpty()) {
            return;
        }
        com.byazt.wt.ve veVar = this.ve;
        if (veVar != null) {
            list = veVar.c(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i);
            int size2 = listC.size();
            com.byazt.mk.a aVarTt = null;
            com.byazt.mk.a aVarC = null;
            for (int i2 = 0; i2 < size2; i2++) {
                tt ttVar = listC.get(i2);
                if (ttVar.ve.equals("sha256/")) {
                    if (aVarTt == null) {
                        aVarTt = tt(x509Certificate);
                    }
                    if (ttVar.uj.equals(aVarTt)) {
                        return;
                    }
                } else {
                    if (!ttVar.ve.equals("sha1/")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + ttVar.ve);
                    }
                    if (aVarC == null) {
                        aVarC = c(x509Certificate);
                    }
                    if (ttVar.uj.equals(aVarC)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
            sb.append("\n    ");
            sb.append(c((Certificate) x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(u15.f19942b);
        int size4 = listC.size();
        for (int i4 = 0; i4 < size4; i4++) {
            tt ttVar2 = listC.get(i4);
            sb.append("\n    ");
            sb.append(ttVar2);
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof sp)) {
            return false;
        }
        sp spVar = (sp) obj;
        return com.byazt.kh.ve.c(this.ve, spVar.ve) && this.tt.equals(spVar.tt);
    }

    public int hashCode() {
        com.byazt.wt.ve veVar = this.ve;
        return ((veVar != null ? veVar.hashCode() : 0) * 31) + this.tt.hashCode();
    }

    public List<tt> c(String str) {
        List<tt> listEmptyList = Collections.emptyList();
        for (tt ttVar : this.tt) {
            if (ttVar.c(str)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList<>();
                }
                listEmptyList.add(ttVar);
            }
        }
        return listEmptyList;
    }

    public sp c(com.byazt.wt.ve veVar) {
        return com.byazt.kh.ve.c(this.ve, veVar) ? this : new sp(this.tt, veVar);
    }

    public static String c(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + tt((X509Certificate) certificate).tt();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    public static com.byazt.mk.a c(X509Certificate x509Certificate) {
        return com.byazt.mk.a.c(x509Certificate.getPublicKey().getEncoded()).ve();
    }
}
