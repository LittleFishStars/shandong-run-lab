package com.kc.openset.common.okhttp;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.LinkedList;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class SSLSocketFactoryCompat extends SSLSocketFactory {
    static String[] cipherSuites;
    static String[] protocols;
    private SSLSocketFactory defaultFactory;

    static {
        OSETSDKProtected.interface11(4390);
        protocols = null;
        cipherSuites = null;
        try {
            SSLSocket sSLSocket = (SSLSocket) SSLSocketFactory.getDefault().createSocket();
            if (sSLSocket != null) {
                LinkedList linkedList = new LinkedList();
                for (String str : sSLSocket.getSupportedProtocols()) {
                    if (!str.toUpperCase().contains(OSETSDKProtected.getString2("1502"))) {
                        linkedList.add(str);
                    }
                }
                protocols = (String[]) linkedList.toArray(new String[linkedList.size()]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public SSLSocketFactoryCompat(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance(OSETSDKProtected.getString2("1503"));
            sSLContext.init(null, x509TrustManager != null ? new X509TrustManager[]{x509TrustManager} : null, null);
            this.defaultFactory = sSLContext.getSocketFactory();
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    private native void upgradeTLS(SSLSocket sSLSocket);

    @Override // javax.net.SocketFactory
    public native Socket createSocket(String str, int i) throws IOException;

    @Override // javax.net.SocketFactory
    public native Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException;

    @Override // javax.net.SocketFactory
    public native Socket createSocket(InetAddress inetAddress, int i) throws IOException;

    @Override // javax.net.SocketFactory
    public native Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException;

    @Override // javax.net.ssl.SSLSocketFactory
    public native Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException;

    @Override // javax.net.ssl.SSLSocketFactory
    public native String[] getDefaultCipherSuites();

    @Override // javax.net.ssl.SSLSocketFactory
    public native String[] getSupportedCipherSuites();
}
