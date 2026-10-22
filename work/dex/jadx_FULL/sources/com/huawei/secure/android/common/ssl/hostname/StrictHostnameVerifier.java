package com.huawei.secure.android.common.ssl.hostname;

import com.huawei.secure.android.common.ssl.util.c;
import com.huawei.secure.android.common.ssl.util.e;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class StrictHostnameVerifier implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        try {
            X509Certificate x509Certificate = (X509Certificate) sSLSession.getPeerCertificates()[0];
            e.c("", "verify: certificate is : " + x509Certificate.getSubjectDN().getName());
            b.a(str, x509Certificate, true);
            c.a();
            return true;
        } catch (SSLException e) {
            e.b("", "SSLException : " + e.getMessage());
            return false;
        }
    }
}
