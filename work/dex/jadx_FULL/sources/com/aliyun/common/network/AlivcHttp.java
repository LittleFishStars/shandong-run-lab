package com.aliyun.common.network;

import androidx.annotation.Keep;
import com.baidu.mapapi.http.wrapper.HttpManager;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class AlivcHttp {
    public static boolean isHttps(AlivcHttpRequest alivcHttpRequest) {
        return alivcHttpRequest.getUrl().startsWith("https://");
    }

    public static boolean needOutput(AlivcHttpRequest alivcHttpRequest) {
        return ((alivcHttpRequest != null) && ("POST".equalsIgnoreCase(alivcHttpRequest.getMethod()) || HttpManager.HTTP_PUT.equalsIgnoreCase(alivcHttpRequest.getMethod()))) && alivcHttpRequest.getBody() != null && alivcHttpRequest.getBody().length > 0;
    }

    private static String readStream(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return "";
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] bArr = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i = bufferedInputStream.read(bArr);
            if (i == -1) {
                return byteArrayOutputStream.toString();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    /* JADX WARN: Not initialized variable reg: 12, insn: 0x0181: MOVE (r18 I:??[long, double]) = (r12 I:??[long, double]), block:B:82:0x017f */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x018c: MOVE (r18 I:??[long, double]) = (r12 I:??[long, double]), block:B:84:0x018a */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x0197: MOVE (r18 I:??[long, double]) = (r12 I:??[long, double]), block:B:86:0x0195 */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x01a2: MOVE (r18 I:??[long, double]) = (r12 I:??[long, double]), block:B:88:0x01a0 */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x01ad: MOVE (r18 I:??[long, double]) = (r12 I:??[long, double]), block:B:90:0x01ab */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 6811. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public static com.aliyun.common.network.AlivcHttpResponse request(com.aliyun.common.network.AlivcHttpRequest r22) {
        /*
            Method dump skipped, instruction units count: 681
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aliyun.common.network.AlivcHttp.request(com.aliyun.common.network.AlivcHttpRequest):com.aliyun.common.network.AlivcHttpResponse");
    }

    private static void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void skipSSLVerification(HttpsURLConnection httpsURLConnection) throws NoSuchAlgorithmException, KeyManagementException {
        TrustManager[] trustManagerArr = {new X509TrustManager() { // from class: com.aliyun.common.network.AlivcHttp.1
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }};
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, trustManagerArr, new SecureRandom());
        httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
        httpsURLConnection.setHostnameVerifier(new HostnameVerifier() { // from class: com.aliyun.common.network.AlivcHttp.2
            @Override // javax.net.ssl.HostnameVerifier
            public boolean verify(String str, SSLSession sSLSession) {
                return true;
            }
        });
    }

    public static boolean trustAllSSLCert(AlivcHttpRequest alivcHttpRequest) {
        return alivcHttpRequest.isTrustAllSSLCert();
    }
}
