package com.byazt.iq;

import com.byazt.eg.sl;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 179, 13})
public final class tt {
    public final List<sl> c;
    public int tt = 0;
    public boolean uj;
    public boolean ve;

    public tt(List<sl> list) {
        this.c = list;
    }

    private boolean tt(SSLSocket sSLSocket) {
        for (int i = this.tt; i < this.c.size(); i++) {
            if (this.c.get(i).c(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public sl c(SSLSocket sSLSocket) throws IOException {
        sl slVar;
        int i = this.tt;
        int size = this.c.size();
        while (true) {
            if (i >= size) {
                slVar = null;
                break;
            }
            slVar = this.c.get(i);
            if (slVar.c(sSLSocket)) {
                this.tt = i + 1;
                break;
            }
            i++;
        }
        if (slVar != null) {
            this.ve = tt(sSLSocket);
            com.byazt.kh.c.c.c(slVar, sSLSocket, this.uj);
            return slVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.uj + ", modes=" + this.c + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean c(IOException iOException) {
        this.uj = true;
        if (!this.ve || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z || (iOException instanceof SSLProtocolException);
    }
}
