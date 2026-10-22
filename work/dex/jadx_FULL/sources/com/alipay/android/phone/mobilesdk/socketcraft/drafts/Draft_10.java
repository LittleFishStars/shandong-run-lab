package com.alipay.android.phone.mobilesdk.socketcraft.drafts;

import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alipay.android.phone.mobilesdk.socketcraft.WebSocket;
import com.alipay.android.phone.mobilesdk.socketcraft.c.f;
import com.alipay.android.phone.mobilesdk.socketcraft.c.h;
import com.alipay.android.phone.mobilesdk.socketcraft.c.i;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidDataException;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidFrameException;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidHandshakeException;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.LimitExedeedException;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.NotSendableException;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.d;
import com.alipay.android.phone.mobilesdk.socketcraft.g.e;
import com.google.common.primitives.UnsignedBytes;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Draft_10 extends Draft {
    static final /* synthetic */ boolean f = true;
    private ByteBuffer g;
    private final Random h = new Random();

    public class IncompleteException extends Throwable {
        private static final long serialVersionUID = 7330519489840500997L;
        private int preferedsize;

        public IncompleteException(int i) {
            this.preferedsize = i;
        }

        public int getPreferedSize() {
            return this.preferedsize;
        }
    }

    public static int b(f fVar) {
        String strB = fVar.b(com.google.common.net.b.R1);
        if (strB.length() > 0) {
            try {
                return new Integer(strB.trim()).intValue();
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public Draft.HandshakeState a(com.alipay.android.phone.mobilesdk.socketcraft.c.a aVar, h hVar) {
        if (aVar.c(com.google.common.net.b.P1) && hVar.c(com.google.common.net.b.N1)) {
            return a(aVar.b(com.google.common.net.b.P1)).equals(hVar.b(com.google.common.net.b.N1)) ? Draft.HandshakeState.MATCHED : Draft.HandshakeState.NOT_MATCHED;
        }
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public List<Framedata> c(ByteBuffer byteBuffer) {
        LinkedList linkedList = new LinkedList();
        if (this.g != null) {
            try {
                byteBuffer.mark();
                int iRemaining = byteBuffer.remaining();
                int iRemaining2 = this.g.remaining();
                if (iRemaining2 > iRemaining) {
                    this.g.put(byteBuffer.array(), byteBuffer.position(), iRemaining);
                    byteBuffer.position(byteBuffer.position() + iRemaining);
                    return Collections.emptyList();
                }
                this.g.put(byteBuffer.array(), byteBuffer.position(), iRemaining2);
                byteBuffer.position(byteBuffer.position() + iRemaining2);
                linkedList.add(e((ByteBuffer) this.g.duplicate().position(0)));
                this.g = null;
            } catch (IncompleteException e) {
                this.g.limit();
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(a(e.getPreferedSize()));
                if (!f && byteBufferAllocate.limit() <= this.g.limit()) {
                    throw new AssertionError();
                }
                this.g.rewind();
                byteBufferAllocate.put(this.g);
                this.g = byteBufferAllocate;
                return c(byteBuffer);
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(e(byteBuffer));
            } catch (IncompleteException e2) {
                byteBuffer.reset();
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(a(e2.getPreferedSize()));
                this.g = byteBufferAllocate2;
                byteBufferAllocate2.put(byteBuffer);
            }
        }
        return linkedList;
    }

    public Framedata e(ByteBuffer byteBuffer) throws InvalidFrameException, LimitExedeedException, IncompleteException {
        com.alipay.android.phone.mobilesdk.socketcraft.framing.c dVar;
        int iRemaining = byteBuffer.remaining();
        int i = 2;
        if (iRemaining < 2) {
            throw new IncompleteException(2);
        }
        byte b = byteBuffer.get();
        boolean z = (b >> 8) != 0;
        byte b2 = (byte) ((b & 127) >> 4);
        if (b2 != 0) {
            throw new InvalidFrameException("bad rsv " + ((int) b2));
        }
        byte b3 = byteBuffer.get();
        boolean z2 = (b3 & UnsignedBytes.f32243a) != 0;
        int iIntValue = (byte) (b3 & 127);
        Framedata.Opcode opcodeA = a((byte) (b & com.google.common.base.a.q));
        if (!z && (opcodeA == Framedata.Opcode.PING || opcodeA == Framedata.Opcode.PONG || opcodeA == Framedata.Opcode.CLOSING)) {
            throw new InvalidFrameException("control frames may no be fragmented");
        }
        if (iIntValue < 0 || iIntValue > 125) {
            if (opcodeA == Framedata.Opcode.PING || opcodeA == Framedata.Opcode.PONG || opcodeA == Framedata.Opcode.CLOSING) {
                throw new InvalidFrameException("more than 125 octets");
            }
            if (iIntValue != 126) {
                i = 10;
                if (iRemaining < 10) {
                    throw new IncompleteException(10);
                }
                byte[] bArr = new byte[8];
                for (int i2 = 0; i2 < 8; i2++) {
                    bArr[i2] = byteBuffer.get();
                }
                long jLongValue = new BigInteger(bArr).longValue();
                if (jLongValue > 2147483647L) {
                    throw new LimitExedeedException(e.f25312a);
                }
                iIntValue = (int) jLongValue;
            } else {
                if (iRemaining < 4) {
                    throw new IncompleteException(4);
                }
                iIntValue = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
                i = 4;
            }
        }
        int i3 = i + (z2 ? 4 : 0) + iIntValue;
        if (iRemaining < i3) {
            throw new IncompleteException(i3);
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(a(iIntValue));
        if (z2) {
            byte[] bArr2 = new byte[4];
            byteBuffer.get(bArr2);
            for (int i4 = 0; i4 < iIntValue; i4++) {
                byteBufferAllocate.put((byte) (byteBuffer.get() ^ bArr2[i4 % 4]));
            }
        } else {
            byteBufferAllocate.put(byteBuffer.array(), byteBuffer.position(), byteBufferAllocate.limit());
            byteBuffer.position(byteBuffer.position() + byteBufferAllocate.limit());
        }
        if (opcodeA == Framedata.Opcode.CLOSING) {
            dVar = new com.alipay.android.phone.mobilesdk.socketcraft.framing.b();
        } else {
            dVar = new d();
            dVar.a(z);
            dVar.a(opcodeA);
        }
        byteBufferAllocate.flip();
        dVar.a(byteBufferAllocate);
        return dVar;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public Draft.CloseHandshakeType b() {
        return Draft.CloseHandshakeType.TWOWAY;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public Draft.HandshakeState a(com.alipay.android.phone.mobilesdk.socketcraft.c.a aVar) {
        int iB = b(aVar);
        if (iB == 7 || iB == 8) {
            return a((f) aVar) ? Draft.HandshakeState.MATCHED : Draft.HandshakeState.NOT_MATCHED;
        }
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public ByteBuffer a(Framedata framedata) {
        int i;
        ByteBuffer byteBufferC = framedata.c();
        int i2 = 0;
        boolean z = this.d == WebSocket.Role.CLIENT;
        if (byteBufferC.remaining() <= 125) {
            i = 1;
        } else {
            i = byteBufferC.remaining() <= 65535 ? 2 : 8;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((i > 1 ? i + 1 : i) + 1 + (z ? 4 : 0) + byteBufferC.remaining());
        byte bA = a(framedata.f());
        boolean zD = framedata.d();
        byte b = UnsignedBytes.f32243a;
        byteBufferAllocate.put((byte) (((byte) (zD ? -128 : 0)) | bA));
        byte[] bArrA = a(byteBufferC.remaining(), i);
        if (!f && bArrA.length != i) {
            throw new AssertionError();
        }
        if (i == 1) {
            byte b2 = bArrA[0];
            if (!z) {
                b = 0;
            }
            byteBufferAllocate.put((byte) (b2 | b));
        } else if (i == 2) {
            if (!z) {
                b = 0;
            }
            byteBufferAllocate.put((byte) (b | 126));
            byteBufferAllocate.put(bArrA);
        } else if (i == 8) {
            if (!z) {
                b = 0;
            }
            byteBufferAllocate.put((byte) (b | 127));
            byteBufferAllocate.put(bArrA);
        } else {
            throw new RuntimeException("Size representation not supported/specified");
        }
        if (z) {
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(4);
            byteBufferAllocate2.putInt(this.h.nextInt());
            byteBufferAllocate.put(byteBufferAllocate2.array());
            while (byteBufferC.hasRemaining()) {
                byteBufferAllocate.put((byte) (byteBufferC.get() ^ byteBufferAllocate2.get(i2 % 4)));
                i2++;
            }
        } else {
            byteBufferAllocate.put(byteBufferC);
        }
        if (!f && byteBufferAllocate.remaining() != 0) {
            throw new AssertionError(byteBufferAllocate.remaining());
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public Draft c() {
        return new Draft_10();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public List<Framedata> a(ByteBuffer byteBuffer, boolean z) {
        d dVar = new d();
        try {
            dVar.a(byteBuffer);
            dVar.a(true);
            dVar.a(Framedata.Opcode.BINARY);
            dVar.b(z);
            return Collections.singletonList(dVar);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
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

    private byte a(Framedata.Opcode opcode) {
        if (opcode == Framedata.Opcode.CONTINUOUS) {
            return (byte) 0;
        }
        if (opcode == Framedata.Opcode.TEXT) {
            return (byte) 1;
        }
        if (opcode == Framedata.Opcode.BINARY) {
            return (byte) 2;
        }
        if (opcode == Framedata.Opcode.CLOSING) {
            return (byte) 8;
        }
        if (opcode == Framedata.Opcode.PING) {
            return (byte) 9;
        }
        if (opcode == Framedata.Opcode.PONG) {
            return (byte) 10;
        }
        throw new RuntimeException("Don't know how to handle " + opcode.toString());
    }

    private String a(String str) {
        try {
            return com.alipay.android.phone.mobilesdk.socketcraft.g.a.a(MessageDigest.getInstance("SHA1").digest((str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public com.alipay.android.phone.mobilesdk.socketcraft.c.b a(com.alipay.android.phone.mobilesdk.socketcraft.c.b bVar) {
        bVar.a(com.google.common.net.b.N, "websocket");
        bVar.a("Connection", com.google.common.net.b.N);
        bVar.a(com.google.common.net.b.R1, PrepareException.ERROR_AUTH_FAIL);
        byte[] bArr = new byte[16];
        this.h.nextBytes(bArr);
        bVar.a(com.google.common.net.b.P1, com.alipay.android.phone.mobilesdk.socketcraft.g.a.a(bArr));
        return bVar;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public com.alipay.android.phone.mobilesdk.socketcraft.c.c a(com.alipay.android.phone.mobilesdk.socketcraft.c.a aVar, i iVar) throws InvalidHandshakeException {
        iVar.a(com.google.common.net.b.N, "websocket");
        iVar.a("Connection", aVar.b("Connection"));
        iVar.a("Switching Protocols");
        String strB = aVar.b(com.google.common.net.b.P1);
        if (strB != null) {
            iVar.a(com.google.common.net.b.N1, a(strB));
            return iVar;
        }
        throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
    }

    private byte[] a(long j, int i) {
        byte[] bArr = new byte[i];
        int i2 = (i * 8) - 8;
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) (j >>> (i2 - (i3 * 8)));
        }
        return bArr;
    }

    private Framedata.Opcode a(byte b) throws InvalidFrameException {
        if (b == 0) {
            return Framedata.Opcode.CONTINUOUS;
        }
        if (b == 1) {
            return Framedata.Opcode.TEXT;
        }
        if (b != 2) {
            switch (b) {
                case 8:
                    return Framedata.Opcode.CLOSING;
                case 9:
                    return Framedata.Opcode.PING;
                case 10:
                    return Framedata.Opcode.PONG;
                default:
                    throw new InvalidFrameException("unknow optcode " + ((int) b));
            }
        }
        return Framedata.Opcode.BINARY;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public void a() {
        this.g = null;
    }
}
