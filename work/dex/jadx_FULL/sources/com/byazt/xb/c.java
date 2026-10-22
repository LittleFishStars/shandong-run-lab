package com.byazt.xb;

import android.net.ssl.SSLSockets;
import android.os.Build;
import android.util.Log;
import com.acse.ottn.p3;
import com.byazt.eg.gr;
import com.byazt.nr.m;
import com.byazt.wt.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLV_ABR, 20})
public class c extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ve f29173a = ve.c();
    public final Class<?> c;
    public final uj<Socket> n;
    public final uj<Socket> tt;
    public final uj<Socket> uj;
    public final uj<Socket> ve;

    /* JADX INFO: renamed from: com.byazt.xb.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLV_ABR, 44})
    public static final class C0575c extends com.byazt.wt.ve {
        public final Object c;
        public final Method tt;

        public C0575c(Object obj, Method method) {
            this.c = obj;
            this.tt = method;
        }

        @Override // com.byazt.wt.ve
        public List<Certificate> c(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.tt.invoke(this.c, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0575c;
        }

        public int hashCode() {
            return 0;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLV_ABR, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    public static final class tt implements a {
        public final X509TrustManager c;
        public final Method tt;

        public tt(X509TrustManager x509TrustManager, Method method) {
            this.tt = method;
            this.c = x509TrustManager;
        }

        @Override // com.byazt.wt.a
        public X509Certificate c(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.tt.invoke(this.c, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
            } catch (IllegalAccessException e) {
                throw com.byazt.kh.ve.c("unable to get issues and signature", (Exception) e);
            } catch (InvocationTargetException unused) {
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof tt)) {
                return false;
            }
            tt ttVar = (tt) obj;
            return this.c.equals(ttVar.c) && this.tt.equals(ttVar.tt);
        }

        public int hashCode() {
            return this.c.hashCode() + (this.tt.hashCode() * 31);
        }
    }

    public c(Class<?> cls, uj<Socket> ujVar, uj<Socket> ujVar2, uj<Socket> ujVar3, uj<Socket> ujVar4) {
        this.c = cls;
        this.tt = ujVar;
        this.ve = ujVar2;
        this.uj = ujVar3;
        this.n = ujVar4;
    }

    private static boolean uj() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // com.byazt.xb.n
    public void c(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (!com.byazt.kh.ve.c(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (ClassCastException e2) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e2;
            }
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e2);
            throw iOException;
        } catch (SecurityException e3) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e3);
            throw iOException2;
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.xb.n
    public boolean tt(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return c(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.tt(str);
        } catch (IllegalAccessException e) {
            e = e;
            throw com.byazt.kh.ve.c("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e2) {
            e = e2;
            throw com.byazt.kh.ve.c("unable to determine cleartext support", e);
        } catch (NoClassDefFoundError unused2) {
            return false;
        } catch (InvocationTargetException e3) {
            e = e3;
            throw com.byazt.kh.ve.c("unable to determine cleartext support", e);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLV_ABR, 132})
    public static final class ve {
        public final Method c;
        public final Method tt;
        public final Method ve;

        public ve(Method method, Method method2, Method method3) {
            this.c = method;
            this.tt = method2;
            this.ve = method3;
        }

        public Object c(String str) {
            Method method = this.c;
            if (method != null) {
                try {
                    Object objInvoke = method.invoke(null, new Object[0]);
                    this.tt.invoke(objInvoke, str);
                    return objInvoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        public boolean c(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.ve.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public static ve c() {
            Method method;
            Method method2;
            Method method3;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                method = cls.getMethod(p3.f, new Class[0]);
                method3 = cls.getMethod("open", String.class);
                method2 = cls.getMethod("warnIfOpen", new Class[0]);
            } catch (Exception unused) {
                method = null;
                method2 = null;
                method3 = null;
            }
            return new ve(method, method3, method2);
        }
    }

    private boolean tt(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.tt(str);
        }
    }

    @Override // com.byazt.xb.n
    public a tt(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new tt(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.tt(x509TrustManager);
        }
    }

    @Override // com.byazt.xb.n
    public void c(SSLSocket sSLSocket, String str, List<gr> list) {
        if (str != null) {
            if (Build.VERSION.SDK_INT >= 30) {
                try {
                    SSLSockets.setUseSessionTickets(sSLSocket, true);
                    SNIHostName sNIHostName = new SNIHostName(str);
                    SSLParameters sSLParameters = sSLSocket.getSSLParameters();
                    sSLParameters.setServerNames(Collections.singletonList(sNIHostName));
                    sSLSocket.setSSLParameters(sSLParameters);
                } catch (Throwable unused) {
                }
            } else {
                this.tt.tt(sSLSocket, Boolean.TRUE);
                this.ve.tt(sSLSocket, str);
            }
        }
        uj<Socket> ujVar = this.n;
        if (ujVar == null || !ujVar.c(sSLSocket)) {
            return;
        }
        this.n.uj(sSLSocket, n.tt(list));
    }

    @Override // com.byazt.xb.n
    public String c(SSLSocket sSLSocket) {
        byte[] bArr;
        uj<Socket> ujVar = this.uj;
        if (ujVar == null || !ujVar.c(sSLSocket) || (bArr = (byte[]) this.uj.uj(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, com.byazt.kh.ve.n);
    }

    @Override // com.byazt.xb.n
    public void c(int i, String str, Throwable th) {
        int iMin;
        int i2 = i != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int iIndexOf = str.indexOf(10, i3);
            if (iIndexOf == -1) {
                iIndexOf = length;
            }
            while (true) {
                iMin = Math.min(iIndexOf, i3 + 4000);
                m.c(i2, "OkHttp", str.substring(i3, iMin));
                if (iMin >= iIndexOf) {
                    break;
                } else {
                    i3 = iMin;
                }
            }
            i3 = iMin + 1;
        }
    }

    @Override // com.byazt.xb.n
    public Object c(String str) {
        return this.f29173a.c(str);
    }

    @Override // com.byazt.xb.n
    public void c(String str, Object obj) {
        if (this.f29173a.c(obj)) {
            return;
        }
        c(5, str, (Throwable) null);
    }

    private boolean c(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return tt(str, cls, obj);
        }
    }

    @Override // com.byazt.xb.n
    public com.byazt.wt.ve c(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0575c(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.c(x509TrustManager);
        }
    }

    public static n c() {
        Class<?> cls;
        uj ujVar;
        uj ujVar2;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            uj ujVar3 = new uj(null, "setUseSessionTickets", Boolean.TYPE);
            uj ujVar4 = new uj(null, "setHostname", String.class);
            if (uj()) {
                uj ujVar5 = new uj(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                ujVar2 = new uj(null, "setAlpnProtocols", byte[].class);
                ujVar = ujVar5;
            } else {
                ujVar = null;
                ujVar2 = null;
            }
            return new c(cls2, ujVar3, ujVar4, ujVar, ujVar2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }
}
