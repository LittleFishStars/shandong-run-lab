package com.czhj.sdk.common.network;

import android.net.SSLCertificateSocketFactory;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class CustomSSLSocketFactory extends SSLSocketFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SSLSocketFactory f29409a;

    private CustomSSLSocketFactory() {
    }

    private static void a(SSLCertificateSocketFactory sSLCertificateSocketFactory, SSLSocket sSLSocket, String str) {
        Preconditions.NoThrow.checkNotNull(sSLCertificateSocketFactory);
        Preconditions.NoThrow.checkNotNull(sSLSocket);
        sSLCertificateSocketFactory.setHostname(sSLSocket, str);
    }

    private void a(Socket socket) {
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        }
    }

    private void a(Socket socket, String str) throws IOException {
        Preconditions.NoThrow.checkNotNull(socket);
        SSLSocketFactory sSLSocketFactory = this.f29409a;
        if (sSLSocketFactory == null) {
            throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
        }
        if (socket instanceof SSLSocket) {
            try {
                SSLSocket sSLSocket = (SSLSocket) socket;
                if (sSLSocketFactory instanceof SSLCertificateSocketFactory) {
                    a((SSLCertificateSocketFactory) sSLSocketFactory, sSLSocket, str);
                    a(sSLSocket, str);
                }
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
            }
        }
    }

    private static void a(SSLSocket sSLSocket, String str) throws IOException {
        Preconditions.NoThrow.checkNotNull(sSLSocket);
        sSLSocket.startHandshake();
        if (!HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSocket.getSession())) {
            throw new SSLHandshakeException("Server Name Identification failed.");
        }
    }

    public static CustomSSLSocketFactory getDefault(int i) {
        CustomSSLSocketFactory customSSLSocketFactory = new CustomSSLSocketFactory();
        customSSLSocketFactory.f29409a = SSLCertificateSocketFactory.getDefault(i, null);
        return customSSLSocketFactory;
    }

    @Deprecated
    public void a(SSLSocketFactory sSLSocketFactory) {
        this.f29409a = sSLSocketFactory;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        SSLSocketFactory sSLSocketFactory = this.f29409a;
        if (sSLSocketFactory == null) {
            throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
        }
        Socket socketCreateSocket = sSLSocketFactory.createSocket();
        a(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        SSLSocketFactory sSLSocketFactory = this.f29409a;
        if (sSLSocketFactory == null) {
            throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
        }
        Socket socketCreateSocket = sSLSocketFactory.createSocket(str, i);
        a(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        SSLSocketFactory sSLSocketFactory = this.f29409a;
        if (sSLSocketFactory == null) {
            throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
        }
        Socket socketCreateSocket = sSLSocketFactory.createSocket(str, i, inetAddress, i2);
        a(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        SSLSocketFactory sSLSocketFactory = this.f29409a;
        if (sSLSocketFactory == null) {
            throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
        }
        Socket socketCreateSocket = sSLSocketFactory.createSocket(inetAddress, i);
        a(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        SSLSocketFactory sSLSocketFactory = this.f29409a;
        if (sSLSocketFactory == null) {
            throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
        }
        Socket socketCreateSocket = sSLSocketFactory.createSocket(inetAddress, i, inetAddress2, i2);
        a(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        SSLSocketFactory sSLSocketFactory = this.f29409a;
        if (sSLSocketFactory == null) {
            throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
        }
        Socket socketCreateSocket = sSLSocketFactory.createSocket(socket, str, i, z);
        a(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        SSLSocketFactory sSLSocketFactory = this.f29409a;
        return sSLSocketFactory == null ? new String[0] : sSLSocketFactory.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        SSLSocketFactory sSLSocketFactory = this.f29409a;
        return sSLSocketFactory == null ? new String[0] : sSLSocketFactory.getSupportedCipherSuites();
    }
}
