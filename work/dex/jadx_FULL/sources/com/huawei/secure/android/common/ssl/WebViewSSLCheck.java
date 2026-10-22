package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import com.huawei.secure.android.common.ssl.util.e;
import com.huawei.secure.android.common.ssl.util.h;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WebViewSSLCheck {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f37735a = "WebViewSSLCheck";

    public static void checkServerCertificateNew(SslErrorHandler sslErrorHandler, SslError sslError, Context context) {
        checkServerCertificateNew(sslErrorHandler, sslError, null, context, null);
    }

    public static void checkServerCertificateNew(SslErrorHandler sslErrorHandler, SslError sslError, String str, Context context, WebViewSSLCheckThread.Callback callback) {
        String str2 = f37735a;
        e.c(str2, " error type : " + sslError.getPrimaryError() + " , cn is : " + sslError.getCertificate().getIssuedTo().getCName());
        X509Certificate x509CertificateA = com.huawei.secure.android.common.ssl.util.b.a(sslError.getCertificate());
        X509Certificate x509CertificateA2 = new h(context).a();
        e.a(str2, "checkServerCertificateNew: error certificate is : " + x509CertificateA);
        if (com.huawei.secure.android.common.ssl.util.b.a(x509CertificateA2, x509CertificateA)) {
            e.c(str2, "checkServerCertificateNew: proceed");
            if (callback != null) {
                callback.onProceed(context, str);
                return;
            } else {
                sslErrorHandler.proceed();
                return;
            }
        }
        e.b(str2, "checkServerCertificateNew: cancel");
        if (callback != null) {
            callback.onCancel(context, str);
        } else {
            sslErrorHandler.cancel();
        }
    }

    public static boolean checkServerCertificateNew(X509Certificate x509Certificate, SslError sslError) {
        return com.huawei.secure.android.common.ssl.util.b.a(x509Certificate, com.huawei.secure.android.common.ssl.util.b.a(sslError.getCertificate()));
    }

    public static boolean checkServerCertificateNew(String str, SslError sslError) {
        return checkServerCertificateNew(com.huawei.secure.android.common.ssl.util.b.a(str), sslError);
    }
}
