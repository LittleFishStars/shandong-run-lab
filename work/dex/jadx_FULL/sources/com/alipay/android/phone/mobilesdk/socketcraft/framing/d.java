package com.alipay.android.phone.mobilesdk.socketcraft.framing;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d implements c {
    protected static byte[] a_ = new byte[0];
    protected boolean b_;
    protected Framedata.Opcode c_;
    protected boolean d_;
    private ByteBuffer e;

    public d() {
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.c
    public void a(boolean z) {
        this.b_ = z;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.c
    public void b(boolean z) {
        this.d_ = z;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata
    public ByteBuffer c() {
        return this.e;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata
    public boolean d() {
        return this.b_;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata
    public boolean e() {
        return this.d_;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata
    public Framedata.Opcode f() {
        return this.c_;
    }

    public String toString() {
        return "Framedata{ optcode:" + f() + ", fin:" + d() + ", payloadlength:[pos:" + this.e.position() + ", len:" + this.e.remaining() + "], payload:" + Arrays.toString(com.alipay.android.phone.mobilesdk.socketcraft.g.b.a(new String(this.e.array()))) + "}";
    }

    public d(Framedata.Opcode opcode) {
        this.c_ = opcode;
        this.e = ByteBuffer.wrap(a_);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.c
    public void a(Framedata.Opcode opcode) {
        this.c_ = opcode;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.c
    public void a(ByteBuffer byteBuffer) {
        this.e = byteBuffer;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata
    public void a(Framedata framedata) {
        ByteBuffer byteBufferC = framedata.c();
        if (this.e == null) {
            this.e = ByteBuffer.allocate(byteBufferC.remaining());
            byteBufferC.mark();
            this.e.put(byteBufferC);
            byteBufferC.reset();
        } else {
            byteBufferC.mark();
            ByteBuffer byteBuffer = this.e;
            byteBuffer.position(byteBuffer.limit());
            ByteBuffer byteBuffer2 = this.e;
            byteBuffer2.limit(byteBuffer2.capacity());
            if (byteBufferC.remaining() > this.e.remaining()) {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBufferC.remaining() + this.e.capacity());
                this.e.flip();
                byteBufferAllocate.put(this.e);
                byteBufferAllocate.put(byteBufferC);
                this.e = byteBufferAllocate;
            } else {
                this.e.put(byteBufferC);
            }
            this.e.rewind();
            byteBufferC.reset();
        }
        this.b_ = framedata.d();
    }

    public d(Framedata framedata) {
        this.b_ = framedata.d();
        this.c_ = framedata.f();
        this.e = framedata.c();
        this.d_ = framedata.e();
    }
}
