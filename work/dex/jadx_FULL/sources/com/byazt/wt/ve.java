package com.byazt.wt;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1564, 54})
public abstract class ve {
    public static ve c(X509TrustManager x509TrustManager) {
        return com.byazt.xb.n.tt().c(x509TrustManager);
    }

    public abstract List<Certificate> c(List<Certificate> list, String str) throws SSLPeerUnverifiedException;
}
