package com.alipay.android.phone.mobilesdk.socketcraft.a;

import com.alipay.android.phone.mobilesdk.socketcraft.c.h;
import com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata;
import com.google.android.exoplayer2.ExoPlayerImplInternal;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends com.alipay.android.phone.mobilesdk.socketcraft.b.b {
    public static final int c = 4000;
    public static final int d = 60000;
    private static final String g = "WebSocketClient";
    private d h;
    private Framedata i;
    private String j;
    private long k;
    private ScheduledFuture<?> l;
    private f m;
    private com.alipay.android.phone.mobilesdk.socketcraft.e.b n;
    private boolean o;

    public class a implements Runnable {
        private static final String c = "SCConnectionTimerRunnable";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f25283a;
        private b d;

        public a(b bVar, d dVar) {
            this.d = bVar;
            this.f25283a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.e(c, "connect response time out");
            try {
                b.this.c(com.alipay.android.phone.mobilesdk.socketcraft.g.e.c);
            } catch (Throwable th) {
                com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.b(c, "onSocketError error", th);
            }
            try {
                this.d.a();
            } catch (Throwable th2) {
                com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.b(c, "close socket error", th2);
            }
        }
    }

    public b(URI uri, Draft draft, Map<String, String> map, int i, d dVar, f fVar) {
        super(uri, draft, map, i);
        this.o = false;
        this.h = dVar;
        this.j = uri.toString();
        this.m = fVar;
        if (i > 4000) {
            this.k = i;
        } else {
            this.k = ExoPlayerImplInternal.f;
        }
        this.n = new com.alipay.android.phone.mobilesdk.socketcraft.e.b(this);
    }

    private void A() {
        com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.a(g, "enter afterConnect");
        this.n.e();
        this.n.a();
    }

    private void x() {
        y();
        this.l = com.alipay.android.phone.mobilesdk.socketcraft.f.d.d.a(new a(this, this.h), this.k, TimeUnit.MILLISECONDS);
    }

    private void y() {
        try {
            com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.a(g, "cancelTimeoutScheduleFuture. try to stop connectTimer");
            ScheduledFuture<?> scheduledFuture = this.l;
            if (scheduledFuture == null) {
                return;
            }
            scheduledFuture.cancel(true);
            this.l = null;
        } catch (Throwable th) {
            com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.b(g, "cancelTimeoutScheduleFuture. Cancel old timeoutScheduleFuture error", th);
        }
    }

    private void z() {
        com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.a(g, "enter beforeConnect");
        this.n.d();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.b.b, com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void a(String str) {
        if (str == null) {
            com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.d(g, "[send] text is null");
            return;
        }
        if (str.length() <= 0) {
            com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.d(g, "[send] text is empty, but continue send.");
        }
        super.a(str);
        this.n.b(str.length());
        this.n.a(new com.alipay.android.phone.mobilesdk.socketcraft.e.a(this.j, t(), "send", str.length(), 0));
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.b.b
    public void b(String str, long j) {
        this.n.b(j);
        this.n.b(str);
    }

    public void c(String str) {
        com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.e(g, String.format("onError. url is %s ,error is %s", this.j, str));
        d(str);
    }

    public void d(String str) {
        this.h.c(str);
        this.n.a("1", str);
    }

    public void m() {
        a((SSLSocketFactory) SSLSocketFactory.getDefault());
        n();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.b.b
    public boolean n() {
        z();
        return super.n();
    }

    public void o() {
        a((SSLSocketFactory) SSLSocketFactory.getDefault());
        p();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.b.b
    public void p() {
        z();
        super.p();
        x();
    }

    public f q() {
        f fVar = this.m;
        if (fVar != null) {
            return fVar;
        }
        synchronized (this) {
            f fVar2 = this.m;
            if (fVar2 != null) {
                return fVar2;
            }
            com.alipay.android.phone.mobilesdk.socketcraft.a.a aVar = new com.alipay.android.phone.mobilesdk.socketcraft.a.a();
            this.m = aVar;
            return aVar;
        }
    }

    public d r() {
        return this.h;
    }

    public String s() {
        return this.j;
    }

    public String t() {
        Object objA = q().a(c.f25284a);
        return (objA == null || !(objA instanceof String)) ? "unkown" : String.valueOf(objA);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.b.b
    public void b(long j) {
        com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.a(g, "onWsHandshake cost: " + j);
        this.n.d(j);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.b.b
    public void b(String str) {
        Object[] objArr = new Object[2];
        objArr[0] = this.j;
        objArr[1] = Integer.valueOf(str != null ? str.length() : -1);
        com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.a(g, String.format("onMessage. url is %s ,socket onmessage length :%d", objArr));
        if (str == null || str.length() <= 0) {
            return;
        }
        this.h.b(str);
        this.n.a(str.length());
        this.n.a(new com.alipay.android.phone.mobilesdk.socketcraft.e.a(this.j, t(), com.alipay.android.phone.mobilesdk.socketcraft.e.a.d, 0, str.length()));
    }

    public b(URI uri, Draft draft, Map<String, String> map, int i, d dVar) {
        this(uri, draft, map, i, dVar, new com.alipay.android.phone.mobilesdk.socketcraft.a.a());
    }

    public b(URI uri, Map<String, String> map, d dVar) {
        this(uri, new com.alipay.android.phone.mobilesdk.socketcraft.drafts.a(), map, 60000, dVar);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.b.b, com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void a(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            super.a(bArr);
            this.n.b(bArr.length);
            this.n.a(new com.alipay.android.phone.mobilesdk.socketcraft.e.a(this.j, t(), "send", bArr.length, 0));
            return;
        }
        com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.d(g, "[send] byte[] is null or length <= 0.");
    }

    public b(URI uri, Map<String, String> map, d dVar, f fVar) {
        this(uri, new com.alipay.android.phone.mobilesdk.socketcraft.drafts.a(), map, 60000, dVar, fVar);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.b.b
    public void b(ByteBuffer byteBuffer) {
        Object[] objArr = new Object[2];
        objArr[0] = this.j;
        objArr[1] = Integer.valueOf(byteBuffer != null ? byteBuffer.position() : -1);
        com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.a(g, String.format("onMessage. url is %s , socket onMessage buffer length : %d", objArr));
        if (byteBuffer == null) {
            return;
        }
        this.h.a(byteBuffer);
        this.n.a(byteBuffer.position());
        this.n.a(new com.alipay.android.phone.mobilesdk.socketcraft.e.a(this.j, t(), com.alipay.android.phone.mobilesdk.socketcraft.e.a.d, 0, byteBuffer.array().length));
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.b.b, com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void a(ByteBuffer byteBuffer) {
        if (byteBuffer != null && byteBuffer.array().length > 0) {
            super.a(byteBuffer);
            this.n.b(byteBuffer.array().length);
            this.n.a(new com.alipay.android.phone.mobilesdk.socketcraft.e.a(this.j, t(), "send", byteBuffer.array().length, 0));
            return;
        }
        com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.d(g, "[send] ByteBuffer is null or length <= 0.");
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.b.b
    public void b(Framedata framedata) {
        Framedata framedata2;
        Framedata.Opcode opcodeF = framedata.f();
        Framedata.Opcode opcode = Framedata.Opcode.CONTINUOUS;
        if (opcodeF != opcode && !framedata.d()) {
            this.i = framedata;
            return;
        }
        if (framedata.f() != opcode || (framedata2 = this.i) == null) {
            return;
        }
        if (framedata2.c().position() > 10485760) {
            com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.d(g, "onFragment. Pending frame exploded");
            a(new RuntimeException(com.alipay.android.phone.mobilesdk.socketcraft.g.e.b));
            a();
            this.i = null;
            return;
        }
        try {
            this.i.a(framedata);
        } catch (Throwable th) {
            com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.a(g, "onFragment. append frame err. ", th);
        }
        if (framedata.d()) {
            if (this.i.f() == Framedata.Opcode.BINARY) {
                b(this.i.c());
            } else if (this.i.f() == Framedata.Opcode.TEXT) {
                try {
                    String strA = com.alipay.android.phone.mobilesdk.socketcraft.g.b.a(this.i.c());
                    if (strA == null) {
                        strA = "";
                    }
                    b(strA);
                } catch (Throwable th2) {
                    com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.a(g, "onFragment. ByteBuffer to String err ", th2);
                }
            }
            this.i = null;
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.b.b
    public void a(String str, long j) {
        this.n.a(j);
        this.n.b(str);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.b.b
    public void a(long j) {
        this.n.c(j);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.b.b
    public void a(h hVar) {
        A();
        y();
        com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.a(g, String.format("onOpen. url is %s , state: opened", this.j));
        this.h.j();
        this.n.a(new com.alipay.android.phone.mobilesdk.socketcraft.e.a(this.j, t(), com.alipay.android.phone.mobilesdk.socketcraft.e.a.f25294a, this.j.length() + 189, 185));
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.b.b
    public void a(int i, String str, boolean z) {
        y();
        com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.a(g, String.format("onClose. url is %s ,state: closed ,reason: %s, errCode = %d, remote = %s", this.j, str, Integer.valueOf(i), Boolean.toString(z)));
        if (!this.o && (i == -1 || i == -2 || i == -3)) {
            c(str);
        } else {
            this.h.k();
        }
        this.n.b();
        this.n.a(new com.alipay.android.phone.mobilesdk.socketcraft.e.a(this.j, t(), "close", 0, 0));
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.b.b
    public void a(Exception exc) {
        com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.b(g, String.format("onError. url is %s ,error is %s", this.j, exc.toString()), exc);
        d("exception: " + exc.getMessage());
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.b.b, com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void a() {
        try {
            com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.a(g, "close. try to close socket");
            this.o = true;
            super.a();
        } catch (Throwable th) {
            com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.b(g, "send err. ", th);
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.b.b, com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void a(int i, String str) {
        try {
            com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.a(g, "close. try to close socket");
            this.o = true;
            super.a(i, str);
        } catch (Throwable th) {
            com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.b(g, "send err. ", th);
        }
    }

    public void a(f fVar) {
        this.m = fVar;
    }
}
