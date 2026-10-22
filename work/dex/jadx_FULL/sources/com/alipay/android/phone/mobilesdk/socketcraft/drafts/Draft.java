package com.alipay.android.phone.mobilesdk.socketcraft.drafts;

import com.alibaba.ariver.resource.parser.a.e;
import com.alipay.android.phone.mobilesdk.socketcraft.WebSocket;
import com.alipay.android.phone.mobilesdk.socketcraft.c.d;
import com.alipay.android.phone.mobilesdk.socketcraft.c.f;
import com.alipay.android.phone.mobilesdk.socketcraft.c.h;
import com.alipay.android.phone.mobilesdk.socketcraft.c.i;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.IncompleteHandshakeException;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidDataException;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidHandshakeException;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata;
import com.zj.adlib.u15;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class Draft {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f25293a = 1000;
    public static int b = 64;
    public static final byte[] c = com.alipay.android.phone.mobilesdk.socketcraft.g.b.a("<policy-file-request/>\u0000");
    protected WebSocket.Role d = null;
    protected Framedata.Opcode e = null;

    public enum CloseHandshakeType {
        NONE,
        ONEWAY,
        TWOWAY
    }

    public enum HandshakeState {
        MATCHED,
        NOT_MATCHED
    }

    public static ByteBuffer a(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b2 = e.i;
        while (byteBuffer.hasRemaining()) {
            byte b3 = byteBuffer.get();
            byteBufferAllocate.put(b3);
            if (b2 == 13 && b3 == 10) {
                byteBufferAllocate.limit(byteBufferAllocate.position() - 2);
                byteBufferAllocate.position(0);
                return byteBufferAllocate;
            }
            b2 = b3;
        }
        byteBuffer.position(byteBuffer.position() - byteBufferAllocate.position());
        return null;
    }

    public static String b(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferA = a(byteBuffer);
        if (byteBufferA == null) {
            return null;
        }
        return com.alipay.android.phone.mobilesdk.socketcraft.g.b.a(byteBufferA.array(), 0, byteBufferA.limit());
    }

    public abstract com.alipay.android.phone.mobilesdk.socketcraft.c.b a(com.alipay.android.phone.mobilesdk.socketcraft.c.b bVar);

    public abstract com.alipay.android.phone.mobilesdk.socketcraft.c.c a(com.alipay.android.phone.mobilesdk.socketcraft.c.a aVar, i iVar);

    public abstract HandshakeState a(com.alipay.android.phone.mobilesdk.socketcraft.c.a aVar);

    public abstract HandshakeState a(com.alipay.android.phone.mobilesdk.socketcraft.c.a aVar, h hVar);

    public abstract ByteBuffer a(Framedata framedata);

    public abstract List<Framedata> a(String str, boolean z);

    public abstract List<Framedata> a(ByteBuffer byteBuffer, boolean z);

    public abstract void a();

    public abstract CloseHandshakeType b();

    public abstract Draft c();

    public abstract List<Framedata> c(ByteBuffer byteBuffer);

    public f d(ByteBuffer byteBuffer) {
        return a(byteBuffer, this.d);
    }

    public WebSocket.Role d() {
        return this.d;
    }

    public static com.alipay.android.phone.mobilesdk.socketcraft.c.c a(ByteBuffer byteBuffer, WebSocket.Role role) throws InvalidHandshakeException {
        com.alipay.android.phone.mobilesdk.socketcraft.c.c cVar;
        String strB;
        String strB2 = b(byteBuffer);
        if (strB2 != null) {
            String[] strArrSplit = strB2.split(" ", 3);
            if (strArrSplit.length == 3) {
                if (role == WebSocket.Role.CLIENT) {
                    com.alipay.android.phone.mobilesdk.socketcraft.c.e eVar = new com.alipay.android.phone.mobilesdk.socketcraft.c.e();
                    eVar.a(Short.parseShort(strArrSplit[1]));
                    eVar.a(strArrSplit[2]);
                    cVar = eVar;
                } else {
                    d dVar = new d();
                    dVar.a(strArrSplit[1]);
                    cVar = dVar;
                }
                while (true) {
                    strB = b(byteBuffer);
                    if (strB == null || strB.length() <= 0) {
                        break;
                    }
                    String[] strArrSplit2 = strB.split(u15.f19942b, 2);
                    if (strArrSplit2.length == 2) {
                        cVar.a(strArrSplit2[0], strArrSplit2[1].replaceFirst("^ +", ""));
                    } else {
                        throw new InvalidHandshakeException("not an http header");
                    }
                }
                if (strB != null) {
                    return cVar;
                }
                throw new IncompleteHandshakeException();
            }
            throw new InvalidHandshakeException();
        }
        throw new IncompleteHandshakeException(byteBuffer.capacity() + 128);
    }

    public boolean a(f fVar) {
        return fVar.b(com.google.common.net.b.N).equalsIgnoreCase("websocket") && fVar.b("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade");
    }

    public List<Framedata> a(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        Framedata.Opcode opcode2;
        if (opcode != Framedata.Opcode.BINARY && opcode != (opcode2 = Framedata.Opcode.TEXT) && opcode != opcode2) {
            throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
        }
        if (this.e != null) {
            this.e = Framedata.Opcode.CONTINUOUS;
        } else {
            this.e = opcode;
        }
        com.alipay.android.phone.mobilesdk.socketcraft.framing.d dVar = new com.alipay.android.phone.mobilesdk.socketcraft.framing.d(this.e);
        try {
            dVar.a(byteBuffer);
            dVar.a(z);
            if (z) {
                this.e = null;
            } else {
                this.e = opcode;
            }
            return Collections.singletonList(dVar);
        } catch (InvalidDataException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ByteBuffer> a(f fVar, WebSocket.Role role) {
        return a(fVar, role, true);
    }

    public List<ByteBuffer> a(f fVar, WebSocket.Role role, boolean z) {
        StringBuilder sb = new StringBuilder(100);
        if (fVar instanceof com.alipay.android.phone.mobilesdk.socketcraft.c.a) {
            sb.append("GET ");
            sb.append(((com.alipay.android.phone.mobilesdk.socketcraft.c.a) fVar).a());
            sb.append(" HTTP/1.1");
        } else if (fVar instanceof h) {
            sb.append("HTTP/1.1 101 " + ((h) fVar).a());
        } else {
            throw new RuntimeException("unknow role");
        }
        sb.append("\r\n");
        Iterator<String> itC = fVar.c();
        while (itC.hasNext()) {
            String next = itC.next();
            String strB = fVar.b(next);
            sb.append(next);
            sb.append(": ");
            sb.append(strB);
            sb.append("\r\n");
        }
        sb.append("\r\n");
        byte[] bArrB = com.alipay.android.phone.mobilesdk.socketcraft.g.b.b(sb.toString());
        byte[] bArrD = z ? fVar.d() : null;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((bArrD == null ? 0 : bArrD.length) + bArrB.length);
        byteBufferAllocate.put(bArrB);
        if (bArrD != null) {
            byteBufferAllocate.put(bArrD);
        }
        byteBufferAllocate.flip();
        return Collections.singletonList(byteBufferAllocate);
    }

    public int a(int i) throws InvalidDataException {
        if (i >= 0) {
            return i;
        }
        throw new InvalidDataException(1002, "Negative count");
    }

    public void a(WebSocket.Role role) {
        this.d = role;
    }
}
