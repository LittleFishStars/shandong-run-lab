package com.byazt.eg;

import com.zj.adlib.u15;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 16, 20})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<sl> f28444a;
    public final my c;
    public final HostnameVerifier da;
    public final SSLSocketFactory i;
    public final List<gr> n;
    public final sp sl;
    public final ProxySelector sp;
    public final z tt;
    public final tt uj;
    public final SocketFactory ve;
    public final Proxy x;

    public c(String str, int i, z zVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, sp spVar, tt ttVar, Proxy proxy, List<gr> list, List<sl> list2, ProxySelector proxySelector) {
        this.c = new my.c().c(sSLSocketFactory != null ? "https" : "http").uj(str).c(i).ve();
        if (zVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.tt = zVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.ve = socketFactory;
        if (ttVar == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.uj = ttVar;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.n = com.byazt.kh.ve.c(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f28444a = com.byazt.kh.ve.c(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.sp = proxySelector;
        this.x = proxy;
        this.i = sSLSocketFactory;
        this.da = hostnameVerifier;
        this.sl = spVar;
    }

    public List<sl> a() {
        return this.f28444a;
    }

    public my c() {
        return this.c;
    }

    public HostnameVerifier da() {
        return this.da;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.c.equals(cVar.c) && c(cVar);
    }

    public int hashCode() {
        int iHashCode = (((((((((((this.c.hashCode() + 527) * 31) + this.tt.hashCode()) * 31) + this.uj.hashCode()) * 31) + this.n.hashCode()) * 31) + this.f28444a.hashCode()) * 31) + this.sp.hashCode()) * 31;
        Proxy proxy = this.x;
        int iHashCode2 = (iHashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.i;
        int iHashCode3 = (iHashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.da;
        int iHashCode4 = (iHashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        sp spVar = this.sl;
        return iHashCode4 + (spVar != null ? spVar.hashCode() : 0);
    }

    public SSLSocketFactory i() {
        return this.i;
    }

    public List<gr> n() {
        return this.n;
    }

    public sp sl() {
        return this.sl;
    }

    public ProxySelector sp() {
        return this.sp;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Address{");
        sb.append(this.c.sp());
        sb.append(u15.f19942b);
        sb.append(this.c.x());
        if (this.x != null) {
            sb.append(", proxy=");
            sb.append(this.x);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.sp);
        }
        sb.append("}");
        return sb.toString();
    }

    public z tt() {
        return this.tt;
    }

    public tt uj() {
        return this.uj;
    }

    public SocketFactory ve() {
        return this.ve;
    }

    public Proxy x() {
        return this.x;
    }

    public boolean c(c cVar) {
        return this.tt.equals(cVar.tt) && this.uj.equals(cVar.uj) && this.n.equals(cVar.n) && this.f28444a.equals(cVar.f28444a) && this.sp.equals(cVar.sp) && com.byazt.kh.ve.c(this.x, cVar.x) && com.byazt.kh.ve.c(this.i, cVar.i) && com.byazt.kh.ve.c(this.da, cVar.da) && com.byazt.kh.ve.c(this.sl, cVar.sl) && c().x() == cVar.c().x();
    }
}
