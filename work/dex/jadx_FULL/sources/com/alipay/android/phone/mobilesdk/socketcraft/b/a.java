package com.alipay.android.phone.mobilesdk.socketcraft.b;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class a extends com.alipay.android.phone.mobilesdk.socketcraft.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final ByteBuffer f25287a;

    public a(ByteChannel byteChannel) {
        super(byteChannel);
        try {
            this.f25287a = ByteBuffer.wrap(e().getBytes("ASCII"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract String e();

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.a, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        return !this.f25287a.hasRemaining() ? super.write(byteBuffer) : super.write(this.f25287a);
    }
}
