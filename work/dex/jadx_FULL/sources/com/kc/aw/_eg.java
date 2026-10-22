package com.kc.aw;

import android.net.Uri;
import android.text.TextUtils;
import com.ipd.dsp.internal.v0.q;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _eg {
    public final Object _a = new Object();
    public final ExecutorService _b = Executors.newFixedThreadPool(8);
    public final ConcurrentHashMap _c = new ConcurrentHashMap();
    public final ServerSocket _d;
    public final int _e;
    public final _bo _f;

    @Keep
    public final class _a implements Runnable {
        public final Socket _a;
        public final _eg _b;

        public _a(_eg _egVar, Socket socket) {
            this._b = _egVar;
            this._a = socket;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _eg _egVar = this._b;
            Socket socket = this._a;
            _egVar.getClass();
            try {
                try {
                    _dx _dxVar_a = _dx._a(socket.getInputStream());
                    _dxVar_a.toString();
                    _egVar._a(_ht._a(_dxVar_a._a))._a(_dxVar_a, socket);
                } catch (Throwable th) {
                    try {
                        if (!socket.isInputShutdown()) {
                            socket.shutdownInput();
                        }
                    } catch (SocketException unused) {
                    } catch (IOException e) {
                        new _hs("Error closing socket input stream", e);
                    }
                    try {
                        if (!socket.isOutputShutdown()) {
                            socket.shutdownOutput();
                        }
                    } catch (IOException unused2) {
                    }
                    try {
                        if (!socket.isClosed()) {
                            socket.close();
                        }
                    } catch (IOException e2) {
                        new _hs("Error closing socket", e2);
                    }
                    synchronized (_egVar._a) {
                        Iterator it = _egVar._c.values().iterator();
                        while (it.hasNext()) {
                            ((_eh) it.next())._a.get();
                        }
                        throw th;
                    }
                }
            } catch (_hs e3) {
                e = e3;
                new _hs("Error processing request", e);
            } catch (SocketException unused3) {
            } catch (IOException e4) {
                e = e4;
                new _hs("Error processing request", e);
            }
            try {
                if (!socket.isInputShutdown()) {
                    socket.shutdownInput();
                }
            } catch (SocketException unused4) {
            } catch (IOException e5) {
                new _hs("Error closing socket input stream", e5);
            }
            try {
                if (!socket.isOutputShutdown()) {
                    socket.shutdownOutput();
                }
            } catch (IOException unused5) {
            }
            try {
                if (!socket.isClosed()) {
                    socket.close();
                }
            } catch (IOException e6) {
                new _hs("Error closing socket", e6);
            }
            synchronized (_egVar._a) {
                Iterator it2 = _egVar._c.values().iterator();
                while (it2.hasNext()) {
                    ((_eh) it2.next())._a.get();
                }
            }
        }
    }

    @Keep
    public final class _b implements Runnable {
        public final CountDownLatch _a;
        public final _eg _b;

        public _b(_eg _egVar, CountDownLatch countDownLatch) {
            this._b = _egVar;
            this._a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this._a.countDown();
            _eg _egVar = this._b;
            _egVar.getClass();
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Socket socketAccept = _egVar._d.accept();
                    Objects.toString(socketAccept);
                    _egVar._b.submit(new _a(_egVar, socketAccept));
                } catch (IOException e) {
                    new _hs("Error during waiting connection", e);
                    return;
                }
            }
        }
    }

    public _eg(_bo _boVar) {
        this._f = (_bo) _hp._a(_boVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName(q.i));
            this._d = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this._e = localPort;
            _ew._a(localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            new Thread(new _b(this, countDownLatch)).start();
            countDownLatch.await();
        } catch (IOException | InterruptedException e) {
            this._b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    public final _eh _a(String str) {
        _eh _ehVar;
        synchronized (this._a) {
            _ehVar = (_eh) this._c.get(str);
            if (_ehVar == null) {
                _ehVar = new _eh(str, this._f);
                this._c.put(str, _ehVar);
            }
        }
        return _ehVar;
    }

    public final String _a(String str, boolean z) {
        String string;
        if (z) {
            _bo _boVar = this._f;
            File file = _boVar._a;
            _boVar._b.getClass();
            if (new File(file, _g0._a(str)).exists()) {
                _bo _boVar2 = this._f;
                File file2 = _boVar2._a;
                _boVar2._b.getClass();
                File file3 = new File(file2, _g0._a(str));
                try {
                    _fw _fwVar = (_fw) this._f._c;
                    _fwVar.getClass();
                    _fw._a.submit(new _fw._c(_fwVar, file3));
                } catch (IOException unused) {
                    Objects.toString(file3);
                }
                return Uri.fromFile(file3).toString();
            }
        }
        Locale locale = Locale.US;
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(com.kc.aw.lib.utils._a._d)) {
            StringBuilder sb2 = new StringBuilder();
            for (char c : "\u0012\u000e\u000e\n@UU".toCharArray()) {
                sb2.append((char) (c ^ 'z'));
            }
            string = sb2.toString();
            com.kc.aw.lib.utils._a._d = string;
        } else {
            string = com.kc.aw.lib.utils._a._d;
        }
        sb.append(string);
        sb.append("%s:%d/%s");
        try {
            return String.format(locale, sb.toString(), q.i, Integer.valueOf(this._e), URLEncoder.encode(str, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error encoding url", e);
        }
    }
}
