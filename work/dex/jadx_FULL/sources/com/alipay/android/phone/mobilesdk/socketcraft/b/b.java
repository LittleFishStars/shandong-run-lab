package com.alipay.android.phone.mobilesdk.socketcraft.b;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import com.alipay.android.phone.mobilesdk.socketcraft.WebSocket;
import com.alipay.android.phone.mobilesdk.socketcraft.c.h;
import com.alipay.android.phone.mobilesdk.socketcraft.d;
import com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft;
import com.alipay.android.phone.mobilesdk.socketcraft.f;
import com.alipay.android.phone.mobilesdk.socketcraft.f.c.c;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata;
import com.zj.adlib.u15;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class b extends d implements WebSocket, Runnable {
    private static final String c = "WebSocketClient";
    static final /* synthetic */ boolean f = true;
    private f d;
    protected URI e;
    private Socket g;
    private InputStream h;
    private OutputStream i;
    private Proxy j;
    private Thread k;
    private Draft l;
    private Map<String, String> m;
    private CountDownLatch n;
    private CountDownLatch o;
    private int p;
    private SSLSocketFactory q;

    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("WebsocketWriteThread");
            while (!Thread.interrupted()) {
                try {
                    ByteBuffer byteBufferTake = b.this.d.i.take();
                    b.this.i.write(byteBufferTake.array(), 0, byteBufferTake.limit());
                    b.this.i.flush();
                } catch (IOException unused) {
                    b.this.d.n();
                    return;
                } catch (InterruptedException unused2) {
                    return;
                }
            }
        }
    }

    public b(URI uri) {
        this(uri, new com.alipay.android.phone.mobilesdk.socketcraft.drafts.a());
    }

    private void m() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            InetAddress[] allByName = InetAddress.getAllByName(this.e.getHost());
            if (allByName == null || allByName.length <= 0) {
                throw new UnknownHostException("Unknown host : " + this.e.getHost());
            }
            InetAddress inetAddress = allByName[0];
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            String hostAddress = inetAddress != null ? inetAddress.getHostAddress() : " null ";
            a(hostAddress, jCurrentTimeMillis2);
            com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.a(c, "DNS timing: " + jCurrentTimeMillis2 + ", ip: " + hostAddress);
            long jCurrentTimeMillis3 = System.currentTimeMillis();
            try {
                this.g.connect(new InetSocketAddress(inetAddress, o()), this.p);
                long jCurrentTimeMillis4 = System.currentTimeMillis() - jCurrentTimeMillis3;
                String hostAddress2 = inetAddress.getHostAddress();
                b(hostAddress2, jCurrentTimeMillis4);
                com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.a(c, "Connection timing: " + jCurrentTimeMillis4 + ", ip: " + hostAddress2);
                SSLSocketFactory sSLSocketFactory = this.q;
                if (sSLSocketFactory == null) {
                    return;
                }
                SSLSocket sSLSocket = (SSLSocket) sSLSocketFactory.createSocket(this.g, this.e.getHost(), o(), true);
                c.a().a(sSLSocket, this.e.getHost());
                long jCurrentTimeMillis5 = System.currentTimeMillis();
                try {
                    sSLSocket.startHandshake();
                    long jCurrentTimeMillis6 = System.currentTimeMillis() - jCurrentTimeMillis5;
                    a(jCurrentTimeMillis6);
                    com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.a(c, "SSL timing: " + jCurrentTimeMillis6 + ", ip: " + inetAddress.getHostAddress());
                    this.g = sSLSocket;
                } catch (Throwable th) {
                    long jCurrentTimeMillis7 = System.currentTimeMillis() - jCurrentTimeMillis5;
                    a(jCurrentTimeMillis7);
                    com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.a(c, "SSL timing: " + jCurrentTimeMillis7 + ", ip: " + inetAddress.getHostAddress());
                    throw th;
                }
            } catch (Throwable th2) {
                long jCurrentTimeMillis8 = System.currentTimeMillis() - jCurrentTimeMillis3;
                String hostAddress3 = inetAddress.getHostAddress();
                b(hostAddress3, jCurrentTimeMillis8);
                com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.a(c, "Connection timing: " + jCurrentTimeMillis8 + ", ip: " + hostAddress3);
                throw th2;
            }
        } catch (Throwable th3) {
            long jCurrentTimeMillis9 = System.currentTimeMillis() - jCurrentTimeMillis;
            a(" null ", jCurrentTimeMillis9);
            com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.a(c, "DNS timing: " + jCurrentTimeMillis9 + ", ip:  null ");
            throw th3;
        }
    }

    private int o() {
        int port = this.e.getPort();
        if (port != -1) {
            return port;
        }
        String scheme = this.e.getScheme();
        if (scheme.equals(com.alibaba.ariver.websocket.b.b)) {
            return 443;
        }
        if (scheme.equals("ws")) {
            return 80;
        }
        throw new RuntimeException("unkonow scheme" + scheme);
    }

    private void q() {
        String path = this.e.getPath();
        String query = this.e.getQuery();
        if (path == null || path.length() == 0) {
            path = WVNativeCallbackUtil.SEPERATER;
        }
        if (query != null) {
            path = path + "?" + query;
        }
        int iO = o();
        StringBuilder sb = new StringBuilder();
        sb.append(this.e.getHost());
        sb.append(iO != 80 ? u15.f19942b + iO : "");
        String string = sb.toString();
        com.alipay.android.phone.mobilesdk.socketcraft.c.d dVar = new com.alipay.android.phone.mobilesdk.socketcraft.c.d();
        dVar.a(path);
        dVar.a("Host", string);
        Map<String, String> map = this.m;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                dVar.a(entry.getKey(), entry.getValue());
            }
        }
        this.d.a((com.alipay.android.phone.mobilesdk.socketcraft.c.b) dVar);
    }

    public abstract void a(int i, String str, boolean z);

    public void a(long j) {
    }

    public abstract void a(h hVar);

    public abstract void a(Exception exc);

    public void a(String str, long j) {
    }

    public void b(int i, String str, boolean z) {
    }

    public void b(long j) {
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.g
    public final void b(WebSocket webSocket) {
    }

    public void b(Framedata framedata) {
    }

    public abstract void b(String str);

    public void b(String str, long j) {
    }

    public void b(ByteBuffer byteBuffer) {
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.g
    public InetSocketAddress c(WebSocket webSocket) {
        Socket socket = this.g;
        if (socket != null) {
            return (InetSocketAddress) socket.getLocalSocketAddress();
        }
        return null;
    }

    public void c(int i, String str) {
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.g
    public InetSocketAddress d(WebSocket webSocket) {
        Socket socket = this.g;
        if (socket != null) {
            return (InetSocketAddress) socket.getRemoteSocketAddress();
        }
        return null;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public boolean e() {
        return this.d.e();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public boolean f() {
        return this.d.f();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public boolean g() {
        return this.d.g();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public boolean h() {
        return this.d.h();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public boolean i() {
        return this.d.i();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public Draft j() {
        return this.l;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public WebSocket.READYSTATE k() {
        return this.d.k();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public String l() {
        return this.e.getPath();
    }

    public boolean n() throws InterruptedException {
        p();
        this.n.await();
        return this.d.f();
    }

    public void p() {
        if (this.k != null) {
            throw new IllegalStateException("WebSocketClient objects are not reuseable");
        }
        Thread thread = new Thread(this);
        this.k = thread;
        thread.start();
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        try {
            Socket socket = this.g;
            if (socket == null) {
                this.g = new Socket(this.j);
            } else if (socket.isClosed()) {
                throw new SocketException("Socket is closed");
            }
            if (!this.g.isBound()) {
                m();
            }
            this.h = this.g.getInputStream();
            this.i = this.g.getOutputStream();
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                q();
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                b(jCurrentTimeMillis2);
                com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.a(c, "WebSocketHandshark timing: " + jCurrentTimeMillis2);
                Thread thread = new Thread(new a());
                this.k = thread;
                thread.start();
                byte[] bArr = new byte[f.d];
                while (!i() && !g() && (i = this.h.read(bArr)) != -1) {
                    try {
                        this.d.b(ByteBuffer.wrap(bArr, 0, i));
                    } catch (IOException unused) {
                        this.d.n();
                    } catch (RuntimeException e) {
                        a(e);
                        this.d.b(1006, e.getMessage());
                    }
                }
                this.d.n();
                if (!f && !this.g.isClosed()) {
                    throw new AssertionError();
                }
            } catch (Throwable th) {
                long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                b(jCurrentTimeMillis3);
                com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.a(c, "WebSocketHandshark timing: " + jCurrentTimeMillis3);
                throw th;
            }
        } catch (Exception e2) {
            a(this.d, e2);
            this.d.b(-1, e2.getMessage());
        }
    }

    public URI u() {
        return this.e;
    }

    public void v() throws InterruptedException {
        a();
        this.o.await();
    }

    public WebSocket w() {
        return this.d;
    }

    public b(URI uri, Draft draft) {
        this(uri, draft, null, 0);
    }

    public void a() {
        if (this.k != null) {
            this.d.a(1000);
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.g
    public void b(WebSocket webSocket, int i, String str, boolean z) {
        b(i, str, z);
    }

    public b(URI uri, Draft draft, Map<String, String> map, int i) {
        this.e = null;
        this.d = null;
        this.g = null;
        this.j = Proxy.NO_PROXY;
        this.n = new CountDownLatch(1);
        this.o = new CountDownLatch(1);
        this.p = 0;
        if (uri == null) {
            throw new IllegalArgumentException();
        }
        if (draft != null) {
            this.e = uri;
            this.l = draft;
            this.m = map;
            this.p = i;
            this.d = new f(this, draft);
            return;
        }
        throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public boolean b() {
        return this.d.b();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public InetSocketAddress c() {
        return this.d.c();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public InetSocketAddress d() {
        return this.d.d();
    }

    public void a(String str) {
        this.d.a(str);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void b(int i, String str) {
        this.d.b(i, str);
    }

    public void a(byte[] bArr) {
        this.d.a(bArr);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.g
    public final void a(WebSocket webSocket, String str) {
        b(str);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.g
    public final void a(WebSocket webSocket, ByteBuffer byteBuffer) {
        b(byteBuffer);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.d, com.alipay.android.phone.mobilesdk.socketcraft.g
    public void a(WebSocket webSocket, Framedata framedata) {
        b(framedata);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.g
    public final void a(WebSocket webSocket, com.alipay.android.phone.mobilesdk.socketcraft.c.f fVar) {
        this.n.countDown();
        a((h) fVar);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.g
    public final void a(WebSocket webSocket, int i, String str, boolean z) {
        this.n.countDown();
        this.o.countDown();
        Thread thread = this.k;
        if (thread != null) {
            thread.interrupt();
        }
        try {
            Socket socket = this.g;
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            a(this, e);
        }
        a(i, str, z);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.g
    public final void a(WebSocket webSocket, Exception exc) {
        a(exc);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.g
    public void a(WebSocket webSocket, int i, String str) {
        c(i, str);
    }

    public void a(Proxy proxy) {
        if (proxy != null) {
            this.j = proxy;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void a(Socket socket) {
        if (this.g == null) {
            this.g = socket;
            return;
        }
        throw new IllegalStateException("socket has already been set");
    }

    public void a(SSLSocketFactory sSLSocketFactory) {
        this.q = sSLSocketFactory;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void a(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        this.d.a(opcode, byteBuffer, z);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void a(int i) {
        this.d.a();
    }

    public void a(int i, String str) {
        this.d.a(i, str);
    }

    public void a(ByteBuffer byteBuffer) {
        this.d.a(byteBuffer);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void a(Framedata framedata) {
        this.d.a(framedata);
    }
}
