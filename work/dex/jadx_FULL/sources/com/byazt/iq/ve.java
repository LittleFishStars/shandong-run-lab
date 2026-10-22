package com.byazt.iq;

import com.byazt.eg.da;
import com.byazt.eg.eo;
import com.byazt.eg.gr;
import com.byazt.eg.gt;
import com.byazt.eg.gu;
import com.byazt.eg.h;
import com.byazt.eg.i;
import com.byazt.eg.m;
import com.byazt.eg.my;
import com.byazt.eg.nu;
import com.byazt.eg.sl;
import com.byazt.eg.yv;
import com.byazt.mk.t;
import com.google.common.net.b;
import com.zj.adlib.u15;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 179, 54})
public final class ve extends com.byazt.jb.sp.tt implements i {
    public boolean c;
    public Socket da;
    public Socket i;
    public nu sl;
    public final da sp;
    public gr t;
    public int tt;
    public com.byazt.jb.sp u;
    public final eo x;
    public com.byazt.mk.n yp;
    public com.byazt.mk.uj z;
    public int ve = 1;
    public final List<Reference<sp>> uj = new ArrayList();
    public long n = Long.MAX_VALUE;

    public ve(da daVar, eo eoVar) {
        this.sp = daVar;
        this.x = eoVar;
    }

    private yv a() {
        return new yv.c().c(this.x.c().c()).c("Host", com.byazt.kh.ve.c(this.x.c().c(), true)).c("Proxy-Connection", b.t0).c("User-Agent", com.byazt.kh.uj.c()).c();
    }

    public void c(int i, int i2, int i3, boolean z, com.byazt.eg.n nVar, m mVar) {
        if (this.t != null) {
            throw new IllegalStateException("already connected");
        }
        List<sl> listA = this.x.c().a();
        tt ttVar = new tt(listA);
        if (this.x.c().i() == null) {
            if (!listA.contains(sl.ve)) {
                throw new n(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String strSp = this.x.c().c().sp();
            if (!com.byazt.xb.n.tt().tt(strSp)) {
                throw new n(new UnknownServiceException("CLEARTEXT communication to " + strSp + " not permitted by network security policy"));
            }
        }
        n nVar2 = null;
        while (true) {
            try {
                if (this.x.uj()) {
                    c(i, i2, i3, nVar, mVar);
                    if (this.i == null) {
                        break;
                    }
                } else {
                    try {
                        c(i, i2, nVar, mVar);
                    } catch (IOException e) {
                        e = e;
                        com.byazt.kh.ve.c(this.da);
                        com.byazt.kh.ve.c(this.i);
                        this.da = null;
                        this.i = null;
                        this.yp = null;
                        this.z = null;
                        this.sl = null;
                        this.t = null;
                        this.u = null;
                        mVar.c(nVar, this.x.ve(), this.x.tt(), null, e);
                        if (nVar2 == null) {
                            nVar2 = new n(e);
                        } else {
                            nVar2.c(e);
                        }
                        if (!z) {
                            throw nVar2;
                        }
                        if (!ttVar.c(e)) {
                            throw nVar2;
                        }
                    }
                }
                c(ttVar, nVar, mVar);
                break;
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (this.x.uj() && this.i == null) {
            throw new n(new ProtocolException("Too many tunnel connections attempted: 21"));
        }
        if (this.u != null) {
            synchronized (this.sp) {
                this.ve = this.u.c();
            }
        }
    }

    public boolean n() {
        return this.u != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Connection{");
        sb.append(this.x.c().c().sp());
        sb.append(u15.f19942b);
        sb.append(this.x.c().c().x());
        sb.append(", proxy=");
        sb.append(this.x.tt());
        sb.append(" hostAddress=");
        sb.append(this.x.ve());
        sb.append(" cipherSuite=");
        nu nuVar = this.sl;
        sb.append(nuVar != null ? nuVar.tt() : "none");
        sb.append(" protocol=");
        sb.append(this.t);
        sb.append('}');
        return sb.toString();
    }

    public void tt() {
        com.byazt.kh.ve.c(this.i);
    }

    public nu uj() {
        return this.sl;
    }

    public Socket ve() {
        return this.da;
    }

    private void c(int i, int i2, int i3, com.byazt.eg.n nVar, m mVar) throws IOException {
        yv yvVarA = a();
        my myVarC = yvVarA.c();
        for (int i4 = 0; i4 < 21; i4++) {
            c(i, i2, nVar, mVar);
            yvVarA = c(i2, i3, yvVarA, myVarC);
            if (yvVarA == null) {
                return;
            }
            com.byazt.kh.ve.c(this.i);
            this.i = null;
            this.z = null;
            this.yp = null;
        }
    }

    private void c(int i, int i2, com.byazt.eg.n nVar, m mVar) throws IOException {
        Proxy proxyTt = this.x.tt();
        Socket socketCreateSocket = (proxyTt.type() == Proxy.Type.DIRECT || proxyTt.type() == Proxy.Type.HTTP) ? this.x.c().ve().createSocket() : new Socket(proxyTt);
        this.i = socketCreateSocket;
        socketCreateSocket.setSoTimeout(i2);
        try {
            com.byazt.xb.n.tt().c(this.i, this.x.ve(), i);
            try {
                this.yp = t.c(t.tt(this.i));
                this.z = t.c(t.c(this.i));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.x.ve());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private void c(tt ttVar, com.byazt.eg.n nVar, m mVar) throws Throwable {
        if (this.x.c().i() == null) {
            this.t = gr.HTTP_1_1;
            this.da = this.i;
            return;
        }
        c(ttVar);
        try {
            if (this.t == gr.HTTP_2) {
                this.da.setSoTimeout(0);
                com.byazt.jb.sp spVarC = new com.byazt.jb.sp.c(true).c(this.da, this.x.c().c().sp(), this.yp, this.z).c(this).c();
                this.u = spVarC;
                spVarC.ve();
            }
        } catch (Throwable unused) {
        }
    }

    private void c(tt ttVar) throws Throwable {
        com.byazt.eg.c cVarC = this.x.c();
        SSLSocket sSLSocket = null;
        try {
            try {
                SSLSocket sSLSocket2 = (SSLSocket) cVarC.i().createSocket(this.i, cVarC.c().sp(), cVarC.c().x(), true);
                try {
                    sl slVarC = ttVar.c(sSLSocket2);
                    if (slVarC.uj()) {
                        com.byazt.xb.n.tt().c(sSLSocket2, cVarC.c().sp(), cVarC.n());
                    }
                    try {
                        sSLSocket2.startHandshake();
                    } catch (Throwable unused) {
                    }
                    nu nuVarC = nu.c(sSLSocket2.getSession());
                    if (cVarC.da().verify(cVarC.c().sp(), sSLSocket2.getSession())) {
                        cVarC.sl().c(cVarC.c().sp(), nuVarC.ve());
                        String strC = slVarC.uj() ? com.byazt.xb.n.tt().c(sSLSocket2) : null;
                        this.da = sSLSocket2;
                        this.yp = t.c(t.tt(sSLSocket2));
                        this.z = t.c(t.c(this.da));
                        this.sl = nuVarC;
                        this.t = strC != null ? gr.c(strC) : gr.HTTP_1_1;
                        com.byazt.xb.n.tt().tt(sSLSocket2);
                        return;
                    }
                    X509Certificate x509Certificate = (X509Certificate) nuVarC.ve().get(0);
                    throw new SSLPeerUnverifiedException("Hostname " + cVarC.c().sp() + " not verified:\n    certificate: " + com.byazt.eg.sp.c((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + com.byazt.wt.n.c(x509Certificate));
                } catch (AssertionError e) {
                    e = e;
                    if (!com.byazt.kh.ve.c(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        com.byazt.xb.n.tt().tt(sSLSocket);
                    }
                    com.byazt.kh.ve.c((Socket) sSLSocket);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (AssertionError e2) {
            e = e2;
        }
    }

    private yv c(int i, int i2, yv yvVar, my myVar) throws IOException {
        String str = "CONNECT " + com.byazt.kh.ve.c(myVar, true) + " HTTP/1.1";
        while (true) {
            com.byazt.hx.c cVar = new com.byazt.hx.c(null, null, this.yp, this.z);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.yp.c().c(i, timeUnit);
            this.z.c().c(i2, timeUnit);
            cVar.c(yvVar.ve(), str);
            cVar.tt();
            h hVarC = cVar.c(false).c(yvVar).c();
            long jC = com.byazt.yx.n.c(hVarC);
            if (jC == -1) {
                jC = 0;
            }
            com.byazt.mk.my myVarTt = cVar.tt(jC);
            com.byazt.kh.ve.tt(myVarTt, Integer.MAX_VALUE, timeUnit);
            myVarTt.close();
            int iVe = hVarC.ve();
            if (iVe == 200) {
                if (this.yp.ve().n() && this.z.ve().n()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iVe == 407) {
                yv yvVarC = this.x.c().uj().c(this.x, hVarC);
                if (yvVarC != null) {
                    if ("close".equalsIgnoreCase(hVarC.c("Connection"))) {
                        return yvVarC;
                    }
                    yvVar = yvVarC;
                } else {
                    throw new IOException("Failed to authenticate with proxy");
                }
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + hVarC.ve());
            }
        }
    }

    public boolean c(com.byazt.eg.c cVar, eo eoVar) {
        if (this.uj.size() >= this.ve || this.c || !com.byazt.kh.c.c.c(this.x.c(), cVar)) {
            return false;
        }
        if (cVar.c().sp().equals(c().c().c().sp())) {
            return true;
        }
        if (this.u == null || eoVar == null || eoVar.tt().type() != Proxy.Type.DIRECT || this.x.tt().type() != Proxy.Type.DIRECT || !this.x.ve().equals(eoVar.ve()) || eoVar.c().da() != com.byazt.wt.n.c || !c(cVar.c())) {
            return false;
        }
        try {
            cVar.sl().c(cVar.c().sp(), uj().ve());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean c(my myVar) {
        if (myVar.x() != this.x.c().c().x()) {
            return false;
        }
        if (myVar.sp().equals(this.x.c().c().sp())) {
            return true;
        }
        return this.sl != null && com.byazt.wt.n.c.c(myVar.sp(), (X509Certificate) this.sl.ve().get(0));
    }

    public com.byazt.yx.ve c(gu guVar, gt.c cVar, sp spVar) throws SocketException {
        if (this.u != null) {
            return new com.byazt.jb.a(guVar, cVar, spVar, this.u);
        }
        this.da.setSoTimeout(cVar.ve());
        com.byazt.mk.gt gtVarC = this.yp.c();
        long jVe = cVar.ve();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        gtVarC.c(jVe, timeUnit);
        this.z.c().c(cVar.uj(), timeUnit);
        return new com.byazt.hx.c(guVar, spVar, this.yp, this.z);
    }

    @Override // com.byazt.eg.i
    public eo c() {
        return this.x;
    }

    public boolean c(boolean z) {
        if (this.da.isClosed() || this.da.isInputShutdown() || this.da.isOutputShutdown()) {
            return false;
        }
        com.byazt.jb.sp spVar = this.u;
        if (spVar != null) {
            return !spVar.uj();
        }
        if (z) {
            try {
                int soTimeout = this.da.getSoTimeout();
                try {
                    this.da.setSoTimeout(1);
                    if (this.yp.n()) {
                        this.da.setSoTimeout(soTimeout);
                        return false;
                    }
                    this.da.setSoTimeout(soTimeout);
                    return true;
                } catch (Throwable th) {
                    this.da.setSoTimeout(soTimeout);
                    throw th;
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // com.byazt.jb.sp.tt
    public void c(com.byazt.jb.i iVar) throws IOException {
        iVar.c(com.byazt.jb.tt.REFUSED_STREAM);
    }

    @Override // com.byazt.jb.sp.tt
    public void c(com.byazt.jb.sp spVar) {
        synchronized (this.sp) {
            this.ve = spVar.c();
        }
    }
}
