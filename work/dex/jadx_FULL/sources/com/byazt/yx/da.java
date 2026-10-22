package com.byazt.yx;

import com.byazt.eg.d;
import com.byazt.eg.eo;
import com.byazt.eg.gr;
import com.byazt.eg.gt;
import com.byazt.eg.gu;
import com.byazt.eg.h;
import com.byazt.eg.m;
import com.byazt.eg.my;
import com.byazt.eg.p;
import com.byazt.eg.yv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, 72})
public final class da implements gt {
    public final gu c;
    public volatile boolean n;
    public final boolean tt;
    public Object uj;
    public com.byazt.iq.sp ve;

    public da(gu guVar, boolean z) {
        this.c = guVar;
        this.tt = z;
    }

    public void c() {
        this.n = true;
        com.byazt.iq.sp spVar = this.ve;
        if (spVar != null) {
            spVar.n();
        }
    }

    public boolean tt() {
        return this.n;
    }

    public void c(Object obj) {
        this.uj = obj;
    }

    @Override // com.byazt.eg.gt
    public h c(gt.c cVar) throws Throwable {
        String strC;
        String str;
        int i;
        IOException iOException;
        int i2;
        yv yvVarC = cVar.c();
        sp spVar = (sp) cVar;
        com.byazt.eg.n nVarCall = spVar.call();
        m mVarX = spVar.x();
        this.ve = new com.byazt.iq.sp(this.c.z(), c(yvVarC.c()), nVarCall, mVarX, this.uj);
        try {
            int i3 = Integer.parseInt(yvVarC.ve().c("csj_client_source_from"));
            strC = yvVarC.ve().c("csj_extra_info");
            try {
                yvVarC = yvVarC.a().tt("csj_client_source_from").tt("csj_extra_info").c();
                i = i3;
                str = strC;
            } catch (Exception unused) {
                str = strC;
                i = 0;
            }
        } catch (Exception unused2) {
            strC = "";
        }
        String string = yvVarC.c().toString();
        ArrayList arrayList = new ArrayList();
        h hVar = null;
        int i4 = 0;
        while (!this.n) {
            if (this.c.d != null && yvVarC.c() != null) {
                Iterator<String> it = this.c.d.iterator();
                while (it.hasNext()) {
                    Iterator<String> it2 = it;
                    String[] strArrSplit = it.next().split("@");
                    m mVar = mVarX;
                    if (strArrSplit.length >= 2) {
                        String str2 = strArrSplit[0];
                        try {
                            i2 = Integer.parseInt(strArrSplit[1]);
                        } catch (Exception unused3) {
                            i2 = 0;
                        }
                        if ((i2 & i) != 0 && Pattern.compile(str2).matcher(yvVarC.c().toString()).find()) {
                            h.c cVar2 = new h.c();
                            cVar2.c(8848);
                            cVar2.c(yvVarC.c().toString());
                            cVar2.c(yvVarC);
                            cVar2.c(gr.HTTP_1_1);
                            cVar2.c(com.byazt.kh.ve.ve);
                            if (arrayList.size() > 0) {
                                arrayList.add(0, string);
                                return cVar2.c("csj-location-record", arrayList.toString()).c("csj-source-from", String.valueOf(i)).c("csj-extra-info", String.valueOf(str)).c();
                            }
                            return cVar2.c();
                        }
                    }
                    it = it2;
                    mVarX = mVar;
                }
            }
            m mVar2 = mVarX;
            try {
                try {
                    h hVarC = spVar.c(yvVarC, this.ve, null, null);
                    if (hVar != null) {
                        hVarC = hVarC.i().ve(hVar.i().c((d) null).c()).c();
                    }
                    yvVarC = c(hVarC);
                    if (yvVarC == null) {
                        if (!this.tt) {
                            this.ve.ve();
                        }
                        if (arrayList.size() <= 0) {
                            return hVarC;
                        }
                        arrayList.add(0, string);
                        return hVarC.i().c("csj-location-record", arrayList.toString()).c("csj-source-from", String.valueOf(i)).c("csj-extra-info", String.valueOf(str)).c();
                    }
                    arrayList.add(yvVarC.c().toString());
                    com.byazt.kh.ve.c(hVarC.x());
                    int i5 = i4 + 1;
                    if (i5 <= 20) {
                        if (!(yvVarC.uj() instanceof t)) {
                            if (!c(hVarC, yvVarC.c())) {
                                this.ve.ve();
                                this.ve = new com.byazt.iq.sp(this.c.z(), c(yvVarC.c()), nVarCall, mVar2, this.uj);
                            } else if (this.ve.c() != null) {
                                throw new IllegalStateException("Closing the body of " + hVarC + " didn't close its backing stream. Bad interceptor?");
                            }
                            hVar = hVarC;
                            i4 = i5;
                            arrayList = arrayList;
                            mVarX = mVar2;
                        } else {
                            this.ve.ve();
                            throw new HttpRetryException("Cannot retry streamed HTTP body", hVarC.ve());
                        }
                    } else {
                        this.ve.ve();
                        throw new ProtocolException("Too many follow-up requests: ".concat(String.valueOf(i5)));
                    }
                } catch (com.byazt.iq.n e) {
                    e = e;
                    if (!c(e.c(), false, yvVarC)) {
                        throw e.c();
                    }
                } catch (IOException e2) {
                    e = e2;
                    iOException = null;
                    try {
                        if (!c(e, !(e instanceof com.byazt.jb.c), yvVarC)) {
                            throw e;
                        }
                    } catch (Throwable th) {
                        th = th;
                        this.ve.c(iOException);
                        this.ve.ve();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    iOException = null;
                    this.ve.c(iOException);
                    this.ve.ve();
                    throw th;
                }
            } catch (com.byazt.iq.n e3) {
                e = e3;
            } catch (IOException e4) {
                e = e4;
                iOException = null;
            } catch (Throwable th3) {
                th = th3;
                iOException = null;
            }
        }
        this.ve.ve();
        throw new IOException("Canceled");
    }

    private com.byazt.eg.c c(my myVar) {
        SSLSocketFactory sSLSocketFactoryDa;
        HostnameVerifier hostnameVerifierSl;
        com.byazt.eg.sp spVarT;
        if (myVar.uj()) {
            sSLSocketFactoryDa = this.c.da();
            hostnameVerifierSl = this.c.sl();
            spVarT = this.c.t();
        } else {
            sSLSocketFactoryDa = null;
            hostnameVerifierSl = null;
            spVarT = null;
        }
        return new com.byazt.eg.c(myVar.sp(), myVar.x(), this.c.x(), this.c.i(), sSLSocketFactoryDa, hostnameVerifierSl, spVarT, this.c.yp(), this.c.uj(), this.c.gt(), this.c.rl(), this.c.n());
    }

    private boolean c(IOException iOException, boolean z, yv yvVar) {
        this.ve.c(iOException);
        if (this.c.rh()) {
            return !(z && (yvVar.uj() instanceof t)) && c(iOException, z) && this.ve.a();
        }
        return false;
    }

    private boolean c(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            return (iOException instanceof SocketTimeoutException) && !z;
        }
        return (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private yv c(h hVar) throws IOException {
        String strC;
        my myVarVe;
        Proxy proxyUj;
        if (hVar != null) {
            com.byazt.iq.ve veVarTt = this.ve.tt();
            eo eoVarC = veVarTt != null ? veVarTt.c() : null;
            int iVe = hVar.ve();
            String strTt = hVar.c().tt();
            if (iVe == 307 || iVe == 308) {
                if (!"GET".equals(strTt) && !com.ipd.dsp.internal.g0.c.f38307a.equals(strTt)) {
                    return null;
                }
            } else {
                if (iVe == 401) {
                    return this.c.u().c(eoVarC, hVar);
                }
                if (iVe == 407) {
                    if (eoVarC != null) {
                        proxyUj = eoVarC.tt();
                    } else {
                        proxyUj = this.c.uj();
                    }
                    if (proxyUj.type() == Proxy.Type.HTTP) {
                        return this.c.yp().c(eoVarC, hVar);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                if (iVe == 408) {
                    if (!this.c.rh() || (hVar.c().uj() instanceof t)) {
                        return null;
                    }
                    if (hVar.sl() == null || hVar.sl().ve() != 408) {
                        return hVar.c();
                    }
                    return null;
                }
                switch (iVe) {
                    case 300:
                    case 301:
                    case 302:
                    case 303:
                        break;
                    default:
                        return null;
                }
            }
            if (!this.c.nu() || (strC = hVar.c("Location")) == null || (myVarVe = hVar.c().c().ve(strC)) == null) {
                return null;
            }
            if (!myVarVe.ve().equals(hVar.c().c().ve()) && !this.c.m()) {
                return null;
            }
            yv.c cVarA = hVar.c().a();
            if (a.ve(strTt)) {
                boolean zUj = a.uj(strTt);
                if (a.n(strTt)) {
                    cVarA.c("GET", (p) null);
                } else {
                    cVarA.c(strTt, zUj ? hVar.c().uj() : null);
                }
                if (!zUj) {
                    cVarA.tt("Transfer-Encoding");
                    cVarA.tt("Content-Length");
                    cVarA.tt("Content-Type");
                }
            }
            if (!c(hVar, myVarVe)) {
                cVarA.tt("Authorization");
            }
            return cVarA.c(myVarVe).c();
        }
        throw new IllegalStateException();
    }

    private boolean c(h hVar, my myVar) {
        my myVarC = hVar.c().c();
        return myVarC.sp().equals(myVar.sp()) && myVarC.x() == myVar.x() && myVarC.ve().equals(myVar.ve());
    }
}
