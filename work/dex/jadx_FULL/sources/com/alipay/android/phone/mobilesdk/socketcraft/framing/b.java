package com.alipay.android.phone.mobilesdk.socketcraft.framing;

import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidDataException;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidFrameException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends d implements a {
    static final ByteBuffer p = ByteBuffer.allocate(0);
    private int q;
    private String r;

    public b() {
        super(Framedata.Opcode.CLOSING);
        a(true);
    }

    private void a(int i, String str) throws InvalidDataException {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        if (i == 1015) {
            i = 1005;
        } else {
            str2 = str;
        }
        if (i == 1005) {
            if (str2.length() > 0) {
                throw new InvalidDataException(1002, "A close frame must have a closecode if it has a reason");
            }
            return;
        }
        byte[] bArrA = com.alipay.android.phone.mobilesdk.socketcraft.g.b.a(str2);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.putInt(i);
        byteBufferAllocate.position(2);
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(bArrA.length + 2);
        byteBufferAllocate2.put(byteBufferAllocate);
        byteBufferAllocate2.put(bArrA);
        byteBufferAllocate2.rewind();
        a(byteBufferAllocate2);
    }

    private void g() throws InvalidFrameException {
        this.q = 1005;
        ByteBuffer byteBufferC = super.c();
        byteBufferC.mark();
        if (byteBufferC.remaining() >= 2) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            byteBufferAllocate.position(2);
            byteBufferAllocate.putShort(byteBufferC.getShort());
            byteBufferAllocate.position(0);
            int i = byteBufferAllocate.getInt();
            this.q = i;
            if (i == 1006 || i == 1015 || i == 1005 || i > 4999 || i < 1000 || i == 1004) {
                throw new InvalidFrameException("closecode must not be sent over the wire: " + this.q);
            }
        }
        byteBufferC.reset();
    }

    private void h() {
        if (this.q == 1005) {
            this.r = com.alipay.android.phone.mobilesdk.socketcraft.g.b.a(super.c());
            return;
        }
        ByteBuffer byteBufferC = super.c();
        int iPosition = byteBufferC.position();
        try {
            try {
                byteBufferC.position(byteBufferC.position() + 2);
                this.r = com.alipay.android.phone.mobilesdk.socketcraft.g.b.a(byteBufferC);
                byteBufferC.position(iPosition);
            } catch (IllegalArgumentException e) {
                throw new InvalidFrameException(e);
            }
        } catch (Throwable th) {
            byteBufferC.position(iPosition);
            throw th;
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.a
    public String b() {
        return this.r;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.d, com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata
    public ByteBuffer c() {
        return this.q == 1005 ? p : super.c();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.d
    public String toString() {
        return super.toString() + "code: " + this.q;
    }

    public b(int i) throws InvalidDataException {
        super(Framedata.Opcode.CLOSING);
        a(true);
        a(i, "");
    }

    public b(int i, String str) throws InvalidDataException {
        super(Framedata.Opcode.CLOSING);
        a(true);
        a(i, str);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.a
    public int a() {
        return this.q;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.d, com.alipay.android.phone.mobilesdk.socketcraft.framing.c
    public void a(ByteBuffer byteBuffer) throws InvalidFrameException {
        super.a(byteBuffer);
        g();
        h();
    }
}
