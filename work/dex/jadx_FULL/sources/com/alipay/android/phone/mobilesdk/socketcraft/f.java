package com.alipay.android.phone.mobilesdk.socketcraft;

import com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft;
import com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft_10;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.IncompleteHandshakeException;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidDataException;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidHandshakeException;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.WebsocketNotConnectedException;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f implements WebSocket {
    public static final String c = "WebSocketImpl";
    public static int d = 16384;
    public static boolean e = true;
    public static final List<Draft> f;
    static final /* synthetic */ boolean k = true;
    public SelectionKey g;
    public ByteChannel h;
    public final BlockingQueue<ByteBuffer> i;
    public final BlockingQueue<ByteBuffer> j;
    private volatile boolean l;
    private WebSocket.READYSTATE m;
    private final g n;
    private List<Draft> o;
    private Draft p;
    private WebSocket.Role q;
    private Framedata.Opcode r;
    private ByteBuffer s;
    private com.alipay.android.phone.mobilesdk.socketcraft.c.a t;
    private String u;
    private Integer v;
    private Boolean w;
    private String x;

    static {
        ArrayList arrayList = new ArrayList(4);
        f = arrayList;
        arrayList.add(new com.alipay.android.phone.mobilesdk.socketcraft.drafts.a());
        arrayList.add(new Draft_10());
        arrayList.add(new com.alipay.android.phone.mobilesdk.socketcraft.drafts.c());
        arrayList.add(new com.alipay.android.phone.mobilesdk.socketcraft.drafts.b());
    }

    public f(g gVar, List<Draft> list) {
        this(gVar, (Draft) null);
        this.q = WebSocket.Role.SERVER;
        if (list == null || list.isEmpty()) {
            this.o = f;
        } else {
            this.o = list;
        }
    }

    /* JADX WARN: Code duplicated, block: B:82:0x018b  */
    /* JADX WARN: Code duplicated, block: B:84:0x0194  */
    /* JADX WARN: Code duplicated, block: B:85:0x019b  */
    /* JADX WARN: Code duplicated, block: B:93:0x01ba  */
    private boolean c(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        int preferedSize;
        if (this.s.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.s.remaining() < byteBuffer.remaining()) {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.s.capacity() + byteBuffer.remaining());
                this.s.flip();
                byteBufferAllocate.put(this.s);
                this.s = byteBufferAllocate;
            }
            this.s.put(byteBuffer);
            this.s.flip();
            byteBuffer2 = this.s;
        }
        byteBuffer2.mark();
        try {
            if (this.p == null && e(byteBuffer2) == Draft.HandshakeState.MATCHED) {
                try {
                    f(ByteBuffer.wrap(com.alipay.android.phone.mobilesdk.socketcraft.g.b.a(this.n.a(this))));
                    a(-3, "");
                } catch (InvalidDataException unused) {
                    c(1006, "remote peer closed connection before flashpolicy could be transmitted", true);
                }
                return false;
            }
            try {
                WebSocket.Role role = this.q;
                if (role != WebSocket.Role.SERVER) {
                    if (role == WebSocket.Role.CLIENT) {
                        this.p.a(role);
                        com.alipay.android.phone.mobilesdk.socketcraft.c.f fVarD = this.p.d(byteBuffer2);
                        if (!(fVarD instanceof com.alipay.android.phone.mobilesdk.socketcraft.c.h)) {
                            b(1002, "wrong http function", false);
                            return false;
                        }
                        com.alipay.android.phone.mobilesdk.socketcraft.c.h hVar = (com.alipay.android.phone.mobilesdk.socketcraft.c.h) fVarD;
                        if (this.p.a(this.t, hVar) == Draft.HandshakeState.MATCHED) {
                            try {
                                this.n.a(this, this.t, hVar);
                                a(hVar);
                                return true;
                            } catch (InvalidDataException e2) {
                                b(e2.getCloseCode(), e2.getMessage(), false);
                                return false;
                            } catch (RuntimeException e3) {
                                this.n.a(this, e3);
                                b(-1, e3.getMessage(), false);
                                return false;
                            }
                        }
                        a(1002, "draft " + this.p + " refuses handshake");
                    }
                    return false;
                }
                Draft draft = this.p;
                if (draft != null) {
                    com.alipay.android.phone.mobilesdk.socketcraft.c.f fVarD2 = draft.d(byteBuffer2);
                    if (!(fVarD2 instanceof com.alipay.android.phone.mobilesdk.socketcraft.c.a)) {
                        b(1002, "wrong http function", false);
                        return false;
                    }
                    com.alipay.android.phone.mobilesdk.socketcraft.c.a aVar = (com.alipay.android.phone.mobilesdk.socketcraft.c.a) fVarD2;
                    if (this.p.a(aVar) == Draft.HandshakeState.MATCHED) {
                        a(aVar);
                        return true;
                    }
                    a(1002, "the handshake did finaly not match");
                    return false;
                }
                Iterator<Draft> it = this.o.iterator();
                while (it.hasNext()) {
                    Draft draftC = it.next().c();
                    try {
                        draftC.a(this.q);
                        byteBuffer2.reset();
                        com.alipay.android.phone.mobilesdk.socketcraft.c.f fVarD3 = draftC.d(byteBuffer2);
                        if (!(fVarD3 instanceof com.alipay.android.phone.mobilesdk.socketcraft.c.a)) {
                            b(1002, "wrong http function", false);
                            return false;
                        }
                        com.alipay.android.phone.mobilesdk.socketcraft.c.a aVar2 = (com.alipay.android.phone.mobilesdk.socketcraft.c.a) fVarD3;
                        if (draftC.a(aVar2) == Draft.HandshakeState.MATCHED) {
                            this.x = aVar2.a();
                            try {
                                a(draftC.a(draftC.a(aVar2, this.n.a(this, draftC, aVar2)), this.q));
                                this.p = draftC;
                                a(aVar2);
                                return true;
                            } catch (InvalidDataException e4) {
                                b(e4.getCloseCode(), e4.getMessage(), false);
                                return false;
                            } catch (RuntimeException e5) {
                                this.n.a(this, e5);
                                b(-1, e5.getMessage(), false);
                                return false;
                            }
                        }
                    } catch (InvalidHandshakeException unused2) {
                    }
                }
                if (this.p == null) {
                    a(1002, "no draft matches");
                }
                return false;
            } catch (InvalidHandshakeException e6) {
                a(e6);
            }
        } catch (IncompleteHandshakeException e7) {
            if (this.s.capacity() == 0) {
                byteBuffer2.reset();
                preferedSize = e7.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                } else if (!k) {
                    throw new AssertionError();
                }
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(preferedSize);
                this.s = byteBufferAllocate2;
                byteBufferAllocate2.put(byteBuffer);
            } else {
                ByteBuffer byteBuffer3 = this.s;
                byteBuffer3.position(byteBuffer3.limit());
                ByteBuffer byteBuffer4 = this.s;
                byteBuffer4.limit(byteBuffer4.capacity());
            }
        }
        if (this.s.capacity() == 0) {
            byteBuffer2.reset();
            preferedSize = e7.getPreferedSize();
            if (preferedSize == 0) {
                preferedSize = byteBuffer2.capacity() + 16;
            } else if (!k && e7.getPreferedSize() < byteBuffer2.remaining()) {
                throw new AssertionError();
            }
            ByteBuffer byteBufferAllocate3 = ByteBuffer.allocate(preferedSize);
            this.s = byteBufferAllocate3;
            byteBufferAllocate3.put(byteBuffer);
        } else {
            ByteBuffer byteBuffer5 = this.s;
            byteBuffer5.position(byteBuffer5.limit());
            ByteBuffer byteBuffer6 = this.s;
            byteBuffer6.limit(byteBuffer6.capacity());
        }
        return false;
    }

    private void d(ByteBuffer byteBuffer) {
        int iA;
        String strB;
        try {
            for (Framedata framedata : this.p.c(byteBuffer)) {
                if (e) {
                    com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.c(c, "matched frame: " + framedata);
                }
                Framedata.Opcode opcodeF = framedata.f();
                boolean zD = framedata.d();
                if (opcodeF == Framedata.Opcode.CLOSING) {
                    if (framedata instanceof com.alipay.android.phone.mobilesdk.socketcraft.framing.a) {
                        com.alipay.android.phone.mobilesdk.socketcraft.framing.a aVar = (com.alipay.android.phone.mobilesdk.socketcraft.framing.a) framedata;
                        iA = aVar.a();
                        strB = aVar.b();
                    } else {
                        iA = 1005;
                        strB = "";
                    }
                    if (this.m == WebSocket.READYSTATE.CLOSING) {
                        a(iA, strB, true);
                    } else if (this.p.b() == Draft.CloseHandshakeType.TWOWAY) {
                        c(iA, strB, true);
                    } else {
                        b(iA, strB, false);
                    }
                } else if (opcodeF == Framedata.Opcode.PING) {
                    this.n.b(this, framedata);
                } else if (opcodeF == Framedata.Opcode.PONG) {
                    this.n.c(this, framedata);
                } else if (!zD || opcodeF == Framedata.Opcode.CONTINUOUS) {
                    if (opcodeF != Framedata.Opcode.CONTINUOUS) {
                        if (this.r != null) {
                            throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                        }
                        this.r = opcodeF;
                    } else if (zD) {
                        if (this.r == null) {
                            throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                        }
                        this.r = null;
                    } else if (this.r == null) {
                        throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                    }
                    try {
                        this.n.a(this, framedata);
                    } catch (RuntimeException e2) {
                        this.n.a(this, e2);
                    }
                } else {
                    if (this.r != null) {
                        throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
                    }
                    if (opcodeF == Framedata.Opcode.TEXT) {
                        try {
                            this.n.a(this, com.alipay.android.phone.mobilesdk.socketcraft.g.b.a(framedata.c()));
                        } catch (RuntimeException e3) {
                            this.n.a(this, e3);
                        }
                    } else {
                        if (opcodeF != Framedata.Opcode.BINARY) {
                            throw new InvalidDataException(1002, "non control or continious frame expected");
                        }
                        try {
                            this.n.a(this, framedata.c());
                        } catch (RuntimeException e4) {
                            this.n.a(this, e4);
                        }
                    }
                }
            }
        } catch (InvalidDataException e5) {
            this.n.a(this, e5);
            a(e5);
        }
    }

    private Draft.HandshakeState e(ByteBuffer byteBuffer) {
        byteBuffer.mark();
        int iLimit = byteBuffer.limit();
        byte[] bArr = Draft.c;
        if (iLimit > bArr.length) {
            return Draft.HandshakeState.NOT_MATCHED;
        }
        if (byteBuffer.limit() < bArr.length) {
            throw new IncompleteHandshakeException(bArr.length);
        }
        int i = 0;
        while (byteBuffer.hasRemaining()) {
            if (Draft.c[i] != byteBuffer.get()) {
                byteBuffer.reset();
                return Draft.HandshakeState.NOT_MATCHED;
            }
            i++;
        }
        return Draft.HandshakeState.MATCHED;
    }

    private void f(ByteBuffer byteBuffer) {
        if (e) {
            StringBuilder sb = new StringBuilder("write(");
            sb.append(byteBuffer.remaining());
            sb.append("): {");
            sb.append(byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array()));
            sb.append("}");
            com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.c(c, sb.toString());
        }
        this.i.add(byteBuffer);
        this.n.b(this);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void a(int i, String str) {
        c(i, str, false);
    }

    public void b(ByteBuffer byteBuffer) {
        boolean z = k;
        if (!z && !byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
        if (e) {
            StringBuilder sb = new StringBuilder("process(");
            sb.append(byteBuffer.remaining());
            sb.append("): {");
            sb.append(byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining()));
            sb.append("}");
            com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.c(c, sb.toString());
        }
        if (this.m != WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            d(byteBuffer);
        } else if (c(byteBuffer)) {
            if (!z && this.s.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                d(byteBuffer);
            } else if (this.s.hasRemaining()) {
                d(this.s);
            }
        }
        if (!z && !g() && !h() && byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public boolean g() {
        return this.m == WebSocket.READYSTATE.CLOSING;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public boolean h() {
        return this.l;
    }

    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public boolean i() {
        return this.m == WebSocket.READYSTATE.CLOSED;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public Draft j() {
        return this.p;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public WebSocket.READYSTATE k() {
        return this.m;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public String l() {
        return this.x;
    }

    public void m() {
        if (this.w == null) {
            throw new IllegalStateException("this method must be used in conjuction with flushAndClose");
        }
        a(this.v.intValue(), this.u, this.w.booleanValue());
    }

    public void n() {
        if (k() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            a(-1, true);
            return;
        }
        if (this.l) {
            a(this.v.intValue(), this.u, this.w.booleanValue());
            return;
        }
        if (this.p.b() == Draft.CloseHandshakeType.NONE) {
            a(1000, true);
        } else if (this.p.b() != Draft.CloseHandshakeType.ONEWAY || this.q == WebSocket.Role.SERVER) {
            a(1006, true);
        } else {
            a(1000, true);
        }
    }

    public String toString() {
        return super.toString();
    }

    /* JADX WARN: Code duplicated, block: B:22:0x002e A[Catch: all -> 0x003f, TryCatch #2 {, blocks: (B:3:0x0001, B:7:0x0009, B:9:0x000d, B:10:0x0010, B:12:0x0014, B:16:0x001e, B:20:0x002a, B:22:0x002e, B:23:0x0031, B:19:0x0025, B:15:0x0019), top: B:33:0x0001, inners: #0, #1 }] */
    public synchronized void a(int i, String str, boolean z) {
        Draft draft;
        if (this.m == WebSocket.READYSTATE.CLOSED) {
            return;
        }
        SelectionKey selectionKey = this.g;
        if (selectionKey != null) {
            selectionKey.cancel();
        }
        ByteChannel byteChannel = this.h;
        if (byteChannel == null) {
            this.n.a(this, i, str, z);
            draft = this.p;
            if (draft != null) {
                draft.a();
            }
            this.t = null;
            this.m = WebSocket.READYSTATE.CLOSED;
            this.i.clear();
            return;
        }
        try {
            byteChannel.close();
        } catch (IOException e2) {
            this.n.a(this, e2);
        }
        try {
            this.n.a(this, i, str, z);
        } catch (RuntimeException e3) {
            this.n.a(this, e3);
        }
        draft = this.p;
        if (draft != null) {
            draft.a();
        }
        this.t = null;
        this.m = WebSocket.READYSTATE.CLOSED;
        this.i.clear();
        return;
        throw th;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public boolean f() {
        if (!k && this.m == WebSocket.READYSTATE.OPEN && this.l) {
            throw new AssertionError();
        }
        return this.m == WebSocket.READYSTATE.OPEN;
    }

    public f(g gVar, Draft draft) {
        this.l = false;
        this.m = WebSocket.READYSTATE.NOT_YET_CONNECTED;
        this.p = null;
        this.r = null;
        this.s = ByteBuffer.allocate(0);
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        if (gVar != null && (draft != null || this.q != WebSocket.Role.SERVER)) {
            this.i = new LinkedBlockingQueue();
            this.j = new LinkedBlockingQueue();
            this.n = gVar;
            this.q = WebSocket.Role.CLIENT;
            if (draft != null) {
                this.p = draft.c();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("parameters must not be null");
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public boolean e() {
        if (k || !this.l || this.m == WebSocket.READYSTATE.CONNECTING) {
            return this.m == WebSocket.READYSTATE.CONNECTING;
        }
        throw new AssertionError();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void b(int i, String str) {
        a(i, str, false);
    }

    public synchronized void b(int i, String str, boolean z) {
        if (this.l) {
            return;
        }
        this.v = Integer.valueOf(i);
        this.u = str;
        this.w = Boolean.valueOf(z);
        this.l = true;
        this.n.b(this);
        try {
            this.n.b(this, i, str, z);
        } catch (RuntimeException e2) {
            this.n.a(this, e2);
        }
        Draft draft = this.p;
        if (draft != null) {
            draft.a();
        }
        this.t = null;
    }

    public void a(int i, boolean z) {
        a(i, "", z);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void a(int i) {
        c(i, "", false);
    }

    public void a(InvalidDataException invalidDataException) {
        c(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        a(this.p.a(str, this.q == WebSocket.Role.CLIENT));
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        a(this.p.a(byteBuffer, this.q == WebSocket.Role.CLIENT));
    }

    @Deprecated
    public f(g gVar, Draft draft, Socket socket) {
        this(gVar, draft);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
    }

    @Deprecated
    public f(g gVar, List<Draft> list, Socket socket) {
        this(gVar, list);
    }

    private void a(Collection<Framedata> collection) {
        if (f()) {
            Iterator<Framedata> it = collection.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            return;
        }
        throw new WebsocketNotConnectedException();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public boolean b() {
        return !this.i.isEmpty();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void a(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        a(this.p.a(opcode, byteBuffer, z));
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void a(Framedata framedata) {
        if (e) {
            com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.c(c, "send frame: " + framedata);
        }
        f(this.p.a(framedata));
    }

    public void a(com.alipay.android.phone.mobilesdk.socketcraft.c.b bVar) {
        boolean z = k;
        if (!z && this.m == WebSocket.READYSTATE.CONNECTING) {
            throw new AssertionError("shall only be called once");
        }
        this.t = this.p.a(bVar);
        String strA = bVar.a();
        this.x = strA;
        if (!z && strA == null) {
            throw new AssertionError();
        }
        try {
            this.n.a((WebSocket) this, this.t);
            a(this.p.a(this.t, this.q));
        } catch (InvalidDataException unused) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        } catch (RuntimeException e2) {
            this.n.a(this, e2);
            throw new InvalidHandshakeException("rejected because of" + e2);
        }
    }

    private void a(List<ByteBuffer> list) {
        Iterator<ByteBuffer> it = list.iterator();
        while (it.hasNext()) {
            f(it.next());
        }
    }

    private void a(com.alipay.android.phone.mobilesdk.socketcraft.c.f fVar) {
        if (e) {
            com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.c(c, "open using draft: " + this.p.getClass().getSimpleName());
        }
        this.m = WebSocket.READYSTATE.OPEN;
        try {
            this.n.a(this, fVar);
        } catch (RuntimeException e2) {
            this.n.a(this, e2);
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public InetSocketAddress d() {
        return this.n.c(this);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void a() {
        a(1000);
    }

    private void c(int i, String str, boolean z) {
        WebSocket.READYSTATE readystate = this.m;
        WebSocket.READYSTATE readystate2 = WebSocket.READYSTATE.CLOSING;
        if (readystate == readystate2 || readystate == WebSocket.READYSTATE.CLOSED) {
            return;
        }
        if (readystate == WebSocket.READYSTATE.OPEN) {
            if (i == 1006) {
                if (!k && z) {
                    throw new AssertionError();
                }
                this.m = readystate2;
                b(i, str, false);
                return;
            }
            if (this.p.b() != Draft.CloseHandshakeType.NONE) {
                if (!z) {
                    try {
                        try {
                            this.n.a(this, i, str);
                        } catch (RuntimeException e2) {
                            this.n.a(this, e2);
                        }
                    } catch (InvalidDataException e3) {
                        this.n.a(this, e3);
                        b(1006, "generated frame is invalid", false);
                    }
                }
                a(new com.alipay.android.phone.mobilesdk.socketcraft.framing.b(i, str));
            }
            b(i, str, z);
        } else if (i == -3) {
            if (!k && !z) {
                throw new AssertionError();
            }
            b(-3, str, true);
        } else {
            b(-1, str, false);
        }
        if (i == 1002) {
            b(i, str, z);
        }
        this.m = WebSocket.READYSTATE.CLOSING;
        this.s = null;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public InetSocketAddress c() {
        return this.n.d(this);
    }
}
