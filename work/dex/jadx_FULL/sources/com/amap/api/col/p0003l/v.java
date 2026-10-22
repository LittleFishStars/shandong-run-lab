package com.amap.api.col.p0003l;

import android.content.Context;
import android.net.SSLSessionCache;
import android.os.Build;
import com.zj.adlib.a7b;
import com.zj.adlib.s4b;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class v extends SSLSocketFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f26060a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SSLContext f1111a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SSLSocketFactory f1112a;

    public v(Context context, SSLContext sSLContext) {
        SSLSocketFactory sSLSocketFactory;
        if (context != null) {
            try {
                this.f26060a = context.getApplicationContext();
            } catch (Throwable th) {
                try {
                    a7b.m(th, "myssl", "<init>");
                    try {
                        if (sSLSocketFactory == null) {
                            return;
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        return;
                    }
                } finally {
                    try {
                        if (this.f1111a == null) {
                            this.f1111a = SSLContext.getDefault();
                        }
                    } catch (Throwable th3) {
                        a7b.m(th3, "myssl", "<init2>");
                    }
                    try {
                        if (this.f1112a == null) {
                            this.f1112a = (SSLSocketFactory) SSLSocketFactory.getDefault();
                        }
                    } catch (Throwable th4) {
                        a7b.m(th4, "myssl", "<init3>");
                    }
                }
            }
        }
        this.f1111a = sSLContext;
        if (sSLContext != null) {
            this.f1112a = sSLContext.getSocketFactory();
        }
        try {
            if (this.f1111a == null) {
                this.f1111a = SSLContext.getDefault();
            }
        } catch (Throwable th5) {
            a7b.m(th5, "myssl", "<init2>");
        }
        try {
            if (this.f1112a == null) {
                this.f1112a = (SSLSocketFactory) SSLSocketFactory.getDefault();
            }
        } catch (Throwable th6) {
            a7b.m(th6, "myssl", "<init3>");
        }
    }

    public static Socket a(Socket socket) {
        try {
            if (fh.g.f869b && (socket instanceof SSLSocket)) {
                ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.2"});
            }
        } catch (Throwable th) {
            a7b.m(th, "myssl", "stlv2");
        }
        return socket;
    }

    public static void d(Socket socket) {
        int i = Build.VERSION.SDK_INT;
        if (fh.g.c && fh.g.d && (socket instanceof SSLSocket)) {
            int i2 = fh.g.b;
            int i3 = fh.g.f25945a;
            if (i2 <= i3) {
                i3 = fh.g.b;
            }
            if (i3 <= 17 || i <= i3) {
                try {
                    socket.getClass().getMethod(s4b.v("Cc2V0VXNlU2Vzc2lvblRpY2tldHM"), Boolean.TYPE).invoke(socket, Boolean.TRUE);
                } catch (Throwable th) {
                    a7b.m(th, "myssl", "sust");
                }
            }
        }
    }

    public final void b() {
        int i = Build.VERSION.SDK_INT;
        if (!fh.g.c || this.f26060a == null || this.f1111a == null) {
            return;
        }
        int i2 = fh.g.f25945a;
        if (i2 <= 17 || i <= i2) {
            SSLSessionCache sSLSessionCache = new SSLSessionCache(this.f26060a);
            if (i >= 28) {
                c(sSLSessionCache);
                return;
            }
            try {
                sSLSessionCache.getClass().getMethod(s4b.v("MaW5zdGFsbA"), SSLSessionCache.class, SSLContext.class).invoke(sSLSessionCache, sSLSessionCache, this.f1111a);
            } catch (Throwable th) {
                a7b.m(th, "myssl", "isc1");
                c(sSLSessionCache);
            }
        }
    }

    public final void c(SSLSessionCache sSLSessionCache) {
        SSLContext sSLContext = this.f1111a;
        if (sSLContext == null) {
            return;
        }
        try {
            SSLSessionContext clientSessionContext = sSLContext.getClientSessionContext();
            Field declaredField = sSLSessionCache.getClass().getDeclaredField(s4b.v("UbVNlc3Npb25DYWNoZQ"));
            declaredField.setAccessible(true);
            Object obj = declaredField.get(sSLSessionCache);
            Method[] methods = clientSessionContext.getClass().getMethods();
            String strV = s4b.v("Yc2V0UGVyc2lzdGVudENhY2hl");
            for (Method method : methods) {
                if (method.getName().equals(strV)) {
                    method.invoke(clientSessionContext, obj);
                    return;
                }
            }
        } catch (Throwable th) {
            a7b.m(th, "myssl", "isc2");
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket() throws IOException {
        try {
            SSLSocketFactory sSLSocketFactory = this.f1112a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket socketA = a(sSLSocketFactory.createSocket());
            d(socketA);
            return socketA;
        } catch (Throwable th) {
            a7b.m(th, "myssl", "cs1");
            if (th instanceof IOException) {
                throw th;
            }
            return null;
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        try {
            SSLSocketFactory sSLSocketFactory = this.f1112a;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory.getDefaultCipherSuites();
            }
        } catch (Throwable th) {
            a7b.m(th, "myssl", "gdcs");
        }
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        try {
            SSLSocketFactory sSLSocketFactory = this.f1112a;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory.getSupportedCipherSuites();
            }
        } catch (Throwable th) {
            a7b.m(th, "myssl", "gscs");
        }
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        try {
            SSLSocketFactory sSLSocketFactory = this.f1112a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket socketA = a(sSLSocketFactory.createSocket(socket, str, i, z));
            d(socketA);
            return socketA;
        } catch (Throwable th) {
            a7b.m(th, "myssl", "cs2");
            if (th instanceof IOException) {
                throw th;
            }
            return null;
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i) throws IOException {
        try {
            SSLSocketFactory sSLSocketFactory = this.f1112a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket socketA = a(sSLSocketFactory.createSocket(str, i));
            d(socketA);
            return socketA;
        } catch (Throwable th) {
            a7b.m(th, "myssl", "cs3");
            if (!(th instanceof UnknownHostException)) {
                if (th instanceof IOException) {
                    throw th;
                }
                return null;
            }
            throw th;
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        try {
            SSLSocketFactory sSLSocketFactory = this.f1112a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket socketA = a(sSLSocketFactory.createSocket(str, i, inetAddress, i2));
            d(socketA);
            return socketA;
        } catch (Throwable th) {
            a7b.m(th, "myssl", "cs4");
            if (!(th instanceof UnknownHostException)) {
                if (th instanceof IOException) {
                    throw th;
                }
                return null;
            }
            throw th;
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        try {
            SSLSocketFactory sSLSocketFactory = this.f1112a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket socketA = a(sSLSocketFactory.createSocket(inetAddress, i));
            d(socketA);
            return socketA;
        } catch (Throwable th) {
            a7b.m(th, "myssl", "cs5");
            if (th instanceof IOException) {
                throw th;
            }
            return null;
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        try {
            SSLSocketFactory sSLSocketFactory = this.f1112a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket socketA = a(sSLSocketFactory.createSocket(inetAddress, i, inetAddress2, i2));
            d(socketA);
            return socketA;
        } catch (Throwable th) {
            a7b.m(th, "myssl", "cs6");
            if (th instanceof IOException) {
                throw th;
            }
            return null;
        }
    }
}
