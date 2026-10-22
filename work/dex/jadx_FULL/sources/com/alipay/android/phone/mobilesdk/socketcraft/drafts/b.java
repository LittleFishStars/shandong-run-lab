package com.alipay.android.phone.mobilesdk.socketcraft.drafts;

import com.alipay.android.phone.mobilesdk.socketcraft.c.f;
import com.alipay.android.phone.mobilesdk.socketcraft.c.h;
import com.alipay.android.phone.mobilesdk.socketcraft.c.i;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidDataException;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidFrameException;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.NotSendableException;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.d;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends Draft {
    public static final byte f = 13;
    public static final byte g = 10;
    public static final byte h = 0;
    public static final byte i = -1;
    protected ByteBuffer l;
    protected boolean j = false;
    protected List<Framedata> k = new LinkedList();
    private final Random m = new Random();

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public Draft.HandshakeState a(com.alipay.android.phone.mobilesdk.socketcraft.c.a aVar, h hVar) {
        return (aVar.b("WebSocket-Origin").equals(hVar.b(com.google.common.net.b.F)) && a(hVar)) ? Draft.HandshakeState.MATCHED : Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public Draft.CloseHandshakeType b() {
        return Draft.CloseHandshakeType.NONE;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public List<Framedata> c(ByteBuffer byteBuffer) throws InvalidDataException {
        List<Framedata> listE = e(byteBuffer);
        if (listE != null) {
            return listE;
        }
        throw new InvalidDataException(1002);
    }

    public List<Framedata> e(ByteBuffer byteBuffer) throws InvalidFrameException {
        while (byteBuffer.hasRemaining()) {
            byte b = byteBuffer.get();
            if (b == 0) {
                if (this.j) {
                    throw new InvalidFrameException("unexpected START_OF_FRAME");
                }
                this.j = true;
            } else if (b == -1) {
                if (!this.j) {
                    throw new InvalidFrameException("unexpected END_OF_FRAME");
                }
                ByteBuffer byteBuffer2 = this.l;
                if (byteBuffer2 != null) {
                    byteBuffer2.flip();
                    d dVar = new d();
                    dVar.a(this.l);
                    dVar.a(true);
                    dVar.a(Framedata.Opcode.TEXT);
                    this.k.add(dVar);
                    this.l = null;
                    byteBuffer.mark();
                }
                this.j = false;
            } else {
                if (!this.j) {
                    return null;
                }
                ByteBuffer byteBuffer3 = this.l;
                if (byteBuffer3 == null) {
                    this.l = e();
                } else if (!byteBuffer3.hasRemaining()) {
                    this.l = f(this.l);
                }
                this.l.put(b);
            }
        }
        List<Framedata> list = this.k;
        this.k = new LinkedList();
        return list;
    }

    public ByteBuffer f(ByteBuffer byteBuffer) {
        byteBuffer.flip();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(a(byteBuffer.capacity() * 2));
        byteBufferAllocate.put(byteBuffer);
        return byteBufferAllocate;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public Draft.HandshakeState a(com.alipay.android.phone.mobilesdk.socketcraft.c.a aVar) {
        return (aVar.c(com.google.common.net.b.F) && a((f) aVar)) ? Draft.HandshakeState.MATCHED : Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public Draft c() {
        return new b();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public ByteBuffer a(Framedata framedata) {
        if (framedata.f() == Framedata.Opcode.TEXT) {
            ByteBuffer byteBufferC = framedata.c();
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBufferC.remaining() + 2);
            byteBufferAllocate.put((byte) 0);
            byteBufferC.mark();
            byteBufferAllocate.put(byteBufferC);
            byteBufferC.reset();
            byteBufferAllocate.put((byte) -1);
            byteBufferAllocate.flip();
            return byteBufferAllocate;
        }
        throw new RuntimeException("only text frames supported");
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public List<Framedata> a(ByteBuffer byteBuffer, boolean z) {
        throw new RuntimeException("not yet implemented");
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public List<Framedata> a(String str, boolean z) {
        d dVar = new d();
        try {
            dVar.a(ByteBuffer.wrap(com.alipay.android.phone.mobilesdk.socketcraft.g.b.a(str)));
            dVar.a(true);
            dVar.a(Framedata.Opcode.TEXT);
            dVar.b(z);
            return Collections.singletonList(dVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public com.alipay.android.phone.mobilesdk.socketcraft.c.b a(com.alipay.android.phone.mobilesdk.socketcraft.c.b bVar) {
        bVar.a(com.google.common.net.b.N, "WebSocket");
        bVar.a("Connection", com.google.common.net.b.N);
        if (!bVar.c(com.google.common.net.b.F)) {
            bVar.a(com.google.common.net.b.F, "random" + this.m.nextInt());
        }
        return bVar;
    }

    public ByteBuffer e() {
        return ByteBuffer.allocate(Draft.b);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public com.alipay.android.phone.mobilesdk.socketcraft.c.c a(com.alipay.android.phone.mobilesdk.socketcraft.c.a aVar, i iVar) {
        iVar.a("Web Socket Protocol Handshake");
        iVar.a(com.google.common.net.b.N, "WebSocket");
        iVar.a("Connection", aVar.b("Connection"));
        iVar.a("WebSocket-Origin", aVar.b(com.google.common.net.b.F));
        iVar.a("WebSocket-Location", "ws://" + aVar.b("Host") + aVar.a());
        return iVar;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public void a() {
        this.j = false;
        this.l = null;
    }
}
